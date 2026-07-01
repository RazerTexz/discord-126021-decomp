package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import b.e.b.c;
import com.esotericsoftware.kryo.KryoException;

/* JADX INFO: loaded from: classes.dex */
public final class AsmCacheFields$AsmObjectField extends ObjectField {
    public AsmCacheFields$AsmObjectField(FieldSerializer fieldSerializer) {
        super(fieldSerializer);
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        try {
            int i = this.accessIndex;
            if (i == -1) {
                throw new KryoException("Unknown acess index");
            }
            c cVar = this.access;
            cVar.t(obj2, i, this.kryo.copy(cVar.b(obj, i)));
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
        int i = this.accessIndex;
        if (i != -1) {
            return this.access.b(obj, i);
        }
        throw new KryoException("Unknown acess index");
    }

    @Override // com.esotericsoftware.kryo.serializers.ObjectField
    public void setField(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        int i = this.accessIndex;
        if (i == -1) {
            throw new KryoException("Unknown acess index");
        }
        this.access.t(obj, i, obj2);
    }
}
