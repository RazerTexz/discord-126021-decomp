package com.discord.utilities.voice;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CallSoundManager$StoreState {
    private final StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream;
    private final MeUser me;
    private final RtcConnection$State rtcConnectionState;
    private final Channel selectedVoiceChannel;
    private final Map<String, List<Long>> streamSpectators;
    private final Map<Long, ModelApplicationStream> streamsByUser;
    private final Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants;

    /* JADX WARN: Multi-variable type inference failed */
    public CallSoundManager$StoreState(Map<Long, StoreVoiceParticipants$VoiceUser> map, RtcConnection$State rtcConnection$State, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, MeUser meUser, Channel channel) {
        m.checkNotNullParameter(map, "voiceParticipants");
        m.checkNotNullParameter(rtcConnection$State, "rtcConnectionState");
        m.checkNotNullParameter(map2, "streamsByUser");
        m.checkNotNullParameter(map3, "streamSpectators");
        m.checkNotNullParameter(meUser, "me");
        this.voiceParticipants = map;
        this.rtcConnectionState = rtcConnection$State;
        this.streamsByUser = map2;
        this.streamSpectators = map3;
        this.activeApplicationStream = storeApplicationStreaming$ActiveApplicationStream;
        this.me = meUser;
        this.selectedVoiceChannel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallSoundManager$StoreState copy$default(CallSoundManager$StoreState callSoundManager$StoreState, Map map, RtcConnection$State rtcConnection$State, Map map2, Map map3, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, MeUser meUser, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            map = callSoundManager$StoreState.voiceParticipants;
        }
        if ((i & 2) != 0) {
            rtcConnection$State = callSoundManager$StoreState.rtcConnectionState;
        }
        RtcConnection$State rtcConnection$State2 = rtcConnection$State;
        if ((i & 4) != 0) {
            map2 = callSoundManager$StoreState.streamsByUser;
        }
        Map map4 = map2;
        if ((i & 8) != 0) {
            map3 = callSoundManager$StoreState.streamSpectators;
        }
        Map map5 = map3;
        if ((i & 16) != 0) {
            storeApplicationStreaming$ActiveApplicationStream = callSoundManager$StoreState.activeApplicationStream;
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream2 = storeApplicationStreaming$ActiveApplicationStream;
        if ((i & 32) != 0) {
            meUser = callSoundManager$StoreState.me;
        }
        MeUser meUser2 = meUser;
        if ((i & 64) != 0) {
            channel = callSoundManager$StoreState.selectedVoiceChannel;
        }
        return callSoundManager$StoreState.copy(map, rtcConnection$State2, map4, map5, storeApplicationStreaming$ActiveApplicationStream2, meUser2, channel);
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> component1() {
        return this.voiceParticipants;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    public final Map<Long, ModelApplicationStream> component3() {
        return this.streamsByUser;
    }

    public final Map<String, List<Long>> component4() {
        return this.streamSpectators;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StoreApplicationStreaming$ActiveApplicationStream getActiveApplicationStream() {
        return this.activeApplicationStream;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final CallSoundManager$StoreState copy(Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, RtcConnection$State rtcConnectionState, Map<Long, ? extends ModelApplicationStream> streamsByUser, Map<String, ? extends List<Long>> streamSpectators, StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream, MeUser me2, Channel selectedVoiceChannel) {
        m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
        m.checkNotNullParameter(streamsByUser, "streamsByUser");
        m.checkNotNullParameter(streamSpectators, "streamSpectators");
        m.checkNotNullParameter(me2, "me");
        return new CallSoundManager$StoreState(voiceParticipants, rtcConnectionState, streamsByUser, streamSpectators, activeApplicationStream, me2, selectedVoiceChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallSoundManager$StoreState)) {
            return false;
        }
        CallSoundManager$StoreState callSoundManager$StoreState = (CallSoundManager$StoreState) other;
        return m.areEqual(this.voiceParticipants, callSoundManager$StoreState.voiceParticipants) && m.areEqual(this.rtcConnectionState, callSoundManager$StoreState.rtcConnectionState) && m.areEqual(this.streamsByUser, callSoundManager$StoreState.streamsByUser) && m.areEqual(this.streamSpectators, callSoundManager$StoreState.streamSpectators) && m.areEqual(this.activeApplicationStream, callSoundManager$StoreState.activeApplicationStream) && m.areEqual(this.me, callSoundManager$StoreState.me) && m.areEqual(this.selectedVoiceChannel, callSoundManager$StoreState.selectedVoiceChannel);
    }

    public final StoreApplicationStreaming$ActiveApplicationStream getActiveApplicationStream() {
        return this.activeApplicationStream;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final Map<String, List<Long>> getStreamSpectators() {
        return this.streamSpectators;
    }

    public final Map<Long, ModelApplicationStream> getStreamsByUser() {
        return this.streamsByUser;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> getVoiceParticipants() {
        return this.voiceParticipants;
    }

    public int hashCode() {
        Map<Long, StoreVoiceParticipants$VoiceUser> map = this.voiceParticipants;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        RtcConnection$State rtcConnection$State = this.rtcConnectionState;
        int iHashCode2 = (iHashCode + (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map2 = this.streamsByUser;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, List<Long>> map3 = this.streamSpectators;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        int iHashCode5 = (iHashCode4 + (storeApplicationStreaming$ActiveApplicationStream != null ? storeApplicationStreaming$ActiveApplicationStream.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode6 = (iHashCode5 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Channel channel = this.selectedVoiceChannel;
        return iHashCode6 + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(voiceParticipants=");
        sbU.append(this.voiceParticipants);
        sbU.append(", rtcConnectionState=");
        sbU.append(this.rtcConnectionState);
        sbU.append(", streamsByUser=");
        sbU.append(this.streamsByUser);
        sbU.append(", streamSpectators=");
        sbU.append(this.streamSpectators);
        sbU.append(", activeApplicationStream=");
        sbU.append(this.activeApplicationStream);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
