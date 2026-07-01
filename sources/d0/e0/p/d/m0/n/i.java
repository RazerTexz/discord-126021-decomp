package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.x0$a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ClassTypeConstructorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends b implements u0 {
    public final d0.e0.p.d.m0.c.e c;
    public final List<d0.e0.p.d.m0.c.z0> d;
    public final Collection<c0> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.c.e eVar, List<? extends d0.e0.p.d.m0.c.z0> list, Collection<c0> collection, d0.e0.p.d.m0.m.o oVar) {
        super(oVar);
        if (eVar == null) {
            g(0);
            throw null;
        }
        if (list == null) {
            g(1);
            throw null;
        }
        if (collection == null) {
            g(2);
            throw null;
        }
        if (oVar == null) {
            g(3);
            throw null;
        }
        this.c = eVar;
        this.d = Collections.unmodifiableList(new ArrayList(list));
        this.e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void g(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.g
    public Collection<c0> a() {
        Collection<c0> collection = this.e;
        if (collection != null) {
            return collection;
        }
        g(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.g
    public d0.e0.p.d.m0.c.x0 d() {
        return x0$a.a;
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<d0.e0.p.d.m0.c.z0> getParameters() {
        List<d0.e0.p.d.m0.c.z0> list = this.d;
        if (list != null) {
            return list;
        }
        g(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return d0.e0.p.d.m0.k.e.getFqName(this.c).asString();
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.e getDeclarationDescriptor() {
        d0.e0.p.d.m0.c.e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        g(5);
        throw null;
    }
}
