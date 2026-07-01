package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeByteField extends UnsafeCacheFields$UnsafeCachedField {
    public UnsafeCacheFields$UnsafeByteField(Field field) {
        super(UnsafeUtil.unsafe().objectFieldOffset(field));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        UnsafeUtil.unsafe().putByte(obj2, this.offset, UnsafeUtil.unsafe().getByte(obj, this.offset));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        UnsafeUtil.unsafe().putByte(obj, this.offset, input.readByte());
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        output.writeByte(UnsafeUtil.unsafe().getByte(obj, this.offset));
    }
}
