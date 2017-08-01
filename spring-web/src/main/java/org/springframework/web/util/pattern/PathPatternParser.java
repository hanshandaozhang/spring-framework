/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.util.pattern;

/**
 * Parser for URI path patterns producing {@link PathPattern} instances that can
 * then be matched to requests.
 *
 * <p>The {@link PathPatternParser} and {@link PathPattern} are specifically
 * designed for use with HTTP URL paths in web applications where a large number
 * of URI path patterns continuously matched against incoming requests motivates
 * the need for pre-parsing and fast matching.
 *
 * <p>For details of the path pattern syntax see {@link PathPattern}.
 *
 * @author Andy Clement
 * @since 5.0
 */
public class PathPatternParser {

	public final static char DEFAULT_SEPARATOR = '/';


	private char separator = DEFAULT_SEPARATOR;

	private boolean matchOptionalTrailingSlash = true;

	private boolean caseSensitive = true;


	/**
	 * Create a path pattern parser that will use the default separator '/'
	 * when parsing patterns.
	 * @see #DEFAULT_SEPARATOR
	 */
	public PathPatternParser() {
	}

	/**
	 * Create a path pattern parser that will use the supplied separator when
	 * parsing patterns.
	 * @param separator the separator expected to divide pattern elements
	 */
	public PathPatternParser(char separator) {
		this.separator = separator;
	}


	/**
	 * Whether a {@link PathPattern} produced by this parser should should
	 * automatically match request paths with a trailing slash.
	 *
	 * <p>If set to {@code true} a {@code PathPattern} without a trailing slash
	 * will also match request paths with a trailing slash. If set to
	 * {@code false} a {@code PathPattern} will only match request paths with
	 * a trailing slash.
	 *
	 * <p>The default is {@code true}.
	 */
	public void setMatchOptionalTrailingSlash(boolean matchOptionalTrailingSlash) {
		this.matchOptionalTrailingSlash = matchOptionalTrailingSlash;
	}

	/**
	 * Whether path pattern matching should be case-sensitive.
	 * <p>The default is {@code true}.
	 */
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}


	/**
	 * Process the path pattern data, a character at a time, breaking it into
	 * path elements around separator boundaries and verifying the structure at each
	 * stage. Produces a PathPattern object that can be used for fast matching
	 * against paths. Each invocation of this method delegates to a new instance of
	 * the {@link InternalPathPatternParser} because that class is not thread-safe.
	 * @param pathPattern the input path pattern, e.g. /foo/{bar}
	 * @return a PathPattern for quickly matching paths against request paths
	 * @throws PatternParseException in case of parse errors
	 */
	public PathPattern parse(String pathPattern) throws PatternParseException {
		return createDelegate().parse(pathPattern);
	}

	private InternalPathPatternParser createDelegate() {
		return new InternalPathPatternParser(
				this.separator, this.caseSensitive, this.matchOptionalTrailingSlash);
	}

}
