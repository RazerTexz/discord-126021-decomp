package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$1$1<T> extends SelectionAggregator<T> {
    public final /* synthetic */ AttachmentPreviewAdapter $previewAdapter;
    public final /* synthetic */ WidgetChatInputAttachments$createPreviewAdapter$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$1$1(WidgetChatInputAttachments$createPreviewAdapter$1 widgetChatInputAttachments$createPreviewAdapter$1, AttachmentPreviewAdapter attachmentPreviewAdapter, AttachmentPreviewAdapter attachmentPreviewAdapter2) {
        super(attachmentPreviewAdapter2, null, null, null, 14, null);
        this.this$0 = widgetChatInputAttachments$createPreviewAdapter$1;
        this.$previewAdapter = attachmentPreviewAdapter;
    }

    public static final /* synthetic */ void access$track(WidgetChatInputAttachments$createPreviewAdapter$1$1 widgetChatInputAttachments$createPreviewAdapter$1$1, Attachment attachment) {
        widgetChatInputAttachments$createPreviewAdapter$1$1.track(attachment);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    private final void track(Attachment attachment) {
        String source = attachment instanceof SourcedAttachment ? ((SourcedAttachment) attachment).getSource() : AnalyticsTracker.ATTACHMENT_SOURCE_PICKER;
        try {
            int size = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0.this$0).b().getSize();
            Context context = this.this$0.$context;
            AnalyticsTracker.addAttachment(source, AttachmentUtilsKt.getMimeType(attachment, context != null ? context.getContentResolver() : null), size);
        } catch (Throwable th) {
            AppLog.g.i("Analytic error on attachment update", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lytefast.flexinput.utils.SelectionAggregator
    public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
        m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        super.registerSelectionCoordinatorInternal(selectionCoordinator);
        WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1 widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1 = new WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1(this, selectionCoordinator.itemSelectionListener);
        m.checkNotNullParameter(widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1, "<set-?>");
        selectionCoordinator.itemSelectionListener = widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1;
    }
}
