package p007b.p109f.p161j.p177l;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.j.l.i */
/* JADX INFO: compiled from: BufferMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1937i implements InterfaceC1946r, Closeable {

    /* JADX INFO: renamed from: j */
    public ByteBuffer f3938j;

    /* JADX INFO: renamed from: k */
    public final int f3939k;

    /* JADX INFO: renamed from: l */
    public final long f3940l = System.identityHashCode(this);

    public C1937i(int i) {
        this.f3938j = ByteBuffer.allocateDirect(i);
        this.f3939k = i;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: a */
    public void mo1365a(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        Objects.requireNonNull(interfaceC1946r);
        if (interfaceC1946r.getUniqueId() == this.f3940l) {
            StringBuilder sbM833U = C1643a.m833U("Copying from BufferMemoryChunk ");
            sbM833U.append(Long.toHexString(this.f3940l));
            sbM833U.append(" to BufferMemoryChunk ");
            sbM833U.append(Long.toHexString(interfaceC1946r.getUniqueId()));
            sbM833U.append(" which are the same ");
            Log.w("BufferMemoryChunk", sbM833U.toString());
            C1460d.m527i(Boolean.FALSE);
        }
        if (interfaceC1946r.getUniqueId() < this.f3940l) {
            synchronized (interfaceC1946r) {
                synchronized (this) {
                    m1389c(i, interfaceC1946r, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (interfaceC1946r) {
                    m1389c(i, interfaceC1946r, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        C1460d.m419B(!isClosed());
        Objects.requireNonNull(this.f3938j);
        iM507d = C1460d.m507d(i, i3, this.f3939k);
        C1460d.m555p(i, bArr.length, i2, iM507d, this.f3939k);
        this.f3938j.position(i);
        this.f3938j.put(bArr, i2, iM507d);
        return iM507d;
    }

    /* JADX INFO: renamed from: c */
    public final void m1389c(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        if (!(interfaceC1946r instanceof C1937i)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        C1460d.m419B(!isClosed());
        C1460d.m419B(!interfaceC1946r.isClosed());
        Objects.requireNonNull(this.f3938j);
        C1460d.m555p(i, interfaceC1946r.getSize(), i2, i3, this.f3939k);
        this.f3938j.position(i);
        ByteBuffer byteBuffer = interfaceC1946r.getByteBuffer();
        Objects.requireNonNull(byteBuffer);
        byteBuffer.position(i2);
        byte[] bArr = new byte[i3];
        this.f3938j.get(bArr, 0, i3);
        byteBuffer.put(bArr, 0, i3);
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f3938j = null;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public synchronized ByteBuffer getByteBuffer() {
        return this.f3938j;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public int getSize() {
        return this.f3939k;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public long getUniqueId() {
        return this.f3940l;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        C1460d.m419B(!isClosed());
        C1460d.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f3939k) {
            z2 = false;
        }
        C1460d.m527i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.f3938j);
        return this.f3938j.get(i);
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        C1460d.m419B(!isClosed());
        Objects.requireNonNull(this.f3938j);
        iM507d = C1460d.m507d(i, i3, this.f3939k);
        C1460d.m555p(i, bArr.length, i2, iM507d, this.f3939k);
        this.f3938j.position(i);
        this.f3938j.get(bArr, i2, iM507d);
        return iM507d;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public synchronized boolean isClosed() {
        return this.f3938j == null;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: k */
    public long mo1370k() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }
}
