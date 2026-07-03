package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2104z;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2199t;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2205z;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p210c0.C2197r;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2186g0;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.z.l */
/* JADX INFO: compiled from: MapperConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2394l<T extends AbstractC2394l<T>> implements AbstractC2199t.a, Serializable {
    private static final long serialVersionUID = 2;
    public final C2383a _base;
    public final int _mapperFeatures;

    static {
        InterfaceC2094p.b bVar = InterfaceC2094p.b.f4436j;
        InterfaceC2094p.b bVar2 = InterfaceC2094p.b.f4436j;
        InterfaceC2081i.d dVar = InterfaceC2081i.d.f4421j;
    }

    public AbstractC2394l(C2383a c2383a, int i) {
        this._base = c2383a;
        this._mapperFeatures = i;
    }

    /* JADX INFO: renamed from: c */
    public static <F extends Enum<F> & InterfaceC2387e> int m2264c(Class<F> cls) {
        int iMo2091g = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            InterfaceC2387e interfaceC2387e = (InterfaceC2387e) obj;
            if (interfaceC2387e.mo2090f()) {
                iMo2091g |= interfaceC2387e.mo2091g();
            }
        }
        return iMo2091g;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m2265b() {
        return m2279q(EnumC2366p.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC2360j m2266d(Class<?> cls) {
        return this._base._typeFactory.m2160b(null, cls, C2335n.f4926l);
    }

    /* JADX INFO: renamed from: e */
    public AbstractC2165b m2267e() {
        return m2279q(EnumC2366p.USE_ANNOTATIONS) ? this._base._annotationIntrospector : AbstractC2205z.f4764j;
    }

    /* JADX INFO: renamed from: f */
    public abstract AbstractC2388f mo2268f(Class<?> cls);

    /* JADX INFO: renamed from: g */
    public abstract InterfaceC2094p.b mo2269g(Class<?> cls, Class<?> cls2);

    /* JADX INFO: renamed from: h */
    public abstract Boolean mo2270h();

    /* JADX INFO: renamed from: i */
    public abstract InterfaceC2081i.d mo2271i(Class<?> cls);

    /* JADX INFO: renamed from: j */
    public abstract InterfaceC2094p.b mo2272j(Class<?> cls);

    /* JADX INFO: renamed from: k */
    public InterfaceC2094p.b m2273k(Class<?> cls, InterfaceC2094p.b bVar) {
        Objects.requireNonNull(mo2268f(cls));
        return bVar;
    }

    /* JADX INFO: renamed from: l */
    public abstract InterfaceC2104z.a mo2274l();

    /* JADX INFO: renamed from: m */
    public abstract InterfaceC2186g0<?> mo2275m(Class<?> cls, C2177c c2177c);

    /* JADX INFO: renamed from: n */
    public AbstractC2172c m2276n(AbstractC2360j abstractC2360j) {
        C2197r c2197r = (C2197r) this._base._classIntrospector;
        C2196q c2196qM1920a = c2197r.m1920a(this, abstractC2360j);
        return c2196qM1920a == null ? C2196q.m1918e(this, abstractC2360j, c2197r.m1921b(this, abstractC2360j, this)) : c2196qM1920a;
    }

    /* JADX INFO: renamed from: o */
    public AbstractC2172c m2277o(Class<?> cls) {
        return m2276n(this._base._typeFactory.m2160b(null, cls, C2335n.f4926l));
    }

    /* JADX INFO: renamed from: p */
    public final boolean m2278p() {
        return m2279q(EnumC2366p.USE_ANNOTATIONS);
    }

    /* JADX INFO: renamed from: q */
    public final boolean m2279q(EnumC2366p enumC2366p) {
        return enumC2366p.m2222h(this._mapperFeatures);
    }

    public AbstractC2394l(AbstractC2394l<T> abstractC2394l, int i) {
        this._base = abstractC2394l._base;
        this._mapperFeatures = i;
    }
}
