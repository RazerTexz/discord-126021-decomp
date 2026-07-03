package p007b.p109f.p160i;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p160i.C1832c;

/* JADX INFO: renamed from: b.f.i.d */
/* JADX INFO: compiled from: ImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class C1833d {

    /* JADX INFO: renamed from: a */
    public static C1833d f3599a;

    /* JADX INFO: renamed from: b */
    public int f3600b;

    /* JADX INFO: renamed from: c */
    public List<C1832c.a> f3601c;

    /* JADX INFO: renamed from: d */
    public final C1830a f3602d = new C1830a();

    public C1833d() {
        m1176d();
    }

    /* JADX INFO: renamed from: a */
    public static C1832c m1173a(InputStream inputStream) throws IOException {
        int iM421B1;
        C1833d c1833dM1175c = m1175c();
        Objects.requireNonNull(c1833dM1175c);
        Objects.requireNonNull(inputStream);
        int i = c1833dM1175c.f3600b;
        byte[] bArr = new byte[i];
        C1460d.m527i(Boolean.valueOf(i >= i));
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                iM421B1 = C1460d.m421B1(inputStream, bArr, 0, i);
                inputStream.reset();
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        } else {
            iM421B1 = C1460d.m421B1(inputStream, bArr, 0, i);
        }
        C1832c c1832cMo1171b = c1833dM1175c.f3602d.mo1171b(bArr, iM421B1);
        if (c1832cMo1171b != C1832c.f3597a) {
            return c1832cMo1171b;
        }
        List<C1832c.a> list = c1833dM1175c.f3601c;
        if (list != null) {
            Iterator<C1832c.a> it = list.iterator();
            while (it.hasNext()) {
                C1832c c1832cMo1171b2 = it.next().mo1171b(bArr, iM421B1);
                if (c1832cMo1171b2 != null && c1832cMo1171b2 != C1832c.f3597a) {
                    return c1832cMo1171b2;
                }
            }
        }
        return C1832c.f3597a;
    }

    /* JADX INFO: renamed from: b */
    public static C1832c m1174b(InputStream inputStream) {
        try {
            return m1173a(inputStream);
        } catch (IOException e) {
            C1690m.m972a(e);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C1833d m1175c() {
        if (f3599a == null) {
            f3599a = new C1833d();
        }
        return f3599a;
    }

    /* JADX INFO: renamed from: d */
    public final void m1176d() {
        this.f3600b = this.f3602d.f3584p;
        List<C1832c.a> list = this.f3601c;
        if (list != null) {
            Iterator<C1832c.a> it = list.iterator();
            while (it.hasNext()) {
                this.f3600b = Math.max(this.f3600b, it.next().mo1170a());
            }
        }
    }
}
