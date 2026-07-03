package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11303c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11814f;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p580t.C12141k;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.c */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11410c {

    /* JADX INFO: renamed from: a */
    public static final C11410c f23013a = new C11410c();

    /* JADX INFO: renamed from: a */
    public final C11814f m9432a(Class<?> cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            C12238m.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            C11712a classId = C11423b.getClassId(cls);
            C11303c c11303c = C11303c.f22614a;
            C11713b c11713bAsSingleFqName = classId.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "javaClassId.asSingleFqName()");
            C11712a c11712aMapJavaToKotlin = c11303c.mapJavaToKotlin(c11713bAsSingleFqName);
            if (c11712aMapJavaToKotlin != null) {
                classId = c11712aMapJavaToKotlin;
            }
            return new C11814f(classId, i);
        }
        if (C12238m.areEqual(cls, Void.TYPE)) {
            C11712a c11712a = C11712a.topLevel(C11291k.a.f22538e.toSafe());
            C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new C11814f(c11712a, i);
        }
        EnumC11289i primitiveType = EnumC11840d.get(cls.getName()).getPrimitiveType();
        C12238m.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
        if (i > 0) {
            C11712a c11712a2 = C11712a.topLevel(primitiveType.getArrayTypeFqName());
            C12238m.checkNotNullExpressionValue(c11712a2, "topLevel(primitiveType.arrayTypeFqName)");
            return new C11814f(c11712a2, i - 1);
        }
        C11712a c11712a3 = C11712a.topLevel(primitiveType.getTypeFqName());
        C12238m.checkNotNullExpressionValue(c11712a3, "topLevel(primitiveType.typeFqName)");
        return new C11814f(c11712a3, i);
    }

    /* JADX INFO: renamed from: b */
    public final void m9433b(InterfaceC11655p.c cVar, Annotation annotation) throws InvocationTargetException {
        Class<?> javaClass = C12209a.getJavaClass(C12209a.getAnnotationClass(annotation));
        InterfaceC11655p.a aVarVisitAnnotation = cVar.visitAnnotation(C11423b.getClassId(javaClass), new C11409b(annotation));
        if (aVarVisitAnnotation == null) {
            return;
        }
        m9434c(aVarVisitAnnotation, annotation, javaClass);
    }

    /* JADX INFO: renamed from: c */
    public final void m9434c(InterfaceC11655p.a aVar, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        C12238m.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                C12238m.checkNotNull(objInvoke);
                C11716e c11716eIdentifier = C11716e.identifier(method.getName());
                C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(method.name)");
                Class<?> enclosingClass = objInvoke.getClass();
                if (C12238m.areEqual(enclosingClass, Class.class)) {
                    aVar.visitClassLiteral(c11716eIdentifier, m9432a((Class) objInvoke));
                } else if (C11416i.f23020a.contains(enclosingClass)) {
                    aVar.visit(c11716eIdentifier, objInvoke);
                } else if (C11423b.isEnumClassOrSpecializedEnumEntryClass(enclosingClass)) {
                    if (!enclosingClass.isEnum()) {
                        enclosingClass = enclosingClass.getEnclosingClass();
                    }
                    C12238m.checkNotNullExpressionValue(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                    C11712a classId = C11423b.getClassId(enclosingClass);
                    C11716e c11716eIdentifier2 = C11716e.identifier(((Enum) objInvoke).name());
                    C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "identifier((value as Enum<*>).name)");
                    aVar.visitEnum(c11716eIdentifier, classId, c11716eIdentifier2);
                } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                    Class<?>[] interfaces = enclosingClass.getInterfaces();
                    C12238m.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                    Class<?> cls2 = (Class) C12141k.single(interfaces);
                    C12238m.checkNotNullExpressionValue(cls2, "annotationClass");
                    InterfaceC11655p.a aVarVisitAnnotation = aVar.visitAnnotation(c11716eIdentifier, C11423b.getClassId(cls2));
                    if (aVarVisitAnnotation != null) {
                        m9434c(aVarVisitAnnotation, (Annotation) objInvoke, cls2);
                    }
                } else {
                    if (!enclosingClass.isArray()) {
                        throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                    }
                    InterfaceC11655p.b bVarVisitArray = aVar.visitArray(c11716eIdentifier);
                    if (bVarVisitArray != null) {
                        Class<?> componentType = enclosingClass.getComponentType();
                        if (componentType.isEnum()) {
                            C12238m.checkNotNullExpressionValue(componentType, "componentType");
                            C11712a classId2 = C11423b.getClassId(componentType);
                            Object[] objArr = (Object[]) objInvoke;
                            int length2 = objArr.length;
                            int i2 = 0;
                            while (i2 < length2) {
                                Object obj = objArr[i2];
                                i2++;
                                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                C11716e c11716eIdentifier3 = C11716e.identifier(((Enum) obj).name());
                                C12238m.checkNotNullExpressionValue(c11716eIdentifier3, "identifier((element as Enum<*>).name)");
                                bVarVisitArray.visitEnum(classId2, c11716eIdentifier3);
                            }
                        } else if (C12238m.areEqual(componentType, Class.class)) {
                            Object[] objArr2 = (Object[]) objInvoke;
                            int length3 = objArr2.length;
                            int i3 = 0;
                            while (i3 < length3) {
                                Object obj2 = objArr2[i3];
                                i3++;
                                Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                bVarVisitArray.visitClassLiteral(m9432a((Class) obj2));
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

    public final void loadClassAnnotations(Class<?> cls, InterfaceC11655p.c cVar) {
        C12238m.checkNotNullParameter(cls, "klass");
        C12238m.checkNotNullParameter(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        C12238m.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            C12238m.checkNotNullExpressionValue(annotation, "annotation");
            m9433b(cVar, annotation);
        }
        cVar.visitEnd();
    }

    public final void visitMembers(Class<?> cls, InterfaceC11655p.d dVar) {
        String str;
        Constructor<?>[] constructorArr;
        int i;
        int i2;
        String str2;
        Method[] methodArr;
        int i3;
        C12238m.checkNotNullParameter(cls, "klass");
        C12238m.checkNotNullParameter(dVar, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        C12238m.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            str = "annotations";
            if (i4 >= length) {
                break;
            }
            Method method = declaredMethods[i4];
            i4++;
            C11716e c11716eIdentifier = C11716e.identifier(method.getName());
            C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(method.name)");
            C11421n c11421n = C11421n.f23027a;
            C12238m.checkNotNullExpressionValue(method, "method");
            InterfaceC11655p.e eVarVisitMethod = dVar.visitMethod(c11716eIdentifier, c11421n.methodDesc(method));
            if (eVarVisitMethod == null) {
                methodArr = declaredMethods;
                i3 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                C12238m.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i5 = 0;
                while (i5 < length2) {
                    Annotation annotation = declaredAnnotations[i5];
                    i5++;
                    C12238m.checkNotNullExpressionValue(annotation, "annotation");
                    m9433b(eVarVisitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                C12238m.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i6 = 0;
                while (i6 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i6];
                    int i7 = i6 + 1;
                    C12238m.checkNotNullExpressionValue(annotationArr, "annotations");
                    int length4 = annotationArr.length;
                    int i8 = 0;
                    while (i8 < length4) {
                        Method[] methodArr2 = declaredMethods;
                        Annotation annotation2 = annotationArr[i8];
                        int i9 = i8 + 1;
                        Class<?> javaClass = C12209a.getJavaClass(C12209a.getAnnotationClass(annotation2));
                        int i10 = length;
                        C11712a classId = C11423b.getClassId(javaClass);
                        C12238m.checkNotNullExpressionValue(annotation2, "annotation");
                        InterfaceC11655p.a aVarVisitParameterAnnotation = eVarVisitMethod.visitParameterAnnotation(i6, classId, new C11409b(annotation2));
                        if (aVarVisitParameterAnnotation != null) {
                            m9434c(aVarVisitParameterAnnotation, annotation2, javaClass);
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
        C12238m.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length5 = declaredConstructors.length;
        int i11 = 0;
        while (i11 < length5) {
            Constructor<?> constructor = declaredConstructors[i11];
            int i12 = i11 + 1;
            C11716e c11716eSpecial = C11716e.special("<init>");
            C12238m.checkNotNullExpressionValue(c11716eSpecial, "special(\"<init>\")");
            C11421n c11421n2 = C11421n.f23027a;
            C12238m.checkNotNullExpressionValue(constructor, "constructor");
            InterfaceC11655p.e eVarVisitMethod2 = dVar.visitMethod(c11716eSpecial, c11421n2.constructorDesc(constructor));
            if (eVarVisitMethod2 == null) {
                constructorArr = declaredConstructors;
                i = length5;
                i2 = i12;
                str2 = str;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                C12238m.checkNotNullExpressionValue(declaredAnnotations2, "constructor.declaredAnnotations");
                int length6 = declaredAnnotations2.length;
                int i13 = 0;
                while (i13 < length6) {
                    Annotation annotation3 = declaredAnnotations2[i13];
                    i13++;
                    C12238m.checkNotNullExpressionValue(annotation3, "annotation");
                    m9433b(eVarVisitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                C12238m.checkNotNullExpressionValue(parameterAnnotations2, "parameterAnnotations");
                if (!(parameterAnnotations2.length == 0)) {
                    int length7 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length8 = parameterAnnotations2.length;
                    int i14 = 0;
                    while (i14 < length8) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i14];
                        int i15 = i14 + 1;
                        C12238m.checkNotNullExpressionValue(annotationArr2, str);
                        int length9 = annotationArr2.length;
                        int i16 = 0;
                        while (i16 < length9) {
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Annotation annotation4 = annotationArr2[i16];
                            i16++;
                            int i17 = length5;
                            Class<?> javaClass2 = C12209a.getJavaClass(C12209a.getAnnotationClass(annotation4));
                            int i18 = i12;
                            int i19 = i14 + length7;
                            int i20 = length7;
                            C11712a classId2 = C11423b.getClassId(javaClass2);
                            String str3 = str;
                            C12238m.checkNotNullExpressionValue(annotation4, "annotation");
                            InterfaceC11655p.a aVarVisitParameterAnnotation2 = eVarVisitMethod2.visitParameterAnnotation(i19, classId2, new C11409b(annotation4));
                            if (aVarVisitParameterAnnotation2 != null) {
                                m9434c(aVarVisitParameterAnnotation2, annotation4, javaClass2);
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
        C12238m.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        int length10 = declaredFields.length;
        int i21 = 0;
        while (i21 < length10) {
            Field field = declaredFields[i21];
            i21++;
            C11716e c11716eIdentifier2 = C11716e.identifier(field.getName());
            C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "identifier(field.name)");
            C11421n c11421n3 = C11421n.f23027a;
            C12238m.checkNotNullExpressionValue(field, "field");
            InterfaceC11655p.c cVarVisitField = dVar.visitField(c11716eIdentifier2, c11421n3.fieldDesc(field), null);
            if (cVarVisitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                C12238m.checkNotNullExpressionValue(declaredAnnotations3, "field.declaredAnnotations");
                int length11 = declaredAnnotations3.length;
                int i22 = 0;
                while (i22 < length11) {
                    Annotation annotation5 = declaredAnnotations3[i22];
                    i22++;
                    C12238m.checkNotNullExpressionValue(annotation5, "annotation");
                    m9433b(cVarVisitField, annotation5);
                }
                cVarVisitField.visitEnd();
            }
        }
    }
}
