package b.b.a.a;

import android.view.View;
import android.view.View$OnLongClickListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements View$OnLongClickListener {
    public final /* synthetic */ FlexInputFragment j;

    public i(FlexInputFragment flexInputFragment) {
        this.j = flexInputFragment;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        FlexInputViewModel flexInputViewModel = this.j.viewModel;
        if (flexInputViewModel == null) {
            return false;
        }
        d0.z.d.m.checkNotNullExpressionValue(view, "it");
        return flexInputViewModel.onToolTipButtonLongPressed(view);
    }
}
