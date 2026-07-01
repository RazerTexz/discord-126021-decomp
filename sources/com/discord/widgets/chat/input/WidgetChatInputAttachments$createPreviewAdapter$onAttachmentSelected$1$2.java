package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ SelectionAggregator $aggregator;
    public final /* synthetic */ Attachment $attachment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2(Attachment attachment, SelectionAggregator selectionAggregator) {
        super(1);
        this.$attachment = attachment;
        this.$aggregator = selectionAggregator;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        this.$attachment.setSpoiler(z2);
        this.$aggregator.getAdapter().notifyDataSetChanged();
    }
}
