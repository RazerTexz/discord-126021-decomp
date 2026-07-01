package androidx.browser.trusted;

import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnection$ActiveNotificationsArgs {
    public final Parcelable[] notifications;

    public TrustedWebActivityServiceConnection$ActiveNotificationsArgs(Parcelable[] parcelableArr) {
        this.notifications = parcelableArr;
    }

    public static TrustedWebActivityServiceConnection$ActiveNotificationsArgs fromBundle(Bundle bundle) {
        TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS");
        return new TrustedWebActivityServiceConnection$ActiveNotificationsArgs(bundle.getParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.notifications);
        return bundle;
    }
}
