package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p198b.InterfaceC2114j;
import p007b.p195g.p196a.p198b.p204t.C2142d;
import p007b.p195g.p196a.p205c.p210c0.C2176b0;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2180d0;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p210c0.C2197r;
import p007b.p195g.p196a.p205c.p210c0.C2202w;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2212d;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2242k;
import p007b.p195g.p196a.p205c.p218h0.C2322a;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2354p;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;
import p007b.p195g.p196a.p205c.p221z.AbstractC2395m;
import p007b.p195g.p196a.p205c.p221z.C2383a;
import p007b.p195g.p196a.p205c.p221z.C2389g;

/* JADX INFO: renamed from: b.g.a.c.v */
/* JADX INFO: compiled from: SerializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2372v extends AbstractC2395m<EnumC2373w, C2372v> implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final InterfaceC2114j f5033l = new C2142d();

    /* JADX INFO: renamed from: m */
    public static final int f5034m = AbstractC2394l.m2264c(EnumC2373w.class);
    private static final long serialVersionUID = 1;
    public final InterfaceC2114j _defaultPrettyPrinter;
    public final AbstractC2242k _filterProvider;
    public final int _formatWriteFeatures;
    public final int _formatWriteFeaturesToChange;
    public final int _generatorFeatures;
    public final int _generatorFeaturesToChange;
    public final int _serFeatures;

    public C2372v(C2383a c2383a, AbstractC2212d abstractC2212d, C2180d0 c2180d0, C2354p c2354p, C2389g c2389g) {
        super(c2383a, abstractC2212d, c2180d0, c2354p, c2389g);
        this._serFeatures = f5034m;
        this._defaultPrettyPrinter = f5033l;
        this._generatorFeatures = 0;
        this._generatorFeaturesToChange = 0;
        this._formatWriteFeatures = 0;
        this._formatWriteFeaturesToChange = 0;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2395m
    /* JADX INFO: renamed from: r */
    public AbstractC2395m mo1969r(int i) {
        return new C2372v(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange, this._formatWriteFeatures, this._formatWriteFeaturesToChange);
    }

    /* JADX INFO: renamed from: u */
    public AbstractC2172c m2236u(AbstractC2360j abstractC2360j) {
        C2202w c2202w;
        C2197r c2197r = (C2197r) this._base._classIntrospector;
        C2196q c2196qM1920a = c2197r.m1920a(this, abstractC2360j);
        if (c2196qM1920a != null) {
            return c2196qM1920a;
        }
        boolean z2 = false;
        if (abstractC2360j.mo2104v() && !(abstractC2360j instanceof C2322a)) {
            Class<?> cls = abstractC2360j._class;
            if (C2342d.m2186r(cls) && (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls))) {
                z2 = true;
            }
        }
        C2196q c2196qM1918e = z2 ? C2196q.m1918e(this, abstractC2360j, c2197r.m1921b(this, abstractC2360j, this)) : null;
        if (c2196qM1918e != null) {
            return c2196qM1918e;
        }
        C2177c c2177cM1921b = c2197r.m1921b(this, abstractC2360j, this);
        if (abstractC2360j.m2215A()) {
            Objects.requireNonNull((C2202w.b) this._base._accessorNaming);
            c2202w = new C2202w.c(this, c2177cM1921b);
        } else {
            C2202w.b bVar = (C2202w.b) this._base._accessorNaming;
            c2202w = new C2202w(this, c2177cM1921b, bVar._setterPrefix, bVar._getterPrefix, bVar._isGetterPrefix, bVar._baseNameValidator);
        }
        return new C2196q(new C2176b0(this, true, abstractC2360j, c2177cM1921b, c2202w));
    }

    /* JADX INFO: renamed from: v */
    public final boolean m2237v(EnumC2373w enumC2373w) {
        return (enumC2373w.mo2091g() & this._serFeatures) != 0;
    }

    public C2372v(C2372v c2372v, int i, int i2, int i3, int i4, int i5, int i6) {
        super(c2372v, i);
        this._serFeatures = i2;
        this._defaultPrettyPrinter = c2372v._defaultPrettyPrinter;
        this._generatorFeatures = i3;
        this._generatorFeaturesToChange = i4;
        this._formatWriteFeatures = i5;
        this._formatWriteFeaturesToChange = i6;
    }
}
