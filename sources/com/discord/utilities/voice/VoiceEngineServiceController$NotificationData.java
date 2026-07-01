package com.discord.utilities.voice;

import a0.a.a.b;
import androidx.annotation.StringRes;
import b.d.b.a.a;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$a;
import com.discord.rtcconnection.RtcConnection$State$b;
import com.discord.rtcconnection.RtcConnection$State$c;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$e;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$State$g;
import com.discord.rtcconnection.RtcConnection$State$h;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class VoiceEngineServiceController$NotificationData {
    private final boolean canSpeak;
    private final long channelId;
    private final String channelName;
    private final Long guildId;
    private final boolean isSelfDeafened;
    private final boolean isSelfMuted;
    private final boolean isSelfStreaming;
    private final boolean isVideo;
    private final boolean proximityLockEnabled;
    private final RtcConnection$State rtcConnectionState;

    @StringRes
    private final int stateString;

    public VoiceEngineServiceController$NotificationData(RtcConnection$State rtcConnection$State, String str, boolean z2, boolean z3, boolean z4, boolean z5, long j, Long l, boolean z6, boolean z7) {
        int i;
        m.checkNotNullParameter(rtcConnection$State, "rtcConnectionState");
        m.checkNotNullParameter(str, "channelName");
        this.rtcConnectionState = rtcConnection$State;
        this.channelName = str;
        this.isSelfMuted = z2;
        this.isSelfDeafened = z3;
        this.isSelfStreaming = z4;
        this.isVideo = z5;
        this.channelId = j;
        this.guildId = l;
        this.proximityLockEnabled = z6;
        this.canSpeak = z7;
        if (rtcConnection$State instanceof RtcConnection$State$d) {
            i = 2131887862;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$b.a)) {
            i = 2131887860;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$a.a)) {
            i = 2131887859;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$c.a)) {
            i = 2131887861;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$h.a)) {
            i = 2131887866;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$g.a)) {
            i = 2131887865;
        } else if (m.areEqual(rtcConnection$State, RtcConnection$State$f.a)) {
            i = z4 ? 2131887868 : z5 ? 2131887869 : 2131887870;
        } else {
            if (!m.areEqual(rtcConnection$State, RtcConnection$State$e.a)) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131887864;
        }
        this.stateString = i;
    }

    public static /* synthetic */ VoiceEngineServiceController$NotificationData copy$default(VoiceEngineServiceController$NotificationData voiceEngineServiceController$NotificationData, RtcConnection$State rtcConnection$State, String str, boolean z2, boolean z3, boolean z4, boolean z5, long j, Long l, boolean z6, boolean z7, int i, Object obj) {
        return voiceEngineServiceController$NotificationData.copy((i & 1) != 0 ? voiceEngineServiceController$NotificationData.rtcConnectionState : rtcConnection$State, (i & 2) != 0 ? voiceEngineServiceController$NotificationData.channelName : str, (i & 4) != 0 ? voiceEngineServiceController$NotificationData.isSelfMuted : z2, (i & 8) != 0 ? voiceEngineServiceController$NotificationData.isSelfDeafened : z3, (i & 16) != 0 ? voiceEngineServiceController$NotificationData.isSelfStreaming : z4, (i & 32) != 0 ? voiceEngineServiceController$NotificationData.isVideo : z5, (i & 64) != 0 ? voiceEngineServiceController$NotificationData.channelId : j, (i & 128) != 0 ? voiceEngineServiceController$NotificationData.guildId : l, (i & 256) != 0 ? voiceEngineServiceController$NotificationData.proximityLockEnabled : z6, (i & 512) != 0 ? voiceEngineServiceController$NotificationData.canSpeak : z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanSpeak() {
        return this.canSpeak;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelfMuted() {
        return this.isSelfMuted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelfDeafened() {
        return this.isSelfDeafened;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSelfStreaming() {
        return this.isSelfStreaming;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getProximityLockEnabled() {
        return this.proximityLockEnabled;
    }

    public final VoiceEngineServiceController$NotificationData copy(RtcConnection$State rtcConnectionState, String channelName, boolean isSelfMuted, boolean isSelfDeafened, boolean isSelfStreaming, boolean isVideo, long channelId, Long guildId, boolean proximityLockEnabled, boolean canSpeak) {
        m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
        m.checkNotNullParameter(channelName, "channelName");
        return new VoiceEngineServiceController$NotificationData(rtcConnectionState, channelName, isSelfMuted, isSelfDeafened, isSelfStreaming, isVideo, channelId, guildId, proximityLockEnabled, canSpeak);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceEngineServiceController$NotificationData)) {
            return false;
        }
        VoiceEngineServiceController$NotificationData voiceEngineServiceController$NotificationData = (VoiceEngineServiceController$NotificationData) other;
        return m.areEqual(this.rtcConnectionState, voiceEngineServiceController$NotificationData.rtcConnectionState) && m.areEqual(this.channelName, voiceEngineServiceController$NotificationData.channelName) && this.isSelfMuted == voiceEngineServiceController$NotificationData.isSelfMuted && this.isSelfDeafened == voiceEngineServiceController$NotificationData.isSelfDeafened && this.isSelfStreaming == voiceEngineServiceController$NotificationData.isSelfStreaming && this.isVideo == voiceEngineServiceController$NotificationData.isVideo && this.channelId == voiceEngineServiceController$NotificationData.channelId && m.areEqual(this.guildId, voiceEngineServiceController$NotificationData.guildId) && this.proximityLockEnabled == voiceEngineServiceController$NotificationData.proximityLockEnabled && this.canSpeak == voiceEngineServiceController$NotificationData.canSpeak;
    }

    public final boolean getCanSpeak() {
        return this.canSpeak;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getProximityLockEnabled() {
        return this.proximityLockEnabled;
    }

    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    public final int getStateString() {
        return this.stateString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        RtcConnection$State rtcConnection$State = this.rtcConnectionState;
        int iHashCode = (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0) * 31;
        String str = this.channelName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isSelfMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.isSelfDeafened;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isSelfStreaming;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.isVideo;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int iA = (b.a(this.channelId) + ((i3 + r5) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode3 = (iA + (l != null ? l.hashCode() : 0)) * 31;
        boolean z6 = this.proximityLockEnabled;
        ?? r0 = z6;
        if (z6) {
            r0 = 1;
        }
        int i4 = (iHashCode3 + r0) * 31;
        boolean z7 = this.canSpeak;
        return i4 + (z7 ? 1 : z7);
    }

    public final boolean isSelfDeafened() {
        return this.isSelfDeafened;
    }

    public final boolean isSelfMuted() {
        return this.isSelfMuted;
    }

    public final boolean isSelfStreaming() {
        return this.isSelfStreaming;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public String toString() {
        StringBuilder sbU = a.U("NotificationData(rtcConnectionState=");
        sbU.append(this.rtcConnectionState);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", isSelfMuted=");
        sbU.append(this.isSelfMuted);
        sbU.append(", isSelfDeafened=");
        sbU.append(this.isSelfDeafened);
        sbU.append(", isSelfStreaming=");
        sbU.append(this.isSelfStreaming);
        sbU.append(", isVideo=");
        sbU.append(this.isVideo);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", proximityLockEnabled=");
        sbU.append(this.proximityLockEnabled);
        sbU.append(", canSpeak=");
        return a.O(sbU, this.canSpeak, ")");
    }
}
