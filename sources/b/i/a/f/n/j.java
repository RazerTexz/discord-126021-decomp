package b.i.a.f.n;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements i {
    public final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1594b;
    public final c0<Void> c;
    public int d;
    public int e;
    public int f;
    public Exception g;
    public boolean h;

    public j(int i, c0<Void> c0Var) {
        this.f1594b = i;
        this.c = c0Var;
    }

    public final void a() {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = this.f1594b;
        if (i + i2 + i3 == i4) {
            if (this.g == null) {
                if (this.h) {
                    this.c.u();
                    return;
                } else {
                    this.c.s(null);
                    return;
                }
            }
            c0<Void> c0Var = this.c;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i2);
            sb.append(" out of ");
            sb.append(i4);
            sb.append(" underlying tasks failed");
            c0Var.t(new ExecutionException(sb.toString(), this.g));
        }
    }

    @Override // b.i.a.f.n.b
    public final void b() {
        synchronized (this.a) {
            this.f++;
            this.h = true;
            a();
        }
    }

    @Override // b.i.a.f.n.d
    public final void onFailure(@NonNull Exception exc) {
        synchronized (this.a) {
            this.e++;
            this.g = exc;
            a();
        }
    }

    @Override // b.i.a.f.n.e
    public final void onSuccess(Object obj) {
        synchronized (this.a) {
            this.d++;
            a();
        }
    }
}
