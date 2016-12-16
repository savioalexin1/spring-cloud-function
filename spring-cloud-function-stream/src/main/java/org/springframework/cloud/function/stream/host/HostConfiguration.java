/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.stream.host;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.function.registry.FileSystemFunctionRegistry;
import org.springframework.cloud.function.registry.FunctionRegistry;
import org.springframework.cloud.function.stream.processor.FunctionConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

/**
 * @author Mark Fisher
 */
@EnableBinding
@EnableConfigurationProperties(FunctionConfigurationProperties.class)
public class HostConfiguration {

	@Bean
	public FunctionRegistry registry() {
		return new FileSystemFunctionRegistry();
	}

	@Bean
	@RefreshScope
	public ProcessorInitializer processorInitializer() {
		return new ProcessorInitializer();
	}
}
