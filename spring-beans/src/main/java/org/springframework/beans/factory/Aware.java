/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.beans.factory;

/**
 * <p>
 *     Aware 接口为 Spring 容器的核心接口，是一个具有标识作用的超级接口，
 *     实现了该接口的 bean 是具有被 Spring 容器通知的能力，通知的方式是采用回调的方式。
 *
 * 	   Aware 接口是一个空接口，实际的方法签名由各个子接口来确定，且该接口通常只会有一个
 * 	   接收单参数的 set 方法，该 set 方法的命名方式为 set + 去掉接口名中的 Aware 后缀，
 * 	   即 XxxAware 接口，则方法定义为 setXxx()，例如 BeanNameAware（setBeanName），
 * 	   ApplicationContextAware（setApplicationContext）。
 *
 *     Aware 的子接口需要提供一个 setXxx 方法，我们知道 set 是设置属性值的方法，即
 *     Aware 类接口的 setXxx 方法其实就是设置 xxx 属性值的。 Aware 的含义是感知的、
 *     感应的，那么在 Spring 容器中是如何实现感知并设置属性值得呢？我们可以从初始化
 *     bean 中的激活 Aware 的方法 #invokeAwareMethods(final String beanName,
 *     final Object bean) 中看到一点点
 * </p>
 * A marker superinterface indicating that a bean is eligible to be notified by the
 * Spring container of a particular framework object through a callback-style method.
 * The actual method signature is determined by individual subinterfaces but should
 * typically consist of just one void-returning method that accepts a single argument.
 *
 * <p>Note that merely implementing {@link Aware} provides no default functionality.
 * Rather, processing must be done explicitly, for example in a
 * {@link org.springframework.beans.factory.config.BeanPostProcessor}.
 * Refer to {@link org.springframework.context.support.ApplicationContextAwareProcessor}
 * for an example of processing specific {@code *Aware} interface callbacks.
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.1
 */
public interface Aware {

}
