package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p177l.InterfaceC1946r;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeMemoryChunk implements InterfaceC1946r, Closeable {

    /* JADX INFO: renamed from: j */
    public final long f19563j;

    /* JADX INFO: renamed from: k */
    public final int f19564k;

    /* JADX INFO: renamed from: l */
    public boolean f19565l;

    static {
        C2061a.m1589c("imagepipeline");
    }

    public NativeMemoryChunk(int i) {
        C1460d.m527i(Boolean.valueOf(i > 0));
        this.f19564k = i;
        this.f19563j = nativeAllocate(i);
        this.f19565l = false;
    }

    @InterfaceC1680c
    private static native long nativeAllocate(int i);

    @InterfaceC1680c
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @InterfaceC1680c
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @InterfaceC1680c
    private static native void nativeFree(long j);

    @InterfaceC1680c
    private static native void nativeMemcpy(long j, long j2, int i);

    @InterfaceC1680c
    private static native byte nativeReadByte(long j);

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: a */
    public void mo1365a(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        Objects.requireNonNull(interfaceC1946r);
        if (interfaceC1946r.getUniqueId() == this.f19563j) {
            StringBuilder sbM833U = C1643a.m833U("Copying from NativeMemoryChunk ");
            sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
            sbM833U.append(" to NativeMemoryChunk ");
            sbM833U.append(Integer.toHexString(System.identityHashCode(interfaceC1946r)));
            sbM833U.append(" which share the same address ");
            sbM833U.append(Long.toHexString(this.f19563j));
            Log.w("NativeMemoryChunk", sbM833U.toString());
            C1460d.m527i(Boolean.FALSE);
        }
        if (interfaceC1946r.getUniqueId() < this.f19563j) {
            synchronized (interfaceC1946r) {
                synchronized (this) {
                    m8708c(i, interfaceC1946r, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (interfaceC1946r) {
                    m8708c(i, interfaceC1946r, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        C1460d.m419B(!isClosed());
        iM507d = C1460d.m507d(i, i3, this.f19564k);
        C1460d.m555p(i, bArr.length, i2, iM507d, this.f19564k);
        nativeCopyFromByteArray(this.f19563j + ((long) i), bArr, i2, iM507d);
        return iM507d;
    }

    /* JADX INFO: renamed from: c */
    public final void m8708c(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        if (!(interfaceC1946r instanceof NativeMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        C1460d.m419B(!isClosed());
        C1460d.m419B(!interfaceC1946r.isClosed());
        C1460d.m555p(i, interfaceC1946r.getSize(), i2, i3, this.f19564k);
        nativeMemcpy(interfaceC1946r.mo1370k() + ((long) i2), this.f19563j + ((long) i), i3);
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f19565l) {
            this.f19565l = true;
            nativeFree(this.f19563j);
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        StringBuilder sbM833U = C1643a.m833U("finalize: Chunk ");
        sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
        sbM833U.append(" still active. ");
        Log.w("NativeMemoryChunk", sbM833U.toString());
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public int getSize() {
        return this.f19564k;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public long getUniqueId() {
        return this.f19563j;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        C1460d.m419B(!isClosed());
        C1460d.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f19564k) {
            z2 = false;
        }
        C1460d.m527i(Boolean.valueOf(z2));
        return nativeReadByte(this.f19563j + ((long) i));
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        C1460d.m419B(!isClosed());
        iM507d = C1460d.m507d(i, i3, this.f19564k);
        C1460d.m555p(i, bArr.length, i2, iM507d, this.f19564k);
        nativeCopyToByteArray(this.f19563j + ((long) i), bArr, i2, iM507d);
        return iM507d;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public synchronized boolean isClosed() {
        return this.f19565l;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: k */
    public long mo1370k() {
        return this.f19563j;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f19564k = 0;
        this.f19563j = 0L;
        this.f19565l = true;
    }
}
