package b.b.a.a;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnLongClickListener {
    public final /* synthetic */ FlexInputFragment j;

    public i(FlexInputFragment flexInputFragment) {
        this.j = flexInputFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        FlexInputViewModel flexInputViewModel = this.j.viewModel;
        if (flexInputViewModel == null) {
            return false;
        }
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        return flexInputViewModel.onToolTipButtonLongPressed(view);
    }
}
