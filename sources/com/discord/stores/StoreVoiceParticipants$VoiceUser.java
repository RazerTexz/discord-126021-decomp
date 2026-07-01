package com.discord.stores;

import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreVoiceParticipants$VoiceUser {
    private final boolean _isSpeaking;
    private final ModelApplicationStream applicationStream;
    private final Integer applicationStreamId;
    private final Integer callStreamId;
    private final GuildMember guildMember;
    private final boolean isBooster;
    private final boolean isDeafened;
    private final boolean isInvitedToSpeak;
    private final boolean isMe;
    private final boolean isMuted;
    private final boolean isRequestingToSpeak;
    private final boolean isRinging;
    private final boolean isSelfDeafened;
    private final boolean isSelfMuted;
    private final boolean isServerDeafened;
    private final boolean isServerMuted;
    private final boolean isSpeaking;
    private final String nickname;
    private final StreamContext streamContext;
    private final StoreVideoStreams$UserStreams streams;
    private final User user;
    private final StoreMediaSettings$VoiceConfiguration voiceConfiguration;
    private final VoiceState voiceState;
    private final String watchingStream;

    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    public StoreVoiceParticipants$VoiceUser(User user, VoiceState voiceState, boolean z2, StoreVideoStreams$UserStreams storeVideoStreams$UserStreams, boolean z3, GuildMember guildMember, String str, StreamContext streamContext, boolean z4, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, boolean z5) {
        boolean selfMute;
        boolean selfDeaf;
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.voiceState = voiceState;
        this.isRinging = z2;
        this.streams = storeVideoStreams$UserStreams;
        this.isMe = z3;
        this.guildMember = guildMember;
        this.watchingStream = str;
        this.streamContext = streamContext;
        this.isBooster = z4;
        this.voiceConfiguration = storeMediaSettings$VoiceConfiguration;
        this._isSpeaking = z5;
        this.isSpeaking = (voiceState == null || !z5 || voiceState.getMute() || voiceState.getDeaf()) ? false : true;
        this.nickname = guildMember != null ? guildMember.getNick() : null;
        this.callStreamId = storeVideoStreams$UserStreams != null ? storeVideoStreams$UserStreams.getCallStreamId() : null;
        this.applicationStreamId = storeVideoStreams$UserStreams != null ? storeVideoStreams$UserStreams.getApplicationStreamId() : null;
        this.applicationStream = streamContext != null ? streamContext.getStream() : null;
        boolean mute = voiceState != null ? voiceState.getMute() : false;
        this.isServerMuted = mute;
        if (z3) {
            if (storeMediaSettings$VoiceConfiguration != null) {
                selfMute = storeMediaSettings$VoiceConfiguration.isSelfMuted();
            } else {
                selfMute = false;
            }
        } else if (voiceState != null) {
            selfMute = voiceState.getSelfMute();
        } else {
            selfMute = false;
        }
        this.isSelfMuted = selfMute;
        this.isMuted = mute || selfMute;
        boolean deaf = voiceState != null ? voiceState.getDeaf() : false;
        this.isServerDeafened = deaf;
        if (z3) {
            if (storeMediaSettings$VoiceConfiguration != null) {
                selfDeaf = storeMediaSettings$VoiceConfiguration.isSelfDeafened();
            } else {
                selfDeaf = false;
            }
        } else if (voiceState != null) {
            selfDeaf = voiceState.getSelfDeaf();
        } else {
            selfDeaf = false;
        }
        this.isSelfDeafened = selfDeaf;
        this.isDeafened = deaf || selfDeaf;
        this.isRequestingToSpeak = d.y0(voiceState).getIsRequestingToSpeak();
        this.isInvitedToSpeak = d.y0(voiceState) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final StoreMediaSettings$VoiceConfiguration getVoiceConfiguration() {
        return this.voiceConfiguration;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    private final boolean get_isSpeaking() {
        return this._isSpeaking;
    }

    public static /* synthetic */ StoreVoiceParticipants$VoiceUser copy$default(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, User user, VoiceState voiceState, boolean z2, StoreVideoStreams$UserStreams storeVideoStreams$UserStreams, boolean z3, GuildMember guildMember, String str, StreamContext streamContext, boolean z4, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, boolean z5, int i, Object obj) {
        return storeVoiceParticipants$VoiceUser.copy((i & 1) != 0 ? storeVoiceParticipants$VoiceUser.user : user, (i & 2) != 0 ? storeVoiceParticipants$VoiceUser.voiceState : voiceState, (i & 4) != 0 ? storeVoiceParticipants$VoiceUser.isRinging : z2, (i & 8) != 0 ? storeVoiceParticipants$VoiceUser.streams : storeVideoStreams$UserStreams, (i & 16) != 0 ? storeVoiceParticipants$VoiceUser.isMe : z3, (i & 32) != 0 ? storeVoiceParticipants$VoiceUser.guildMember : guildMember, (i & 64) != 0 ? storeVoiceParticipants$VoiceUser.watchingStream : str, (i & 128) != 0 ? storeVoiceParticipants$VoiceUser.streamContext : streamContext, (i & 256) != 0 ? storeVoiceParticipants$VoiceUser.isBooster : z4, (i & 512) != 0 ? storeVoiceParticipants$VoiceUser.voiceConfiguration : storeMediaSettings$VoiceConfiguration, (i & 1024) != 0 ? storeVoiceParticipants$VoiceUser._isSpeaking : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRinging() {
        return this.isRinging;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreVideoStreams$UserStreams getStreams() {
        return this.streams;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getWatchingStream() {
        return this.watchingStream;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsBooster() {
        return this.isBooster;
    }

    public final StoreVoiceParticipants$VoiceUser copy(User user, VoiceState voiceState, boolean isRinging, StoreVideoStreams$UserStreams streams, boolean isMe, GuildMember guildMember, String watchingStream, StreamContext streamContext, boolean isBooster, StoreMediaSettings$VoiceConfiguration voiceConfiguration, boolean _isSpeaking) {
        m.checkNotNullParameter(user, "user");
        return new StoreVoiceParticipants$VoiceUser(user, voiceState, isRinging, streams, isMe, guildMember, watchingStream, streamContext, isBooster, voiceConfiguration, _isSpeaking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreVoiceParticipants$VoiceUser)) {
            return false;
        }
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = (StoreVoiceParticipants$VoiceUser) other;
        return m.areEqual(this.user, storeVoiceParticipants$VoiceUser.user) && m.areEqual(this.voiceState, storeVoiceParticipants$VoiceUser.voiceState) && this.isRinging == storeVoiceParticipants$VoiceUser.isRinging && m.areEqual(this.streams, storeVoiceParticipants$VoiceUser.streams) && this.isMe == storeVoiceParticipants$VoiceUser.isMe && m.areEqual(this.guildMember, storeVoiceParticipants$VoiceUser.guildMember) && m.areEqual(this.watchingStream, storeVoiceParticipants$VoiceUser.watchingStream) && m.areEqual(this.streamContext, storeVoiceParticipants$VoiceUser.streamContext) && this.isBooster == storeVoiceParticipants$VoiceUser.isBooster && m.areEqual(this.voiceConfiguration, storeVoiceParticipants$VoiceUser.voiceConfiguration) && this._isSpeaking == storeVoiceParticipants$VoiceUser._isSpeaking;
    }

    public final ModelApplicationStream getApplicationStream() {
        return this.applicationStream;
    }

    public final Integer getApplicationStreamId() {
        return this.applicationStreamId;
    }

    public final Integer getCallStreamId() {
        return this.callStreamId;
    }

    public final String getDisplayName() {
        String str = this.nickname;
        return str != null ? str : this.user.getUsername();
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final StoreVideoStreams$UserStreams getStreams() {
        return this.streams;
    }

    public final User getUser() {
        return this.user;
    }

    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    public final String getWatchingStream() {
        return this.watchingStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        VoiceState voiceState = this.voiceState;
        int iHashCode2 = (iHashCode + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
        boolean z2 = this.isRinging;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        StoreVideoStreams$UserStreams storeVideoStreams$UserStreams = this.streams;
        int iHashCode3 = (i + (storeVideoStreams$UserStreams != null ? storeVideoStreams$UserStreams.hashCode() : 0)) * 31;
        boolean z3 = this.isMe;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode3 + r3) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode4 = (i2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str = this.watchingStream;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        boolean z4 = this.isBooster;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode6 + r4) * 31;
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        int iHashCode7 = (i3 + (storeMediaSettings$VoiceConfiguration != null ? storeMediaSettings$VoiceConfiguration.hashCode() : 0)) * 31;
        boolean z5 = this._isSpeaking;
        return iHashCode7 + (z5 ? 1 : z5);
    }

    public final boolean isBooster() {
        return this.isBooster;
    }

    public final boolean isConnected() {
        return this.voiceState != null;
    }

    /* JADX INFO: renamed from: isDeafened, reason: from getter */
    public final boolean getIsDeafened() {
        return this.isDeafened;
    }

    /* JADX INFO: renamed from: isInvitedToSpeak, reason: from getter */
    public final boolean getIsInvitedToSpeak() {
        return this.isInvitedToSpeak;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: isMuted, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: isRequestingToSpeak, reason: from getter */
    public final boolean getIsRequestingToSpeak() {
        return this.isRequestingToSpeak;
    }

    public final boolean isRinging() {
        return this.isRinging;
    }

    /* JADX INFO: renamed from: isSpeaking, reason: from getter */
    public final boolean getIsSpeaking() {
        return this.isSpeaking;
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceUser(user=");
        sbU.append(this.user);
        sbU.append(", voiceState=");
        sbU.append(this.voiceState);
        sbU.append(", isRinging=");
        sbU.append(this.isRinging);
        sbU.append(", streams=");
        sbU.append(this.streams);
        sbU.append(", isMe=");
        sbU.append(this.isMe);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", watchingStream=");
        sbU.append(this.watchingStream);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", isBooster=");
        sbU.append(this.isBooster);
        sbU.append(", voiceConfiguration=");
        sbU.append(this.voiceConfiguration);
        sbU.append(", _isSpeaking=");
        return a.O(sbU, this._isSpeaking, ")");
    }
}
