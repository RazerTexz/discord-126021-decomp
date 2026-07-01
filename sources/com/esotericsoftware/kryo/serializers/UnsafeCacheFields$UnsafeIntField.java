package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeIntField extends UnsafeCacheFields$UnsafeCachedField {
    public UnsafeCacheFields$UnsafeIntField(Field field) {
        super(UnsafeUtil.unsafe().objectFieldOffset(field));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        UnsafeUtil.unsafe().putInt(obj2, this.offset, UnsafeUtil.unsafe().getInt(obj, this.offset));
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        if (this.varIntsEnabled) {
            UnsafeUtil.unsafe().putInt(obj, this.offset, input.readInt(false));
        } else {
            UnsafeUtil.unsafe().putInt(obj, this.offset, input.readInt());
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        if (this.varIntsEnabled) {
            output.writeInt(UnsafeUtil.unsafe().getInt(obj, this.offset), false);
        } else {
            output.writeInt(UnsafeUtil.unsafe().getInt(obj, this.offset));
        }
    }
}
