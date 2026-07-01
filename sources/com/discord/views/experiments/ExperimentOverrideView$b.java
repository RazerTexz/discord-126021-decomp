package com.discord.views.experiments;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ExperimentOverrideView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverrideView$b {
    public final Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2842b;

    public ExperimentOverrideView$b(Integer num, String str) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.a = num;
        this.f2842b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperimentOverrideView$b)) {
            return false;
        }
        ExperimentOverrideView$b experimentOverrideView$b = (ExperimentOverrideView$b) obj;
        return m.areEqual(this.a, experimentOverrideView$b.a) && m.areEqual(this.f2842b, experimentOverrideView$b.f2842b);
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.f2842b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SpinnerItem(bucket=");
        sbU.append(this.a);
        sbU.append(", text=");
        return a.J(sbU, this.f2842b, ")");
    }
}
