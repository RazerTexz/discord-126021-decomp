package x.a.b.b.a;

import android.media.MediaMetadata;
import android.media.session.MediaController$Callback;
import android.media.session.MediaController$PlaybackInfo;
import android.media.session.MediaSession$QueueItem;
import android.media.session.PlaybackState;
import android.media.session.PlaybackState$CustomAction;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$QueueItem$b;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.support.v4.media.session.PlaybackStateCompat$b;
import android.support.v4.media.session.PlaybackStateCompat$c;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MediaControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class c$a extends MediaController$Callback {
    public final WeakReference<c> a;

    public c$a(c cVar) {
        this.a = new WeakReference<>(cVar);
    }

    @Override // android.media.session.MediaController$Callback
    public void onAudioInfoChanged(MediaController$PlaybackInfo mediaController$PlaybackInfo) {
        if (this.a.get() != null) {
            mediaController$PlaybackInfo.getPlaybackType();
            AudioAttributesCompat.wrap(mediaController$PlaybackInfo.getAudioAttributes());
            mediaController$PlaybackInfo.getVolumeControl();
            mediaController$PlaybackInfo.getMaxVolume();
            mediaController$PlaybackInfo.getCurrentVolume();
        }
    }

    @Override // android.media.session.MediaController$Callback
    public void onExtrasChanged(Bundle bundle) {
        MediaSessionCompat.a(bundle);
        this.a.get();
    }

    @Override // android.media.session.MediaController$Callback
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

    @Override // android.media.session.MediaController$Callback
    public void onPlaybackStateChanged(PlaybackState playbackState) {
        ArrayList arrayList;
        PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction;
        c cVar = this.a.get();
        if (cVar == null || cVar.a != null) {
            return;
        }
        Bundle bundleA = null;
        if (playbackState != null) {
            List<PlaybackState$CustomAction> listJ = PlaybackStateCompat$b.j(playbackState);
            if (listJ != null) {
                ArrayList arrayList2 = new ArrayList(listJ.size());
                for (PlaybackState$CustomAction playbackState$CustomAction : listJ) {
                    if (playbackState$CustomAction != null) {
                        PlaybackState$CustomAction playbackState$CustomAction2 = playbackState$CustomAction;
                        Bundle bundleL = PlaybackStateCompat$b.l(playbackState$CustomAction2);
                        MediaSessionCompat.a(bundleL);
                        playbackStateCompat$CustomAction = new PlaybackStateCompat$CustomAction(PlaybackStateCompat$b.f(playbackState$CustomAction2), PlaybackStateCompat$b.o(playbackState$CustomAction2), PlaybackStateCompat$b.m(playbackState$CustomAction2), bundleL);
                    } else {
                        playbackStateCompat$CustomAction = null;
                    }
                    arrayList2.add(playbackStateCompat$CustomAction);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (Build$VERSION.SDK_INT >= 22) {
                bundleA = PlaybackStateCompat$c.a(playbackState);
                MediaSessionCompat.a(bundleA);
            }
            new PlaybackStateCompat(PlaybackStateCompat$b.r(playbackState), PlaybackStateCompat$b.q(playbackState), PlaybackStateCompat$b.i(playbackState), PlaybackStateCompat$b.p(playbackState), PlaybackStateCompat$b.g(playbackState), 0, PlaybackStateCompat$b.k(playbackState), PlaybackStateCompat$b.n(playbackState), arrayList, PlaybackStateCompat$b.h(playbackState), bundleA);
        }
    }

    @Override // android.media.session.MediaController$Callback
    public void onQueueChanged(List<MediaSession$QueueItem> list) {
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        if (this.a.get() == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaSession$QueueItem mediaSession$QueueItem : list) {
            if (mediaSession$QueueItem != null) {
                MediaSession$QueueItem mediaSession$QueueItem2 = mediaSession$QueueItem;
                mediaSessionCompat$QueueItem = new MediaSessionCompat$QueueItem(mediaSession$QueueItem2, MediaDescriptionCompat.a(MediaSessionCompat$QueueItem$b.b(mediaSession$QueueItem2)), MediaSessionCompat$QueueItem$b.c(mediaSession$QueueItem2));
            } else {
                mediaSessionCompat$QueueItem = null;
            }
            arrayList.add(mediaSessionCompat$QueueItem);
        }
    }

    @Override // android.media.session.MediaController$Callback
    public void onQueueTitleChanged(CharSequence charSequence) {
        this.a.get();
    }

    @Override // android.media.session.MediaController$Callback
    public void onSessionDestroyed() {
        this.a.get();
    }

    @Override // android.media.session.MediaController$Callback
    public void onSessionEvent(String str, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        c cVar = this.a.get();
        if (cVar == null || cVar.a == null) {
            return;
        }
        int i = Build$VERSION.SDK_INT;
    }
}
