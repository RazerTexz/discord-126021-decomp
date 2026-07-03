package p007b.p076b.p077a.p078a;

import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.m */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1425m implements SelectionCoordinator.ItemSelectionListener<Attachment<? extends Object>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FlexInputFragment f2137a;

    public C1425m(FlexInputFragment flexInputFragment) {
        this.f2137a = flexInputFragment;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public void onItemSelected(Attachment<? extends Object> attachment) {
        Attachment<? extends Object> attachment2 = attachment;
        C12238m.checkNotNullParameter(attachment2, "item");
        FlexInputViewModel flexInputViewModel = this.f2137a.viewModel;
        if (flexInputViewModel == null || !flexInputViewModel.isSingleSelectMode()) {
            FlexInputFragment flexInputFragment = this.f2137a;
            FlexInputViewModel flexInputViewModel2 = flexInputFragment.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(flexInputFragment.mo396b().getAttachments());
                return;
            }
            return;
        }
        FlexInputViewModel flexInputViewModel3 = this.f2137a.viewModel;
        if (flexInputViewModel3 != null) {
            flexInputViewModel3.onSingleAttachmentSelected(attachment2);
        }
        FlexInputViewModel flexInputViewModel4 = this.f2137a.viewModel;
        if (flexInputViewModel4 != null) {
            flexInputViewModel4.onContentDialogDismissed(true);
        }
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public void onItemUnselected(Attachment<? extends Object> attachment) {
        C12238m.checkNotNullParameter(attachment, "item");
        FlexInputFragment flexInputFragment = this.f2137a;
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(flexInputFragment.mo396b().getAttachments());
        }
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public void unregister() {
    }
}
