package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.report.ReportType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportArgs$DirectoryServer extends MobileReportArgs {
    public static final Parcelable$Creator<MobileReportArgs$DirectoryServer> CREATOR = new MobileReportArgs$DirectoryServer$Creator();
    private final long channelId;
    private final long guildId;
    private final long hubId;

    public MobileReportArgs$DirectoryServer(long j, long j2, long j3) {
        super(ReportType.DirectoryServer, j3, null);
        this.guildId = j;
        this.hubId = j2;
        this.channelId = j3;
    }

    public static /* synthetic */ MobileReportArgs$DirectoryServer copy$default(MobileReportArgs$DirectoryServer mobileReportArgs$DirectoryServer, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mobileReportArgs$DirectoryServer.guildId;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = mobileReportArgs$DirectoryServer.hubId;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = mobileReportArgs$DirectoryServer.getChannelId();
        }
        return mobileReportArgs$DirectoryServer.copy(j4, j5, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getHubId() {
        return this.hubId;
    }

    public final long component3() {
        return getChannelId();
    }

    public final MobileReportArgs$DirectoryServer copy(long guildId, long hubId, long channelId) {
        return new MobileReportArgs$DirectoryServer(guildId, hubId, channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportArgs$DirectoryServer)) {
            return false;
        }
        MobileReportArgs$DirectoryServer mobileReportArgs$DirectoryServer = (MobileReportArgs$DirectoryServer) other;
        return this.guildId == mobileReportArgs$DirectoryServer.guildId && this.hubId == mobileReportArgs$DirectoryServer.hubId && getChannelId() == mobileReportArgs$DirectoryServer.getChannelId();
    }

    @Override // com.discord.widgets.mobile_reports.MobileReportArgs
    public long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getHubId() {
        return this.hubId;
    }

    public int hashCode() {
        return b.a(getChannelId()) + ((b.a(this.hubId) + (b.a(this.guildId) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryServer(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubId=");
        sbU.append(this.hubId);
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.hubId);
        parcel.writeLong(this.channelId);
    }
}
