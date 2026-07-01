package j0;

import j0.k.Func1;
import j0.o.l;
import rx.functions.Action1;

/* JADX INFO: renamed from: j0.h, reason: use source file name */
/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes3.dex */
public class Single2<T> {
    public final a<T> a;

    /* JADX INFO: renamed from: j0.h$a */
    /* JADX INFO: compiled from: Single.java */
    public interface a<T> extends Action1<SingleSubscriber<? super T>> {
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=j0.h$a<T>, code=j0.h$a, for r2v0, types: [j0.h$a<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Single2(a aVar) {
        Func1<a, a> func1 = l.c;
        this.a = func1 != null ? func1.call(aVar) : aVar;
    }
}
