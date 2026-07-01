package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$TreeMapSerializer extends MapSerializer {
    private TreeMap createTreeMap(Class<? extends Map> cls, Comparator comparator) {
        if (cls == TreeMap.class || cls == null) {
            return new TreeMap(comparator);
        }
        try {
            Constructor<? extends Map> constructor = cls.getConstructor(Comparator.class);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException unused) {
                }
            }
            return (TreeMap) constructor.newInstance(comparator);
        } catch (Exception e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.MapSerializer
    public Map create(Kryo kryo, Input input, Class<Map> cls) {
        return createTreeMap(cls, (Comparator) kryo.readClassAndObject(input));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.esotericsoftware.kryo.serializers.MapSerializer
    public Map createCopy(Kryo kryo, Map map) {
        return createTreeMap(map.getClass(), ((TreeMap) map).comparator());
    }

    @Override // com.esotericsoftware.kryo.serializers.MapSerializer, com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Map map) {
        write2(kryo, output, map);
    }

    @Override // com.esotericsoftware.kryo.serializers.MapSerializer
    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Map map) {
        kryo.writeClassAndObject(output, ((TreeMap) map).comparator());
        super.write(kryo, output, map);
    }
}
