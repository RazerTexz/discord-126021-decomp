package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonSetter;
import b.g.a.a.Nulls;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.z.MapperConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.c0.c0, reason: use source file name */
/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    public static final AnnotationIntrospector.a k = new AnnotationIntrospector.a(1, "");
    public final boolean l;
    public final MapperConfig<?> m;
    public final AnnotationIntrospector n;
    public final PropertyName o;
    public final PropertyName p;
    public d<AnnotatedField> q;
    public d<AnnotatedParameter> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d<AnnotatedMethod> f687s;
    public d<AnnotatedMethod> t;
    public transient PropertyMetadata u;
    public transient AnnotationIntrospector.a v;

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$a */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class a implements e<Class<?>[]> {
        public a() {
        }

        @Override // b.g.a.c.c0.POJOPropertyBuilder.e
        public Class<?>[] a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.n.R(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$b */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class b implements e<AnnotationIntrospector.a> {
        public b() {
        }

        @Override // b.g.a.c.c0.POJOPropertyBuilder.e
        public AnnotationIntrospector.a a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.n.D(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$c */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class c implements e<Boolean> {
        public c() {
        }

        @Override // b.g.a.c.c0.POJOPropertyBuilder.e
        public Boolean a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.n.d0(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$d */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public static final class d<T> {
        public final T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d<T> f688b;
        public final PropertyName c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public d(T t, d<T> dVar, PropertyName propertyName, boolean z2, boolean z3, boolean z4) {
            this.a = t;
            this.f688b = dVar;
            PropertyName propertyName2 = (propertyName == null || propertyName.d()) ? null : propertyName;
            this.c = propertyName2;
            if (z2) {
                if (propertyName2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!propertyName.c()) {
                    z2 = false;
                }
            }
            this.d = z2;
            this.e = z3;
            this.f = z4;
        }

        public d<T> a(d<T> dVar) {
            d<T> dVar2 = this.f688b;
            return dVar2 == null ? c(dVar) : c(dVar2.a(dVar));
        }

        public d<T> b() {
            d<T> dVar = this.f688b;
            if (dVar == null) {
                return this;
            }
            d<T> dVarB = dVar.b();
            if (this.c != null) {
                return dVarB.c == null ? c(null) : c(dVarB);
            }
            if (dVarB.c != null) {
                return dVarB;
            }
            boolean z2 = this.e;
            if (z2 == dVarB.e) {
                return c(dVarB);
            }
            return z2 ? c(null) : dVarB;
        }

        public d<T> c(d<T> dVar) {
            return dVar == this.f688b ? this : new d<>(this.a, dVar, this.c, this.d, this.e, this.f);
        }

        public d<T> d() {
            d<T> dVarD;
            if (!this.f) {
                d<T> dVar = this.f688b;
                return (dVar == null || (dVarD = dVar.d()) == this.f688b) ? this : c(dVarD);
            }
            d<T> dVar2 = this.f688b;
            if (dVar2 == null) {
                return null;
            }
            return dVar2.d();
        }

        public d<T> e() {
            return this.f688b == null ? this : new d<>(this.a, null, this.c, this.d, this.e, this.f);
        }

        public d<T> f() {
            d<T> dVar = this.f688b;
            d<T> dVarF = dVar == null ? null : dVar.f();
            return this.e ? c(dVarF) : dVarF;
        }

        public String toString() {
            String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.a.toString(), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.d));
            if (this.f688b == null) {
                return str;
            }
            StringBuilder sbX = outline.X(str, ", ");
            sbX.append(this.f688b.toString());
            return sbX.toString();
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$e */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public interface e<T> {
        T a(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z2, PropertyName propertyName) {
        this.m = mapperConfig;
        this.n = annotationIntrospector;
        this.p = propertyName;
        this.o = propertyName;
        this.l = z2;
    }

    public static <T> d<T> N(d<T> dVar, d<T> dVar2) {
        if (dVar == null) {
            return dVar2;
        }
        if (dVar2 == null) {
            return dVar;
        }
        d<T> dVar3 = dVar.f688b;
        return dVar3 == null ? dVar.c(dVar2) : dVar.c(dVar3.a(dVar2));
    }

    public final <T extends AnnotatedMember> d<T> A(d<T> dVar, AnnotationMap annotationMap) {
        AnnotatedMember annotatedMember = (AnnotatedMember) dVar.a.l(annotationMap);
        d<T> dVar2 = dVar.f688b;
        if (dVar2 != null) {
            dVar = dVar.c(A(dVar2, annotationMap));
        }
        return annotatedMember == dVar.a ? dVar : new d<>(annotatedMember, dVar.f688b, dVar.c, dVar.d, dVar.e, dVar.f);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void B(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public final Set<PropertyName> C(d<? extends AnnotatedMember> dVar, Set<PropertyName> set) {
        for (d dVar2 = dVar; dVar2 != null; dVar2 = dVar2.f688b) {
            if (dVar2.d && dVar2.c != null) {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(dVar2.c);
            }
        }
        return set;
    }

    public final <T extends AnnotatedMember> AnnotationMap D(d<T> dVar) {
        AnnotationMap annotationMap = dVar.a.k;
        d<T> dVar2 = dVar.f688b;
        return dVar2 != null ? AnnotationMap.c(annotationMap, D(dVar2)) : annotationMap;
    }

    public int E(AnnotatedMethod annotatedMethod) {
        String strC = annotatedMethod.c();
        if (!strC.startsWith("get") || strC.length() <= 3) {
            return (!strC.startsWith("is") || strC.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AnnotationMap F(int i, d<? extends AnnotatedMember>... dVarArr) {
        d<? extends AnnotatedMember> dVar = dVarArr[i];
        AnnotationMap annotationMapC = ((AnnotatedMember) dVar.a).k;
        d<? extends AnnotatedMember> dVar2 = dVar.f688b;
        if (dVar2 != null) {
            annotationMapC = AnnotationMap.c(annotationMapC, D(dVar2));
        }
        do {
            i++;
            if (i >= dVarArr.length) {
                return annotationMapC;
            }
        } while (dVarArr[i] == null);
        return AnnotationMap.c(annotationMapC, F(i, dVarArr));
    }

    public final <T> d<T> G(d<T> dVar) {
        return dVar == null ? dVar : dVar.d();
    }

    public final <T> d<T> H(d<T> dVar) {
        return dVar == null ? dVar : dVar.f();
    }

    public int I(AnnotatedMethod annotatedMethod) {
        String strC = annotatedMethod.c();
        return (!strC.startsWith("set") || strC.length() <= 3) ? 2 : 1;
    }

    public final <T> d<T> J(d<T> dVar) {
        return dVar == null ? dVar : dVar.b();
    }

    public void K(POJOPropertyBuilder pOJOPropertyBuilder) {
        this.q = N(this.q, pOJOPropertyBuilder.q);
        this.r = N(this.r, pOJOPropertyBuilder.r);
        this.f687s = N(this.f687s, pOJOPropertyBuilder.f687s);
        this.t = N(this.t, pOJOPropertyBuilder.t);
    }

    public Set<PropertyName> L() {
        Set<PropertyName> setC = C(this.r, C(this.t, C(this.f687s, C(this.q, null))));
        return setC == null ? Collections.emptySet() : setC;
    }

    public <T> T M(e<T> eVar) {
        d<AnnotatedMethod> dVar;
        d<AnnotatedField> dVar2;
        T tA = null;
        if (this.n == null) {
            return null;
        }
        if (this.l) {
            d<AnnotatedMethod> dVar3 = this.f687s;
            if (dVar3 != null) {
                tA = eVar.a(dVar3.a);
            }
        } else {
            d<AnnotatedParameter> dVar4 = this.r;
            tA = dVar4 != null ? eVar.a(dVar4.a) : null;
            if (tA == null && (dVar = this.t) != null) {
                tA = eVar.a(dVar.a);
            }
        }
        return (tA != null || (dVar2 = this.q) == null) ? tA : eVar.a(dVar2.a);
    }

    @Override // java.lang.Comparable
    public int compareTo(POJOPropertyBuilder pOJOPropertyBuilder) {
        POJOPropertyBuilder pOJOPropertyBuilder2 = pOJOPropertyBuilder;
        if (this.r != null) {
            if (pOJOPropertyBuilder2.r == null) {
                return -1;
            }
        } else if (pOJOPropertyBuilder2.r != null) {
            return 1;
        }
        return p().compareTo(pOJOPropertyBuilder2.p());
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public boolean f() {
        return (this.r == null && this.t == null && this.q == null) ? false : true;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public JsonInclude.b g() {
        AnnotatedMember annotatedMemberJ = j();
        AnnotationIntrospector annotationIntrospector = this.n;
        JsonInclude.b bVarZ = annotationIntrospector == null ? null : annotationIntrospector.z(annotatedMemberJ);
        if (bVarZ != null) {
            return bVarZ;
        }
        JsonInclude.b bVar = JsonInclude.b.j;
        return JsonInclude.b.j;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotationIntrospector.a h() {
        AnnotationIntrospector.a aVar = this.v;
        if (aVar != null) {
            if (aVar == k) {
                return null;
            }
            return aVar;
        }
        AnnotationIntrospector.a aVar2 = (AnnotationIntrospector.a) M(new b());
        this.v = aVar2 == null ? k : aVar2;
        return aVar2;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public Class<?>[] i() {
        return (Class[]) M(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedParameter k() {
        d dVar = this.r;
        if (dVar == null) {
            return null;
        }
        do {
            T t = dVar.a;
            if (((AnnotatedParameter) t)._owner instanceof AnnotatedConstructor) {
                return (AnnotatedParameter) t;
            }
            dVar = dVar.f688b;
        } while (dVar != null);
        return this.r.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedField l() {
        d<AnnotatedField> dVar = this.q;
        if (dVar == null) {
            return null;
        }
        AnnotatedField annotatedField = dVar.a;
        for (d dVar2 = dVar.f688b; dVar2 != null; dVar2 = dVar2.f688b) {
            AnnotatedField annotatedField2 = (AnnotatedField) dVar2.a;
            Class<?> clsG = annotatedField.g();
            Class<?> clsG2 = annotatedField2.g();
            if (clsG != clsG2) {
                if (clsG.isAssignableFrom(clsG2)) {
                    annotatedField = annotatedField2;
                } else if (clsG2.isAssignableFrom(clsG)) {
                }
            }
            StringBuilder sbU = outline.U("Multiple fields representing property \"");
            sbU.append(p());
            sbU.append("\": ");
            sbU.append(annotatedField.h());
            sbU.append(" vs ");
            sbU.append(annotatedField2.h());
            throw new IllegalArgumentException(sbU.toString());
        }
        return annotatedField;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyName m() {
        return this.o;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMethod n() {
        int iE;
        int iE2;
        d dVar = this.f687s;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f688b;
        if (dVar2 == null) {
            return (AnnotatedMethod) dVar.a;
        }
        while (dVar2 != null) {
            Class<?> clsG = ((AnnotatedMethod) dVar.a).g();
            Class<?> clsG2 = ((AnnotatedMethod) dVar2.a).g();
            if (clsG == clsG2) {
                iE = E((AnnotatedMethod) dVar2.a);
                iE2 = E((AnnotatedMethod) dVar.a);
                if (iE != iE2) {
                    StringBuilder sbU = outline.U("Conflicting getter definitions for property \"");
                    sbU.append(p());
                    sbU.append("\": ");
                    sbU.append(((AnnotatedMethod) dVar.a).h());
                    sbU.append(" vs ");
                    sbU.append(((AnnotatedMethod) dVar2.a).h());
                    throw new IllegalArgumentException(sbU.toString());
                }
                if (iE < iE2) {
                    dVar = dVar2;
                }
            } else if (clsG.isAssignableFrom(clsG2)) {
                dVar = dVar2;
            } else if (clsG2.isAssignableFrom(clsG)) {
                continue;
            } else {
                iE = E((AnnotatedMethod) dVar2.a);
                iE2 = E((AnnotatedMethod) dVar.a);
                if (iE != iE2) {
                    StringBuilder sbU2 = outline.U("Conflicting getter definitions for property \"");
                    sbU2.append(p());
                    sbU2.append("\": ");
                    sbU2.append(((AnnotatedMethod) dVar.a).h());
                    sbU2.append(" vs ");
                    sbU2.append(((AnnotatedMethod) dVar2.a).h());
                    throw new IllegalArgumentException(sbU2.toString());
                }
                if (iE < iE2) {
                    dVar = dVar2;
                }
            }
            dVar2 = dVar2.f688b;
        }
        this.f687s = dVar.e();
        return (AnnotatedMethod) dVar.a;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0104  */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyMetadata o() {
        AnnotatedMethod annotatedMethod;
        PropertyMetadata propertyMetadata;
        Nulls nullsA;
        boolean z2;
        Class<?> cls;
        Boolean boolM;
        if (this.u == null) {
            Nulls nullsB = null;
            if (this.l) {
                d<AnnotatedMethod> dVar = this.f687s;
                if (dVar != null) {
                    annotatedMethod = dVar.a;
                } else {
                    d<AnnotatedField> dVar2 = this.q;
                    if (dVar2 != null) {
                        annotatedMethod = dVar2.a;
                    } else {
                        annotatedMethod = null;
                    }
                }
            } else {
                d<AnnotatedParameter> dVar3 = this.r;
                if (dVar3 != null) {
                    annotatedMethod = dVar3.a;
                } else {
                    d<AnnotatedMethod> dVar4 = this.t;
                    if (dVar4 != null) {
                        annotatedMethod = dVar4.a;
                    } else {
                        d<AnnotatedField> dVar5 = this.q;
                        if (dVar5 != null) {
                            annotatedMethod = dVar5.a;
                        } else {
                            d<AnnotatedMethod> dVar6 = this.f687s;
                            if (dVar6 != null) {
                                annotatedMethod = dVar6.a;
                            } else {
                                annotatedMethod = null;
                            }
                        }
                    }
                }
            }
            if (annotatedMethod == null) {
                this.u = PropertyMetadata.l;
            } else {
                Boolean boolA0 = this.n.a0(annotatedMethod);
                String strW = this.n.w(annotatedMethod);
                Integer numB = this.n.B(annotatedMethod);
                String strV = this.n.v(annotatedMethod);
                if (boolA0 == null && numB == null && strV == null) {
                    PropertyMetadata propertyMetadata2 = PropertyMetadata.l;
                    if (strW != null) {
                        propertyMetadata2 = new PropertyMetadata(propertyMetadata2._required, strW, propertyMetadata2._index, propertyMetadata2._defaultValue, propertyMetadata2.m, propertyMetadata2._valueNulls, propertyMetadata2._contentNulls);
                    }
                    this.u = propertyMetadata2;
                } else {
                    PropertyMetadata propertyMetadata3 = PropertyMetadata.j;
                    if (strW != null || numB != null || strV != null) {
                        propertyMetadata = new PropertyMetadata(boolA0, strW, numB, strV, null, null, null);
                    } else if (boolA0 == null) {
                        propertyMetadata = PropertyMetadata.l;
                    } else {
                        propertyMetadata = boolA0.booleanValue() ? PropertyMetadata.j : PropertyMetadata.k;
                    }
                    this.u = propertyMetadata;
                }
                if (!this.l) {
                    PropertyMetadata propertyMetadataA = this.u;
                    AnnotatedMember annotatedMemberJ = j();
                    AnnotationIntrospector annotationIntrospector = this.n;
                    if (annotationIntrospector != null) {
                        if (annotatedMemberJ == null || (boolM = annotationIntrospector.m(annotatedMethod)) == null) {
                            z2 = true;
                        } else {
                            if (boolM.booleanValue()) {
                                propertyMetadataA = propertyMetadataA.a(new PropertyMetadata.a(annotatedMemberJ, false));
                            }
                            z2 = false;
                        }
                        JsonSetter.a aVarM = this.n.M(annotatedMethod);
                        if (aVarM != null) {
                            nullsB = aVarM.b();
                            nullsA = aVarM.a();
                        } else {
                            nullsA = null;
                        }
                    } else {
                        nullsA = null;
                        z2 = true;
                    }
                    if (z2 || nullsB == null || nullsA == null) {
                        if (annotatedMethod instanceof AnnotatedMethod) {
                            AnnotatedMethod annotatedMethod2 = (AnnotatedMethod) annotatedMethod;
                            if (annotatedMethod2.o() > 0) {
                                cls = annotatedMethod2.n(0)._class;
                            } else {
                                cls = annotatedMethod.e()._class;
                            }
                        } else {
                            cls = annotatedMethod.e()._class;
                        }
                        Objects.requireNonNull(this.m.f(cls));
                    }
                    if (z2 || nullsB == null || nullsA == null) {
                        JsonSetter.a aVarL = this.m.l();
                        if (nullsB == null) {
                            nullsB = aVarL.b();
                        }
                        if (nullsA == null) {
                            nullsA = aVarL.a();
                        }
                        if (z2) {
                            if (Boolean.TRUE.equals(this.m.h()) && annotatedMemberJ != null) {
                                propertyMetadataA = propertyMetadataA.a(new PropertyMetadata.a(annotatedMemberJ, true));
                            }
                        }
                    }
                    Nulls nulls = nullsB;
                    Nulls nulls2 = nullsA;
                    if (nulls != null || nulls2 != null) {
                        propertyMetadataA = new PropertyMetadata(propertyMetadataA._required, propertyMetadataA._description, propertyMetadataA._index, propertyMetadataA._defaultValue, propertyMetadataA.m, nulls, nulls2);
                    }
                    this.u = propertyMetadataA;
                }
            }
        }
        return this.u;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public String p() {
        PropertyName propertyName = this.o;
        if (propertyName == null) {
            return null;
        }
        return propertyName._simpleName;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMember q() {
        if (this.l) {
            return j();
        }
        AnnotatedMember annotatedMemberK = k();
        if (annotatedMemberK == null && (annotatedMemberK = s()) == null) {
            annotatedMemberK = l();
        }
        return annotatedMemberK == null ? j() : annotatedMemberK;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d A[PHI: r0
      0x003d: PHI (r0v3 b.g.a.c.c0.b) = (r0v2 b.g.a.c.c0.b), (r0v5 b.g.a.c.c0.b) binds: [B:16:0x0030, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public Class<?> r() {
        JavaType javaTypeE;
        if (this.l) {
            Annotated annotatedN = n();
            javaTypeE = (annotatedN == null && (annotatedN = l()) == null) ? TypeFactory.k() : annotatedN.e();
        } else {
            Annotated annotatedK = k();
            if (annotatedK == null) {
                AnnotatedMethod annotatedMethodS = s();
                if (annotatedMethodS != null) {
                    javaTypeE = annotatedMethodS.n(0);
                } else {
                    annotatedK = l();
                    if (annotatedK == null) {
                        javaTypeE = annotatedK.e();
                    } else {
                        javaTypeE = annotatedK.e();
                    }
                }
            } else if (annotatedK == null || (annotatedK = n()) != null) {
                javaTypeE = annotatedK.e();
            } else {
                javaTypeE = TypeFactory.k();
            }
        }
        return javaTypeE._class;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:36:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public AnnotatedMethod s() {
        AnnotatedMethod annotatedMethod;
        AnnotatedMethod annotatedMethod2;
        int I;
        int I2;
        AnnotationIntrospector annotationIntrospector;
        AnnotatedMethod annotatedMethodF0;
        d dVar = this.t;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f688b;
        if (dVar2 == null) {
            return (AnnotatedMethod) dVar.a;
        }
        while (dVar2 != null) {
            Class<?> clsG = ((AnnotatedMethod) dVar.a).g();
            Class<?> clsG2 = ((AnnotatedMethod) dVar2.a).g();
            if (clsG == clsG2) {
                annotatedMethod = (AnnotatedMethod) dVar2.a;
                annotatedMethod2 = (AnnotatedMethod) dVar.a;
                I = I(annotatedMethod);
                I2 = I(annotatedMethod2);
                if (I != I2) {
                    annotationIntrospector = this.n;
                    if (annotationIntrospector == null) {
                        annotatedMethodF0 = annotationIntrospector.f0(this.m, annotatedMethod2, annotatedMethod);
                        if (annotatedMethodF0 != annotatedMethod2) {
                            if (annotatedMethodF0 != annotatedMethod) {
                            }
                            dVar = dVar2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", p(), ((AnnotatedMethod) dVar.a).h(), ((AnnotatedMethod) dVar2.a).h()));
                }
                if (I < I2) {
                    dVar = dVar2;
                }
            } else if (clsG.isAssignableFrom(clsG2)) {
                dVar = dVar2;
            } else if (clsG2.isAssignableFrom(clsG)) {
                continue;
            } else {
                annotatedMethod = (AnnotatedMethod) dVar2.a;
                annotatedMethod2 = (AnnotatedMethod) dVar.a;
                I = I(annotatedMethod);
                I2 = I(annotatedMethod2);
                if (I != I2) {
                    annotationIntrospector = this.n;
                    if (annotationIntrospector == null) {
                        annotatedMethodF0 = annotationIntrospector.f0(this.m, annotatedMethod2, annotatedMethod);
                        if (annotatedMethodF0 != annotatedMethod2) {
                            if (annotatedMethodF0 != annotatedMethod) {
                            }
                            dVar = dVar2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", p(), ((AnnotatedMethod) dVar.a).h(), ((AnnotatedMethod) dVar2.a).h()));
                }
                if (I < I2) {
                    dVar = dVar2;
                }
            }
            dVar2 = dVar2.f688b;
        }
        this.t = dVar.e();
        return (AnnotatedMethod) dVar.a;
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public PropertyName t() {
        AnnotationIntrospector annotationIntrospector;
        if (q() == null || (annotationIntrospector = this.n) == null) {
            return null;
        }
        Objects.requireNonNull(annotationIntrospector);
        return null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[Property '");
        sbU.append(this.o);
        sbU.append("'; ctors: ");
        sbU.append(this.r);
        sbU.append(", field(s): ");
        sbU.append(this.q);
        sbU.append(", getter(s): ");
        sbU.append(this.f687s);
        sbU.append(", setter(s): ");
        sbU.append(this.t);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public boolean u() {
        return x(this.q) || x(this.f687s) || x(this.t) || w(this.r);
    }

    @Override // b.g.a.c.c0.BeanPropertyDefinition
    public boolean v() {
        Boolean bool = (Boolean) M(new c());
        return bool != null && bool.booleanValue();
    }

    public final <T> boolean w(d<T> dVar) {
        while (dVar != null) {
            if (dVar.c != null && dVar.d) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean x(d<T> dVar) {
        while (dVar != null) {
            PropertyName propertyName = dVar.c;
            if (propertyName != null && propertyName.c()) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean y(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean z(d<T> dVar) {
        while (dVar != null) {
            if (dVar.e) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z2, PropertyName propertyName, PropertyName propertyName2) {
        this.m = mapperConfig;
        this.n = annotationIntrospector;
        this.p = propertyName;
        this.o = propertyName2;
        this.l = z2;
    }

    public POJOPropertyBuilder(POJOPropertyBuilder pOJOPropertyBuilder, PropertyName propertyName) {
        this.m = pOJOPropertyBuilder.m;
        this.n = pOJOPropertyBuilder.n;
        this.p = pOJOPropertyBuilder.p;
        this.o = propertyName;
        this.q = pOJOPropertyBuilder.q;
        this.r = pOJOPropertyBuilder.r;
        this.f687s = pOJOPropertyBuilder.f687s;
        this.t = pOJOPropertyBuilder.t;
        this.l = pOJOPropertyBuilder.l;
    }
}
