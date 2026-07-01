package d0.e0.p.d.m0.e.a.g0;

import d0.Tuples;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.KotlinRetention;
import d0.e0.p.d.m0.c.g1.KotlinTarget;
import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.e.a.k0.annotationArguments5;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.d, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationMapper3 {
    public static final JavaAnnotationMapper3 a = new JavaAnnotationMapper3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, EnumSet<KotlinTarget>> f3316b = Maps6.mapOf(Tuples.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), Tuples.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), Tuples.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), Tuples.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), Tuples.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), Tuples.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), Tuples.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), Tuples.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), Tuples.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), Tuples.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    public static final Map<String, KotlinRetention> c = Maps6.mapOf(Tuples.to("RUNTIME", KotlinRetention.RUNTIME), Tuples.to("CLASS", KotlinRetention.BINARY), Tuples.to("SOURCE", KotlinRetention.SOURCE));

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.d$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper2.a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), moduleDescriptor2.getBuiltIns().getBuiltInClassByFqName(StandardNames.a.A));
            KotlinType type = annotationParameterByName == null ? null : annotationParameterByName.getType();
            if (type != null) {
                return type;
            }
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
            return kotlinType4CreateErrorType;
        }
    }

    public final d0.e0.p.d.m0.k.v.g<?> mapJavaRetentionArgument$descriptors_jvm(annotationArguments annotationarguments) {
        annotationArguments5 annotationarguments5 = annotationarguments instanceof annotationArguments5 ? (annotationArguments5) annotationarguments : null;
        if (annotationarguments5 == null) {
            return null;
        }
        Map<String, KotlinRetention> map = c;
        Name entryName = annotationarguments5.getEntryName();
        KotlinRetention kotlinRetention = map.get(entryName == null ? null : entryName.asString());
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(StandardNames.a.C);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationRetention)");
        Name nameIdentifier = Name.identifier(kotlinRetention.name());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(retention.name)");
        return new d0.e0.p.d.m0.k.v.j(classId, nameIdentifier);
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String str) {
        EnumSet<KotlinTarget> enumSet = f3316b.get(str);
        return enumSet == null ? Sets5.emptySet() : enumSet;
    }

    public final d0.e0.p.d.m0.k.v.g<?> mapJavaTargetArguments$descriptors_jvm(List<? extends annotationArguments> list) {
        Intrinsics3.checkNotNullParameter(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof annotationArguments5) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Name entryName = ((annotationArguments5) it.next()).getEntryName();
            MutableCollections.addAll(arrayList2, mapJavaTargetArgumentByName(entryName == null ? null : entryName.asString()));
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            ClassId classId = ClassId.topLevel(StandardNames.a.B);
            Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationTarget)");
            Name nameIdentifier = Name.identifier(kotlinTarget.name());
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new d0.e0.p.d.m0.k.v.j(classId, nameIdentifier));
        }
        return new d0.e0.p.d.m0.k.v.b(arrayList3, a.j);
    }
}
