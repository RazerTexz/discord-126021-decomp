package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k */
/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11563k {

    /* JADX INFO: renamed from: a */
    public static final C11563k f23436a = new C11563k();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k$a */
    /* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
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
            return C11563k.this.hasBuiltinSpecialPropertyFqName(interfaceC11321b);
        }
    }

    public final String getBuiltinSpecialPropertyGetterName(InterfaceC11321b interfaceC11321b) {
        C11716e c11716e;
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        AbstractC11288h.isBuiltIn(interfaceC11321b);
        InterfaceC11321b interfaceC11321bFirstOverridden$default = C11836a.firstOverridden$default(C11836a.getPropertyIfAccessor(interfaceC11321b), false, new a(), 1, null);
        if (interfaceC11321bFirstOverridden$default == null || (c11716e = C11522i.f23276a.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(C11836a.getFqNameSafe(interfaceC11321bFirstOverridden$default))) == null) {
            return null;
        }
        return c11716e.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "callableMemberDescriptor");
        C11522i c11522i = C11522i.f23276a;
        if (!c11522i.getSPECIAL_SHORT_NAMES().contains(interfaceC11321b.getName())) {
            return false;
        }
        if (!C12163u.contains(c11522i.getSPECIAL_FQ_NAMES(), C11836a.fqNameOrNull(interfaceC11321b)) || !interfaceC11321b.getValueParameters().isEmpty()) {
            if (!AbstractC11288h.isBuiltIn(interfaceC11321b)) {
                return false;
            }
            Collection<? extends InterfaceC11321b> overriddenDescriptors = interfaceC11321b.getOverriddenDescriptors();
            C12238m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            if (overriddenDescriptors.isEmpty()) {
                return false;
            }
            for (InterfaceC11321b interfaceC11321b2 : overriddenDescriptors) {
                C12238m.checkNotNullExpressionValue(interfaceC11321b2, "it");
                if (hasBuiltinSpecialPropertyFqName(interfaceC11321b2)) {
                }
            }
            return false;
        }
        return true;
    }
}
