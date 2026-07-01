package androidx.browser.trusted;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$CancelNotificationArgs {
    public final int platformId;
    public final String platformTag;

    public TrustedWebActivityServiceConnection$CancelNotificationArgs(String str, int i) {
        this.platformTag = str;
        this.platformId = i;
    }

    public static TrustedWebActivityServiceConnection$CancelNotificationArgs fromBundle(Bundle bundle) {
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
        return new TrustedWebActivityServiceConnection$CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
        bundle.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
        return bundle;
    }
}
