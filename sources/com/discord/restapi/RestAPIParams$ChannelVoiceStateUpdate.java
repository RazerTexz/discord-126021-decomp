package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$ChannelVoiceStateUpdate {
    private final long channelId;
    private final UtcDateTime requestToSpeakTimestamp;
    private final Boolean suppress;

    public RestAPIParams$ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime) {
        this.channelId = j;
        this.suppress = bool;
        this.requestToSpeakTimestamp = utcDateTime;
    }

    public static /* synthetic */ RestAPIParams$ChannelVoiceStateUpdate copy$default(RestAPIParams$ChannelVoiceStateUpdate restAPIParams$ChannelVoiceStateUpdate, long j, Boolean bool, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            j = restAPIParams$ChannelVoiceStateUpdate.channelId;
        }
        if ((i & 2) != 0) {
            bool = restAPIParams$ChannelVoiceStateUpdate.suppress;
        }
        if ((i & 4) != 0) {
            utcDateTime = restAPIParams$ChannelVoiceStateUpdate.requestToSpeakTimestamp;
        }
        return restAPIParams$ChannelVoiceStateUpdate.copy(j, bool, utcDateTime);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getSuppress() {
        return this.suppress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    public final RestAPIParams$ChannelVoiceStateUpdate copy(long channelId, Boolean suppress, UtcDateTime requestToSpeakTimestamp) {
        return new RestAPIParams$ChannelVoiceStateUpdate(channelId, suppress, requestToSpeakTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$ChannelVoiceStateUpdate)) {
            return false;
        }
        RestAPIParams$ChannelVoiceStateUpdate restAPIParams$ChannelVoiceStateUpdate = (RestAPIParams$ChannelVoiceStateUpdate) other;
        return this.channelId == restAPIParams$ChannelVoiceStateUpdate.channelId && m.areEqual(this.suppress, restAPIParams$ChannelVoiceStateUpdate.suppress) && m.areEqual(this.requestToSpeakTimestamp, restAPIParams$ChannelVoiceStateUpdate.requestToSpeakTimestamp);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final UtcDateTime getRequestToSpeakTimestamp() {
        return this.requestToSpeakTimestamp;
    }

    public final Boolean getSuppress() {
        return this.suppress;
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Boolean bool = this.suppress;
        int iHashCode = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
        return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelVoiceStateUpdate(channelId=");
        sbU.append(this.channelId);
        sbU.append(", suppress=");
        sbU.append(this.suppress);
        sbU.append(", requestToSpeakTimestamp=");
        sbU.append(this.requestToSpeakTimestamp);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ RestAPIParams$ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : utcDateTime);
    }
}
