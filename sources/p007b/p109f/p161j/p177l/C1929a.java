package p007b.p109f.p161j.p177l;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.j.l.a */
/* JADX INFO: compiled from: AshmemMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(27)
public class C1929a implements InterfaceC1946r, Closeable {

    /* JADX INFO: renamed from: j */
    public SharedMemory f3914j;

    /* JADX INFO: renamed from: k */
    public ByteBuffer f3915k;

    /* JADX INFO: renamed from: l */
    public final long f3916l;

    public C1929a(int i) {
        C1460d.m527i(Boolean.valueOf(i > 0));
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("AshmemMemoryChunk", i);
            this.f3914j = sharedMemoryCreate;
            this.f3915k = sharedMemoryCreate.mapReadWrite();
            this.f3916l = System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: a */
    public void mo1365a(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        Objects.requireNonNull(interfaceC1946r);
        if (interfaceC1946r.getUniqueId() == this.f3916l) {
            StringBuilder sbM833U = C1643a.m833U("Copying from AshmemMemoryChunk ");
            sbM833U.append(Long.toHexString(this.f3916l));
            sbM833U.append(" to AshmemMemoryChunk ");
            sbM833U.append(Long.toHexString(interfaceC1946r.getUniqueId()));
            sbM833U.append(" which are the same ");
            Log.w("AshmemMemoryChunk", sbM833U.toString());
            C1460d.m527i(Boolean.FALSE);
        }
        if (interfaceC1946r.getUniqueId() < this.f3916l) {
            synchronized (interfaceC1946r) {
                synchronized (this) {
                    m1367c(i, interfaceC1946r, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (interfaceC1946r) {
                    m1367c(i, interfaceC1946r, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(this.f3915k);
        iM507d = C1460d.m507d(i, i3, getSize());
        C1460d.m555p(i, bArr.length, i2, iM507d, getSize());
        this.f3915k.position(i);
        this.f3915k.put(bArr, i2, iM507d);
        return iM507d;
    }

    /* JADX INFO: renamed from: c */
    public final void m1367c(int i, InterfaceC1946r interfaceC1946r, int i2, int i3) {
        if (!(interfaceC1946r instanceof C1929a)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        C1460d.m419B(!isClosed());
        C1460d.m419B(!interfaceC1946r.isClosed());
        Objects.requireNonNull(this.f3915k);
        Objects.requireNonNull(interfaceC1946r.getByteBuffer());
        C1460d.m555p(i, interfaceC1946r.getSize(), i2, i3, getSize());
        this.f3915k.position(i);
        interfaceC1946r.getByteBuffer().position(i2);
        byte[] bArr = new byte[i3];
        this.f3915k.get(bArr, 0, i3);
        interfaceC1946r.getByteBuffer().put(bArr, 0, i3);
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory sharedMemory = this.f3914j;
            if (sharedMemory != null) {
                sharedMemory.close();
            }
            ByteBuffer byteBuffer = this.f3915k;
            if (byteBuffer != null) {
                SharedMemory.unmap(byteBuffer);
            }
            this.f3915k = null;
            this.f3914j = null;
        }
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public ByteBuffer getByteBuffer() {
        return this.f3915k;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public int getSize() {
        Objects.requireNonNull(this.f3914j);
        return this.f3914j.getSize();
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public long getUniqueId() {
        return this.f3916l;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        C1460d.m419B(!isClosed());
        C1460d.m527i(Boolean.valueOf(i >= 0));
        if (i >= getSize()) {
            z2 = false;
        }
        C1460d.m527i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.f3915k);
        return this.f3915k.get(i);
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(this.f3915k);
        iM507d = C1460d.m507d(i, i3, getSize());
        C1460d.m555p(i, bArr.length, i2, iM507d, getSize());
        this.f3915k.position(i);
        this.f3915k.get(bArr, i2, iM507d);
        return iM507d;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    public synchronized boolean isClosed() {
        return this.f3915k == null || this.f3914j == null;
    }

    @Override // p007b.p109f.p161j.p177l.InterfaceC1946r
    /* JADX INFO: renamed from: k */
    public long mo1370k() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }
}
