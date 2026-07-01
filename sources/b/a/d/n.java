package b.a.d;

import com.discord.utilities.rx.ObservableExtensionsKt;
import rx.Observable;
import rx.Observable$c;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n<T, R> implements Observable$c<T, T> {
    public static final n j = new n();

    @Override // j0.k.b
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        d0.z.d.m.checkNotNullExpressionValue(observable, "observable");
        return ObservableExtensionsKt.computationBuffered(observable).r();
    }
}
