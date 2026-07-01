package com.discord.widgets.chat.input;

import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener;
import d0.z.d.m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1<T> implements SelectionCoordinator$ItemSelectionListener<T> {
    private final /* synthetic */ SelectionCoordinator$ItemSelectionListener<? super T> $$delegate_0;
    public final /* synthetic */ SelectionCoordinator$ItemSelectionListener $oldItemSelectionListener;
    public final /* synthetic */ WidgetChatInputAttachments$createPreviewAdapter$1$1 this$0;

    public WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1(WidgetChatInputAttachments$createPreviewAdapter$1$1 widgetChatInputAttachments$createPreviewAdapter$1$1, SelectionCoordinator$ItemSelectionListener selectionCoordinator$ItemSelectionListener) {
        this.this$0 = widgetChatInputAttachments$createPreviewAdapter$1$1;
        this.$oldItemSelectionListener = selectionCoordinator$ItemSelectionListener;
        this.$$delegate_0 = selectionCoordinator$ItemSelectionListener;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemSelected(Object obj) {
        onItemSelected((Attachment) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemUnselected(Attachment item) {
        m.checkNotNullParameter(item, "item");
        this.$$delegate_0.onItemUnselected(item);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemUnselected(Object obj) {
        onItemUnselected((Attachment) obj);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void unregister() {
        this.$$delegate_0.unregister();
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemSelected(Attachment item) {
        m.checkNotNullParameter(item, "item");
        WidgetChatInputAttachments$createPreviewAdapter$1$1.access$track(this.this$0, item);
        this.$oldItemSelectionListener.onItemSelected(item);
    }
}
