package i0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends d0.z.d.o implements Function1<Throwable, Unit> {
    public final /* synthetic */ d $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(d dVar) {
        super(1);
        this.$this_await$inlined = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_await$inlined.cancel();
        return Unit.a;
    }
}
