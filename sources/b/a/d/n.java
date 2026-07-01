package b.a.d;

import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import rx.Observable;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n<T, R> implements Observable.c<T, T> {
    public static final n j = new n();

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        return ObservableExtensionsKt.computationBuffered(observable).r();
    }
}
