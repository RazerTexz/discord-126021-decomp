package org.objectweb.asm.commons;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/SimpleRemapper.SCL.lombok */
public class SimpleRemapper extends Remapper {
    private final Map<String, String> mapping;

    public SimpleRemapper(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    public SimpleRemapper(String oldName, String newName) {
        this.mapping = Collections.singletonMap(oldName, newName);
    }

    @Override // org.objectweb.asm.commons.Remapper
    public String mapMethodName(String owner, String name, String descriptor) {
        String remappedName = map(owner + '.' + name + descriptor);
        return remappedName == null ? name : remappedName;
    }

    @Override // org.objectweb.asm.commons.Remapper
    public String mapInvokeDynamicMethodName(String name, String descriptor) {
        String remappedName = map('.' + name + descriptor);
        return remappedName == null ? name : remappedName;
    }

    @Override // org.objectweb.asm.commons.Remapper
    public String mapFieldName(String owner, String name, String descriptor) {
        String remappedName = map(owner + '.' + name);
        return remappedName == null ? name : remappedName;
    }

    @Override // org.objectweb.asm.commons.Remapper
    public String map(String key) {
        return this.mapping.get(key);
    }
}
