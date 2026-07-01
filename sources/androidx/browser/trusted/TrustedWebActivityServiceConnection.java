package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import x.a.a.d.b;

/* JADX INFO: loaded from: classes.dex */
public final class TrustedWebActivityServiceConnection {
    private static final String KEY_ACTIVE_NOTIFICATIONS = "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS";
    private static final String KEY_CHANNEL_NAME = "android.support.customtabs.trusted.CHANNEL_NAME";
    private static final String KEY_NOTIFICATION = "android.support.customtabs.trusted.NOTIFICATION";
    private static final String KEY_NOTIFICATION_SUCCESS = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS";
    private static final String KEY_PLATFORM_ID = "android.support.customtabs.trusted.PLATFORM_ID";
    private static final String KEY_PLATFORM_TAG = "android.support.customtabs.trusted.PLATFORM_TAG";
    private final ComponentName mComponentName;
    private final b mService;

    public TrustedWebActivityServiceConnection(@NonNull b bVar, @NonNull ComponentName componentName) {
        this.mService = bVar;
        this.mComponentName = componentName;
    }

    public static void ensureBundleContains(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException(a.w("Bundle must contain ", str));
        }
    }

    @Nullable
    private static x.a.a.d.a wrapCallback(@Nullable TrustedWebActivityCallback trustedWebActivityCallback) {
        if (trustedWebActivityCallback == null) {
            return null;
        }
        return new TrustedWebActivityServiceConnection$1(trustedWebActivityCallback);
    }

    public boolean areNotificationsEnabled(@NonNull String str) throws RemoteException {
        return TrustedWebActivityServiceConnection$ResultArgs.fromBundle(this.mService.areNotificationsEnabled(new TrustedWebActivityServiceConnection$NotificationsEnabledArgs(str).toBundle())).success;
    }

    public void cancel(@NonNull String str, int i) throws RemoteException {
        this.mService.cancelNotification(new TrustedWebActivityServiceConnection$CancelNotificationArgs(str, i).toBundle());
    }

    @NonNull
    @RequiresApi(23)
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public Parcelable[] getActiveNotifications() throws RemoteException {
        return TrustedWebActivityServiceConnection$ActiveNotificationsArgs.fromBundle(this.mService.getActiveNotifications()).notifications;
    }

    @NonNull
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    @Nullable
    public Bitmap getSmallIconBitmap() throws RemoteException {
        return (Bitmap) this.mService.getSmallIconBitmap().getParcelable(TrustedWebActivityService.KEY_SMALL_ICON_BITMAP);
    }

    public int getSmallIconId() throws RemoteException {
        return this.mService.getSmallIconId();
    }

    public boolean notify(@NonNull String str, int i, @NonNull Notification notification, @NonNull String str2) throws RemoteException {
        return TrustedWebActivityServiceConnection$ResultArgs.fromBundle(this.mService.notifyNotificationWithChannel(new TrustedWebActivityServiceConnection$NotifyNotificationArgs(str, i, notification, str2).toBundle())).success;
    }

    @Nullable
    public Bundle sendExtraCommand(@NonNull String str, @NonNull Bundle bundle, @Nullable TrustedWebActivityCallback trustedWebActivityCallback) throws RemoteException {
        x.a.a.d.a aVarWrapCallback = wrapCallback(trustedWebActivityCallback);
        return this.mService.extraCommand(str, bundle, aVarWrapCallback == null ? null : aVarWrapCallback.asBinder());
    }
}
