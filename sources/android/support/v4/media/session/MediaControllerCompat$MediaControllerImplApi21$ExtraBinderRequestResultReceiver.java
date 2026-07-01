package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import x.a.b.b.a.b;
import x.a.b.b.a.b$a;

/* JADX INFO: loaded from: classes.dex */
public class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {
    public WeakReference<MediaControllerCompat$MediaControllerImplApi21> j;

    public MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21) {
        super(null);
        this.j = new WeakReference<>(mediaControllerCompat$MediaControllerImplApi21);
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.j.get();
        if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
            return;
        }
        synchronized (mediaControllerCompat$MediaControllerImplApi21.f20b) {
            MediaSessionCompat$Token mediaSessionCompat$Token = mediaControllerCompat$MediaControllerImplApi21.e;
            b bVarC = b$a.c(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
            synchronized (mediaSessionCompat$Token.j) {
                mediaSessionCompat$Token.l = bVarC;
            }
            MediaSessionCompat$Token mediaSessionCompat$Token2 = mediaControllerCompat$MediaControllerImplApi21.e;
            VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
            synchronized (mediaSessionCompat$Token2.j) {
                mediaSessionCompat$Token2.m = versionedParcelable;
            }
            mediaControllerCompat$MediaControllerImplApi21.a();
        }
    }
}
