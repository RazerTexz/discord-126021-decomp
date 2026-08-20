package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p507d0.p509b0.AbstractC11212a;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12244s;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.i */
/* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11752i implements InterfaceC11751h {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f24261a = {C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "withDefinedIn", "getWithDefinedIn()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "modifiers", "getModifiers()Ljava/util/Set;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "startFromName", "getStartFromName()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "debugMode", "getDebugMode()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "verbose", "getVerbose()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "unitReturnType", "getUnitReturnType()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "withoutReturnType", "getWithoutReturnType()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "enhancedTypes", "getEnhancedTypes()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderDefaultModality", "getRenderDefaultModality()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "receiverAfterName", "getReceiverAfterName()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), C12216a0.mutableProperty1(new C12244s(C12216a0.getOrCreateKotlinClass(C11752i.class), "informativeErrorType", "getInformativeErrorType()Z"))};

    /* JADX INFO: renamed from: A */
    public final ReadWriteProperty f24262A;

    /* JADX INFO: renamed from: B */
    public final ReadWriteProperty f24263B;

    /* JADX INFO: renamed from: C */
    public final ReadWriteProperty f24264C;

    /* JADX INFO: renamed from: D */
    public final ReadWriteProperty f24265D;

    /* JADX INFO: renamed from: E */
    public final ReadWriteProperty f24266E;

    /* JADX INFO: renamed from: F */
    public final ReadWriteProperty f24267F;

    /* JADX INFO: renamed from: G */
    public final ReadWriteProperty f24268G;

    /* JADX INFO: renamed from: H */
    public final ReadWriteProperty f24269H;

    /* JADX INFO: renamed from: I */
    public final ReadWriteProperty f24270I;

    /* JADX INFO: renamed from: J */
    public final ReadWriteProperty f24271J;

    /* JADX INFO: renamed from: K */
    public final ReadWriteProperty f24272K;

    /* JADX INFO: renamed from: L */
    public final ReadWriteProperty f24273L;

    /* JADX INFO: renamed from: M */
    public final ReadWriteProperty f24274M;

    /* JADX INFO: renamed from: N */
    public final ReadWriteProperty f24275N;

    /* JADX INFO: renamed from: O */
    public final ReadWriteProperty f24276O;

    /* JADX INFO: renamed from: P */
    public final ReadWriteProperty f24277P;

    /* JADX INFO: renamed from: Q */
    public final ReadWriteProperty f24278Q;

    /* JADX INFO: renamed from: R */
    public final ReadWriteProperty f24279R;

    /* JADX INFO: renamed from: S */
    public final ReadWriteProperty f24280S;

    /* JADX INFO: renamed from: T */
    public final ReadWriteProperty f24281T;

    /* JADX INFO: renamed from: U */
    public final ReadWriteProperty f24282U;

    /* JADX INFO: renamed from: V */
    public final ReadWriteProperty f24283V;

    /* JADX INFO: renamed from: W */
    public final ReadWriteProperty f24284W;

    /* JADX INFO: renamed from: b */
    public boolean f24285b;

    /* JADX INFO: renamed from: c */
    public final ReadWriteProperty f24286c;

    /* JADX INFO: renamed from: d */
    public final ReadWriteProperty f24287d;

    /* JADX INFO: renamed from: e */
    public final ReadWriteProperty f24288e;

    /* JADX INFO: renamed from: f */
    public final ReadWriteProperty f24289f;

    /* JADX INFO: renamed from: g */
    public final ReadWriteProperty f24290g;

    /* JADX INFO: renamed from: h */
    public final ReadWriteProperty f24291h;

    /* JADX INFO: renamed from: i */
    public final ReadWriteProperty f24292i;

    /* JADX INFO: renamed from: j */
    public final ReadWriteProperty f24293j;

    /* JADX INFO: renamed from: k */
    public final ReadWriteProperty f24294k;

    /* JADX INFO: renamed from: l */
    public final ReadWriteProperty f24295l;

    /* JADX INFO: renamed from: m */
    public final ReadWriteProperty f24296m;

    /* JADX INFO: renamed from: n */
    public final ReadWriteProperty f24297n;

    /* JADX INFO: renamed from: o */
    public final ReadWriteProperty f24298o;

    /* JADX INFO: renamed from: p */
    public final ReadWriteProperty f24299p;

    /* JADX INFO: renamed from: q */
    public final ReadWriteProperty f24300q;

    /* JADX INFO: renamed from: r */
    public final ReadWriteProperty f24301r;

    /* JADX INFO: renamed from: s */
    public final ReadWriteProperty f24302s;

    /* JADX INFO: renamed from: t */
    public final ReadWriteProperty f24303t;

    /* JADX INFO: renamed from: u */
    public final ReadWriteProperty f24304u;

    /* JADX INFO: renamed from: v */
    public final ReadWriteProperty f24305v;

    /* JADX INFO: renamed from: w */
    public final ReadWriteProperty f24306w;

    /* JADX INFO: renamed from: x */
    public final ReadWriteProperty f24307x;

    /* JADX INFO: renamed from: y */
    public final ReadWriteProperty f24308y;

    /* JADX INFO: renamed from: z */
    public final ReadWriteProperty f24309z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.i$a */
    /* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11326c1, String> {

        /* JADX INFO: renamed from: j */
        public static final a f24310j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(InterfaceC11326c1 interfaceC11326c1) {
            C12238m.checkNotNullParameter(interfaceC11326c1, "it");
            return "...";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.i$b */
    /* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
    public static final class b extends AbstractC12240o implements Function1<AbstractC11913c0, AbstractC11913c0> {

        /* JADX INFO: renamed from: j */
        public static final b f24311j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11913c0 invoke(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "it");
            return abstractC11913c0;
        }
    }

    public C11752i() {
        InterfaceC11745b.c cVar = InterfaceC11745b.c.f24224a;
        this.f24286c = new C11753j(cVar, cVar, this);
        Boolean bool = Boolean.TRUE;
        this.f24287d = new C11753j(bool, bool, this);
        this.f24288e = new C11753j(bool, bool, this);
        Set<EnumC11750g> set = EnumC11750g.f24244j;
        this.f24289f = new C11753j(set, set, this);
        Boolean bool2 = Boolean.FALSE;
        this.f24290g = new C11753j(bool2, bool2, this);
        this.f24291h = new C11753j(bool2, bool2, this);
        this.f24292i = new C11753j(bool2, bool2, this);
        this.f24293j = new C11753j(bool2, bool2, this);
        this.f24294k = new C11753j(bool2, bool2, this);
        this.f24295l = new C11753j(bool, bool, this);
        this.f24296m = new C11753j(bool2, bool2, this);
        this.f24297n = new C11753j(bool2, bool2, this);
        this.f24298o = new C11753j(bool2, bool2, this);
        this.f24299p = new C11753j(bool, bool, this);
        this.f24300q = new C11753j(bool, bool, this);
        this.f24301r = new C11753j(bool2, bool2, this);
        this.f24302s = new C11753j(bool2, bool2, this);
        this.f24303t = new C11753j(bool2, bool2, this);
        this.f24304u = new C11753j(bool2, bool2, this);
        this.f24305v = new C11753j(bool2, bool2, this);
        this.f24306w = new C11753j(bool2, bool2, this);
        this.f24307x = new C11753j(bool2, bool2, this);
        b bVar = b.f24311j;
        this.f24308y = new C11753j(bVar, bVar, this);
        a aVar = a.f24310j;
        this.f24309z = new C11753j(aVar, aVar, this);
        this.f24262A = new C11753j(bool, bool, this);
        EnumC11756m enumC11756m = EnumC11756m.RENDER_OPEN;
        this.f24263B = new C11753j(enumC11756m, enumC11756m, this);
        AbstractC11746c.l.a aVar2 = AbstractC11746c.l.a.f24238a;
        this.f24264C = new C11753j(aVar2, aVar2, this);
        EnumC11759p enumC11759p = EnumC11759p.PLAIN;
        this.f24265D = new C11753j(enumC11759p, enumC11759p, this);
        EnumC11757n enumC11757n = EnumC11757n.ALL;
        this.f24266E = new C11753j(enumC11757n, enumC11757n, this);
        this.f24267F = new C11753j(bool2, bool2, this);
        this.f24268G = new C11753j(bool2, bool2, this);
        EnumC11758o enumC11758o = EnumC11758o.DEBUG;
        this.f24269H = new C11753j(enumC11758o, enumC11758o, this);
        this.f24270I = new C11753j(bool2, bool2, this);
        this.f24271J = new C11753j(bool2, bool2, this);
        Set setEmptySet = C12148n0.emptySet();
        this.f24272K = new C11753j(setEmptySet, setEmptySet, this);
        Set<C11713b> internalAnnotationsForResolve = C11754k.f24314a.getInternalAnnotationsForResolve();
        this.f24273L = new C11753j(internalAnnotationsForResolve, internalAnnotationsForResolve, this);
        this.f24274M = new C11753j(null, null, this);
        EnumC11744a enumC11744a = EnumC11744a.NO_ARGUMENTS;
        this.f24275N = new C11753j(enumC11744a, enumC11744a, this);
        this.f24276O = new C11753j(bool2, bool2, this);
        this.f24277P = new C11753j(bool, bool, this);
        this.f24278Q = new C11753j(bool, bool, this);
        this.f24279R = new C11753j(bool2, bool2, this);
        this.f24280S = new C11753j(bool, bool, this);
        this.f24281T = new C11753j(bool, bool, this);
        new C11753j(bool2, bool2, this);
        this.f24282U = new C11753j(bool2, bool2, this);
        this.f24283V = new C11753j(bool2, bool2, this);
        this.f24284W = new C11753j(bool, bool, this);
    }

    public final C11752i copy() {
        C11752i c11752i = new C11752i();
        Field[] declaredFields = C11752i.class.getDeclaredFields();
        C12238m.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                AbstractC11212a abstractC11212a = obj instanceof AbstractC11212a ? (AbstractC11212a) obj : null;
                if (abstractC11212a != null) {
                    String name = field.getName();
                    C12238m.checkNotNullExpressionValue(name, "field.name");
                    C12103t.startsWith$default(name, "is", false, 2, null);
                    InterfaceC11230c orCreateKotlinClass = C12216a0.getOrCreateKotlinClass(C11752i.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    C12238m.checkNotNullExpressionValue(name3, "field.name");
                    Object value = abstractC11212a.getValue(this, new C12250y(orCreateKotlinClass, name2, C12238m.stringPlus("get", C12103t.capitalize(name3))));
                    field.set(c11752i, new C11753j(value, value, c11752i));
                }
            }
        }
        return c11752i;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.f24303t.getValue(this, f24261a[17])).booleanValue();
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.f24276O.getValue(this, f24261a[38])).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public EnumC11744a getAnnotationArgumentsRenderingPolicy() {
        return (EnumC11744a) this.f24275N.getValue(this, f24261a[37]);
    }

    public Function1<InterfaceC11340c, Boolean> getAnnotationFilter() {
        return (Function1) this.f24274M.getValue(this, f24261a[36]);
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.f24283V.getValue(this, f24261a[46])).booleanValue();
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.f24293j.getValue(this, f24261a[7])).booleanValue();
    }

    public InterfaceC11745b getClassifierNamePolicy() {
        return (InterfaceC11745b) this.f24286c.getValue(this, f24261a[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public boolean getDebugMode() {
        return ((Boolean) this.f24292i.getValue(this, f24261a[6])).booleanValue();
    }

    public Function1<InterfaceC11326c1, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f24309z.getValue(this, f24261a[23]);
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.f24271J.getValue(this, f24261a[33])).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public boolean getEnhancedTypes() {
        return ((Boolean) this.f24297n.getValue(this, f24261a[11])).booleanValue();
    }

    public Set<C11713b> getExcludedAnnotationClasses() {
        return (Set) this.f24272K.getValue(this, f24261a[34]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public Set<C11713b> getExcludedTypeAnnotationClasses() {
        return (Set) this.f24273L.getValue(this, f24261a[35]);
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.f24280S.getValue(this, f24261a[42])).booleanValue();
    }

    public boolean getIncludeAnnotationArguments() {
        return InterfaceC11751h.a.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return InterfaceC11751h.a.getIncludeEmptyAnnotationArguments(this);
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.f24305v.getValue(this, f24261a[19])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.f24284W.getValue(this, f24261a[47])).booleanValue();
    }

    public Set<EnumC11750g> getModifiers() {
        return (Set) this.f24289f.getValue(this, f24261a[3]);
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.f24298o.getValue(this, f24261a[12])).booleanValue();
    }

    public EnumC11756m getOverrideRenderingPolicy() {
        return (EnumC11756m) this.f24263B.getValue(this, f24261a[25]);
    }

    public EnumC11757n getParameterNameRenderingPolicy() {
        return (EnumC11757n) this.f24266E.getValue(this, f24261a[28]);
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.f24281T.getValue(this, f24261a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.f24282U.getValue(this, f24261a[45])).booleanValue();
    }

    public EnumC11758o getPropertyAccessorRenderingPolicy() {
        return (EnumC11758o) this.f24269H.getValue(this, f24261a[31]);
    }

    public boolean getReceiverAfterName() {
        return ((Boolean) this.f24267F.getValue(this, f24261a[29])).booleanValue();
    }

    public boolean getRenderCompanionObjectName() {
        return ((Boolean) this.f24268G.getValue(this, f24261a[30])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((Boolean) this.f24301r.getValue(this, f24261a[15])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((Boolean) this.f24277P.getValue(this, f24261a[39])).booleanValue();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((Boolean) this.f24270I.getValue(this, f24261a[32])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((Boolean) this.f24300q.getValue(this, f24261a[14])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((Boolean) this.f24299p.getValue(this, f24261a[13])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((Boolean) this.f24302s.getValue(this, f24261a[16])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((Boolean) this.f24279R.getValue(this, f24261a[41])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((Boolean) this.f24278Q.getValue(this, f24261a[40])).booleanValue();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((Boolean) this.f24262A.getValue(this, f24261a[24])).booleanValue();
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((Boolean) this.f24291h.getValue(this, f24261a[5])).booleanValue();
    }

    public boolean getStartFromName() {
        return ((Boolean) this.f24290g.getValue(this, f24261a[4])).booleanValue();
    }

    public EnumC11759p getTextFormat() {
        return (EnumC11759p) this.f24265D.getValue(this, f24261a[27]);
    }

    public Function1<AbstractC11913c0, AbstractC11913c0> getTypeNormalizer() {
        return (Function1) this.f24308y.getValue(this, f24261a[22]);
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.f24304u.getValue(this, f24261a[18])).booleanValue();
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.f24295l.getValue(this, f24261a[9])).booleanValue();
    }

    public AbstractC11746c.l getValueParametersHandler() {
        return (AbstractC11746c.l) this.f24264C.getValue(this, f24261a[26]);
    }

    public boolean getVerbose() {
        return ((Boolean) this.f24294k.getValue(this, f24261a[8])).booleanValue();
    }

    public boolean getWithDefinedIn() {
        return ((Boolean) this.f24287d.getValue(this, f24261a[1])).booleanValue();
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((Boolean) this.f24288e.getValue(this, f24261a[2])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((Boolean) this.f24296m.getValue(this, f24261a[10])).booleanValue();
    }

    public boolean getWithoutSuperTypes() {
        return ((Boolean) this.f24307x.getValue(this, f24261a[21])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        return ((Boolean) this.f24306w.getValue(this, f24261a[20])).booleanValue();
    }

    public final boolean isLocked() {
        return this.f24285b;
    }

    public final void lock() {
        this.f24285b = true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setAnnotationArgumentsRenderingPolicy(EnumC11744a enumC11744a) {
        C12238m.checkNotNullParameter(enumC11744a, "<set-?>");
        this.f24275N.setValue(this, f24261a[37], enumC11744a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setClassifierNamePolicy(InterfaceC11745b interfaceC11745b) {
        C12238m.checkNotNullParameter(interfaceC11745b, "<set-?>");
        this.f24286c.setValue(this, f24261a[0], interfaceC11745b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setDebugMode(boolean z2) {
        this.f24292i.setValue(this, f24261a[6], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setExcludedTypeAnnotationClasses(Set<C11713b> set) {
        C12238m.checkNotNullParameter(set, "<set-?>");
        this.f24273L.setValue(this, f24261a[35], set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setModifiers(Set<? extends EnumC11750g> set) {
        C12238m.checkNotNullParameter(set, "<set-?>");
        this.f24289f.setValue(this, f24261a[3], set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setParameterNameRenderingPolicy(EnumC11757n enumC11757n) {
        C12238m.checkNotNullParameter(enumC11757n, "<set-?>");
        this.f24266E.setValue(this, f24261a[28], enumC11757n);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setReceiverAfterName(boolean z2) {
        this.f24267F.setValue(this, f24261a[29], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setRenderCompanionObjectName(boolean z2) {
        this.f24268G.setValue(this, f24261a[30], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setStartFromName(boolean z2) {
        this.f24290g.setValue(this, f24261a[4], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setTextFormat(EnumC11759p enumC11759p) {
        C12238m.checkNotNullParameter(enumC11759p, "<set-?>");
        this.f24265D.setValue(this, f24261a[27], enumC11759p);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithDefinedIn(boolean z2) {
        this.f24287d.setValue(this, f24261a[1], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithoutSuperTypes(boolean z2) {
        this.f24307x.setValue(this, f24261a[21], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h
    public void setWithoutTypeParameters(boolean z2) {
        this.f24306w.setValue(this, f24261a[20], Boolean.valueOf(z2));
    }
}
