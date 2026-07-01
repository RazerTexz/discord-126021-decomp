package com.discord.widgets.chat.list.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 implements TextWatcher {
    public final /* synthetic */ StoreThreadDraft$ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = storeThreadDraft$ThreadDraftState;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        boolean z2;
        StoreThreadDraft storeThreadDraft = this.$storeThreadDraft$inlined;
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = this.$draftState$inlined;
        String string = s2 != null ? s2.toString() : null;
        if (this.$draftState$inlined.getShouldDisplayNameError() && s2 != null) {
            z2 = s2.length() == 0;
        }
        storeThreadDraft.setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(storeThreadDraft$ThreadDraftState, false, null, string, false, z2, 11, null));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
