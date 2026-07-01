package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.g0.k;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.o0;
import d0.e0.p.d.m0.n.p0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final d0.e0.p.d.m0.g.b a = new d0.e0.p.d.m0.g.b("java.lang.Class");

    public static final /* synthetic */ d0.e0.p.d.m0.g.b access$getJAVA_LANG_CLASS_FQ_NAME$p$s1946801611() {
        return a;
    }

    public static final c0 getErasedUpperBound(z0 z0Var, z0 z0Var2, Function0<? extends c0> function0) {
        m.checkNotNullParameter(z0Var, "<this>");
        m.checkNotNullParameter(function0, "defaultValue");
        if (z0Var == z0Var2) {
            return function0.invoke();
        }
        List<c0> upperBounds = z0Var.getUpperBounds();
        m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        c0 c0Var = (c0) u.first((List) upperBounds);
        if (c0Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.e) {
            m.checkNotNullExpressionValue(c0Var, "firstUpperBound");
            return d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(c0Var);
        }
        if (z0Var2 != null) {
            z0Var = z0Var2;
        }
        h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            z0 z0Var3 = (z0) declarationDescriptor;
            if (m.areEqual(z0Var3, z0Var)) {
                return function0.invoke();
            }
            List<c0> upperBounds2 = z0Var3.getUpperBounds();
            m.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            c0 c0Var2 = (c0) u.first((List) upperBounds2);
            if (c0Var2.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.e) {
                m.checkNotNullExpressionValue(c0Var2, "nextUpperBound");
                return d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(c0Var2);
            }
            declarationDescriptor = c0Var2.getConstructor().getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static /* synthetic */ c0 getErasedUpperBound$default(z0 z0Var, z0 z0Var2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z0Var2 = null;
        }
        if ((i & 2) != 0) {
            function0 = new e$a(z0Var);
        }
        return getErasedUpperBound(z0Var, z0Var2, function0);
    }

    public static final w0 makeStarProjection(z0 z0Var, a aVar) {
        m.checkNotNullParameter(z0Var, "typeParameter");
        m.checkNotNullParameter(aVar, "attr");
        return aVar.getHowThisTypeIsUsed() == k.SUPERTYPE ? new y0(p0.starProjectionType(z0Var)) : new o0(z0Var);
    }

    public static final a toAttributes(k kVar, boolean z2, z0 z0Var) {
        m.checkNotNullParameter(kVar, "<this>");
        return new a(kVar, null, z2, z0Var, 2, null);
    }

    public static /* synthetic */ a toAttributes$default(k kVar, boolean z2, z0 z0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z0Var = null;
        }
        return toAttributes(kVar, z2, z0Var);
    }
}
