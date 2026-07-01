package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import d0.t.h0;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$VideoUseDetector {
    private final StoreChannels channelsStore;
    private final StoreUser usersStore;
    private final StoreVoiceStates voiceStatesStore;

    public StoreAudioManagerV2$VideoUseDetector(StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUser storeUser) {
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        m.checkNotNullParameter(storeUser, "usersStore");
        this.channelsStore = storeChannels;
        this.voiceStatesStore = storeVoiceStates;
        this.usersStore = storeUser;
    }

    @StoreThread
    private final Map<Long, VoiceState> getVoiceStatesForChannel(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.channelsStore.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
        if (map == null) {
            return h0.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, VoiceState> map$Entry : map.entrySet()) {
            Long channelId2 = map$Entry.getValue().getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @StoreThread
    public final boolean isMyVideoOn(long channelId) {
        VoiceState voiceState = getVoiceStatesForChannel(channelId).get(Long.valueOf(this.usersStore.getMe().getId()));
        if (voiceState == null) {
            return false;
        }
        m.checkNotNullParameter(voiceState, "$this$hasVideo");
        return voiceState.getSelfStream() || voiceState.getSelfVideo();
    }
}
