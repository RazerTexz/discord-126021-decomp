package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration$LayoutManager;
import d0.z.d.m;

/* JADX INFO: compiled from: StickyHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderManager {
    private final ChatInputAutocompleteAdapter adapter;
    private final RecyclerView recyclerView;
    private final StickyHeaderHolder stickyHeaderHolder;

    public StickyHeaderManager(RecyclerView recyclerView, ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(chatInputAutocompleteAdapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = chatInputAutocompleteAdapter;
        WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBindingA = WidgetChatInputCommandApplicationHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(widgetChatInputCommandApplicationHeaderItemBindingA, "WidgetChatInputCommandAp…clerView, false\n        )");
        this.stickyHeaderHolder = new CommandHeaderViewHolder(widgetChatInputCommandApplicationHeaderItemBindingA);
    }

    public final ChatInputAutocompleteAdapter getAdapter() {
        return this.adapter;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final StickyHeaderHolder getStickyHeaderHolder() {
        return this.stickyHeaderHolder;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        StickyHeaderItemDecoration$LayoutManager.layoutHeaderView(recyclerView, this.stickyHeaderHolder.getItemView());
    }
}
