package p007b.p109f.p115d.p122g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.d.g.j */
/* JADX INFO: compiled from: PooledByteStreams.java */
/* JADX INFO: loaded from: classes.dex */
public class C1703j {

    /* JADX INFO: renamed from: a */
    public final int f3117a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1694a f3118b;

    public C1703j(InterfaceC1694a interfaceC1694a) {
        C1460d.m527i(true);
        this.f3117a = 16384;
        this.f3118b = interfaceC1694a;
    }

    /* JADX INFO: renamed from: a */
    public long m998a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f3118b.get(this.f3117a);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.f3117a);
                if (i == -1) {
                    this.f3118b.release(bArr);
                    return j;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            } catch (Throwable th) {
                this.f3118b.release(bArr);
                throw th;
            }
        }
    }
}
