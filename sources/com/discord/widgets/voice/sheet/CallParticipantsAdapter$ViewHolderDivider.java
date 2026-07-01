package com.discord.widgets.voice.sheet;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderDivider extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderDivider(CallParticipantsAdapter callParticipantsAdapter) {
        super(R$layout.voice_user_list_item_divider, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
    }
}
