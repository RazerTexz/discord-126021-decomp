package b.a.s;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenshotContentObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f286b;
    public final String c;
    public final String d;
    public final Uri e;
    public final long f;

    public b$b(long j, String str, String str2, Uri uri, long j2) {
        m.checkNotNullParameter(str, "fileName");
        m.checkNotNullParameter(str2, "relativePath");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        this.f286b = j;
        this.c = str;
        this.d = str2;
        this.e = uri;
        this.f = j2;
        this.a = str2 + MentionUtilsKt.SLASH_CHAR + str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b$b)) {
            return false;
        }
        b$b b_b = (b$b) obj;
        return this.f286b == b_b.f286b && m.areEqual(this.c, b_b.c) && m.areEqual(this.d, b_b.d) && m.areEqual(this.e, b_b.e) && this.f == b_b.f;
    }

    public int hashCode() {
        int iA = a0.a.a.b.a(this.f286b) * 31;
        String str = this.c;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Uri uri = this.e;
        return a0.a.a.b.a(this.f) + ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ScreenshotData(id=");
        sbU.append(this.f286b);
        sbU.append(", fileName=");
        sbU.append(this.c);
        sbU.append(", relativePath=");
        sbU.append(this.d);
        sbU.append(", uri=");
        sbU.append(this.e);
        sbU.append(", dateAdded=");
        return b.d.b.a.a.C(sbU, this.f, ")");
    }
}
