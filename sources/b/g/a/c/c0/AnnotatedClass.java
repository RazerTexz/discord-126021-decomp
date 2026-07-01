package b.g.a.c.c0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.c0.AnnotatedFieldCollector;
import b.g.a.c.c0.AnnotatedMethodCollector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.c0.TypeResolutionContext;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.Annotations;
import b.g.a.c.i0.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.c0.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedClass.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedClass extends Annotated implements TypeResolutionContext {
    public static final a j = new a(null, Collections.emptyList(), Collections.emptyList());
    public final JavaType k;
    public final Class<?> l;
    public final TypeBindings m;
    public final List<JavaType> n;
    public final AnnotationIntrospector o;
    public final TypeFactory p;
    public final ClassIntrospector.a q;
    public final Class<?> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f684s;
    public final Annotations t;
    public a u;
    public AnnotatedMethodMap v;
    public List<AnnotatedField> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Boolean f685x;

    /* JADX INFO: renamed from: b.g.a.c.c0.c$a */
    /* JADX INFO: compiled from: AnnotatedClass.java */
    public static final class a {
        public final AnnotatedConstructor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<AnnotatedConstructor> f686b;
        public final List<AnnotatedMethod> c;

        public a(AnnotatedConstructor annotatedConstructor, List<AnnotatedConstructor> list, List<AnnotatedMethod> list2) {
            this.a = annotatedConstructor;
            this.f686b = list;
            this.c = list2;
        }
    }

    public AnnotatedClass(JavaType javaType, Class<?> cls, List<JavaType> list, Class<?> cls2, Annotations annotations, TypeBindings typeBindings, AnnotationIntrospector annotationIntrospector, ClassIntrospector.a aVar, TypeFactory typeFactory, boolean z2) {
        this.k = javaType;
        this.l = cls;
        this.n = list;
        this.r = cls2;
        this.t = annotations;
        this.m = typeBindings;
        this.o = annotationIntrospector;
        this.q = aVar;
        this.p = typeFactory;
        this.f684s = z2;
    }

    @Override // b.g.a.c.c0.TypeResolutionContext
    public JavaType a(Type type) {
        return this.p.b(null, type, this.m);
    }

    @Override // b.g.a.c.c0.Annotated
    public <A extends Annotation> A b(Class<A> cls) {
        return (A) this.t.a(cls);
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this.l;
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this.k;
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.o(obj, AnnotatedClass.class) && ((AnnotatedClass) obj).l == this.l;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:165:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:169:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:170:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:172:0x0303  */
    /* JADX WARN: Code duplicated, block: B:177:0x0318  */
    /* JADX WARN: Code duplicated, block: B:185:0x032f  */
    /* JADX WARN: Code duplicated, block: B:191:0x0349  */
    /* JADX WARN: Code duplicated, block: B:214:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0341 A[EDGE_INSN: B:215:0x0341->B:188:0x0341 BREAK  A[LOOP:6: B:183:0x032b->B:217:0x032b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x033d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x032b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0357 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x035b A[EDGE_INSN: B:221:0x035b->B:194:0x035b BREAK  A[LOOP:7: B:189:0x0346->B:222:0x0346], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0128  */
    /* JADX WARN: Code duplicated, block: B:70:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0133  */
    /* JADX WARN: Code duplicated, block: B:75:0x0140  */
    /* JADX WARN: Code duplicated, block: B:76:0x0146  */
    /* JADX WARN: Code duplicated, block: B:78:0x0157 A[LOOP:8: B:77:0x0155->B:78:0x0157, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:80:0x0160  */
    /* JADX WARN: Code duplicated, block: B:82:0x0169  */
    /* JADX WARN: Code duplicated, block: B:84:0x0171  */
    /* JADX WARN: Code duplicated, block: B:85:0x0174 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0176  */
    /* JADX WARN: Code duplicated, block: B:88:0x017b A[LOOP:10: B:87:0x0179->B:88:0x017b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x019b  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b1 A[LOOP:11: B:90:0x0199->B:94:0x01b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x01bc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final a f() {
        ClassUtil.a aVar;
        ArrayList arrayList;
        int size;
        ?? arrayList2;
        ?? r2;
        int i;
        ArrayList arrayList3;
        TypeResolutionContext.b bVar;
        int size2;
        ArrayList arrayList4;
        int i2;
        int i3;
        List listEmptyList;
        JavaType javaType;
        int i4;
        ArrayList arrayList5;
        TypeVariable<Method>[] typeParameters;
        TypeBindings typeBindings;
        TypeResolutionContext aVar2;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] declaredMethods;
        int length;
        MemberKey[] memberKeyArr;
        int i5;
        Method method;
        Method[] methodArr;
        MemberKey memberKey;
        int i6;
        int i7;
        AnnotatedConstructor annotatedConstructor;
        int size3;
        int size4;
        ClassUtil.a[] aVarArr;
        List listEmptyList2;
        a aVar3 = this.u;
        if (aVar3 == null) {
            JavaType javaType2 = this.k;
            if (javaType2 == null) {
                aVar3 = j;
            } else {
                AnnotationIntrospector annotationIntrospector = this.o;
                TypeFactory typeFactory = this.p;
                Class<?> cls = this.r;
                AnnotatedCreatorCollector annotatedCreatorCollector = new AnnotatedCreatorCollector(annotationIntrospector, this, this.f684s | (cls != null));
                if (javaType2.w()) {
                    aVar = null;
                    arrayList = null;
                } else {
                    aVar = null;
                    arrayList = null;
                    for (ClassUtil.a aVar4 : ClassUtil.l(javaType2._class)) {
                        if (!aVar4.a.isSynthetic()) {
                            if (aVar4.a() == 0) {
                                aVar = aVar4;
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(aVar4);
                            }
                        }
                    }
                }
                if (arrayList == null) {
                    listEmptyList2 = Collections.emptyList();
                    if (aVar != null) {
                        arrayList2 = listEmptyList2;
                        size = 0;
                    }
                    r2 = listEmptyList2;
                    arrayList3 = null;
                    for (Method method2 : ClassUtil.k(javaType2._class)) {
                        if (AnnotatedCreatorCollector.f(method2)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(method2);
                        }
                    }
                    if (arrayList3 == null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        bVar = new TypeResolutionContext.b(typeFactory);
                        size2 = arrayList3.size();
                        arrayList4 = new ArrayList(size2);
                        for (i2 = 0; i2 < size2; i2++) {
                            arrayList4.add(null);
                        }
                        if (cls != null) {
                            declaredMethods = cls.getDeclaredMethods();
                            length = declaredMethods.length;
                            memberKeyArr = null;
                            i5 = 0;
                            while (i5 < length) {
                                method = declaredMethods[i5];
                                if (AnnotatedCreatorCollector.f(method)) {
                                    if (memberKeyArr == null) {
                                        memberKeyArr = new MemberKey[size2];
                                        i7 = 0;
                                        while (i7 < size2) {
                                            memberKeyArr[i7] = new MemberKey((Method) arrayList3.get(i7));
                                            i7++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    memberKey = new MemberKey(method);
                                    for (i6 = 0; i6 < size2; i6++) {
                                        if (memberKey.equals(memberKeyArr[i6])) {
                                            arrayList4.set(i6, annotatedCreatorCollector.j((Method) arrayList3.get(i6), bVar, method));
                                            break;
                                        }
                                    }
                                } else {
                                    methodArr = declaredMethods;
                                }
                                i5++;
                                declaredMethods = methodArr;
                            }
                        }
                        i3 = 0;
                        while (i3 < size2) {
                            if (((AnnotatedMethod) arrayList4.get(i3)) == null) {
                                Method method3 = (Method) arrayList3.get(i3);
                                typeParameters = method3.getTypeParameters();
                                if (typeParameters.length != 0 || javaType2.j().i()) {
                                    javaType = javaType2;
                                    i4 = size2;
                                    arrayList5 = arrayList3;
                                    typeBindings = null;
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(javaType2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList6 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            i4 = size2;
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableI1 = AnimatableValueParser.i1(actualTypeArguments[i8]);
                                                    if (typeVariableI1 != null) {
                                                        String name = typeVariableI1.getName();
                                                        if (name == null) {
                                                            javaType = javaType2;
                                                        } else {
                                                            arrayList5 = arrayList3;
                                                            JavaType javaTypeF = javaType2.j().f(i8);
                                                            if (javaTypeF == null) {
                                                                javaType = javaType2;
                                                            } else {
                                                                javaType = javaType2;
                                                                int length2 = typeParameters.length;
                                                                typeArr = actualTypeArguments;
                                                                int i9 = 0;
                                                                while (true) {
                                                                    if (i9 >= length2) {
                                                                        typeVariable = null;
                                                                        break;
                                                                    }
                                                                    typeVariable = typeParameters[i9];
                                                                    int i10 = length2;
                                                                    if (name.equals(typeVariable.getName())) {
                                                                        break;
                                                                    }
                                                                    i9++;
                                                                    length2 = i10;
                                                                }
                                                                if (typeVariable != null) {
                                                                    Type[] bounds = typeVariable.getBounds();
                                                                    int length3 = bounds.length;
                                                                    typeVariableArr = typeParameters;
                                                                    int i11 = 0;
                                                                    while (true) {
                                                                        if (i11 >= length3) {
                                                                            z2 = true;
                                                                            break;
                                                                        }
                                                                        int i12 = length3;
                                                                        if (!AnimatableValueParser.A1(bVar, javaTypeF, bounds[i11])) {
                                                                            z2 = false;
                                                                            break;
                                                                        }
                                                                        i11++;
                                                                        length3 = i12;
                                                                    }
                                                                    if (z2) {
                                                                        int iIndexOf = arrayList6.indexOf(name);
                                                                        if (iIndexOf != -1) {
                                                                            JavaType javaType3 = (JavaType) arrayList7.get(iIndexOf);
                                                                            if (javaTypeF.equals(javaType3)) {
                                                                                continue;
                                                                            } else {
                                                                                boolean zB = javaType3.B(javaTypeF._class);
                                                                                boolean zB2 = javaTypeF.B(javaType3._class);
                                                                                if (zB || zB2) {
                                                                                    if ((zB ^ zB2) && zB2) {
                                                                                        arrayList7.set(iIndexOf, javaTypeF);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            arrayList6.add(name);
                                                                            arrayList7.add(javaTypeF);
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        javaType = javaType2;
                                                        arrayList5 = arrayList3;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i8++;
                                                    arrayList3 = arrayList5;
                                                    javaType2 = javaType;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    javaType = javaType2;
                                                    arrayList5 = arrayList3;
                                                    if (!arrayList6.isEmpty()) {
                                                        typeBindings = (arrayList6.isEmpty() || arrayList7.isEmpty()) ? TypeBindings.l : new TypeBindings((String[]) arrayList6.toArray(TypeBindings.j), (JavaType[]) arrayList7.toArray(TypeBindings.k), null);
                                                    }
                                                }
                                                typeBindings = null;
                                            }
                                        } else {
                                            javaType = javaType2;
                                            i4 = size2;
                                        }
                                        arrayList5 = arrayList3;
                                        typeBindings = null;
                                    } else {
                                        javaType = javaType2;
                                        i4 = size2;
                                        arrayList5 = arrayList3;
                                        typeBindings = null;
                                    }
                                }
                                if (typeBindings == null) {
                                    aVar2 = bVar;
                                } else {
                                    aVar2 = new TypeResolutionContext.a(typeFactory, typeBindings);
                                }
                                arrayList4.set(i3, annotatedCreatorCollector.j(method3, aVar2, null));
                            } else {
                                javaType = javaType2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                            }
                            i3++;
                            size2 = i4;
                            arrayList3 = arrayList5;
                            javaType2 = javaType;
                        }
                        listEmptyList = arrayList4;
                    }
                    if (annotatedCreatorCollector.e) {
                        annotatedConstructor = annotatedCreatorCollector.f;
                        if (annotatedConstructor != null && annotatedCreatorCollector.c.Z(annotatedConstructor)) {
                            annotatedCreatorCollector.f = null;
                        }
                        size3 = r2.size();
                        while (true) {
                            size3--;
                            if (size3 >= 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.c.Z((AnnotatedMember) r2.get(size3))) {
                                r2.remove(size3);
                            }
                        }
                        size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 >= 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.c.Z((AnnotatedMember) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    aVar3 = new a(annotatedCreatorCollector.f, r2, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i13 = 0; i13 < size; i13++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    ClassUtil.a[] aVarArrL = ClassUtil.l(cls);
                    int length4 = aVarArrL.length;
                    MemberKey[] memberKeyArr2 = null;
                    int i14 = 0;
                    while (i14 < length4) {
                        ClassUtil.a aVar5 = aVarArrL[i14];
                        if (aVar5.a() != 0) {
                            aVarArr = aVarArrL;
                            if (arrayList != null) {
                                if (memberKeyArr2 == null) {
                                    MemberKey[] memberKeyArr3 = new MemberKey[size];
                                    for (int i15 = 0; i15 < size; i15++) {
                                        memberKeyArr3[i15] = new MemberKey(((ClassUtil.a) arrayList.get(i15)).a);
                                    }
                                    memberKeyArr2 = memberKeyArr3;
                                }
                                MemberKey memberKey2 = new MemberKey(aVar5.a);
                                for (int i16 = 0; i16 < size; i16++) {
                                    if (memberKey2.equals(memberKeyArr2[i16])) {
                                        arrayList2.set(i16, annotatedCreatorCollector.k((ClassUtil.a) arrayList.get(i16), aVar5));
                                        break;
                                    }
                                }
                            } else {
                                r2 = listEmptyList2;
                            }
                        } else if (aVar != null) {
                            aVarArr = aVarArrL;
                            annotatedCreatorCollector.f = new AnnotatedConstructor(annotatedCreatorCollector.d, aVar.a, annotatedCreatorCollector.g(aVar, aVar5), CollectorBase.a);
                            aVar = null;
                        } else {
                            aVarArr = aVarArrL;
                        }
                        i14++;
                        aVarArrL = aVarArr;
                    }
                    r2 = listEmptyList2;
                }
                if (aVar != null) {
                    annotatedCreatorCollector.f = new AnnotatedConstructor(annotatedCreatorCollector.d, aVar.a, annotatedCreatorCollector.g(aVar, null), CollectorBase.a);
                }
                for (int i17 = 0; i17 < size; i17++) {
                    if (((AnnotatedConstructor) arrayList2.get(i17)) == null) {
                        arrayList2.set(i17, annotatedCreatorCollector.k((ClassUtil.a) arrayList.get(i17), null));
                    }
                }
                r2 = arrayList2;
                r2 = listEmptyList2;
                arrayList3 = null;
                while (i < r6) {
                    if (AnnotatedCreatorCollector.f(method2)) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(method2);
                    }
                }
                if (arrayList3 == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    bVar = new TypeResolutionContext.b(typeFactory);
                    size2 = arrayList3.size();
                    arrayList4 = new ArrayList(size2);
                    while (i2 < size2) {
                        arrayList4.add(null);
                    }
                    if (cls != null) {
                        declaredMethods = cls.getDeclaredMethods();
                        length = declaredMethods.length;
                        memberKeyArr = null;
                        i5 = 0;
                        while (i5 < length) {
                            method = declaredMethods[i5];
                            if (AnnotatedCreatorCollector.f(method)) {
                                methodArr = declaredMethods;
                            } else {
                                if (memberKeyArr == null) {
                                    memberKeyArr = new MemberKey[size2];
                                    i7 = 0;
                                    while (i7 < size2) {
                                        memberKeyArr[i7] = new MemberKey((Method) arrayList3.get(i7));
                                        i7++;
                                        declaredMethods = declaredMethods;
                                    }
                                }
                                methodArr = declaredMethods;
                                memberKey = new MemberKey(method);
                                while (i6 < size2) {
                                    if (memberKey.equals(memberKeyArr[i6])) {
                                        arrayList4.set(i6, annotatedCreatorCollector.j((Method) arrayList3.get(i6), bVar, method));
                                        break;
                                        break;
                                    }
                                }
                            }
                            i5++;
                            declaredMethods = methodArr;
                        }
                    }
                    i3 = 0;
                    while (i3 < size2) {
                        if (((AnnotatedMethod) arrayList4.get(i3)) == null) {
                            Method method4 = (Method) arrayList3.get(i3);
                            typeParameters = method4.getTypeParameters();
                            if (typeParameters.length != 0) {
                                javaType = javaType2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                typeBindings = null;
                            } else {
                                javaType = javaType2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                typeBindings = null;
                            }
                            if (typeBindings == null) {
                                aVar2 = bVar;
                            } else {
                                aVar2 = new TypeResolutionContext.a(typeFactory, typeBindings);
                            }
                            arrayList4.set(i3, annotatedCreatorCollector.j(method4, aVar2, null));
                        } else {
                            javaType = javaType2;
                            i4 = size2;
                            arrayList5 = arrayList3;
                        }
                        i3++;
                        size2 = i4;
                        arrayList3 = arrayList5;
                        javaType2 = javaType;
                    }
                    listEmptyList = arrayList4;
                }
                if (annotatedCreatorCollector.e) {
                    annotatedConstructor = annotatedCreatorCollector.f;
                    if (annotatedConstructor != null) {
                        annotatedCreatorCollector.f = null;
                    }
                    size3 = r2.size();
                    while (true) {
                        size3--;
                        if (size3 >= 0) {
                            break;
                            break;
                        }
                        if (annotatedCreatorCollector.c.Z((AnnotatedMember) r2.get(size3))) {
                            r2.remove(size3);
                        }
                    }
                    size4 = listEmptyList.size();
                    while (true) {
                        size4--;
                        if (size4 >= 0) {
                            break;
                            break;
                        }
                        if (annotatedCreatorCollector.c.Z((AnnotatedMember) listEmptyList.get(size4))) {
                            listEmptyList.remove(size4);
                        }
                    }
                }
                aVar3 = new a(annotatedCreatorCollector.f, r2, listEmptyList);
            }
            this.u = aVar3;
        }
        return aVar3;
    }

    public Iterable<AnnotatedField> g() {
        List<AnnotatedField> listEmptyList = this.w;
        if (listEmptyList == null) {
            JavaType javaType = this.k;
            if (javaType == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, AnnotatedFieldCollector.a> mapF = new AnnotatedFieldCollector(this.o, this.p, this.q, this.f684s).f(this, javaType, null);
                if (mapF == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapF.size());
                    for (AnnotatedFieldCollector.a aVar : mapF.values()) {
                        arrayList.add(new AnnotatedField(aVar.a, aVar.f690b, aVar.c.b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.w = listEmptyList;
        }
        return listEmptyList;
    }

    public Iterable<AnnotatedMethod> h() {
        boolean z2;
        Class<?> clsA;
        AnnotatedMethodMap annotatedMethodMap = this.v;
        if (annotatedMethodMap == null) {
            JavaType javaType = this.k;
            if (javaType == null) {
                annotatedMethodMap = new AnnotatedMethodMap();
            } else {
                AnnotationIntrospector annotationIntrospector = this.o;
                ClassIntrospector.a aVar = this.q;
                TypeFactory typeFactory = this.p;
                List<JavaType> list = this.n;
                Class<?> cls = this.r;
                AnnotatedMethodCollector annotatedMethodCollector = new AnnotatedMethodCollector(annotationIntrospector, aVar, this.f684s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                annotatedMethodCollector.f(this, javaType._class, linkedHashMap, cls);
                Iterator<JavaType> it = list.iterator();
                while (true) {
                    Class<?> clsA2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    JavaType next = it.next();
                    ClassIntrospector.a aVar2 = annotatedMethodCollector.d;
                    if (aVar2 != null) {
                        clsA2 = aVar2.a(next._class);
                    }
                    annotatedMethodCollector.f(new TypeResolutionContext.a(typeFactory, next.j()), next._class, linkedHashMap, clsA2);
                }
                ClassIntrospector.a aVar3 = annotatedMethodCollector.d;
                if (aVar3 == null || (clsA = aVar3.a(Object.class)) == null) {
                    z2 = false;
                } else {
                    annotatedMethodCollector.g(this, javaType._class, linkedHashMap, clsA);
                    z2 = true;
                }
                if (z2 && annotatedMethodCollector.c != null && !linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        MemberKey memberKey = (MemberKey) entry.getKey();
                        if ("hashCode".equals(memberKey.f696b) && memberKey.c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(memberKey.f696b, new Class[0]);
                                if (declaredMethod != null) {
                                    AnnotatedMethodCollector.a aVar4 = (AnnotatedMethodCollector.a) entry.getValue();
                                    aVar4.c = annotatedMethodCollector.d(aVar4.c, declaredMethod.getDeclaredAnnotations());
                                    aVar4.f691b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    annotatedMethodMap = new AnnotatedMethodMap();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        AnnotatedMethodCollector.a aVar5 = (AnnotatedMethodCollector.a) entry2.getValue();
                        Method method = aVar5.f691b;
                        AnnotatedMethod annotatedMethod = method == null ? null : new AnnotatedMethod(aVar5.a, method, aVar5.c.b(), null);
                        if (annotatedMethod != null) {
                            linkedHashMap2.put(entry2.getKey(), annotatedMethod);
                        }
                    }
                    annotatedMethodMap = new AnnotatedMethodMap(linkedHashMap2);
                }
            }
            this.v = annotatedMethodMap;
        }
        return annotatedMethodMap;
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    public String toString() {
        return outline.o(this.l, outline.U("[AnnotedClass "), "]");
    }

    public AnnotatedClass(Class<?> cls) {
        this.k = null;
        this.l = cls;
        this.n = Collections.emptyList();
        this.r = null;
        this.t = AnnotationCollector.a;
        this.m = TypeBindings.l;
        this.o = null;
        this.q = null;
        this.p = null;
        this.f684s = false;
    }
}
