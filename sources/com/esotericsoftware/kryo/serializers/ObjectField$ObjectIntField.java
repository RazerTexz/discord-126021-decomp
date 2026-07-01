package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectField$ObjectIntField extends ObjectField {
    public ObjectField$ObjectIntField(FieldSerializer fieldSerializer) {
        super(fieldSerializer);
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        try {
            Field field = this.field;
            field.setInt(obj2, field.getInt(obj));
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
        return Integer.valueOf(this.field.getInt(obj));
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        try {
            if (this.varIntsEnabled) {
                this.field.setInt(obj, input.readInt(false));
            } else {
                this.field.setInt(obj, input.readInt());
            }
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
            if (this.varIntsEnabled) {
                output.writeInt(this.field.getInt(obj), false);
            } else {
                output.writeInt(this.field.getInt(obj));
            }
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
