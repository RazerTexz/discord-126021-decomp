package b.a.e;

import d0.z.d.FunctionReferenceImpl;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.e.a, reason: use source file name */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Backgrounded extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public Backgrounded(Backgrounded4 backgrounded4) {
        super(1, backgrounded4, Backgrounded4.class, "emit", "emit(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        Backgrounded4 backgrounded4 = (Backgrounded4) this.receiver;
        boolean z2 = Backgrounded4.a;
        Objects.requireNonNull(backgrounded4);
        Backgrounded4.a = zBooleanValue;
        Subscription subscription = Backgrounded4.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Backgrounded4.f65b.onNext(Boolean.valueOf(zBooleanValue));
        return Unit.a;
    }
}
