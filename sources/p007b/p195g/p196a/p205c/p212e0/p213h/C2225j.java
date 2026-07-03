package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2211c;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p212e0.C2209a;
import p007b.p195g.p196a.p205c.p212e0.C2210b;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f;

/* JADX INFO: renamed from: b.g.a.c.e0.h.j */
/* JADX INFO: compiled from: StdTypeResolverBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2225j implements InterfaceC2214f<C2225j> {
    public InterfaceC2213e _customIdResolver;
    public InterfaceC2070c0.b _idType;
    public InterfaceC2070c0.a _includeAs;
    public String _typeProperty;

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: a */
    public InterfaceC2214f mo1949a(boolean z2) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ InterfaceC2214f mo1950b(InterfaceC2070c0.b bVar, InterfaceC2213e interfaceC2213e) {
        m1966g(bVar, interfaceC2213e);
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: c */
    public InterfaceC2214f mo1951c(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.m1594f();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: d */
    public InterfaceC2214f mo1952d(Class cls) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: e */
    public AbstractC2215g mo1953e(C2372v c2372v, AbstractC2360j abstractC2360j, Collection<C2210b> collection) {
        if (this._idType == InterfaceC2070c0.b.NONE || abstractC2360j._class.isPrimitive()) {
            return null;
        }
        AbstractC2211c c2209a = c2372v._base._typeValidator;
        if (c2209a == C2222g.f4772j && c2372v.m2279q(EnumC2366p.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            c2209a = new C2209a();
        }
        InterfaceC2213e c2221f = this._customIdResolver;
        if (c2221f == null) {
            InterfaceC2070c0.b bVar = this._idType;
            if (bVar == null) {
                throw new IllegalStateException("Cannot build, 'init()' not yet called");
            }
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 0) {
                c2221f = null;
            } else if (iOrdinal == 1) {
                c2221f = new C2221f(abstractC2360j, c2372v._base._typeFactory, c2209a);
            } else if (iOrdinal == 2) {
                c2221f = new C2223h(abstractC2360j, c2372v._base._typeFactory, c2209a);
            } else if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    StringBuilder sbM833U = C1643a.m833U("Do not know how to construct standard type id resolver for idType: ");
                    sbM833U.append(this._idType);
                    throw new IllegalStateException(sbM833U.toString());
                }
                c2221f = new C2221f(abstractC2360j, c2372v._base._typeFactory, c2209a);
            } else {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                c2372v.m2279q(EnumC2366p.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (collection != null) {
                    for (C2210b c2210b : collection) {
                        Class<?> cls = c2210b._class;
                        concurrentHashMap.put(cls.getName(), c2210b.m1944a() ? c2210b._name : C2227l.m1967d(cls));
                    }
                }
                c2221f = new C2227l(c2372v, abstractC2360j, concurrentHashMap, null);
            }
        }
        if (this._idType == InterfaceC2070c0.b.DEDUCTION) {
            return new C2217b(c2221f, null, this._typeProperty);
        }
        int iOrdinal2 = this._includeAs.ordinal();
        if (iOrdinal2 == 0) {
            return new C2219d(c2221f, null, this._typeProperty);
        }
        if (iOrdinal2 == 1) {
            return new C2220e(c2221f, null);
        }
        if (iOrdinal2 == 2) {
            return new C2216a(c2221f, null);
        }
        if (iOrdinal2 == 3) {
            return new C2218c(c2221f, null, this._typeProperty);
        }
        if (iOrdinal2 == 4) {
            return new C2217b(c2221f, null, this._typeProperty);
        }
        StringBuilder sbM833U2 = C1643a.m833U("Do not know how to construct standard type serializer for inclusion type: ");
        sbM833U2.append(this._includeAs);
        throw new IllegalStateException(sbM833U2.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f
    /* JADX INFO: renamed from: f */
    public InterfaceC2214f mo1954f(InterfaceC2070c0.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = aVar;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public C2225j m1966g(InterfaceC2070c0.b bVar, InterfaceC2213e interfaceC2213e) {
        if (bVar == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = bVar;
        this._customIdResolver = interfaceC2213e;
        this._typeProperty = bVar.m1594f();
        return this;
    }
}
