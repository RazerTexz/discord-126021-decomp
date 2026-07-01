package androidx.media;

import android.content.Context;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    private static volatile MediaSessionManager sSessionManager;
    public MediaSessionManager$MediaSessionManagerImpl mImpl;
    public static final String TAG = "MediaSessionManager";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final Object sLock = new Object();

    private MediaSessionManager(Context context) {
        if (Build$VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28(context);
        } else {
            this.mImpl = new MediaSessionManagerImplApi21(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        synchronized (sLock) {
            if (sSessionManager == null) {
                sSessionManager = new MediaSessionManager(context.getApplicationContext());
            }
            mediaSessionManager = sSessionManager;
        }
        return mediaSessionManager;
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        if (mediaSessionManager$RemoteUserInfo != null) {
            return this.mImpl.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfo.mImpl);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
