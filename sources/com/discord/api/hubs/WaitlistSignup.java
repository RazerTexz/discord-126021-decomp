package com.discord.api.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WaitlistSignup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WaitlistSignup {
    private final String email;
    private final String emailDomain;
    private final String school;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WaitlistSignup)) {
            return false;
        }
        WaitlistSignup waitlistSignup = (WaitlistSignup) other;
        return m.areEqual(this.email, waitlistSignup.email) && m.areEqual(this.emailDomain, waitlistSignup.emailDomain) && m.areEqual(this.school, waitlistSignup.school);
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emailDomain;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.school;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WaitlistSignup(email=");
        sbU.append(this.email);
        sbU.append(", emailDomain=");
        sbU.append(this.emailDomain);
        sbU.append(", school=");
        return a.J(sbU, this.school, ")");
    }
}
