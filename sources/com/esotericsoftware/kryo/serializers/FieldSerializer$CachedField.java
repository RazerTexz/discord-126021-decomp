package com.esotericsoftware.kryo.serializers;

import b.e.b.c;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class FieldSerializer$CachedField<X> {
    public c access;
    public boolean canBeNull;
    public Field field;
    public Serializer serializer;
    public Class valueClass;
    public int accessIndex = -1;
    public long offset = -1;
    public boolean varIntsEnabled = true;

    public abstract void copy(Object obj, Object obj2);

    public Field getField() {
        return this.field;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public abstract void read(Input input, Object obj);

    public void setCanBeNull(boolean z2) {
        this.canBeNull = z2;
    }

    public void setClass(Class cls) {
        this.valueClass = cls;
        this.serializer = null;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public String toString() {
        return this.field.getName();
    }

    public abstract void write(Output output, Object obj);

    public void setClass(Class cls, Serializer serializer) {
        this.valueClass = cls;
        this.serializer = serializer;
    }
}
