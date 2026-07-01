package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import x.a.b.b.a.IMediaSession;
import x.a.b.b.a.MediaControllerCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaControllerCompat$MediaControllerImplApi21 {
    public final MediaController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20b = new Object();

    @GuardedBy("mLock")
    public final List<MediaControllerCompat> c = new ArrayList();
    public HashMap<MediaControllerCompat, a> d = new HashMap<>();
    public final MediaSessionCompat.Token e;

    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> j;

        public ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21) {
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
                MediaSessionCompat.Token token = mediaControllerCompat$MediaControllerImplApi21.e;
                IMediaSession iMediaSessionC = IMediaSession.a.c(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                synchronized (token.j) {
                    token.l = iMediaSessionC;
                }
                MediaSessionCompat.Token token2 = mediaControllerCompat$MediaControllerImplApi21.e;
                VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
                synchronized (token2.j) {
                    token2.m = versionedParcelable;
                }
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    public static class a extends MediaControllerCompat.b {
        public a(MediaControllerCompat mediaControllerCompat) {
            super(mediaControllerCompat);
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void U(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void W() throws RemoteException {
            throw new AssertionError();
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void y(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        @Override // x.a.b.b.a.MediaControllerCompat.b, x.a.b.b.a.IMediaControllerCallback
        public void z(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }
    }

    public MediaControllerCompat$MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
        this.e = token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) token.k);
        this.a = mediaController;
        if (token.b() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }
    }

    @GuardedBy("mLock")
    public void a() {
        if (this.e.b() == null) {
            return;
        }
        for (MediaControllerCompat mediaControllerCompat : this.c) {
            a aVar = new a(mediaControllerCompat);
            this.d.put(mediaControllerCompat, aVar);
            mediaControllerCompat.a = aVar;
            try {
                this.e.b().k(aVar);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.c.clear();
    }
}
