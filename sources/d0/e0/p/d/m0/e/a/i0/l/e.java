package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.t;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LazyJavaAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.e.a.h0.i {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.i0.g f3327b;
    public final d0.e0.p.d.m0.e.a.k0.a c;
    public final d0.e0.p.d.m0.m.k d;
    public final d0.e0.p.d.m0.m.j e;
    public final d0.e0.p.d.m0.e.a.j0.a f;
    public final d0.e0.p.d.m0.m.j g;
    public final boolean h;
    public final boolean i;

    public e(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(aVar, "javaAnnotation");
        this.f3327b = gVar;
        this.c = aVar;
        this.d = gVar.getStorageManager().createNullableLazyValue(new e$b(this));
        this.e = gVar.getStorageManager().createLazyValue(new e$c(this));
        this.f = gVar.getComponents().getSourceElementFactory().source(aVar);
        this.g = gVar.getStorageManager().createLazyValue(new e$a(this));
        this.h = aVar.isIdeExternalAnnotation();
        this.i = aVar.isFreshlySupportedTypeUseAnnotation() || z2;
    }

    public static final d0.e0.p.d.m0.c.e access$createTypeForMissingDependencies(e eVar, d0.e0.p.d.m0.g.b bVar) {
        c0 module = eVar.f3327b.getModule();
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(bVar);
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(fqName)");
        return w.findNonGenericClassAcrossDependencies(module, aVar, eVar.f3327b.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(e eVar) {
        return eVar.f3327b;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.k0.a access$getJavaAnnotation$p(e eVar) {
        return eVar.c;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.k.v.g access$resolveAnnotationArgument(e eVar, d0.e0.p.d.m0.e.a.k0.b bVar) {
        return eVar.a(bVar);
    }

    public final d0.e0.p.d.m0.k.v.g<?> a(d0.e0.p.d.m0.e.a.k0.b bVar) {
        d0.e0.p.d.m0.k.v.g<?> aVar;
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.o) {
            return d0.e0.p.d.m0.k.v.h.a.createConstantValue(((d0.e0.p.d.m0.e.a.k0.o) bVar).getValue());
        }
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.m) {
            d0.e0.p.d.m0.e.a.k0.m mVar = (d0.e0.p.d.m0.e.a.k0.m) bVar;
            d0.e0.p.d.m0.g.a enumClassId = mVar.getEnumClassId();
            d0.e0.p.d.m0.g.e entryName = mVar.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new d0.e0.p.d.m0.k.v.j(enumClassId, entryName);
        }
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.e) {
            d0.e0.p.d.m0.g.e name = bVar.getName();
            if (name == null) {
                name = d0.e0.p.d.m0.e.a.a0.f3305b;
            }
            d0.z.d.m.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<d0.e0.p.d.m0.e.a.k0.b> elements = ((d0.e0.p.d.m0.e.a.k0.e) bVar).getElements();
            j0 type = getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "type");
            if (e0.isError(type)) {
                return null;
            }
            d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(this);
            d0.z.d.m.checkNotNull(annotationClass);
            c1 annotationParameterByName = d0.e0.p.d.m0.e.a.g0.a.getAnnotationParameterByName(name, annotationClass);
            d0.e0.p.d.m0.n.c0 type2 = annotationParameterByName != null ? annotationParameterByName.getType() : null;
            if (type2 == null) {
                type2 = this.f3327b.getComponents().getModule().getBuiltIns().getArrayType(j1.INVARIANT, t.createErrorType("Unknown array element type"));
            }
            d0.z.d.m.checkNotNullExpressionValue(type2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                d0.e0.p.d.m0.k.v.g<?> gVarA = a((d0.e0.p.d.m0.e.a.k0.b) it.next());
                if (gVarA == null) {
                    gVarA = new d0.e0.p.d.m0.k.v.t();
                }
                arrayList.add(gVarA);
            }
            aVar = d0.e0.p.d.m0.k.v.h.a.createArrayValue(arrayList, type2);
        } else {
            if (!(bVar instanceof d0.e0.p.d.m0.e.a.k0.c)) {
                if (bVar instanceof d0.e0.p.d.m0.e.a.k0.h) {
                    return d0.e0.p.d.m0.k.v.r.f3476b.create(this.f3327b.getTypeResolver().transformJavaType(((d0.e0.p.d.m0.e.a.k0.h) bVar).getReferencedType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null)));
                }
                return null;
            }
            aVar = new d0.e0.p.d.m0.k.v.a(new e(this.f3327b, ((d0.e0.p.d.m0.e.a.k0.c) bVar).getAnnotation(), false, 4, null));
        }
        return aVar;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return (Map) d0.e0.p.d.m0.m.n.getValue(this.g, this, (KProperty<?>) a[2]);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.g.b getFqName() {
        return (d0.e0.p.d.m0.g.b) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) a[0]);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public /* bridge */ /* synthetic */ u0 getSource() {
        return getSource();
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 getType() {
        return getType();
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.i;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.i
    public boolean isIdeExternalAnnotation() {
        return this.h;
    }

    public String toString() {
        return d0.e0.p.d.m0.j.c.renderAnnotation$default(d0.e0.p.d.m0.j.c.f3439b, this, null, 2, null);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.e.a.j0.a getSource() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public j0 getType() {
        return (j0) d0.e0.p.d.m0.m.n.getValue(this.e, this, (KProperty<?>) a[1]);
    }

    public /* synthetic */ e(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.a aVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, aVar, (i & 4) != 0 ? false : z2);
    }
}
