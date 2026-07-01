package j0.o;

import j0.k.Func1;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements Func1<Observable.b, Observable.b> {
    @Override // j0.k.Func1
    public Observable.b call(Observable.b bVar) {
        Observable.b bVar2 = bVar;
        Objects.requireNonNull(RxJavaPlugins.a.c());
        return bVar2;
    }
}
