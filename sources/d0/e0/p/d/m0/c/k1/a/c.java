package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.e.b.p$a;
import d0.e0.p.d.m0.e.b.p$b;
import d0.e0.p.d.m0.e.b.p$c;
import d0.e0.p.d.m0.e.b.p$d;
import d0.e0.p.d.m0.e.b.p$e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    public final d0.e0.p.d.m0.k.v.f a(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            d0.z.d.m.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.c.k1.b.b.getClassId(cls);
            d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
            d0.e0.p.d.m0.g.b bVarAsSingleFqName = classId.asSingleFqName();
            d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "javaClassId.asSingleFqName()");
            d0.e0.p.d.m0.g.a aVarMapJavaToKotlin = cVar.mapJavaToKotlin(bVarAsSingleFqName);
            if (aVarMapJavaToKotlin != null) {
                classId = aVarMapJavaToKotlin;
            }
            return new d0.e0.p.d.m0.k.v.f(classId, i);
        }
        if (d0.z.d.m.areEqual(cls, Void.TYPE)) {
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.b.k$a.e.toSafe());
            d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new d0.e0.p.d.m0.k.v.f(aVar, i);
        }
        d0.e0.p.d.m0.b.i primitiveType = d0.e0.p.d.m0.k.y.d.get(cls.getName()).getPrimitiveType();
        d0.z.d.m.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
        if (i > 0) {
            d0.e0.p.d.m0.g.a aVar2 = d0.e0.p.d.m0.g.a.topLevel(primitiveType.getArrayTypeFqName());
            d0.z.d.m.checkNotNullExpressionValue(aVar2, "topLevel(primitiveType.arrayTypeFqName)");
            return new d0.e0.p.d.m0.k.v.f(aVar2, i - 1);
        }
        d0.e0.p.d.m0.g.a aVar3 = d0.e0.p.d.m0.g.a.topLevel(primitiveType.getTypeFqName());
        d0.z.d.m.checkNotNullExpressionValue(aVar3, "topLevel(primitiveType.typeFqName)");
        return new d0.e0.p.d.m0.k.v.f(aVar3, i);
    }

    public final void b(p$c p_c, Annotation annotation) throws InvocationTargetException {
        Class<?> javaClass = d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(annotation));
        p$a p_aVisitAnnotation = p_c.visitAnnotation(d0.e0.p.d.m0.c.k1.b.b.getClassId(javaClass), new b(annotation));
        if (p_aVisitAnnotation == null) {
            return;
        }
        c(p_aVisitAnnotation, annotation, javaClass);
    }

    public final void c(p$a p_a, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                d0.z.d.m.checkNotNull(objInvoke);
                d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(method.getName());
                d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(method.name)");
                Class<?> enclosingClass = objInvoke.getClass();
                if (d0.z.d.m.areEqual(enclosingClass, Class.class)) {
                    p_a.visitClassLiteral(eVarIdentifier, a((Class) objInvoke));
                } else if (i.m86access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p$s1934497501().contains(enclosingClass)) {
                    p_a.visit(eVarIdentifier, objInvoke);
                } else if (d0.e0.p.d.m0.c.k1.b.b.isEnumClassOrSpecializedEnumEntryClass(enclosingClass)) {
                    if (!enclosingClass.isEnum()) {
                        enclosingClass = enclosingClass.getEnclosingClass();
                    }
                    d0.z.d.m.checkNotNullExpressionValue(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                    d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.c.k1.b.b.getClassId(enclosingClass);
                    d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier(((Enum) objInvoke).name());
                    d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "identifier((value as Enum<*>).name)");
                    p_a.visitEnum(eVarIdentifier, classId, eVarIdentifier2);
                } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                    Class<?>[] interfaces = enclosingClass.getInterfaces();
                    d0.z.d.m.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                    Class<?> cls2 = (Class) d0.t.k.single(interfaces);
                    d0.z.d.m.checkNotNullExpressionValue(cls2, "annotationClass");
                    p$a p_aVisitAnnotation = p_a.visitAnnotation(eVarIdentifier, d0.e0.p.d.m0.c.k1.b.b.getClassId(cls2));
                    if (p_aVisitAnnotation != null) {
                        c(p_aVisitAnnotation, (Annotation) objInvoke, cls2);
                    }
                } else {
                    if (!enclosingClass.isArray()) {
                        throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                    }
                    p$b p_bVisitArray = p_a.visitArray(eVarIdentifier);
                    if (p_bVisitArray != null) {
                        Class<?> componentType = enclosingClass.getComponentType();
                        if (componentType.isEnum()) {
                            d0.z.d.m.checkNotNullExpressionValue(componentType, "componentType");
                            d0.e0.p.d.m0.g.a classId2 = d0.e0.p.d.m0.c.k1.b.b.getClassId(componentType);
                            Object[] objArr = (Object[]) objInvoke;
                            int length2 = objArr.length;
                            int i2 = 0;
                            while (i2 < length2) {
                                Object obj = objArr[i2];
                                i2++;
                                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                d0.e0.p.d.m0.g.e eVarIdentifier3 = d0.e0.p.d.m0.g.e.identifier(((Enum) obj).name());
                                d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier3, "identifier((element as Enum<*>).name)");
                                p_bVisitArray.visitEnum(classId2, eVarIdentifier3);
                            }
                        } else if (d0.z.d.m.areEqual(componentType, Class.class)) {
                            Object[] objArr2 = (Object[]) objInvoke;
                            int length3 = objArr2.length;
                            int i3 = 0;
                            while (i3 < length3) {
                                Object obj2 = objArr2[i3];
                                i3++;
                                Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                p_bVisitArray.visitClassLiteral(a((Class) obj2));
                            }
                        } else {
                            Object[] objArr3 = (Object[]) objInvoke;
                            int length4 = objArr3.length;
                            int i4 = 0;
                            while (i4 < length4) {
                                Object obj3 = objArr3[i4];
                                i4++;
                                p_bVisitArray.visit(obj3);
                            }
                        }
                        p_bVisitArray.visitEnd();
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        p_a.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> cls, p$c p_c) {
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        d0.z.d.m.checkNotNullParameter(p_c, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        d0.z.d.m.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            d0.z.d.m.checkNotNullExpressionValue(annotation, "annotation");
            b(p_c, annotation);
        }
        p_c.visitEnd();
    }

    public final void visitMembers(Class<?> cls, p$d p_d) {
        String str;
        Constructor<?>[] constructorArr;
        int i;
        int i2;
        String str2;
        Method[] methodArr;
        int i3;
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        d0.z.d.m.checkNotNullParameter(p_d, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            str = "annotations";
            if (i4 >= length) {
                break;
            }
            Method method = declaredMethods[i4];
            i4++;
            d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(method.getName());
            d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(method.name)");
            n nVar = n.a;
            d0.z.d.m.checkNotNullExpressionValue(method, "method");
            p$e p_eVisitMethod = p_d.visitMethod(eVarIdentifier, nVar.methodDesc(method));
            if (p_eVisitMethod == null) {
                methodArr = declaredMethods;
                i3 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                d0.z.d.m.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i5 = 0;
                while (i5 < length2) {
                    Annotation annotation = declaredAnnotations[i5];
                    i5++;
                    d0.z.d.m.checkNotNullExpressionValue(annotation, "annotation");
                    b(p_eVisitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                d0.z.d.m.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i6 = 0;
                while (i6 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i6];
                    int i7 = i6 + 1;
                    d0.z.d.m.checkNotNullExpressionValue(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i8 = 0;
                    while (i8 < length4) {
                        Method[] methodArr2 = declaredMethods;
                        Annotation annotation2 = annotationArr[i8];
                        int i9 = i8 + 1;
                        Class<?> javaClass = d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(annotation2));
                        int i10 = length;
                        d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.c.k1.b.b.getClassId(javaClass);
                        d0.z.d.m.checkNotNullExpressionValue(annotation2, "annotation");
                        p$a p_aVisitParameterAnnotation = p_eVisitMethod.visitParameterAnnotation(i6, classId, new b(annotation2));
                        if (p_aVisitParameterAnnotation != null) {
                            c(p_aVisitParameterAnnotation, annotation2, javaClass);
                        }
                        declaredMethods = methodArr2;
                        length = i10;
                        i8 = i9;
                    }
                    i6 = i7;
                }
                methodArr = declaredMethods;
                i3 = length;
                p_eVisitMethod.visitEnd();
            }
            declaredMethods = methodArr;
            length = i3;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        d0.z.d.m.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length5 = declaredConstructors.length;
        int i11 = 0;
        while (i11 < length5) {
            Constructor<?> constructor = declaredConstructors[i11];
            int i12 = i11 + 1;
            d0.e0.p.d.m0.g.e eVarSpecial = d0.e0.p.d.m0.g.e.special("<init>");
            d0.z.d.m.checkNotNullExpressionValue(eVarSpecial, "special(\"<init>\")");
            n nVar2 = n.a;
            d0.z.d.m.checkNotNullExpressionValue(constructor, "constructor");
            p$e p_eVisitMethod2 = p_d.visitMethod(eVarSpecial, nVar2.constructorDesc(constructor));
            if (p_eVisitMethod2 == null) {
                constructorArr = declaredConstructors;
                i = length5;
                i2 = i12;
                str2 = str;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                d0.z.d.m.checkNotNullExpressionValue(declaredAnnotations2, "constructor.declaredAnnotations");
                int length6 = declaredAnnotations2.length;
                int i13 = 0;
                while (i13 < length6) {
                    Annotation annotation3 = declaredAnnotations2[i13];
                    i13++;
                    d0.z.d.m.checkNotNullExpressionValue(annotation3, "annotation");
                    b(p_eVisitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                d0.z.d.m.checkNotNullExpressionValue(parameterAnnotations2, "parameterAnnotations");
                if (!(parameterAnnotations2.length == 0)) {
                    int length7 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length8 = parameterAnnotations2.length;
                    int i14 = 0;
                    while (i14 < length8) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i14];
                        int i15 = i14 + 1;
                        d0.z.d.m.checkNotNullExpressionValue(annotationArr2, str);
                        int length9 = annotationArr2.length;
                        int i16 = 0;
                        while (i16 < length9) {
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Annotation annotation4 = annotationArr2[i16];
                            i16++;
                            int i17 = length5;
                            Class<?> javaClass2 = d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(annotation4));
                            int i18 = i12;
                            int i19 = i14 + length7;
                            int i20 = length7;
                            d0.e0.p.d.m0.g.a classId2 = d0.e0.p.d.m0.c.k1.b.b.getClassId(javaClass2);
                            String str3 = str;
                            d0.z.d.m.checkNotNullExpressionValue(annotation4, "annotation");
                            p$a p_aVisitParameterAnnotation2 = p_eVisitMethod2.visitParameterAnnotation(i19, classId2, new b(annotation4));
                            if (p_aVisitParameterAnnotation2 != null) {
                                c(p_aVisitParameterAnnotation2, annotation4, javaClass2);
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
                p_eVisitMethod2.visitEnd();
            }
            declaredConstructors = constructorArr;
            i11 = i2;
            length5 = i;
            str = str2;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        d0.z.d.m.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        int length10 = declaredFields.length;
        int i21 = 0;
        while (i21 < length10) {
            Field field = declaredFields[i21];
            i21++;
            d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier(field.getName());
            d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "identifier(field.name)");
            n nVar3 = n.a;
            d0.z.d.m.checkNotNullExpressionValue(field, "field");
            p$c p_cVisitField = p_d.visitField(eVarIdentifier2, nVar3.fieldDesc(field), null);
            if (p_cVisitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                d0.z.d.m.checkNotNullExpressionValue(declaredAnnotations3, "field.declaredAnnotations");
                int length11 = declaredAnnotations3.length;
                int i22 = 0;
                while (i22 < length11) {
                    Annotation annotation5 = declaredAnnotations3[i22];
                    i22++;
                    d0.z.d.m.checkNotNullExpressionValue(annotation5, "annotation");
                    b(p_cVisitField, annotation5);
                }
                p_cVisitField.visitEnd();
            }
        }
    }
}
