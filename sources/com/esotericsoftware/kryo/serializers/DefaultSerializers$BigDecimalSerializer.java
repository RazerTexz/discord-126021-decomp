package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$BigDecimalSerializer extends Serializer<BigDecimal> {
    private final DefaultSerializers$BigIntegerSerializer bigIntegerSerializer = new DefaultSerializers$BigIntegerSerializer();

    public DefaultSerializers$BigDecimalSerializer() {
        setAcceptsNull(true);
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ BigDecimal read(Kryo kryo, Input input, Class<BigDecimal> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, BigDecimal bigDecimal) {
        write2(kryo, output, bigDecimal);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public BigDecimal read2(Kryo kryo, Input input, Class<BigDecimal> cls) {
        BigInteger bigInteger = this.bigIntegerSerializer.read2(kryo, input, BigInteger.class);
        if (bigInteger == null) {
            return null;
        }
        int i = input.readInt(false);
        if (cls == BigDecimal.class || cls == null) {
            return (bigInteger == BigInteger.ZERO && i == 0) ? BigDecimal.ZERO : new BigDecimal(bigInteger, i);
        }
        try {
            Constructor<BigDecimal> constructor = cls.getConstructor(BigInteger.class, Integer.TYPE);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException unused) {
                }
            }
            return constructor.newInstance(bigInteger, Integer.valueOf(i));
        } catch (Exception e) {
            throw new KryoException(e);
        }
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            output.writeVarInt(0, true);
        } else if (bigDecimal == BigDecimal.ZERO) {
            this.bigIntegerSerializer.write2(kryo, output, BigInteger.ZERO);
            output.writeInt(0, false);
        } else {
            this.bigIntegerSerializer.write2(kryo, output, bigDecimal.unscaledValue());
            output.writeInt(bigDecimal.scale(), false);
        }
    }
}
