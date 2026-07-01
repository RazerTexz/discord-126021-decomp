package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: ClassDescriptorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends a {
    public final d0.e0.p.d.m0.c.m o;
    public final u0 p;
    public final boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.g.e eVar, u0 u0Var, boolean z2) {
        super(oVar, eVar);
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
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
        this.o = mVar;
        this.p = u0Var;
        this.q = z2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        d0.e0.p.d.m0.c.m mVar = this.o;
        if (mVar != null) {
            return mVar;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.p
    public u0 getSource() {
        u0 u0Var = this.p;
        if (u0Var != null) {
            return u0Var;
        }
        a(5);
        throw null;
    }

    public boolean isExternal() {
        return this.q;
    }
}
