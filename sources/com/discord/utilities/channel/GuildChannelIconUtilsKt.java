package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildChannelIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelIconUtilsKt {
    public static final GuildChannelIconType getChannelType(Channel channel) {
        PermissionOverwrite permissionOverwrite;
        if (channel == null) {
            return GuildChannelIconType.Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.m7694r(channel, (1 & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null)) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.ForumPost.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v = channel.m7655v();
            if (listM7655v != null) {
                for (Object obj2 : listM7655v) {
                    if (((PermissionOverwrite) obj2).m8131e() == channel.getGuildId()) {
                        obj = obj2;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
                if (permissionOverwrite2 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconType.ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconType.NSFW.Voice.INSTANCE : GuildChannelIconType.Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.Announcements.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v2 = channel.m7655v();
            if (listM7655v2 != null) {
                for (Object obj3 : listM7655v2) {
                    if (((PermissionOverwrite) obj3).m8131e() == channel.getGuildId()) {
                        obj = obj3;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite3 = (PermissionOverwrite) obj;
                if (permissionOverwrite3 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.Announcements.INSTANCE;
                }
            }
            return GuildChannelIconType.Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconType.Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconType.NSFW.Forum.INSTANCE;
            }
            List<PermissionOverwrite> listM7655v3 = channel.m7655v();
            if (listM7655v3 != null) {
                for (Object obj4 : listM7655v3) {
                    if (((PermissionOverwrite) obj4).m8131e() == channel.getGuildId()) {
                        obj = obj4;
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite4 = (PermissionOverwrite) obj;
                if (permissionOverwrite4 != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconType.Locked.Forum.INSTANCE;
                }
            }
            return GuildChannelIconType.Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconType.NSFW.Thread.INSTANCE : GuildChannelIconType.Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconType.NSFW.Thread.INSTANCE : GuildChannelIconType.Thread.INSTANCE;
            case 12:
                return GuildChannelIconType.Locked.Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconType.NSFW.Text.INSTANCE;
                }
                List<PermissionOverwrite> listM7655v4 = channel.m7655v();
                if (listM7655v4 != null) {
                    for (Object obj5 : listM7655v4) {
                        if (((PermissionOverwrite) obj5).m8131e() == channel.getGuildId()) {
                            obj = obj5;
                            permissionOverwrite = (PermissionOverwrite) obj;
                            if (permissionOverwrite != null && PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                                return GuildChannelIconType.Locked.Text.INSTANCE;
                            }
                        }
                    }
                    permissionOverwrite = (PermissionOverwrite) obj;
                    if (permissionOverwrite != null) {
                        return GuildChannelIconType.Locked.Text.INSTANCE;
                    }
                }
                return GuildChannelIconType.Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconType guildChannelIconType) {
        C12238m.checkNotNullParameter(guildChannelIconType, "guildChannelIconType");
        if (C12238m.areEqual(guildChannelIconType, GuildChannelIconType.Text.INSTANCE)) {
            return C5419R.drawable.ic_channel_text;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Thread) {
            return C5419R.drawable.ic_thread;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Announcements) {
            return C5419R.drawable.ic_channel_announcements;
        }
        if (guildChannelIconType instanceof GuildChannelIconType.Forum) {
            return C5419R.drawable.ic_channel_forum;
        }
        if (!(guildChannelIconType instanceof GuildChannelIconType.ForumPost)) {
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Text) {
                return C5419R.drawable.ic_channel_text_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Announcements) {
                return C5419R.drawable.ic_channel_announcements_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Thread) {
                return C5419R.drawable.ic_thread_locked;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Voice) {
                return C5419R.drawable.ic_voice_nsfw;
            }
            if (guildChannelIconType instanceof GuildChannelIconType.NSFW.Forum) {
                return C5419R.drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconType instanceof GuildChannelIconType.NSFW.ForumPost)) {
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Text) {
                    return C5419R.drawable.ic_channel_text_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Announcements) {
                    return C5419R.drawable.ic_channel_announcements_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Thread) {
                    return C5419R.drawable.ic_thread_locked;
                }
                if (guildChannelIconType instanceof GuildChannelIconType.Locked.Forum) {
                    return C5419R.drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconType instanceof GuildChannelIconType.Locked.ForumPost)) {
                    if (guildChannelIconType instanceof GuildChannelIconType.Directory) {
                        return C5419R.drawable.ic_hub_24dp;
                    }
                    if (guildChannelIconType instanceof GuildChannelIconType.Voice) {
                        return C5419R.drawable.ic_channel_voice_grey_header_24dp;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return C5419R.drawable.ic_channel_forum_post;
    }
}
