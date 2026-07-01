package b.a.d;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Observable$c;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$d<T, R> implements Observable$c<T, T> {
    public final /* synthetic */ Function1 j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ long l;
    public final /* synthetic */ TimeUnit m;

    public o$d(Function1 function1, Object obj, long j, TimeUnit timeUnit) {
        this.j = function1;
        this.k = obj;
        this.l = j;
        this.m = timeUnit;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        return ((Observable) obj).Y(new t(this));
    }
}
