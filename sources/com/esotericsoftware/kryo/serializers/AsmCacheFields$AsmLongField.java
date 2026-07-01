package com.esotericsoftware.kryo.serializers;

import b.e.b.c;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public final class AsmCacheFields$AsmLongField extends AsmCacheFields$AsmCachedField {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        c cVar = this.access;
        int i = this.accessIndex;
        cVar.A(obj2, i, cVar.j(obj, i));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        if (this.varIntsEnabled) {
            this.access.A(obj, this.accessIndex, input.readLong(false));
        } else {
            this.access.A(obj, this.accessIndex, input.readLong());
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        if (this.varIntsEnabled) {
            output.writeLong(this.access.j(obj, this.accessIndex), false);
        } else {
            output.writeLong(this.access.j(obj, this.accessIndex));
        }
    }
}
