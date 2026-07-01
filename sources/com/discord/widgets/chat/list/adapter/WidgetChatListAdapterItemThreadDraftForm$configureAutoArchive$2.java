package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$2 implements View$OnClickListener {
    public final /* synthetic */ ThreadDraftFormEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$2(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, ThreadDraftFormEntry threadDraftFormEntry) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$data = threadDraftFormEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadDraftArchiveSheet.Companion.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(this.this$0).getFragmentManager(), this.$data.getGuildId());
    }
}
