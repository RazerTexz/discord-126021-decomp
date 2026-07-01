package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSourceKt, reason: use source file name */
/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionableSource3 {
    private static final boolean isDmOrGroupDm(Channel channel) {
        return channel.getType() == 3 || channel.getType() == 1;
    }

    private static final boolean isTextOrVoiceChannel(Channel channel) {
        return channel.getType() == 5 || channel.getType() == 0 || channel.getType() == 11 || channel.getType() == 12 || channel.getType() == 2;
    }
}
