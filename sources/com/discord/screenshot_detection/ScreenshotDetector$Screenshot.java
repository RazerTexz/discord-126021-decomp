package com.discord.screenshot_detection;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ScreenshotDetector$Screenshot {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Uri uri;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String filename;

    public ScreenshotDetector$Screenshot(Uri uri, String str) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str, "filename");
        this.uri = uri;
        this.filename = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenshotDetector$Screenshot)) {
            return false;
        }
        ScreenshotDetector$Screenshot screenshotDetector$Screenshot = (ScreenshotDetector$Screenshot) other;
        return m.areEqual(this.uri, screenshotDetector$Screenshot.uri) && m.areEqual(this.filename, screenshotDetector$Screenshot.filename);
    }

    public int hashCode() {
        Uri uri = this.uri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.filename;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Screenshot(uri=");
        sbU.append(this.uri);
        sbU.append(", filename=");
        return a.J(sbU, this.filename, ")");
    }
}
