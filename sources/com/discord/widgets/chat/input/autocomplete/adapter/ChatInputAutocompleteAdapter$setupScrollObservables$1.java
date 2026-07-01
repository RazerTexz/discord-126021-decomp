package com.discord.widgets.chat.input.autocomplete.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompleteAdapter$setupScrollObservables$1<T> implements Action1<Emitter<Object>> {
    public final /* synthetic */ ChatInputAutocompleteAdapter this$0;

    public ChatInputAutocompleteAdapter$setupScrollObservables$1(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        this.this$0 = chatInputAutocompleteAdapter;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Object> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Object> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        ChatInputAutocompleteAdapter.access$setOnScrollListener$p(this.this$0, new ChatInputAutocompleteAdapter$setupScrollObservables$1$1(emitter));
    }
}
