package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickyHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderManager {
    private final ChatInputAutocompleteAdapter adapter;
    private final RecyclerView recyclerView;
    private final StickyHeaderHolder stickyHeaderHolder;

    public StickyHeaderManager(RecyclerView recyclerView, ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        C12238m.checkNotNullParameter(chatInputAutocompleteAdapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = chatInputAutocompleteAdapter;
        WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBindingM8407a = WidgetChatInputCommandApplicationHeaderItemBinding.m8407a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        C12238m.checkNotNullExpressionValue(widgetChatInputCommandApplicationHeaderItemBindingM8407a, "WidgetChatInputCommandAp…clerView, false\n        )");
        this.stickyHeaderHolder = new CommandHeaderViewHolder(widgetChatInputCommandApplicationHeaderItemBindingM8407a);
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
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, this.stickyHeaderHolder.getItemView());
    }
}
