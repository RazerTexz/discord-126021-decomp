package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11382k0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11387n;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11400z;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.l */
/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11292l {

    /* JADX INFO: renamed from: a */
    public static final C11400z f22572a;

    /* JADX INFO: renamed from: b */
    public static final C11400z f22573b;

    static {
        InterfaceC11325c0 errorModule = C12005t.getErrorModule();
        C12238m.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        C11387n c11387n = new C11387n(errorModule, C11291k.f22492e);
        EnumC11333f enumC11333f = EnumC11333f.INTERFACE;
        C11716e c11716eShortName = C11291k.f22493f.shortName();
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        InterfaceC11905o interfaceC11905o = C11896f.f24710b;
        C11400z c11400z = new C11400z(c11387n, enumC11333f, false, false, c11716eShortName, interfaceC11467u0, interfaceC11905o);
        EnumC11476z enumC11476z = EnumC11476z.ABSTRACT;
        c11400z.setModality(enumC11476z);
        AbstractC11466u abstractC11466u = C11464t.f23087e;
        c11400z.setVisibility(abstractC11466u);
        InterfaceC11344g.a aVar = InterfaceC11344g.f22735f;
        InterfaceC11344g empty = aVar.getEMPTY();
        EnumC11935j1 enumC11935j1 = EnumC11935j1.IN_VARIANCE;
        c11400z.setTypeParameterDescriptors(C12145m.listOf(C11382k0.createWithDefaultBound(c11400z, empty, false, enumC11935j1, C11716e.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, interfaceC11905o)));
        c11400z.createTypeConstructor();
        f22572a = c11400z;
        InterfaceC11325c0 errorModule2 = C12005t.getErrorModule();
        C12238m.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
        C11400z c11400z2 = new C11400z(new C11387n(errorModule2, C11291k.f22491d), enumC11333f, false, false, C11291k.f22494g.shortName(), interfaceC11467u0, interfaceC11905o);
        c11400z2.setModality(enumC11476z);
        c11400z2.setVisibility(abstractC11466u);
        c11400z2.setTypeParameterDescriptors(C12145m.listOf(C11382k0.createWithDefaultBound(c11400z2, aVar.getEMPTY(), false, enumC11935j1, C11716e.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, interfaceC11905o)));
        c11400z2.createTypeConstructor();
        f22573b = c11400z2;
    }

    public static final boolean isContinuation(C11713b c11713b, boolean z2) {
        return z2 ? C12238m.areEqual(c11713b, C11291k.f22494g) : C12238m.areEqual(c11713b, C11291k.f22493f);
    }

    public static final AbstractC11934j0 transformSuspendFunctionToRuntimeFunctionType(AbstractC11913c0 abstractC11913c0, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11913c0, "suspendFunType");
        C11287g.isSuspendFunctionType(abstractC11913c0);
        AbstractC11288h builtIns = C11992a.getBuiltIns(abstractC11913c0);
        InterfaceC11344g annotations = abstractC11913c0.getAnnotations();
        AbstractC11913c0 receiverTypeFromFunctionType = C11287g.getReceiverTypeFromFunctionType(abstractC11913c0);
        List<InterfaceC12012w0> valueParameterTypesFromFunctionType = C11287g.getValueParameterTypesFromFunctionType(abstractC11913c0);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        Iterator<T> it = valueParameterTypesFromFunctionType.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC12012w0) it.next()).getType());
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
        InterfaceC12008u0 typeConstructor = z2 ? f22573b.getTypeConstructor() : f22572a.getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List listPlus = C12163u.plus((Collection<? extends AbstractC11934j0>) arrayList, C11916d0.simpleType$default(empty, typeConstructor, C12145m.listOf(C11992a.asTypeProjection(C11287g.getReturnTypeFromFunctionType(abstractC11913c0))), false, null, 16, null));
        AbstractC11934j0 nullableAnyType = C11992a.getBuiltIns(abstractC11913c0).getNullableAnyType();
        C12238m.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return C11287g.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, listPlus, null, nullableAnyType, (64 & 64) != 0 ? false : false).makeNullableAsSpecified(abstractC11913c0.isMarkedNullable());
    }
}
