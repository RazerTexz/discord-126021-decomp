package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.d.d.DoNotStrip;
import b.f.j.l.MemoryChunk;
import b.f.m.n.NativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public final long j;
    public final int k;
    public boolean l;

    static {
        NativeLoader.c("imagepipeline");
    }

    public NativeMemoryChunk(int i) {
        AnimatableValueParser.i(Boolean.valueOf(i > 0));
        this.k = i;
        this.j = nativeAllocate(i);
        this.l = false;
    }

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    @Override // b.f.j.l.MemoryChunk
    public void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.j) {
            StringBuilder sbU = outline.U("Copying from NativeMemoryChunk ");
            sbU.append(Integer.toHexString(System.identityHashCode(this)));
            sbU.append(" to NativeMemoryChunk ");
            sbU.append(Integer.toHexString(System.identityHashCode(memoryChunk)));
            sbU.append(" which share the same address ");
            sbU.append(Long.toHexString(this.j));
            Log.w("NativeMemoryChunk", sbU.toString());
            AnimatableValueParser.i(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < this.j) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    c(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    c(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized int b(int i, byte[] bArr, int i2, int i3) {
        int iD;
        AnimatableValueParser.B(!isClosed());
        iD = AnimatableValueParser.d(i, i3, this.k);
        AnimatableValueParser.p(i, bArr.length, i2, iD, this.k);
        nativeCopyFromByteArray(this.j + ((long) i), bArr, i2, iD);
        return iD;
    }

    public final void c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof NativeMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.B(!isClosed());
        AnimatableValueParser.B(!memoryChunk.isClosed());
        AnimatableValueParser.p(i, memoryChunk.getSize(), i2, i3, this.k);
        nativeMemcpy(memoryChunk.k() + ((long) i2), this.j + ((long) i), i3);
    }

    @Override // b.f.j.l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.l) {
            this.l = true;
            nativeFree(this.j);
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        StringBuilder sbU = outline.U("finalize: Chunk ");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" still active. ");
        Log.w("NativeMemoryChunk", sbU.toString());
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // b.f.j.l.MemoryChunk
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // b.f.j.l.MemoryChunk
    public int getSize() {
        return this.k;
    }

    @Override // b.f.j.l.MemoryChunk
    public long getUniqueId() {
        return this.j;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized byte h(int i) {
        boolean z2 = true;
        AnimatableValueParser.B(!isClosed());
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        if (i >= this.k) {
            z2 = false;
        }
        AnimatableValueParser.i(Boolean.valueOf(z2));
        return nativeReadByte(this.j + ((long) i));
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        AnimatableValueParser.B(!isClosed());
        iD = AnimatableValueParser.d(i, i3, this.k);
        AnimatableValueParser.p(i, bArr.length, i2, iD, this.k);
        nativeCopyToByteArray(this.j + ((long) i), bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized boolean isClosed() {
        return this.l;
    }

    @Override // b.f.j.l.MemoryChunk
    public long k() {
        return this.j;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.k = 0;
        this.j = 0L;
        this.l = true;
    }
}
