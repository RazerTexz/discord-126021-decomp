package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMessageReactions().deleteEmoji(((ManageReactionsResultsAdapter$ReactionUserItem) this.$data).getChannelId(), ((ManageReactionsResultsAdapter$ReactionUserItem) this.$data).getMessageId(), ((ManageReactionsResultsAdapter$ReactionUserItem) this.$data).getEmoji(), ((ManageReactionsResultsAdapter$ReactionUserItem) this.$data).getUser().getId());
    }
}
