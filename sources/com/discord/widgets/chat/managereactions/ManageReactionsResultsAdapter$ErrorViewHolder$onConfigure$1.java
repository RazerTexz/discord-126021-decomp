package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import java.util.Objects;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$ErrorViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public ManageReactionsResultsAdapter$ErrorViewHolder$onConfigure$1(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MGRecyclerDataPayload mGRecyclerDataPayload = this.$data;
        Objects.requireNonNull(mGRecyclerDataPayload, "null cannot be cast to non-null type com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter.ErrorItem");
        ManageReactionsResultsAdapter$ErrorItem manageReactionsResultsAdapter$ErrorItem = (ManageReactionsResultsAdapter$ErrorItem) mGRecyclerDataPayload;
        StoreStream.Companion.getMessageReactions().forceRetryFetchReactions(manageReactionsResultsAdapter$ErrorItem.getChannelId(), manageReactionsResultsAdapter$ErrorItem.getMessageId(), manageReactionsResultsAdapter$ErrorItem.getEmoji());
    }
}
