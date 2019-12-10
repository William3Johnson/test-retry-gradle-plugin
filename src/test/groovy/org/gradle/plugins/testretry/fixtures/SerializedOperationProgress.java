/*
 * Copyright 2019 the original author or authors.
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
package org.gradle.plugins.testretry.fixtures;

import com.google.common.collect.ImmutableMap;

import java.util.Map;


class SerializedOperationProgress implements SerializedOperation {

    final long id;
    final long time;
    final Object details;
    final String detailsClassName;

    SerializedOperationProgress(Map<String, ?> map) {
        this.id = ((Integer) map.get("id")).longValue();
        this.time = (Long) map.get("time");
        this.details = map.get("details");
        this.detailsClassName = (String) map.get("detailsClassName");
    }

    @Override
    public Map<String, ?> toMap() {
        ImmutableMap.Builder<String, Object> map = ImmutableMap.builder();

        // Order is optimised for humans looking at the log.

        if (details != null) {
            map.put("details", details);
            map.put("detailsClassName", detailsClassName);
        }

        map.put("id", id);
        map.put("time", time);

        return map.build();
    }

}
