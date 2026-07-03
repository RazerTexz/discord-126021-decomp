package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e;

/* JADX INFO: renamed from: b.g.a.c.e0.h.m */
/* JADX INFO: compiled from: TypeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2228m extends AbstractC2215g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2213e f4779a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2206d f4780b;

    public AbstractC2228m(InterfaceC2213e interfaceC2213e, InterfaceC2206d interfaceC2206d) {
        this.f4779a = interfaceC2213e;
        this.f4780b = interfaceC2206d;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: b */
    public String mo1956b() {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: e */
    public C2138b mo1959e(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException {
        if (c2138b.f4586c == null) {
            Object obj = c2138b.f4584a;
            Class<?> cls = c2138b.f4585b;
            c2138b.f4586c = cls == null ? this.f4779a.mo1946a(obj) : this.f4779a.mo1948c(obj, cls);
        }
        Objects.requireNonNull(abstractC2108d);
        Object obj2 = c2138b.f4586c;
        EnumC2112h enumC2112h = c2138b.f4589f;
        String strValueOf = obj2 instanceof String ? (String) obj2 : String.valueOf(obj2);
        c2138b.f4590g = true;
        int i = c2138b.f4588e;
        EnumC2112h enumC2112h2 = EnumC2112h.START_OBJECT;
        if (enumC2112h != enumC2112h2) {
            C1563b.m760j(i);
            if (i == 3 || i == 4) {
                c2138b.f4588e = 1;
                i = 1;
            }
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h != 1) {
            if (iM758h == 2) {
                abstractC2108d.mo1653d0(c2138b.f4584a);
                abstractC2108d.mo1666y(c2138b.f4587d);
                abstractC2108d.mo1658j0(strValueOf);
            } else if (iM758h != 3 && iM758h != 4) {
                abstractC2108d.mo1645W();
                abstractC2108d.mo1658j0(strValueOf);
            }
            return c2138b;
        }
        abstractC2108d.mo1651c0();
        abstractC2108d.mo1666y(strValueOf);
        if (enumC2112h == enumC2112h2) {
            abstractC2108d.mo1653d0(c2138b.f4584a);
        } else if (enumC2112h == EnumC2112h.START_ARRAY) {
            abstractC2108d.mo1645W();
        }
        return c2138b;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: f */
    public C2138b mo1960f(AbstractC2108d abstractC2108d, C2138b c2138b) throws IOException {
        Objects.requireNonNull(abstractC2108d);
        EnumC2112h enumC2112h = c2138b.f4589f;
        if (enumC2112h == EnumC2112h.START_OBJECT) {
            abstractC2108d.mo1664u();
        } else if (enumC2112h == EnumC2112h.START_ARRAY) {
            abstractC2108d.mo1663t();
        }
        if (c2138b.f4590g) {
            int iM758h = C1563b.m758h(c2138b.f4588e);
            if (iM758h == 0) {
                abstractC2108d.mo1663t();
            } else if (iM758h != 2 && iM758h != 3) {
                if (iM758h != 4) {
                    abstractC2108d.mo1664u();
                } else {
                    Object obj = c2138b.f4586c;
                    String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
                    abstractC2108d.mo1666y(c2138b.f4587d);
                    abstractC2108d.mo1658j0(strValueOf);
                }
            }
        }
        return c2138b;
    }
}
