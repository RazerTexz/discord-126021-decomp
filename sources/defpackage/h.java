package defpackage;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public h(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.onExpressionTrayButtonClicked();
                return;
            }
            return;
        }
        if (i == 1) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.k;
            FlexInputViewModel flexInputViewModel2 = flexInputFragment.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onSendButtonClicked(flexInputFragment.inputListener);
                return;
            }
            return;
        }
        if (i == 2) {
            FlexInputViewModel flexInputViewModel3 = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel3 != null) {
                flexInputViewModel3.onGalleryButtonClicked();
                return;
            }
            return;
        }
        if (i == 3) {
            FlexInputViewModel flexInputViewModel4 = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel4 != null) {
                flexInputViewModel4.onGiftButtonClicked();
                return;
            }
            return;
        }
        if (i != 4) {
            throw null;
        }
        FlexInputViewModel flexInputViewModel5 = ((FlexInputFragment) this.k).viewModel;
        if (flexInputViewModel5 != null) {
            flexInputViewModel5.onExpandButtonClicked();
        }
    }
}
