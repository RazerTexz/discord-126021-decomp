package p007b.p076b.p077a.p078a;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.i */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewOnLongClickListenerC1421i implements View.OnLongClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ FlexInputFragment f2135j;

    public ViewOnLongClickListenerC1421i(FlexInputFragment flexInputFragment) {
        this.f2135j = flexInputFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        FlexInputViewModel flexInputViewModel = this.f2135j.viewModel;
        if (flexInputViewModel == null) {
            return false;
        }
        C12238m.checkNotNullExpressionValue(view, "it");
        return flexInputViewModel.onToolTipButtonLongPressed(view);
    }
}
