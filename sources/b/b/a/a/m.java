package b.b.a.a;

import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements SelectionCoordinator$ItemSelectionListener<Attachment<? extends Object>> {
    public final /* synthetic */ FlexInputFragment a;

    public m(FlexInputFragment flexInputFragment) {
        this.a = flexInputFragment;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemSelected(Attachment<? extends Object> attachment) {
        Attachment<? extends Object> attachment2 = attachment;
        d0.z.d.m.checkNotNullParameter(attachment2, "item");
        FlexInputViewModel flexInputViewModel = this.a.viewModel;
        if (flexInputViewModel == null || !flexInputViewModel.isSingleSelectMode()) {
            FlexInputFragment flexInputFragment = this.a;
            FlexInputViewModel flexInputViewModel2 = flexInputFragment.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(flexInputFragment.b().getAttachments());
                return;
            }
            return;
        }
        FlexInputViewModel flexInputViewModel3 = this.a.viewModel;
        if (flexInputViewModel3 != null) {
            flexInputViewModel3.onSingleAttachmentSelected(attachment2);
        }
        FlexInputViewModel flexInputViewModel4 = this.a.viewModel;
        if (flexInputViewModel4 != null) {
            flexInputViewModel4.onContentDialogDismissed(true);
        }
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemUnselected(Attachment<? extends Object> attachment) {
        d0.z.d.m.checkNotNullParameter(attachment, "item");
        FlexInputFragment flexInputFragment = this.a;
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(flexInputFragment.b().getAttachments());
        }
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void unregister() {
    }
}
