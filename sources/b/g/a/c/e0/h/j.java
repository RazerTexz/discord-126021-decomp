package b.g.a.c.e0.h;

import b.g.a.a.c0$a;
import b.g.a.a.c0$b;
import b.g.a.c.p;
import b.g.a.c.v;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: StdTypeResolverBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements b.g.a.c.e0.f<j> {
    public b.g.a.c.e0.e _customIdResolver;
    public c0$b _idType;
    public c0$a _includeAs;
    public String _typeProperty;

    @Override // b.g.a.c.e0.f
    public b.g.a.c.e0.f a(boolean z2) {
        return this;
    }

    @Override // b.g.a.c.e0.f
    public /* bridge */ /* synthetic */ b.g.a.c.e0.f b(c0$b c0_b, b.g.a.c.e0.e eVar) {
        g(c0_b, eVar);
        return this;
    }

    @Override // b.g.a.c.e0.f
    public b.g.a.c.e0.f c(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.f();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // b.g.a.c.e0.f
    public b.g.a.c.e0.f d(Class cls) {
        return this;
    }

    @Override // b.g.a.c.e0.f
    public b.g.a.c.e0.g e(v vVar, b.g.a.c.j jVar, Collection<b.g.a.c.e0.b> collection) {
        if (this._idType == c0$b.NONE || jVar._class.isPrimitive()) {
            return null;
        }
        b.g.a.c.e0.c aVar = vVar._base._typeValidator;
        if (aVar == g.j && vVar.q(p.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            aVar = new b.g.a.c.e0.a();
        }
        b.g.a.c.e0.e fVar = this._customIdResolver;
        if (fVar == null) {
            c0$b c0_b = this._idType;
            if (c0_b == null) {
                throw new IllegalStateException("Cannot build, 'init()' not yet called");
            }
            int iOrdinal = c0_b.ordinal();
            if (iOrdinal == 0) {
                fVar = null;
            } else if (iOrdinal == 1) {
                fVar = new f(jVar, vVar._base._typeFactory, aVar);
            } else if (iOrdinal == 2) {
                fVar = new h(jVar, vVar._base._typeFactory, aVar);
            } else if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    StringBuilder sbU = b.d.b.a.a.U("Do not know how to construct standard type id resolver for idType: ");
                    sbU.append(this._idType);
                    throw new IllegalStateException(sbU.toString());
                }
                fVar = new f(jVar, vVar._base._typeFactory, aVar);
            } else {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                vVar.q(p.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (collection != null) {
                    for (b.g.a.c.e0.b bVar : collection) {
                        Class<?> cls = bVar._class;
                        concurrentHashMap.put(cls.getName(), bVar.a() ? bVar._name : l.d(cls));
                    }
                }
                fVar = new l(vVar, jVar, concurrentHashMap, null);
            }
        }
        if (this._idType == c0$b.DEDUCTION) {
            return new b(fVar, null, this._typeProperty);
        }
        int iOrdinal2 = this._includeAs.ordinal();
        if (iOrdinal2 == 0) {
            return new d(fVar, null, this._typeProperty);
        }
        if (iOrdinal2 == 1) {
            return new e(fVar, null);
        }
        if (iOrdinal2 == 2) {
            return new a(fVar, null);
        }
        if (iOrdinal2 == 3) {
            return new c(fVar, null, this._typeProperty);
        }
        if (iOrdinal2 == 4) {
            return new b(fVar, null, this._typeProperty);
        }
        StringBuilder sbU2 = b.d.b.a.a.U("Do not know how to construct standard type serializer for inclusion type: ");
        sbU2.append(this._includeAs);
        throw new IllegalStateException(sbU2.toString());
    }

    @Override // b.g.a.c.e0.f
    public b.g.a.c.e0.f f(c0$a c0_a) {
        if (c0_a == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = c0_a;
        return this;
    }

    public j g(c0$b c0_b, b.g.a.c.e0.e eVar) {
        if (c0_b == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = c0_b;
        this._customIdResolver = eVar;
        this._typeProperty = c0_b.f();
        return this;
    }
}
