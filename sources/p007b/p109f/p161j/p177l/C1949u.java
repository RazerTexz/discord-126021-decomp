package p007b.p109f.p161j.p177l;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p115d.p122g.AbstractC1702i;
import p007b.p109f.p115d.p122g.C1703j;
import p007b.p109f.p115d.p122g.InterfaceC1700g;

/* JADX INFO: renamed from: b.f.j.l.u */
/* JADX INFO: compiled from: MemoryPooledByteBufferFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1949u implements InterfaceC1700g {

    /* JADX INFO: renamed from: a */
    public final C1703j f3955a;

    /* JADX INFO: renamed from: b */
    public final AbstractC1947s f3956b;

    public C1949u(AbstractC1947s abstractC1947s, C1703j c1703j) {
        this.f3956b = abstractC1947s;
        this.f3955a = c1703j;
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1700g
    /* JADX INFO: renamed from: a */
    public AbstractC1702i mo993a() {
        AbstractC1947s abstractC1947s = this.f3956b;
        return new MemoryPooledByteBufferOutputStream(abstractC1947s, abstractC1947s.f3952k[0]);
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1700g
    /* JADX INFO: renamed from: b */
    public PooledByteBuffer mo994b(byte[] bArr) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f3956b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                C1948t c1948tM8707b = memoryPooledByteBufferOutputStream.m8707b();
                memoryPooledByteBufferOutputStream.close();
                return c1948tM8707b;
            } catch (IOException e) {
                C1690m.m972a(e);
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1700g
    /* JADX INFO: renamed from: c */
    public PooledByteBuffer mo995c(InputStream inputStream) throws Throwable {
        AbstractC1947s abstractC1947s = this.f3956b;
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(abstractC1947s, abstractC1947s.f3952k[0]);
        try {
            this.f3955a.m998a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.m8707b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1700g
    /* JADX INFO: renamed from: d */
    public PooledByteBuffer mo996d(InputStream inputStream, int i) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f3956b, i);
        try {
            this.f3955a.m998a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.m8707b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1700g
    /* JADX INFO: renamed from: e */
    public AbstractC1702i mo997e(int i) {
        return new MemoryPooledByteBufferOutputStream(this.f3956b, i);
    }
}
