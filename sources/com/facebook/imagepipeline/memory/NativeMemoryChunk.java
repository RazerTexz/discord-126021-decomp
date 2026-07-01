package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.d;
import b.f.d.d.c;
import b.f.j.l.r;
import b.f.m.n.a;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@c
public class NativeMemoryChunk implements r, Closeable {
    public final long j;
    public final int k;
    public boolean l;

    static {
        a.c("imagepipeline");
    }

    public NativeMemoryChunk(int i) {
        d.i(Boolean.valueOf(i > 0));
        this.k = i;
        this.j = nativeAllocate(i);
        this.l = false;
    }

    @c
    private static native long nativeAllocate(int i);

    @c
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @c
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @c
    private static native void nativeFree(long j);

    @c
    private static native void nativeMemcpy(long j, long j2, int i);

    @c
    private static native byte nativeReadByte(long j);

    @Override // b.f.j.l.r
    public void a(int i, r rVar, int i2, int i3) {
        Objects.requireNonNull(rVar);
        if (rVar.getUniqueId() == this.j) {
            StringBuilder sbU = b.d.b.a.a.U("Copying from NativeMemoryChunk ");
            sbU.append(Integer.toHexString(System.identityHashCode(this)));
            sbU.append(" to NativeMemoryChunk ");
            sbU.append(Integer.toHexString(System.identityHashCode(rVar)));
            sbU.append(" which share the same address ");
            sbU.append(Long.toHexString(this.j));
            Log.w("NativeMemoryChunk", sbU.toString());
            d.i(Boolean.FALSE);
        }
        if (rVar.getUniqueId() < this.j) {
            synchronized (rVar) {
                synchronized (this) {
                    c(i, rVar, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (rVar) {
                    c(i, rVar, i2, i3);
                }
            }
        }
    }

    @Override // b.f.j.l.r
    public synchronized int b(int i, byte[] bArr, int i2, int i3) {
        int iD;
        d.B(!isClosed());
        iD = d.d(i, i3, this.k);
        d.p(i, bArr.length, i2, iD, this.k);
        nativeCopyFromByteArray(this.j + ((long) i), bArr, i2, iD);
        return iD;
    }

    public final void c(int i, r rVar, int i2, int i3) {
        if (!(rVar instanceof NativeMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        d.B(!isClosed());
        d.B(!rVar.isClosed());
        d.p(i, rVar.getSize(), i2, i3, this.k);
        nativeMemcpy(rVar.k() + ((long) i2), this.j + ((long) i), i3);
    }

    @Override // b.f.j.l.r, java.io.Closeable, java.lang.AutoCloseable
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
        StringBuilder sbU = b.d.b.a.a.U("finalize: Chunk ");
        sbU.append(Integer.toHexString(System.identityHashCode(this)));
        sbU.append(" still active. ");
        Log.w("NativeMemoryChunk", sbU.toString());
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // b.f.j.l.r
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // b.f.j.l.r
    public int getSize() {
        return this.k;
    }

    @Override // b.f.j.l.r
    public long getUniqueId() {
        return this.j;
    }

    @Override // b.f.j.l.r
    public synchronized byte h(int i) {
        boolean z2 = true;
        d.B(!isClosed());
        d.i(Boolean.valueOf(i >= 0));
        if (i >= this.k) {
            z2 = false;
        }
        d.i(Boolean.valueOf(z2));
        return nativeReadByte(this.j + ((long) i));
    }

    @Override // b.f.j.l.r
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        d.B(!isClosed());
        iD = d.d(i, i3, this.k);
        d.p(i, bArr.length, i2, iD, this.k);
        nativeCopyToByteArray(this.j + ((long) i), bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.r
    public synchronized boolean isClosed() {
        return this.l;
    }

    @Override // b.f.j.l.r
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
