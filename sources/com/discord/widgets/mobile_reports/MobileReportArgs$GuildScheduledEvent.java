package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.report.ReportType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportArgs$GuildScheduledEvent extends MobileReportArgs {
    public static final Parcelable$Creator<MobileReportArgs$GuildScheduledEvent> CREATOR = new MobileReportArgs$GuildScheduledEvent$Creator();
    private final long eventId;
    private final long guildId;

    public MobileReportArgs$GuildScheduledEvent(long j, long j2) {
        super(ReportType.GuildScheduledEvent, -1L, null);
        this.guildId = j;
        this.eventId = j2;
    }

    public static /* synthetic */ MobileReportArgs$GuildScheduledEvent copy$default(MobileReportArgs$GuildScheduledEvent mobileReportArgs$GuildScheduledEvent, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mobileReportArgs$GuildScheduledEvent.guildId;
        }
        if ((i & 2) != 0) {
            j2 = mobileReportArgs$GuildScheduledEvent.eventId;
        }
        return mobileReportArgs$GuildScheduledEvent.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEventId() {
        return this.eventId;
    }

    public final MobileReportArgs$GuildScheduledEvent copy(long guildId, long eventId) {
        return new MobileReportArgs$GuildScheduledEvent(guildId, eventId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportArgs$GuildScheduledEvent)) {
            return false;
        }
        MobileReportArgs$GuildScheduledEvent mobileReportArgs$GuildScheduledEvent = (MobileReportArgs$GuildScheduledEvent) other;
        return this.guildId == mobileReportArgs$GuildScheduledEvent.guildId && this.eventId == mobileReportArgs$GuildScheduledEvent.eventId;
    }

    public final long getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.eventId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEvent(guildId=");
        sbU.append(this.guildId);
        sbU.append(", eventId=");
        return a.C(sbU, this.eventId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.eventId);
    }
}
