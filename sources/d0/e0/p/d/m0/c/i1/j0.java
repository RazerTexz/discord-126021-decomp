package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.n.c1;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends q implements i0 {
    public static final j0$a M = new j0$a(null);
    public static final /* synthetic */ KProperty<Object>[] N = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public final d0.e0.p.d.m0.m.o O;
    public final y0 P;
    public d0.e0.p.d.m0.c.d Q;

    public j0(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar, i0 i0Var, d0.e0.p.d.m0.c.g1.g gVar, b$a b_a, u0 u0Var) {
        super(y0Var, i0Var, gVar, d0.e0.p.d.m0.g.e.special("<init>"), b_a, u0Var);
        this.O = oVar;
        this.P = y0Var;
        setActual(getTypeAliasDescriptor().isActual());
        oVar.createNullableLazyValue(new j0$b(this, dVar));
        this.Q = dVar;
    }

    public /* synthetic */ j0(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar, i0 i0Var, d0.e0.p.d.m0.c.g1.g gVar, b$a b_a, u0 u0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, y0Var, dVar, i0Var, gVar, b_a, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public q b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return new j0(this.O, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, gVar, b$a.DECLARATION, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.l
    public d0.e0.p.d.m0.c.e getConstructedClass() {
        d0.e0.p.d.m0.c.e constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        d0.z.d.m.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        d0.e0.p.d.m0.n.c0 returnType = super.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        return returnType;
    }

    public final d0.e0.p.d.m0.m.o getStorageManager() {
        return this.O;
    }

    public y0 getTypeAliasDescriptor() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.c.i1.i0
    public d0.e0.p.d.m0.c.d getUnderlyingConstructorDescriptor() {
        return this.Q;
    }

    @Override // d0.e0.p.d.m0.c.l
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.l substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public i0 copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(zVar, "modality");
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.e0.p.d.m0.c.x xVarBuild = newCopyBuilder().setOwner(mVar).setModality(zVar).setVisibility(uVar).setKind(b_a).setCopyOverrides(z2).build();
        Objects.requireNonNull(xVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) xVarBuild;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public y0 getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public i0 substitute(c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(c1Var, "substitutor");
        d0.e0.p.d.m0.c.x xVarSubstitute = super.substitute(c1Var);
        Objects.requireNonNull(xVarSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        j0 j0Var = (j0) xVarSubstitute;
        c1 c1VarCreate = c1.create(j0Var.getReturnType());
        d0.z.d.m.checkNotNullExpressionValue(c1VarCreate, "create(substitutedTypeAliasConstructor.returnType)");
        d0.e0.p.d.m0.c.d dVarSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(c1VarCreate);
        if (dVarSubstitute == null) {
            return null;
        }
        j0Var.Q = dVarSubstitute;
        return j0Var;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public i0 getOriginal() {
        return (i0) super.getOriginal();
    }
}
