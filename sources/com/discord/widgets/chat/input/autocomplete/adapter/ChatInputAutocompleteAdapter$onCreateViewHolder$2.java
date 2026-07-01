package com.discord.widgets.chat.input.autocomplete.adapter;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChatInputAutocompleteAdapter$onCreateViewHolder$2 extends k implements Function1<Autocompletable, Unit> {
    public ChatInputAutocompleteAdapter$onCreateViewHolder$2(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter) {
        super(1, chatInputAutocompleteAdapter, ChatInputAutocompleteAdapter.class, "onAutocompletableSelected", "onAutocompletableSelected(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
        invoke2(autocompletable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Autocompletable autocompletable) {
        m.checkNotNullParameter(autocompletable, "p1");
        ((ChatInputAutocompleteAdapter) this.receiver).onAutocompletableSelected(autocompletable);
    }
}
