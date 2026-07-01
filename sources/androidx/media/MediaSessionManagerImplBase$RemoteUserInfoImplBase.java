package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionManagerImplBase$RemoteUserInfoImplBase implements MediaSessionManager$RemoteUserInfoImpl {
    private String mPackageName;
    private int mPid;
    private int mUid;

    public MediaSessionManagerImplBase$RemoteUserInfoImplBase(String str, int i, int i2) {
        this.mPackageName = str;
        this.mPid = i;
        this.mUid = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionManagerImplBase$RemoteUserInfoImplBase)) {
            return false;
        }
        MediaSessionManagerImplBase$RemoteUserInfoImplBase mediaSessionManagerImplBase$RemoteUserInfoImplBase = (MediaSessionManagerImplBase$RemoteUserInfoImplBase) obj;
        if (this.mPid < 0 || mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPid < 0) {
            return TextUtils.equals(this.mPackageName, mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPackageName) && this.mUid == mediaSessionManagerImplBase$RemoteUserInfoImplBase.mUid;
        }
        return TextUtils.equals(this.mPackageName, mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPackageName) && this.mPid == mediaSessionManagerImplBase$RemoteUserInfoImplBase.mPid && this.mUid == mediaSessionManagerImplBase$RemoteUserInfoImplBase.mUid;
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public int getPid() {
        return this.mPid;
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mPackageName, Integer.valueOf(this.mUid));
    }
}
