package com.discord.utilities.channel;

import androidx.annotation.DrawableRes;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.channel.GuildChannelIconUtils;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: GuildChannelIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelIconUtils2 {
    public static final GuildChannelIconUtils getChannelType(Channel channel) {
        PermissionOverwrite permissionOverwrite;
        if (channel == null) {
            return GuildChannelIconUtils.Text.INSTANCE;
        }
        Object obj = null;
        if (ChannelUtils.r(channel, (1 & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null)) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.ForumPost.INSTANCE;
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
                if (permissionOverwrite2 != null && PermissionOverwriteUtils.denies(permissionOverwrite2, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.ForumPost.INSTANCE;
                }
            }
            return GuildChannelIconUtils.ForumPost.INSTANCE;
        }
        int type = channel.getType();
        if (type == 2) {
            return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Voice.INSTANCE : GuildChannelIconUtils.Voice.INSTANCE;
        }
        if (type == 5) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Announcements.INSTANCE;
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
                if (permissionOverwrite3 != null && PermissionOverwriteUtils.denies(permissionOverwrite3, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Announcements.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Announcements.INSTANCE;
        }
        if (type == 14) {
            return GuildChannelIconUtils.Directory.INSTANCE;
        }
        if (type == 15) {
            if (channel.getNsfw()) {
                return GuildChannelIconUtils.NSFW.Forum.INSTANCE;
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
                if (permissionOverwrite4 != null && PermissionOverwriteUtils.denies(permissionOverwrite4, Permission.VIEW_CHANNEL)) {
                    return GuildChannelIconUtils.Locked.Forum.INSTANCE;
                }
            }
            return GuildChannelIconUtils.Forum.INSTANCE;
        }
        switch (type) {
            case 10:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 11:
                return channel.getNsfw() ? GuildChannelIconUtils.NSFW.Thread.INSTANCE : GuildChannelIconUtils.Thread.INSTANCE;
            case 12:
                return GuildChannelIconUtils.Locked.Thread.INSTANCE;
            default:
                if (channel.getNsfw()) {
                    return GuildChannelIconUtils.NSFW.Text.INSTANCE;
                }
                List<PermissionOverwrite> listV4 = channel.v();
                if (listV4 != null) {
                    for (Object obj5 : listV4) {
                        if (((PermissionOverwrite) obj5).e() == channel.getGuildId()) {
                            obj = obj5;
                            permissionOverwrite = (PermissionOverwrite) obj;
                            if (permissionOverwrite != null && PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                                return GuildChannelIconUtils.Locked.Text.INSTANCE;
                            }
                        }
                    }
                    permissionOverwrite = (PermissionOverwrite) obj;
                    if (permissionOverwrite != null) {
                        return GuildChannelIconUtils.Locked.Text.INSTANCE;
                    }
                }
                return GuildChannelIconUtils.Text.INSTANCE;
        }
    }

    public static final int guildChannelIcon(Channel channel) {
        return mapGuildChannelTypeToIcon(getChannelType(channel));
    }

    @DrawableRes
    public static final int mapGuildChannelTypeToIcon(GuildChannelIconUtils guildChannelIconUtils) {
        Intrinsics3.checkNotNullParameter(guildChannelIconUtils, "guildChannelIconType");
        if (Intrinsics3.areEqual(guildChannelIconUtils, GuildChannelIconUtils.Text.INSTANCE)) {
            return R.drawable.ic_channel_text;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Thread) {
            return R.drawable.ic_thread;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Announcements) {
            return R.drawable.ic_channel_announcements;
        }
        if (guildChannelIconUtils instanceof GuildChannelIconUtils.Forum) {
            return R.drawable.ic_channel_forum;
        }
        if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.ForumPost)) {
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Text) {
                return R.drawable.ic_channel_text_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Announcements) {
                return R.drawable.ic_channel_announcements_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Thread) {
                return R.drawable.ic_thread_locked;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Voice) {
                return R.drawable.ic_voice_nsfw;
            }
            if (guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.Forum) {
                return R.drawable.ic_channel_forum_nsfw;
            }
            if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.NSFW.ForumPost)) {
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Text) {
                    return R.drawable.ic_channel_text_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Announcements) {
                    return R.drawable.ic_channel_announcements_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Thread) {
                    return R.drawable.ic_thread_locked;
                }
                if (guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.Forum) {
                    return R.drawable.ic_channel_forum_locked;
                }
                if (!(guildChannelIconUtils instanceof GuildChannelIconUtils.Locked.ForumPost)) {
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Directory) {
                        return R.drawable.ic_hub_24dp;
                    }
                    if (guildChannelIconUtils instanceof GuildChannelIconUtils.Voice) {
                        return R.drawable.ic_channel_voice_grey_header_24dp;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return R.drawable.ic_channel_forum_post;
    }
}
