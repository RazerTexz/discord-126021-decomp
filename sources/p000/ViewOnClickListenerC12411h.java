package p000;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: renamed from: h */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12411h implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f26139j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f26140k;

    public ViewOnClickListenerC12411h(int i, Object obj) {
        this.f26139j = i;
        this.f26140k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f26139j;
        if (i == 0) {
            FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.f26140k).viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.onExpressionTrayButtonClicked();
                return;
            }
            return;
        }
        if (i == 1) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.f26140k;
            FlexInputViewModel flexInputViewModel2 = flexInputFragment.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onSendButtonClicked(flexInputFragment.inputListener);
                return;
            }
            return;
        }
        if (i == 2) {
            FlexInputViewModel flexInputViewModel3 = ((FlexInputFragment) this.f26140k).viewModel;
            if (flexInputViewModel3 != null) {
                flexInputViewModel3.onGalleryButtonClicked();
                return;
            }
            return;
        }
        if (i == 3) {
            FlexInputViewModel flexInputViewModel4 = ((FlexInputFragment) this.f26140k).viewModel;
            if (flexInputViewModel4 != null) {
                flexInputViewModel4.onGiftButtonClicked();
                return;
            }
            return;
        }
        if (i != 4) {
            throw null;
        }
        FlexInputViewModel flexInputViewModel5 = ((FlexInputFragment) this.f26140k).viewModel;
        if (flexInputViewModel5 != null) {
            flexInputViewModel5.onExpandButtonClicked();
        }
    }
}
