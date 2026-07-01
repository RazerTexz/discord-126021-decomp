package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$a implements d0.e0.p.d.m0.c.c0 {
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:21:0x002e  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
            switch (i) {
                case 8:
                case 9:
                case 10:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
            switch (i) {
                case 8:
                case 9:
                case 10:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                break;
            case 2:
            case 7:
                objArr[0] = "fqName";
                break;
            case 3:
                objArr[0] = "nameFilter";
                break;
            case 11:
                objArr[0] = "visitor";
                break;
            case 12:
                objArr[0] = "targetModule";
                break;
            default:
                objArr[0] = "capability";
                break;
        }
        if (i == 1) {
            objArr[1] = "getAnnotations";
        } else if (i == 4) {
            objArr[1] = "getSubPackagesOf";
        } else if (i == 5) {
            objArr[1] = "getName";
        } else if (i == 6) {
            objArr[1] = "getStableName";
        } else if (i == 13) {
            objArr[1] = "getOriginal";
        } else if (i != 14) {
            switch (i) {
                case 8:
                    objArr[1] = "getAllDependencyModules";
                    break;
                case 9:
                    objArr[1] = "getExpectedByModules";
                    break;
                case 10:
                    objArr[1] = "getAllExpectedByModules";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
            }
        } else {
            objArr[1] = "getBuiltIns";
        }
        switch (i) {
            case 1:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 13:
            case 14:
                break;
            case 2:
            case 3:
                objArr[2] = "getSubPackagesOf";
                break;
            case 7:
                objArr[2] = "getPackage";
                break;
            case 11:
                objArr[2] = "accept";
                break;
            case 12:
                objArr[2] = "shouldSeeInternalsOf";
                break;
            default:
                objArr[2] = "getCapability";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
            switch (i) {
                case 8:
                case 9:
                case 10:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        if (oVar != null) {
            return null;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        if (empty != null) {
            return empty;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.e eVar = d0.e0.p.d.m0.b.e.getInstance();
        if (eVar != null) {
            return eVar;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public <T> T getCapability(d0.e0.p.d.m0.c.b0<T> b0Var) {
        if (b0Var != null) {
            return null;
        }
        a(0);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public List<d0.e0.p.d.m0.c.c0> getExpectedByModules() {
        List<d0.e0.p.d.m0.c.c0> listEmptyList = d0.t.n.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVarSpecial = d0.e0.p.d.m0.g.e.special("<ERROR MODULE>");
        if (eVarSpecial != null) {
            return eVarSpecial;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getOriginal() {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public d0.e0.p.d.m0.c.j0 getPackage(d0.e0.p.d.m0.g.b bVar) {
        if (bVar != null) {
            throw new IllegalStateException("Should not be called!");
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        if (bVar == null) {
            a(2);
            throw null;
        }
        if (function1 == null) {
            a(3);
            throw null;
        }
        List listEmptyList = d0.t.n.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public boolean shouldSeeInternalsOf(d0.e0.p.d.m0.c.c0 c0Var) {
        if (c0Var != null) {
            return false;
        }
        a(12);
        throw null;
    }
}
