package b.i.c.m.d.l;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: QueueFileLogStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements c$d {
    public final /* synthetic */ byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f1710b;

    public d(e eVar, byte[] bArr, int[] iArr) {
        this.a = bArr;
        this.f1710b = iArr;
    }

    @Override // b.i.c.m.d.l.c$d
    public void a(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.a, this.f1710b[0], i);
            int[] iArr = this.f1710b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
