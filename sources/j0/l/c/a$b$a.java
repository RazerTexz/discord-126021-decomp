package j0.l.c;

import rx.functions.Action0;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$b$a implements Action0 {
    public final /* synthetic */ Action0 j;
    public final /* synthetic */ a$b k;

    public a$b$a(a$b a_b, Action0 action0) {
        this.k = a_b;
        this.j = action0;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.k.j.k) {
            return;
        }
        this.j.call();
    }
}
