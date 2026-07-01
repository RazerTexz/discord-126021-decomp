package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.a.JacksonInject;
import b.g.a.a.JsonCreator;
import b.g.a.a.JsonProperty;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyName;
import b.g.a.c.PropertyNamingStrategy;
import b.g.a.c.c0.POJOPropertyBuilder;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.z.MapperConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: renamed from: b.g.a.c.c0.b0, reason: use source file name */
/* JADX INFO: compiled from: POJOPropertiesCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class POJOPropertiesCollector {
    public final MapperConfig<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccessorNamingStrategy f682b;
    public final boolean c;
    public final JavaType d;
    public final AnnotatedClass e;
    public final VisibilityChecker<?> f;
    public final AnnotationIntrospector g;
    public final boolean h;
    public boolean i;
    public LinkedHashMap<String, POJOPropertyBuilder> j;
    public LinkedList<POJOPropertyBuilder> k;
    public Map<PropertyName, PropertyName> l;
    public LinkedList<AnnotatedMember> m;
    public LinkedList<AnnotatedMember> n;
    public LinkedList<AnnotatedMethod> o;
    public LinkedList<AnnotatedMember> p;
    public LinkedList<AnnotatedMember> q;
    public LinkedList<AnnotatedMember> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HashSet<String> f683s;
    public LinkedHashMap<Object, AnnotatedMember> t;

    public POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z2, JavaType javaType, AnnotatedClass annotatedClass, AccessorNamingStrategy accessorNamingStrategy) {
        this.a = mapperConfig;
        this.c = z2;
        this.d = javaType;
        this.e = annotatedClass;
        if (mapperConfig.p()) {
            this.h = true;
            this.g = mapperConfig.e();
        } else {
            this.h = false;
            this.g = NopAnnotationIntrospector.j;
        }
        this.f = mapperConfig.m(javaType._class, annotatedClass);
        this.f682b = accessorNamingStrategy;
        mapperConfig.q(MapperFeature.USE_STD_BEAN_NAMING);
    }

    public void a(Map<String, POJOPropertyBuilder> map, AnnotatedParameter annotatedParameter) {
        POJOPropertyBuilder pOJOPropertyBuilderF;
        JsonCreator.a aVarD;
        String strI = this.g.i(annotatedParameter);
        if (strI == null) {
            strI = "";
        }
        PropertyName propertyNameN = this.g.n(annotatedParameter);
        boolean z2 = (propertyNameN == null || propertyNameN.d()) ? false : true;
        if (!z2) {
            if (strI.isEmpty() || (aVarD = this.g.d(this.a, annotatedParameter._owner)) == null || aVarD == JsonCreator.a.DISABLED) {
                return;
            } else {
                propertyNameN = PropertyName.a(strI);
            }
        }
        PropertyName propertyName = propertyNameN;
        String strB = b(strI);
        if (z2 && strB.isEmpty()) {
            String str = propertyName._simpleName;
            pOJOPropertyBuilderF = map.get(str);
            if (pOJOPropertyBuilderF == null) {
                pOJOPropertyBuilderF = new POJOPropertyBuilder(this.a, this.g, this.c, propertyName);
                map.put(str, pOJOPropertyBuilderF);
            }
        } else {
            pOJOPropertyBuilderF = f(map, strB);
        }
        pOJOPropertyBuilderF.r = new POJOPropertyBuilder.d<>(annotatedParameter, pOJOPropertyBuilderF.r, propertyName, z2, true, false);
        this.k.add(pOJOPropertyBuilderF);
    }

    public final String b(String str) {
        PropertyName propertyName;
        Map<PropertyName, PropertyName> map = this.l;
        return (map == null || (propertyName = map.get(e(str))) == null) ? str : propertyName._simpleName;
    }

    public void c(String str) {
        if (this.c || str == null) {
            return;
        }
        if (this.f683s == null) {
            this.f683s = new HashSet<>();
        }
        this.f683s.add(str);
    }

    public void d(JacksonInject.a aVar, AnnotatedMember annotatedMember) {
        if (aVar == null) {
            return;
        }
        Object obj = aVar._id;
        if (this.t == null) {
            this.t = new LinkedHashMap<>();
        }
        AnnotatedMember annotatedMemberPut = this.t.put(obj, annotatedMember);
        if (annotatedMemberPut == null || annotatedMemberPut.getClass() != annotatedMember.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    public final PropertyName e(String str) {
        return PropertyName.b(str, null);
    }

    public POJOPropertyBuilder f(Map<String, POJOPropertyBuilder> map, String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = map.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        POJOPropertyBuilder pOJOPropertyBuilder2 = new POJOPropertyBuilder(this.a, this.g, this.c, PropertyName.a(str));
        map.put(str, pOJOPropertyBuilder2);
        return pOJOPropertyBuilder2;
    }

    public boolean g(POJOPropertyBuilder pOJOPropertyBuilder, List<POJOPropertyBuilder> list) {
        if (list != null) {
            String str = pOJOPropertyBuilder.p._simpleName;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).p._simpleName.equals(str)) {
                    list.set(i, pOJOPropertyBuilder);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:179:0x0341  */
    /* JADX WARN: Code duplicated, block: B:452:0x087e  */
    public void h() {
        PropertyNamingStrategy propertyNamingStrategy;
        boolean zBooleanValue;
        boolean z2;
        Collection<POJOPropertyBuilder> collectionValues;
        String strC;
        HashSet<String> hashSet;
        JsonProperty.a aVarT;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar2;
        POJOPropertyBuilder.d<AnnotatedField> dVar3;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar4;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar5;
        POJOPropertyBuilder.d<AnnotatedField> dVar6;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar7;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar8;
        boolean z3;
        String strI;
        PropertyName propertyName;
        boolean z4;
        boolean z5;
        boolean zF;
        String strI2;
        PropertyName propertyName2;
        boolean z6;
        boolean zF2;
        PropertyName propertyNameE;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedHashMap<String, POJOPropertyBuilder> linkedHashMap = new LinkedHashMap<>();
        AnnotationIntrospector annotationIntrospector = this.g;
        boolean z10 = (this.c || this.a.q(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zQ = this.a.q(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this.e.g()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(annotationIntrospector.V(this.a, annotatedField))) {
                if (this.q == null) {
                    this.q = new LinkedList<>();
                }
                this.q.add(annotatedField);
            }
            if (bool.equals(annotationIntrospector.W(annotatedField))) {
                if (this.r == null) {
                    this.r = new LinkedList<>();
                }
                this.r.add(annotatedField);
            } else {
                boolean zEquals = bool.equals(annotationIntrospector.S(annotatedField));
                boolean zEquals2 = bool.equals(annotationIntrospector.U(annotatedField));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.n == null) {
                            this.n = new LinkedList<>();
                        }
                        this.n.add(annotatedField);
                    }
                    if (zEquals2) {
                        if (this.p == null) {
                            this.p = new LinkedList<>();
                        }
                        this.p.add(annotatedField);
                    }
                } else {
                    String strI3 = annotationIntrospector.i(annotatedField);
                    if (strI3 == null) {
                        strI3 = annotatedField.c();
                    }
                    Objects.requireNonNull((DefaultAccessorNamingStrategy) this.f682b);
                    if (strI3 != null) {
                        PropertyName propertyNameE2 = e(strI3);
                        PropertyName propertyNameE3 = annotationIntrospector.E(this.a, annotatedField, propertyNameE2);
                        if (propertyNameE3 != null && !propertyNameE3.equals(propertyNameE2)) {
                            if (this.l == null) {
                                this.l = new HashMap();
                            }
                            this.l.put(propertyNameE3, propertyNameE2);
                        }
                        PropertyName propertyNameO = this.c ? annotationIntrospector.o(annotatedField) : annotationIntrospector.n(annotatedField);
                        boolean z11 = propertyNameO != null;
                        if (z11 && propertyNameO.d()) {
                            propertyNameE = e(strI3);
                            z7 = false;
                        } else {
                            propertyNameE = propertyNameO;
                            z7 = z11;
                        }
                        boolean zF3 = propertyNameE != null;
                        if (!zF3) {
                            VisibilityChecker.a aVar = (VisibilityChecker.a) this.f;
                            Objects.requireNonNull(aVar);
                            zF3 = aVar._fieldMinLevel.f(annotatedField.l);
                        }
                        boolean Z = annotationIntrospector.Z(annotatedField);
                        if (!Modifier.isTransient(annotatedField.l.getModifiers()) || z11) {
                            z8 = Z;
                            z9 = zF3;
                        } else if (zQ) {
                            z9 = false;
                            z8 = true;
                        } else {
                            z8 = Z;
                            z9 = false;
                        }
                        if (!z10 || propertyNameE != null || z8 || !Modifier.isFinal(annotatedField.l.getModifiers())) {
                            POJOPropertyBuilder pOJOPropertyBuilderF = f(linkedHashMap, strI3);
                            pOJOPropertyBuilderF.q = new POJOPropertyBuilder.d<>(annotatedField, pOJOPropertyBuilderF.q, propertyNameE, z7, z9, z8);
                        }
                    }
                }
            }
        }
        for (AnnotatedMethod annotatedMethod : (AnnotatedMethodMap) this.e.h()) {
            int iO = annotatedMethod.o();
            if (iO == 0) {
                AnnotationIntrospector annotationIntrospector2 = this.g;
                Class<?> returnType = annotatedMethod.l.getReturnType();
                if (returnType != Void.TYPE && (returnType != Void.class || this.a.q(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES))) {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(annotationIntrospector2.S(annotatedMethod))) {
                        if (this.m == null) {
                            this.m = new LinkedList<>();
                        }
                        this.m.add(annotatedMethod);
                    } else if (bool2.equals(annotationIntrospector2.V(this.a, annotatedMethod))) {
                        if (this.q == null) {
                            this.q = new LinkedList<>();
                        }
                        this.q.add(annotatedMethod);
                    } else if (bool2.equals(annotationIntrospector2.W(annotatedMethod))) {
                        if (this.r == null) {
                            this.r = new LinkedList<>();
                        }
                        this.r.add(annotatedMethod);
                    } else {
                        PropertyName propertyNameO2 = annotationIntrospector2.o(annotatedMethod);
                        boolean z12 = propertyNameO2 != null;
                        if (z12) {
                            strI = annotationIntrospector2.i(annotatedMethod);
                            if (strI == null && (strI = this.f682b.c(annotatedMethod, annotatedMethod.c())) == null) {
                                strI = this.f682b.a(annotatedMethod, annotatedMethod.c());
                            }
                            if (strI == null) {
                                strI = annotatedMethod.c();
                            }
                            if (propertyNameO2.d()) {
                                propertyNameO2 = e(strI);
                                z12 = false;
                            }
                            propertyName = propertyNameO2;
                            z4 = z12;
                            z5 = true;
                        } else {
                            strI = annotationIntrospector2.i(annotatedMethod);
                            if (strI == null) {
                                strI = this.f682b.c(annotatedMethod, annotatedMethod.c());
                            }
                            if (strI == null) {
                                strI = this.f682b.a(annotatedMethod, annotatedMethod.c());
                                if (strI != null) {
                                    VisibilityChecker.a aVar2 = (VisibilityChecker.a) this.f;
                                    Objects.requireNonNull(aVar2);
                                    zF = aVar2._isGetterMinLevel.f(annotatedMethod.l);
                                }
                            } else {
                                VisibilityChecker.a aVar3 = (VisibilityChecker.a) this.f;
                                Objects.requireNonNull(aVar3);
                                zF = aVar3._getterMinLevel.f(annotatedMethod.l);
                            }
                            z4 = z12;
                            z5 = zF;
                            propertyName = propertyNameO2;
                        }
                        String strB = b(strI);
                        boolean Z2 = annotationIntrospector2.Z(annotatedMethod);
                        POJOPropertyBuilder pOJOPropertyBuilderF2 = f(linkedHashMap, strB);
                        pOJOPropertyBuilderF2.f687s = new POJOPropertyBuilder.d<>(annotatedMethod, pOJOPropertyBuilderF2.f687s, propertyName, z4, z5, Z2);
                    }
                }
            } else if (iO == 1) {
                AnnotationIntrospector annotationIntrospector3 = this.g;
                PropertyName propertyNameN = annotationIntrospector3.n(annotatedMethod);
                boolean z13 = propertyNameN != null;
                if (z13) {
                    strI2 = annotationIntrospector3.i(annotatedMethod);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(annotatedMethod, annotatedMethod.c());
                    }
                    if (strI2 == null) {
                        strI2 = annotatedMethod.c();
                    }
                    if (propertyNameN.d()) {
                        propertyNameN = e(strI2);
                        z13 = false;
                    }
                    propertyName2 = propertyNameN;
                    z6 = z13;
                    zF2 = true;
                } else {
                    strI2 = annotationIntrospector3.i(annotatedMethod);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(annotatedMethod, annotatedMethod.c());
                    }
                    if (strI2 != null) {
                        VisibilityChecker.a aVar4 = (VisibilityChecker.a) this.f;
                        Objects.requireNonNull(aVar4);
                        z6 = z13;
                        zF2 = aVar4._setterMinLevel.f(annotatedMethod.l);
                        propertyName2 = propertyNameN;
                    }
                }
                String strB2 = b(strI2);
                boolean Z3 = annotationIntrospector3.Z(annotatedMethod);
                POJOPropertyBuilder pOJOPropertyBuilderF3 = f(linkedHashMap, strB2);
                pOJOPropertyBuilderF3.t = new POJOPropertyBuilder.d<>(annotatedMethod, pOJOPropertyBuilderF3.t, propertyName2, z6, zF2, Z3);
            } else if (iO == 2 && Boolean.TRUE.equals(this.g.U(annotatedMethod))) {
                if (this.o == null) {
                    this.o = new LinkedList<>();
                }
                this.o.add(annotatedMethod);
            }
        }
        AnnotatedClass annotatedClass = this.e;
        Boolean boolValueOf = annotatedClass.f685x;
        if (boolValueOf == null) {
            Class<?> cls = annotatedClass.l;
            Annotation[] annotationArr = ClassUtil.a;
            if (Modifier.isStatic(cls.getModifiers())) {
                z3 = false;
            } else if ((ClassUtil.t(cls) ? null : cls.getEnclosingClass()) != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolValueOf = Boolean.valueOf(z3);
            annotatedClass.f685x = boolValueOf;
        }
        if (!boolValueOf.booleanValue() && this.h) {
            for (AnnotatedConstructor annotatedConstructor : this.e.f().f686b) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int length = annotatedConstructor._constructor.getParameterTypes().length;
                for (int i = 0; i < length; i++) {
                    a(linkedHashMap, annotatedConstructor.m(i));
                }
            }
            for (AnnotatedMethod annotatedMethod2 : this.e.f().c) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int iO2 = annotatedMethod2.o();
                for (int i2 = 0; i2 < iO2; i2++) {
                    a(linkedHashMap, annotatedMethod2.m(i2));
                }
            }
        }
        Iterator<POJOPropertyBuilder> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder next = it.next();
            if (!(next.z(next.q) || next.z(next.f687s) || next.z(next.t) || next.z(next.r))) {
                it.remove();
            } else if (next.y(next.q) || next.y(next.f687s) || next.y(next.t) || next.y(next.r)) {
                if (next.u()) {
                    next.q = next.G(next.q);
                    next.f687s = next.G(next.f687s);
                    next.t = next.G(next.t);
                    next.r = next.G(next.r);
                    if (!next.f()) {
                        c(next.p());
                    }
                } else {
                    it.remove();
                    c(next.p());
                }
            }
        }
        boolean zQ2 = this.a.q(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder pOJOPropertyBuilder : linkedHashMap.values()) {
            POJOPropertiesCollector pOJOPropertiesCollector = this.c ? null : this;
            JsonProperty.a aVar5 = JsonProperty.a.AUTO;
            AnnotationIntrospector annotationIntrospector4 = pOJOPropertyBuilder.n;
            if (annotationIntrospector4 == null || (!pOJOPropertyBuilder.l ? ((dVar = pOJOPropertyBuilder.r) == null || (aVarT = annotationIntrospector4.t(dVar.a)) == null || aVarT == aVar5) && (((dVar2 = pOJOPropertyBuilder.t) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar2.a)) == null || aVarT == aVar5) && (((dVar3 = pOJOPropertyBuilder.q) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar3.a)) == null || aVarT == aVar5) && ((dVar4 = pOJOPropertyBuilder.f687s) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar4.a)) == null || aVarT == aVar5))) : ((dVar5 = pOJOPropertyBuilder.f687s) == null || (aVarT = annotationIntrospector4.t(dVar5.a)) == null || aVarT == aVar5) && (((dVar6 = pOJOPropertyBuilder.q) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar6.a)) == null || aVarT == aVar5) && (((dVar7 = pOJOPropertyBuilder.r) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar7.a)) == null || aVarT == aVar5) && ((dVar8 = pOJOPropertyBuilder.t) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar8.a)) == null || aVarT == aVar5))))) {
                aVarT = null;
            }
            if (aVarT != null) {
                aVar5 = aVarT;
            }
            int iOrdinal = aVar5.ordinal();
            if (iOrdinal == 1) {
                if (pOJOPropertiesCollector != null) {
                    pOJOPropertiesCollector.c(pOJOPropertyBuilder.p());
                    Iterator<PropertyName> it2 = pOJOPropertyBuilder.L().iterator();
                    while (it2.hasNext()) {
                        pOJOPropertiesCollector.c(it2.next()._simpleName);
                    }
                }
                pOJOPropertyBuilder.t = null;
                pOJOPropertyBuilder.r = null;
                if (!pOJOPropertyBuilder.l) {
                    pOJOPropertyBuilder.q = null;
                }
            } else if (iOrdinal == 2) {
                pOJOPropertyBuilder.f687s = null;
                if (pOJOPropertyBuilder.l) {
                    pOJOPropertyBuilder.q = null;
                }
            } else if (iOrdinal != 3) {
                pOJOPropertyBuilder.f687s = pOJOPropertyBuilder.H(pOJOPropertyBuilder.f687s);
                pOJOPropertyBuilder.r = pOJOPropertyBuilder.H(pOJOPropertyBuilder.r);
                if (!zQ2 || pOJOPropertyBuilder.f687s == null) {
                    pOJOPropertyBuilder.q = pOJOPropertyBuilder.H(pOJOPropertyBuilder.q);
                    pOJOPropertyBuilder.t = pOJOPropertyBuilder.H(pOJOPropertyBuilder.t);
                }
            }
        }
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it3 = linkedHashMap.entrySet().iterator();
        LinkedList<POJOPropertyBuilder> linkedList = null;
        while (it3.hasNext()) {
            POJOPropertyBuilder value = it3.next().getValue();
            Set<PropertyName> setL = value.L();
            if (!setL.isEmpty()) {
                it3.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setL.size() == 1) {
                    linkedList.add(new POJOPropertyBuilder(value, setL.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    value.B(setL, map, value.q);
                    value.B(setL, map, value.f687s);
                    value.B(setL, map, value.t);
                    value.B(setL, map, value.r);
                    linkedList.addAll(map.values());
                }
            }
        }
        if (linkedList != null) {
            for (POJOPropertyBuilder pOJOPropertyBuilder2 : linkedList) {
                String strP = pOJOPropertyBuilder2.p();
                POJOPropertyBuilder pOJOPropertyBuilder3 = linkedHashMap.get(strP);
                if (pOJOPropertyBuilder3 == null) {
                    linkedHashMap.put(strP, pOJOPropertyBuilder2);
                } else {
                    pOJOPropertyBuilder3.K(pOJOPropertyBuilder2);
                }
                if (g(pOJOPropertyBuilder2, this.k) && (hashSet = this.f683s) != null) {
                    hashSet.remove(strP);
                }
            }
        }
        for (AnnotatedField annotatedField2 : this.e.g()) {
            d(this.g.j(annotatedField2), annotatedField2);
        }
        for (AnnotatedMethod annotatedMethod3 : (AnnotatedMethodMap) this.e.h()) {
            if (annotatedMethod3.o() == 1) {
                d(this.g.j(annotatedMethod3), annotatedMethod3);
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder4 : linkedHashMap.values()) {
            if (this.c) {
                POJOPropertyBuilder.d<AnnotatedMethod> dVar9 = pOJOPropertyBuilder4.f687s;
                if (dVar9 != null) {
                    pOJOPropertyBuilder4.f687s = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.f687s, pOJOPropertyBuilder4.F(0, dVar9, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.t));
                } else {
                    POJOPropertyBuilder.d<AnnotatedField> dVar10 = pOJOPropertyBuilder4.q;
                    if (dVar10 != null) {
                        pOJOPropertyBuilder4.q = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.F(0, dVar10, pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.t));
                    }
                }
            } else {
                POJOPropertyBuilder.d<AnnotatedParameter> dVar11 = pOJOPropertyBuilder4.r;
                if (dVar11 != null) {
                    pOJOPropertyBuilder4.r = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.F(0, dVar11, pOJOPropertyBuilder4.t, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.f687s));
                } else {
                    POJOPropertyBuilder.d<AnnotatedMethod> dVar12 = pOJOPropertyBuilder4.t;
                    if (dVar12 != null) {
                        pOJOPropertyBuilder4.t = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.t, pOJOPropertyBuilder4.F(0, dVar12, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.f687s));
                    } else {
                        POJOPropertyBuilder.d<AnnotatedField> dVar13 = pOJOPropertyBuilder4.q;
                        if (dVar13 != null) {
                            pOJOPropertyBuilder4.q = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.F(0, dVar13, pOJOPropertyBuilder4.f687s));
                        }
                    }
                }
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder5 : linkedHashMap.values()) {
            pOJOPropertyBuilder5.q = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.q);
            pOJOPropertyBuilder5.f687s = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.f687s);
            pOJOPropertyBuilder5.t = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.t);
            pOJOPropertyBuilder5.r = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.r);
        }
        Object objP = this.g.p(this.e);
        if (objP == null) {
            propertyNamingStrategy = this.a._base._propertyNamingStrategy;
        } else if (objP instanceof PropertyNamingStrategy) {
            propertyNamingStrategy = (PropertyNamingStrategy) objP;
        } else {
            if (!(objP instanceof Class)) {
                StringBuilder sbU = outline.U("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
                sbU.append(objP.getClass().getName());
                sbU.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
                throw new IllegalStateException(sbU.toString());
            }
            Class cls2 = (Class) objP;
            if (cls2 == PropertyNamingStrategy.class) {
                propertyNamingStrategy = null;
            } else {
                if (!PropertyNamingStrategy.class.isAssignableFrom(cls2)) {
                    throw new IllegalStateException(outline.o(cls2, outline.U("AnnotationIntrospector returned Class "), "; expected Class<PropertyNamingStrategy>"));
                }
                Objects.requireNonNull(this.a._base);
                propertyNamingStrategy = (PropertyNamingStrategy) ClassUtil.g(cls2, this.a.b());
            }
        }
        if (propertyNamingStrategy != null) {
            POJOPropertyBuilder[] pOJOPropertyBuilderArr = (POJOPropertyBuilder[]) linkedHashMap.values().toArray(new POJOPropertyBuilder[linkedHashMap.size()]);
            linkedHashMap.clear();
            for (POJOPropertyBuilder pOJOPropertyBuilder6 : pOJOPropertyBuilderArr) {
                PropertyName propertyName3 = pOJOPropertyBuilder6.o;
                if ((pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.q) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.f687s) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.t) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.r)) && !this.a.q(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                    strC = null;
                } else if (this.c) {
                    if (pOJOPropertyBuilder6.f687s != null) {
                        strC = propertyNamingStrategy.c(this.a, pOJOPropertyBuilder6.n(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.q != null) {
                        strC = propertyNamingStrategy.b(this.a, pOJOPropertyBuilder6.l(), propertyName3._simpleName);
                    } else {
                        strC = null;
                    }
                } else if (pOJOPropertyBuilder6.t != null) {
                    strC = propertyNamingStrategy.d(this.a, pOJOPropertyBuilder6.s(), propertyName3._simpleName);
                } else if (pOJOPropertyBuilder6.r != null) {
                    strC = propertyNamingStrategy.a(this.a, pOJOPropertyBuilder6.k(), propertyName3._simpleName);
                } else if (pOJOPropertyBuilder6.q != null) {
                    strC = propertyNamingStrategy.b(this.a, pOJOPropertyBuilder6.l(), propertyName3._simpleName);
                } else if (pOJOPropertyBuilder6.f687s != null) {
                    strC = propertyNamingStrategy.c(this.a, pOJOPropertyBuilder6.n(), propertyName3._simpleName);
                } else {
                    strC = null;
                }
                if (strC == null || propertyName3._simpleName.equals(strC)) {
                    strC = propertyName3._simpleName;
                } else {
                    PropertyName propertyName4 = pOJOPropertyBuilder6.o;
                    if (!strC.equals(propertyName4._simpleName)) {
                        propertyName4 = new PropertyName(strC, propertyName4._namespace);
                    }
                    if (propertyName4 != pOJOPropertyBuilder6.o) {
                        pOJOPropertyBuilder6 = new POJOPropertyBuilder(pOJOPropertyBuilder6, propertyName4);
                    }
                }
                POJOPropertyBuilder pOJOPropertyBuilder7 = linkedHashMap.get(strC);
                if (pOJOPropertyBuilder7 == null) {
                    linkedHashMap.put(strC, pOJOPropertyBuilder6);
                } else {
                    pOJOPropertyBuilder7.K(pOJOPropertyBuilder6);
                }
                g(pOJOPropertyBuilder6, this.k);
            }
        }
        if (this.a.q(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator<Map.Entry<String, POJOPropertyBuilder>> it4 = linkedHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                if (it4.next().getValue().q() != null) {
                    Objects.requireNonNull(this.g);
                }
            }
        }
        AnnotationIntrospector annotationIntrospector5 = this.g;
        Boolean boolJ = annotationIntrospector5.J(this.e);
        if (boolJ == null) {
            MapperConfig<?> mapperConfig = this.a;
            Objects.requireNonNull(mapperConfig);
            zBooleanValue = mapperConfig.q(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            zBooleanValue = boolJ.booleanValue();
        }
        Iterator<POJOPropertyBuilder> it5 = linkedHashMap.values().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (it5.next().o()._index != null) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        String[] strArrI = annotationIntrospector5.I(this.e);
        if (zBooleanValue || z2 || this.k != null || strArrI != null) {
            int size = linkedHashMap.size();
            Map<? extends Object, ? extends Object> treeMap = zBooleanValue ? new TreeMap<>() : new LinkedHashMap<>(size + size);
            for (POJOPropertyBuilder pOJOPropertyBuilder8 : linkedHashMap.values()) {
                treeMap.put(pOJOPropertyBuilder8.p(), pOJOPropertyBuilder8);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
            if (strArrI != null) {
                for (String strP2 : strArrI) {
                    POJOPropertyBuilder pOJOPropertyBuilder9 = (POJOPropertyBuilder) treeMap.remove(strP2);
                    if (pOJOPropertyBuilder9 == null) {
                        for (POJOPropertyBuilder pOJOPropertyBuilder10 : linkedHashMap.values()) {
                            if (strP2.equals(pOJOPropertyBuilder10.p._simpleName)) {
                                strP2 = pOJOPropertyBuilder10.p();
                                pOJOPropertyBuilder9 = pOJOPropertyBuilder10;
                                break;
                            }
                        }
                    }
                    if (pOJOPropertyBuilder9 != null) {
                        linkedHashMap2.put(strP2, pOJOPropertyBuilder9);
                    }
                }
            }
            if (z2) {
                TreeMap treeMap2 = new TreeMap();
                Iterator<Map.Entry<? extends Object, ? extends Object>> it6 = treeMap.entrySet().iterator();
                while (it6.hasNext()) {
                    POJOPropertyBuilder pOJOPropertyBuilder11 = (POJOPropertyBuilder) it6.next().getValue();
                    Integer num = pOJOPropertyBuilder11.o()._index;
                    if (num != null) {
                        treeMap2.put(num, pOJOPropertyBuilder11);
                        it6.remove();
                    }
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder12 : treeMap2.values()) {
                    linkedHashMap2.put(pOJOPropertyBuilder12.p(), pOJOPropertyBuilder12);
                }
            }
            if (this.k != null && (!zBooleanValue || this.a.q(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zBooleanValue) {
                    TreeMap treeMap3 = new TreeMap();
                    for (POJOPropertyBuilder pOJOPropertyBuilder13 : this.k) {
                        treeMap3.put(pOJOPropertyBuilder13.p(), pOJOPropertyBuilder13);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.k;
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder14 : collectionValues) {
                    String strP3 = pOJOPropertyBuilder14.p();
                    if (treeMap.containsKey(strP3)) {
                        linkedHashMap2.put(strP3, pOJOPropertyBuilder14);
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.j = linkedHashMap;
        this.i = true;
    }

    public void i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbU = outline.U("Problem with definition of ");
        sbU.append(this.e);
        sbU.append(": ");
        sbU.append(str);
        throw new IllegalArgumentException(sbU.toString());
    }
}
