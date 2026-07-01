package j0.o;

import j0.k.Func1;
import java.util.Objects;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements Func1<Throwable, Throwable> {
    @Override // j0.k.Func1
    public Throwable call(Throwable th) {
        Throwable th2 = th;
        Objects.requireNonNull(RxJavaPlugins.a.c());
        return th2;
    }
}
