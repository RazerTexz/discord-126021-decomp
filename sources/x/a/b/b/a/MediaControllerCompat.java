package x.a.b.b.a;

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
import x.a.b.b.a.IMediaControllerCallback;

/* JADX INFO: renamed from: x.a.b.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: MediaControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaControllerCompat implements IBinder.DeathRecipient {
    public IMediaControllerCallback a;

    /* JADX INFO: renamed from: x.a.b.b.a.c$a */
    /* JADX INFO: compiled from: MediaControllerCompat.java */
    @RequiresApi(21)
    public static class a extends MediaController.Callback {
        public final WeakReference<MediaControllerCompat> a;

        public a(MediaControllerCompat mediaControllerCompat) {
            this.a = new WeakReference<>(mediaControllerCompat);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            if (this.a.get() != null) {
                playbackInfo.getPlaybackType();
                AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes());
                playbackInfo.getVolumeControl();
                playbackInfo.getMaxVolume();
                playbackInfo.getCurrentVolume();
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            if (this.a.get() != null) {
                ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.j;
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
            MediaControllerCompat mediaControllerCompat = this.a.get();
            if (mediaControllerCompat == null || mediaControllerCompat.a != null) {
                return;
            }
            Bundle bundleA = null;
            if (playbackState != null) {
                List<PlaybackState.CustomAction> listJ = PlaybackStateCompat.b.j(playbackState);
                if (listJ != null) {
                    ArrayList arrayList2 = new ArrayList(listJ.size());
                    for (PlaybackState.CustomAction customAction2 : listJ) {
                        if (customAction2 != null) {
                            PlaybackState.CustomAction customAction3 = customAction2;
                            Bundle bundleL = PlaybackStateCompat.b.l(customAction3);
                            MediaSessionCompat.a(bundleL);
                            customAction = new PlaybackStateCompat.CustomAction(PlaybackStateCompat.b.f(customAction3), PlaybackStateCompat.b.o(customAction3), PlaybackStateCompat.b.m(customAction3), bundleL);
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
                    bundleA = PlaybackStateCompat.c.a(playbackState);
                    MediaSessionCompat.a(bundleA);
                }
                new PlaybackStateCompat(PlaybackStateCompat.b.r(playbackState), PlaybackStateCompat.b.q(playbackState), PlaybackStateCompat.b.i(playbackState), PlaybackStateCompat.b.p(playbackState), PlaybackStateCompat.b.g(playbackState), 0, PlaybackStateCompat.b.k(playbackState), PlaybackStateCompat.b.n(playbackState), arrayList, PlaybackStateCompat.b.h(playbackState), bundleA);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            MediaSessionCompat.QueueItem queueItem;
            if (this.a.get() == null || list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (MediaSession.QueueItem queueItem2 : list) {
                if (queueItem2 != null) {
                    MediaSession.QueueItem queueItem3 = queueItem2;
                    queueItem = new MediaSessionCompat.QueueItem(queueItem3, MediaDescriptionCompat.a(MediaSessionCompat.QueueItem.b.b(queueItem3)), MediaSessionCompat.QueueItem.b.c(queueItem3));
                } else {
                    queueItem = null;
                }
                arrayList.add(queueItem);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.a.get();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            MediaControllerCompat mediaControllerCompat = this.a.get();
            if (mediaControllerCompat == null || mediaControllerCompat.a == null) {
                return;
            }
            int i = Build.VERSION.SDK_INT;
        }
    }

    /* JADX INFO: renamed from: x.a.b.b.a.c$b */
    /* JADX INFO: compiled from: MediaControllerCompat.java */
    public static class b extends IMediaControllerCallback.a {
        public final WeakReference<MediaControllerCompat> a;

        public b(MediaControllerCompat mediaControllerCompat) {
            this.a = new WeakReference<>(mediaControllerCompat);
        }

        public void U(CharSequence charSequence) throws RemoteException {
            this.a.get();
        }

        public void W() throws RemoteException {
            this.a.get();
        }

        public void X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            this.a.get();
        }

        public void s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            if (this.a.get() == null || parcelableVolumeInfo == null) {
                return;
            }
            new AudioAttributesCompat.Builder().setLegacyStreamType(parcelableVolumeInfo.k).build();
        }

        public void y(Bundle bundle) throws RemoteException {
            this.a.get();
        }

        public void z(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            this.a.get();
        }
    }

    public MediaControllerCompat() {
        new a(this);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }
}
