package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2073e;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2091n;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2104z;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2180d0;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2186g0;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2212d;
import p007b.p195g.p196a.p205c.p219i0.C2354p;
import p007b.p195g.p196a.p205c.p221z.AbstractC2395m;
import p007b.p195g.p196a.p205c.p221z.InterfaceC2387e;

/* JADX INFO: renamed from: b.g.a.c.z.m */
/* JADX INFO: compiled from: MapperConfigBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2395m<CFG extends InterfaceC2387e, T extends AbstractC2395m<CFG, T>> extends AbstractC2394l<T> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final int f5095j = AbstractC2394l.m2264c(EnumC2366p.class);

    /* JADX INFO: renamed from: k */
    public static final int f5096k = (((EnumC2366p.AUTO_DETECT_FIELDS.mo2091g() | EnumC2366p.AUTO_DETECT_GETTERS.mo2091g()) | EnumC2366p.AUTO_DETECT_IS_GETTERS.mo2091g()) | EnumC2366p.AUTO_DETECT_SETTERS.mo2091g()) | EnumC2366p.AUTO_DETECT_CREATORS.mo2091g();
    public final AbstractC2391i _attributes;
    public final C2389g _configOverrides;
    public final C2180d0 _mixIns;
    public final C2370t _rootName;
    public final C2354p _rootNames;
    public final AbstractC2212d _subtypeResolver;
    public final Class<?> _view;

    public AbstractC2395m(C2383a c2383a, AbstractC2212d abstractC2212d, C2180d0 c2180d0, C2354p c2354p, C2389g c2389g) {
        super(c2383a, f5095j);
        this._mixIns = c2180d0;
        this._subtypeResolver = abstractC2212d;
        this._rootNames = c2354p;
        this._rootName = null;
        this._view = null;
        this._attributes = AbstractC2391i.a.f5087j;
        this._configOverrides = c2389g;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2199t.a
    /* JADX INFO: renamed from: a */
    public final Class<?> mo1885a(Class<?> cls) {
        return this._mixIns.mo1885a(cls);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: f */
    public final AbstractC2388f mo2268f(Class<?> cls) {
        AbstractC2388f abstractC2388fM2263a = this._configOverrides.m2263a(cls);
        return abstractC2388fM2263a == null ? AbstractC2388f.a.f5081a : abstractC2388fM2263a;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: g */
    public final InterfaceC2094p.b mo2269g(Class<?> cls, Class<?> cls2) {
        this._configOverrides.m2263a(cls2);
        InterfaceC2094p.b bVarMo2272j = mo2272j(cls);
        if (bVarMo2272j == null) {
            return null;
        }
        return bVarMo2272j.m1618a(null);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: h */
    public Boolean mo2270h() {
        return this._configOverrides._defaultMergeable;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: i */
    public final InterfaceC2081i.d mo2271i(Class<?> cls) {
        C2389g c2389g = this._configOverrides;
        Map<Class<?>, ?> map = c2389g._overrides;
        if (map != null) {
        }
        Boolean bool = c2389g._defaultLeniency;
        if (bool == null) {
            return InterfaceC2081i.d.f4421j;
        }
        return new InterfaceC2081i.d("", null, null, null, null, InterfaceC2081i.b.f4406a, Boolean.valueOf(bool.booleanValue()));
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: j */
    public final InterfaceC2094p.b mo2272j(Class<?> cls) {
        this._configOverrides.m2263a(cls);
        InterfaceC2094p.b bVar = this._configOverrides._defaultInclusion;
        if (bVar == null) {
            return null;
        }
        return bVar.m1618a(null);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: l */
    public final InterfaceC2104z.a mo2274l() {
        return this._configOverrides._defaultSetterInfo;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2394l
    /* JADX INFO: renamed from: m */
    public final InterfaceC2186g0<?> mo2275m(Class<?> cls, C2177c c2177c) {
        InterfaceC2186g0<?> aVar;
        InterfaceC2186g0.a aVar2;
        InterfaceC2186g0.a aVar3;
        InterfaceC2186g0.a aVar4;
        InterfaceC2186g0.a aVar5;
        InterfaceC2186g0.a aVar6;
        InterfaceC2073e.a aVar7 = InterfaceC2073e.a.NONE;
        InterfaceC2186g0<?> interfaceC2186g0 = this._configOverrides._visibilityChecker;
        int i = this._mapperFeatures;
        int i2 = f5096k;
        InterfaceC2186g0<?> aVar8 = interfaceC2186g0;
        if ((i & i2) != i2) {
            if (!m2279q(EnumC2366p.AUTO_DETECT_FIELDS)) {
                aVar6 = (InterfaceC2186g0.a) interfaceC2186g0;
                if (aVar6._fieldMinLevel != aVar7) {
                    aVar = interfaceC2186g0;
                    aVar = aVar6;
                    aVar = new InterfaceC2186g0.a(aVar6._getterMinLevel, aVar6._isGetterMinLevel, aVar6._setterMinLevel, aVar6._creatorMinLevel, aVar7);
                }
            }
            aVar = interfaceC2186g0;
            aVar = aVar6;
            aVar = interfaceC2186g0;
            InterfaceC2186g0<?> aVar9 = aVar;
            if (!m2279q(EnumC2366p.AUTO_DETECT_GETTERS)) {
                aVar5 = (InterfaceC2186g0.a) aVar;
                if (aVar5._getterMinLevel != aVar7) {
                    aVar9 = aVar5;
                    aVar9 = new InterfaceC2186g0.a(aVar7, aVar5._isGetterMinLevel, aVar5._setterMinLevel, aVar5._creatorMinLevel, aVar5._fieldMinLevel);
                }
            }
            aVar9 = aVar5;
            InterfaceC2186g0<?> aVar10 = aVar9;
            if (!m2279q(EnumC2366p.AUTO_DETECT_IS_GETTERS)) {
                aVar4 = (InterfaceC2186g0.a) aVar9;
                if (aVar4._isGetterMinLevel != aVar7) {
                    aVar10 = aVar4;
                    aVar10 = new InterfaceC2186g0.a(aVar4._getterMinLevel, aVar7, aVar4._setterMinLevel, aVar4._creatorMinLevel, aVar4._fieldMinLevel);
                }
            }
            aVar10 = aVar4;
            InterfaceC2186g0<?> aVar11 = aVar10;
            if (!m2279q(EnumC2366p.AUTO_DETECT_SETTERS)) {
                aVar3 = (InterfaceC2186g0.a) aVar10;
                if (aVar3._setterMinLevel != aVar7) {
                    aVar11 = aVar3;
                    aVar11 = new InterfaceC2186g0.a(aVar3._getterMinLevel, aVar3._isGetterMinLevel, aVar7, aVar3._creatorMinLevel, aVar3._fieldMinLevel);
                }
            }
            aVar11 = aVar3;
            aVar8 = aVar11;
            if (!m2279q(EnumC2366p.AUTO_DETECT_CREATORS)) {
                aVar2 = (InterfaceC2186g0.a) aVar11;
                if (aVar2._creatorMinLevel != aVar7) {
                    aVar8 = aVar2;
                    aVar8 = new InterfaceC2186g0.a(aVar2._getterMinLevel, aVar2._isGetterMinLevel, aVar2._setterMinLevel, aVar7, aVar2._fieldMinLevel);
                }
            }
        }
        aVar8 = aVar2;
        AbstractC2165b abstractC2165bM2267e = m2267e();
        InterfaceC2186g0<?> interfaceC2186g0Mo1773b = aVar8;
        if (abstractC2165bM2267e != null) {
            interfaceC2186g0Mo1773b = abstractC2165bM2267e.mo1773b(c2177c, aVar8);
        }
        if (this._configOverrides.m2263a(cls) == null) {
            return interfaceC2186g0Mo1773b;
        }
        InterfaceC2186g0.a aVar12 = (InterfaceC2186g0.a) interfaceC2186g0Mo1773b;
        Objects.requireNonNull(aVar12);
        return aVar12;
    }

    /* JADX INFO: renamed from: r */
    public abstract T mo1969r(int i);

    /* JADX INFO: renamed from: s */
    public final InterfaceC2091n.a m2280s(Class<?> cls, C2177c c2177c) {
        AbstractC2165b abstractC2165bM2267e = m2267e();
        InterfaceC2091n.a aVarMo1800x = abstractC2165bM2267e == null ? null : abstractC2165bM2267e.mo1800x(this, c2177c);
        this._configOverrides.m2263a(cls);
        InterfaceC2091n.a aVar = InterfaceC2091n.a.f4427j;
        if (aVarMo1800x == null) {
            return null;
        }
        return aVarMo1800x;
    }

    /* JADX INFO: renamed from: t */
    public final T m2281t(EnumC2366p... enumC2366pArr) {
        int i = this._mapperFeatures;
        for (EnumC2366p enumC2366p : enumC2366pArr) {
            i &= ~enumC2366p.mo2091g();
        }
        return i == this._mapperFeatures ? this : (T) mo1969r(i);
    }

    public AbstractC2395m(AbstractC2395m<CFG, T> abstractC2395m, int i) {
        super(abstractC2395m, i);
        this._mixIns = abstractC2395m._mixIns;
        this._subtypeResolver = abstractC2395m._subtypeResolver;
        this._rootNames = abstractC2395m._rootNames;
        this._rootName = abstractC2395m._rootName;
        this._view = abstractC2395m._view;
        this._attributes = abstractC2395m._attributes;
        this._configOverrides = abstractC2395m._configOverrides;
    }
}
