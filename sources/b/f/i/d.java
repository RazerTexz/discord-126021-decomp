package b.f.i;

import b.f.d.d.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f542b;
    public List<c$a> c;
    public final a d = new a();

    public d() {
        d();
    }

    public static c a(InputStream inputStream) throws IOException {
        int iB1;
        d dVarC = c();
        Objects.requireNonNull(dVarC);
        Objects.requireNonNull(inputStream);
        int i = dVarC.f542b;
        byte[] bArr = new byte[i];
        b.c.a.a0.d.i(Boolean.valueOf(i >= i));
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                iB1 = b.c.a.a0.d.B1(inputStream, bArr, 0, i);
                inputStream.reset();
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        } else {
            iB1 = b.c.a.a0.d.B1(inputStream, bArr, 0, i);
        }
        c cVarB = dVarC.d.b(bArr, iB1);
        if (cVarB != c.a) {
            return cVarB;
        }
        List<c$a> list = dVarC.c;
        if (list != null) {
            Iterator<c$a> it = list.iterator();
            while (it.hasNext()) {
                c cVarB2 = it.next().b(bArr, iB1);
                if (cVarB2 != null && cVarB2 != c.a) {
                    return cVarB2;
                }
            }
        }
        return c.a;
    }

    public static c b(InputStream inputStream) {
        try {
            return a(inputStream);
        } catch (IOException e) {
            m.a(e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized d c() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public final void d() {
        this.f542b = this.d.p;
        List<c$a> list = this.c;
        if (list != null) {
            Iterator<c$a> it = list.iterator();
            while (it.hasNext()) {
                this.f542b = Math.max(this.f542b, it.next().a());
            }
        }
    }
}
