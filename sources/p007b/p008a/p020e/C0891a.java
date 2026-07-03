package p007b.p008a.p020e;

import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.e.a */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0891a extends C12236k implements Function1<Boolean, Unit> {
    public C0891a(C0894d c0894d) {
        super(1, c0894d, C0894d.class, "emit", "emit(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C0894d c0894d = (C0894d) this.receiver;
        boolean z2 = C0894d.f597a;
        Objects.requireNonNull(c0894d);
        C0894d.f597a = zBooleanValue;
        Subscription subscription = C0894d.f599c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        C0894d.f598b.onNext(Boolean.valueOf(zBooleanValue));
        return Unit.f27425a;
    }
}
