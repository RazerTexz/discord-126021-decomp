package b.a.d;

import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a0<T, R> implements Observable.c<T, R> {
    public final /* synthetic */ Function1 j;
    public final /* synthetic */ Function1 k;
    public final /* synthetic */ Function1 l;

    public a0(Function1 function1, Function1 function2, Function1 function3) {
        this.j = function1;
        this.k = function2;
        this.l = function3;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        return ((Observable) obj).Y(new z(this));
    }
}
