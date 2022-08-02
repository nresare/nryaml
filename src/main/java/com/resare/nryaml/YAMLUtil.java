/*
 * Copyright 2022 Noa Resare
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.resare.nryaml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YAMLUtil {
    private static DumperOptions OPTIONS = new DumperOptions();
    static {
        OPTIONS.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    }
    private static ThreadLocal<Yaml> parser = ThreadLocal.withInitial(() -> new Yaml(OPTIONS));

    public static YAMLValue fromInputStream(InputStream inputStream) {
        return new YAMLValueImpl(parser.get().load(inputStream));
    }

    public static YAMLValue fromBare(Object bare) {
        return new YAMLValueImpl(bare);
    }

    public static String toString(YAMLValue value) {
        return parser.get().dump(value.toBareObject());
    }

    public static YAMLValue fromString(String input) {
        return new YAMLValueImpl(parser.get().load(input));
    }
}
