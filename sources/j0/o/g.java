package j0.o;

import java.util.Objects;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Func2<Observable, Observable.a, Observable.a> {
    @Override // rx.functions.Func2
    public Observable.a call(Observable observable, Observable.a aVar) {
        Observable.a aVar2 = aVar;
        Objects.requireNonNull(RxJavaPlugins.a.c());
        return aVar2;
    }
}
