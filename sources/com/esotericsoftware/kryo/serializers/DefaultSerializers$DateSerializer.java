package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$DateSerializer extends Serializer<Date> {
    private Date create(Kryo kryo, Class<? extends Date> cls, long j) throws KryoException {
        if (cls == Date.class || cls == null) {
            return new Date(j);
        }
        if (cls == Timestamp.class) {
            return new Timestamp(j);
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(j);
        }
        if (cls == Time.class) {
            return new Time(j);
        }
        try {
            Constructor<? extends Date> constructor = cls.getConstructor(Long.TYPE);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException unused) {
                }
            }
            return constructor.newInstance(Long.valueOf(j));
        } catch (Exception unused2) {
            Date date = (Date) kryo.newInstance(cls);
            date.setTime(j);
            return date;
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Date copy(Kryo kryo, Date date) {
        return copy2(kryo, date);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Date read(Kryo kryo, Input input, Class<Date> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Date date) {
        write2(kryo, output, date);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Date copy2(Kryo kryo, Date date) {
        return create(kryo, date.getClass(), date.getTime());
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(Kryo kryo, Input input, Class<Date> cls) {
        return create(kryo, cls, input.readLong(true));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Date date) {
        output.writeLong(date.getTime(), true);
    }
}
