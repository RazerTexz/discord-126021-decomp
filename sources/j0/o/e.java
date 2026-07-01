package j0.o;

import j0.Completable3;
import j0.k.Func1;
import java.util.Objects;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Func1<Completable3.a, Completable3.a> {
    @Override // j0.k.Func1
    public Completable3.a call(Completable3.a aVar) {
        Completable3.a aVar2 = aVar;
        Objects.requireNonNull(RxJavaPlugins.a.a());
        return aVar2;
    }
}
