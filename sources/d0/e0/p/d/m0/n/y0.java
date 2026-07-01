package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: TypeProjectionImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class y0 extends x0 {
    public final j1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3543b;

    public y0(j1 j1Var, c0 c0Var) {
        if (j1Var == null) {
            a(0);
            throw null;
        }
        if (c0Var == null) {
            a(1);
            throw null;
        }
        this.a = j1Var;
        this.f3543b = c0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.n.w0
    public j1 getProjectionKind() {
        j1 j1Var = this.a;
        if (j1Var != null) {
            return j1Var;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public c0 getType() {
        c0 c0Var = this.f3543b;
        if (c0Var != null) {
            return c0Var;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public boolean isStarProjection() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public w0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar != null) {
            return new y0(this.a, gVar.refineType(this.f3543b));
        }
        a(6);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y0(c0 c0Var) {
        this(j1.INVARIANT, c0Var);
        if (c0Var != null) {
        } else {
            a(2);
            throw null;
        }
    }
}
