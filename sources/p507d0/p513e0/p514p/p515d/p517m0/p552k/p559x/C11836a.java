package p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11948h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11955o;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a */
/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11836a {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$a */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class a implements C12034b.c<InterfaceC11326c1> {

        /* JADX INFO: renamed from: a */
        public static final a f24455a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.c
        public final Iterable<InterfaceC11326c1> getNeighbors(InterfaceC11326c1 interfaceC11326c1) {
            Collection<InterfaceC11326c1> overriddenDescriptors = interfaceC11326c1.getOverriddenDescriptors();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(overriddenDescriptors, 10));
            Iterator<T> it = overriddenDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11326c1) it.next()).getOriginal());
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$b */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public /* synthetic */ class b extends C12235j implements Function1<InterfaceC11326c1, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f24456j = new b();

        public b() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(InterfaceC11326c1.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11326c1 interfaceC11326c1) {
            return Boolean.valueOf(invoke2(interfaceC11326c1));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11326c1 interfaceC11326c1) {
            C12238m.checkNotNullParameter(interfaceC11326c1, "p0");
            return interfaceC11326c1.declaresDefaultValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$c */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class c implements C12034b.c<InterfaceC11321b> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ boolean f24457a;

        public c(boolean z2) {
            this.f24457a = z2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.c
        public final Iterable<InterfaceC11321b> getNeighbors(InterfaceC11321b interfaceC11321b) {
            if (this.f24457a) {
                interfaceC11321b = interfaceC11321b == null ? null : interfaceC11321b.getOriginal();
            }
            Collection<? extends InterfaceC11321b> overriddenDescriptors = interfaceC11321b != null ? interfaceC11321b.getOverriddenDescriptors() : null;
            return overriddenDescriptors == null ? C12147n.emptyList() : overriddenDescriptors;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$d */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class d extends C12034b.b<InterfaceC11321b, InterfaceC11321b> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Ref$ObjectRef<InterfaceC11321b> f24458a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Function1<InterfaceC11321b, Boolean> f24459b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Ref$ObjectRef<InterfaceC11321b> ref$ObjectRef, Function1<? super InterfaceC11321b, Boolean> function1) {
            this.f24458a = ref$ObjectRef;
            this.f24459b = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.b, p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
        public void afterChildren(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "current");
            if (this.f24458a.element == null && this.f24459b.invoke(interfaceC11321b).booleanValue()) {
                this.f24458a.element = interfaceC11321b;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
        public boolean beforeChildren(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "current");
            return this.f24458a.element == null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
        public InterfaceC11321b result() {
            return this.f24458a.element;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$e */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class e extends AbstractC12240o implements Function1<InterfaceC11450m, InterfaceC11450m> {

        /* JADX INFO: renamed from: j */
        public static final e f24460j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11450m invoke(InterfaceC11450m interfaceC11450m) {
            C12238m.checkNotNullParameter(interfaceC11450m, "it");
            return interfaceC11450m.getContainingDeclaration();
        }
    }

    static {
        C12238m.checkNotNullExpressionValue(C11716e.identifier("value"), "identifier(\"value\")");
    }

    public static final boolean declaresOrInheritsDefaultValue(InterfaceC11326c1 interfaceC11326c1) {
        C12238m.checkNotNullParameter(interfaceC11326c1, "<this>");
        Boolean boolIfAny = C12034b.ifAny(C12145m.listOf(interfaceC11326c1), a.f24455a, b.f24456j);
        C12238m.checkNotNullExpressionValue(boolIfAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolIfAny.booleanValue();
    }

    public static final AbstractC11815g<?> firstArgument(InterfaceC11340c interfaceC11340c) {
        C12238m.checkNotNullParameter(interfaceC11340c, "<this>");
        return (AbstractC11815g) C12163u.firstOrNull(interfaceC11340c.getAllValueArguments().values());
    }

    public static final InterfaceC11321b firstOverridden(InterfaceC11321b interfaceC11321b, boolean z2, Function1<? super InterfaceC11321b, Boolean> function1) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        C12238m.checkNotNullParameter(function1, "predicate");
        return (InterfaceC11321b) C12034b.dfs(C12145m.listOf(interfaceC11321b), new c(z2), new d(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ InterfaceC11321b firstOverridden$default(InterfaceC11321b interfaceC11321b, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return firstOverridden(interfaceC11321b, z2, function1);
    }

    public static final C11713b fqNameOrNull(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        C11714c fqNameUnsafe = getFqNameUnsafe(interfaceC11450m);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final InterfaceC11330e getAnnotationClass(InterfaceC11340c interfaceC11340c) {
        C12238m.checkNotNullParameter(interfaceC11340c, "<this>");
        InterfaceC11352h declarationDescriptor = interfaceC11340c.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11330e) {
            return (InterfaceC11330e) declarationDescriptor;
        }
        return null;
    }

    public static final AbstractC11288h getBuiltIns(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        return getModule(interfaceC11450m).getBuiltIns();
    }

    public static final C11712a getClassId(InterfaceC11352h interfaceC11352h) {
        InterfaceC11450m containingDeclaration;
        C11712a classId;
        if (interfaceC11352h == null || (containingDeclaration = interfaceC11352h.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof InterfaceC11331e0) {
            return new C11712a(((InterfaceC11331e0) containingDeclaration).getFqName(), interfaceC11352h.getName());
        }
        if (!(containingDeclaration instanceof InterfaceC11359i) || (classId = getClassId((InterfaceC11352h) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(interfaceC11352h.getName());
    }

    public static final C11713b getFqNameSafe(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        C11713b fqNameSafe = C11787e.getFqNameSafe(interfaceC11450m);
        C12238m.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final C11714c getFqNameUnsafe(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        C11714c fqName = C11787e.getFqName(interfaceC11450m);
        C12238m.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    public static final AbstractC11947g getKotlinTypeRefiner(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C11955o c11955o = (C11955o) interfaceC11325c0.getCapability(C11948h.getREFINER_CAPABILITY());
        AbstractC11947g abstractC11947g = c11955o == null ? null : (AbstractC11947g) c11955o.getValue();
        return abstractC11947g == null ? AbstractC11947g.a.f24807a : abstractC11947g;
    }

    public static final InterfaceC11325c0 getModule(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        InterfaceC11325c0 containingModule = C11787e.getContainingModule(interfaceC11450m);
        C12238m.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<InterfaceC11450m> getParents(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        return C12078q.drop(getParentsWithSelf(interfaceC11450m), 1);
    }

    public static final Sequence<InterfaceC11450m> getParentsWithSelf(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        return C12075n.generateSequence(interfaceC11450m, e.f24460j);
    }

    public static final InterfaceC11321b getPropertyIfAccessor(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "<this>");
        if (!(interfaceC11321b instanceof InterfaceC11451m0)) {
            return interfaceC11321b;
        }
        InterfaceC11453n0 correspondingProperty = ((InterfaceC11451m0) interfaceC11321b).getCorrespondingProperty();
        C12238m.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final InterfaceC11330e getSuperClassNotAny(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
        for (AbstractC11913c0 abstractC11913c0 : interfaceC11330e.getDefaultType().getConstructor().getSupertypes()) {
            if (!AbstractC11288h.isAnyOrNullableAny(abstractC11913c0)) {
                InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
                if (C11787e.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (InterfaceC11330e) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C11955o c11955o = (C11955o) interfaceC11325c0.getCapability(C11948h.getREFINER_CAPABILITY());
        return (c11955o == null ? null : (AbstractC11947g) c11955o.getValue()) != null;
    }

    public static final InterfaceC11330e resolveTopLevelClass(InterfaceC11325c0 interfaceC11325c0, C11713b c11713b, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        C12238m.checkNotNullParameter(c11713b, "topLevelClassFqName");
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        c11713b.isRoot();
        C11713b c11713bParent = c11713b.parent();
        C12238m.checkNotNullExpressionValue(c11713bParent, "topLevelClassFqName.parent()");
        InterfaceC11770i memberScope = interfaceC11325c0.getPackage(c11713bParent).getMemberScope();
        C11716e c11716eShortName = c11713b.shortName();
        C12238m.checkNotNullExpressionValue(c11716eShortName, "topLevelClassFqName.shortName()");
        InterfaceC11352h contributedClassifier = memberScope.getContributedClassifier(c11716eShortName, interfaceC11480b);
        if (contributedClassifier instanceof InterfaceC11330e) {
            return (InterfaceC11330e) contributedClassifier;
        }
        return null;
    }
}
