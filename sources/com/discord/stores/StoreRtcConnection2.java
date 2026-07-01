package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.voice.state.VoiceState;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.discord.stores.VoicePropsTracker, reason: use source file name */
/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection2 {
    private final long channelId;
    private final long guildId;
    private final long localUserId;
    private boolean localUserSpeaking;
    private int maxListenerCount;
    private int maxSpeakerCount;
    private int maxVoiceStateCount;
    private final Set<Long> allVoiceStateUsers = new LinkedHashSet();
    private final Set<Long> currentVoiceStateUsers = new LinkedHashSet();
    private final Set<Long> allListenerUsers = new LinkedHashSet();
    private final Set<Long> currentPotentialListeners = new LinkedHashSet();
    private final Set<Long> allSpeakerUsers = new LinkedHashSet();
    private final Set<Long> currentSpeakerUsers = new LinkedHashSet();

    public StoreRtcConnection2(long j, long j2, long j3, Map<Long, VoiceState> map) {
        this.guildId = j;
        this.channelId = j2;
        this.localUserId = j3;
        if (map != null) {
            for (Map.Entry<Long, VoiceState> entry : map.entrySet()) {
                long jLongValue = entry.getKey().longValue();
                VoiceState value = entry.getValue();
                Long channelId = value.getChannelId();
                long j4 = this.channelId;
                if (channelId != null && channelId.longValue() == j4) {
                    this.currentVoiceStateUsers.add(Long.valueOf(jLongValue));
                    if (!value.getDeaf() && !value.getSelfDeaf()) {
                        this.currentPotentialListeners.add(Long.valueOf(jLongValue));
                    }
                }
            }
        }
    }

    public final void getProps(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        properties.put("max_voice_state_count", Integer.valueOf(this.maxVoiceStateCount));
        properties.put("total_voice_state_count", Integer.valueOf(this.allVoiceStateUsers.size()));
        properties.put("max_listener_count", Integer.valueOf(this.maxListenerCount));
        properties.put("total_listener_count", Integer.valueOf(this.allListenerUsers.size()));
        properties.put("max_speaker_count", Integer.valueOf(this.maxSpeakerCount));
        properties.put("total_speaker_count", Integer.valueOf(this.allSpeakerUsers.size()));
    }

    public final void handleOnSpeaking(long userId, boolean isSpeaking) {
        if (isSpeaking) {
            this.allSpeakerUsers.add(Long.valueOf(userId));
            this.currentSpeakerUsers.add(Long.valueOf(userId));
            this.maxSpeakerCount = Math.max(this.maxSpeakerCount, this.currentSpeakerUsers.size());
        } else {
            this.currentSpeakerUsers.remove(Long.valueOf(userId));
        }
        if (userId != this.localUserId || this.localUserSpeaking == isSpeaking) {
            return;
        }
        this.localUserSpeaking = isSpeaking;
        if (isSpeaking) {
            this.allListenerUsers.addAll(this.currentPotentialListeners);
            this.maxListenerCount = Math.max(this.maxListenerCount, this.currentPotentialListeners.size());
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getGuildId() == this.guildId) {
            if (AnimatableValueParser.X0(voiceState)) {
                this.currentVoiceStateUsers.remove(Long.valueOf(voiceState.getUserId()));
                this.currentPotentialListeners.remove(Long.valueOf(voiceState.getUserId()));
                this.currentSpeakerUsers.remove(Long.valueOf(voiceState.getUserId()));
                return;
            }
            Long channelId = voiceState.getChannelId();
            long j = this.channelId;
            if (channelId != null && channelId.longValue() == j) {
                this.currentVoiceStateUsers.add(Long.valueOf(voiceState.getUserId()));
                this.allVoiceStateUsers.add(Long.valueOf(voiceState.getUserId()));
                this.maxVoiceStateCount = Math.max(this.maxVoiceStateCount, this.currentVoiceStateUsers.size());
                if (voiceState.getDeaf() || voiceState.getSelfDeaf()) {
                    this.currentPotentialListeners.remove(Long.valueOf(voiceState.getUserId()));
                    return;
                }
                this.currentPotentialListeners.add(Long.valueOf(voiceState.getUserId()));
                if (this.localUserSpeaking) {
                    this.allListenerUsers.add(Long.valueOf(voiceState.getUserId()));
                    this.maxListenerCount = Math.max(this.maxListenerCount, this.currentPotentialListeners.size());
                }
            }
        }
    }
}
