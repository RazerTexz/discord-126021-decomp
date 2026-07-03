package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11991o0;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.j */
/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11290j {

    /* JADX INFO: renamed from: a */
    public static final b f22482a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f22483b;

    /* JADX INFO: renamed from: c */
    public final C11328d0 f22484c;

    /* JADX INFO: renamed from: d */
    public final Lazy f22485d;

    /* JADX INFO: renamed from: e */
    public final a f22486e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$a */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f22487a;

        public a(int i) {
            this.f22487a = i;
        }

        public final InterfaceC11330e getValue(C11290j c11290j, KProperty<?> kProperty) {
            C12238m.checkNotNullParameter(c11290j, "types");
            C12238m.checkNotNullParameter(kProperty, "property");
            return C11290j.access$find(c11290j, C12103t.capitalize(kProperty.getName()), this.f22487a);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$b */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11913c0 createKPropertyStarType(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = C11470w.findClassAcrossModuleDependencies(interfaceC11325c0, C11291k.a.f22529Z);
            if (interfaceC11330eFindClassAcrossModuleDependencies == null) {
                return null;
            }
            C11916d0 c11916d0 = C11916d0.f24748a;
            InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
            List<InterfaceC11477z0> parameters = interfaceC11330eFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            C12238m.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objSingle = C12163u.single((List<? extends Object>) parameters);
            C12238m.checkNotNullExpressionValue(objSingle, "kPropertyClass.typeConstructor.parameters.single()");
            return C11916d0.simpleNotNullType(empty, interfaceC11330eFindClassAcrossModuleDependencies, C12145m.listOf(new C11991o0((InterfaceC11477z0) objSingle)));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.j$c */
    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class c extends AbstractC12240o implements Function0<InterfaceC11770i> {
        public final /* synthetic */ InterfaceC11325c0 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC11325c0 interfaceC11325c0) {
            super(0);
            this.$module = interfaceC11325c0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11770i invoke() {
            return this.$module.getPackage(C11291k.f22496i).getMemberScope();
        }
    }

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11290j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f22483b = kPropertyArr;
    }

    public C11290j(InterfaceC11325c0 interfaceC11325c0, C11328d0 c11328d0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        this.f22484c = c11328d0;
        this.f22485d = C12083g.lazy(EnumC12110i.PUBLICATION, new c(interfaceC11325c0));
        this.f22486e = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    public static final InterfaceC11330e access$find(C11290j c11290j, String str, int i) {
        Objects.requireNonNull(c11290j);
        C11716e c11716eIdentifier = C11716e.identifier(str);
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(className)");
        InterfaceC11352h contributedClassifier = ((InterfaceC11770i) c11290j.f22485d.getValue()).getContributedClassifier(c11716eIdentifier, EnumC11482d.FROM_REFLECTION);
        InterfaceC11330e interfaceC11330e = contributedClassifier instanceof InterfaceC11330e ? (InterfaceC11330e) contributedClassifier : null;
        return interfaceC11330e == null ? c11290j.f22484c.getClass(new C11712a(C11291k.f22496i, c11716eIdentifier), C12145m.listOf(Integer.valueOf(i))) : interfaceC11330e;
    }

    public final InterfaceC11330e getKClass() {
        return this.f22486e.getValue(this, f22483b[1]);
    }
}
