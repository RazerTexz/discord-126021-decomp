package d0.e0.p.d;

import b.d.b.a.outline;
import d0.Tuples;
import d0.e0.p.d.l0.AnnotationConstructorCaller2;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.k1.a.ReflectAnnotationSource;
import d0.e0.p.d.m0.c.k1.a.ReflectJavaClassFinder2;
import d0.e0.p.d.m0.c.k1.a.ReflectKotlinClass2;
import d0.e0.p.d.m0.c.k1.a.RuntimeModuleData;
import d0.e0.p.d.m0.c.k1.a.RuntimeSourceElementFactory;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotation;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaClass;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaElement;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.KotlinJvmBinarySourceElement;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.k.v.r;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.l.b.context6;
import d0.e0.p.d.m0.n.KotlinType;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.PropertyReference;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;

/* JADX INFO: renamed from: d0.e0.p.d.j0, reason: use source file name */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class util2 {
    public static final FqName a = new FqName("kotlin.jvm.JvmStatic");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class<?> a(ClassLoader classLoader, ClassId classId, int i) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId classIdMapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (classIdMapKotlinToJava != null) {
            classId = classIdMapKotlinToJava;
        }
        String strAsString = classId.getPackageFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "javaClassId.packageFqName.asString()");
        String strAsString2 = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "javaClassId.relativeClassName.asString()");
        if (Intrinsics3.areEqual(strAsString, "kotlin")) {
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
        String str = strAsString + '.' + StringsJVM.replace$default(strAsString2, '.', '$', false, 4, (Object) null);
        if (i > 0) {
            str = StringsJVM.repeat("[", i) + 'L' + str + ';';
        }
        return ReflectJavaClassFinder2.tryLoadClass(classLoader, str);
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        KCallable kCallableCompute = functionReference != null ? functionReference.compute() : null;
        return (KFunctionImpl) (kCallableCompute instanceof KFunctionImpl ? kCallableCompute : null);
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        KCallable kCallableCompute = propertyReference != null ? propertyReference.compute() : null;
        return (KPropertyImpl) (kCallableCompute instanceof KPropertyImpl ? kCallableCompute : null);
    }

    public static final Annotation b(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map.Entry<Name, d0.e0.p.d.m0.k.v.g<?>>> setEntrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            d0.e0.p.d.m0.k.v.g gVar = (d0.e0.p.d.m0.k.v.g) entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            Intrinsics3.checkNotNullExpressionValue(classLoader, "annotationClass.classLoader");
            Object objC = c(gVar, classLoader);
            Tuples2 tuples2 = objC != null ? Tuples.to(name.asString(), objC) : null;
            if (tuples2 != null) {
                arrayList.add(tuples2);
            }
        }
        return (Annotation) AnnotationConstructorCaller2.createAnnotationInstance$default(javaClass, Maps6.toMap(arrayList), null, 4, null);
    }

    public static final Object c(d0.e0.p.d.m0.k.v.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof d0.e0.p.d.m0.k.v.a) {
            return b(((d0.e0.p.d.m0.k.v.a) gVar).getValue());
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            List<? extends d0.e0.p.d.m0.k.v.g<?>> value = ((d0.e0.p.d.m0.k.v.b) gVar).getValue();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(c((d0.e0.p.d.m0.k.v.g) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.j) {
            Tuples2<? extends ClassId, ? extends Name> value2 = ((d0.e0.p.d.m0.k.v.j) gVar).getValue();
            ClassId classIdComponent1 = value2.component1();
            Name nameComponent2 = value2.component2();
            Class<?> clsA = a(classLoader, classIdComponent1, 0);
            if (clsA != null) {
                return Util4.getEnumConstantByName(clsA, nameComponent2.asString());
            }
            return null;
        }
        if (!(gVar instanceof d0.e0.p.d.m0.k.v.r)) {
            if ((gVar instanceof d0.e0.p.d.m0.k.v.k) || (gVar instanceof d0.e0.p.d.m0.k.v.t)) {
                return null;
            }
            return gVar.getValue();
        }
        r.b value3 = ((d0.e0.p.d.m0.k.v.r) gVar).getValue();
        if (value3 instanceof r.b.C0405b) {
            r.b.C0405b c0405b = (r.b.C0405b) value3;
            return a(classLoader, c0405b.getClassId(), c0405b.getArrayDimensions());
        }
        if (!(value3 instanceof r.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        ClassifierDescriptor declarationDescriptor = ((r.b.a) value3).getType().getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor != null) {
            return toJavaClass(classDescriptor);
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotations3 annotations3) {
        Intrinsics3.checkNotNullParameter(annotations3, "$this$computeAnnotations");
        Annotations4 annotations = annotations3.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotationB = null;
            if (source instanceof ReflectAnnotationSource) {
                annotationB = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.a) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.a) source).getJavaElement();
                if (!(javaElement instanceof ReflectJavaAnnotation)) {
                    javaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                if (reflectJavaAnnotation != null) {
                    annotationB = reflectJavaAnnotation.getAnnotation();
                }
            } else {
                annotationB = b(annotationDescriptor);
            }
            if (annotationB != null) {
                arrayList.add(annotationB);
            }
        }
        return arrayList;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (Intrinsics3.areEqual(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (Intrinsics3.areEqual(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (Intrinsics3.areEqual(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (Intrinsics3.areEqual(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (Intrinsics3.areEqual(type, Integer.TYPE)) {
            return 0;
        }
        if (Intrinsics3.areEqual(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (Intrinsics3.areEqual(type, Long.TYPE)) {
            return 0L;
        }
        if (Intrinsics3.areEqual(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (Intrinsics3.areEqual(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException(outline.z("Unknown primitive: ", type));
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> cls, M m, NameResolver nameResolver, TypeTable typeTable, BinaryVersion binaryVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<d0.e0.p.d.m0.f.s> typeParameterList;
        Intrinsics3.checkNotNullParameter(cls, "moduleAnchor");
        Intrinsics3.checkNotNullParameter(m, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(function2, "createDescriptor");
        RuntimeModuleData orCreateModule = moduleByClassLoader.getOrCreateModule(cls);
        if (m instanceof d0.e0.p.d.m0.f.i) {
            typeParameterList = ((d0.e0.p.d.m0.f.i) m).getTypeParameterList();
        } else {
            if (!(m instanceof d0.e0.p.d.m0.f.n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            typeParameterList = ((d0.e0.p.d.m0.f.n) m).getTypeParameterList();
        }
        List<d0.e0.p.d.m0.f.s> list = typeParameterList;
        context5 deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor2 module = orCreateModule.getModule();
        VersionRequirement2 empty = VersionRequirement2.a.getEMPTY();
        Intrinsics3.checkNotNullExpressionValue(list, "typeParameters");
        return function2.invoke(new MemberDeserializer(new context6(deserialization, nameResolver, module, typeTable, empty, binaryVersion, null, null, list)), m);
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "$this$instanceReceiverParameter");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final FqName getJVM_STATIC() {
        return a;
    }

    public static final boolean isInlineClassType(KType kType) {
        KotlinType type;
        Intrinsics3.checkNotNullParameter(kType, "$this$isInlineClassType");
        if (!(kType instanceof KTypeImpl)) {
            kType = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) kType;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !inlineClassesUtils.isInlineClassType(type)) ? false : true;
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "$this$toJavaClass");
        SourceElement source = classDescriptor.getSource();
        Intrinsics3.checkNotNullExpressionValue(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Objects.requireNonNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass2) binaryClass).getKlass();
        }
        if (source instanceof RuntimeSourceElementFactory.a) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.a) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        }
        ClassId classId = DescriptorUtils2.getClassId(classDescriptor);
        if (classId != null) {
            return a(reflectClassUtil.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
        }
        return null;
    }

    public static final KVisibility toKVisibility(DescriptorVisibility2 descriptorVisibility2) {
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "$this$toKVisibility");
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.e)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.c)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.d)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.a) || Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f3300b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }
}
