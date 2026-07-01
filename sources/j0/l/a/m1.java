package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public class m1 implements Action0 {
    public final /* synthetic */ j1$f j;

    public m1(j1$f j1_f) {
        this.j = j1_f;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T[], java.lang.Object[]] */
    @Override // rx.functions.Action0
    public void call() {
        if (this.j.m) {
            return;
        }
        synchronized (this.j.n) {
            if (!this.j.m) {
                j1$f j1_f = this.j;
                j0.l.e.g<j1$c<T>> gVar = j1_f.n;
                gVar.f3794b = 0;
                gVar.d = new Object[0];
                j1_f.p++;
                this.j.m = true;
            }
        }
    }
}
