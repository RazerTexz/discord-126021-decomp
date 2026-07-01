package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.y0, reason: use source file name */
/* JADX INFO: compiled from: TypeProjectionImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    public final Variance a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KotlinType f3543b;

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            a(0);
            throw null;
        }
        if (kotlinType == null) {
            a(1);
            throw null;
        }
        this.a = variance;
        this.f3543b = kotlinType;
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

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public Variance getProjectionKind() {
        Variance variance = this.a;
        if (variance != null) {
            return variance;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public KotlinType getType() {
        KotlinType kotlinType = this.f3543b;
        if (kotlinType != null) {
            return kotlinType;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return new TypeProjectionImpl(this.a, kotlinTypeRefiner.refineType(this.f3543b));
        }
        a(6);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(KotlinType kotlinType) {
        this(Variance.INVARIANT, kotlinType);
        if (kotlinType != null) {
        } else {
            a(2);
            throw null;
        }
    }
}
