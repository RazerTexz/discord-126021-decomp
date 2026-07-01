package androidx.browser.trusted;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$NotificationsEnabledArgs {
    public final String channelName;

    public TrustedWebActivityServiceConnection$NotificationsEnabledArgs(String str) {
        this.channelName = str;
    }

    public static TrustedWebActivityServiceConnection$NotificationsEnabledArgs fromBundle(Bundle bundle) {
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
        return new TrustedWebActivityServiceConnection$NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
        return bundle;
    }
}
