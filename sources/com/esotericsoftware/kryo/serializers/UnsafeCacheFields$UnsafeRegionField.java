package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeMemoryOutput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeCacheFields$UnsafeRegionField extends UnsafeCacheFields$UnsafeCachedField {
    public static final boolean bulkReadsSupported = false;
    public final long len;

    public UnsafeCacheFields$UnsafeRegionField(long j, long j2) {
        super(j);
        this.len = j2;
    }

    private void readSlow(Input input, Object obj) {
        long j;
        long j2;
        Unsafe unsafe = UnsafeUtil.unsafe();
        long j3 = this.offset;
        while (true) {
            j = this.offset;
            j2 = this.len;
            if (j3 >= (j + j2) - 8) {
                break;
            }
            unsafe.putLong(obj, j3, input.readLong());
            j3 += 8;
        }
        if (j3 < j + j2) {
            while (j3 < this.offset + this.len) {
                unsafe.putByte(obj, j3, input.readByte());
                j3++;
            }
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        Unsafe unsafe = UnsafeUtil.unsafe();
        long j = this.offset;
        unsafe.copyMemory(obj, j, obj2, j, this.len);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public final void read(Input input, Object obj) {
        readSlow(input, obj);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public final void write(Output output, Object obj) {
        long j;
        long j2;
        if (output instanceof UnsafeOutput) {
            ((UnsafeOutput) output).writeBytes(obj, this.offset, this.len);
            return;
        }
        if (output instanceof UnsafeMemoryOutput) {
            ((UnsafeMemoryOutput) output).writeBytes(obj, this.offset, this.len);
            return;
        }
        Unsafe unsafe = UnsafeUtil.unsafe();
        long j3 = this.offset;
        while (true) {
            j = this.offset;
            j2 = this.len;
            if (j3 >= (j + j2) - 8) {
                break;
            }
            output.writeLong(unsafe.getLong(obj, j3));
            j3 += 8;
        }
        if (j3 < j + j2) {
            while (j3 < this.offset + this.len) {
                output.write(unsafe.getByte(obj, j3));
                j3++;
            }
        }
    }
}
