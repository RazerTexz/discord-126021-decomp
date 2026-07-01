package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompleteAdapter$setupStickyApplicationHeaders$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ RecyclerView $recyclerView;
    public final /* synthetic */ ChatInputAutocompleteAdapter this$0;

    public ChatInputAutocompleteAdapter$setupStickyApplicationHeaders$1(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter, RecyclerView recyclerView) {
        this.this$0 = chatInputAutocompleteAdapter;
        this.$recyclerView = recyclerView;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        StickyHeaderManager stickyHeaderManagerAccess$getStickyHeaderManager$p = ChatInputAutocompleteAdapter.access$getStickyHeaderManager$p(this.this$0);
        if (stickyHeaderManagerAccess$getStickyHeaderManager$p != null) {
            stickyHeaderManagerAccess$getStickyHeaderManager$p.layoutViews(this.$recyclerView);
        }
    }
}
