package d0.e0.p.d;

import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.k.v.r$b$a;
import d0.e0.p.d.m0.k.v.r$b$b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public static final d0.e0.p.d.m0.g.b a = new d0.e0.p.d.m0.g.b("kotlin.jvm.JvmStatic");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class<?> a(ClassLoader classLoader, d0.e0.p.d.m0.g.a aVar, int i) {
        d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
        d0.e0.p.d.m0.g.c unsafe = aVar.asSingleFqName().toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        d0.e0.p.d.m0.g.a aVarMapKotlinToJava = cVar.mapKotlinToJava(unsafe);
        if (aVarMapKotlinToJava != null) {
            aVar = aVarMapKotlinToJava;
        }
        String strAsString = aVar.getPackageFqName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "javaClassId.packageFqName.asString()");
        String strAsString2 = aVar.getRelativeClassName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString2, "javaClassId.relativeClassName.asString()");
        if (d0.z.d.m.areEqual(strAsString, "kotlin")) {
            switch (strAsString2.hashCode()) {
                case -901856463:
                    if (strAsString2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (strAsString2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (strAsString2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (strAsString2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (strAsString2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (strAsString2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (strAsString2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (strAsString2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (strAsString2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str = strAsString + '.' + d0.g0.t.replace$default(strAsString2, '.', '$', false, 4, (Object) null);
        if (i > 0) {
            str = d0.g0.t.repeat("[", i) + 'L' + str + ';';
        }
        return d0.e0.p.d.m0.c.k1.a.e.tryLoadClass(classLoader, str);
    }

    public static final j asKFunctionImpl(Object obj) {
        j jVar = (j) (!(obj instanceof j) ? null : obj);
        if (jVar != null) {
            return jVar;
        }
        if (!(obj instanceof d0.z.d.j)) {
            obj = null;
        }
        d0.z.d.j jVar2 = (d0.z.d.j) obj;
        KCallable kCallableCompute = jVar2 != null ? jVar2.compute() : null;
        return (j) (kCallableCompute instanceof j ? kCallableCompute : null);
    }

    public static final s<?> asKPropertyImpl(Object obj) {
        s<?> sVar = (s) (!(obj instanceof s) ? null : obj);
        if (sVar != null) {
            return sVar;
        }
        if (!(obj instanceof d0.z.d.z)) {
            obj = null;
        }
        d0.z.d.z zVar = (d0.z.d.z) obj;
        KCallable kCallableCompute = zVar != null ? zVar.compute() : null;
        return (s) (kCallableCompute instanceof s ? kCallableCompute : null);
    }

    public static final Annotation b(d0.e0.p.d.m0.c.g1.c cVar) {
        d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map$Entry<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>>> setEntrySet = cVar.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            d0.e0.p.d.m0.g.e eVar = (d0.e0.p.d.m0.g.e) map$Entry.getKey();
            d0.e0.p.d.m0.k.v.g gVar = (d0.e0.p.d.m0.k.v.g) map$Entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            d0.z.d.m.checkNotNullExpressionValue(classLoader, "annotationClass.classLoader");
            Object objC = c(gVar, classLoader);
            Pair pair = objC != null ? d0.o.to(eVar.asString(), objC) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) d0.e0.p.d.l0.b.createAnnotationInstance$default(javaClass, d0.t.h0.toMap(arrayList), null, 4, null);
    }

    public static final Object c(d0.e0.p.d.m0.k.v.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof d0.e0.p.d.m0.k.v.a) {
            return b(((d0.e0.p.d.m0.k.v.a) gVar).getValue());
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            List<? extends d0.e0.p.d.m0.k.v.g<?>> value = ((d0.e0.p.d.m0.k.v.b) gVar).getValue();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(c((d0.e0.p.d.m0.k.v.g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.j) {
            Pair<? extends d0.e0.p.d.m0.g.a, ? extends d0.e0.p.d.m0.g.e> value2 = ((d0.e0.p.d.m0.k.v.j) gVar).getValue();
            d0.e0.p.d.m0.g.a aVarComponent1 = value2.component1();
            d0.e0.p.d.m0.g.e eVarComponent2 = value2.component2();
            Class<?> clsA = a(classLoader, aVarComponent1, 0);
            if (clsA != null) {
                return i0.getEnumConstantByName(clsA, eVarComponent2.asString());
            }
            return null;
        }
        if (!(gVar instanceof d0.e0.p.d.m0.k.v.r)) {
            if ((gVar instanceof d0.e0.p.d.m0.k.v.k) || (gVar instanceof d0.e0.p.d.m0.k.v.t)) {
                return null;
            }
            return gVar.getValue();
        }
        d0.e0.p.d.m0.k.v.r$b value3 = ((d0.e0.p.d.m0.k.v.r) gVar).getValue();
        if (value3 instanceof r$b$b) {
            r$b$b r_b_b = (r$b$b) value3;
            return a(classLoader, r_b_b.getClassId(), r_b_b.getArrayDimensions());
        }
        if (!(value3 instanceof r$b$a)) {
            throw new NoWhenBranchMatchedException();
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = ((r$b$a) value3).getType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            declarationDescriptor = null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) declarationDescriptor;
        if (eVar != null) {
            return toJavaClass(eVar);
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(d0.e0.p.d.m0.c.g1.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "$this$computeAnnotations");
        d0.e0.p.d.m0.c.g1.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.c.g1.c cVar : annotations) {
            u0 source = cVar.getSource();
            Annotation annotationB = null;
            if (source instanceof d0.e0.p.d.m0.c.k1.a.b) {
                annotationB = ((d0.e0.p.d.m0.c.k1.a.b) source).getAnnotation();
            } else if (source instanceof d0.e0.p.d.m0.c.k1.a.m$a) {
                d0.e0.p.d.m0.c.k1.b.n javaElement = ((d0.e0.p.d.m0.c.k1.a.m$a) source).getJavaElement();
                if (!(javaElement instanceof d0.e0.p.d.m0.c.k1.b.c)) {
                    javaElement = null;
                }
                d0.e0.p.d.m0.c.k1.b.c cVar2 = (d0.e0.p.d.m0.c.k1.b.c) javaElement;
                if (cVar2 != null) {
                    annotationB = cVar2.getAnnotation();
                }
            } else {
                annotationB = b(cVar);
            }
            if (annotationB != null) {
                arrayList.add(annotationB);
            }
        }
        return arrayList;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        d0.z.d.m.checkNotNullParameter(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (d0.z.d.m.areEqual(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (d0.z.d.m.areEqual(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (d0.z.d.m.areEqual(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (d0.z.d.m.areEqual(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (d0.z.d.m.areEqual(type, Integer.TYPE)) {
            return 0;
        }
        if (d0.z.d.m.areEqual(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (d0.z.d.m.areEqual(type, Long.TYPE)) {
            return 0L;
        }
        if (d0.z.d.m.areEqual(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (d0.z.d.m.areEqual(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException(b.d.b.a.a.z("Unknown primitive: ", type));
    }

    public static final <M extends d0.e0.p.d.m0.i.n, D extends d0.e0.p.d.m0.c.a> D deserializeToDescriptor(Class<?> cls, M m, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.f.z.a aVar, Function2<? super d0.e0.p.d.m0.l.b.u, ? super M, ? extends D> function2) {
        List<d0.e0.p.d.m0.f.s> typeParameterList;
        d0.z.d.m.checkNotNullParameter(cls, "moduleAnchor");
        d0.z.d.m.checkNotNullParameter(m, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(function2, "createDescriptor");
        d0.e0.p.d.m0.c.k1.a.k orCreateModule = b0.getOrCreateModule(cls);
        if (m instanceof d0.e0.p.d.m0.f.i) {
            typeParameterList = ((d0.e0.p.d.m0.f.i) m).getTypeParameterList();
        } else {
            if (!(m instanceof d0.e0.p.d.m0.f.n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            typeParameterList = ((d0.e0.p.d.m0.f.n) m).getTypeParameterList();
        }
        List<d0.e0.p.d.m0.f.s> list = typeParameterList;
        d0.e0.p.d.m0.l.b.j deserialization = orCreateModule.getDeserialization();
        d0.e0.p.d.m0.c.c0 module = orCreateModule.getModule();
        d0.e0.p.d.m0.f.z.i empty = d0.e0.p.d.m0.f.z.i.a.getEMPTY();
        d0.z.d.m.checkNotNullExpressionValue(list, "typeParameters");
        return function2.invoke(new d0.e0.p.d.m0.l.b.u(new d0.e0.p.d.m0.l.b.l(deserialization, cVar, module, gVar, empty, aVar, null, null, list)), m);
    }

    public static final q0 getInstanceReceiverParameter(d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "$this$instanceReceiverParameter");
        if (aVar.getDispatchReceiverParameter() == null) {
            return null;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = aVar.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((d0.e0.p.d.m0.c.e) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final d0.e0.p.d.m0.g.b getJVM_STATIC() {
        return a;
    }

    public static final boolean isInlineClassType(KType kType) {
        d0.e0.p.d.m0.n.c0 type;
        d0.z.d.m.checkNotNullParameter(kType, "$this$isInlineClassType");
        if (!(kType instanceof x)) {
            kType = null;
        }
        x xVar = (x) kType;
        return (xVar == null || (type = xVar.getType()) == null || !d0.e0.p.d.m0.k.g.isInlineClassType(type)) ? false : true;
    }

    public static final Class<?> toJavaClass(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "$this$toJavaClass");
        u0 source = eVar.getSource();
        d0.z.d.m.checkNotNullExpressionValue(source, "source");
        if (source instanceof d0.e0.p.d.m0.e.b.r) {
            d0.e0.p.d.m0.e.b.p binaryClass = ((d0.e0.p.d.m0.e.b.r) source).getBinaryClass();
            Objects.requireNonNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((d0.e0.p.d.m0.c.k1.a.f) binaryClass).getKlass();
        }
        if (source instanceof d0.e0.p.d.m0.c.k1.a.m$a) {
            d0.e0.p.d.m0.c.k1.b.n javaElement = ((d0.e0.p.d.m0.c.k1.a.m$a) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((d0.e0.p.d.m0.c.k1.b.j) javaElement).getElement();
        }
        d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(eVar);
        if (classId != null) {
            return a(d0.e0.p.d.m0.c.k1.b.b.getSafeClassLoader(eVar.getClass()), classId, 0);
        }
        return null;
    }

    public static final KVisibility toKVisibility(d0.e0.p.d.m0.c.u uVar) {
        d0.z.d.m.checkNotNullParameter(uVar, "$this$toKVisibility");
        if (d0.z.d.m.areEqual(uVar, d0.e0.p.d.m0.c.t.e)) {
            return KVisibility.PUBLIC;
        }
        if (d0.z.d.m.areEqual(uVar, d0.e0.p.d.m0.c.t.c)) {
            return KVisibility.PROTECTED;
        }
        if (d0.z.d.m.areEqual(uVar, d0.e0.p.d.m0.c.t.d)) {
            return KVisibility.INTERNAL;
        }
        if (d0.z.d.m.areEqual(uVar, d0.e0.p.d.m0.c.t.a) || d0.z.d.m.areEqual(uVar, d0.e0.p.d.m0.c.t.f3300b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }
}
