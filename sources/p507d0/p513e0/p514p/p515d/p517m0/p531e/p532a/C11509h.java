package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11660u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11509h extends C11494e0 {

    /* JADX INFO: renamed from: m */
    public static final C11509h f23259m = new C11509h();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11321b interfaceC11321b) {
            return Boolean.valueOf(invoke2(interfaceC11321b));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "it");
            return C11509h.access$getHasErasedValueParametersInJava(C11509h.this, interfaceC11321b);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h$b */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11321b interfaceC11321b) {
            return Boolean.valueOf(invoke2(interfaceC11321b));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "it");
            return (interfaceC11321b instanceof InterfaceC11472x) && C11509h.access$getHasErasedValueParametersInJava(C11509h.this, interfaceC11321b);
        }
    }

    public static final boolean access$getHasErasedValueParametersInJava(C11509h c11509h, InterfaceC11321b interfaceC11321b) {
        Objects.requireNonNull(c11509h);
        return C12163u.contains(C11494e0.f23195a.getERASED_VALUE_PARAMETERS_SIGNATURES(), C11660u.computeJvmSignature(interfaceC11321b));
    }

    public static final InterfaceC11472x getOverriddenBuiltinFunctionWithErasedValueParametersInJava(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        C11509h c11509h = f23259m;
        C11716e name = interfaceC11472x.getName();
        C12238m.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (c11509h.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (InterfaceC11472x) C11836a.firstOverridden$default(interfaceC11472x, false, c11509h.new a(), 1, null);
        }
        return null;
    }

    public static final C11494e0.b getSpecialSignatureInfo(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        C11494e0.a aVar = C11494e0.f23195a;
        if (!aVar.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(interfaceC11321b.getName())) {
            return null;
        }
        InterfaceC11321b interfaceC11321bFirstOverridden$default = C11836a.firstOverridden$default(interfaceC11321b, false, f23259m.new b(), 1, null);
        String strComputeJvmSignature = interfaceC11321bFirstOverridden$default == null ? null : C11660u.computeJvmSignature(interfaceC11321bFirstOverridden$default);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return aVar.getSpecialSignatureInfo(strComputeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, "<this>");
        return C11494e0.f23195a.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(c11716e);
    }
}
