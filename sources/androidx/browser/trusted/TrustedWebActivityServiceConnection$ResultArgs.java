package androidx.browser.trusted;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$ResultArgs {
    public final boolean success;

    public TrustedWebActivityServiceConnection$ResultArgs(boolean z2) {
        this.success = z2;
    }

    public static TrustedWebActivityServiceConnection$ResultArgs fromBundle(Bundle bundle) {
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
        return new TrustedWebActivityServiceConnection$ResultArgs(bundle.getBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.success);
        return bundle;
    }
}
