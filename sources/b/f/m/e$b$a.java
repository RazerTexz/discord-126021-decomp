package b.f.m;

import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ExoSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b$a extends m$e {
    public int j;
    public final /* synthetic */ e$b k;

    public e$b$a(e$b e_b, e$a e_a) {
        this.k = e_b;
    }

    @Override // b.f.m.m$e
    public boolean a() {
        return this.j < this.k.j.length;
    }

    @Override // b.f.m.m$e
    public m$d b() throws IOException {
        e$c[] e_cArr = this.k.j;
        int i = this.j;
        this.j = i + 1;
        e$c e_c = e_cArr[i];
        FileInputStream fileInputStream = new FileInputStream(e_c.l);
        try {
            return new m$d(e_c, fileInputStream);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }
}
