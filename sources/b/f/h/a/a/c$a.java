package b.f.h.a.a;

/* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class c$a implements Runnable {
    public final /* synthetic */ c j;

    public c$a(c cVar) {
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.j) {
            c cVar = this.j;
            cVar.d = false;
            if (cVar.f525b.now() - cVar.e > 2000) {
                c$b c_b = this.j.f;
                if (c_b != null) {
                    c_b.c();
                }
            } else {
                this.j.c();
            }
        }
    }
}
