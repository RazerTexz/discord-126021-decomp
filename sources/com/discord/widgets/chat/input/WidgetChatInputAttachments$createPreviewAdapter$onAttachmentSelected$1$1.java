package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ SelectionAggregator $aggregator;
    public final /* synthetic */ Attachment $attachment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1(SelectionAggregator selectionAggregator, Attachment attachment) {
        super(0);
        this.$aggregator = selectionAggregator;
        this.$attachment = attachment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$aggregator.unselectItem(this.$attachment);
    }
}
