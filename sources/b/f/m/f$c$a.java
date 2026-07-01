package b.f.m;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ExtractFromZipSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c$a extends m$e {
    public int j;
    public final /* synthetic */ f$c k;

    public f$c$a(f$c f_c, f$a f_a) {
        this.k = f_c;
    }

    @Override // b.f.m.m$e
    public boolean a() {
        this.k.c();
        return this.j < this.k.j.length;
    }

    @Override // b.f.m.m$e
    public m$d b() throws IOException {
        this.k.c();
        f$c f_c = this.k;
        f$b[] f_bArr = f_c.j;
        int i = this.j;
        this.j = i + 1;
        f$b f_b = f_bArr[i];
        InputStream inputStream = f_c.k.getInputStream(f_b.l);
        try {
            return new m$d(f_b, inputStream);
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
