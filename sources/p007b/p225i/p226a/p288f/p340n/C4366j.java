package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: b.i.a.f.n.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4366j implements InterfaceC4365i {

    /* JADX INFO: renamed from: a */
    public final Object f11482a = new Object();

    /* JADX INFO: renamed from: b */
    public final int f11483b;

    /* JADX INFO: renamed from: c */
    public final C4358c0<Void> f11484c;

    /* JADX INFO: renamed from: d */
    public int f11485d;

    /* JADX INFO: renamed from: e */
    public int f11486e;

    /* JADX INFO: renamed from: f */
    public int f11487f;

    /* JADX INFO: renamed from: g */
    public Exception f11488g;

    /* JADX INFO: renamed from: h */
    public boolean f11489h;

    public C4366j(int i, C4358c0<Void> c4358c0) {
        this.f11483b = i;
        this.f11484c = c4358c0;
    }

    /* JADX INFO: renamed from: a */
    public final void m6029a() {
        int i = this.f11485d;
        int i2 = this.f11486e;
        int i3 = this.f11487f;
        int i4 = this.f11483b;
        if (i + i2 + i3 == i4) {
            if (this.f11488g == null) {
                if (this.f11489h) {
                    this.f11484c.m6026u();
                    return;
                } else {
                    this.f11484c.m6024s(null);
                    return;
                }
            }
            C4358c0<Void> c4358c0 = this.f11484c;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i2);
            sb.append(" out of ");
            sb.append(i4);
            sb.append(" underlying tasks failed");
            c4358c0.m6025t(new ExecutionException(sb.toString(), this.f11488g));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4355b
    /* JADX INFO: renamed from: b */
    public final void mo6005b() {
        synchronized (this.f11482a) {
            this.f11487f++;
            this.f11489h = true;
            m6029a();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
    public final void onFailure(@NonNull Exception exc) {
        synchronized (this.f11482a) {
            this.f11486e++;
            this.f11488g = exc;
            m6029a();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public final void onSuccess(Object obj) {
        synchronized (this.f11482a) {
            this.f11485d++;
            m6029a();
        }
    }
}
