package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.R$drawable;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: GuildChannelIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelIconUtilsKt {
    public static final GuildChannelIconType getChannelType(Channel channel) {
        PermissionOverwrite permissionOverwrite;
        if (channel == null) {
            return GuildChannelIconType$Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.s(channel, null, 1)) {
            if (channel.getNsfw()) {
                return GuildChannelIconType$NSFW$ForumPost.INSTANCE;
            }
            List<PermissionOverwrite> listV = channel.v();
            if (listV != null) {
                for (Object obj2 : listV) {
                    if (((PermissionOverwrite) obj2).e() == channel.getGuildId()) {
                        obj = obj2;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
                if (permissionOverwrite2 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType$Locked$ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconType$ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconType$NSFW$Voice.INSTANCE : GuildChannelIconType$Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconType$NSFW$Announcements.INSTANCE;
            }
            List<PermissionOverwrite> listV2 = channel.v();
            if (listV2 != null) {
                for (Object obj3 : listV2) {
                    if (((PermissionOverwrite) obj3).e() == channel.getGuildId()) {
                        obj = obj3;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite3 = (PermissionOverwrite) obj;
                if (permissionOverwrite3 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType$Locked$Announcements.INSTANCE;
                }
            }
            return GuildChannelIconType$Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconType$Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconType$NSFW$Forum.INSTANCE;
            }
            List<PermissionOverwrite> listV3 = channel.v();
            if (listV3 != null) {
                for (Object obj4 : listV3) {
                    if (((PermissionOverwrite) obj4).e() == channel.getGuildId()) {
                        obj = obj4;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite4 = (PermissionOverwrite) obj;
                if (permissionOverwrite4 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType$Locked$Forum.INSTANCE;
                }
            }
            return GuildChannelIconType$Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconType$NSFW$Thread.INSTANCE : GuildChannelIconType$Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconType$NSFW$Thread.INSTANCE : GuildChannelIconType$Thread.INSTANCE;
            case 12:
                return GuildChannelIconType$Locked$Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconType$NSFW$Text.INSTANCE;
                }
                List<PermissionOverwrite> listV4 = channel.v();
                if (listV4 != null) {
                    for (Object obj5 : listV4) {
                        if (((PermissionOverwrite) obj5).e() == channel.getGuildId()) {
                            obj = obj5;
                            permissionOverwrite = (PermissionOverwrite) obj;
                            if (permissionOverwrite != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                                return GuildChannelIconType$Locked$Text.INSTANCE;
                            }
                        }
                    }
                    permissionOverwrite = (PermissionOverwrite) obj;
                    if (permissionOverwrite != null) {
                        return GuildChannelIconType$Locked$Text.INSTANCE;
                    }
                }
                return GuildChannelIconType$Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconType guildChannelIconType) {
        m.checkNotNullParameter(guildChannelIconType, "guildChannelIconType");
        if (m.areEqual(guildChannelIconType, GuildChannelIconType$Text.INSTANCE)) {
            return 2131231630;
        }
        if (guildChannelIconType instanceof GuildChannelIconType$Thread) {
            return 2131232193;
        }
        if (guildChannelIconType instanceof GuildChannelIconType$Announcements) {
            return 2131231611;
        }
        if (guildChannelIconType instanceof GuildChannelIconType$Forum) {
            return R$drawable.ic_channel_forum;
        }
        if (!(guildChannelIconType instanceof GuildChannelIconType$ForumPost)) {
            if (guildChannelIconType instanceof GuildChannelIconType$NSFW$Text) {
                return 2131231635;
            }
            if (guildChannelIconType instanceof GuildChannelIconType$NSFW$Announcements) {
                return 2131231614;
            }
            if (guildChannelIconType instanceof GuildChannelIconType$NSFW$Thread) {
                return 2131232196;
            }
            if (guildChannelIconType instanceof GuildChannelIconType$NSFW$Voice) {
                return 2131232254;
            }
            if (guildChannelIconType instanceof GuildChannelIconType$NSFW$Forum) {
                return R$drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconType instanceof GuildChannelIconType$NSFW$ForumPost)) {
                if (guildChannelIconType instanceof GuildChannelIconType$Locked$Text) {
                    return 2131231634;
                }
                if (guildChannelIconType instanceof GuildChannelIconType$Locked$Announcements) {
                    return 2131231613;
                }
                if (guildChannelIconType instanceof GuildChannelIconType$Locked$Thread) {
                    return 2131232196;
                }
                if (guildChannelIconType instanceof GuildChannelIconType$Locked$Forum) {
                    return R$drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconType instanceof GuildChannelIconType$Locked$ForumPost)) {
                    if (guildChannelIconType instanceof GuildChannelIconType$Directory) {
                        return 2131231874;
                    }
                    if (guildChannelIconType instanceof GuildChannelIconType$Voice) {
                        return 2131231642;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return R$drawable.ic_channel_forum_post;
    }
}
