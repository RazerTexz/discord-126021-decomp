package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$CHANNEL_SOURCE$2 extends o implements Function0<ChannelAutocompletableSource> {
    public static final ChatInputAutocompletables$CHANNEL_SOURCE$2 INSTANCE = new ChatInputAutocompletables$CHANNEL_SOURCE$2();

    public ChatInputAutocompletables$CHANNEL_SOURCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChannelAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelAutocompletableSource invoke() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return new ChannelAutocompletableSource(storeStream$Companion.getChannels(), storeStream$Companion.getThreadsActiveJoined(), storeStream$Companion.getPermissions());
    }
}
