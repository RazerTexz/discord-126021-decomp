package p007b.p195g.p196a.p205c.p210c0;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2199t;
import p007b.p195g.p196a.p205c.p210c0.C2187h;
import p007b.p195g.p196a.p205c.p210c0.C2190k;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2182e0;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;

/* JADX INFO: renamed from: b.g.a.c.c0.c */
/* JADX INFO: compiled from: AnnotatedClass.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2177c extends AbstractC2175b implements InterfaceC2182e0 {

    /* JADX INFO: renamed from: j */
    public static final a f4653j = new a(null, Collections.emptyList(), Collections.emptyList());

    /* JADX INFO: renamed from: k */
    public final AbstractC2360j f4654k;

    /* JADX INFO: renamed from: l */
    public final Class<?> f4655l;

    /* JADX INFO: renamed from: m */
    public final C2334m f4656m;

    /* JADX INFO: renamed from: n */
    public final List<AbstractC2360j> f4657n;

    /* JADX INFO: renamed from: o */
    public final AbstractC2165b f4658o;

    /* JADX INFO: renamed from: p */
    public final C2335n f4659p;

    /* JADX INFO: renamed from: q */
    public final AbstractC2199t.a f4660q;

    /* JADX INFO: renamed from: r */
    public final Class<?> f4661r;

    /* JADX INFO: renamed from: s */
    public final boolean f4662s;

    /* JADX INFO: renamed from: t */
    public final InterfaceC2339a f4663t;

    /* JADX INFO: renamed from: u */
    public a f4664u;

    /* JADX INFO: renamed from: v */
    public C2191l f4665v;

    /* JADX INFO: renamed from: w */
    public List<C2185g> f4666w;

    /* JADX INFO: renamed from: x */
    public transient Boolean f4667x;

    /* JADX INFO: renamed from: b.g.a.c.c0.c$a */
    /* JADX INFO: compiled from: AnnotatedClass.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C2181e f4668a;

        /* JADX INFO: renamed from: b */
        public final List<C2181e> f4669b;

        /* JADX INFO: renamed from: c */
        public final List<C2189j> f4670c;

        public a(C2181e c2181e, List<C2181e> list, List<C2189j> list2) {
            this.f4668a = c2181e;
            this.f4669b = list;
            this.f4670c = list2;
        }
    }

    public C2177c(AbstractC2360j abstractC2360j, Class<?> cls, List<AbstractC2360j> list, Class<?> cls2, InterfaceC2339a interfaceC2339a, C2334m c2334m, AbstractC2165b abstractC2165b, AbstractC2199t.a aVar, C2335n c2335n, boolean z2) {
        this.f4654k = abstractC2360j;
        this.f4655l = cls;
        this.f4657n = list;
        this.f4661r = cls2;
        this.f4663t = interfaceC2339a;
        this.f4656m = c2334m;
        this.f4658o = abstractC2165b;
        this.f4660q = aVar;
        this.f4659p = c2335n;
        this.f4662s = z2;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.InterfaceC2182e0
    /* JADX INFO: renamed from: a */
    public AbstractC2360j mo1831a(Type type) {
        return this.f4659p.m2160b(null, type, this.f4656m);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: b */
    public <A extends Annotation> A mo1818b(Class<A> cls) {
        return (A) this.f4663t.mo1915a(cls);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return this.f4655l.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: d */
    public Class<?> mo1820d() {
        return this.f4655l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    /* JADX INFO: renamed from: e */
    public AbstractC2360j mo1821e() {
        return this.f4654k;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return C2342d.m2183o(obj, C2177c.class) && ((C2177c) obj).f4655l == this.f4655l;
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
    /* JADX INFO: renamed from: f */
    public final a m1832f() {
        C2342d.a aVar;
        ArrayList arrayList;
        int size;
        ?? arrayList2;
        ?? r2;
        int i;
        ArrayList arrayList3;
        InterfaceC2182e0.b bVar;
        int size2;
        ArrayList arrayList4;
        int i2;
        int i3;
        List listEmptyList;
        AbstractC2360j abstractC2360j;
        int i4;
        ArrayList arrayList5;
        TypeVariable<Method>[] typeParameters;
        C2334m c2334m;
        InterfaceC2182e0 aVar2;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] declaredMethods;
        int length;
        C2204y[] c2204yArr;
        int i5;
        Method method;
        Method[] methodArr;
        C2204y c2204y;
        int i6;
        int i7;
        C2181e c2181e;
        int size3;
        int size4;
        C2342d.a[] aVarArr;
        List listEmptyList2;
        a aVar3 = this.f4664u;
        if (aVar3 == null) {
            AbstractC2360j abstractC2360j2 = this.f4654k;
            if (abstractC2360j2 == null) {
                aVar3 = f4653j;
            } else {
                AbstractC2165b abstractC2165b = this.f4658o;
                C2335n c2335n = this.f4659p;
                Class<?> cls = this.f4661r;
                C2183f c2183f = new C2183f(abstractC2165b, this, this.f4662s | (cls != null));
                if (abstractC2360j2.m2219w()) {
                    aVar = null;
                    arrayList = null;
                } else {
                    aVar = null;
                    arrayList = null;
                    for (C2342d.a aVar4 : C2342d.m2180l(abstractC2360j2._class)) {
                        if (!aVar4.f4947a.isSynthetic()) {
                            if (aVar4.m2195a() == 0) {
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
                    for (Method method2 : C2342d.m2179k(abstractC2360j2._class)) {
                        if (C2183f.m1892f(method2)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(method2);
                        }
                    }
                    if (arrayList3 == null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        bVar = new InterfaceC2182e0.b(c2335n);
                        size2 = arrayList3.size();
                        arrayList4 = new ArrayList(size2);
                        for (i2 = 0; i2 < size2; i2++) {
                            arrayList4.add(null);
                        }
                        if (cls != null) {
                            declaredMethods = cls.getDeclaredMethods();
                            length = declaredMethods.length;
                            c2204yArr = null;
                            i5 = 0;
                            while (i5 < length) {
                                method = declaredMethods[i5];
                                if (C2183f.m1892f(method)) {
                                    if (c2204yArr == null) {
                                        c2204yArr = new C2204y[size2];
                                        i7 = 0;
                                        while (i7 < size2) {
                                            c2204yArr[i7] = new C2204y((Method) arrayList3.get(i7));
                                            i7++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    c2204y = new C2204y(method);
                                    for (i6 = 0; i6 < size2; i6++) {
                                        if (c2204y.equals(c2204yArr[i6])) {
                                            arrayList4.set(i6, c2183f.m1896j((Method) arrayList3.get(i6), bVar, method));
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
                            if (((C2189j) arrayList4.get(i3)) == null) {
                                Method method3 = (Method) arrayList3.get(i3);
                                typeParameters = method3.getTypeParameters();
                                if (typeParameters.length != 0 || abstractC2360j2.mo2136j().m2154i()) {
                                    abstractC2360j = abstractC2360j2;
                                    i4 = size2;
                                    arrayList5 = arrayList3;
                                    c2334m = null;
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(abstractC2360j2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList6 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            i4 = size2;
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableM529i1 = C1460d.m529i1(actualTypeArguments[i8]);
                                                    if (typeVariableM529i1 != null) {
                                                        String name = typeVariableM529i1.getName();
                                                        if (name == null) {
                                                            abstractC2360j = abstractC2360j2;
                                                        } else {
                                                            arrayList5 = arrayList3;
                                                            AbstractC2360j abstractC2360jM2151f = abstractC2360j2.mo2136j().m2151f(i8);
                                                            if (abstractC2360jM2151f == null) {
                                                                abstractC2360j = abstractC2360j2;
                                                            } else {
                                                                abstractC2360j = abstractC2360j2;
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
                                                                        if (!C1460d.m417A1(bVar, abstractC2360jM2151f, bounds[i11])) {
                                                                            z2 = false;
                                                                            break;
                                                                        }
                                                                        i11++;
                                                                        length3 = i12;
                                                                    }
                                                                    if (z2) {
                                                                        int iIndexOf = arrayList6.indexOf(name);
                                                                        if (iIndexOf != -1) {
                                                                            AbstractC2360j abstractC2360j3 = (AbstractC2360j) arrayList7.get(iIndexOf);
                                                                            if (abstractC2360jM2151f.equals(abstractC2360j3)) {
                                                                                continue;
                                                                            } else {
                                                                                boolean zM2216B = abstractC2360j3.m2216B(abstractC2360jM2151f._class);
                                                                                boolean zM2216B2 = abstractC2360jM2151f.m2216B(abstractC2360j3._class);
                                                                                if (zM2216B || zM2216B2) {
                                                                                    if ((zM2216B ^ zM2216B2) && zM2216B2) {
                                                                                        arrayList7.set(iIndexOf, abstractC2360jM2151f);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            arrayList6.add(name);
                                                                            arrayList7.add(abstractC2360jM2151f);
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        abstractC2360j = abstractC2360j2;
                                                        arrayList5 = arrayList3;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i8++;
                                                    arrayList3 = arrayList5;
                                                    abstractC2360j2 = abstractC2360j;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    abstractC2360j = abstractC2360j2;
                                                    arrayList5 = arrayList3;
                                                    if (!arrayList6.isEmpty()) {
                                                        c2334m = (arrayList6.isEmpty() || arrayList7.isEmpty()) ? C2334m.f4908l : new C2334m((String[]) arrayList6.toArray(C2334m.f4906j), (AbstractC2360j[]) arrayList7.toArray(C2334m.f4907k), null);
                                                    }
                                                }
                                                c2334m = null;
                                            }
                                        } else {
                                            abstractC2360j = abstractC2360j2;
                                            i4 = size2;
                                        }
                                        arrayList5 = arrayList3;
                                        c2334m = null;
                                    } else {
                                        abstractC2360j = abstractC2360j2;
                                        i4 = size2;
                                        arrayList5 = arrayList3;
                                        c2334m = null;
                                    }
                                }
                                if (c2334m == null) {
                                    aVar2 = bVar;
                                } else {
                                    aVar2 = new InterfaceC2182e0.a(c2335n, c2334m);
                                }
                                arrayList4.set(i3, c2183f.m1896j(method3, aVar2, null));
                            } else {
                                abstractC2360j = abstractC2360j2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                            }
                            i3++;
                            size2 = i4;
                            arrayList3 = arrayList5;
                            abstractC2360j2 = abstractC2360j;
                        }
                        listEmptyList = arrayList4;
                    }
                    if (c2183f.f4706e) {
                        c2181e = c2183f.f4707f;
                        if (c2181e != null && c2183f.f4750c.mo1770Z(c2181e)) {
                            c2183f.f4707f = null;
                        }
                        size3 = r2.size();
                        while (true) {
                            size3--;
                            if (size3 >= 0) {
                                break;
                            }
                            if (c2183f.f4750c.mo1770Z((AbstractC2188i) r2.get(size3))) {
                                r2.remove(size3);
                            }
                        }
                        size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 >= 0) {
                                break;
                            }
                            if (c2183f.f4750c.mo1770Z((AbstractC2188i) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    aVar3 = new a(c2183f.f4707f, r2, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i13 = 0; i13 < size; i13++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    C2342d.a[] aVarArrM2180l = C2342d.m2180l(cls);
                    int length4 = aVarArrM2180l.length;
                    C2204y[] c2204yArr2 = null;
                    int i14 = 0;
                    while (i14 < length4) {
                        C2342d.a aVar5 = aVarArrM2180l[i14];
                        if (aVar5.m2195a() != 0) {
                            aVarArr = aVarArrM2180l;
                            if (arrayList != null) {
                                if (c2204yArr2 == null) {
                                    C2204y[] c2204yArr3 = new C2204y[size];
                                    for (int i15 = 0; i15 < size; i15++) {
                                        c2204yArr3[i15] = new C2204y(((C2342d.a) arrayList.get(i15)).f4947a);
                                    }
                                    c2204yArr2 = c2204yArr3;
                                }
                                C2204y c2204y2 = new C2204y(aVar5.f4947a);
                                for (int i16 = 0; i16 < size; i16++) {
                                    if (c2204y2.equals(c2204yArr2[i16])) {
                                        arrayList2.set(i16, c2183f.m1897k((C2342d.a) arrayList.get(i16), aVar5));
                                        break;
                                    }
                                }
                            } else {
                                r2 = listEmptyList2;
                            }
                        } else if (aVar != null) {
                            aVarArr = aVarArrM2180l;
                            c2183f.f4707f = new C2181e(c2183f.f4705d, aVar.f4947a, c2183f.m1893g(aVar, aVar5), C2200u.f4748a);
                            aVar = null;
                        } else {
                            aVarArr = aVarArrM2180l;
                        }
                        i14++;
                        aVarArrM2180l = aVarArr;
                    }
                    r2 = listEmptyList2;
                }
                if (aVar != null) {
                    c2183f.f4707f = new C2181e(c2183f.f4705d, aVar.f4947a, c2183f.m1893g(aVar, null), C2200u.f4748a);
                }
                for (int i17 = 0; i17 < size; i17++) {
                    if (((C2181e) arrayList2.get(i17)) == null) {
                        arrayList2.set(i17, c2183f.m1897k((C2342d.a) arrayList.get(i17), null));
                    }
                }
                r2 = arrayList2;
                r2 = listEmptyList2;
                arrayList3 = null;
                while (i < r6) {
                    if (C2183f.m1892f(method2)) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(method2);
                    }
                }
                if (arrayList3 == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    bVar = new InterfaceC2182e0.b(c2335n);
                    size2 = arrayList3.size();
                    arrayList4 = new ArrayList(size2);
                    while (i2 < size2) {
                        arrayList4.add(null);
                    }
                    if (cls != null) {
                        declaredMethods = cls.getDeclaredMethods();
                        length = declaredMethods.length;
                        c2204yArr = null;
                        i5 = 0;
                        while (i5 < length) {
                            method = declaredMethods[i5];
                            if (C2183f.m1892f(method)) {
                                methodArr = declaredMethods;
                            } else {
                                if (c2204yArr == null) {
                                    c2204yArr = new C2204y[size2];
                                    i7 = 0;
                                    while (i7 < size2) {
                                        c2204yArr[i7] = new C2204y((Method) arrayList3.get(i7));
                                        i7++;
                                        declaredMethods = declaredMethods;
                                    }
                                }
                                methodArr = declaredMethods;
                                c2204y = new C2204y(method);
                                while (i6 < size2) {
                                    if (c2204y.equals(c2204yArr[i6])) {
                                        arrayList4.set(i6, c2183f.m1896j((Method) arrayList3.get(i6), bVar, method));
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
                        if (((C2189j) arrayList4.get(i3)) == null) {
                            Method method4 = (Method) arrayList3.get(i3);
                            typeParameters = method4.getTypeParameters();
                            if (typeParameters.length != 0) {
                                abstractC2360j = abstractC2360j2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                c2334m = null;
                            } else {
                                abstractC2360j = abstractC2360j2;
                                i4 = size2;
                                arrayList5 = arrayList3;
                                c2334m = null;
                            }
                            if (c2334m == null) {
                                aVar2 = bVar;
                            } else {
                                aVar2 = new InterfaceC2182e0.a(c2335n, c2334m);
                            }
                            arrayList4.set(i3, c2183f.m1896j(method4, aVar2, null));
                        } else {
                            abstractC2360j = abstractC2360j2;
                            i4 = size2;
                            arrayList5 = arrayList3;
                        }
                        i3++;
                        size2 = i4;
                        arrayList3 = arrayList5;
                        abstractC2360j2 = abstractC2360j;
                    }
                    listEmptyList = arrayList4;
                }
                if (c2183f.f4706e) {
                    c2181e = c2183f.f4707f;
                    if (c2181e != null) {
                        c2183f.f4707f = null;
                    }
                    size3 = r2.size();
                    while (true) {
                        size3--;
                        if (size3 >= 0) {
                            break;
                            break;
                        }
                        if (c2183f.f4750c.mo1770Z((AbstractC2188i) r2.get(size3))) {
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
                        if (c2183f.f4750c.mo1770Z((AbstractC2188i) listEmptyList.get(size4))) {
                            listEmptyList.remove(size4);
                        }
                    }
                }
                aVar3 = new a(c2183f.f4707f, r2, listEmptyList);
            }
            this.f4664u = aVar3;
        }
        return aVar3;
    }

    /* JADX INFO: renamed from: g */
    public Iterable<C2185g> m1833g() {
        List<C2185g> listEmptyList = this.f4666w;
        if (listEmptyList == null) {
            AbstractC2360j abstractC2360j = this.f4654k;
            if (abstractC2360j == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, C2187h.a> mapM1900f = new C2187h(this.f4658o, this.f4659p, this.f4660q, this.f4662s).m1900f(this, abstractC2360j, null);
                if (mapM1900f == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapM1900f.size());
                    for (C2187h.a aVar : mapM1900f.values()) {
                        arrayList.add(new C2185g(aVar.f4713a, aVar.f4714b, aVar.f4715c.mo1912b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.f4666w = listEmptyList;
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: h */
    public Iterable<C2189j> m1834h() {
        boolean z2;
        Class<?> clsMo1885a;
        C2191l c2191l = this.f4665v;
        if (c2191l == null) {
            AbstractC2360j abstractC2360j = this.f4654k;
            if (abstractC2360j == null) {
                c2191l = new C2191l();
            } else {
                AbstractC2165b abstractC2165b = this.f4658o;
                AbstractC2199t.a aVar = this.f4660q;
                C2335n c2335n = this.f4659p;
                List<AbstractC2360j> list = this.f4657n;
                Class<?> cls = this.f4661r;
                C2190k c2190k = new C2190k(abstractC2165b, aVar, this.f4662s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                c2190k.m1908f(this, abstractC2360j._class, linkedHashMap, cls);
                Iterator<AbstractC2360j> it = list.iterator();
                while (true) {
                    Class<?> clsMo1885a2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    AbstractC2360j next = it.next();
                    AbstractC2199t.a aVar2 = c2190k.f4719d;
                    if (aVar2 != null) {
                        clsMo1885a2 = aVar2.mo1885a(next._class);
                    }
                    c2190k.m1908f(new InterfaceC2182e0.a(c2335n, next.mo2136j()), next._class, linkedHashMap, clsMo1885a2);
                }
                AbstractC2199t.a aVar3 = c2190k.f4719d;
                if (aVar3 == null || (clsMo1885a = aVar3.mo1885a(Object.class)) == null) {
                    z2 = false;
                } else {
                    c2190k.m1909g(this, abstractC2360j._class, linkedHashMap, clsMo1885a);
                    z2 = true;
                }
                if (z2 && c2190k.f4750c != null && !linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        C2204y c2204y = (C2204y) entry.getKey();
                        if ("hashCode".equals(c2204y.f4762b) && c2204y.f4763c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(c2204y.f4762b, new Class[0]);
                                if (declaredMethod != null) {
                                    C2190k.a aVar4 = (C2190k.a) entry.getValue();
                                    aVar4.f4723c = c2190k.m1926d(aVar4.f4723c, declaredMethod.getDeclaredAnnotations());
                                    aVar4.f4722b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    c2191l = new C2191l();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        C2190k.a aVar5 = (C2190k.a) entry2.getValue();
                        Method method = aVar5.f4722b;
                        C2189j c2189j = method == null ? null : new C2189j(aVar5.f4721a, method, aVar5.f4723c.mo1912b(), null);
                        if (c2189j != null) {
                            linkedHashMap2.put(entry2.getKey(), c2189j);
                        }
                    }
                    c2191l = new C2191l(linkedHashMap2);
                }
            }
            this.f4665v = c2191l;
        }
        return c2191l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2175b
    public int hashCode() {
        return this.f4655l.getName().hashCode();
    }

    public String toString() {
        return C1643a.m867o(this.f4655l, C1643a.m833U("[AnnotedClass "), "]");
    }

    public C2177c(Class<?> cls) {
        this.f4654k = null;
        this.f4655l = cls;
        this.f4657n = Collections.emptyList();
        this.f4661r = null;
        this.f4663t = AbstractC2194o.f4725a;
        this.f4656m = C2334m.f4908l;
        this.f4658o = null;
        this.f4660q = null;
        this.f4659p = null;
        this.f4662s = false;
    }
}
