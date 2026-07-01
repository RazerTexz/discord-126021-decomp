package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetMemberVerificationViewModel$Event$Success extends WidgetMemberVerificationViewModel$Event {
    private final ApplicationStatus applicationStatus;
    private final Long guildId;
    private final String guildName;
    private final String lastSeen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel$Event$Success(Long l, String str, ApplicationStatus applicationStatus, String str2) {
        super(null);
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        this.guildId = l;
        this.guildName = str;
        this.applicationStatus = applicationStatus;
        this.lastSeen = str2;
    }

    public static /* synthetic */ WidgetMemberVerificationViewModel$Event$Success copy$default(WidgetMemberVerificationViewModel$Event$Success widgetMemberVerificationViewModel$Event$Success, Long l, String str, ApplicationStatus applicationStatus, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetMemberVerificationViewModel$Event$Success.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetMemberVerificationViewModel$Event$Success.guildName;
        }
        if ((i & 4) != 0) {
            applicationStatus = widgetMemberVerificationViewModel$Event$Success.applicationStatus;
        }
        if ((i & 8) != 0) {
            str2 = widgetMemberVerificationViewModel$Event$Success.lastSeen;
        }
        return widgetMemberVerificationViewModel$Event$Success.copy(l, str, applicationStatus, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    public final WidgetMemberVerificationViewModel$Event$Success copy(Long guildId, String guildName, ApplicationStatus applicationStatus, String lastSeen) {
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        return new WidgetMemberVerificationViewModel$Event$Success(guildId, guildName, applicationStatus, lastSeen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetMemberVerificationViewModel$Event$Success)) {
            return false;
        }
        WidgetMemberVerificationViewModel$Event$Success widgetMemberVerificationViewModel$Event$Success = (WidgetMemberVerificationViewModel$Event$Success) other;
        return m.areEqual(this.guildId, widgetMemberVerificationViewModel$Event$Success.guildId) && m.areEqual(this.guildName, widgetMemberVerificationViewModel$Event$Success.guildName) && m.areEqual(this.applicationStatus, widgetMemberVerificationViewModel$Event$Success.applicationStatus) && m.areEqual(this.lastSeen, widgetMemberVerificationViewModel$Event$Success.lastSeen);
    }

    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.guildName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        String str2 = this.lastSeen;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", lastSeen=");
        return a.J(sbU, this.lastSeen, ")");
    }
}
