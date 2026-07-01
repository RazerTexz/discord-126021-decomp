package b.a.d;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class y<T, R> implements Observable.c<T, T> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Function1 l;
    public final /* synthetic */ Function1 m;
    public final /* synthetic */ Function1 n;
    public final /* synthetic */ Function0 o;

    public y(Context context, String str, Function1 function1, Function1 function2, Function1 function3, Function0 function0) {
        this.j = context;
        this.k = str;
        this.l = function1;
        this.m = function2;
        this.n = function3;
        this.o = function0;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        Context context = this.j;
        String str = this.k;
        Function1 function1 = this.l;
        Function1 function2 = this.m;
        Function1 function3 = this.n;
        Function0 function0 = this.o;
        if (function0 == null) {
            function0 = x.j;
        }
        ObservableExtensionsKt.appSubscribe(observable, (117 & 1) != 0 ? null : context, str, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : function1), function2, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : function3), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : function0), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        return null;
    }
}
