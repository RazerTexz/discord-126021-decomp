package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables$observeChannelAutocompletables$1<T, R> implements b<Channel, Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>> {
    public static final ChatInputAutocompletables$observeChannelAutocompletables$1 INSTANCE = new ChatInputAutocompletables$observeChannelAutocompletables$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<LeadingIdentifier, Set<Autocompletable>>> call2(Channel channel) {
        ChatInputAutocompletables chatInputAutocompletables = ChatInputAutocompletables.INSTANCE;
        ApplicationCommandsAutocompletableSource application_commands_source = chatInputAutocompletables.getAPPLICATION_COMMANDS_SOURCE();
        m.checkNotNullExpressionValue(channel, "channel");
        return Observable.h(application_commands_source.observeApplicationCommandAutocompletables(channel), chatInputAutocompletables.getEMOJI_SOURCE().observeEmojiAutocompletables(channel), chatInputAutocompletables.getCHANNEL_SOURCE().observeChannelAutocompletables(channel.getGuildId()), chatInputAutocompletables.getUSERS_SOURCE().observeUserAutocompletables(channel), ChatInputAutocompletables$observeChannelAutocompletables$1$1.INSTANCE);
    }
}
