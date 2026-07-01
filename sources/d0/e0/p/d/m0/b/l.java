package d0.e0.p.d.m0.b;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.g1.g$a;
import d0.e0.p.d.m0.c.i1.k0;
import d0.e0.p.d.m0.c.i1.z;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.t;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final z a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f3231b;

    static {
        c0 errorModule = t.getErrorModule();
        d0.z.d.m.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        d0.e0.p.d.m0.c.i1.n nVar = new d0.e0.p.d.m0.c.i1.n(errorModule, k.e);
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.INTERFACE;
        d0.e0.p.d.m0.g.e eVarShortName = k.f.shortName();
        u0 u0Var = u0.a;
        d0.e0.p.d.m0.m.o oVar = d0.e0.p.d.m0.m.f.f3514b;
        z zVar = new z(nVar, fVar, false, false, eVarShortName, u0Var, oVar);
        d0.e0.p.d.m0.c.z zVar2 = d0.e0.p.d.m0.c.z.ABSTRACT;
        zVar.setModality(zVar2);
        u uVar = d0.e0.p.d.m0.c.t.e;
        zVar.setVisibility(uVar);
        g$a g_a = d0.e0.p.d.m0.c.g1.g.f;
        d0.e0.p.d.m0.c.g1.g empty = g_a.getEMPTY();
        j1 j1Var = j1.IN_VARIANCE;
        zVar.setTypeParameterDescriptors(d0.t.m.listOf(k0.createWithDefaultBound(zVar, empty, false, j1Var, d0.e0.p.d.m0.g.e.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, oVar)));
        zVar.createTypeConstructor();
        a = zVar;
        c0 errorModule2 = t.getErrorModule();
        d0.z.d.m.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
        z zVar3 = new z(new d0.e0.p.d.m0.c.i1.n(errorModule2, k.d), fVar, false, false, k.g.shortName(), u0Var, oVar);
        zVar3.setModality(zVar2);
        zVar3.setVisibility(uVar);
        zVar3.setTypeParameterDescriptors(d0.t.m.listOf(k0.createWithDefaultBound(zVar3, g_a.getEMPTY(), false, j1Var, d0.e0.p.d.m0.g.e.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, oVar)));
        zVar3.createTypeConstructor();
        f3231b = zVar3;
    }

    public static final boolean isContinuation(d0.e0.p.d.m0.g.b bVar, boolean z2) {
        return z2 ? d0.z.d.m.areEqual(bVar, k.g) : d0.z.d.m.areEqual(bVar, k.f);
    }

    public static final j0 transformSuspendFunctionToRuntimeFunctionType(d0.e0.p.d.m0.n.c0 c0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "suspendFunType");
        g.isSuspendFunctionType(c0Var);
        h builtIns = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var);
        d0.e0.p.d.m0.c.g1.g annotations = c0Var.getAnnotations();
        d0.e0.p.d.m0.n.c0 receiverTypeFromFunctionType = g.getReceiverTypeFromFunctionType(c0Var);
        List<w0> valueParameterTypesFromFunctionType = g.getValueParameterTypesFromFunctionType(c0Var);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        Iterator<T> it = valueParameterTypesFromFunctionType.iterator();
        while (it.hasNext()) {
            arrayList.add(((w0) it.next()).getType());
        }
        d0 d0Var = d0.a;
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        d0.e0.p.d.m0.n.u0 typeConstructor = z2 ? f3231b.getTypeConstructor() : a.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List listPlus = d0.t.u.plus((Collection<? extends j0>) arrayList, d0.simpleType$default(empty, typeConstructor, d0.t.m.listOf(d0.e0.p.d.m0.n.o1.a.asTypeProjection(g.getReturnTypeFromFunctionType(c0Var))), false, null, 16, null));
        j0 nullableAnyType = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var).getNullableAnyType();
        d0.z.d.m.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return g.createFunctionType$default(builtIns, annotations, receiverTypeFromFunctionType, listPlus, null, nullableAnyType, false, 64, null).makeNullableAsSpecified(c0Var.isMarkedNullable());
    }
}
