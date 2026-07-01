package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$EnumSerializer extends Serializer<Enum> {
    private Object[] enumConstants;

    public DefaultSerializers$EnumSerializer(Class<? extends Enum> cls) {
        setImmutable(true);
        setAcceptsNull(true);
        Object[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        if (enumConstants != null || Enum.class.equals(cls)) {
            return;
        }
        throw new IllegalArgumentException("The type must be an enum: " + cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Enum read(Kryo kryo, Input input, Class<Enum> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Enum r3) {
        write2(kryo, output, r3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public Enum read(Kryo kryo, Input input, Class<Enum> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        int i = varInt - 1;
        if (i >= 0) {
            Object[] objArr = this.enumConstants;
            if (i <= objArr.length - 1) {
                return (Enum) objArr[i];
            }
        }
        StringBuilder sbU = a.U("Invalid ordinal for enum \"");
        sbU.append(cls.getName());
        sbU.append("\": ");
        sbU.append(i);
        throw new KryoException(sbU.toString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Enum r3) {
        if (r3 == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(r3.ordinal() + 1, true);
        }
    }
}
