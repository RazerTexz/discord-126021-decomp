package j0.o;

import j0.k.Func1;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Func1<Observable.a, Observable.a> {
    @Override // j0.k.Func1
    public Observable.a call(Observable.a aVar) {
        Observable.a aVar2 = aVar;
        Objects.requireNonNull(RxJavaPlugins.a.c());
        return aVar2;
    }
}
