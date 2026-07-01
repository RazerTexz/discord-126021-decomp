package com.lytefast.flexinput.fragment;

import android.view.View;
import android.view.View$OnClickListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.n;
import d0.z.d.m;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class FlexInputFragment$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public FlexInputFragment$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.onInputTextClicked();
                return;
            }
            return;
        }
        if (i != 1) {
            throw null;
        }
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = ((FlexInputFragment) this.k).attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        attachmentPreviewAdapter.selectionAggregator.clear();
        attachmentPreviewAdapter.notifyDataSetChanged();
        FlexInputViewModel flexInputViewModel2 = ((FlexInputFragment) this.k).viewModel;
        if (flexInputViewModel2 != null) {
            flexInputViewModel2.onAttachmentsUpdated(n.emptyList());
        }
    }
}
