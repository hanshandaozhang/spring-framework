/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.messaging.simp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

/**
 * Unit tests for
 * {@link org.springframework.messaging.simp.SimpAttributesContextHolder}.
 *
 * @author Rossen Stoyanchev
 * @since 4.1
 */
public class SimpAttributesContextHolderTests {

	private SimpAttributes simpAttributes;


	@Before
	public void setUp() {
		Map<String, Object> map = new ConcurrentHashMap<>();
		this.simpAttributes = new SimpAttributes("session1", map);
	}

	@After
	public void tearDown() {
		SimpAttributesContextHolder.resetAttributes();
	}


	@Test
	public void resetAttributes() {
		SimpAttributesContextHolder.setAttributes(this.simpAttributes);
		assertThat(SimpAttributesContextHolder.getAttributes(), sameInstance(this.simpAttributes));

		SimpAttributesContextHolder.resetAttributes();
		assertThat(SimpAttributesContextHolder.getAttributes(), nullValue());
	}

	@Test
	public void getAttributes() {
		assertThat(SimpAttributesContextHolder.getAttributes(), nullValue());

		SimpAttributesContextHolder.setAttributes(this.simpAttributes);
		assertThat(SimpAttributesContextHolder.getAttributes(), sameInstance(this.simpAttributes));
	}

	@Test
	public void setAttributes() {
		SimpAttributesContextHolder.setAttributes(this.simpAttributes);
		assertThat(SimpAttributesContextHolder.getAttributes(), sameInstance(this.simpAttributes));

		SimpAttributesContextHolder.setAttributes(null);
		assertThat(SimpAttributesContextHolder.getAttributes(), nullValue());
	}

	@Test
	public void setAttributesFromMessage() {

		String sessionId = "session1";
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

		SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create();
		headerAccessor.setSessionId(sessionId);
		headerAccessor.setSessionAttributes(map);
		Message<?> message = MessageBuilder.createMessage("", headerAccessor.getMessageHeaders());

		SimpAttributesContextHolder.setAttributesFromMessage(message);

		SimpAttributes attrs = SimpAttributesContextHolder.getAttributes();
		assertThat(attrs, notNullValue());
		assertThat(attrs.getSessionId(), is(sessionId));

		attrs.setAttribute("name1", "value1");
		assertThat(map.get("name1"), is("value1"));
	}

	@Test
	public void setAttributesFromMessageWithMissingSessionId() {
		assertThatIllegalStateException().isThrownBy(() ->
				SimpAttributesContextHolder.setAttributesFromMessage(new GenericMessage<Object>("")))
			.withMessageStartingWith("No session id in");
	}

	@Test
	public void setAttributesFromMessageWithMissingSessionAttributes() {
		SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create();
		headerAccessor.setSessionId("session1");
		Message<?> message = MessageBuilder.createMessage("", headerAccessor.getMessageHeaders());
		assertThatIllegalStateException().isThrownBy(() ->
				SimpAttributesContextHolder.setAttributesFromMessage(message))
			.withMessageStartingWith("No session attributes in");
	}

	@Test
	public void currentAttributes() {
		SimpAttributesContextHolder.setAttributes(this.simpAttributes);
		assertThat(SimpAttributesContextHolder.currentAttributes(), sameInstance(this.simpAttributes));
	}

	@Test
	public void currentAttributesNone() {
		assertThatIllegalStateException().isThrownBy(() ->
				SimpAttributesContextHolder.currentAttributes())
			.withMessageStartingWith("No thread-bound SimpAttributes found");
	}

}
