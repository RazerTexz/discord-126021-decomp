package com.discord.widgets.chat.input.autocomplete.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import rx.Emitter;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompleteAdapter$setupScrollObservables$1$1 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ Emitter $emitter;

    public ChatInputAutocompleteAdapter$setupScrollObservables$1$1(Emitter emitter) {
        this.$emitter = emitter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        this.$emitter.onNext(0);
    }
}
