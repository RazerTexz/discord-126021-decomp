package b.g.a.c.c0;

import b.g.a.a.h0;
import b.g.a.a.p$b;
import b.g.a.c.b$a;
import b.g.a.c.s$a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 extends s implements Comparable<c0> {
    public static final b$a k = new b$a(1, "");
    public final boolean l;
    public final b.g.a.c.z.l<?> m;
    public final b.g.a.c.b n;
    public final b.g.a.c.t o;
    public final b.g.a.c.t p;
    public c0$d<g> q;
    public c0$d<m> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c0$d<j> f687s;
    public c0$d<j> t;
    public transient b.g.a.c.s u;
    public transient b$a v;

    public c0(b.g.a.c.z.l<?> lVar, b.g.a.c.b bVar, boolean z2, b.g.a.c.t tVar) {
        this.m = lVar;
        this.n = bVar;
        this.p = tVar;
        this.o = tVar;
        this.l = z2;
    }

    public static <T> c0$d<T> N(c0$d<T> c0_d, c0$d<T> c0_d2) {
        if (c0_d == null) {
            return c0_d2;
        }
        if (c0_d2 == null) {
            return c0_d;
        }
        c0$d<T> c0_d3 = c0_d.f688b;
        return c0_d3 == null ? c0_d.c(c0_d2) : c0_d.c(c0_d3.a(c0_d2));
    }

    public final <T extends i> c0$d<T> A(c0$d<T> c0_d, p pVar) {
        i iVar = (i) c0_d.a.l(pVar);
        c0$d<T> c0_d2 = c0_d.f688b;
        if (c0_d2 != null) {
            c0_d = c0_d.c(A(c0_d2, pVar));
        }
        return iVar == c0_d.a ? c0_d : new c0$d<>(iVar, c0_d.f688b, c0_d.c, c0_d.d, c0_d.e, c0_d.f);
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

    public final Set<b.g.a.c.t> C(c0$d<? extends i> c0_d, Set<b.g.a.c.t> set) {
        for (c0$d c0_d2 = c0_d; c0_d2 != null; c0_d2 = c0_d2.f688b) {
            if (c0_d2.d && c0_d2.c != null) {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(c0_d2.c);
            }
        }
        return set;
    }

    public final <T extends i> p D(c0$d<T> c0_d) {
        p pVar = c0_d.a.k;
        c0$d<T> c0_d2 = c0_d.f688b;
        return c0_d2 != null ? p.c(pVar, D(c0_d2)) : pVar;
    }

    public int E(j jVar) {
        String strC = jVar.c();
        if (!strC.startsWith("get") || strC.length() <= 3) {
            return (!strC.startsWith("is") || strC.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p F(int i, c0$d<? extends i>... c0_dArr) {
        c0$d<? extends i> c0_d = c0_dArr[i];
        p pVarC = ((i) c0_d.a).k;
        c0$d<? extends i> c0_d2 = c0_d.f688b;
        if (c0_d2 != null) {
            pVarC = p.c(pVarC, D(c0_d2));
        }
        do {
            i++;
            if (i >= c0_dArr.length) {
                return pVarC;
            }
        } while (c0_dArr[i] == null);
        return p.c(pVarC, F(i, c0_dArr));
    }

    public final <T> c0$d<T> G(c0$d<T> c0_d) {
        return c0_d == null ? c0_d : c0_d.d();
    }

    public final <T> c0$d<T> H(c0$d<T> c0_d) {
        return c0_d == null ? c0_d : c0_d.f();
    }

    public int I(j jVar) {
        String strC = jVar.c();
        return (!strC.startsWith("set") || strC.length() <= 3) ? 2 : 1;
    }

    public final <T> c0$d<T> J(c0$d<T> c0_d) {
        return c0_d == null ? c0_d : c0_d.b();
    }

    public void K(c0 c0Var) {
        this.q = N(this.q, c0Var.q);
        this.r = N(this.r, c0Var.r);
        this.f687s = N(this.f687s, c0Var.f687s);
        this.t = N(this.t, c0Var.t);
    }

    public Set<b.g.a.c.t> L() {
        Set<b.g.a.c.t> setC = C(this.r, C(this.t, C(this.f687s, C(this.q, null))));
        return setC == null ? Collections.emptySet() : setC;
    }

    public <T> T M(c0$e<T> c0_e) {
        c0$d<j> c0_d;
        c0$d<g> c0_d2;
        T tA = null;
        if (this.n == null) {
            return null;
        }
        if (this.l) {
            c0$d<j> c0_d3 = this.f687s;
            if (c0_d3 != null) {
                tA = c0_e.a(c0_d3.a);
            }
        } else {
            c0$d<m> c0_d4 = this.r;
            tA = c0_d4 != null ? c0_e.a(c0_d4.a) : null;
            if (tA == null && (c0_d = this.t) != null) {
                tA = c0_e.a(c0_d.a);
            }
        }
        return (tA != null || (c0_d2 = this.q) == null) ? tA : c0_e.a(c0_d2.a);
    }

    @Override // java.lang.Comparable
    public int compareTo(c0 c0Var) {
        c0 c0Var2 = c0Var;
        if (this.r != null) {
            if (c0Var2.r == null) {
                return -1;
            }
        } else if (c0Var2.r != null) {
            return 1;
        }
        return p().compareTo(c0Var2.p());
    }

    @Override // b.g.a.c.c0.s
    public boolean f() {
        return (this.r == null && this.t == null && this.q == null) ? false : true;
    }

    @Override // b.g.a.c.c0.s
    public p$b g() {
        i iVarJ = j();
        b.g.a.c.b bVar = this.n;
        p$b p_bZ = bVar == null ? null : bVar.z(iVarJ);
        if (p_bZ != null) {
            return p_bZ;
        }
        p$b p_b = p$b.j;
        return p$b.j;
    }

    @Override // b.g.a.c.c0.s
    public b$a h() {
        b$a b_a = this.v;
        if (b_a != null) {
            if (b_a == k) {
                return null;
            }
            return b_a;
        }
        b$a b_a2 = (b$a) M(new c0$b(this));
        this.v = b_a2 == null ? k : b_a2;
        return b_a2;
    }

    @Override // b.g.a.c.c0.s
    public Class<?>[] i() {
        return (Class[]) M(new c0$a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.s
    public m k() {
        c0$d c0_d = this.r;
        if (c0_d == null) {
            return null;
        }
        do {
            T t = c0_d.a;
            if (((m) t)._owner instanceof e) {
                return (m) t;
            }
            c0_d = c0_d.f688b;
        } while (c0_d != null);
        return this.r.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.s
    public g l() {
        c0$d<g> c0_d = this.q;
        if (c0_d == null) {
            return null;
        }
        g gVar = c0_d.a;
        for (c0$d c0_d2 = c0_d.f688b; c0_d2 != null; c0_d2 = c0_d2.f688b) {
            g gVar2 = (g) c0_d2.a;
            Class<?> clsG = gVar.g();
            Class<?> clsG2 = gVar2.g();
            if (clsG != clsG2) {
                if (clsG.isAssignableFrom(clsG2)) {
                    gVar = gVar2;
                } else if (clsG2.isAssignableFrom(clsG)) {
                }
            }
            StringBuilder sbU = b.d.b.a.a.U("Multiple fields representing property \"");
            sbU.append(p());
            sbU.append("\": ");
            sbU.append(gVar.h());
            sbU.append(" vs ");
            sbU.append(gVar2.h());
            throw new IllegalArgumentException(sbU.toString());
        }
        return gVar;
    }

    @Override // b.g.a.c.c0.s
    public b.g.a.c.t m() {
        return this.o;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.s
    public j n() {
        int iE;
        int iE2;
        c0$d c0_d = this.f687s;
        if (c0_d == null) {
            return null;
        }
        c0$d c0_d2 = c0_d.f688b;
        if (c0_d2 == null) {
            return (j) c0_d.a;
        }
        while (c0_d2 != null) {
            Class<?> clsG = ((j) c0_d.a).g();
            Class<?> clsG2 = ((j) c0_d2.a).g();
            if (clsG == clsG2) {
                iE = E((j) c0_d2.a);
                iE2 = E((j) c0_d.a);
                if (iE != iE2) {
                    StringBuilder sbU = b.d.b.a.a.U("Conflicting getter definitions for property \"");
                    sbU.append(p());
                    sbU.append("\": ");
                    sbU.append(((j) c0_d.a).h());
                    sbU.append(" vs ");
                    sbU.append(((j) c0_d2.a).h());
                    throw new IllegalArgumentException(sbU.toString());
                }
                if (iE < iE2) {
                    c0_d = c0_d2;
                }
            } else if (clsG.isAssignableFrom(clsG2)) {
                c0_d = c0_d2;
            } else if (clsG2.isAssignableFrom(clsG)) {
                continue;
            } else {
                iE = E((j) c0_d2.a);
                iE2 = E((j) c0_d.a);
                if (iE != iE2) {
                    StringBuilder sbU2 = b.d.b.a.a.U("Conflicting getter definitions for property \"");
                    sbU2.append(p());
                    sbU2.append("\": ");
                    sbU2.append(((j) c0_d.a).h());
                    sbU2.append(" vs ");
                    sbU2.append(((j) c0_d2.a).h());
                    throw new IllegalArgumentException(sbU2.toString());
                }
                if (iE < iE2) {
                    c0_d = c0_d2;
                }
            }
            c0_d2 = c0_d2.f688b;
        }
        this.f687s = c0_d.e();
        return (j) c0_d.a;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0104  */
    @Override // b.g.a.c.c0.s
    public b.g.a.c.s o() {
        j jVar;
        b.g.a.c.s sVar;
        h0 h0VarA;
        boolean z2;
        Class<?> cls;
        Boolean boolM;
        if (this.u == null) {
            h0 h0VarB = null;
            if (this.l) {
                c0$d<j> c0_d = this.f687s;
                if (c0_d != null) {
                    jVar = c0_d.a;
                } else {
                    c0$d<g> c0_d2 = this.q;
                    if (c0_d2 != null) {
                        jVar = c0_d2.a;
                    } else {
                        jVar = null;
                    }
                }
            } else {
                c0$d<m> c0_d3 = this.r;
                if (c0_d3 != null) {
                    jVar = c0_d3.a;
                } else {
                    c0$d<j> c0_d4 = this.t;
                    if (c0_d4 != null) {
                        jVar = c0_d4.a;
                    } else {
                        c0$d<g> c0_d5 = this.q;
                        if (c0_d5 != null) {
                            jVar = c0_d5.a;
                        } else {
                            c0$d<j> c0_d6 = this.f687s;
                            if (c0_d6 != null) {
                                jVar = c0_d6.a;
                            } else {
                                jVar = null;
                            }
                        }
                    }
                }
            }
            if (jVar == null) {
                this.u = b.g.a.c.s.l;
            } else {
                Boolean boolA0 = this.n.a0(jVar);
                String strW = this.n.w(jVar);
                Integer numB = this.n.B(jVar);
                String strV = this.n.v(jVar);
                if (boolA0 == null && numB == null && strV == null) {
                    b.g.a.c.s sVar2 = b.g.a.c.s.l;
                    if (strW != null) {
                        sVar2 = new b.g.a.c.s(sVar2._required, strW, sVar2._index, sVar2._defaultValue, sVar2.m, sVar2._valueNulls, sVar2._contentNulls);
                    }
                    this.u = sVar2;
                } else {
                    b.g.a.c.s sVar3 = b.g.a.c.s.j;
                    if (strW != null || numB != null || strV != null) {
                        sVar = new b.g.a.c.s(boolA0, strW, numB, strV, null, null, null);
                    } else if (boolA0 == null) {
                        sVar = b.g.a.c.s.l;
                    } else {
                        sVar = boolA0.booleanValue() ? b.g.a.c.s.j : b.g.a.c.s.k;
                    }
                    this.u = sVar;
                }
                if (!this.l) {
                    b.g.a.c.s sVarA = this.u;
                    i iVarJ = j();
                    b.g.a.c.b bVar = this.n;
                    if (bVar != null) {
                        if (iVarJ == null || (boolM = bVar.m(jVar)) == null) {
                            z2 = true;
                        } else {
                            if (boolM.booleanValue()) {
                                sVarA = sVarA.a(new s$a(iVarJ, false));
                            }
                            z2 = false;
                        }
                        b.g.a.a.z$a z_aM = this.n.M(jVar);
                        if (z_aM != null) {
                            h0VarB = z_aM.b();
                            h0VarA = z_aM.a();
                        } else {
                            h0VarA = null;
                        }
                    } else {
                        h0VarA = null;
                        z2 = true;
                    }
                    if (z2 || h0VarB == null || h0VarA == null) {
                        if (jVar instanceof j) {
                            j jVar2 = (j) jVar;
                            if (jVar2.o() > 0) {
                                cls = jVar2.n(0)._class;
                            } else {
                                cls = jVar.e()._class;
                            }
                        } else {
                            cls = jVar.e()._class;
                        }
                        Objects.requireNonNull(this.m.f(cls));
                    }
                    if (z2 || h0VarB == null || h0VarA == null) {
                        b.g.a.a.z$a z_aL = this.m.l();
                        if (h0VarB == null) {
                            h0VarB = z_aL.b();
                        }
                        if (h0VarA == null) {
                            h0VarA = z_aL.a();
                        }
                        if (z2) {
                            if (Boolean.TRUE.equals(this.m.h()) && iVarJ != null) {
                                sVarA = sVarA.a(new s$a(iVarJ, true));
                            }
                        }
                    }
                    h0 h0Var = h0VarB;
                    h0 h0Var2 = h0VarA;
                    if (h0Var != null || h0Var2 != null) {
                        sVarA = new b.g.a.c.s(sVarA._required, sVarA._description, sVarA._index, sVarA._defaultValue, sVarA.m, h0Var, h0Var2);
                    }
                    this.u = sVarA;
                }
            }
        }
        return this.u;
    }

    @Override // b.g.a.c.c0.s
    public String p() {
        b.g.a.c.t tVar = this.o;
        if (tVar == null) {
            return null;
        }
        return tVar._simpleName;
    }

    @Override // b.g.a.c.c0.s
    public i q() {
        if (this.l) {
            return j();
        }
        i iVarK = k();
        if (iVarK == null && (iVarK = s()) == null) {
            iVarK = l();
        }
        return iVarK == null ? j() : iVarK;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d A[PHI: r0
      0x003d: PHI (r0v3 b.g.a.c.c0.b) = (r0v2 b.g.a.c.c0.b), (r0v5 b.g.a.c.c0.b) binds: [B:16:0x0030, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.c0.s
    public Class<?> r() {
        b.g.a.c.j jVarE;
        if (this.l) {
            b bVarN = n();
            jVarE = (bVarN == null && (bVarN = l()) == null) ? b.g.a.c.h0.n.k() : bVarN.e();
        } else {
            b bVarK = k();
            if (bVarK == null) {
                j jVarS = s();
                if (jVarS != null) {
                    jVarE = jVarS.n(0);
                } else {
                    bVarK = l();
                    if (bVarK == null) {
                        jVarE = bVarK.e();
                    } else {
                        jVarE = bVarK.e();
                    }
                }
            } else if (bVarK == null || (bVarK = n()) != null) {
                jVarE = bVarK.e();
            } else {
                jVarE = b.g.a.c.h0.n.k();
            }
        }
        return jVarE._class;
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
    @Override // b.g.a.c.c0.s
    public j s() {
        j jVar;
        j jVar2;
        int I;
        int I2;
        b.g.a.c.b bVar;
        j jVarF0;
        c0$d c0_d = this.t;
        if (c0_d == null) {
            return null;
        }
        c0$d c0_d2 = c0_d.f688b;
        if (c0_d2 == null) {
            return (j) c0_d.a;
        }
        while (c0_d2 != null) {
            Class<?> clsG = ((j) c0_d.a).g();
            Class<?> clsG2 = ((j) c0_d2.a).g();
            if (clsG == clsG2) {
                jVar = (j) c0_d2.a;
                jVar2 = (j) c0_d.a;
                I = I(jVar);
                I2 = I(jVar2);
                if (I != I2) {
                    bVar = this.n;
                    if (bVar == null) {
                        jVarF0 = bVar.f0(this.m, jVar2, jVar);
                        if (jVarF0 != jVar2) {
                            if (jVarF0 != jVar) {
                            }
                            c0_d = c0_d2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", p(), ((j) c0_d.a).h(), ((j) c0_d2.a).h()));
                }
                if (I < I2) {
                    c0_d = c0_d2;
                }
            } else if (clsG.isAssignableFrom(clsG2)) {
                c0_d = c0_d2;
            } else if (clsG2.isAssignableFrom(clsG)) {
                continue;
            } else {
                jVar = (j) c0_d2.a;
                jVar2 = (j) c0_d.a;
                I = I(jVar);
                I2 = I(jVar2);
                if (I != I2) {
                    bVar = this.n;
                    if (bVar == null) {
                        jVarF0 = bVar.f0(this.m, jVar2, jVar);
                        if (jVarF0 != jVar2) {
                            if (jVarF0 != jVar) {
                            }
                            c0_d = c0_d2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", p(), ((j) c0_d.a).h(), ((j) c0_d2.a).h()));
                }
                if (I < I2) {
                    c0_d = c0_d2;
                }
            }
            c0_d2 = c0_d2.f688b;
        }
        this.t = c0_d.e();
        return (j) c0_d.a;
    }

    @Override // b.g.a.c.c0.s
    public b.g.a.c.t t() {
        b.g.a.c.b bVar;
        if (q() == null || (bVar = this.n) == null) {
            return null;
        }
        Objects.requireNonNull(bVar);
        return null;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[Property '");
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

    @Override // b.g.a.c.c0.s
    public boolean u() {
        return x(this.q) || x(this.f687s) || x(this.t) || w(this.r);
    }

    @Override // b.g.a.c.c0.s
    public boolean v() {
        Boolean bool = (Boolean) M(new c0$c(this));
        return bool != null && bool.booleanValue();
    }

    public final <T> boolean w(c0$d<T> c0_d) {
        while (c0_d != null) {
            if (c0_d.c != null && c0_d.d) {
                return true;
            }
            c0_d = c0_d.f688b;
        }
        return false;
    }

    public final <T> boolean x(c0$d<T> c0_d) {
        while (c0_d != null) {
            b.g.a.c.t tVar = c0_d.c;
            if (tVar != null && tVar.c()) {
                return true;
            }
            c0_d = c0_d.f688b;
        }
        return false;
    }

    public final <T> boolean y(c0$d<T> c0_d) {
        while (c0_d != null) {
            if (c0_d.f) {
                return true;
            }
            c0_d = c0_d.f688b;
        }
        return false;
    }

    public final <T> boolean z(c0$d<T> c0_d) {
        while (c0_d != null) {
            if (c0_d.e) {
                return true;
            }
            c0_d = c0_d.f688b;
        }
        return false;
    }

    public c0(b.g.a.c.z.l<?> lVar, b.g.a.c.b bVar, boolean z2, b.g.a.c.t tVar, b.g.a.c.t tVar2) {
        this.m = lVar;
        this.n = bVar;
        this.p = tVar;
        this.o = tVar2;
        this.l = z2;
    }

    public c0(c0 c0Var, b.g.a.c.t tVar) {
        this.m = c0Var.m;
        this.n = c0Var.n;
        this.p = c0Var.p;
        this.o = tVar;
        this.q = c0Var.q;
        this.r = c0Var.r;
        this.f687s = c0Var.f687s;
        this.t = c0Var.t;
        this.l = c0Var.l;
    }
}
