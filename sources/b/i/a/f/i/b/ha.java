package b.i.a.f.i.b;

import java.math.BigDecimal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ha extends ea {
    public b.i.a.f.h.l.o0 g;
    public final /* synthetic */ ba h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(ba baVar, String str, int i, b.i.a.f.h.l.o0 o0Var) {
        super(str, i);
        this.h = baVar;
        this.g = o0Var;
    }

    @Override // b.i.a.f.i.b.ea
    public final int a() {
        return this.g.w();
    }

    @Override // b.i.a.f.i.b.ea
    public final boolean g() {
        return true;
    }

    @Override // b.i.a.f.i.b.ea
    public final boolean h() {
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean i(Long l, Long l2, b.i.a.f.h.l.i1 i1Var, boolean z2) {
        boolean z3 = b.i.a.f.h.l.f9.b() && this.h.a.h.u(this.a, p.f1551a0);
        boolean z4 = this.g.z();
        boolean zA = this.g.A();
        boolean zC = this.g.C();
        boolean z5 = z4 || zA || zC;
        Boolean boolC = null;
        Boolean boolF = null;
        boolC = null;
        boolC = null;
        boolC = null;
        boolC = null;
        if (z2 && !z5) {
            this.h.g().n.c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f1531b), this.g.v() ? Integer.valueOf(this.g.w()) : null);
            return true;
        }
        b.i.a.f.h.l.m0 m0VarY = this.g.y();
        boolean zA2 = m0VarY.A();
        if (i1Var.H()) {
            if (m0VarY.x()) {
                boolC = ea.c(ea.b(i1Var.I(), m0VarY.y()), zA2);
            } else {
                this.h.g().i.b("No number filter for long property. property", this.h.d().y(i1Var.D()));
            }
        } else if (i1Var.J()) {
            if (m0VarY.x()) {
                double dK = i1Var.K();
                try {
                    boolF = ea.f(new BigDecimal(dK), m0VarY.y(), Math.ulp(dK));
                } catch (NumberFormatException unused) {
                }
                boolC = ea.c(boolF, zA2);
            } else {
                this.h.g().i.b("No number filter for double property. property", this.h.d().y(i1Var.D()));
            }
        } else if (!i1Var.F()) {
            this.h.g().i.b("User property has no value, property", this.h.d().y(i1Var.D()));
        } else if (m0VarY.v()) {
            boolC = ea.c(ea.e(i1Var.G(), m0VarY.w(), this.h.g()), zA2);
        } else if (!m0VarY.x()) {
            this.h.g().i.b("No string or number filter defined. property", this.h.d().y(i1Var.D()));
        } else if (q9.P(i1Var.G())) {
            boolC = ea.c(ea.d(i1Var.G(), m0VarY.y()), zA2);
        } else {
            this.h.g().i.c("Invalid user property value for Numeric number filter. property, value", this.h.d().y(i1Var.D()), i1Var.G());
        }
        this.h.g().n.b("Property filter result", boolC == null ? "null" : boolC);
        if (boolC == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (zC && !boolC.booleanValue()) {
            return true;
        }
        if (!z2 || this.g.z()) {
            this.d = boolC;
        }
        if (boolC.booleanValue() && z5 && i1Var.y()) {
            long jZ = i1Var.z();
            if (l != null) {
                jZ = l.longValue();
            }
            if (z3 && this.g.z() && !this.g.A() && l2 != null) {
                jZ = l2.longValue();
            }
            if (this.g.A()) {
                this.f = Long.valueOf(jZ);
            } else {
                this.e = Long.valueOf(jZ);
            }
        }
        return true;
    }
}
