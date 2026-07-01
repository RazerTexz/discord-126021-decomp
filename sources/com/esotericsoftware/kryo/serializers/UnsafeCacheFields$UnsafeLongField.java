package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeLongField extends UnsafeCacheFields$UnsafeCachedField {
    public UnsafeCacheFields$UnsafeLongField(Field field) {
        super(UnsafeUtil.unsafe().objectFieldOffset(field));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        UnsafeUtil.unsafe().putLong(obj2, this.offset, UnsafeUtil.unsafe().getLong(obj, this.offset));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        if (this.varIntsEnabled) {
            UnsafeUtil.unsafe().putLong(obj, this.offset, input.readLong(false));
        } else {
            UnsafeUtil.unsafe().putLong(obj, this.offset, input.readLong());
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        if (this.varIntsEnabled) {
            output.writeLong(UnsafeUtil.unsafe().getLong(obj, this.offset), false);
        } else {
            output.writeLong(UnsafeUtil.unsafe().getLong(obj, this.offset));
        }
    }
}
