package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.provider.Settings$Secure;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionManagerImplBase implements MediaSessionManager$MediaSessionManagerImpl {
    private static final boolean DEBUG = MediaSessionManager.DEBUG;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    public ContentResolver mContentResolver;
    public Context mContext;

    public MediaSessionManagerImplBase(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl, String str) {
        if (mediaSessionManager$RemoteUserInfoImpl.getPid() < 0) {
            return this.mContext.getPackageManager().checkPermission(str, mediaSessionManager$RemoteUserInfoImpl.getPackageName()) == 0;
        }
        return this.mContext.checkPermission(str, mediaSessionManager$RemoteUserInfoImpl.getPid(), mediaSessionManager$RemoteUserInfoImpl.getUid()) == 0;
    }

    @Override // androidx.media.MediaSessionManager$MediaSessionManagerImpl
    public Context getContext() {
        return this.mContext;
    }

    public boolean isEnabledNotificationListener(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        String string = Settings$Secure.getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (string != null) {
            for (String str : string.split(":")) {
                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(mediaSessionManager$RemoteUserInfoImpl.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media.MediaSessionManager$MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        try {
            if (this.mContext.getPackageManager().getApplicationInfo(mediaSessionManager$RemoteUserInfoImpl.getPackageName(), 0) == null) {
                return false;
            }
            return isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) || isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) || mediaSessionManager$RemoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(mediaSessionManager$RemoteUserInfoImpl);
        } catch (PackageManager$NameNotFoundException unused) {
            if (DEBUG) {
                StringBuilder sbU = a.U("Package ");
                sbU.append(mediaSessionManager$RemoteUserInfoImpl.getPackageName());
                sbU.append(" doesn't exist");
                Log.d("MediaSessionManager", sbU.toString());
            }
            return false;
        }
    }
}
