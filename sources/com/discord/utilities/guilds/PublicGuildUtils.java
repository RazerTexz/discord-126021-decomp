package com.discord.utilities.guilds;

import com.discord.api.message.MessageReference;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: PublicGuildUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublicGuildUtils {
    public static final PublicGuildUtils INSTANCE = new PublicGuildUtils();
    private static final long PUBLIC_GUILD_ANNOUNCEMENTS_GUILD_ID = 667560445975986187L;
    private static final long PUBLIC_GUILD_UPDATES_WEBHOOK_USER_ID = 669627189624307712L;

    private PublicGuildUtils() {
    }

    public final boolean isPublicGuildSystemMessage(Message message) {
        User author;
        Intrinsics3.checkNotNullParameter(message, "message");
        MessageReference messageReference = message.getMessageReference();
        Long guildId = messageReference != null ? messageReference.getGuildId() : null;
        return (guildId != null && guildId.longValue() == PUBLIC_GUILD_ANNOUNCEMENTS_GUILD_ID) || ((author = message.getAuthor()) != null && author.getId() == PUBLIC_GUILD_UPDATES_WEBHOOK_USER_ID);
    }
}
