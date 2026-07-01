package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.n.c0;
import d0.g0.t;
import d0.t.n0;
import d0.z.d.a0;
import d0.z.d.s;
import d0.z.d.y;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements h {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "withDefinedIn", "getWithDefinedIn()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "modifiers", "getModifiers()Ljava/util/Set;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "startFromName", "getStartFromName()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "debugMode", "getDebugMode()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "verbose", "getVerbose()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "unitReturnType", "getUnitReturnType()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "withoutReturnType", "getWithoutReturnType()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "enhancedTypes", "getEnhancedTypes()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderDefaultModality", "getRenderDefaultModality()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "receiverAfterName", "getReceiverAfterName()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), a0.mutableProperty1(new s(a0.getOrCreateKotlinClass(i.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    public final ReadWriteProperty A;
    public final ReadWriteProperty B;
    public final ReadWriteProperty C;
    public final ReadWriteProperty D;
    public final ReadWriteProperty E;
    public final ReadWriteProperty F;
    public final ReadWriteProperty G;
    public final ReadWriteProperty H;
    public final ReadWriteProperty I;
    public final ReadWriteProperty J;
    public final ReadWriteProperty K;
    public final ReadWriteProperty L;
    public final ReadWriteProperty M;
    public final ReadWriteProperty N;
    public final ReadWriteProperty O;
    public final ReadWriteProperty P;
    public final ReadWriteProperty Q;
    public final ReadWriteProperty R;
    public final ReadWriteProperty S;
    public final ReadWriteProperty T;
    public final ReadWriteProperty U;
    public final ReadWriteProperty V;
    public final ReadWriteProperty W;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3444b;
    public final ReadWriteProperty c;
    public final ReadWriteProperty d;
    public final ReadWriteProperty e;
    public final ReadWriteProperty f;
    public final ReadWriteProperty g;
    public final ReadWriteProperty h;
    public final ReadWriteProperty i;
    public final ReadWriteProperty j;
    public final ReadWriteProperty k;
    public final ReadWriteProperty l;
    public final ReadWriteProperty m;
    public final ReadWriteProperty n;
    public final ReadWriteProperty o;
    public final ReadWriteProperty p;
    public final ReadWriteProperty q;
    public final ReadWriteProperty r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ReadWriteProperty f3445s;
    public final ReadWriteProperty t;
    public final ReadWriteProperty u;
    public final ReadWriteProperty v;
    public final ReadWriteProperty w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ReadWriteProperty f3446x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ReadWriteProperty f3447y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ReadWriteProperty f3448z;

    public i() {
        b$c b_c = b$c.a;
        this.c = new j(b_c, b_c, this);
        Boolean bool = Boolean.TRUE;
        this.d = new j(bool, bool, this);
        this.e = new j(bool, bool, this);
        Set<g> set = g.j;
        this.f = new j(set, set, this);
        Boolean bool2 = Boolean.FALSE;
        this.g = new j(bool2, bool2, this);
        this.h = new j(bool2, bool2, this);
        this.i = new j(bool2, bool2, this);
        this.j = new j(bool2, bool2, this);
        this.k = new j(bool2, bool2, this);
        this.l = new j(bool, bool, this);
        this.m = new j(bool2, bool2, this);
        this.n = new j(bool2, bool2, this);
        this.o = new j(bool2, bool2, this);
        this.p = new j(bool, bool, this);
        this.q = new j(bool, bool, this);
        this.r = new j(bool2, bool2, this);
        this.f3445s = new j(bool2, bool2, this);
        this.t = new j(bool2, bool2, this);
        this.u = new j(bool2, bool2, this);
        this.v = new j(bool2, bool2, this);
        this.w = new j(bool2, bool2, this);
        this.f3446x = new j(bool2, bool2, this);
        i$b i_b = i$b.j;
        this.f3447y = new j(i_b, i_b, this);
        i$a i_a = i$a.j;
        this.f3448z = new j(i_a, i_a, this);
        this.A = new j(bool, bool, this);
        m mVar = m.RENDER_OPEN;
        this.B = new j(mVar, mVar, this);
        c$l$a c_l_a = c$l$a.a;
        this.C = new j(c_l_a, c_l_a, this);
        p pVar = p.j;
        this.D = new j(pVar, pVar, this);
        n nVar = n.ALL;
        this.E = new j(nVar, nVar, this);
        this.F = new j(bool2, bool2, this);
        this.G = new j(bool2, bool2, this);
        o oVar = o.DEBUG;
        this.H = new j(oVar, oVar, this);
        this.I = new j(bool2, bool2, this);
        this.J = new j(bool2, bool2, this);
        Set setEmptySet = n0.emptySet();
        this.K = new j(setEmptySet, setEmptySet, this);
        Set<d0.e0.p.d.m0.g.b> internalAnnotationsForResolve = k.a.getInternalAnnotationsForResolve();
        this.L = new j(internalAnnotationsForResolve, internalAnnotationsForResolve, this);
        this.M = new j(null, null, this);
        a aVar = a.NO_ARGUMENTS;
        this.N = new j(aVar, aVar, this);
        this.O = new j(bool2, bool2, this);
        this.P = new j(bool, bool, this);
        this.Q = new j(bool, bool, this);
        this.R = new j(bool2, bool2, this);
        this.S = new j(bool, bool, this);
        this.T = new j(bool, bool, this);
        new j(bool2, bool2, this);
        this.U = new j(bool2, bool2, this);
        this.V = new j(bool2, bool2, this);
        this.W = new j(bool, bool, this);
    }

    public final i copy() {
        i iVar = new i();
        Field[] declaredFields = i.class.getDeclaredFields();
        d0.z.d.m.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                d0.b0.a aVar = obj instanceof d0.b0.a ? (d0.b0.a) obj : null;
                if (aVar != null) {
                    String name = field.getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "field.name");
                    t.startsWith$default(name, "is", false, 2, null);
                    d0.e0.c orCreateKotlinClass = a0.getOrCreateKotlinClass(i.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    d0.z.d.m.checkNotNullExpressionValue(name3, "field.name");
                    Object value = aVar.getValue(this, new y(orCreateKotlinClass, name2, d0.z.d.m.stringPlus("get", t.capitalize(name3))));
                    field.set(iVar, new j(value, value, iVar));
                }
            }
        }
        return iVar;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.t.getValue(this, a[17])).booleanValue();
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.O.getValue(this, a[38])).booleanValue();
    }

    @Override // d0.e0.p.d.m0.j.h
    public a getAnnotationArgumentsRenderingPolicy() {
        return (a) this.N.getValue(this, a[37]);
    }

    public Function1<d0.e0.p.d.m0.c.g1.c, Boolean> getAnnotationFilter() {
        return (Function1) this.M.getValue(this, a[36]);
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.V.getValue(this, a[46])).booleanValue();
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.j.getValue(this, a[7])).booleanValue();
    }

    public b getClassifierNamePolicy() {
        return (b) this.c.getValue(this, a[0]);
    }

    @Override // d0.e0.p.d.m0.j.h
    public boolean getDebugMode() {
        return ((Boolean) this.i.getValue(this, a[6])).booleanValue();
    }

    public Function1<c1, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f3448z.getValue(this, a[23]);
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.J.getValue(this, a[33])).booleanValue();
    }

    @Override // d0.e0.p.d.m0.j.h
    public boolean getEnhancedTypes() {
        return ((Boolean) this.n.getValue(this, a[11])).booleanValue();
    }

    public Set<d0.e0.p.d.m0.g.b> getExcludedAnnotationClasses() {
        return (Set) this.K.getValue(this, a[34]);
    }

    @Override // d0.e0.p.d.m0.j.h
    public Set<d0.e0.p.d.m0.g.b> getExcludedTypeAnnotationClasses() {
        return (Set) this.L.getValue(this, a[35]);
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.S.getValue(this, a[42])).booleanValue();
    }

    public boolean getIncludeAnnotationArguments() {
        return h$a.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return h$a.getIncludeEmptyAnnotationArguments(this);
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.v.getValue(this, a[19])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.W.getValue(this, a[47])).booleanValue();
    }

    public Set<g> getModifiers() {
        return (Set) this.f.getValue(this, a[3]);
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.o.getValue(this, a[12])).booleanValue();
    }

    public m getOverrideRenderingPolicy() {
        return (m) this.B.getValue(this, a[25]);
    }

    public n getParameterNameRenderingPolicy() {
        return (n) this.E.getValue(this, a[28]);
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.T.getValue(this, a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.U.getValue(this, a[45])).booleanValue();
    }

    public o getPropertyAccessorRenderingPolicy() {
        return (o) this.H.getValue(this, a[31]);
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

    public p getTextFormat() {
        return (p) this.D.getValue(this, a[27]);
    }

    public Function1<c0, c0> getTypeNormalizer() {
        return (Function1) this.f3447y.getValue(this, a[22]);
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.u.getValue(this, a[18])).booleanValue();
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.l.getValue(this, a[9])).booleanValue();
    }

    public c$l getValueParametersHandler() {
        return (c$l) this.C.getValue(this, a[26]);
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

    @Override // d0.e0.p.d.m0.j.h
    public void setAnnotationArgumentsRenderingPolicy(a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "<set-?>");
        this.N.setValue(this, a[37], aVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setClassifierNamePolicy(b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<set-?>");
        this.c.setValue(this, a[0], bVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setDebugMode(boolean z2) {
        this.i.setValue(this, a[6], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setExcludedTypeAnnotationClasses(Set<d0.e0.p.d.m0.g.b> set) {
        d0.z.d.m.checkNotNullParameter(set, "<set-?>");
        this.L.setValue(this, a[35], set);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setModifiers(Set<? extends g> set) {
        d0.z.d.m.checkNotNullParameter(set, "<set-?>");
        this.f.setValue(this, a[3], set);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setParameterNameRenderingPolicy(n nVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<set-?>");
        this.E.setValue(this, a[28], nVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setReceiverAfterName(boolean z2) {
        this.F.setValue(this, a[29], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setRenderCompanionObjectName(boolean z2) {
        this.G.setValue(this, a[30], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setStartFromName(boolean z2) {
        this.g.setValue(this, a[4], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setTextFormat(p pVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "<set-?>");
        this.D.setValue(this, a[27], pVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithDefinedIn(boolean z2) {
        this.d.setValue(this, a[1], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithoutSuperTypes(boolean z2) {
        this.f3446x.setValue(this, a[21], Boolean.valueOf(z2));
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithoutTypeParameters(boolean z2) {
        this.w.setValue(this, a[20], Boolean.valueOf(z2));
    }
}
