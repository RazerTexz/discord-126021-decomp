package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$EMOJI_SOURCE$2 extends o implements Function0<EmojiAutocompletableSource> {
    public static final ChatInputAutocompletables$EMOJI_SOURCE$2 INSTANCE = new ChatInputAutocompletables$EMOJI_SOURCE$2();

    public ChatInputAutocompletables$EMOJI_SOURCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiAutocompletableSource invoke() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return new EmojiAutocompletableSource(storeStream$Companion.getEmojis(), storeStream$Companion.getUserSettings());
    }
}
