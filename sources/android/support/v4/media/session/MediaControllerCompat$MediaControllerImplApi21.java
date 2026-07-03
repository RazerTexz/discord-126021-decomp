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
import p668x.p669a.p672b.p674b.p675a.AbstractC13184c;
import p668x.p669a.p672b.p674b.p675a.InterfaceC13183b;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaControllerCompat$MediaControllerImplApi21 {

    /* JADX INFO: renamed from: a */
    public final MediaController f40a;

    /* JADX INFO: renamed from: b */
    public final Object f41b = new Object();

    /* JADX INFO: renamed from: c */
    @GuardedBy("mLock")
    public final List<AbstractC13184c> f42c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public HashMap<AbstractC13184c, BinderC0020a> f43d = new HashMap<>();

    /* JADX INFO: renamed from: e */
    public final MediaSessionCompat.Token f44e;

    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: j */
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> f45j;

        public ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21) {
            super(null);
            this.f45j = new WeakReference<>(mediaControllerCompat$MediaControllerImplApi21);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f45j.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f41b) {
                MediaSessionCompat.Token token = mediaControllerCompat$MediaControllerImplApi21.f44e;
                InterfaceC13183b interfaceC13183bM11356c = InterfaceC13183b.a.m11356c(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                synchronized (token.f50j) {
                    token.f52l = interfaceC13183bM11356c;
                }
                MediaSessionCompat.Token token2 = mediaControllerCompat$MediaControllerImplApi21.f44e;
                VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
                synchronized (token2.f50j) {
                    token2.f53m = versionedParcelable;
                }
                mediaControllerCompat$MediaControllerImplApi21.m33a();
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
    public static class BinderC0020a extends AbstractC13184c.b {
        public BinderC0020a(AbstractC13184c abstractC13184c) {
            super(abstractC13184c);
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: U */
        public void mo34U(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: W */
        public void mo35W() throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: X */
        public void mo36X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: s0 */
        public void mo37s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: y */
        public void mo38y(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.AbstractC13184c.b, p668x.p669a.p672b.p674b.p675a.InterfaceC13182a
        /* JADX INFO: renamed from: z */
        public void mo39z(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }
    }

    public MediaControllerCompat$MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
        this.f44e = token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) token.f51k);
        this.f40a = mediaController;
        if (token.m46b() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }
    }

    @GuardedBy("mLock")
    /* JADX INFO: renamed from: a */
    public void m33a() {
        if (this.f44e.m46b() == null) {
            return;
        }
        for (AbstractC13184c abstractC13184c : this.f42c) {
            BinderC0020a binderC0020a = new BinderC0020a(abstractC13184c);
            this.f43d.put(abstractC13184c, binderC0020a);
            abstractC13184c.f27945a = binderC0020a;
            try {
                this.f44e.m46b().mo11355k(binderC0020a);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.f42c.clear();
    }
}
