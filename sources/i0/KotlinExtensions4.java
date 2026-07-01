package i0;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: i0.n, reason: use source file name */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinExtensions4 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Call3 $this_awaitResponse$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions4(Call3 call3) {
        super(1);
        this.$this_awaitResponse$inlined = call3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_awaitResponse$inlined.cancel();
        return Unit.a;
    }
}
