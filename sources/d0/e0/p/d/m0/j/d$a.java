package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.j0;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import kotlin.Unit;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a implements d0.e0.p.d.m0.c.o<Unit, StringBuilder> {
    public final /* synthetic */ d a;

    public d$a(d dVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "this$0");
        this.a = dVar;
    }

    public final void a(m0 m0Var, StringBuilder sb, String str) {
        int iOrdinal = this.a.getPropertyAccessorRenderingPolicy().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            visitFunctionDescriptor2((x) m0Var, sb);
        } else {
            d.access$renderAccessorModifiers(this.a, m0Var, sb);
            sb.append(d0.z.d.m.stringPlus(str, " for "));
            d dVar = this.a;
            n0 correspondingProperty = m0Var.getCorrespondingProperty();
            d0.z.d.m.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
            d.access$renderProperty(dVar, correspondingProperty, sb);
        }
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitClassDescriptor(d0.e0.p.d.m0.c.e eVar, StringBuilder sb) {
        visitClassDescriptor2(eVar, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(d0.e0.p.d.m0.c.l lVar, StringBuilder sb) {
        visitConstructorDescriptor2(lVar, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(x xVar, StringBuilder sb) {
        visitFunctionDescriptor2(xVar, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(c0 c0Var, StringBuilder sb) {
        visitModuleDeclaration2(c0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(e0 e0Var, StringBuilder sb) {
        visitPackageFragmentDescriptor2(e0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(j0 j0Var, StringBuilder sb) {
        visitPackageViewDescriptor2(j0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(n0 n0Var, StringBuilder sb) {
        visitPropertyDescriptor2(n0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(o0 o0Var, StringBuilder sb) {
        visitPropertyGetterDescriptor2(o0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(p0 p0Var, StringBuilder sb) {
        visitPropertySetterDescriptor2(p0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(q0 q0Var, StringBuilder sb) {
        visitReceiverParameterDescriptor2(q0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(y0 y0Var, StringBuilder sb) {
        visitTypeAliasDescriptor2(y0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(z0 z0Var, StringBuilder sb) {
        visitTypeParameterDescriptor2(z0Var, sb);
        return Unit.a;
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(c1 c1Var, StringBuilder sb) {
        visitValueParameterDescriptor2(c1Var, sb);
        return Unit.a;
    }

    /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
    public void visitClassDescriptor2(d0.e0.p.d.m0.c.e eVar, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(eVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderClass(this.a, eVar, sb);
    }

    /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
    public void visitConstructorDescriptor2(d0.e0.p.d.m0.c.l lVar, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(lVar, "constructorDescriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderConstructor(this.a, lVar, sb);
    }

    /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
    public void visitFunctionDescriptor2(x xVar, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderFunction(this.a, xVar, sb);
    }

    /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
    public void visitModuleDeclaration2(c0 c0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(c0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderName(this.a, c0Var, sb, true);
    }

    /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
    public void visitPackageFragmentDescriptor2(e0 e0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(e0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderPackageFragment(this.a, e0Var, sb);
    }

    /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
    public void visitPackageViewDescriptor2(j0 j0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(j0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderPackageView(this.a, j0Var, sb);
    }

    /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
    public void visitPropertyDescriptor2(n0 n0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderProperty(this.a, n0Var, sb);
    }

    /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
    public void visitPropertyGetterDescriptor2(o0 o0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(o0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        a(o0Var, sb, "getter");
    }

    /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
    public void visitPropertySetterDescriptor2(p0 p0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(p0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        a(p0Var, sb, "setter");
    }

    /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
    public void visitReceiverParameterDescriptor2(q0 q0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(q0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        sb.append(q0Var.getName());
    }

    /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
    public void visitTypeAliasDescriptor2(y0 y0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(y0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderTypeAlias(this.a, y0Var, sb);
    }

    /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
    public void visitTypeParameterDescriptor2(z0 z0Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(z0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderTypeParameter(this.a, z0Var, sb, true);
    }

    /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
    public void visitValueParameterDescriptor2(c1 c1Var, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(c1Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        d.access$renderValueParameter(this.a, c1Var, true, sb, true);
    }
}
