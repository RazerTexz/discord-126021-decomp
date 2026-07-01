package d0.e0.p.d.m0.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final d0.e0.p.d.m0.p.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.g1.c> f3309b;

    public c(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.p.e eVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(eVar, "javaTypeEnhancementState");
        this.a = eVar;
        this.f3309b = oVar.createMemoizedFunctionWithNullableValues(new c$b(this));
    }

    public static final d0.e0.p.d.m0.c.g1.c access$computeTypeQualifierNickname(c cVar, d0.e0.p.d.m0.c.e eVar) {
        Objects.requireNonNull(cVar);
        if (!eVar.getAnnotations().hasAnnotation(b.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        Iterator<d0.e0.p.d.m0.c.g1.c> it = eVar.getAnnotations().iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.g1.c cVarResolveTypeQualifierAnnotation = cVar.resolveTypeQualifierAnnotation(it.next());
            if (cVarResolveTypeQualifierAnnotation != null) {
                return cVarResolveTypeQualifierAnnotation;
            }
        }
        return null;
    }

    public static final List access$toKotlinTargetNames(c cVar, String str) {
        Objects.requireNonNull(cVar);
        Set<d0.e0.p.d.m0.c.g1.n> setMapJavaTargetArgumentByName = d0.e0.p.d.m0.e.a.g0.d.a.mapJavaTargetArgumentByName(str);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(setMapJavaTargetArgumentByName, 10));
        Iterator<T> it = setMapJavaTargetArgumentByName.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.g1.n) it.next()).name());
        }
        return arrayList;
    }

    public final List<a> a(d0.e0.p.d.m0.k.v.g<?> gVar, Function2<? super d0.e0.p.d.m0.k.v.j, ? super a, Boolean> function2) {
        a aVar;
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            List<? extends d0.e0.p.d.m0.k.v.g<?>> value = ((d0.e0.p.d.m0.k.v.b) gVar).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                d0.t.r.addAll(arrayList, a((d0.e0.p.d.m0.k.v.g) it.next(), function2));
            }
            return arrayList;
        }
        if (!(gVar instanceof d0.e0.p.d.m0.k.v.j)) {
            return d0.t.n.emptyList();
        }
        a[] aVarArrValuesCustom = a.valuesCustom();
        for (int i = 0; i < 6; i++) {
            aVar = aVarArrValuesCustom[i];
            if (function2.invoke(gVar, aVar).booleanValue()) {
                return d0.t.n.listOfNotNull(aVar);
            }
        }
        aVar = null;
        return d0.t.n.listOfNotNull(aVar);
    }

    public final c$a resolveAnnotation(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        if (annotationClass == null) {
            return null;
        }
        d0.e0.p.d.m0.c.g1.g annotations = annotationClass.getAnnotations();
        d0.e0.p.d.m0.g.b bVar = a0.c;
        d0.z.d.m.checkNotNullExpressionValue(bVar, "TARGET_ANNOTATION");
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotations.findAnnotation(bVar);
        if (cVarFindAnnotation == null) {
            return null;
        }
        Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = cVarFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        Iterator<Map$Entry<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>>> it = allValueArguments.entrySet().iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(arrayList, a(it.next().getValue(), new e(this)));
        }
        int iOrdinal = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((a) it2.next()).ordinal();
        }
        return new c$a(cVar, iOrdinal);
    }

    public final d0.e0.p.d.m0.p.h resolveJsr305AnnotationState(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        d0.e0.p.d.m0.p.h hVarResolveJsr305CustomState = resolveJsr305CustomState(cVar);
        return hVarResolveJsr305CustomState == null ? this.a.getGlobalJsr305Level() : hVarResolveJsr305CustomState;
    }

    public final d0.e0.p.d.m0.p.h resolveJsr305CustomState(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        Map<String, d0.e0.p.d.m0.p.h> userDefinedLevelForSpecificJsr305Annotation = this.a.getUserDefinedLevelForSpecificJsr305Annotation();
        d0.e0.p.d.m0.g.b fqName = cVar.getFqName();
        d0.e0.p.d.m0.p.h hVar = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (hVar != null) {
            return hVar;
        }
        d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        if (annotationClass == null) {
            return null;
        }
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotationClass.getAnnotations().findAnnotation(b.getMIGRATION_ANNOTATION_FQNAME());
        d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = cVarFindAnnotation == null ? null : d0.e0.p.d.m0.k.x.a.firstArgument(cVarFindAnnotation);
        d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
        if (jVar == null) {
            return null;
        }
        d0.e0.p.d.m0.p.h migrationLevelForJsr305 = this.a.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            return migrationLevelForJsr305;
        }
        String strAsString = jVar.getEnumEntryName().asString();
        int iHashCode = strAsString.hashCode();
        if (iHashCode == -2137067054) {
            if (strAsString.equals("IGNORE")) {
                return d0.e0.p.d.m0.p.h.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strAsString.equals("STRICT")) {
                return d0.e0.p.d.m0.p.h.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strAsString.equals("WARN")) {
            return d0.e0.p.d.m0.p.h.WARN;
        }
        return null;
    }

    public final u resolveQualifierBuiltInDefaultAnnotation(d0.e0.p.d.m0.c.g1.c cVar) {
        u uVar;
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        if (this.a.getDisabledDefaultAnnotations() || (uVar = b.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(cVar.getFqName())) == null) {
            return null;
        }
        d0.e0.p.d.m0.p.h jspecifyReportLevel = b.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(cVar.getFqName()) ? this.a.getJspecifyReportLevel() : resolveJsr305AnnotationState(cVar);
        if (!(jspecifyReportLevel != d0.e0.p.d.m0.p.h.IGNORE)) {
            jspecifyReportLevel = null;
        }
        if (jspecifyReportLevel == null) {
            return null;
        }
        return u.copy$default(uVar, d0.e0.p.d.m0.e.a.l0.i.copy$default(uVar.getNullabilityQualifier(), null, jspecifyReportLevel.isWarning(), 1, null), null, false, 6, null);
    }

    public final d0.e0.p.d.m0.c.g1.c resolveTypeQualifierAnnotation(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.e0.p.d.m0.c.e annotationClass;
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        if (this.a.getDisabledJsr305() || (annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar)) == null) {
            return null;
        }
        if (f.access$isAnnotatedWithTypeQualifier(annotationClass)) {
            return cVar;
        }
        if (annotationClass.getKind() != d0.e0.p.d.m0.c.f.ANNOTATION_CLASS) {
            return null;
        }
        return this.f3309b.invoke(annotationClass);
    }

    public final c$a resolveTypeQualifierDefaultAnnotation(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.e0.p.d.m0.c.g1.c next;
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        if (this.a.getDisabledJsr305()) {
            return null;
        }
        d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(b.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        d0.e0.p.d.m0.c.e annotationClass2 = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        d0.z.d.m.checkNotNull(annotationClass2);
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotationClass2.getAnnotations().findAnnotation(b.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        d0.z.d.m.checkNotNull(cVarFindAnnotation);
        Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = cVarFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map$Entry<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> map$Entry : allValueArguments.entrySet()) {
            d0.t.r.addAll(arrayList, d0.z.d.m.areEqual(map$Entry.getKey(), a0.f3305b) ? a(map$Entry.getValue(), d.j) : d0.t.n.emptyList());
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((a) it.next()).ordinal();
        }
        Iterator<d0.e0.p.d.m0.c.g1.c> it2 = annotationClass.getAnnotations().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!(resolveTypeQualifierAnnotation(next) != null));
        d0.e0.p.d.m0.c.g1.c cVar2 = next;
        if (cVar2 == null) {
            return null;
        }
        return new c$a(cVar2, iOrdinal);
    }
}
