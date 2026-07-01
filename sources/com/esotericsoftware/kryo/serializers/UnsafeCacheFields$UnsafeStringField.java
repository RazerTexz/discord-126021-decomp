package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeStringField extends UnsafeCacheFields$UnsafeCachedField {
    public UnsafeCacheFields$UnsafeStringField(Field field) {
        super(UnsafeUtil.unsafe().objectFieldOffset(field));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        UnsafeUtil.unsafe().putObject(obj2, this.offset, UnsafeUtil.unsafe().getObject(obj, this.offset));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        UnsafeUtil.unsafe().putObject(obj, this.offset, input.readString());
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        output.writeString((String) UnsafeUtil.unsafe().getObject(obj, this.offset));
    }
}
