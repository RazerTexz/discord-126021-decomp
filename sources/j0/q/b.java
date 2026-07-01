package j0.q;

import rx.functions.Action0;

/* JADX INFO: compiled from: SubjectSubscriptionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Action0 {
    public final /* synthetic */ c$b j;
    public final /* synthetic */ c k;

    public b(c cVar, c$b c_b) {
        this.k = cVar;
        this.j = c_b;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.a(this.j);
    }
}
