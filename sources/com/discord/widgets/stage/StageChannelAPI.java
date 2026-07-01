package com.discord.widgets.stage;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import rx.Observable;

/* JADX INFO: compiled from: StageChannelAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelAPI {
    public static final StageChannelAPI INSTANCE = new StageChannelAPI();

    private StageChannelAPI() {
    }

    public static /* synthetic */ Observable setUserSuppressedInChannel$default(StageChannelAPI stageChannelAPI, Channel channel, long j, boolean z2, long j2, int i, Object obj) {
        if ((i & 8) != 0) {
            j2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        }
        return stageChannelAPI.setUserSuppressedInChannel(channel, j, z2, j2);
    }

    public static /* synthetic */ Observable startStageInstance$default(StageChannelAPI stageChannelAPI, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = null;
        }
        return stageChannelAPI.startStageInstance(j, str, stageInstancePrivacyLevel, z2, str2);
    }

    public static /* synthetic */ Observable updateStageInstance$default(StageChannelAPI stageChannelAPI, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            stageInstancePrivacyLevel = null;
        }
        return stageChannelAPI.updateStageInstance(j, str, stageInstancePrivacyLevel);
    }

    public final Observable<Void> ackInvitationToSpeak(long channelId, boolean accept) {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(channelId);
        if (channel != null) {
            return INSTANCE.ackInvitationToSpeak(channel, accept);
        }
        return null;
    }

    public final Observable<Void> setUserSuppressedInChannel(Channel channel, long userId, boolean isSuppressed, long meId) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return userId == meId ? RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, isSuppressed) : RestAPI.INSTANCE.getApi().setUserSuppressed(channel, userId, isSuppressed);
    }

    public final Observable<StageInstance> startStageInstance(long channelId, String topic, StageInstancePrivacyLevel privacyLevel, boolean sendStartNotification, String guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(privacyLevel, "privacyLevel");
        return RestAPI.INSTANCE.getApi().startStageInstance(new RestAPIParams.StartStageInstanceBody(channelId, topic, privacyLevel, sendStartNotification, guildScheduledEventId));
    }

    public final Observable<StageInstance> updateStageInstance(long channelId, String topic, StageInstancePrivacyLevel privacyLevel) {
        return RestAPI.INSTANCE.getApi().updateStageInstance(channelId, new RestAPIParams.UpdateStageInstanceBody(topic, privacyLevel));
    }

    public final Observable<Void> ackInvitationToSpeak(Channel channel, boolean accept) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return setUserSuppressedInChannel$default(this, channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), !accept, 0L, 8, null);
    }
}
