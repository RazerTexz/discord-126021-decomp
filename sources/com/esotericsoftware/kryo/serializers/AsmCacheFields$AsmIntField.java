package com.esotericsoftware.kryo.serializers;

import b.e.b.c;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public final class AsmCacheFields$AsmIntField extends AsmCacheFields$AsmCachedField {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        c cVar = this.access;
        int i = this.accessIndex;
        cVar.z(obj2, i, cVar.i(obj, i));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        if (this.varIntsEnabled) {
            this.access.z(obj, this.accessIndex, input.readInt(false));
        } else {
            this.access.z(obj, this.accessIndex, input.readInt());
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        if (this.varIntsEnabled) {
            output.writeInt(this.access.i(obj, this.accessIndex), false);
        } else {
            output.writeInt(this.access.i(obj, this.accessIndex));
        }
    }
}
