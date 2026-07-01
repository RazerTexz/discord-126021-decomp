package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$NotifyNotificationArgs {
    public final String channelName;
    public final Notification notification;
    public final int platformId;
    public final String platformTag;

    public TrustedWebActivityServiceConnection$NotifyNotificationArgs(String str, int i, Notification notification, String str2) {
        this.platformTag = str;
        this.platformId = i;
        this.notification = notification;
        this.channelName = str2;
    }

    public static TrustedWebActivityServiceConnection$NotifyNotificationArgs fromBundle(Bundle bundle) {
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION");
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
        return new TrustedWebActivityServiceConnection$NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
        bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
        bundle.putParcelable("android.support.customtabs.trusted.NOTIFICATION", this.notification);
        bundle.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
        return bundle;
    }
}
