package b.f.j.p;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0$c extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> implements b.f.j.q.d {
    public boolean c;
    public CloseableReference<b.f.j.j.c> d;

    public t0$c(t0 t0Var, t0$b t0_b, b.f.j.q.c cVar, x0 x0Var, t0$a t0_a) {
        super(t0_b);
        this.c = false;
        this.d = null;
        cVar.a(this);
        x0Var.f(new v0(this, t0Var));
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void g() {
        if (n()) {
            this.f632b.d();
        }
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void h(Throwable th) {
        if (n()) {
            this.f632b.c(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        CloseableReference closeableReference = (CloseableReference) obj;
        if (b.f(i)) {
            return;
        }
        synchronized (this) {
            if (!this.c) {
                CloseableReference<b.f.j.j.c> closeableReference2 = this.d;
                this.d = CloseableReference.n(closeableReference);
                if (closeableReference2 != null) {
                    closeableReference2.close();
                }
            }
        }
        synchronized (this) {
            if (!this.c) {
                CloseableReference closeableReferenceN = CloseableReference.n(this.d);
                try {
                    this.f632b.b((O) closeableReferenceN, 0);
                } finally {
                    if (closeableReferenceN != null) {
                        closeableReferenceN.close();
                    }
                }
            }
        }
    }

    public final boolean n() {
        synchronized (this) {
            if (this.c) {
                return false;
            }
            CloseableReference<b.f.j.j.c> closeableReference = this.d;
            this.d = null;
            this.c = true;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference != null) {
                closeableReference.close();
            }
            return true;
        }
    }
}
