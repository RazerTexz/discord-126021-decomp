package p007b.p008a.p018d;

import com.discord.utilities.p501rx.ObservableExtensionsKt;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.n */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0878n<T, R> implements Observable.InterfaceC13007c<T, T> {

    /* JADX INFO: renamed from: j */
    public static final C0878n f565j = new C0878n();

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        C12238m.checkNotNullExpressionValue(observable, "observable");
        return ObservableExtensionsKt.computationBuffered(observable).m11112r();
    }
}
