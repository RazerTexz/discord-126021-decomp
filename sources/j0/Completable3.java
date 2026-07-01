package j0;

import j0.k.Func1;
import j0.o.l;
import rx.functions.Action1;

/* JADX INFO: renamed from: j0.d, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class Completable3 {
    public final a a;

    /* JADX INFO: renamed from: j0.d$a */
    /* JADX INFO: compiled from: Completable.java */
    public interface a extends Action1<CompletableSubscriber> {
    }

    public Completable3(a aVar) {
        Func1<a, a> func1 = l.d;
        this.a = func1 != null ? func1.call(aVar) : aVar;
    }
}
