package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import x.a.a.d.b$a;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityService$1 extends b$a {
    public final /* synthetic */ TrustedWebActivityService this$0;

    public TrustedWebActivityService$1(TrustedWebActivityService trustedWebActivityService) {
        this.this$0 = trustedWebActivityService;
    }

    private void checkCaller() {
        TrustedWebActivityService trustedWebActivityService = this.this$0;
        if (trustedWebActivityService.mVerifiedUid == -1) {
            String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid == null) {
                packagesForUid = new String[0];
            }
            Token tokenLoad = this.this$0.getTokenStore().load();
            PackageManager packageManager = this.this$0.getPackageManager();
            if (tokenLoad != null) {
                for (String str : packagesForUid) {
                    if (tokenLoad.matches(str, packageManager)) {
                        this.this$0.mVerifiedUid = Binder.getCallingUid();
                        break;
                    }
                }
            }
        }
        if (this.this$0.mVerifiedUid != Binder.getCallingUid()) {
            throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
        }
    }

    @Override // x.a.a.d.b
    public Bundle areNotificationsEnabled(Bundle bundle) {
        checkCaller();
        return new TrustedWebActivityServiceConnection$ResultArgs(this.this$0.onAreNotificationsEnabled(TrustedWebActivityServiceConnection$NotificationsEnabledArgs.fromBundle(bundle).channelName)).toBundle();
    }

    @Override // x.a.a.d.b
    public void cancelNotification(Bundle bundle) {
        checkCaller();
        TrustedWebActivityServiceConnection$CancelNotificationArgs trustedWebActivityServiceConnection$CancelNotificationArgsFromBundle = TrustedWebActivityServiceConnection$CancelNotificationArgs.fromBundle(bundle);
        this.this$0.onCancelNotification(trustedWebActivityServiceConnection$CancelNotificationArgsFromBundle.platformTag, trustedWebActivityServiceConnection$CancelNotificationArgsFromBundle.platformId);
    }

    @Override // x.a.a.d.b
    public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
        checkCaller();
        return this.this$0.onExtraCommand(str, bundle, TrustedWebActivityCallbackRemote.fromBinder(iBinder));
    }

    @Override // x.a.a.d.b
    public Bundle getActiveNotifications() {
        checkCaller();
        return new TrustedWebActivityServiceConnection$ActiveNotificationsArgs(this.this$0.onGetActiveNotifications()).toBundle();
    }

    @Override // x.a.a.d.b
    public Bundle getSmallIconBitmap() {
        checkCaller();
        return this.this$0.onGetSmallIconBitmap();
    }

    @Override // x.a.a.d.b
    public int getSmallIconId() {
        checkCaller();
        return this.this$0.onGetSmallIconId();
    }

    @Override // x.a.a.d.b
    public Bundle notifyNotificationWithChannel(Bundle bundle) {
        checkCaller();
        TrustedWebActivityServiceConnection$NotifyNotificationArgs trustedWebActivityServiceConnection$NotifyNotificationArgsFromBundle = TrustedWebActivityServiceConnection$NotifyNotificationArgs.fromBundle(bundle);
        return new TrustedWebActivityServiceConnection$ResultArgs(this.this$0.onNotifyNotificationWithChannel(trustedWebActivityServiceConnection$NotifyNotificationArgsFromBundle.platformTag, trustedWebActivityServiceConnection$NotifyNotificationArgsFromBundle.platformId, trustedWebActivityServiceConnection$NotifyNotificationArgsFromBundle.notification, trustedWebActivityServiceConnection$NotifyNotificationArgsFromBundle.channelName)).toBundle();
    }
}
