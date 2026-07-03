package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.y0 */
/* JADX INFO: compiled from: TypeProjectionImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12016y0 extends AbstractC12014x0 {

    /* JADX INFO: renamed from: a */
    public final EnumC11935j1 f24894a;

    /* JADX INFO: renamed from: b */
    public final AbstractC11913c0 f24895b;

    public C12016y0(EnumC11935j1 enumC11935j1, AbstractC11913c0 abstractC11913c0) {
        if (enumC11935j1 == null) {
            m10039a(0);
            throw null;
        }
        if (abstractC11913c0 == null) {
            m10039a(1);
            throw null;
        }
        this.f24894a = enumC11935j1;
        this.f24895b = abstractC11913c0;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10039a(int i) {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public EnumC11935j1 getProjectionKind() {
        EnumC11935j1 enumC11935j1 = this.f24894a;
        if (enumC11935j1 != null) {
            return enumC11935j1;
        }
        m10039a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public AbstractC11913c0 getType() {
        AbstractC11913c0 abstractC11913c0 = this.f24895b;
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        m10039a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public boolean isStarProjection() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0
    public InterfaceC12012w0 refine(AbstractC11947g abstractC11947g) {
        if (abstractC11947g != null) {
            return new C12016y0(this.f24894a, abstractC11947g.refineType(this.f24895b));
        }
        m10039a(6);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12016y0(AbstractC11913c0 abstractC11913c0) {
        this(EnumC11935j1.INVARIANT, abstractC11913c0);
        if (abstractC11913c0 != null) {
        } else {
            m10039a(2);
            throw null;
        }
    }
}
