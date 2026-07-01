package com.discord.utilities.stage;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.start.WidgetModeratorStartStage;
import d0.z.d.m;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StageChannelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelUtils {
    public static final StageChannelUtils INSTANCE = new StageChannelUtils();

    private StageChannelUtils() {
    }

    public static final boolean computeCanEditStageModerators(StorePermissions permissionStore, StoreGuilds guildStore, long meId, long guildId, Channel channel) {
        m.checkNotNullParameter(permissionStore, "permissionStore");
        m.checkNotNullParameter(guildStore, "guildStore");
        m.checkNotNullParameter(channel, "channel");
        Guild guild = guildStore.getGuilds().get(Long.valueOf(guildId));
        if ((guild != null && guild.isOwner(meId)) || d.H0((Long) a.d(channel, permissionStore.getPermissionsByChannel()), 8L) || d.H0(permissionStore.getGuildPermissions().get(Long.valueOf(guildId)), 289406992L)) {
            return true;
        }
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        Map<Long, GuildMember> map = guildStore.getMembers().get(Long.valueOf(guildId));
        return d.H0(Long.valueOf(permissionUtils.computeChannelOverwrite(meId, guildId, map != null ? map.get(Long.valueOf(meId)) : null, channel.v())), Permission.MANAGE_ROLES);
    }

    public static /* synthetic */ boolean shouldShowEndStageBottomSheet$default(StageChannelUtils stageChannelUtils, long j, StoreChannels storeChannels, StoreStageChannels storeStageChannels, StoreStageInstances storeStageInstances, StoreUser storeUser, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 4) != 0) {
            storeStageChannels = StoreStream.Companion.getStageChannels();
        }
        StoreStageChannels storeStageChannels2 = storeStageChannels;
        if ((i & 8) != 0) {
            storeStageInstances = StoreStream.Companion.getStageInstances();
        }
        StoreStageInstances storeStageInstances2 = storeStageInstances;
        if ((i & 16) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return stageChannelUtils.shouldShowEndStageBottomSheet(j, storeChannels2, storeStageChannels2, storeStageInstances2, storeUser);
    }

    public final void connectToStageChannel(Channel channel, Context context, FragmentManager fragmentManager) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (channel.getType() != 13) {
            return;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StageInstance stageInstanceForChannel = storeStream$Companion.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long l = (Long) a.d(channel, storeStream$Companion.getPermissions().getPermissionsByChannel());
        if (stageInstanceForChannel != null && d.W0(stageInstanceForChannel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            return;
        }
        if (stageInstanceForChannel != null || l == null || !PermissionUtils.can(20971536L, Long.valueOf(l.longValue()))) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new StageChannelUtils$connectToStageChannel$2(context, fragmentManager, channel), 48, null);
            return;
        }
        WidgetModeratorStartStage.Companion.launch(context, channel.getId(), channel.getGuildId());
    }

    public final boolean shouldShowEndStageBottomSheet(long channelId, StoreChannels channelsStore, StoreStageChannels stageChannelsStore, StoreStageInstances stageInstanceStore, StoreUser userStore) {
        StageRoles stageRolesM15getMyRolesvisDeB4;
        Map<Long, StageRoles> channelRoles;
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(stageChannelsStore, "stageChannelsStore");
        m.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
        m.checkNotNullParameter(userStore, "userStore");
        Channel channel = channelsStore.getChannel(channelId);
        if (channel == null || !ChannelUtils.D(channel) || stageInstanceStore.getStageInstanceForChannel(channel.getId()) == null || (stageRolesM15getMyRolesvisDeB4 = stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) == null || !StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) || (channelRoles = stageChannelsStore.getChannelRoles(channel.getId())) == null) {
            return false;
        }
        long id2 = userStore.getMeSnapshot().getId();
        boolean z2 = false;
        boolean z3 = false;
        for (Map$Entry<Long, StageRoles> map$Entry : channelRoles.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            int iM35unboximpl = map$Entry.getValue().m35unboximpl();
            if (jLongValue != id2 && StageRoles.m32isModeratorimpl(iM35unboximpl)) {
                if (StageRoles.m33isSpeakerimpl(iM35unboximpl)) {
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return true;
        }
        if (StageRoles.m33isSpeakerimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return !z3;
        }
        return false;
    }
}
