package b.b.a.a;

import android.content.DialogInterface;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements DialogInterface.OnDismissListener {
    public final /* synthetic */ FlexInputFragment j;

    public g(FlexInputFragment flexInputFragment) {
        this.j = flexInputFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        FlexInputViewModel flexInputViewModel;
        if (!this.j.isAdded() || this.j.isHidden() || (flexInputViewModel = this.j.viewModel) == null) {
            return;
        }
        b.i.a.f.e.o.f.O0(flexInputViewModel, false, 1, null);
    }
}
