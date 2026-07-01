package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import b.i.c.m.d.k.h;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$Companion;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1<T> extends o implements Function2<SelectionAggregator<T>, T, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        super(2);
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((SelectionAggregator) obj, (Attachment) obj2);
        return Unit.a;
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/lytefast/flexinput/utils/SelectionAggregator<TT;>;TT;)V */
    public final void invoke(SelectionAggregator selectionAggregator, Attachment attachment) {
        m.checkNotNullParameter(selectionAggregator, "aggregator");
        m.checkNotNullParameter(attachment, "attachment");
        h.r(WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).requireContext(), WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).l());
        AttachmentBottomSheet$Companion attachmentBottomSheet$Companion = AttachmentBottomSheet.Companion;
        FragmentManager childFragmentManager = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
        AttachmentBottomSheet$Companion.show$default(attachmentBottomSheet$Companion, childFragmentManager, attachment, new WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1(selectionAggregator, attachment), new WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2(attachment, selectionAggregator), null, 16, null);
    }
}
