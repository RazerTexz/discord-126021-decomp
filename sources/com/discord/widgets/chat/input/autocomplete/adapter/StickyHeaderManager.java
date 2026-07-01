package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StickyHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderManager {
    private final ChatInputAutocompleteAdapter adapter;
    private final RecyclerView recyclerView;
    private final StickyHeaderManager2 stickyHeaderHolder;

    public StickyHeaderManager(RecyclerView recyclerView, ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(chatInputAutocompleteAdapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = chatInputAutocompleteAdapter;
        WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBindingA = WidgetChatInputCommandApplicationHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommandApplicationHeaderItemBindingA, "WidgetChatInputCommandAp…clerView, false\n        )");
        this.stickyHeaderHolder = new CommandHeaderViewHolder(widgetChatInputCommandApplicationHeaderItemBindingA);
    }

    public final ChatInputAutocompleteAdapter getAdapter() {
        return this.adapter;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final StickyHeaderManager2 getStickyHeaderHolder() {
        return this.stickyHeaderHolder;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, this.stickyHeaderHolder.getItemView());
    }
}
