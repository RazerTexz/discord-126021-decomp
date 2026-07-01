package com.discord.widgets.voice.model;

import a0.a.a.b;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallModel$Companion$Chunk {
    private final StoreAudioManagerV2$State audioManagerState;
    private final Channel channel;
    private final Long channelPermissions;
    private final long myUserId;
    private final VideoInputDeviceDescription selectedVideoDevice;
    private final long timeConnectedMs;
    private final List<VideoInputDeviceDescription> videoDevices;
    private final StoreMediaSettings$VoiceConfiguration voiceConfig;
    private final Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants;

    public CallModel$Companion$Chunk(Channel channel, long j, long j2, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map<Long, StoreVoiceParticipants$VoiceUser> map, Long l, List<VideoInputDeviceDescription> list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2$State storeAudioManagerV2$State) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(storeMediaSettings$VoiceConfiguration, "voiceConfig");
        m.checkNotNullParameter(map, "voiceParticipants");
        m.checkNotNullParameter(list, "videoDevices");
        m.checkNotNullParameter(storeAudioManagerV2$State, "audioManagerState");
        this.channel = channel;
        this.myUserId = j;
        this.timeConnectedMs = j2;
        this.voiceConfig = storeMediaSettings$VoiceConfiguration;
        this.voiceParticipants = map;
        this.channelPermissions = l;
        this.videoDevices = list;
        this.selectedVideoDevice = videoInputDeviceDescription;
        this.audioManagerState = storeAudioManagerV2$State;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallModel$Companion$Chunk copy$default(CallModel$Companion$Chunk callModel$Companion$Chunk, Channel channel, long j, long j2, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map map, Long l, List list, VideoInputDeviceDescription videoInputDeviceDescription, StoreAudioManagerV2$State storeAudioManagerV2$State, int i, Object obj) {
        return callModel$Companion$Chunk.copy((i & 1) != 0 ? callModel$Companion$Chunk.channel : channel, (i & 2) != 0 ? callModel$Companion$Chunk.myUserId : j, (i & 4) != 0 ? callModel$Companion$Chunk.timeConnectedMs : j2, (i & 8) != 0 ? callModel$Companion$Chunk.voiceConfig : storeMediaSettings$VoiceConfiguration, (i & 16) != 0 ? callModel$Companion$Chunk.voiceParticipants : map, (i & 32) != 0 ? callModel$Companion$Chunk.channelPermissions : l, (i & 64) != 0 ? callModel$Companion$Chunk.videoDevices : list, (i & 128) != 0 ? callModel$Companion$Chunk.selectedVideoDevice : videoInputDeviceDescription, (i & 256) != 0 ? callModel$Companion$Chunk.audioManagerState : storeAudioManagerV2$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreMediaSettings$VoiceConfiguration getVoiceConfig() {
        return this.voiceConfig;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> component5() {
        return this.voiceParticipants;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final List<VideoInputDeviceDescription> component7() {
        return this.videoDevices;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final VideoInputDeviceDescription getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final CallModel$Companion$Chunk copy(Channel channel, long myUserId, long timeConnectedMs, StoreMediaSettings$VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, Long channelPermissions, List<VideoInputDeviceDescription> videoDevices, VideoInputDeviceDescription selectedVideoDevice, StoreAudioManagerV2$State audioManagerState) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(voiceConfig, "voiceConfig");
        m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(videoDevices, "videoDevices");
        m.checkNotNullParameter(audioManagerState, "audioManagerState");
        return new CallModel$Companion$Chunk(channel, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, selectedVideoDevice, audioManagerState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallModel$Companion$Chunk)) {
            return false;
        }
        CallModel$Companion$Chunk callModel$Companion$Chunk = (CallModel$Companion$Chunk) other;
        return m.areEqual(this.channel, callModel$Companion$Chunk.channel) && this.myUserId == callModel$Companion$Chunk.myUserId && this.timeConnectedMs == callModel$Companion$Chunk.timeConnectedMs && m.areEqual(this.voiceConfig, callModel$Companion$Chunk.voiceConfig) && m.areEqual(this.voiceParticipants, callModel$Companion$Chunk.voiceParticipants) && m.areEqual(this.channelPermissions, callModel$Companion$Chunk.channelPermissions) && m.areEqual(this.videoDevices, callModel$Companion$Chunk.videoDevices) && m.areEqual(this.selectedVideoDevice, callModel$Companion$Chunk.selectedVideoDevice) && m.areEqual(this.audioManagerState, callModel$Companion$Chunk.audioManagerState);
    }

    public final StoreAudioManagerV2$State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final VideoInputDeviceDescription getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<VideoInputDeviceDescription> getVideoDevices() {
        return this.videoDevices;
    }

    public final StoreMediaSettings$VoiceConfiguration getVoiceConfig() {
        return this.voiceConfig;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> getVoiceParticipants() {
        return this.voiceParticipants;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iA = (b.a(this.timeConnectedMs) + ((b.a(this.myUserId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31)) * 31;
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfig;
        int iHashCode = (iA + (storeMediaSettings$VoiceConfiguration != null ? storeMediaSettings$VoiceConfiguration.hashCode() : 0)) * 31;
        Map<Long, StoreVoiceParticipants$VoiceUser> map = this.voiceParticipants;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Long l = this.channelPermissions;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        List<VideoInputDeviceDescription> list = this.videoDevices;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoDevice;
        int iHashCode5 = (iHashCode4 + (videoInputDeviceDescription != null ? videoInputDeviceDescription.hashCode() : 0)) * 31;
        StoreAudioManagerV2$State storeAudioManagerV2$State = this.audioManagerState;
        return iHashCode5 + (storeAudioManagerV2$State != null ? storeAudioManagerV2$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Chunk(channel=");
        sbU.append(this.channel);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", timeConnectedMs=");
        sbU.append(this.timeConnectedMs);
        sbU.append(", voiceConfig=");
        sbU.append(this.voiceConfig);
        sbU.append(", voiceParticipants=");
        sbU.append(this.voiceParticipants);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", videoDevices=");
        sbU.append(this.videoDevices);
        sbU.append(", selectedVideoDevice=");
        sbU.append(this.selectedVideoDevice);
        sbU.append(", audioManagerState=");
        sbU.append(this.audioManagerState);
        sbU.append(")");
        return sbU.toString();
    }
}
