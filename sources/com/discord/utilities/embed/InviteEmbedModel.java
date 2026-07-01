package com.discord.utilities.embed;

import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites$InviteState;
import com.discord.stores.StoreInstantInvites$InviteState$Resolved;
import com.discord.stores.StoreRequestedStageChannels$StageInstanceState;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: InviteEmbedModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InviteEmbedModel {
    public static final InviteEmbedModel$Companion Companion = new InviteEmbedModel$Companion(null);
    private final Map<Long, Channel> channels;
    private final Map<String, StoreInstantInvites$InviteState> invites;
    private final Map<Long, StoreRequestedStageChannels$StageInstanceState> requestedInstances;
    private final Map<Long, StageInstance> stageInstances;

    /* JADX WARN: Multi-variable type inference failed */
    public InviteEmbedModel(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites$InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels$StageInstanceState> map4) {
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(map2, "invites");
        m.checkNotNullParameter(map3, "stageInstances");
        m.checkNotNullParameter(map4, "requestedInstances");
        this.channels = map;
        this.invites = map2;
        this.stageInstances = map3;
        this.requestedInstances = map4;
    }

    private final Map<Long, Channel> component1() {
        return this.channels;
    }

    private final Map<String, StoreInstantInvites$InviteState> component2() {
        return this.invites;
    }

    private final Map<Long, StageInstance> component3() {
        return this.stageInstances;
    }

    private final Map<Long, StoreRequestedStageChannels$StageInstanceState> component4() {
        return this.requestedInstances;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteEmbedModel copy$default(InviteEmbedModel inviteEmbedModel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = inviteEmbedModel.channels;
        }
        if ((i & 2) != 0) {
            map2 = inviteEmbedModel.invites;
        }
        if ((i & 4) != 0) {
            map3 = inviteEmbedModel.stageInstances;
        }
        if ((i & 8) != 0) {
            map4 = inviteEmbedModel.requestedInstances;
        }
        return inviteEmbedModel.copy(map, map2, map3, map4);
    }

    public final InviteEmbedModel copy(Map<Long, Channel> channels, Map<String, ? extends StoreInstantInvites$InviteState> invites, Map<Long, StageInstance> stageInstances, Map<Long, StoreRequestedStageChannels$StageInstanceState> requestedInstances) {
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(invites, "invites");
        m.checkNotNullParameter(stageInstances, "stageInstances");
        m.checkNotNullParameter(requestedInstances, "requestedInstances");
        return new InviteEmbedModel(channels, invites, stageInstances, requestedInstances);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEmbedModel)) {
            return false;
        }
        InviteEmbedModel inviteEmbedModel = (InviteEmbedModel) other;
        return m.areEqual(this.channels, inviteEmbedModel.channels) && m.areEqual(this.invites, inviteEmbedModel.invites) && m.areEqual(this.stageInstances, inviteEmbedModel.stageInstances) && m.areEqual(this.requestedInstances, inviteEmbedModel.requestedInstances);
    }

    public final ModelInvite getResolvedInvite(String inviteKey) {
        m.checkNotNullParameter(inviteKey, "inviteKey");
        StoreInstantInvites$InviteState storeInstantInvites$InviteState = this.invites.get(inviteKey);
        if (!(storeInstantInvites$InviteState instanceof StoreInstantInvites$InviteState$Resolved)) {
            storeInstantInvites$InviteState = null;
        }
        StoreInstantInvites$InviteState$Resolved storeInstantInvites$InviteState$Resolved = (StoreInstantInvites$InviteState$Resolved) storeInstantInvites$InviteState;
        if (storeInstantInvites$InviteState$Resolved != null) {
            return storeInstantInvites$InviteState$Resolved.getInvite();
        }
        return null;
    }

    public int hashCode() {
        Map<Long, Channel> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, StoreInstantInvites$InviteState> map2 = this.invites;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, StageInstance> map3 = this.stageInstances;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, StoreRequestedStageChannels$StageInstanceState> map4 = this.requestedInstances;
        return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
    }

    public final ModelInvite resolveInviteCodeForPublicStage(String inviteCode) {
        RecommendedStageInstance stageInstance;
        StageInstance recommendedStageInstance;
        m.checkNotNullParameter(inviteCode, "inviteCode");
        ModelInvite resolvedInvite = getResolvedInvite(inviteCode);
        if (resolvedInvite != null) {
            Channel channel = resolvedInvite.getChannel();
            if (!(channel != null && ChannelUtils.D(channel))) {
                channel = null;
            }
            if (channel != null) {
                m.checkNotNullExpressionValue(channel, "invite.channel.takeIf { … == true } ?: return null");
                StageInstance stageInstance2 = (StageInstance) a.d(channel, this.stageInstances);
                if (stageInstance2 != null && d.W0(stageInstance2)) {
                    return resolvedInvite;
                }
                if (((Channel) a.d(channel, this.channels)) != null) {
                    return null;
                }
                StoreRequestedStageChannels$StageInstanceState storeRequestedStageChannels$StageInstanceState = (StoreRequestedStageChannels$StageInstanceState) a.d(channel, this.requestedInstances);
                if (storeRequestedStageChannels$StageInstanceState != null && (stageInstance = storeRequestedStageChannels$StageInstanceState.getStageInstance()) != null && (recommendedStageInstance = stageInstance.getInstance()) != null && d.W0(recommendedStageInstance)) {
                    return resolvedInvite;
                }
                if (storeRequestedStageChannels$StageInstanceState == null || storeRequestedStageChannels$StageInstanceState.isError()) {
                    StoreStream.Companion.getRequestedStageChannels().enqueueStageChannelFetch(channel.getId());
                }
            }
        }
        return null;
    }

    public final ModelInvite resolveInviteForGuildScheduledEvent(String inviteCode, String eventId) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        m.checkNotNullParameter(eventId, "eventId");
        String inviteStoreKey = ModelInvite.getInviteStoreKey(inviteCode, SnowflakeUtils.INSTANCE.toSnowflake(eventId));
        m.checkNotNullExpressionValue(inviteStoreKey, "ModelInvite.getInviteSto…d.toSnowflake()\n        )");
        ModelInvite resolvedInvite = getResolvedInvite(inviteStoreKey);
        if ((resolvedInvite != null ? resolvedInvite.getGuildScheduledEvent() : null) != null) {
            return resolvedInvite;
        }
        return null;
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteEmbedModel(channels=");
        sbU.append(this.channels);
        sbU.append(", invites=");
        sbU.append(this.invites);
        sbU.append(", stageInstances=");
        sbU.append(this.stageInstances);
        sbU.append(", requestedInstances=");
        return a.M(sbU, this.requestedInstances, ")");
    }
}
