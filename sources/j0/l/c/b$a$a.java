package j0.l.c;

import rx.functions.Action0;

/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a$a implements Action0 {
    public final /* synthetic */ Action0 j;
    public final /* synthetic */ b$a k;

    public b$a$a(b$a b_a, Action0 action0) {
        this.k = b_a;
        this.j = action0;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.k.l.k) {
            return;
        }
        this.j.call();
    }
}
