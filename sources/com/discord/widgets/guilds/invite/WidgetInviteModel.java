package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.widgets.guilds.invite.InviteGenerator;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetInviteModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetInviteModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Channel> dms;
    private final List<Channel> invitableChannels;
    private final ModelInvite invite;
    private final boolean isGeneratingInvite;
    private final boolean isInviteFromStore;
    private final boolean isValidInvite;
    private final MeUser me;
    private final ModelInvite.Settings settings;
    private final Channel targetChannel;

    /* JADX INFO: compiled from: WidgetInviteModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final ModelInvite tryGetStaticInvite(Long selectedChannelId, Guild guild, Map<Long, StageInstance> guildStageInstances) {
            String inviteCode;
            if (guild == null) {
                return null;
            }
            StageInstance stageInstance = guildStageInstances.get(selectedChannelId);
            if (stageInstance != null && (inviteCode = stageInstance.getInviteCode()) != null) {
                return ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
            }
            String vanityUrlCode = guild.getVanityUrlCode();
            if (vanityUrlCode != null) {
                return ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
            }
            return null;
        }

        public final WidgetInviteModel create(ModelInvite.Settings settings, Map<Long, Channel> invitableChannels, InviteGenerator.InviteGenerationState inviteGenerationState, Long selectedChannelId, MeUser me2, List<Channel> dms, Guild guild, Map<Long, StageInstance> guildStageInstances, GuildScheduledEvent guildScheduledEvent, ModelInvite existingInviteFromStore) {
            Channel channel;
            ModelInvite modelInviteTryGetStaticInvite;
            boolean z2;
            Channel channel2;
            Intrinsics3.checkNotNullParameter(settings, "settings");
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(dms, "dms");
            Intrinsics3.checkNotNullParameter(guildStageInstances, "guildStageInstances");
            if (existingInviteFromStore != null) {
                return new WidgetInviteModel(null, null, existingInviteFromStore, false, true, Collections2.emptyList(), me2, dms, true);
            }
            ModelInvite lastGeneratedInvite = inviteGenerationState.getLastGeneratedInvite();
            ArrayList arrayList = new ArrayList(invitableChannels.values());
            Collections.sort(arrayList, ChannelUtils.h(Channel.INSTANCE));
            if (invitableChannels.containsKey(selectedChannelId)) {
                channel = invitableChannels.get(selectedChannelId);
            } else {
                channel = arrayList.isEmpty() ^ true ? (Channel) arrayList.get(0) : null;
            }
            Channel channel3 = channel;
            boolean z3 = (lastGeneratedInvite == null || channel3 == null || lastGeneratedInvite.getChannel() == null || (channel2 = lastGeneratedInvite.getChannel()) == null || channel2.getId() != channel3.getId()) ? false : true;
            if ((channel3 == null || inviteGenerationState.getState() == InviteGenerator.GenerationState.FAILURE) && (modelInviteTryGetStaticInvite = tryGetStaticInvite(selectedChannelId, guild, guildStageInstances)) != null) {
                z2 = true;
            } else {
                z2 = z3;
                modelInviteTryGetStaticInvite = lastGeneratedInvite;
            }
            if (channel3 != null && guildScheduledEvent != null && guildScheduledEvent.p(channel3.getId()) && modelInviteTryGetStaticInvite != null) {
                modelInviteTryGetStaticInvite.setGuildScheduledEvent(guildScheduledEvent);
            }
            return new WidgetInviteModel(channel3, settings, modelInviteTryGetStaticInvite, inviteGenerationState.getState() == InviteGenerator.GenerationState.GENERATING, z2, arrayList, me2, dms, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetInviteModel(Channel channel, ModelInvite.Settings settings, ModelInvite modelInvite, boolean z2, boolean z3, List<Channel> list, MeUser meUser, List<Channel> list2, boolean z4) {
        Intrinsics3.checkNotNullParameter(list, "invitableChannels");
        Intrinsics3.checkNotNullParameter(meUser, "me");
        Intrinsics3.checkNotNullParameter(list2, "dms");
        this.targetChannel = channel;
        this.settings = settings;
        this.invite = modelInvite;
        this.isGeneratingInvite = z2;
        this.isValidInvite = z3;
        this.invitableChannels = list;
        this.me = meUser;
        this.dms = list2;
        this.isInviteFromStore = z4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelInvite.Settings getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsValidInvite() {
        return this.isValidInvite;
    }

    public final List<Channel> component6() {
        return this.invitableChannels;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final List<Channel> component8() {
        return this.dms;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final WidgetInviteModel copy(Channel targetChannel, ModelInvite.Settings settings, ModelInvite invite, boolean isGeneratingInvite, boolean isValidInvite, List<Channel> invitableChannels, MeUser me2, List<Channel> dms, boolean isInviteFromStore) {
        Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
        Intrinsics3.checkNotNullParameter(me2, "me");
        Intrinsics3.checkNotNullParameter(dms, "dms");
        return new WidgetInviteModel(targetChannel, settings, invite, isGeneratingInvite, isValidInvite, invitableChannels, me2, dms, isInviteFromStore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetInviteModel)) {
            return false;
        }
        WidgetInviteModel widgetInviteModel = (WidgetInviteModel) other;
        return Intrinsics3.areEqual(this.targetChannel, widgetInviteModel.targetChannel) && Intrinsics3.areEqual(this.settings, widgetInviteModel.settings) && Intrinsics3.areEqual(this.invite, widgetInviteModel.invite) && this.isGeneratingInvite == widgetInviteModel.isGeneratingInvite && this.isValidInvite == widgetInviteModel.isValidInvite && Intrinsics3.areEqual(this.invitableChannels, widgetInviteModel.invitableChannels) && Intrinsics3.areEqual(this.me, widgetInviteModel.me) && Intrinsics3.areEqual(this.dms, widgetInviteModel.dms) && this.isInviteFromStore == widgetInviteModel.isInviteFromStore;
    }

    public final List<Channel> getDms() {
        return this.dms;
    }

    public final List<Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final ModelInvite.Settings getSettings() {
        return this.settings;
    }

    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.targetChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        ModelInvite.Settings settings = this.settings;
        int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        int iHashCode3 = (iHashCode2 + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
        boolean z2 = this.isGeneratingInvite;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        boolean z3 = this.isValidInvite;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        List<Channel> list = this.invitableChannels;
        int iHashCode4 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        List<Channel> list2 = this.dms;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z4 = this.isInviteFromStore;
        return iHashCode6 + (z4 ? 1 : z4);
    }

    public final boolean isGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    public final boolean isInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final boolean isValidInvite() {
        return this.isValidInvite;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetInviteModel(targetChannel=");
        sbU.append(this.targetChannel);
        sbU.append(", settings=");
        sbU.append(this.settings);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", isGeneratingInvite=");
        sbU.append(this.isGeneratingInvite);
        sbU.append(", isValidInvite=");
        sbU.append(this.isValidInvite);
        sbU.append(", invitableChannels=");
        sbU.append(this.invitableChannels);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", dms=");
        sbU.append(this.dms);
        sbU.append(", isInviteFromStore=");
        return outline.O(sbU, this.isInviteFromStore, ")");
    }

    public /* synthetic */ WidgetInviteModel(Channel channel, ModelInvite.Settings settings, ModelInvite modelInvite, boolean z2, boolean z3, List list, MeUser meUser, List list2, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, settings, modelInvite, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, list, meUser, list2, (i & 256) != 0 ? false : z4);
    }
}
