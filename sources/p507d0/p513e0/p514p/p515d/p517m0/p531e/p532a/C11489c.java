package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.EnumC11351n;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.C11501d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11603i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12037e;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.EnumC12040h;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11489c {

    /* JADX INFO: renamed from: a */
    public final C12037e f23187a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11899i<InterfaceC11330e, InterfaceC11340c> f23188b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$a */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC11340c f23189a;

        /* JADX INFO: renamed from: b */
        public final int f23190b;

        public a(InterfaceC11340c interfaceC11340c, int i) {
            C12238m.checkNotNullParameter(interfaceC11340c, "typeQualifier");
            this.f23189a = interfaceC11340c;
            this.f23190b = i;
        }

        public final InterfaceC11340c component1() {
            return this.f23189a;
        }

        public final List<EnumC11485a> component2() {
            EnumC11485a[] enumC11485aArrValuesCustom = EnumC11485a.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 6; i++) {
                EnumC11485a enumC11485a = enumC11485aArrValuesCustom[i];
                boolean z2 = true;
                if (!((this.f23190b & (1 << enumC11485a.ordinal())) != 0)) {
                    if (!((this.f23190b & 8) != 0) || enumC11485a == EnumC11485a.TYPE_PARAMETER_BOUNDS) {
                        z2 = false;
                    }
                }
                if (z2) {
                    arrayList.add(enumC11485a);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$b */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public /* synthetic */ class b extends C12235j implements Function1<InterfaceC11330e, InterfaceC11340c> {
        public b(C11489c c11489c) {
            super(1, c11489c);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final KDeclarationContainer getOwner() {
            return C12216a0.getOrCreateKotlinClass(C11489c.class);
        }

        @Override // p507d0.p592z.p594d.AbstractC12221d
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11340c invoke(InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11330e, "p0");
            return C11489c.access$computeTypeQualifierNickname((C11489c) this.receiver, interfaceC11330e);
        }
    }

    public C11489c(InterfaceC11905o interfaceC11905o, C12037e c12037e) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(c12037e, "javaTypeEnhancementState");
        this.f23187a = c12037e;
        this.f23188b = interfaceC11905o.createMemoizedFunctionWithNullableValues(new b(this));
    }

    public static final InterfaceC11340c access$computeTypeQualifierNickname(C11489c c11489c, InterfaceC11330e interfaceC11330e) {
        Objects.requireNonNull(c11489c);
        if (!interfaceC11330e.getAnnotations().hasAnnotation(C11487b.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        Iterator<InterfaceC11340c> it = interfaceC11330e.getAnnotations().iterator();
        while (it.hasNext()) {
            InterfaceC11340c interfaceC11340cResolveTypeQualifierAnnotation = c11489c.resolveTypeQualifierAnnotation(it.next());
            if (interfaceC11340cResolveTypeQualifierAnnotation != null) {
                return interfaceC11340cResolveTypeQualifierAnnotation;
            }
        }
        return null;
    }

    public static final List access$toKotlinTargetNames(C11489c c11489c, String str) {
        Objects.requireNonNull(c11489c);
        Set<EnumC11351n> setMapJavaTargetArgumentByName = C11501d.f23236a.mapJavaTargetArgumentByName(str);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(setMapJavaTargetArgumentByName, 10));
        Iterator<T> it = setMapJavaTargetArgumentByName.iterator();
        while (it.hasNext()) {
            arrayList.add(((EnumC11351n) it.next()).name());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final List<EnumC11485a> m9448a(AbstractC11815g<?> abstractC11815g, Function2<? super C11818j, ? super EnumC11485a, Boolean> function2) {
        EnumC11485a enumC11485a;
        if (abstractC11815g instanceof C11809b) {
            List<? extends AbstractC11815g<?>> value = ((C11809b) abstractC11815g).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                C12160r.addAll(arrayList, m9448a((AbstractC11815g) it.next(), function2));
            }
            return arrayList;
        }
        if (!(abstractC11815g instanceof C11818j)) {
            return C12147n.emptyList();
        }
        EnumC11485a[] enumC11485aArrValuesCustom = EnumC11485a.valuesCustom();
        for (int i = 0; i < 6; i++) {
            enumC11485a = enumC11485aArrValuesCustom[i];
            if (function2.invoke(abstractC11815g, enumC11485a).booleanValue()) {
                return C12147n.listOfNotNull(enumC11485a);
            }
        }
        enumC11485a = null;
        return C12147n.listOfNotNull(enumC11485a);
    }

    public final a resolveAnnotation(InterfaceC11340c interfaceC11340c) {
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        InterfaceC11330e annotationClass = C11836a.getAnnotationClass(interfaceC11340c);
        if (annotationClass == null) {
            return null;
        }
        InterfaceC11344g annotations = annotationClass.getAnnotations();
        C11713b c11713b = C11486a0.f23149c;
        C12238m.checkNotNullExpressionValue(c11713b, "TARGET_ANNOTATION");
        InterfaceC11340c interfaceC11340cFindAnnotation = annotations.findAnnotation(c11713b);
        if (interfaceC11340cFindAnnotation == null) {
            return null;
        }
        Map<C11716e, AbstractC11815g<?>> allValueArguments = interfaceC11340cFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<C11716e, AbstractC11815g<?>>> it = allValueArguments.entrySet().iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList, m9448a(it.next().getValue(), new C11493e(this)));
        }
        int iOrdinal = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((EnumC11485a) it2.next()).ordinal();
        }
        return new a(interfaceC11340c, iOrdinal);
    }

    public final EnumC12040h resolveJsr305AnnotationState(InterfaceC11340c interfaceC11340c) {
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        EnumC12040h enumC12040hResolveJsr305CustomState = resolveJsr305CustomState(interfaceC11340c);
        return enumC12040hResolveJsr305CustomState == null ? this.f23187a.getGlobalJsr305Level() : enumC12040hResolveJsr305CustomState;
    }

    public final EnumC12040h resolveJsr305CustomState(InterfaceC11340c interfaceC11340c) {
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        Map<String, EnumC12040h> userDefinedLevelForSpecificJsr305Annotation = this.f23187a.getUserDefinedLevelForSpecificJsr305Annotation();
        C11713b fqName = interfaceC11340c.getFqName();
        EnumC12040h enumC12040h = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (enumC12040h != null) {
            return enumC12040h;
        }
        InterfaceC11330e annotationClass = C11836a.getAnnotationClass(interfaceC11340c);
        if (annotationClass == null) {
            return null;
        }
        InterfaceC11340c interfaceC11340cFindAnnotation = annotationClass.getAnnotations().findAnnotation(C11487b.getMIGRATION_ANNOTATION_FQNAME());
        AbstractC11815g<?> abstractC11815gFirstArgument = interfaceC11340cFindAnnotation == null ? null : C11836a.firstArgument(interfaceC11340cFindAnnotation);
        C11818j c11818j = abstractC11815gFirstArgument instanceof C11818j ? (C11818j) abstractC11815gFirstArgument : null;
        if (c11818j == null) {
            return null;
        }
        EnumC12040h migrationLevelForJsr305 = this.f23187a.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            return migrationLevelForJsr305;
        }
        String strAsString = c11818j.getEnumEntryName().asString();
        int iHashCode = strAsString.hashCode();
        if (iHashCode == -2137067054) {
            if (strAsString.equals("IGNORE")) {
                return EnumC12040h.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strAsString.equals("STRICT")) {
                return EnumC12040h.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strAsString.equals("WARN")) {
            return EnumC12040h.WARN;
        }
        return null;
    }

    public final C11627u resolveQualifierBuiltInDefaultAnnotation(InterfaceC11340c interfaceC11340c) {
        C11627u c11627u;
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        if (this.f23187a.getDisabledDefaultAnnotations() || (c11627u = C11487b.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(interfaceC11340c.getFqName())) == null) {
            return null;
        }
        EnumC12040h jspecifyReportLevel = C11487b.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(interfaceC11340c.getFqName()) ? this.f23187a.getJspecifyReportLevel() : resolveJsr305AnnotationState(interfaceC11340c);
        if (!(jspecifyReportLevel != EnumC12040h.IGNORE)) {
            jspecifyReportLevel = null;
        }
        if (jspecifyReportLevel == null) {
            return null;
        }
        return C11627u.copy$default(c11627u, C11603i.copy$default(c11627u.getNullabilityQualifier(), null, jspecifyReportLevel.isWarning(), 1, null), null, false, 6, null);
    }

    public final InterfaceC11340c resolveTypeQualifierAnnotation(InterfaceC11340c interfaceC11340c) {
        InterfaceC11330e annotationClass;
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        if (this.f23187a.getDisabledJsr305() || (annotationClass = C11836a.getAnnotationClass(interfaceC11340c)) == null) {
            return null;
        }
        if (C11495f.access$isAnnotatedWithTypeQualifier(annotationClass)) {
            return interfaceC11340c;
        }
        if (annotationClass.getKind() != EnumC11333f.ANNOTATION_CLASS) {
            return null;
        }
        return this.f23188b.invoke(annotationClass);
    }

    public final a resolveTypeQualifierDefaultAnnotation(InterfaceC11340c interfaceC11340c) {
        InterfaceC11340c next;
        C12238m.checkNotNullParameter(interfaceC11340c, "annotationDescriptor");
        if (this.f23187a.getDisabledJsr305()) {
            return null;
        }
        InterfaceC11330e annotationClass = C11836a.getAnnotationClass(interfaceC11340c);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(C11487b.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        InterfaceC11330e annotationClass2 = C11836a.getAnnotationClass(interfaceC11340c);
        C12238m.checkNotNull(annotationClass2);
        InterfaceC11340c interfaceC11340cFindAnnotation = annotationClass2.getAnnotations().findAnnotation(C11487b.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        C12238m.checkNotNull(interfaceC11340cFindAnnotation);
        Map<C11716e, AbstractC11815g<?>> allValueArguments = interfaceC11340cFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<C11716e, AbstractC11815g<?>> entry : allValueArguments.entrySet()) {
            C12160r.addAll(arrayList, C12238m.areEqual(entry.getKey(), C11486a0.f23148b) ? m9448a(entry.getValue(), C11491d.f23191j) : C12147n.emptyList());
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((EnumC11485a) it.next()).ordinal();
        }
        Iterator<InterfaceC11340c> it2 = annotationClass.getAnnotations().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!(resolveTypeQualifierAnnotation(next) != null));
        InterfaceC11340c interfaceC11340c2 = next;
        if (interfaceC11340c2 == null) {
            return null;
        }
        return new a(interfaceC11340c2, iOrdinal);
    }
}
