package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: DeclarationDescriptorNonRootImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k implements d0.e0.p.d.m0.c.n {
    public final d0.e0.p.d.m0.c.m l;
    public final u0 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, u0 u0Var) {
        super(gVar, eVar);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (u0Var == null) {
            a(3);
            throw null;
        }
        this.l = mVar;
        this.m = u0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        d0.e0.p.d.m0.c.m mVar = this.l;
        if (mVar != null) {
            return mVar;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    public u0 getSource() {
        u0 u0Var = this.m;
        if (u0Var != null) {
            return u0Var;
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.p getOriginal() {
        d0.e0.p.d.m0.c.p pVar = (d0.e0.p.d.m0.c.p) super.getOriginal();
        if (pVar != null) {
            return pVar;
        }
        a(4);
        throw null;
    }
}
