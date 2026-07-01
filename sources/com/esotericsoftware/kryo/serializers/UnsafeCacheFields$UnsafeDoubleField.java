package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeDoubleField extends UnsafeCacheFields$UnsafeCachedField {
    public UnsafeCacheFields$UnsafeDoubleField(Field field) {
        super(UnsafeUtil.unsafe().objectFieldOffset(field));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        UnsafeUtil.unsafe().putDouble(obj2, this.offset, UnsafeUtil.unsafe().getDouble(obj, this.offset));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        UnsafeUtil.unsafe().putDouble(obj, this.offset, input.readDouble());
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        output.writeDouble(UnsafeUtil.unsafe().getDouble(obj, this.offset));
    }
}
