package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$2 implements View$OnClickListener {
    public final /* synthetic */ StoreThreadDraft$ThreadDraftState $draftState;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft;

    public WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$2(StoreThreadDraft storeThreadDraft, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState) {
        this.$storeThreadDraft = storeThreadDraft;
        this.$draftState = storeThreadDraft$ThreadDraftState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreThreadDraft storeThreadDraft = this.$storeThreadDraft;
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = this.$draftState;
        storeThreadDraft.setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(storeThreadDraft$ThreadDraftState, !storeThreadDraft$ThreadDraftState.isPrivate(), null, null, false, false, 30, null));
    }
}
