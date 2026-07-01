package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeObjectField extends ObjectField {
    public UnsafeCacheFields$UnsafeObjectField(FieldSerializer fieldSerializer) {
        super(fieldSerializer);
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        try {
            if (this.offset == -1) {
                throw new KryoException("Unknown offset");
            }
            UnsafeUtil.unsafe().putObject(obj2, this.offset, this.kryo.copy(UnsafeUtil.unsafe().getObject(obj, this.offset)));
        } catch (KryoException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            a.m0(this.type, sb, ")", e);
            throw e;
        } catch (RuntimeException e2) {
            KryoException kryoException = new KryoException(e2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this);
            sb2.append(" (");
            a.m0(this.type, sb2, ")", kryoException);
            throw kryoException;
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField
    public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (this.offset >= 0) {
            return UnsafeUtil.unsafe().getObject(obj, this.offset);
        }
        throw new KryoException("Unknown offset");
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField
    public void setField(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        if (this.offset == -1) {
            throw new KryoException("Unknown offset");
        }
        UnsafeUtil.unsafe().putObject(obj, this.offset, obj2);
    }
}
