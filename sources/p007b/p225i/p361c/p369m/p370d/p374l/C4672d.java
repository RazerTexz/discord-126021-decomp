package p007b.p225i.p361c.p369m.p370d.p374l;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: b.i.c.m.d.l.d */
/* JADX INFO: compiled from: QueueFileLogStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4672d implements C4671c.d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ byte[] f12489a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int[] f12490b;

    public C4672d(C4673e c4673e, byte[] bArr, int[] iArr) {
        this.f12489a = bArr;
        this.f12490b = iArr;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.C4671c.d
    /* JADX INFO: renamed from: a */
    public void mo6512a(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.f12489a, this.f12490b[0], i);
            int[] iArr = this.f12490b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
