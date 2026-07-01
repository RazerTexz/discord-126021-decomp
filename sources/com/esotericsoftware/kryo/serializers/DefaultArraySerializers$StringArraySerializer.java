package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$StringArraySerializer extends Serializer<String[]> {
    public DefaultArraySerializers$StringArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ String[] copy(Kryo kryo, String[] strArr) {
        return copy2(kryo, strArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ String[] read(Kryo kryo, Input input, Class<String[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, String[] strArr) {
        write2(kryo, output, strArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public String[] copy2(Kryo kryo, String[] strArr) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public String[] read2(Kryo kryo, Input input, Class<String[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        int i = varInt - 1;
        String[] strArr = new String[i];
        int i2 = 0;
        if (kryo.getReferences() && kryo.getReferenceResolver().useReferences(String.class)) {
            Serializer serializer = kryo.getSerializer(String.class);
            while (i2 < i) {
                strArr[i2] = (String) kryo.readObjectOrNull(input, String.class, serializer);
                i2++;
            }
        } else {
            while (i2 < i) {
                strArr[i2] = input.readString();
                i2++;
            }
        }
        return strArr;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, String[] strArr) {
        int i = 0;
        if (strArr == null) {
            output.writeVarInt(0, true);
            return;
        }
        output.writeVarInt(strArr.length + 1, true);
        if (!kryo.getReferences() || !kryo.getReferenceResolver().useReferences(String.class)) {
            int length = strArr.length;
            while (i < length) {
                output.writeString(strArr[i]);
                i++;
            }
            return;
        }
        Serializer serializer = kryo.getSerializer(String.class);
        int length2 = strArr.length;
        while (i < length2) {
            kryo.writeObjectOrNull(output, strArr[i], serializer);
            i++;
        }
    }
}
