package b.f.j.p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0$b extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
    public final z0 c;
    public final x0 d;
    public final b.f.j.q.b e;
    public boolean f;
    public CloseableReference<b.f.j.j.c> g;
    public int h;
    public boolean i;
    public boolean j;
    public final /* synthetic */ t0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0$b(t0 t0Var, l<CloseableReference<b.f.j.j.c>> lVar, z0 z0Var, b.f.j.q.b bVar, x0 x0Var) {
        super(lVar);
        this.k = t0Var;
        this.g = null;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.c = z0Var;
        this.e = bVar;
        this.d = x0Var;
        x0Var.f(new t0$b$a(this, t0Var));
    }

    public static void n(t0$b t0_b, CloseableReference closeableReference, int i) {
        Objects.requireNonNull(t0_b);
        b.c.a.a0.d.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
        if (!(((b.f.j.j.c) closeableReference.u()) instanceof b.f.j.j.d)) {
            t0_b.q(closeableReference, i);
            return;
        }
        t0_b.c.e(t0_b.d, "PostprocessorProducer");
        CloseableReference<b.f.j.j.c> closeableReferenceR = null;
        try {
            try {
                closeableReferenceR = t0_b.r((b.f.j.j.c) closeableReference.u());
                z0 z0Var = t0_b.c;
                x0 x0Var = t0_b.d;
                z0Var.j(x0Var, "PostprocessorProducer", t0_b.p(z0Var, x0Var, t0_b.e));
                t0_b.q(closeableReferenceR, i);
                if (closeableReferenceR != null) {
                    closeableReferenceR.close();
                }
            } catch (Exception e) {
                z0 z0Var2 = t0_b.c;
                x0 x0Var2 = t0_b.d;
                z0Var2.k(x0Var2, "PostprocessorProducer", e, t0_b.p(z0Var2, x0Var2, t0_b.e));
                if (t0_b.o()) {
                    t0_b.f632b.c(e);
                }
            }
        } catch (Throwable th) {
            if (closeableReferenceR != null) {
                closeableReferenceR.close();
            }
            throw th;
        }
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void g() {
        if (o()) {
            this.f632b.d();
        }
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void h(Throwable th) {
        if (o()) {
            this.f632b.c(th);
        }
    }

    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        CloseableReference closeableReference = (CloseableReference) obj;
        if (!CloseableReference.y(closeableReference)) {
            if (b.e(i)) {
                q(null, i);
                return;
            }
            return;
        }
        synchronized (this) {
            if (!this.f) {
                CloseableReference<b.f.j.j.c> closeableReference2 = this.g;
                this.g = CloseableReference.n(closeableReference);
                this.h = i;
                this.i = true;
                boolean zS = s();
                if (closeableReference2 != null) {
                    closeableReference2.close();
                }
                if (zS) {
                    this.k.c.execute(new u0(this));
                }
            }
        }
    }

    public final boolean o() {
        synchronized (this) {
            if (this.f) {
                return false;
            }
            CloseableReference<b.f.j.j.c> closeableReference = this.g;
            this.g = null;
            this.f = true;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference != null) {
                closeableReference.close();
            }
            return true;
        }
    }

    public final Map<String, String> p(z0 z0Var, x0 x0Var, b.f.j.q.b bVar) {
        if (z0Var.g(x0Var, "PostprocessorProducer")) {
            return b.f.d.d.f.of("Postprocessor", bVar.getName());
        }
        return null;
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final void q(com.facebook.common.references.CloseableReference<b.f.j.j.c> r3, int r4) {
        /*
            r2 = this;
            boolean r0 = b.f.j.p.b.e(r4)
            if (r0 != 0) goto L10
            monitor-enter(r2)
            boolean r1 = r2.f     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r2)
            if (r1 == 0) goto L18
            goto L10
        Ld:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L10:
            if (r0 == 0) goto L1d
            boolean r0 = r2.o()
            if (r0 == 0) goto L1d
        L18:
            b.f.j.p.l<O> r0 = r2.f632b
            r0.b(r3, r4)
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.t0$b.q(com.facebook.common.references.CloseableReference, int):void");
    }

    public final CloseableReference<b.f.j.j.c> r(b.f.j.j.c cVar) {
        b.f.j.j.d dVar = (b.f.j.j.d) cVar;
        CloseableReference<Bitmap> closeableReferenceProcess = this.e.process(dVar.m, this.k.f639b);
        try {
            b.f.j.j.d dVar2 = new b.f.j.j.d(closeableReferenceProcess, cVar.b(), dVar.o, dVar.p);
            dVar2.e(dVar.k);
            return CloseableReference.A(dVar2);
        } finally {
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReferenceProcess != null) {
                closeableReferenceProcess.close();
            }
        }
    }

    public final synchronized boolean s() {
        if (this.f || !this.i || this.j || !CloseableReference.y(this.g)) {
            return false;
        }
        this.j = true;
        return true;
    }
}
