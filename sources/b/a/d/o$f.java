package b.a.d;

import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o$f<T> extends d0.z.d.k implements Function1<T, Unit> {
    public o$f(Action1 action1) {
        super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Object obj) {
        ((Action1) this.receiver).call(obj);
        return Unit.a;
    }
}
