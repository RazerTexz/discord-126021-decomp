package com.discord.widgets.voice.settings;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildVoiceRegions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Lambda;
import d0.z.d.PrimitiveCompanionObjects;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings2 extends Lambda implements Function0<WidgetVoiceChannelSettings.Model> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;
    public final /* synthetic */ StoreGuildVoiceRegions $voiceRegionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceChannelSettings2(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreGuildVoiceRegions storeGuildVoiceRegions) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$permissionStore = storePermissions;
        this.$userStore = storeUser;
        this.$voiceRegionsStore = storeGuildVoiceRegions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceChannelSettings.Model invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        if (channel == null) {
            return null;
        }
        Guild guild = (Guild) outline.c(channel, this.$guildStore.getGuilds());
        Long l = (Long) outline.d(channel, this.$permissionStore.getPermissionsByChannel());
        long jLongValue = l != null ? l.longValue() : 0L;
        MeUser meSnapshot = this.$userStore.getMeSnapshot();
        if (guild == null) {
            return null;
        }
        this.$voiceRegionsStore.fetchIfNonexisting(guild.getId());
        List<ModelVoiceRegion> guildVoiceRegions = this.$voiceRegionsStore.getGuildVoiceRegions(guild.getId());
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildVoiceRegions) {
            ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) obj;
            if ((modelVoiceRegion.isDeprecated() || modelVoiceRegion.isHidden()) ? false : true) {
                arrayList.add(obj);
            }
        }
        final Comparator<String> case_insensitive_order = StringsJVM.getCASE_INSENSITIVE_ORDER(PrimitiveCompanionObjects.a);
        return new WidgetVoiceChannelSettings.Model(channel, PermissionUtils.canAndIsElevated(16L, Long.valueOf(jLongValue), meSnapshot.getMfaEnabled(), guild.getMfaLevel()), PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(jLongValue), meSnapshot.getMfaEnabled(), guild.getMfaLevel()), GuildUtils.getMaxVoiceBitrateKbps(guild, channel), _Collections.sortedWith(arrayList, new Comparator() { // from class: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return case_insensitive_order.compare(((ModelVoiceRegion) t).getName(), ((ModelVoiceRegion) t2).getName());
            }
        }), guild.getId());
    }
}
