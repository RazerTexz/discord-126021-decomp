package p007b.p008a.p018d;

import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p658rx.functions.Action1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.a.d.u */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0885u<T> extends C12236k implements Function1<T, Unit> {
    public C0885u(Action1 action1) {
        super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Object obj) {
        ((Action1) this.receiver).call(obj);
        return Unit.f27425a;
    }
}
