package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class MapSerializer extends Serializer<Map> {
    private Class keyClass;
    private Class keyGenericType;
    private Serializer keySerializer;
    private Class valueClass;
    private Class valueGenericType;
    private Serializer valueSerializer;
    private boolean keysCanBeNull = true;
    private boolean valuesCanBeNull = true;

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Map copy(Kryo kryo, Map map) {
        return copy2(kryo, map);
    }

    public Map create(Kryo kryo, Input input, Class<Map> cls) {
        return (Map) kryo.newInstance(cls);
    }

    public Map createCopy(Kryo kryo, Map map) {
        return (Map) kryo.newInstance(map.getClass());
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Map read(Kryo kryo, Input input, Class<Map> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void setGenerics(Kryo kryo, Class[] clsArr) {
        this.keyGenericType = null;
        this.valueGenericType = null;
        if (clsArr == null || clsArr.length <= 0) {
            return;
        }
        if (clsArr[0] != null && kryo.isFinal(clsArr[0])) {
            this.keyGenericType = clsArr[0];
        }
        if (clsArr.length <= 1 || clsArr[1] == null || !kryo.isFinal(clsArr[1])) {
            return;
        }
        this.valueGenericType = clsArr[1];
    }

    public void setKeyClass(Class cls, Serializer serializer) {
        this.keyClass = cls;
        this.keySerializer = serializer;
    }

    public void setKeysCanBeNull(boolean z2) {
        this.keysCanBeNull = z2;
    }

    public void setValueClass(Class cls, Serializer serializer) {
        this.valueClass = cls;
        this.valueSerializer = serializer;
    }

    public void setValuesCanBeNull(boolean z2) {
        this.valuesCanBeNull = z2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Map map) {
        write(kryo, output, map);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Map copy2(Kryo kryo, Map map) {
        Map mapCreateCopy = createCopy(kryo, map);
        for (Map$Entry map$Entry : map.entrySet()) {
            mapCreateCopy.put(kryo.copy(map$Entry.getKey()), kryo.copy(map$Entry.getValue()));
        }
        return mapCreateCopy;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Map read2(Kryo kryo, Input input, Class<Map> cls) {
        Map mapCreate = create(kryo, input, cls);
        int i = input.readInt(true);
        Class cls2 = this.keyClass;
        Class cls3 = this.valueClass;
        Serializer serializer = this.keySerializer;
        Class cls4 = this.keyGenericType;
        if (cls4 != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(cls4);
            }
            this.keyGenericType = null;
            cls2 = cls4;
        }
        Serializer serializer2 = this.valueSerializer;
        Class cls5 = this.valueGenericType;
        if (cls5 != null) {
            if (serializer2 == null) {
                serializer2 = kryo.getSerializer(cls5);
            }
            this.valueGenericType = null;
            cls3 = cls5;
        }
        kryo.reference(mapCreate);
        for (int i2 = 0; i2 < i; i2++) {
            mapCreate.put(serializer != null ? this.keysCanBeNull ? kryo.readObjectOrNull(input, cls2, serializer) : kryo.readObject(input, cls2, serializer) : kryo.readClassAndObject(input), serializer2 != null ? this.valuesCanBeNull ? kryo.readObjectOrNull(input, cls3, serializer2) : kryo.readObject(input, cls3, serializer2) : kryo.readClassAndObject(input));
        }
        return mapCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void write(Kryo kryo, Output output, Map map) {
        output.writeInt(map.size(), true);
        Serializer serializer = this.keySerializer;
        Class cls = this.keyGenericType;
        if (cls != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(cls);
            }
            this.keyGenericType = null;
        }
        Serializer serializer2 = this.valueSerializer;
        Class cls2 = this.valueGenericType;
        if (cls2 != null) {
            if (serializer2 == null) {
                serializer2 = kryo.getSerializer(cls2);
            }
            this.valueGenericType = null;
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            if (serializer == null) {
                kryo.writeClassAndObject(output, map$Entry.getKey());
            } else if (this.keysCanBeNull) {
                kryo.writeObjectOrNull(output, map$Entry.getKey(), serializer);
            } else {
                kryo.writeObject(output, map$Entry.getKey(), serializer);
            }
            if (serializer2 == null) {
                kryo.writeClassAndObject(output, map$Entry.getValue());
            } else if (this.valuesCanBeNull) {
                kryo.writeObjectOrNull(output, map$Entry.getValue(), serializer2);
            } else {
                kryo.writeObject(output, map$Entry.getValue(), serializer2);
            }
        }
    }
}
