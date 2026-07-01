package j0.o;

import java.util.Objects;
import rx.functions.Action1;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Action1<Throwable> {
    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Objects.requireNonNull(o.a.b());
    }
}
