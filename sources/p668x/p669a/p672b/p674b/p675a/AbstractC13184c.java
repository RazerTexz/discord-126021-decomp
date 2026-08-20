package p668x.p669a.p672b.p674b.p675a;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: x.a.b.b.a.c */
/* JADX INFO: compiled from: MediaControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC13184c implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a */
    public InterfaceC13182a f27945a;

    /* JADX INFO: renamed from: x.a.b.b.a.c$a */
    /* JADX INFO: compiled from: MediaControllerCompat.java */
    @RequiresApi(21)
    public static class a extends MediaController.Callback {

        /* JADX INFO: renamed from: a */
        public final WeakReference<AbstractC13184c> f27946a;

        public a(AbstractC13184c abstractC13184c) {
            this.f27946a = new WeakReference<>(abstractC13184c);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            if (this.f27946a.get() != null) {
                playbackInfo.getPlaybackType();
                AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes());
                playbackInfo.getVolumeControl();
                playbackInfo.getMaxVolume();
                playbackInfo.getCurrentVolume();
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.m40a(bundle);
            this.f27946a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            if (this.f27946a.get() != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.f36j;
                if (mediaMetadata != null) {
                    Parcel parcelObtain = Parcel.obtain();
                    mediaMetadata.writeToParcel(parcelObtain, 0);
                    parcelObtain.setDataPosition(0);
                    MediaMetadataCompat mediaMetadataCompatCreateFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain);
                    parcelObtain.recycle();
                    Objects.requireNonNull(mediaMetadataCompatCreateFromParcel);
                }
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            ArrayList arrayList;
            PlaybackStateCompat.CustomAction customAction;
            AbstractC13184c abstractC13184c = this.f27946a.get();
            if (abstractC13184c == null || abstractC13184c.f27945a != null) {
                return;
            }
            Bundle bundleM71a = null;
            if (playbackState != null) {
                List<PlaybackState.CustomAction> listM56j = PlaybackStateCompat.C0028b.m56j(playbackState);
                if (listM56j != null) {
                    ArrayList arrayList2 = new ArrayList(listM56j.size());
                    for (PlaybackState.CustomAction customAction2 : listM56j) {
                        if (customAction2 != null) {
                            PlaybackState.CustomAction customAction3 = customAction2;
                            Bundle bundleM58l = PlaybackStateCompat.C0028b.m58l(customAction3);
                            MediaSessionCompat.m40a(bundleM58l);
                            customAction = new PlaybackStateCompat.CustomAction(PlaybackStateCompat.C0028b.m52f(customAction3), PlaybackStateCompat.C0028b.m61o(customAction3), PlaybackStateCompat.C0028b.m59m(customAction3), bundleM58l);
                        } else {
                            customAction = null;
                        }
                        arrayList2.add(customAction);
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                if (Build.VERSION.SDK_INT >= 22) {
                    bundleM71a = PlaybackStateCompat.C0029c.m71a(playbackState);
                    MediaSessionCompat.m40a(bundleM71a);
                }
                new PlaybackStateCompat(PlaybackStateCompat.C0028b.m64r(playbackState), PlaybackStateCompat.C0028b.m63q(playbackState), PlaybackStateCompat.C0028b.m55i(playbackState), PlaybackStateCompat.C0028b.m62p(playbackState), PlaybackStateCompat.C0028b.m53g(playbackState), 0, PlaybackStateCompat.C0028b.m57k(playbackState), PlaybackStateCompat.C0028b.m60n(playbackState), arrayList, PlaybackStateCompat.C0028b.m54h(playbackState), bundleM71a);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            MediaSessionCompat.QueueItem queueItem;
            if (this.f27946a.get() == null || list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (MediaSession.QueueItem queueItem2 : list) {
                if (queueItem2 != null) {
                    MediaSession.QueueItem queueItem3 = queueItem2;
                    queueItem = new MediaSessionCompat.QueueItem(queueItem3, MediaDescriptionCompat.m14a(MediaSessionCompat.QueueItem.C0022b.m43b(queueItem3)), MediaSessionCompat.QueueItem.C0022b.m44c(queueItem3));
                } else {
                    queueItem = null;
                }
                arrayList.add(queueItem);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f27946a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f27946a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.m40a(bundle);
            AbstractC13184c abstractC13184c = this.f27946a.get();
            if (abstractC13184c == null || abstractC13184c.f27945a == null) {
                return;
            }
            int i = Build.VERSION.SDK_INT;
        }
    }

    /* JADX INFO: renamed from: x.a.b.b.a.c$b */
    /* JADX INFO: compiled from: MediaControllerCompat.java */
    public static class b extends InterfaceC13182a.a {

        /* JADX INFO: renamed from: a */
        public final WeakReference<AbstractC13184c> f27947a;

        public b(AbstractC13184c abstractC13184c) {
            this.f27947a = new WeakReference<>(abstractC13184c);
        }

        /* JADX INFO: renamed from: U */
        public void mo34U(CharSequence charSequence) throws RemoteException {
            this.f27947a.get();
        }

        /* JADX INFO: renamed from: W */
        public void mo35W() throws RemoteException {
            this.f27947a.get();
        }

        /* JADX INFO: renamed from: X */
        public void mo36X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            this.f27947a.get();
        }

        /* JADX INFO: renamed from: s0 */
        public void mo37s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            if (this.f27947a.get() == null || parcelableVolumeInfo == null) {
                return;
            }
            new AudioAttributesCompat.Builder().setLegacyStreamType(parcelableVolumeInfo.f55k).build();
        }

        /* JADX INFO: renamed from: y */
        public void mo38y(Bundle bundle) throws RemoteException {
            this.f27947a.get();
        }

        /* JADX INFO: renamed from: z */
        public void mo39z(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            this.f27947a.get();
        }
    }

    public AbstractC13184c() {
        new a(this);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }
}
