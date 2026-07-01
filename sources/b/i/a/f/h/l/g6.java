package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g6<T> implements q6<T> {
    public final c6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d7<?, ?> f1444b;
    public final boolean c;
    public final j4<?> d;

    public g6(d7<?, ?> d7Var, j4<?> j4Var, c6 c6Var) {
        this.f1444b = d7Var;
        this.c = j4Var.e(c6Var);
        this.d = j4Var;
        this.a = c6Var;
    }

    @Override // b.i.a.f.h.l.q6
    public final T a() {
        return (T) ((u4$b) this.a.h()).o();
    }

    @Override // b.i.a.f.h.l.q6
    public final int b(T t) {
        int iHashCode = this.f1444b.e(t).hashCode();
        return this.c ? (iHashCode * 53) + this.d.b(t).hashCode() : iHashCode;
    }

    @Override // b.i.a.f.h.l.q6
    public final boolean c(T t) {
        return this.d.b(t).m();
    }

    @Override // b.i.a.f.h.l.q6
    public final void d(T t) {
        this.f1444b.h(t);
        this.d.g(t);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.i.a.f.h.l.q6
    public final int e(T t) {
        d7<?, ?> d7Var = this.f1444b;
        int i = d7Var.i(d7Var.e(t)) + 0;
        if (!this.c) {
            return i;
        }
        n4<T> n4VarB = this.d.b(t);
        int iK = 0;
        for (int i2 = 0; i2 < n4VarB.f1461b.e(); i2++) {
            iK += n4.k(n4VarB.f1461b.d(i2));
        }
        Iterator<T> it = n4VarB.f1461b.g().iterator();
        while (it.hasNext()) {
            iK += n4.k((Map$Entry) it.next());
        }
        return i + iK;
    }

    @Override // b.i.a.f.h.l.q6
    public final boolean f(T t, T t2) {
        if (!this.f1444b.e(t).equals(this.f1444b.e(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(t).equals(this.d.b(t2));
        }
        return true;
    }

    @Override // b.i.a.f.h.l.q6
    public final void g(T t, v7 v7Var) throws IOException {
        Iterator itL = this.d.b(t).l();
        while (itL.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) itL.next();
            p4 p4Var = (p4) map$Entry.getKey();
            if (p4Var.c() != w7.MESSAGE || p4Var.d() || p4Var.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (map$Entry instanceof f5) {
                ((g4) v7Var).c(p4Var.a(), ((f5) map$Entry).j.getValue().c());
            } else {
                ((g4) v7Var).c(p4Var.a(), map$Entry.getValue());
            }
        }
        d7<?, ?> d7Var = this.f1444b;
        d7Var.f(d7Var.e(t), v7Var);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095 A[EDGE_INSN: B:56:0x0095->B:34:0x0095 BREAK  A[LOOP:1: B:18:0x0050->B:61:0x0050], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.l.q6
    public final void h(T t, byte[] bArr, int i, int i2, s3 s3Var) throws IOException {
        u4 u4Var = (u4) t;
        c7 c7VarC = u4Var.zzb;
        if (c7VarC == c7.a) {
            c7VarC = c7.c();
            u4Var.zzb = c7VarC;
        }
        ((u4$d) t).u();
        u4$f u4_f = null;
        while (i < i2) {
            int iO1 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
            int i3 = s3Var.a;
            if (i3 == 11) {
                int i4 = 0;
                t3 t3Var = null;
                while (iO1 < i2) {
                    iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i5 = s3Var.a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iO1 = b.i.a.f.e.o.f.G1(i5, bArr, iO1, i2, s3Var);
                        } else {
                            iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                            i4 = s3Var.a;
                            u4_f = (u4$f) this.d.c(s3Var.d, this.a, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (u4_f != null) {
                                n6 n6Var = n6.a;
                                throw new NoSuchMethodError();
                            }
                            if (i7 == 2) {
                                iO1 = b.i.a.f.e.o.f.v2(bArr, iO1, s3Var);
                                t3Var = (t3) s3Var.c;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iO1 = b.i.a.f.e.o.f.G1(i5, bArr, iO1, i2, s3Var);
                        }
                    }
                }
                if (t3Var != null) {
                    c7VarC.a((i4 << 3) | 2, t3Var);
                }
                i = iO1;
            } else if ((i3 & 7) == 2) {
                u4_f = (u4$f) this.d.c(s3Var.d, this.a, i3 >>> 3);
                if (u4_f != null) {
                    n6 n6Var2 = n6.a;
                    throw new NoSuchMethodError();
                }
                i = b.i.a.f.e.o.f.I1(i3, bArr, iO1, i2, c7VarC, s3Var);
            } else {
                i = b.i.a.f.e.o.f.G1(i3, bArr, iO1, i2, s3Var);
            }
        }
        if (i != i2) {
            throw zzij.d();
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final void i(T t, T t2) {
        d7<?, ?> d7Var = this.f1444b;
        Class<?> cls = s6.a;
        d7Var.d(t, d7Var.g(d7Var.e(t), d7Var.e(t2)));
        if (this.c) {
            s6.i(this.d, t, t2);
        }
    }
}
