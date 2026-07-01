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
import rx.functions.Action1;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w<T, R> implements Observable.c<T, T> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ Class k;
    public final /* synthetic */ Action1 l;
    public final /* synthetic */ Action1 m;
    public final /* synthetic */ Action1 n;

    public w(Context context, Class cls, Action1 action1, Action1 action2, Action1 action3) {
        this.j = context;
        this.k = cls;
        this.l = action1;
        this.m = action2;
        this.n = action3;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        Context context = this.j;
        String simpleName = this.k.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        Action1 action1 = this.l;
        c0 c0Var = action1 != null ? new c0(action1) : null;
        u uVar = new u(this.m);
        Action1 action2 = this.n;
        ObservableExtensionsKt.appSubscribe(observable, (117 & 1) != 0 ? null : context, simpleName, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : c0Var), uVar, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : action2 != null ? new c0(action2) : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : v.j), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        return null;
    }
}
