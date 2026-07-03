package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$CHANNEL_SOURCE$2 extends AbstractC12240o implements Function0<ChannelAutocompletableSource> {
    public static final ChatInputAutocompletables$CHANNEL_SOURCE$2 INSTANCE = new ChatInputAutocompletables$CHANNEL_SOURCE$2();

    public ChatInputAutocompletables$CHANNEL_SOURCE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new ChannelAutocompletableSource(companion.getChannels(), companion.getThreadsActiveJoined(), companion.getPermissions());
    }
}
