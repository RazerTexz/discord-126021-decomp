package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$BigIntegerSerializer extends Serializer<BigInteger> {
    public DefaultSerializers$BigIntegerSerializer() {
        setImmutable(true);
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ BigInteger read(Kryo kryo, Input input, Class<BigInteger> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, BigInteger bigInteger) {
        write2(kryo, output, bigInteger);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public BigInteger read2(Kryo kryo, Input input, Class<BigInteger> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        byte[] bytes = input.readBytes(varInt - 1);
        if (cls != BigInteger.class && cls != null) {
            try {
                Constructor<BigInteger> constructor = cls.getConstructor(byte[].class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException unused) {
                    }
                }
                return constructor.newInstance(bytes);
            } catch (Exception e) {
                throw new KryoException(e);
            }
        }
        if (varInt == 2) {
            byte b2 = bytes[0];
            if (b2 == 0) {
                return BigInteger.ZERO;
            }
            if (b2 == 1) {
                return BigInteger.ONE;
            }
            if (b2 == 10) {
                return BigInteger.TEN;
            }
        }
        return new BigInteger(bytes);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, BigInteger bigInteger) {
        if (bigInteger == null) {
            output.writeVarInt(0, true);
            return;
        }
        if (bigInteger == BigInteger.ZERO) {
            output.writeVarInt(2, true);
            output.writeByte(0);
        } else {
            byte[] byteArray = bigInteger.toByteArray();
            output.writeVarInt(byteArray.length + 1, true);
            output.writeBytes(byteArray);
        }
    }
}
