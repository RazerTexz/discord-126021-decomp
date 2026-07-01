package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public class x1$a$a$a implements Action0 {
    public final /* synthetic */ long j;
    public final /* synthetic */ x1$a$a k;

    public x1$a$a$a(x1$a$a x1_a_a, long j) {
        this.k = x1_a_a;
        this.j = j;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.j.j(this.j);
    }
}
