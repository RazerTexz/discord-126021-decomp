package b.b.a.a;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        FlexInputViewModel flexInputViewModel = this.this$0.viewModel;
        if (flexInputViewModel != null) {
            b.i.a.f.e.o.f.O0(flexInputViewModel, false, 1, null);
        }
        return Unit.a;
    }
}
