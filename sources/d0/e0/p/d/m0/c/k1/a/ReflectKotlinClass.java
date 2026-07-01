package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.ClassLiteralValue;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.t._Arrays;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.c, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClass {
    public static final ReflectKotlinClass a = new ReflectKotlinClass();

    public final ClassLiteralValue a(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            Intrinsics3.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            ClassId classId = reflectClassUtil.getClassId(cls);
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
            FqName fqNameAsSingleFqName = classId.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "javaClassId.asSingleFqName()");
            ClassId classIdMapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(fqNameAsSingleFqName);
            if (classIdMapJavaToKotlin != null) {
                classId = classIdMapJavaToKotlin;
            }
            return new ClassLiteralValue(classId, i);
        }
        if (Intrinsics3.areEqual(cls, Void.TYPE)) {
            ClassId classId2 = ClassId.topLevel(StandardNames.a.e.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new ClassLiteralValue(classId2, i);
        }
        PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
        Intrinsics3.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
        if (i > 0) {
            ClassId classId3 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
            Intrinsics3.checkNotNullExpressionValue(classId3, "topLevel(primitiveType.arrayTypeFqName)");
            return new ClassLiteralValue(classId3, i - 1);
        }
        ClassId classId4 = ClassId.topLevel(primitiveType.getTypeFqName());
        Intrinsics3.checkNotNullExpressionValue(classId4, "topLevel(primitiveType.typeFqName)");
        return new ClassLiteralValue(classId4, i);
    }

    public final void b(KotlinJvmBinaryClass.c cVar, Annotation annotation) throws InvocationTargetException {
        Class<?> javaClass = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.a aVarVisitAnnotation = cVar.visitAnnotation(reflectClassUtil.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (aVarVisitAnnotation == null) {
            return;
        }
        c(aVarVisitAnnotation, annotation, javaClass);
    }

    public final void c(KotlinJvmBinaryClass.a aVar, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                Intrinsics3.checkNotNull(objInvoke);
                Name nameIdentifier = Name.identifier(method.getName());
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(method.name)");
                Class<?> enclosingClass = objInvoke.getClass();
                if (Intrinsics3.areEqual(enclosingClass, Class.class)) {
                    aVar.visitClassLiteral(nameIdentifier, a((Class) objInvoke));
                } else if (ReflectKotlinClass3.a.contains(enclosingClass)) {
                    aVar.visit(nameIdentifier, objInvoke);
                } else if (reflectClassUtil.isEnumClassOrSpecializedEnumEntryClass(enclosingClass)) {
                    if (!enclosingClass.isEnum()) {
                        enclosingClass = enclosingClass.getEnclosingClass();
                    }
                    Intrinsics3.checkNotNullExpressionValue(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                    ClassId classId = reflectClassUtil.getClassId(enclosingClass);
                    Name nameIdentifier2 = Name.identifier(((Enum) objInvoke).name());
                    Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier((value as Enum<*>).name)");
                    aVar.visitEnum(nameIdentifier, classId, nameIdentifier2);
                } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                    Class<?>[] interfaces = enclosingClass.getInterfaces();
                    Intrinsics3.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                    Class<?> cls2 = (Class) _Arrays.single(interfaces);
                    Intrinsics3.checkNotNullExpressionValue(cls2, "annotationClass");
                    KotlinJvmBinaryClass.a aVarVisitAnnotation = aVar.visitAnnotation(nameIdentifier, reflectClassUtil.getClassId(cls2));
                    if (aVarVisitAnnotation != null) {
                        c(aVarVisitAnnotation, (Annotation) objInvoke, cls2);
                    }
                } else {
                    if (!enclosingClass.isArray()) {
                        throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                    }
                    KotlinJvmBinaryClass.b bVarVisitArray = aVar.visitArray(nameIdentifier);
                    if (bVarVisitArray != null) {
                        Class<?> componentType = enclosingClass.getComponentType();
                        if (componentType.isEnum()) {
                            Intrinsics3.checkNotNullExpressionValue(componentType, "componentType");
                            ClassId classId2 = reflectClassUtil.getClassId(componentType);
                            Object[] objArr = (Object[]) objInvoke;
                            int length2 = objArr.length;
                            int i2 = 0;
                            while (i2 < length2) {
                                Object obj = objArr[i2];
                                i2++;
                                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                Name nameIdentifier3 = Name.identifier(((Enum) obj).name());
                                Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier((element as Enum<*>).name)");
                                bVarVisitArray.visitEnum(classId2, nameIdentifier3);
                            }
                        } else if (Intrinsics3.areEqual(componentType, Class.class)) {
                            Object[] objArr2 = (Object[]) objInvoke;
                            int length3 = objArr2.length;
                            int i3 = 0;
                            while (i3 < length3) {
                                Object obj2 = objArr2[i3];
                                i3++;
                                Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                bVarVisitArray.visitClassLiteral(a((Class) obj2));
                            }
                        } else {
                            Object[] objArr3 = (Object[]) objInvoke;
                            int length4 = objArr3.length;
                            int i4 = 0;
                            while (i4 < length4) {
                                Object obj3 = objArr3[i4];
                                i4++;
                                bVarVisitArray.visit(obj3);
                            }
                        }
                        bVarVisitArray.visitEnd();
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> cls, KotlinJvmBinaryClass.c cVar) {
        Intrinsics3.checkNotNullParameter(cls, "klass");
        Intrinsics3.checkNotNullParameter(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        Intrinsics3.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            Intrinsics3.checkNotNullExpressionValue(annotation, "annotation");
            b(cVar, annotation);
        }
        cVar.visitEnd();
    }

    public final void visitMembers(Class<?> cls, KotlinJvmBinaryClass.d dVar) {
        String str;
        Constructor<?>[] constructorArr;
        int i;
        int i2;
        String str2;
        Method[] methodArr;
        int i3;
        Intrinsics3.checkNotNullParameter(cls, "klass");
        Intrinsics3.checkNotNullParameter(dVar, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            str = "annotations";
            if (i4 >= length) {
                break;
            }
            Method method = declaredMethods[i4];
            i4++;
            Name nameIdentifier = Name.identifier(method.getName());
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(method.name)");
            ReflectKotlinClass4 reflectKotlinClass4 = ReflectKotlinClass4.a;
            Intrinsics3.checkNotNullExpressionValue(method, "method");
            KotlinJvmBinaryClass.e eVarVisitMethod = dVar.visitMethod(nameIdentifier, reflectKotlinClass4.methodDesc(method));
            if (eVarVisitMethod == null) {
                methodArr = declaredMethods;
                i3 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics3.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i5 = 0;
                while (i5 < length2) {
                    Annotation annotation = declaredAnnotations[i5];
                    i5++;
                    Intrinsics3.checkNotNullExpressionValue(annotation, "annotation");
                    b(eVarVisitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics3.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i6 = 0;
                while (i6 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i6];
                    int i7 = i6 + 1;
                    Intrinsics3.checkNotNullExpressionValue(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i8 = 0;
                    while (i8 < length4) {
                        Method[] methodArr2 = declaredMethods;
                        Annotation annotation2 = annotationArr[i8];
                        int i9 = i8 + 1;
                        Class<?> javaClass = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation2));
                        int i10 = length;
                        ClassId classId = reflectClassUtil.getClassId(javaClass);
                        Intrinsics3.checkNotNullExpressionValue(annotation2, "annotation");
                        KotlinJvmBinaryClass.a aVarVisitParameterAnnotation = eVarVisitMethod.visitParameterAnnotation(i6, classId, new ReflectAnnotationSource(annotation2));
                        if (aVarVisitParameterAnnotation != null) {
                            c(aVarVisitParameterAnnotation, annotation2, javaClass);
                        }
                        declaredMethods = methodArr2;
                        length = i10;
                        i8 = i9;
                    }
                    i6 = i7;
                }
                methodArr = declaredMethods;
                i3 = length;
                eVarVisitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i3;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics3.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length5 = declaredConstructors.length;
        int i11 = 0;
        while (i11 < length5) {
            Constructor<?> constructor = declaredConstructors[i11];
            int i12 = i11 + 1;
            Name nameSpecial = Name.special("<init>");
            Intrinsics3.checkNotNullExpressionValue(nameSpecial, "special(\"<init>\")");
            ReflectKotlinClass4 reflectKotlinClass5 = ReflectKotlinClass4.a;
            Intrinsics3.checkNotNullExpressionValue(constructor, "constructor");
            KotlinJvmBinaryClass.e eVarVisitMethod2 = dVar.visitMethod(nameSpecial, reflectKotlinClass5.constructorDesc(constructor));
            if (eVarVisitMethod2 == null) {
                constructorArr = declaredConstructors;
                i = length5;
                i2 = i12;
                str2 = str;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                Intrinsics3.checkNotNullExpressionValue(declaredAnnotations2, "constructor.declaredAnnotations");
                int length6 = declaredAnnotations2.length;
                int i13 = 0;
                while (i13 < length6) {
                    Annotation annotation3 = declaredAnnotations2[i13];
                    i13++;
                    Intrinsics3.checkNotNullExpressionValue(annotation3, "annotation");
                    b(eVarVisitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                Intrinsics3.checkNotNullExpressionValue(parameterAnnotations2, "parameterAnnotations");
                if (!(parameterAnnotations2.length == 0)) {
                    int length7 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length8 = parameterAnnotations2.length;
                    int i14 = 0;
                    while (i14 < length8) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i14];
                        int i15 = i14 + 1;
                        Intrinsics3.checkNotNullExpressionValue(annotationArr2, str);
                        int length9 = annotationArr2.length;
                        int i16 = 0;
                        while (i16 < length9) {
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Annotation annotation4 = annotationArr2[i16];
                            i16++;
                            int i17 = length5;
                            Class<?> javaClass2 = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation4));
                            int i18 = i12;
                            int i19 = i14 + length7;
                            int i20 = length7;
                            ClassId classId2 = reflectClassUtil.getClassId(javaClass2);
                            String str3 = str;
                            Intrinsics3.checkNotNullExpressionValue(annotation4, "annotation");
                            KotlinJvmBinaryClass.a aVarVisitParameterAnnotation2 = eVarVisitMethod2.visitParameterAnnotation(i19, classId2, new ReflectAnnotationSource(annotation4));
                            if (aVarVisitParameterAnnotation2 != null) {
                                c(aVarVisitParameterAnnotation2, annotation4, javaClass2);
                            }
                            declaredConstructors = constructorArr2;
                            i12 = i18;
                            length5 = i17;
                            length7 = i20;
                            str = str3;
                        }
                        i14 = i15;
                    }
                }
                constructorArr = declaredConstructors;
                i = length5;
                i2 = i12;
                str2 = str;
                eVarVisitMethod2.visitEnd();
            }
            declaredConstructors = constructorArr;
            i11 = i2;
            length5 = i;
            str = str2;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics3.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        int length10 = declaredFields.length;
        int i21 = 0;
        while (i21 < length10) {
            Field field = declaredFields[i21];
            i21++;
            Name nameIdentifier2 = Name.identifier(field.getName());
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(field.name)");
            ReflectKotlinClass4 reflectKotlinClass6 = ReflectKotlinClass4.a;
            Intrinsics3.checkNotNullExpressionValue(field, "field");
            KotlinJvmBinaryClass.c cVarVisitField = dVar.visitField(nameIdentifier2, reflectKotlinClass6.fieldDesc(field), null);
            if (cVarVisitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                Intrinsics3.checkNotNullExpressionValue(declaredAnnotations3, "field.declaredAnnotations");
                int length11 = declaredAnnotations3.length;
                int i22 = 0;
                while (i22 < length11) {
                    Annotation annotation5 = declaredAnnotations3[i22];
                    i22++;
                    Intrinsics3.checkNotNullExpressionValue(annotation5, "annotation");
                    b(cVarVisitField, annotation5);
                }
                cVarVisitField.visitEnd();
            }
        }
    }
}
