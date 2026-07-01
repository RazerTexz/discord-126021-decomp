package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectField$ObjectBooleanField extends ObjectField {
    public ObjectField$ObjectBooleanField(FieldSerializer fieldSerializer) {
        super(fieldSerializer);
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        try {
            Field field = this.field;
            field.setBoolean(obj2, field.getBoolean(obj));
        } catch (Exception e) {
            KryoException kryoException = new KryoException(e);
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            a.m0(this.type, sb, ")", kryoException);
            throw kryoException;
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField
    public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return Boolean.valueOf(this.field.getBoolean(obj));
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        try {
            this.field.setBoolean(obj, input.readBoolean());
        } catch (Exception e) {
            KryoException kryoException = new KryoException(e);
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            a.m0(this.type, sb, ")", kryoException);
            throw kryoException;
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        try {
            output.writeBoolean(this.field.getBoolean(obj));
        } catch (Exception e) {
            KryoException kryoException = new KryoException(e);
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            a.m0(this.type, sb, ")", kryoException);
            throw kryoException;
        }
    }
}
