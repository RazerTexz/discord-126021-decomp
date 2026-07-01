package j0.o;

import j0.Single2;
import j0.k.Func1;
import java.util.Objects;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Func1<Single2.a, Single2.a> {
    @Override // j0.k.Func1
    public Single2.a call(Single2.a aVar) {
        Single2.a aVar2 = aVar;
        Objects.requireNonNull(RxJavaPlugins.a.f());
        return aVar2;
    }
}
