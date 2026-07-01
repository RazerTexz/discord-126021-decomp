package com.discord.widgets.chat.input.autocomplete;

import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$1 implements FlexInputAttachmentListener {
    public final /* synthetic */ InputAutocomplete this$0;

    public InputAutocomplete$1(InputAutocomplete inputAutocomplete) {
        this.this$0 = inputAutocomplete;
    }

    @Override // com.lytefast.flexinput.FlexInputAttachmentListener
    public void onAttachmentSelected(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        InputAutocomplete.access$getViewModel$p(this.this$0).setAttachment(attachment);
    }
}
