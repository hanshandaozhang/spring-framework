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

package org.springframework.aop.aspectj;

import org.junit.Test;

import org.springframework.aop.support.AopUtils;

import static org.junit.Assert.assertTrue;

/**
 * @author Juergen Hoeller
 * @author Chris Beams
 */
public class AroundAdviceCircularTests extends AroundAdviceBindingTests {

	@Test
	public void testBothBeansAreProxies() {
		Object tb = ctx.getBean("testBean");
		assertTrue(AopUtils.isAopProxy(tb));
		Object tb2 = ctx.getBean("testBean2");
		assertTrue(AopUtils.isAopProxy(tb2));
	}

}
