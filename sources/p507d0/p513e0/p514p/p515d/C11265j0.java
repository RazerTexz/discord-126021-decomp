package p507d0.p513e0.p514p.p515d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p516l0.C11270b;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11303c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11409b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11412e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11413f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11418k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11420m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11435n;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11424c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11431j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11657r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11819k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11828t;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11876l;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11885u;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12251z;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.j0 */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11265j0 {

    /* JADX INFO: renamed from: a */
    public static final C11713b f22397a = new C11713b("kotlin.jvm.JvmStatic");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: a */
    public static final Class<?> m9349a(ClassLoader classLoader, C11712a c11712a, int i) {
        C11303c c11303c = C11303c.f22614a;
        C11714c unsafe = c11712a.asSingleFqName().toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        C11712a c11712aMapKotlinToJava = c11303c.mapKotlinToJava(unsafe);
        if (c11712aMapKotlinToJava != null) {
            c11712a = c11712aMapKotlinToJava;
        }
        String strAsString = c11712a.getPackageFqName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "javaClassId.packageFqName.asString()");
        String strAsString2 = c11712a.getRelativeClassName().asString();
        C12238m.checkNotNullExpressionValue(strAsString2, "javaClassId.relativeClassName.asString()");
        if (C12238m.areEqual(strAsString, "kotlin")) {
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
        String str = strAsString + '.' + C12103t.replace$default(strAsString2, '.', '$', false, 4, (Object) null);
        if (i > 0) {
            str = C12103t.repeat("[", i) + 'L' + str + ';';
        }
        return C11412e.tryLoadClass(classLoader, str);
    }

    public static final C11264j asKFunctionImpl(Object obj) {
        C11264j c11264j = (C11264j) (!(obj instanceof C11264j) ? null : obj);
        if (c11264j != null) {
            return c11264j;
        }
        if (!(obj instanceof C12235j)) {
            obj = null;
        }
        C12235j c12235j = (C12235j) obj;
        KCallable kCallableCompute = c12235j != null ? c12235j.compute() : null;
        return (C11264j) (kCallableCompute instanceof C11264j ? kCallableCompute : null);
    }

    public static final AbstractC12053s<?> asKPropertyImpl(Object obj) {
        AbstractC12053s<?> abstractC12053s = (AbstractC12053s) (!(obj instanceof AbstractC12053s) ? null : obj);
        if (abstractC12053s != null) {
            return abstractC12053s;
        }
        if (!(obj instanceof AbstractC12251z)) {
            obj = null;
        }
        AbstractC12251z abstractC12251z = (AbstractC12251z) obj;
        KCallable kCallableCompute = abstractC12251z != null ? abstractC12251z.compute() : null;
        return (AbstractC12053s) (kCallableCompute instanceof AbstractC12053s ? kCallableCompute : null);
    }

    /* JADX INFO: renamed from: b */
    public static final Annotation m9350b(InterfaceC11340c interfaceC11340c) {
        InterfaceC11330e annotationClass = C11836a.getAnnotationClass(interfaceC11340c);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map.Entry<C11716e, AbstractC11815g<?>>> setEntrySet = interfaceC11340c.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            C11716e c11716e = (C11716e) entry.getKey();
            AbstractC11815g abstractC11815g = (AbstractC11815g) entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            C12238m.checkNotNullExpressionValue(classLoader, "annotationClass.classLoader");
            Object objM9351c = m9351c(abstractC11815g, classLoader);
            Pair pairM10073to = objM9351c != null ? C12116o.m10073to(c11716e.asString(), objM9351c) : null;
            if (pairM10073to != null) {
                arrayList.add(pairM10073to);
            }
        }
        return (Annotation) C11270b.createAnnotationInstance$default(javaClass, C12136h0.toMap(arrayList), null, 4, null);
    }

    /* JADX INFO: renamed from: c */
    public static final Object m9351c(AbstractC11815g<?> abstractC11815g, ClassLoader classLoader) {
        if (abstractC11815g instanceof C11807a) {
            return m9350b(((C11807a) abstractC11815g).getValue());
        }
        if (abstractC11815g instanceof C11809b) {
            List<? extends AbstractC11815g<?>> value = ((C11809b) abstractC11815g).getValue();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(m9351c((AbstractC11815g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        }
        if (abstractC11815g instanceof C11818j) {
            Pair<? extends C11712a, ? extends C11716e> value2 = ((C11818j) abstractC11815g).getValue();
            C11712a c11712aComponent1 = value2.component1();
            C11716e c11716eComponent2 = value2.component2();
            Class<?> clsM9349a = m9349a(classLoader, c11712aComponent1, 0);
            if (clsM9349a != null) {
                return C11263i0.getEnumConstantByName(clsM9349a, c11716eComponent2.asString());
            }
            return null;
        }
        if (!(abstractC11815g instanceof C11826r)) {
            if ((abstractC11815g instanceof AbstractC11819k) || (abstractC11815g instanceof C11828t)) {
                return null;
            }
            return abstractC11815g.getValue();
        }
        C11826r.b value3 = ((C11826r) abstractC11815g).getValue();
        if (value3 instanceof C11826r.b.C13329b) {
            C11826r.b.C13329b c13329b = (C11826r.b.C13329b) value3;
            return m9349a(classLoader, c13329b.getClassId(), c13329b.getArrayDimensions());
        }
        if (!(value3 instanceof C11826r.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC11352h declarationDescriptor = ((C11826r.b.a) value3).getType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof InterfaceC11330e)) {
            declarationDescriptor = null;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) declarationDescriptor;
        if (interfaceC11330e != null) {
            return toJavaClass(interfaceC11330e);
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(InterfaceC11338a interfaceC11338a) {
        C12238m.checkNotNullParameter(interfaceC11338a, "$this$computeAnnotations");
        InterfaceC11344g annotations = interfaceC11338a.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11340c interfaceC11340c : annotations) {
            InterfaceC11467u0 source = interfaceC11340c.getSource();
            Annotation annotationM9350b = null;
            if (source instanceof C11409b) {
                annotationM9350b = ((C11409b) source).getAnnotation();
            } else if (source instanceof C11420m.a) {
                AbstractC11435n javaElement = ((C11420m.a) source).getJavaElement();
                if (!(javaElement instanceof C11424c)) {
                    javaElement = null;
                }
                C11424c c11424c = (C11424c) javaElement;
                if (c11424c != null) {
                    annotationM9350b = c11424c.getAnnotation();
                }
            } else {
                annotationM9350b = m9350b(interfaceC11340c);
            }
            if (annotationM9350b != null) {
                arrayList.add(annotationM9350b);
            }
        }
        return arrayList;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        C12238m.checkNotNullParameter(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (C12238m.areEqual(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (C12238m.areEqual(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (C12238m.areEqual(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (C12238m.areEqual(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (C12238m.areEqual(type, Integer.TYPE)) {
            return 0;
        }
        if (C12238m.areEqual(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (C12238m.areEqual(type, Long.TYPE)) {
            return 0L;
        }
        if (C12238m.areEqual(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (C12238m.areEqual(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException(C1643a.m887z("Unknown primitive: ", type));
    }

    public static final <M extends InterfaceC11734n, D extends InterfaceC11318a> D deserializeToDescriptor(Class<?> cls, M m, InterfaceC11704c interfaceC11704c, C11708g c11708g, AbstractC11702a abstractC11702a, Function2<? super C11885u, ? super M, ? extends D> function2) {
        List<C11694s> typeParameterList;
        C12238m.checkNotNullParameter(cls, "moduleAnchor");
        C12238m.checkNotNullParameter(m, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C12238m.checkNotNullParameter(function2, "createDescriptor");
        C11418k orCreateModule = C11249b0.getOrCreateModule(cls);
        if (m instanceof C11684i) {
            typeParameterList = ((C11684i) m).getTypeParameterList();
        } else {
            if (!(m instanceof C11689n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            typeParameterList = ((C11689n) m).getTypeParameterList();
        }
        List<C11694s> list = typeParameterList;
        C11874j deserialization = orCreateModule.getDeserialization();
        InterfaceC11325c0 module = orCreateModule.getModule();
        C11710i empty = C11710i.f24073a.getEMPTY();
        C12238m.checkNotNullExpressionValue(list, "typeParameters");
        return function2.invoke(new C11885u(new C11876l(deserialization, interfaceC11704c, module, c11708g, empty, abstractC11702a, null, null, list)), m);
    }

    public static final InterfaceC11459q0 getInstanceReceiverParameter(InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11318a, "$this$instanceReceiverParameter");
        if (interfaceC11318a.getDispatchReceiverParameter() == null) {
            return null;
        }
        InterfaceC11450m containingDeclaration = interfaceC11318a.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((InterfaceC11330e) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final C11713b getJVM_STATIC() {
        return f22397a;
    }

    public static final boolean isInlineClassType(KType kType) {
        AbstractC11913c0 type;
        C12238m.checkNotNullParameter(kType, "$this$isInlineClassType");
        if (!(kType instanceof C12058x)) {
            kType = null;
        }
        C12058x c12058x = (C12058x) kType;
        return (c12058x == null || (type = c12058x.getType()) == null || !C11789g.isInlineClassType(type)) ? false : true;
    }

    public static final Class<?> toJavaClass(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "$this$toJavaClass");
        InterfaceC11467u0 source = interfaceC11330e.getSource();
        C12238m.checkNotNullExpressionValue(source, "source");
        if (source instanceof C11657r) {
            InterfaceC11655p binaryClass = ((C11657r) source).getBinaryClass();
            Objects.requireNonNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((C11413f) binaryClass).getKlass();
        }
        if (source instanceof C11420m.a) {
            AbstractC11435n javaElement = ((C11420m.a) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((C11431j) javaElement).getElement();
        }
        C11712a classId = C11836a.getClassId(interfaceC11330e);
        if (classId != null) {
            return m9349a(C11423b.getSafeClassLoader(interfaceC11330e.getClass()), classId, 0);
        }
        return null;
    }

    public static final KVisibility toKVisibility(AbstractC11466u abstractC11466u) {
        C12238m.checkNotNullParameter(abstractC11466u, "$this$toKVisibility");
        if (C12238m.areEqual(abstractC11466u, C11464t.f23087e)) {
            return KVisibility.PUBLIC;
        }
        if (C12238m.areEqual(abstractC11466u, C11464t.f23085c)) {
            return KVisibility.PROTECTED;
        }
        if (C12238m.areEqual(abstractC11466u, C11464t.f23086d)) {
            return KVisibility.INTERNAL;
        }
        if (C12238m.areEqual(abstractC11466u, C11464t.f23083a) || C12238m.areEqual(abstractC11466u, C11464t.f23084b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }
}
