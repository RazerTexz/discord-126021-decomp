package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: VariableDescriptorWithInitializerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends m0 {
    public final boolean o;
    public d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, boolean z2, u0 u0Var) {
        super(mVar, gVar, eVar, c0Var, u0Var);
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
        this.o = z2;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.c.d1
    public d0.e0.p.d.m0.k.v.g<?> getCompileTimeInitializer() {
        d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> kVar = this.p;
        if (kVar != null) {
            return kVar.invoke();
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.d1
    public boolean isVar() {
        return this.o;
    }

    public void setCompileTimeInitializer(d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> kVar) {
        if (kVar != null) {
            this.p = kVar;
        } else {
            a(4);
            throw null;
        }
    }
}
