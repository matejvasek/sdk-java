/*
 * Copyright 2018-Present The CloudEvents Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.cloudevents.v1;

import io.cloudevents.CloudEvent;
import io.cloudevents.SpecVersion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author fabiojose
 */
public class CloudEventBuilderTest {

    @ParameterizedTest()
    @MethodSource("io.cloudevents.test.Data#v1Events")
    void testCopyWithBuilder(CloudEvent event) {
        assertThat(CloudEvent.buildV1(event).build()).isEqualTo(event);
    }

    @ParameterizedTest()
    @MethodSource("io.cloudevents.test.Data#v1Events")
    void testToV03(CloudEvent event) {
        CloudEvent eventV03 = CloudEvent.buildV03(event).build();

        assertThat(eventV03.getAttributes().getSpecVersion())
            .isEqualTo(SpecVersion.V03);

        assertThat(eventV03).isEqualTo(event.toV03());
    }

}
