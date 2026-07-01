package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreInstantInvites$InviteState;
import com.discord.stores.StoreInstantInvites$InviteState$Resolved;
import com.discord.widgets.guilds.invite.InviteGenerator$InviteGenerationState;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import com.discord.widgets.guilds.invite.WidgetInviteModel$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1 extends o implements Function10<ModelInvite$Settings, Map<Long, ? extends Channel>, InviteGenerator$InviteGenerationState, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites$InviteState, Channel, WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded> {
    public static final WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1 INSTANCE = new WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1();

    public WidgetGuildScheduledEventCreateSuccessViewModel$observeInvite$1() {
        super(10);
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded invoke(ModelInvite$Settings modelInvite$Settings, Map<Long, ? extends Channel> map, InviteGenerator$InviteGenerationState inviteGenerator$InviteGenerationState, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites$InviteState storeInstantInvites$InviteState, Channel channel) {
        return invoke2(modelInvite$Settings, (Map<Long, Channel>) map, inviteGenerator$InviteGenerationState, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, storeInstantInvites$InviteState, channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded invoke2(ModelInvite$Settings modelInvite$Settings, Map<Long, Channel> map, InviteGenerator$InviteGenerationState inviteGenerator$InviteGenerationState, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites$InviteState storeInstantInvites$InviteState, Channel channel) {
        Long lValueOf;
        StoreInstantInvites$InviteState storeInstantInvites$InviteState2 = storeInstantInvites$InviteState;
        m.checkNotNullParameter(modelInvite$Settings, "settings");
        m.checkNotNullParameter(map, "invitableChannels");
        m.checkNotNullParameter(inviteGenerator$InviteGenerationState, "inviteGenerationState");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(list, "dms");
        m.checkNotNullParameter(map2, "guildStageInstances");
        m.checkNotNullParameter(storeInstantInvites$InviteState2, "storeInvite");
        WidgetInviteModel$Companion widgetInviteModel$Companion = WidgetInviteModel.Companion;
        if (guildScheduledEvent == null || (lValueOf = guildScheduledEvent.getChannelId()) == null) {
            lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
        }
        if (!(storeInstantInvites$InviteState2 instanceof StoreInstantInvites$InviteState$Resolved)) {
            storeInstantInvites$InviteState2 = null;
        }
        StoreInstantInvites$InviteState$Resolved storeInstantInvites$InviteState$Resolved = (StoreInstantInvites$InviteState$Resolved) storeInstantInvites$InviteState2;
        WidgetInviteModel widgetInviteModelCreate = widgetInviteModel$Companion.create(modelInvite$Settings, map, inviteGenerator$InviteGenerationState, lValueOf, meUser, list, guild, map2, guildScheduledEvent, storeInstantInvites$InviteState$Resolved != null ? storeInstantInvites$InviteState$Resolved.getInvite() : null);
        boolean z2 = true;
        if (widgetInviteModelCreate.getInvite() != null && (widgetInviteModelCreate.getInvite().isStatic() || widgetInviteModelCreate.isInviteFromStore())) {
            z2 = false;
        }
        return new WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded(widgetInviteModelCreate, z2);
    }
}
