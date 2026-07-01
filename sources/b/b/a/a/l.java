package b.b.a.a;

import com.lytefast.flexinput.fragment.FlexInputFragment;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FlexInputFragment flexInputFragment) {
        super(0);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.showExpressionKeyboardSubscription = Observable.d0(300L, TimeUnit.MILLISECONDS).J(j0.j.b.a.a()).V(new l$a(this));
    }
}
