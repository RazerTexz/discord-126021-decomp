package b.g.a.c.c0;

import b.g.a.c.i0.d$a;
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
import java.util.Map$Entry;
import java.util.Objects;

/* JADX INFO: compiled from: AnnotatedClass.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b implements e0 {
    public static final c$a j = new c$a(null, Collections.emptyList(), Collections.emptyList());
    public final b.g.a.c.j k;
    public final Class<?> l;
    public final b.g.a.c.h0.m m;
    public final List<b.g.a.c.j> n;
    public final b.g.a.c.b o;
    public final b.g.a.c.h0.n p;
    public final t$a q;
    public final Class<?> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f684s;
    public final b.g.a.c.i0.a t;
    public c$a u;
    public l v;
    public List<g> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Boolean f685x;

    public c(b.g.a.c.j jVar, Class<?> cls, List<b.g.a.c.j> list, Class<?> cls2, b.g.a.c.i0.a aVar, b.g.a.c.h0.m mVar, b.g.a.c.b bVar, t$a t_a, b.g.a.c.h0.n nVar, boolean z2) {
        this.k = jVar;
        this.l = cls;
        this.n = list;
        this.r = cls2;
        this.t = aVar;
        this.m = mVar;
        this.o = bVar;
        this.q = t_a;
        this.p = nVar;
        this.f684s = z2;
    }

    @Override // b.g.a.c.c0.e0
    public b.g.a.c.j a(Type type) {
        return this.p.b(null, type, this.m);
    }

    @Override // b.g.a.c.c0.b
    public <A extends Annotation> A b(Class<A> cls) {
        return (A) this.t.a(cls);
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this.l;
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this.k;
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return b.g.a.c.i0.d.o(obj, c.class) && ((c) obj).l == this.l;
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
    public final c$a f() {
        d$a d_a;
        ArrayList arrayList;
        int size;
        ?? arrayList2;
        ?? r2;
        int i;
        ArrayList arrayList3;
        e0$b e0_b;
        int size2;
        ArrayList arrayList4;
        int i2;
        int i3;
        List listEmptyList;
        b.g.a.c.j jVar;
        int i4;
        ArrayList arrayList5;
        TypeVariable<Method>[] typeParameters;
        b.g.a.c.h0.m mVar;
        e0 e0_a;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] declaredMethods;
        int length;
        y[] yVarArr;
        int i5;
        Method method;
        Method[] methodArr;
        y yVar;
        int i6;
        int i7;
        e eVar;
        int size3;
        int size4;
        d$a[] d_aArr;
        List listEmptyList2;
        c$a c_a = this.u;
        if (c_a == null) {
            b.g.a.c.j jVar2 = this.k;
            if (jVar2 == null) {
                c_a = j;
            } else {
                b.g.a.c.b bVar = this.o;
                b.g.a.c.h0.n nVar = this.p;
                Class<?> cls = this.r;
                f fVar = new f(bVar, this, this.f684s | (cls != null));
                if (jVar2.w()) {
                    d_a = null;
                    arrayList = null;
                } else {
                    d_a = null;
                    arrayList = null;
                    for (d$a d_a2 : b.g.a.c.i0.d.l(jVar2._class)) {
                        if (!d_a2.a.isSynthetic()) {
                            if (d_a2.a() == 0) {
                                d_a = d_a2;
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(d_a2);
                            }
                        }
                    }
                }
                if (arrayList == null) {
                    listEmptyList2 = Collections.emptyList();
                    if (d_a != null) {
                        arrayList2 = listEmptyList2;
                        size = 0;
                    }
                    r2 = listEmptyList2;
                    arrayList3 = null;
                    for (Method method2 : b.g.a.c.i0.d.k(jVar2._class)) {
                        if (f.f(method2)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(method2);
                        }
                    }
                    if (arrayList3 == null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        e0_b = new e0$b(nVar);
                        size2 = arrayList3.size();
                        arrayList4 = new ArrayList(size2);
                        for (i2 = 0; i2 < size2; i2++) {
                            arrayList4.add(null);
                        }
                        if (cls != null) {
                            declaredMethods = cls.getDeclaredMethods();
                            length = declaredMethods.length;
                            yVarArr = null;
                            i5 = 0;
                            while (i5 < length) {
                                method = declaredMethods[i5];
                                if (f.f(method)) {
                                    if (yVarArr == null) {
                                        yVarArr = new y[size2];
                                        i7 = 0;
                                        while (i7 < size2) {
                                            yVarArr[i7] = new y((Method) arrayList3.get(i7));
                                            i7++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    yVar = new y(method);
                                    for (i6 = 0; i6 < size2; i6++) {
                                        if (yVar.equals(yVarArr[i6])) {
                                            arrayList4.set(i6, fVar.j((Method) arrayList3.get(i6), e0_b, method));
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
                            if (((j) arrayList4.get(i3)) == null) {
                                Method method3 = (Method) arrayList3.get(i3);
                                typeParameters = method3.getTypeParameters();
                                if (typeParameters.length != 0 || jVar2.j().i()) {
                                    jVar = jVar2;
                                    i4 = size2;
                                    arrayList5 = arrayList3;
                                    mVar = null;
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(jVar2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList6 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            i4 = size2;
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableI1 = b.c.a.a0.d.i1(actualTypeArguments[i8]);
                                                    if (typeVariableI1 != null) {
                                                        String name = typeVariableI1.getName();
                                                        if (name == null) {
                                                            jVar = jVar2;
                                                        } else {
                                                            arrayList5 = arrayList3;
                                                            b.g.a.c.j jVarF = jVar2.j().f(i8);
                                                            if (jVarF == null) {
                                                                jVar = jVar2;
                                                            } else {
                                                                jVar = jVar2;
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
                                                                        if (!b.c.a.a0.d.A1(e0_b, jVarF, bounds[i11])) {
                                                                            z2 = false;
                                                                            break;
                                                                        }
                                                                        i11++;
                                                                        length3 = i12;
                                                                    }
                                                                    if (z2) {
                                                                        int iIndexOf = arrayList6.indexOf(name);
                                                                        if (iIndexOf != -1) {
                                                                            b.g.a.c.j jVar3 = (b.g.a.c.j) arrayList7.get(iIndexOf);
                                                                            if (jVarF.equals(jVar3)) {
                                                                                continue;
                                                                            } else {
                                                                                boolean zB = jVar3.B(jVarF._class);
                                                                                boolean zB2 = jVarF.B(jVar3._class);
                                                                                if (zB || zB2) {
                                                                                    if ((zB ^ zB2) && zB2) {
                                                                                        arrayList7.set(iIndexOf, jVarF);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            arrayList6.add(name);
                                                                            arrayList7.add(jVarF);
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        jVar = jVar2;
                                                        arrayList5 = arrayList3;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i8++;
                                                    arrayList3 = arrayList5;
                                                    jVar2 = jVar;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    jVar = jVar2;
                                                    arrayList5 = arrayList3;
                                                    if (!arrayList6.isEmpty()) {
                                                        mVar = (arrayList6.isEmpty() || arrayList7.isEmpty()) ? b.g.a.c.h0.m.l : new b.g.a.c.h0.m((String[]) arrayList6.toArray(b.g.a.c.h0.m.j), (b.g.a.c.j[]) arrayList7.toArray(b.g.a.c.h0.m.k), null);
                                                    }
                                                }
                                                mVar = null;
                                            }
                                        } else {
                                            jVar = jVar2;
                                            i4 = size2;
                                        }
                                        arrayList5 = arrayList3;
                                        mVar = null;
                                    } else {
                                        jVar = jVar2;
                                        i4 = size2;
                                        arrayList5 = arrayList3;
                                        mVar = null;
                                    }
                                }
                                if (mVar == null) {
                                    e0_a = e0_b;
                                } else {
                                    e0_a = new e0$a(nVar, mVar);
                                }
                                arrayList4.set(i3, fVar.j(method3, e0_a, null));
                            } else {
                                jVar = jVar2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                            }
                            i3++;
                            size2 = i4;
                            arrayList3 = arrayList5;
                            jVar2 = jVar;
                        }
                        listEmptyList = arrayList4;
                    }
                    if (fVar.e) {
                        eVar = fVar.f;
                        if (eVar != null && fVar.c.Z(eVar)) {
                            fVar.f = null;
                        }
                        size3 = r2.size();
                        while (true) {
                            size3--;
                            if (size3 >= 0) {
                                break;
                            }
                            if (fVar.c.Z((i) r2.get(size3))) {
                                r2.remove(size3);
                            }
                        }
                        size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 >= 0) {
                                break;
                            }
                            if (fVar.c.Z((i) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    c_a = new c$a(fVar.f, r2, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i13 = 0; i13 < size; i13++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    d$a[] d_aArrL = b.g.a.c.i0.d.l(cls);
                    int length4 = d_aArrL.length;
                    y[] yVarArr2 = null;
                    int i14 = 0;
                    while (i14 < length4) {
                        d$a d_a3 = d_aArrL[i14];
                        if (d_a3.a() != 0) {
                            d_aArr = d_aArrL;
                            if (arrayList != null) {
                                if (yVarArr2 == null) {
                                    y[] yVarArr3 = new y[size];
                                    for (int i15 = 0; i15 < size; i15++) {
                                        yVarArr3[i15] = new y(((d$a) arrayList.get(i15)).a);
                                    }
                                    yVarArr2 = yVarArr3;
                                }
                                y yVar2 = new y(d_a3.a);
                                for (int i16 = 0; i16 < size; i16++) {
                                    if (yVar2.equals(yVarArr2[i16])) {
                                        arrayList2.set(i16, fVar.k((d$a) arrayList.get(i16), d_a3));
                                        break;
                                    }
                                }
                            } else {
                                r2 = listEmptyList2;
                            }
                        } else if (d_a != null) {
                            d_aArr = d_aArrL;
                            fVar.f = new e(fVar.d, d_a.a, fVar.g(d_a, d_a3), u.a);
                            d_a = null;
                        } else {
                            d_aArr = d_aArrL;
                        }
                        i14++;
                        d_aArrL = d_aArr;
                    }
                    r2 = listEmptyList2;
                }
                if (d_a != null) {
                    fVar.f = new e(fVar.d, d_a.a, fVar.g(d_a, null), u.a);
                }
                for (int i17 = 0; i17 < size; i17++) {
                    if (((e) arrayList2.get(i17)) == null) {
                        arrayList2.set(i17, fVar.k((d$a) arrayList.get(i17), null));
                    }
                }
                r2 = arrayList2;
                r2 = listEmptyList2;
                arrayList3 = null;
                while (i < r6) {
                    if (f.f(method2)) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(method2);
                    }
                }
                if (arrayList3 == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    e0_b = new e0$b(nVar);
                    size2 = arrayList3.size();
                    arrayList4 = new ArrayList(size2);
                    while (i2 < size2) {
                        arrayList4.add(null);
                    }
                    if (cls != null) {
                        declaredMethods = cls.getDeclaredMethods();
                        length = declaredMethods.length;
                        yVarArr = null;
                        i5 = 0;
                        while (i5 < length) {
                            method = declaredMethods[i5];
                            if (f.f(method)) {
                                methodArr = declaredMethods;
                            } else {
                                if (yVarArr == null) {
                                    yVarArr = new y[size2];
                                    i7 = 0;
                                    while (i7 < size2) {
                                        yVarArr[i7] = new y((Method) arrayList3.get(i7));
                                        i7++;
                                        declaredMethods = declaredMethods;
                                    }
                                }
                                methodArr = declaredMethods;
                                yVar = new y(method);
                                while (i6 < size2) {
                                    if (yVar.equals(yVarArr[i6])) {
                                        arrayList4.set(i6, fVar.j((Method) arrayList3.get(i6), e0_b, method));
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
                        if (((j) arrayList4.get(i3)) == null) {
                            Method method4 = (Method) arrayList3.get(i3);
                            typeParameters = method4.getTypeParameters();
                            if (typeParameters.length != 0) {
                                jVar = jVar2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                mVar = null;
                            } else {
                                jVar = jVar2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                mVar = null;
                            }
                            if (mVar == null) {
                                e0_a = e0_b;
                            } else {
                                e0_a = new e0$a(nVar, mVar);
                            }
                            arrayList4.set(i3, fVar.j(method4, e0_a, null));
                        } else {
                            jVar = jVar2;
                            i4 = size2;
                            arrayList5 = arrayList3;
                        }
                        i3++;
                        size2 = i4;
                        arrayList3 = arrayList5;
                        jVar2 = jVar;
                    }
                    listEmptyList = arrayList4;
                }
                if (fVar.e) {
                    eVar = fVar.f;
                    if (eVar != null) {
                        fVar.f = null;
                    }
                    size3 = r2.size();
                    while (true) {
                        size3--;
                        if (size3 >= 0) {
                            break;
                            break;
                        }
                        if (fVar.c.Z((i) r2.get(size3))) {
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
                        if (fVar.c.Z((i) listEmptyList.get(size4))) {
                            listEmptyList.remove(size4);
                        }
                    }
                }
                c_a = new c$a(fVar.f, r2, listEmptyList);
            }
            this.u = c_a;
        }
        return c_a;
    }

    public Iterable<g> g() {
        List<g> listEmptyList = this.w;
        if (listEmptyList == null) {
            b.g.a.c.j jVar = this.k;
            if (jVar == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, h$a> mapF = new h(this.o, this.p, this.q, this.f684s).f(this, jVar, null);
                if (mapF == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapF.size());
                    for (h$a h_a : mapF.values()) {
                        arrayList.add(new g(h_a.a, h_a.f690b, h_a.c.b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.w = listEmptyList;
        }
        return listEmptyList;
    }

    public Iterable<j> h() {
        boolean z2;
        Class<?> clsA;
        l lVar = this.v;
        if (lVar == null) {
            b.g.a.c.j jVar = this.k;
            if (jVar == null) {
                lVar = new l();
            } else {
                b.g.a.c.b bVar = this.o;
                t$a t_a = this.q;
                b.g.a.c.h0.n nVar = this.p;
                List<b.g.a.c.j> list = this.n;
                Class<?> cls = this.r;
                k kVar = new k(bVar, t_a, this.f684s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                kVar.f(this, jVar._class, linkedHashMap, cls);
                Iterator<b.g.a.c.j> it = list.iterator();
                while (true) {
                    Class<?> clsA2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    b.g.a.c.j next = it.next();
                    t$a t_a2 = kVar.d;
                    if (t_a2 != null) {
                        clsA2 = t_a2.a(next._class);
                    }
                    kVar.f(new e0$a(nVar, next.j()), next._class, linkedHashMap, clsA2);
                }
                t$a t_a3 = kVar.d;
                if (t_a3 == null || (clsA = t_a3.a(Object.class)) == null) {
                    z2 = false;
                } else {
                    kVar.g(this, jVar._class, linkedHashMap, clsA);
                    z2 = true;
                }
                if (z2 && kVar.c != null && !linkedHashMap.isEmpty()) {
                    for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
                        y yVar = (y) map$Entry.getKey();
                        if ("hashCode".equals(yVar.f696b) && yVar.c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(yVar.f696b, new Class[0]);
                                if (declaredMethod != null) {
                                    k$a k_a = (k$a) map$Entry.getValue();
                                    k_a.c = kVar.d(k_a.c, declaredMethod.getDeclaredAnnotations());
                                    k_a.f691b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    lVar = new l();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
                        k$a k_a2 = (k$a) map$Entry2.getValue();
                        Method method = k_a2.f691b;
                        j jVar2 = method == null ? null : new j(k_a2.a, method, k_a2.c.b(), null);
                        if (jVar2 != null) {
                            linkedHashMap2.put(map$Entry2.getKey(), jVar2);
                        }
                    }
                    lVar = new l(linkedHashMap2);
                }
            }
            this.v = lVar;
        }
        return lVar;
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    public String toString() {
        return b.d.b.a.a.o(this.l, b.d.b.a.a.U("[AnnotedClass "), "]");
    }

    public c(Class<?> cls) {
        this.k = null;
        this.l = cls;
        this.n = Collections.emptyList();
        this.r = null;
        this.t = o.a;
        this.m = b.g.a.c.h0.m.l;
        this.o = null;
        this.q = null;
        this.p = null;
        this.f684s = false;
    }
}
