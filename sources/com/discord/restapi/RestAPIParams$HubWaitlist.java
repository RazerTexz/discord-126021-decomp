package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$HubWaitlist {
    private final String email;
    private final String school;

    public RestAPIParams$HubWaitlist(String str, String str2) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(str2, "school");
        this.email = str;
        this.school = str2;
    }

    public static /* synthetic */ RestAPIParams$HubWaitlist copy$default(RestAPIParams$HubWaitlist restAPIParams$HubWaitlist, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$HubWaitlist.email;
        }
        if ((i & 2) != 0) {
            str2 = restAPIParams$HubWaitlist.school;
        }
        return restAPIParams$HubWaitlist.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public final RestAPIParams$HubWaitlist copy(String email, String school) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(school, "school");
        return new RestAPIParams$HubWaitlist(email, school);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$HubWaitlist)) {
            return false;
        }
        RestAPIParams$HubWaitlist restAPIParams$HubWaitlist = (RestAPIParams$HubWaitlist) other;
        return m.areEqual(this.email, restAPIParams$HubWaitlist.email) && m.areEqual(this.school, restAPIParams$HubWaitlist.school);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getSchool() {
        return this.school;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.school;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubWaitlist(email=");
        sbU.append(this.email);
        sbU.append(", school=");
        return a.J(sbU, this.school, ")");
    }
}
