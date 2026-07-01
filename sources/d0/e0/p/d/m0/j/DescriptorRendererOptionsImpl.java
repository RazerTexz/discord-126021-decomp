package d0.e0.p.d.m0.j;

import d0.b0.ObservableProperty;
import d0.e0.KClass;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.j.ClassifierNamePolicy;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.n.KotlinType;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.i, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorRendererOptionsImpl implements DescriptorRenderer4 {
    public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "debugMode", "getDebugMode()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "enhancedTypes", "getEnhancedTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultModality", "getRenderDefaultModality()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    public final Interfaces A;
    public final Interfaces B;
    public final Interfaces C;
    public final Interfaces D;
    public final Interfaces E;
    public final Interfaces F;
    public final Interfaces G;
    public final Interfaces H;
    public final Interfaces I;
    public final Interfaces J;
    public final Interfaces K;
    public final Interfaces L;
    public final Interfaces M;
    public final Interfaces N;
    public final Interfaces O;
    public final Interfaces P;
    public final Interfaces Q;
    public final Interfaces R;
    public final Interfaces S;
    public final Interfaces T;
    public final Interfaces U;
    public final Interfaces V;
    public final Interfaces W;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3444b;
    public final Interfaces c;
    public final Interfaces d;
    public final Interfaces e;
    public final Interfaces f;
    public final Interfaces g;
    public final Interfaces h;
    public final Interfaces i;
    public final Interfaces j;
    public final Interfaces k;
    public final Interfaces l;
    public final Interfaces m;
    public final Interfaces n;
    public final Interfaces o;
    public final Interfaces p;
    public final Interfaces q;
    public final Interfaces r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Interfaces f3445s;
    public final Interfaces t;
    public final Interfaces u;
    public final Interfaces v;
    public final Interfaces w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Interfaces f3446x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Interfaces f3447y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Interfaces f3448z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.i$a */
    /* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
    public static final class a extends Lambda implements Function1<ValueParameterDescriptor, String> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "it");
            return "...";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.i$b */
    /* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
    public static final class b extends Lambda implements Function1<KotlinType, KotlinType> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "it");
            return kotlinType;
        }
    }

    public DescriptorRendererOptionsImpl() {
        ClassifierNamePolicy.c cVar = ClassifierNamePolicy.c.a;
        this.c = new Delegates2(cVar, cVar, this);
        Boolean bool = Boolean.TRUE;
        this.d = new Delegates2(bool, bool, this);
        this.e = new Delegates2(bool, bool, this);
        Set<DescriptorRenderer3> set = DescriptorRenderer3.j;
        this.f = new Delegates2(set, set, this);
        Boolean bool2 = Boolean.FALSE;
        this.g = new Delegates2(bool2, bool2, this);
        this.h = new Delegates2(bool2, bool2, this);
        this.i = new Delegates2(bool2, bool2, this);
        this.j = new Delegates2(bool2, bool2, this);
        this.k = new Delegates2(bool2, bool2, this);
        this.l = new Delegates2(bool, bool, this);
        this.m = new Delegates2(bool2, bool2, this);
        this.n = new Delegates2(bool2, bool2, this);
        this.o = new Delegates2(bool2, bool2, this);
        this.p = new Delegates2(bool, bool, this);
        this.q = new Delegates2(bool, bool, this);
        this.r = new Delegates2(bool2, bool2, this);
        this.f3445s = new Delegates2(bool2, bool2, this);
        this.t = new Delegates2(bool2, bool2, this);
        this.u = new Delegates2(bool2, bool2, this);
        this.v = new Delegates2(bool2, bool2, this);
        this.w = new Delegates2(bool2, bool2, this);
        this.f3446x = new Delegates2(bool2, bool2, this);
        b bVar = b.j;
        this.f3447y = new Delegates2(bVar, bVar, this);
        a aVar = a.j;
        this.f3448z = new Delegates2(aVar, aVar, this);
        this.A = new Delegates2(bool, bool, this);
        DescriptorRenderer6 descriptorRenderer6 = DescriptorRenderer6.RENDER_OPEN;
        this.B = new Delegates2(descriptorRenderer6, descriptorRenderer6, this);
        DescriptorRenderer2.l.a aVar2 = DescriptorRenderer2.l.a.a;
        this.C = new Delegates2(aVar2, aVar2, this);
        DescriptorRenderer9 descriptorRenderer9 = DescriptorRenderer9.PLAIN;
        this.D = new Delegates2(descriptorRenderer9, descriptorRenderer9, this);
        DescriptorRenderer7 descriptorRenderer7 = DescriptorRenderer7.ALL;
        this.E = new Delegates2(descriptorRenderer7, descriptorRenderer7, this);
        this.F = new Delegates2(bool2, bool2, this);
        this.G = new Delegates2(bool2, bool2, this);
        DescriptorRenderer8 descriptorRenderer8 = DescriptorRenderer8.DEBUG;
        this.H = new Delegates2(descriptorRenderer8, descriptorRenderer8, this);
        this.I = new Delegates2(bool2, bool2, this);
        this.J = new Delegates2(bool2, bool2, this);
        Set setEmptySet = Sets5.emptySet();
        this.K = new Delegates2(setEmptySet, setEmptySet, this);
        Set<FqName> internalAnnotationsForResolve = DescriptorRenderer5.a.getInternalAnnotationsForResolve();
        this.L = new Delegates2(internalAnnotationsForResolve, internalAnnotationsForResolve, this);
        this.M = new Delegates2(null, null, this);
        DescriptorRenderer descriptorRenderer = DescriptorRenderer.NO_ARGUMENTS;
        this.N = new Delegates2(descriptorRenderer, descriptorRenderer, this);
        this.O = new Delegates2(bool2, bool2, this);
        this.P = new Delegates2(bool, bool, this);
        this.Q = new Delegates2(bool, bool, this);
        this.R = new Delegates2(bool2, bool2, this);
        this.S = new Delegates2(bool, bool, this);
        this.T = new Delegates2(bool, bool, this);
        new Delegates2(bool2, bool2, this);
        this.U = new Delegates2(bool2, bool2, this);
        this.V = new Delegates2(bool2, bool2, this);
        this.W = new Delegates2(bool, bool, this);
    }

    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = DescriptorRendererOptionsImpl.class.getDeclaredFields();
        Intrinsics3.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty != null) {
                    String name = field.getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "field.name");
                    StringsJVM.startsWith$default(name, "is", false, 2, null);
                    KClass orCreateKotlinClass = Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    Intrinsics3.checkNotNullExpressionValue(name3, "field.name");
                    Object value = observableProperty.getValue(this, new PropertyReference1Impl(orCreateKotlinClass, name2, Intrinsics3.stringPlus("get", StringsJVM.capitalize(name3))));
                    field.set(descriptorRendererOptionsImpl, new Delegates2(value, value, descriptorRendererOptionsImpl));
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.t.getValue(this, a[17])).booleanValue();
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.O.getValue(this, a[38])).booleanValue();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public DescriptorRenderer getAnnotationArgumentsRenderingPolicy() {
        return (DescriptorRenderer) this.N.getValue(this, a[37]);
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return (Function1) this.M.getValue(this, a[36]);
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.V.getValue(this, a[46])).booleanValue();
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.j.getValue(this, a[7])).booleanValue();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy) this.c.getValue(this, a[0]);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public boolean getDebugMode() {
        return ((Boolean) this.i.getValue(this, a[6])).booleanValue();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f3448z.getValue(this, a[23]);
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.J.getValue(this, a[33])).booleanValue();
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public boolean getEnhancedTypes() {
        return ((Boolean) this.n.getValue(this, a[11])).booleanValue();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set) this.K.getValue(this, a[34]);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set) this.L.getValue(this, a[35]);
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.S.getValue(this, a[42])).booleanValue();
    }

    public boolean getIncludeAnnotationArguments() {
        return DescriptorRenderer4.a.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRenderer4.a.getIncludeEmptyAnnotationArguments(this);
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.v.getValue(this, a[19])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.W.getValue(this, a[47])).booleanValue();
    }

    public Set<DescriptorRenderer3> getModifiers() {
        return (Set) this.f.getValue(this, a[3]);
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.o.getValue(this, a[12])).booleanValue();
    }

    public DescriptorRenderer6 getOverrideRenderingPolicy() {
        return (DescriptorRenderer6) this.B.getValue(this, a[25]);
    }

    public DescriptorRenderer7 getParameterNameRenderingPolicy() {
        return (DescriptorRenderer7) this.E.getValue(this, a[28]);
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.T.getValue(this, a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.U.getValue(this, a[45])).booleanValue();
    }

    public DescriptorRenderer8 getPropertyAccessorRenderingPolicy() {
        return (DescriptorRenderer8) this.H.getValue(this, a[31]);
    }

    public boolean getReceiverAfterName() {
        return ((Boolean) this.F.getValue(this, a[29])).booleanValue();
    }

    public boolean getRenderCompanionObjectName() {
        return ((Boolean) this.G.getValue(this, a[30])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((Boolean) this.r.getValue(this, a[15])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((Boolean) this.P.getValue(this, a[39])).booleanValue();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((Boolean) this.I.getValue(this, a[32])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((Boolean) this.q.getValue(this, a[14])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((Boolean) this.p.getValue(this, a[13])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((Boolean) this.f3445s.getValue(this, a[16])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((Boolean) this.R.getValue(this, a[41])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((Boolean) this.Q.getValue(this, a[40])).booleanValue();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((Boolean) this.A.getValue(this, a[24])).booleanValue();
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((Boolean) this.h.getValue(this, a[5])).booleanValue();
    }

    public boolean getStartFromName() {
        return ((Boolean) this.g.getValue(this, a[4])).booleanValue();
    }

    public DescriptorRenderer9 getTextFormat() {
        return (DescriptorRenderer9) this.D.getValue(this, a[27]);
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1) this.f3447y.getValue(this, a[22]);
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.u.getValue(this, a[18])).booleanValue();
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.l.getValue(this, a[9])).booleanValue();
    }

    public DescriptorRenderer2.l getValueParametersHandler() {
        return (DescriptorRenderer2.l) this.C.getValue(this, a[26]);
    }

    public boolean getVerbose() {
        return ((Boolean) this.k.getValue(this, a[8])).booleanValue();
    }

    public boolean getWithDefinedIn() {
        return ((Boolean) this.d.getValue(this, a[1])).booleanValue();
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((Boolean) this.e.getValue(this, a[2])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((Boolean) this.m.getValue(this, a[10])).booleanValue();
    }

    public boolean getWithoutSuperTypes() {
        return ((Boolean) this.f3446x.getValue(this, a[21])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        return ((Boolean) this.w.getValue(this, a[20])).booleanValue();
    }

    public final boolean isLocked() {
        return this.f3444b;
    }

    public final void lock() {
        this.f3444b = true;
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setAnnotationArgumentsRenderingPolicy(DescriptorRenderer descriptorRenderer) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer, "<set-?>");
        this.N.setValue(this, a[37], descriptorRenderer);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics3.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.c.setValue(this, a[0], classifierNamePolicy);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setDebugMode(boolean z2) {
        this.i.setValue(this, a[6], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.L.setValue(this, a[35], set);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setModifiers(Set<? extends DescriptorRenderer3> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.f.setValue(this, a[3], set);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setParameterNameRenderingPolicy(DescriptorRenderer7 descriptorRenderer7) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer7, "<set-?>");
        this.E.setValue(this, a[28], descriptorRenderer7);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setReceiverAfterName(boolean z2) {
        this.F.setValue(this, a[29], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setRenderCompanionObjectName(boolean z2) {
        this.G.setValue(this, a[30], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setStartFromName(boolean z2) {
        this.g.setValue(this, a[4], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setTextFormat(DescriptorRenderer9 descriptorRenderer9) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer9, "<set-?>");
        this.D.setValue(this, a[27], descriptorRenderer9);
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithDefinedIn(boolean z2) {
        this.d.setValue(this, a[1], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithoutSuperTypes(boolean z2) {
        this.f3446x.setValue(this, a[21], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.DescriptorRenderer4
    public void setWithoutTypeParameters(boolean z2) {
        this.w.setValue(this, a[20], Boolean.valueOf(z2));
    }
}
