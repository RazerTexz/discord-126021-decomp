package com.discord.widgets.chat.managereactions;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$LoadingViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsResultsAdapter$LoadingViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
        super(R$layout.widget_manage_reactions_result_loading, manageReactionsResultsAdapter);
        m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
    }
}
