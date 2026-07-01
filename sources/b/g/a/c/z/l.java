package b.g.a.c.z;

import b.g.a.a.i$d;
import b.g.a.a.p$b;
import b.g.a.a.z$a;
import b.g.a.c.c0.g0;
import b.g.a.c.c0.q;
import b.g.a.c.c0.r;
import b.g.a.c.c0.t$a;
import b.g.a.c.c0.z;
import b.g.a.c.p;
import b.g.a.c.z.l;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: MapperConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<T extends l<T>> implements t$a, Serializable {
    private static final long serialVersionUID = 2;
    public final a _base;
    public final int _mapperFeatures;

    static {
        p$b p_b = p$b.j;
        p$b p_b2 = p$b.j;
        i$d i_d = i$d.j;
    }

    public l(a aVar, int i) {
        this._base = aVar;
        this._mapperFeatures = i;
    }

    public static <F extends Enum<F> & e> int c(Class<F> cls) {
        int iG = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            e eVar = (e) obj;
            if (eVar.f()) {
                iG |= eVar.g();
            }
        }
        return iG;
    }

    public final boolean b() {
        return q(p.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final b.g.a.c.j d(Class<?> cls) {
        return this._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l);
    }

    public b.g.a.c.b e() {
        return q(p.USE_ANNOTATIONS) ? this._base._annotationIntrospector : z.j;
    }

    public abstract f f(Class<?> cls);

    public abstract p$b g(Class<?> cls, Class<?> cls2);

    public abstract Boolean h();

    public abstract i$d i(Class<?> cls);

    public abstract p$b j(Class<?> cls);

    public p$b k(Class<?> cls, p$b p_b) {
        Objects.requireNonNull(f(cls));
        return p_b;
    }

    public abstract z$a l();

    public abstract g0<?> m(Class<?> cls, b.g.a.c.c0.c cVar);

    public b.g.a.c.c n(b.g.a.c.j jVar) {
        r rVar = (r) this._base._classIntrospector;
        q qVarA = rVar.a(this, jVar);
        return qVarA == null ? q.e(this, jVar, rVar.b(this, jVar, this)) : qVarA;
    }

    public b.g.a.c.c o(Class<?> cls) {
        return n(this._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l));
    }

    public final boolean p() {
        return q(p.USE_ANNOTATIONS);
    }

    public final boolean q(p pVar) {
        return pVar.h(this._mapperFeatures);
    }

    public l(l<T> lVar, int i) {
        this._base = lVar._base;
        this._mapperFeatures = i;
    }
}
