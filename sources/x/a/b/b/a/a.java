package x.a.b.b.a;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import java.util.List;

/* JADX INFO: compiled from: IMediaControllerCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    void U(CharSequence charSequence) throws RemoteException;

    void W() throws RemoteException;

    void X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void y(Bundle bundle) throws RemoteException;

    void z(List<MediaSessionCompat$QueueItem> list) throws RemoteException;
}
