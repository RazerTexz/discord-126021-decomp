package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.GuildUtilsKt;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetInviteModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetInviteModel$Companion {
    private WidgetInviteModel$Companion() {
    }

    private final ModelInvite tryGetStaticInvite(Long selectedChannelId, Guild guild, Map<Long, StageInstance> guildStageInstances) {
        String inviteCode;
        if (guild == null) {
            return null;
        }
        StageInstance stageInstance = guildStageInstances.get(selectedChannelId);
        if (stageInstance != null && (inviteCode = stageInstance.getInviteCode()) != null) {
            return ModelInvite.createForStaticUrl(inviteCode, GuildUtilsKt.createApiGuild(guild));
        }
        String vanityUrlCode = guild.getVanityUrlCode();
        if (vanityUrlCode != null) {
            return ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtilsKt.createApiGuild(guild));
        }
        return null;
    }

    public final WidgetInviteModel create(ModelInvite$Settings settings, Map<Long, Channel> invitableChannels, InviteGenerator$InviteGenerationState inviteGenerationState, Long selectedChannelId, MeUser me2, List<Channel> dms, Guild guild, Map<Long, StageInstance> guildStageInstances, GuildScheduledEvent guildScheduledEvent, ModelInvite existingInviteFromStore) {
        Channel channel;
        ModelInvite modelInviteTryGetStaticInvite;
        boolean z2;
        Channel channel2;
        m.checkNotNullParameter(settings, "settings");
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        m.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(dms, "dms");
        m.checkNotNullParameter(guildStageInstances, "guildStageInstances");
        if (existingInviteFromStore != null) {
            return new WidgetInviteModel(null, null, existingInviteFromStore, false, true, n.emptyList(), me2, dms, true);
        }
        ModelInvite lastGeneratedInvite = inviteGenerationState.getLastGeneratedInvite();
        ArrayList arrayList = new ArrayList(invitableChannels.values());
        Collections.sort(arrayList, ChannelUtils.h(Channel.Companion));
        if (invitableChannels.containsKey(selectedChannelId)) {
            channel = invitableChannels.get(selectedChannelId);
        } else {
            channel = arrayList.isEmpty() ^ true ? (Channel) arrayList.get(0) : null;
        }
        Channel channel3 = channel;
        boolean z3 = (lastGeneratedInvite == null || channel3 == null || lastGeneratedInvite.getChannel() == null || (channel2 = lastGeneratedInvite.getChannel()) == null || channel2.getId() != channel3.getId()) ? false : true;
        if ((channel3 == null || inviteGenerationState.getState() == InviteGenerator$GenerationState.FAILURE) && (modelInviteTryGetStaticInvite = tryGetStaticInvite(selectedChannelId, guild, guildStageInstances)) != null) {
            z2 = true;
        } else {
            z2 = z3;
            modelInviteTryGetStaticInvite = lastGeneratedInvite;
        }
        if (channel3 != null && guildScheduledEvent != null && guildScheduledEvent.p(channel3.getId()) && modelInviteTryGetStaticInvite != null) {
            modelInviteTryGetStaticInvite.setGuildScheduledEvent(guildScheduledEvent);
        }
        return new WidgetInviteModel(channel3, settings, modelInviteTryGetStaticInvite, inviteGenerationState.getState() == InviteGenerator$GenerationState.GENERATING, z2, arrayList, me2, dms, false);
    }

    public /* synthetic */ WidgetInviteModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
