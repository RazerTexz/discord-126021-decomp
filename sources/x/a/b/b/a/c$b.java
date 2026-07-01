package x.a.b.b.a;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import androidx.media.AudioAttributesCompat$Builder;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: MediaControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c$b extends a$a {
    public final WeakReference<c> a;

    public c$b(c cVar) {
        this.a = new WeakReference<>(cVar);
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
        new AudioAttributesCompat$Builder().setLegacyStreamType(parcelableVolumeInfo.k).build();
    }

    public void y(Bundle bundle) throws RemoteException {
        this.a.get();
    }

    public void z(List<MediaSessionCompat$QueueItem> list) throws RemoteException {
        this.a.get();
    }
}
