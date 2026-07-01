package androidx.media;

import android.os.Build$VERSION;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager$RemoteUserInfo {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static final int UNKNOWN_PID = -1;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static final int UNKNOWN_UID = -1;
    public MediaSessionManager$RemoteUserInfoImpl mImpl;

    public MediaSessionManager$RemoteUserInfo(@NonNull String str, int i, int i2) {
        Objects.requireNonNull(str, "package shouldn't be null");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build$VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(str, i, i2);
        } else {
            this.mImpl = new MediaSessionManagerImplBase$RemoteUserInfoImplBase(str, i, i2);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaSessionManager$RemoteUserInfo) {
            return this.mImpl.equals(((MediaSessionManager$RemoteUserInfo) obj).mImpl);
        }
        return false;
    }

    @NonNull
    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public int getPid() {
        return this.mImpl.getPid();
    }

    public int getUid() {
        return this.mImpl.getUid();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public MediaSessionManager$RemoteUserInfo(android.media.session.MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        String packageName = MediaSessionManagerImplApi28$RemoteUserInfoImplApi28.getPackageName(mediaSessionManager$RemoteUserInfo);
        Objects.requireNonNull(packageName, "package shouldn't be null");
        if (!TextUtils.isEmpty(packageName)) {
            this.mImpl = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(mediaSessionManager$RemoteUserInfo);
            return;
        }
        throw new IllegalArgumentException("packageName should be nonempty");
    }
}
