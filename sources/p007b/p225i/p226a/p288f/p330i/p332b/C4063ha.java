package p007b.p225i.p226a.p288f.p330i.p332b;

import java.math.BigDecimal;
import p007b.p225i.p226a.p288f.p313h.p325l.C3657f9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3691i1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3743m0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;

/* JADX INFO: renamed from: b.i.a.f.i.b.ha */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4063ha extends AbstractC4027ea {

    /* JADX INFO: renamed from: g */
    public C3769o0 f10796g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C3991ba f10797h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4063ha(C3991ba c3991ba, String str, int i, C3769o0 c3769o0) {
        super(str, i);
        this.f10797h = c3991ba;
        this.f10796g = c3769o0;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: a */
    public final int mo5593a() {
        return this.f10796g.m5148w();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: g */
    public final boolean mo5594g() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4027ea
    /* JADX INFO: renamed from: h */
    public final boolean mo5595h() {
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
    /* JADX INFO: renamed from: i */
    public final boolean m5662i(Long l, Long l2, C3691i1 c3691i1, boolean z2) {
        boolean z3 = C3657f9.m4881b() && this.f10797h.f11202a.f11260h.m5532u(this.f10698a, C4142p.f11062a0);
        boolean zM5151z = this.f10796g.m5151z();
        boolean zM5144A = this.f10796g.m5144A();
        boolean zM5146C = this.f10796g.m5146C();
        boolean z4 = zM5151z || zM5144A || zM5146C;
        Boolean boolM5589c = null;
        Boolean boolM5592f = null;
        boolM5589c = null;
        boolM5589c = null;
        boolM5589c = null;
        boolM5589c = null;
        if (z2 && !z4) {
            this.f10797h.mo5726g().f11149n.m5862c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f10699b), this.f10796g.m5147v() ? Integer.valueOf(this.f10796g.m5148w()) : null);
            return true;
        }
        C3743m0 c3743m0M5150y = this.f10796g.m5150y();
        boolean zM5062A = c3743m0M5150y.m5062A();
        if (c3691i1.m4952H()) {
            if (c3743m0M5150y.m5067x()) {
                boolM5589c = AbstractC4027ea.m5589c(AbstractC4027ea.m5588b(c3691i1.m4953I(), c3743m0M5150y.m5068y()), zM5062A);
            } else {
                this.f10797h.mo5726g().f11144i.m5861b("No number filter for long property. property", this.f10797h.m5865d().m5769y(c3691i1.m4949D()));
            }
        } else if (c3691i1.m4954J()) {
            if (c3743m0M5150y.m5067x()) {
                double dM4955K = c3691i1.m4955K();
                try {
                    boolM5592f = AbstractC4027ea.m5592f(new BigDecimal(dM4955K), c3743m0M5150y.m5068y(), Math.ulp(dM4955K));
                } catch (NumberFormatException unused) {
                }
                boolM5589c = AbstractC4027ea.m5589c(boolM5592f, zM5062A);
            } else {
                this.f10797h.mo5726g().f11144i.m5861b("No number filter for double property. property", this.f10797h.m5865d().m5769y(c3691i1.m4949D()));
            }
        } else if (!c3691i1.m4950F()) {
            this.f10797h.mo5726g().f11144i.m5861b("User property has no value, property", this.f10797h.m5865d().m5769y(c3691i1.m4949D()));
        } else if (c3743m0M5150y.m5065v()) {
            boolM5589c = AbstractC4027ea.m5589c(AbstractC4027ea.m5591e(c3691i1.m4951G(), c3743m0M5150y.m5066w(), this.f10797h.mo5726g()), zM5062A);
        } else if (!c3743m0M5150y.m5067x()) {
            this.f10797h.mo5726g().f11144i.m5861b("No string or number filter defined. property", this.f10797h.m5865d().m5769y(c3691i1.m4949D()));
        } else if (C4163q9.m5827P(c3691i1.m4951G())) {
            boolM5589c = AbstractC4027ea.m5589c(AbstractC4027ea.m5590d(c3691i1.m4951G(), c3743m0M5150y.m5068y()), zM5062A);
        } else {
            this.f10797h.mo5726g().f11144i.m5862c("Invalid user property value for Numeric number filter. property, value", this.f10797h.m5865d().m5769y(c3691i1.m4949D()), c3691i1.m4951G());
        }
        this.f10797h.mo5726g().f11149n.m5861b("Property filter result", boolM5589c == null ? "null" : boolM5589c);
        if (boolM5589c == null) {
            return false;
        }
        this.f10700c = Boolean.TRUE;
        if (zM5146C && !boolM5589c.booleanValue()) {
            return true;
        }
        if (!z2 || this.f10796g.m5151z()) {
            this.f10701d = boolM5589c;
        }
        if (boolM5589c.booleanValue() && z4 && c3691i1.m4956y()) {
            long jM4957z = c3691i1.m4957z();
            if (l != null) {
                jM4957z = l.longValue();
            }
            if (z3 && this.f10796g.m5151z() && !this.f10796g.m5144A() && l2 != null) {
                jM4957z = l2.longValue();
            }
            if (this.f10796g.m5144A()) {
                this.f10703f = Long.valueOf(jM4957z);
            } else {
                this.f10702e = Long.valueOf(jM4957z);
            }
        }
        return true;
    }
}
