package j0.l.c;

import rx.functions.Action0;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a$a implements Action0 {
    public final /* synthetic */ j0.r.b j;
    public final /* synthetic */ c$a k;

    public c$a$a(c$a c_a, j0.r.b bVar) {
        this.k = c_a;
        this.j = bVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.k.c(this.j);
    }
}
