package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionableSourceKt {
    public static final /* synthetic */ boolean access$isDmOrGroupDm(Channel channel) {
        return isDmOrGroupDm(channel);
    }

    public static final /* synthetic */ boolean access$isTextOrVoiceChannel(Channel channel) {
        return isTextOrVoiceChannel(channel);
    }

    private static final boolean isDmOrGroupDm(Channel channel) {
        return channel.getType() == 3 || channel.getType() == 1;
    }

    private static final boolean isTextOrVoiceChannel(Channel channel) {
        return channel.getType() == 5 || channel.getType() == 0 || channel.getType() == 11 || channel.getType() == 12 || channel.getType() == 2;
    }
}
