package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11513d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11960t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0 */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11492d0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f23192j = new a();

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
            return C11563k.f23436a.hasBuiltinSpecialPropertyFqName(C11836a.getPropertyIfAccessor(interfaceC11321b));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$b */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f23193j = new b();

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
            return C11497g.f23218m.isBuiltinFunctionWithDifferentNameInJvm((InterfaceC11465t0) interfaceC11321b);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$c */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class c extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final c f23194j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11321b interfaceC11321b) {
            return Boolean.valueOf(invoke2(interfaceC11321b));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "it");
            if (AbstractC11288h.isBuiltIn(interfaceC11321b)) {
                C11509h c11509h = C11509h.f23259m;
                if (C11509h.getSpecialSignatureInfo(interfaceC11321b) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName(interfaceC11321b) != null;
    }

    public static final String getJvmMethodNameIfSpecial(InterfaceC11321b interfaceC11321b) {
        C11716e jvmName;
        C12238m.checkNotNullParameter(interfaceC11321b, "callableMemberDescriptor");
        InterfaceC11321b overriddenBuiltinWithDifferentJvmName = AbstractC11288h.isBuiltIn(interfaceC11321b) ? getOverriddenBuiltinWithDifferentJvmName(interfaceC11321b) : null;
        InterfaceC11321b propertyIfAccessor = overriddenBuiltinWithDifferentJvmName == null ? null : C11836a.getPropertyIfAccessor(overriddenBuiltinWithDifferentJvmName);
        if (propertyIfAccessor == null) {
            return null;
        }
        if (propertyIfAccessor instanceof InterfaceC11453n0) {
            return C11563k.f23436a.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof InterfaceC11465t0) || (jvmName = C11497g.f23218m.getJvmName((InterfaceC11465t0) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    public static final <T extends InterfaceC11321b> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        C12238m.checkNotNullParameter(t, "<this>");
        if (!C11494e0.f23195a.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !C11522i.f23276a.getSPECIAL_SHORT_NAMES().contains(C11836a.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if (t instanceof InterfaceC11453n0 ? true : t instanceof InterfaceC11451m0) {
            return (T) C11836a.firstOverridden$default(t, false, a.f23192j, 1, null);
        }
        if (t instanceof InterfaceC11465t0) {
            return (T) C11836a.firstOverridden$default(t, false, b.f23193j, 1, null);
        }
        return null;
    }

    public static final <T extends InterfaceC11321b> T getOverriddenSpecialBuiltin(T t) {
        C12238m.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        C11509h c11509h = C11509h.f23259m;
        C11716e name = t.getName();
        C12238m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (c11509h.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) C11836a.firstOverridden$default(t, false, c.f23194j, 1, null);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(InterfaceC11330e interfaceC11330e, InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
        C12238m.checkNotNullParameter(interfaceC11318a, "specialCallableDescriptor");
        AbstractC11934j0 defaultType = ((InterfaceC11330e) interfaceC11318a.getContainingDeclaration()).getDefaultType();
        C12238m.checkNotNullExpressionValue(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        InterfaceC11330e superClassDescriptor = C11787e.getSuperClassDescriptor(interfaceC11330e);
        while (true) {
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof InterfaceC11513d)) {
                if (C11960t.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                    return !AbstractC11288h.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = C11787e.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        return C11836a.getPropertyIfAccessor(interfaceC11321b).getContainingDeclaration() instanceof InterfaceC11513d;
    }

    public static final boolean isFromJavaOrBuiltins(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        return isFromJava(interfaceC11321b) || AbstractC11288h.isBuiltIn(interfaceC11321b);
    }
}
