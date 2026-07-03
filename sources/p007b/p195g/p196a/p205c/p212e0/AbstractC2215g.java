package p007b.p195g.p196a.p205c.p212e0;

import java.io.IOException;
import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p198b.p204t.C2151m;
import p007b.p195g.p196a.p205c.InterfaceC2206d;

/* JADX INFO: renamed from: b.g.a.c.e0.g */
/* JADX INFO: compiled from: TypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2215g {
    /* JADX INFO: renamed from: a */
    public abstract AbstractC2215g mo1955a(InterfaceC2206d interfaceC2206d);

    /* JADX INFO: renamed from: b */
    public abstract String mo1956b();

    /* JADX INFO: renamed from: c */
    public abstract InterfaceC2070c0.a mo1957c();

    /* JADX INFO: renamed from: d */
    public C2138b m1958d(Object obj, EnumC2112h enumC2112h) {
        C2138b c2138b = new C2138b(obj, enumC2112h);
        int iOrdinal = mo1957c().ordinal();
        if (iOrdinal == 0) {
            c2138b.f4588e = 3;
            c2138b.f4587d = mo1956b();
        } else if (iOrdinal == 1) {
            c2138b.f4588e = 2;
        } else if (iOrdinal == 2) {
            c2138b.f4588e = 1;
        } else if (iOrdinal == 3) {
            c2138b.f4588e = 5;
            c2138b.f4587d = mo1956b();
        } else {
            if (iOrdinal != 4) {
                int i = C2151m.f4617a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            c2138b.f4588e = 4;
            c2138b.f4587d = mo1956b();
        }
        return c2138b;
    }

    /* JADX INFO: renamed from: e */
    public abstract C2138b mo1959e(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException;

    /* JADX INFO: renamed from: f */
    public abstract C2138b mo1960f(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException;
}
