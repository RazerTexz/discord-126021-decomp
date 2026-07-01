package b.a.e;

import d0.z.d.k;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a extends k implements Function1<Boolean, Unit> {
    public a(d dVar) {
        super(1, dVar, d.class, "emit", "emit(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        d dVar = (d) this.receiver;
        boolean z2 = d.a;
        Objects.requireNonNull(dVar);
        d.a = zBooleanValue;
        Subscription subscription = d.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        d.f65b.onNext(Boolean.valueOf(zBooleanValue));
        return Unit.a;
    }
}
