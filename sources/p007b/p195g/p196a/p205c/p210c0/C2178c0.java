package p007b.p195g.p196a.p205c.p210c0;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.EnumC2080h0;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2104z;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.c0 */
/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2178c0 extends AbstractC2198s implements Comparable<C2178c0> {

    /* JADX INFO: renamed from: k */
    public static final AbstractC2165b.a f4671k = new AbstractC2165b.a(1, "");

    /* JADX INFO: renamed from: l */
    public final boolean f4672l;

    /* JADX INFO: renamed from: m */
    public final AbstractC2394l<?> f4673m;

    /* JADX INFO: renamed from: n */
    public final AbstractC2165b f4674n;

    /* JADX INFO: renamed from: o */
    public final C2370t f4675o;

    /* JADX INFO: renamed from: p */
    public final C2370t f4676p;

    /* JADX INFO: renamed from: q */
    public d<C2185g> f4677q;

    /* JADX INFO: renamed from: r */
    public d<C2192m> f4678r;

    /* JADX INFO: renamed from: s */
    public d<C2189j> f4679s;

    /* JADX INFO: renamed from: t */
    public d<C2189j> f4680t;

    /* JADX INFO: renamed from: u */
    public transient C2369s f4681u;

    /* JADX INFO: renamed from: v */
    public transient AbstractC2165b.a f4682v;

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$a */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class a implements e<Class<?>[]> {
        public a() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.C2178c0.e
        /* JADX INFO: renamed from: a */
        public Class<?>[] mo1869a(AbstractC2188i abstractC2188i) {
            return C2178c0.this.f4674n.mo1762R(abstractC2188i);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$b */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class b implements e<AbstractC2165b.a> {
        public b() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.C2178c0.e
        /* JADX INFO: renamed from: a */
        public AbstractC2165b.a mo1869a(AbstractC2188i abstractC2188i) {
            return C2178c0.this.f4674n.mo1748D(abstractC2188i);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$c */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class c implements e<Boolean> {
        public c() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.C2178c0.e
        /* JADX INFO: renamed from: a */
        public Boolean mo1869a(AbstractC2188i abstractC2188i) {
            return C2178c0.this.f4674n.mo1778d0(abstractC2188i);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$d */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public static final class d<T> {

        /* JADX INFO: renamed from: a */
        public final T f4686a;

        /* JADX INFO: renamed from: b */
        public final d<T> f4687b;

        /* JADX INFO: renamed from: c */
        public final C2370t f4688c;

        /* JADX INFO: renamed from: d */
        public final boolean f4689d;

        /* JADX INFO: renamed from: e */
        public final boolean f4690e;

        /* JADX INFO: renamed from: f */
        public final boolean f4691f;

        public d(T t, d<T> dVar, C2370t c2370t, boolean z2, boolean z3, boolean z4) {
            this.f4686a = t;
            this.f4687b = dVar;
            C2370t c2370t2 = (c2370t == null || c2370t.m2230d()) ? null : c2370t;
            this.f4688c = c2370t2;
            if (z2) {
                if (c2370t2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!c2370t.m2229c()) {
                    z2 = false;
                }
            }
            this.f4689d = z2;
            this.f4690e = z3;
            this.f4691f = z4;
        }

        /* JADX INFO: renamed from: a */
        public d<T> m1870a(d<T> dVar) {
            d<T> dVar2 = this.f4687b;
            return dVar2 == null ? m1872c(dVar) : m1872c(dVar2.m1870a(dVar));
        }

        /* JADX INFO: renamed from: b */
        public d<T> m1871b() {
            d<T> dVar = this.f4687b;
            if (dVar == null) {
                return this;
            }
            d<T> dVarM1871b = dVar.m1871b();
            if (this.f4688c != null) {
                return dVarM1871b.f4688c == null ? m1872c(null) : m1872c(dVarM1871b);
            }
            if (dVarM1871b.f4688c != null) {
                return dVarM1871b;
            }
            boolean z2 = this.f4690e;
            if (z2 == dVarM1871b.f4690e) {
                return m1872c(dVarM1871b);
            }
            return z2 ? m1872c(null) : dVarM1871b;
        }

        /* JADX INFO: renamed from: c */
        public d<T> m1872c(d<T> dVar) {
            return dVar == this.f4687b ? this : new d<>(this.f4686a, dVar, this.f4688c, this.f4689d, this.f4690e, this.f4691f);
        }

        /* JADX INFO: renamed from: d */
        public d<T> m1873d() {
            d<T> dVarM1873d;
            if (!this.f4691f) {
                d<T> dVar = this.f4687b;
                return (dVar == null || (dVarM1873d = dVar.m1873d()) == this.f4687b) ? this : m1872c(dVarM1873d);
            }
            d<T> dVar2 = this.f4687b;
            if (dVar2 == null) {
                return null;
            }
            return dVar2.m1873d();
        }

        /* JADX INFO: renamed from: e */
        public d<T> m1874e() {
            return this.f4687b == null ? this : new d<>(this.f4686a, null, this.f4688c, this.f4689d, this.f4690e, this.f4691f);
        }

        /* JADX INFO: renamed from: f */
        public d<T> m1875f() {
            d<T> dVar = this.f4687b;
            d<T> dVarM1875f = dVar == null ? null : dVar.m1875f();
            return this.f4690e ? m1872c(dVarM1875f) : dVarM1875f;
        }

        public String toString() {
            String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.f4686a.toString(), Boolean.valueOf(this.f4690e), Boolean.valueOf(this.f4691f), Boolean.valueOf(this.f4689d));
            if (this.f4687b == null) {
                return str;
            }
            StringBuilder sbM836X = C1643a.m836X(str, ", ");
            sbM836X.append(this.f4687b.toString());
            return sbM836X.toString();
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$e */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public interface e<T> {
        /* JADX INFO: renamed from: a */
        T mo1869a(AbstractC2188i abstractC2188i);
    }

    public C2178c0(AbstractC2394l<?> abstractC2394l, AbstractC2165b abstractC2165b, boolean z2, C2370t c2370t) {
        this.f4673m = abstractC2394l;
        this.f4674n = abstractC2165b;
        this.f4676p = c2370t;
        this.f4675o = c2370t;
        this.f4672l = z2;
    }

    /* JADX INFO: renamed from: N */
    public static <T> d<T> m1835N(d<T> dVar, d<T> dVar2) {
        if (dVar == null) {
            return dVar2;
        }
        if (dVar2 == null) {
            return dVar;
        }
        d<T> dVar3 = dVar.f4687b;
        return dVar3 == null ? dVar.m1872c(dVar2) : dVar.m1872c(dVar3.m1870a(dVar2));
    }

    /* JADX INFO: renamed from: A */
    public final <T extends AbstractC2188i> d<T> m1836A(d<T> dVar, C2195p c2195p) {
        AbstractC2188i abstractC2188i = (AbstractC2188i) dVar.f4686a.mo1890l(c2195p);
        d<T> dVar2 = dVar.f4687b;
        if (dVar2 != null) {
            dVar = dVar.m1872c(m1836A(dVar2, c2195p));
        }
        return abstractC2188i == dVar.f4686a ? dVar : new d<>(abstractC2188i, dVar.f4687b, dVar.f4688c, dVar.f4689d, dVar.f4690e, dVar.f4691f);
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
    /* JADX INFO: renamed from: B */
    public final void m1837B(
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

    /* JADX INFO: renamed from: C */
    public final Set<C2370t> m1838C(d<? extends AbstractC2188i> dVar, Set<C2370t> set) {
        for (d dVar2 = dVar; dVar2 != null; dVar2 = dVar2.f4687b) {
            if (dVar2.f4689d && dVar2.f4688c != null) {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(dVar2.f4688c);
            }
        }
        return set;
    }

    /* JADX INFO: renamed from: D */
    public final <T extends AbstractC2188i> C2195p m1839D(d<T> dVar) {
        C2195p c2195p = dVar.f4686a.f4717k;
        d<T> dVar2 = dVar.f4687b;
        return dVar2 != null ? C2195p.m1916c(c2195p, m1839D(dVar2)) : c2195p;
    }

    /* JADX INFO: renamed from: E */
    public int m1840E(C2189j c2189j) {
        String strMo1819c = c2189j.mo1819c();
        if (!strMo1819c.startsWith("get") || strMo1819c.length() <= 3) {
            return (!strMo1819c.startsWith("is") || strMo1819c.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: F */
    public final C2195p m1841F(int i, d<? extends AbstractC2188i>... dVarArr) {
        d<? extends AbstractC2188i> dVar = dVarArr[i];
        C2195p c2195pM1916c = ((AbstractC2188i) dVar.f4686a).f4717k;
        d<? extends AbstractC2188i> dVar2 = dVar.f4687b;
        if (dVar2 != null) {
            c2195pM1916c = C2195p.m1916c(c2195pM1916c, m1839D(dVar2));
        }
        do {
            i++;
            if (i >= dVarArr.length) {
                return c2195pM1916c;
            }
        } while (dVarArr[i] == null);
        return C2195p.m1916c(c2195pM1916c, m1841F(i, dVarArr));
    }

    /* JADX INFO: renamed from: G */
    public final <T> d<T> m1842G(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1873d();
    }

    /* JADX INFO: renamed from: H */
    public final <T> d<T> m1843H(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1875f();
    }

    /* JADX INFO: renamed from: I */
    public int m1844I(C2189j c2189j) {
        String strMo1819c = c2189j.mo1819c();
        return (!strMo1819c.startsWith("set") || strMo1819c.length() <= 3) ? 2 : 1;
    }

    /* JADX INFO: renamed from: J */
    public final <T> d<T> m1845J(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1871b();
    }

    /* JADX INFO: renamed from: K */
    public void m1846K(C2178c0 c2178c0) {
        this.f4677q = m1835N(this.f4677q, c2178c0.f4677q);
        this.f4678r = m1835N(this.f4678r, c2178c0.f4678r);
        this.f4679s = m1835N(this.f4679s, c2178c0.f4679s);
        this.f4680t = m1835N(this.f4680t, c2178c0.f4680t);
    }

    /* JADX INFO: renamed from: L */
    public Set<C2370t> m1847L() {
        Set<C2370t> setM1838C = m1838C(this.f4678r, m1838C(this.f4680t, m1838C(this.f4679s, m1838C(this.f4677q, null))));
        return setM1838C == null ? Collections.emptySet() : setM1838C;
    }

    /* JADX INFO: renamed from: M */
    public <T> T m1848M(e<T> eVar) {
        d<C2189j> dVar;
        d<C2185g> dVar2;
        T tMo1869a = null;
        if (this.f4674n == null) {
            return null;
        }
        if (this.f4672l) {
            d<C2189j> dVar3 = this.f4679s;
            if (dVar3 != null) {
                tMo1869a = eVar.mo1869a(dVar3.f4686a);
            }
        } else {
            d<C2192m> dVar4 = this.f4678r;
            tMo1869a = dVar4 != null ? eVar.mo1869a(dVar4.f4686a) : null;
            if (tMo1869a == null && (dVar = this.f4680t) != null) {
                tMo1869a = eVar.mo1869a(dVar.f4686a);
            }
        }
        return (tMo1869a != null || (dVar2 = this.f4677q) == null) ? tMo1869a : eVar.mo1869a(dVar2.f4686a);
    }

    @Override // java.lang.Comparable
    public int compareTo(C2178c0 c2178c0) {
        C2178c0 c2178c1 = c2178c0;
        if (this.f4678r != null) {
            if (c2178c1.f4678r == null) {
                return -1;
            }
        } else if (c2178c1.f4678r != null) {
            return 1;
        }
        return mo1858p().compareTo(c2178c1.mo1858p());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: f */
    public boolean mo1849f() {
        return (this.f4678r == null && this.f4680t == null && this.f4677q == null) ? false : true;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: g */
    public InterfaceC2094p.b mo1850g() {
        AbstractC2188i abstractC2188iM1922j = m1922j();
        AbstractC2165b abstractC2165b = this.f4674n;
        InterfaceC2094p.b bVarMo1802z = abstractC2165b == null ? null : abstractC2165b.mo1802z(abstractC2188iM1922j);
        if (bVarMo1802z != null) {
            return bVarMo1802z;
        }
        InterfaceC2094p.b bVar = InterfaceC2094p.b.f4436j;
        return InterfaceC2094p.b.f4436j;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: h */
    public AbstractC2165b.a mo1851h() {
        AbstractC2165b.a aVar = this.f4682v;
        if (aVar != null) {
            if (aVar == f4671k) {
                return null;
            }
            return aVar;
        }
        AbstractC2165b.a aVar2 = (AbstractC2165b.a) m1848M(new b());
        this.f4682v = aVar2 == null ? f4671k : aVar2;
        return aVar2;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: i */
    public Class<?>[] mo1852i() {
        return (Class[]) m1848M(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: k */
    public C2192m mo1853k() {
        d dVar = this.f4678r;
        if (dVar == null) {
            return null;
        }
        do {
            T t = dVar.f4686a;
            if (((C2192m) t)._owner instanceof C2181e) {
                return (C2192m) t;
            }
            dVar = dVar.f4687b;
        } while (dVar != null);
        return this.f4678r.f4686a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: l */
    public C2185g mo1854l() {
        d<C2185g> dVar = this.f4677q;
        if (dVar == null) {
            return null;
        }
        C2185g c2185g = dVar.f4686a;
        for (d dVar2 = dVar.f4687b; dVar2 != null; dVar2 = dVar2.f4687b) {
            C2185g c2185g2 = (C2185g) dVar2.f4686a;
            Class<?> clsMo1887g = c2185g.mo1887g();
            Class<?> clsMo1887g2 = c2185g2.mo1887g();
            if (clsMo1887g != clsMo1887g2) {
                if (clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                    c2185g = c2185g2;
                } else if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                }
            }
            StringBuilder sbM833U = C1643a.m833U("Multiple fields representing property \"");
            sbM833U.append(mo1858p());
            sbM833U.append("\": ");
            sbM833U.append(c2185g.mo1903h());
            sbM833U.append(" vs ");
            sbM833U.append(c2185g2.mo1903h());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        return c2185g;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: m */
    public C2370t mo1855m() {
        return this.f4675o;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: n */
    public C2189j mo1856n() {
        int iM1840E;
        int iM1840E2;
        d dVar = this.f4679s;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f4687b;
        if (dVar2 == null) {
            return (C2189j) dVar.f4686a;
        }
        while (dVar2 != null) {
            Class<?> clsMo1887g = ((C2189j) dVar.f4686a).mo1887g();
            Class<?> clsMo1887g2 = ((C2189j) dVar2.f4686a).mo1887g();
            if (clsMo1887g == clsMo1887g2) {
                iM1840E = m1840E((C2189j) dVar2.f4686a);
                iM1840E2 = m1840E((C2189j) dVar.f4686a);
                if (iM1840E != iM1840E2) {
                    StringBuilder sbM833U = C1643a.m833U("Conflicting getter definitions for property \"");
                    sbM833U.append(mo1858p());
                    sbM833U.append("\": ");
                    sbM833U.append(((C2189j) dVar.f4686a).mo1903h());
                    sbM833U.append(" vs ");
                    sbM833U.append(((C2189j) dVar2.f4686a).mo1903h());
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                if (iM1840E < iM1840E2) {
                    dVar = dVar2;
                }
            } else if (clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                dVar = dVar2;
            } else if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                continue;
            } else {
                iM1840E = m1840E((C2189j) dVar2.f4686a);
                iM1840E2 = m1840E((C2189j) dVar.f4686a);
                if (iM1840E != iM1840E2) {
                    StringBuilder sbM833U2 = C1643a.m833U("Conflicting getter definitions for property \"");
                    sbM833U2.append(mo1858p());
                    sbM833U2.append("\": ");
                    sbM833U2.append(((C2189j) dVar.f4686a).mo1903h());
                    sbM833U2.append(" vs ");
                    sbM833U2.append(((C2189j) dVar2.f4686a).mo1903h());
                    throw new IllegalArgumentException(sbM833U2.toString());
                }
                if (iM1840E < iM1840E2) {
                    dVar = dVar2;
                }
            }
            dVar2 = dVar2.f4687b;
        }
        this.f4679s = dVar.m1874e();
        return (C2189j) dVar.f4686a;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0104  */
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: o */
    public C2369s mo1857o() {
        C2189j c2189j;
        C2369s c2369s;
        EnumC2080h0 enumC2080h0M1620a;
        boolean z2;
        Class<?> cls;
        Boolean boolMo1789m;
        if (this.f4681u == null) {
            EnumC2080h0 enumC2080h0M1621b = null;
            if (this.f4672l) {
                d<C2189j> dVar = this.f4679s;
                if (dVar != null) {
                    c2189j = dVar.f4686a;
                } else {
                    d<C2185g> dVar2 = this.f4677q;
                    if (dVar2 != null) {
                        c2189j = dVar2.f4686a;
                    } else {
                        c2189j = null;
                    }
                }
            } else {
                d<C2192m> dVar3 = this.f4678r;
                if (dVar3 != null) {
                    c2189j = dVar3.f4686a;
                } else {
                    d<C2189j> dVar4 = this.f4680t;
                    if (dVar4 != null) {
                        c2189j = dVar4.f4686a;
                    } else {
                        d<C2185g> dVar5 = this.f4677q;
                        if (dVar5 != null) {
                            c2189j = dVar5.f4686a;
                        } else {
                            d<C2189j> dVar6 = this.f4679s;
                            if (dVar6 != null) {
                                c2189j = dVar6.f4686a;
                            } else {
                                c2189j = null;
                            }
                        }
                    }
                }
            }
            if (c2189j == null) {
                this.f4681u = C2369s.f5027l;
            } else {
                Boolean boolMo1772a0 = this.f4674n.mo1772a0(c2189j);
                String strMo1799w = this.f4674n.mo1799w(c2189j);
                Integer numMo1746B = this.f4674n.mo1746B(c2189j);
                String strMo1798v = this.f4674n.mo1798v(c2189j);
                if (boolMo1772a0 == null && numMo1746B == null && strMo1798v == null) {
                    C2369s c2369s2 = C2369s.f5027l;
                    if (strMo1799w != null) {
                        c2369s2 = new C2369s(c2369s2._required, strMo1799w, c2369s2._index, c2369s2._defaultValue, c2369s2.f5028m, c2369s2._valueNulls, c2369s2._contentNulls);
                    }
                    this.f4681u = c2369s2;
                } else {
                    C2369s c2369s3 = C2369s.f5025j;
                    if (strMo1799w != null || numMo1746B != null || strMo1798v != null) {
                        c2369s = new C2369s(boolMo1772a0, strMo1799w, numMo1746B, strMo1798v, null, null, null);
                    } else if (boolMo1772a0 == null) {
                        c2369s = C2369s.f5027l;
                    } else {
                        c2369s = boolMo1772a0.booleanValue() ? C2369s.f5025j : C2369s.f5026k;
                    }
                    this.f4681u = c2369s;
                }
                if (!this.f4672l) {
                    C2369s c2369sM2226a = this.f4681u;
                    AbstractC2188i abstractC2188iM1922j = m1922j();
                    AbstractC2165b abstractC2165b = this.f4674n;
                    if (abstractC2165b != null) {
                        if (abstractC2188iM1922j == null || (boolMo1789m = abstractC2165b.mo1789m(c2189j)) == null) {
                            z2 = true;
                        } else {
                            if (boolMo1789m.booleanValue()) {
                                c2369sM2226a = c2369sM2226a.m2226a(new C2369s.a(abstractC2188iM1922j, false));
                            }
                            z2 = false;
                        }
                        InterfaceC2104z.a aVarMo1757M = this.f4674n.mo1757M(c2189j);
                        if (aVarMo1757M != null) {
                            enumC2080h0M1621b = aVarMo1757M.m1621b();
                            enumC2080h0M1620a = aVarMo1757M.m1620a();
                        } else {
                            enumC2080h0M1620a = null;
                        }
                    } else {
                        enumC2080h0M1620a = null;
                        z2 = true;
                    }
                    if (z2 || enumC2080h0M1621b == null || enumC2080h0M1620a == null) {
                        if (c2189j instanceof C2189j) {
                            C2189j c2189j2 = (C2189j) c2189j;
                            if (c2189j2.m1905o() > 0) {
                                cls = c2189j2.mo1891n(0)._class;
                            } else {
                                cls = c2189j.mo1821e()._class;
                            }
                        } else {
                            cls = c2189j.mo1821e()._class;
                        }
                        Objects.requireNonNull(this.f4673m.mo2268f(cls));
                    }
                    if (z2 || enumC2080h0M1621b == null || enumC2080h0M1620a == null) {
                        InterfaceC2104z.a aVarMo2274l = this.f4673m.mo2274l();
                        if (enumC2080h0M1621b == null) {
                            enumC2080h0M1621b = aVarMo2274l.m1621b();
                        }
                        if (enumC2080h0M1620a == null) {
                            enumC2080h0M1620a = aVarMo2274l.m1620a();
                        }
                        if (z2) {
                            if (Boolean.TRUE.equals(this.f4673m.mo2270h()) && abstractC2188iM1922j != null) {
                                c2369sM2226a = c2369sM2226a.m2226a(new C2369s.a(abstractC2188iM1922j, true));
                            }
                        }
                    }
                    EnumC2080h0 enumC2080h0 = enumC2080h0M1621b;
                    EnumC2080h0 enumC2080h1 = enumC2080h0M1620a;
                    if (enumC2080h0 != null || enumC2080h1 != null) {
                        c2369sM2226a = new C2369s(c2369sM2226a._required, c2369sM2226a._description, c2369sM2226a._index, c2369sM2226a._defaultValue, c2369sM2226a.f5028m, enumC2080h0, enumC2080h1);
                    }
                    this.f4681u = c2369sM2226a;
                }
            }
        }
        return this.f4681u;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: p */
    public String mo1858p() {
        C2370t c2370t = this.f4675o;
        if (c2370t == null) {
            return null;
        }
        return c2370t._simpleName;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: q */
    public AbstractC2188i mo1859q() {
        if (this.f4672l) {
            return m1922j();
        }
        AbstractC2188i abstractC2188iMo1853k = mo1853k();
        if (abstractC2188iMo1853k == null && (abstractC2188iMo1853k = mo1861s()) == null) {
            abstractC2188iMo1853k = mo1854l();
        }
        return abstractC2188iMo1853k == null ? m1922j() : abstractC2188iMo1853k;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d A[PHI: r0
      0x003d: PHI (r0v3 b.g.a.c.c0.b) = (r0v2 b.g.a.c.c0.b), (r0v5 b.g.a.c.c0.b) binds: [B:16:0x0030, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: r */
    public Class<?> mo1860r() {
        AbstractC2360j abstractC2360jMo1821e;
        if (this.f4672l) {
            AbstractC2175b abstractC2175bMo1856n = mo1856n();
            abstractC2360jMo1821e = (abstractC2175bMo1856n == null && (abstractC2175bMo1856n = mo1854l()) == null) ? C2335n.m2158k() : abstractC2175bMo1856n.mo1821e();
        } else {
            AbstractC2175b abstractC2175bMo1853k = mo1853k();
            if (abstractC2175bMo1853k == null) {
                C2189j c2189jMo1861s = mo1861s();
                if (c2189jMo1861s != null) {
                    abstractC2360jMo1821e = c2189jMo1861s.mo1891n(0);
                } else {
                    abstractC2175bMo1853k = mo1854l();
                    if (abstractC2175bMo1853k == null) {
                        abstractC2360jMo1821e = abstractC2175bMo1853k.mo1821e();
                    } else {
                        abstractC2360jMo1821e = abstractC2175bMo1853k.mo1821e();
                    }
                }
            } else if (abstractC2175bMo1853k == null || (abstractC2175bMo1853k = mo1856n()) != null) {
                abstractC2360jMo1821e = abstractC2175bMo1853k.mo1821e();
            } else {
                abstractC2360jMo1821e = C2335n.m2158k();
            }
        }
        return abstractC2360jMo1821e._class;
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
    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: s */
    public C2189j mo1861s() {
        C2189j c2189j;
        C2189j c2189j2;
        int iM1844I;
        int iM1844I2;
        AbstractC2165b abstractC2165b;
        C2189j c2189jMo1782f0;
        d dVar = this.f4680t;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f4687b;
        if (dVar2 == null) {
            return (C2189j) dVar.f4686a;
        }
        while (dVar2 != null) {
            Class<?> clsMo1887g = ((C2189j) dVar.f4686a).mo1887g();
            Class<?> clsMo1887g2 = ((C2189j) dVar2.f4686a).mo1887g();
            if (clsMo1887g == clsMo1887g2) {
                c2189j = (C2189j) dVar2.f4686a;
                c2189j2 = (C2189j) dVar.f4686a;
                iM1844I = m1844I(c2189j);
                iM1844I2 = m1844I(c2189j2);
                if (iM1844I != iM1844I2) {
                    abstractC2165b = this.f4674n;
                    if (abstractC2165b == null) {
                        c2189jMo1782f0 = abstractC2165b.mo1782f0(this.f4673m, c2189j2, c2189j);
                        if (c2189jMo1782f0 != c2189j2) {
                            if (c2189jMo1782f0 != c2189j) {
                            }
                            dVar = dVar2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", mo1858p(), ((C2189j) dVar.f4686a).mo1903h(), ((C2189j) dVar2.f4686a).mo1903h()));
                }
                if (iM1844I < iM1844I2) {
                    dVar = dVar2;
                }
            } else if (clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                dVar = dVar2;
            } else if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                continue;
            } else {
                c2189j = (C2189j) dVar2.f4686a;
                c2189j2 = (C2189j) dVar.f4686a;
                iM1844I = m1844I(c2189j);
                iM1844I2 = m1844I(c2189j2);
                if (iM1844I != iM1844I2) {
                    abstractC2165b = this.f4674n;
                    if (abstractC2165b == null) {
                        c2189jMo1782f0 = abstractC2165b.mo1782f0(this.f4673m, c2189j2, c2189j);
                        if (c2189jMo1782f0 != c2189j2) {
                            if (c2189jMo1782f0 != c2189j) {
                            }
                            dVar = dVar2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", mo1858p(), ((C2189j) dVar.f4686a).mo1903h(), ((C2189j) dVar2.f4686a).mo1903h()));
                }
                if (iM1844I < iM1844I2) {
                    dVar = dVar2;
                }
            }
            dVar2 = dVar2.f4687b;
        }
        this.f4680t = dVar.m1874e();
        return (C2189j) dVar.f4686a;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: t */
    public C2370t mo1862t() {
        AbstractC2165b abstractC2165b;
        if (mo1859q() == null || (abstractC2165b = this.f4674n) == null) {
            return null;
        }
        Objects.requireNonNull(abstractC2165b);
        return null;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[Property '");
        sbM833U.append(this.f4675o);
        sbM833U.append("'; ctors: ");
        sbM833U.append(this.f4678r);
        sbM833U.append(", field(s): ");
        sbM833U.append(this.f4677q);
        sbM833U.append(", getter(s): ");
        sbM833U.append(this.f4679s);
        sbM833U.append(", setter(s): ");
        sbM833U.append(this.f4680t);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: u */
    public boolean mo1863u() {
        return m1866x(this.f4677q) || m1866x(this.f4679s) || m1866x(this.f4680t) || m1865w(this.f4678r);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: v */
    public boolean mo1864v() {
        Boolean bool = (Boolean) m1848M(new c());
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: renamed from: w */
    public final <T> boolean m1865w(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4688c != null && dVar.f4689d) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: x */
    public final <T> boolean m1866x(d<T> dVar) {
        while (dVar != null) {
            C2370t c2370t = dVar.f4688c;
            if (c2370t != null && c2370t.m2229c()) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final <T> boolean m1867y(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4691f) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: z */
    public final <T> boolean m1868z(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4690e) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    public C2178c0(AbstractC2394l<?> abstractC2394l, AbstractC2165b abstractC2165b, boolean z2, C2370t c2370t, C2370t c2370t2) {
        this.f4673m = abstractC2394l;
        this.f4674n = abstractC2165b;
        this.f4676p = c2370t;
        this.f4675o = c2370t2;
        this.f4672l = z2;
    }

    public C2178c0(C2178c0 c2178c0, C2370t c2370t) {
        this.f4673m = c2178c0.f4673m;
        this.f4674n = c2178c0.f4674n;
        this.f4676p = c2178c0.f4676p;
        this.f4675o = c2370t;
        this.f4677q = c2178c0.f4677q;
        this.f4678r = c2178c0.f4678r;
        this.f4679s = c2178c0.f4679s;
        this.f4680t = c2178c0.f4680t;
        this.f4672l = c2178c0.f4672l;
    }
}
