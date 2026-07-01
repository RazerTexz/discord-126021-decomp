package com.esotericsoftware.kryo.serializers;

import b.e.b.c;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public final class AsmCacheFields$AsmFloatField extends AsmCacheFields$AsmCachedField {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        c cVar = this.access;
        int i = this.accessIndex;
        cVar.y(obj2, i, cVar.g(obj, i));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        this.access.y(obj, this.accessIndex, input.readFloat());
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        output.writeFloat(this.access.g(obj, this.accessIndex));
    }
}
