package com.discord.widgets.voice.feedback.call;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallFeedbackSheetViewModel$Config implements Parcelable {
    public static final CallFeedbackSheetViewModel$Config$CREATOR CREATOR = new CallFeedbackSheetViewModel$Config$CREATOR(null);
    private final Long callDurationMs;
    private final long channelId;
    private final String mediaSessionId;
    private final String rtcConnectionId;

    public CallFeedbackSheetViewModel$Config(long j, String str, String str2, Long l) {
        this.channelId = j;
        this.rtcConnectionId = str;
        this.mediaSessionId = str2;
        this.callDurationMs = l;
    }

    public static /* synthetic */ CallFeedbackSheetViewModel$Config copy$default(CallFeedbackSheetViewModel$Config callFeedbackSheetViewModel$Config, long j, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = callFeedbackSheetViewModel$Config.channelId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = callFeedbackSheetViewModel$Config.rtcConnectionId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = callFeedbackSheetViewModel$Config.mediaSessionId;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            l = callFeedbackSheetViewModel$Config.callDurationMs;
        }
        return callFeedbackSheetViewModel$Config.copy(j2, str3, str4, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getCallDurationMs() {
        return this.callDurationMs;
    }

    public final CallFeedbackSheetViewModel$Config copy(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
        return new CallFeedbackSheetViewModel$Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallFeedbackSheetViewModel$Config)) {
            return false;
        }
        CallFeedbackSheetViewModel$Config callFeedbackSheetViewModel$Config = (CallFeedbackSheetViewModel$Config) other;
        return this.channelId == callFeedbackSheetViewModel$Config.channelId && m.areEqual(this.rtcConnectionId, callFeedbackSheetViewModel$Config.rtcConnectionId) && m.areEqual(this.mediaSessionId, callFeedbackSheetViewModel$Config.mediaSessionId) && m.areEqual(this.callDurationMs, callFeedbackSheetViewModel$Config.callDurationMs);
    }

    public final Long getCallDurationMs() {
        return this.callDurationMs;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.rtcConnectionId;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mediaSessionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.callDurationMs;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Config(channelId=");
        sbU.append(this.channelId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", callDurationMs=");
        return a.G(sbU, this.callDurationMs, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.channelId);
        parcel.writeString(this.rtcConnectionId);
        parcel.writeString(this.mediaSessionId);
        parcel.writeValue(this.callDurationMs);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CallFeedbackSheetViewModel$Config(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcel");
        long j = parcel.readLong();
        String string = parcel.readString();
        String string2 = parcel.readString();
        Object value = parcel.readValue(Long.TYPE.getClassLoader());
        this(j, string, string2, (Long) (value instanceof Long ? value : null));
    }
}
