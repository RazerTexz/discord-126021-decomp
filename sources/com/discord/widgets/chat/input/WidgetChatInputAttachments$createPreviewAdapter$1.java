package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$1<T> extends o implements Function1<AttachmentPreviewAdapter<T>, SelectionAggregator<T>> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$1(WidgetChatInputAttachments widgetChatInputAttachments, Context context) {
        super(1);
        this.this$0 = widgetChatInputAttachments;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((AttachmentPreviewAdapter) obj);
    }

    public final SelectionAggregator<T> invoke(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
        m.checkNotNullParameter(attachmentPreviewAdapter, "previewAdapter");
        return new WidgetChatInputAttachments$createPreviewAdapter$1$1(this, attachmentPreviewAdapter, attachmentPreviewAdapter);
    }
}
