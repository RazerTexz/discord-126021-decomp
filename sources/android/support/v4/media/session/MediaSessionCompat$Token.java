package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.MediaSession$Token;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.versionedparcelable.VersionedParcelable;
import x.a.b.b.a.b;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable$Creator<MediaSessionCompat$Token> CREATOR = new MediaSessionCompat$Token$a();
    public final Object j;
    public final Object k;

    @GuardedBy("mLock")
    public b l;

    @GuardedBy("mLock")
    public VersionedParcelable m;

    public MediaSessionCompat$Token(Object obj) {
        this.j = new Object();
        this.k = obj;
        this.l = null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static MediaSessionCompat$Token a(Object obj, b bVar) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof MediaSession$Token) {
            return new MediaSessionCompat$Token(obj, bVar);
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public b b() {
        b bVar;
        synchronized (this.j) {
            bVar = this.l;
        }
        return bVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
        Object obj2 = this.k;
        if (obj2 == null) {
            return mediaSessionCompat$Token.k == null;
        }
        Object obj3 = mediaSessionCompat$Token.k;
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.k;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable((Parcelable) this.k, i);
    }

    public MediaSessionCompat$Token(Object obj, b bVar) {
        this.j = new Object();
        this.k = obj;
        this.l = bVar;
    }
}
