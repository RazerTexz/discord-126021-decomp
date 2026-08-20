package p668x.p669a.p672b.p674b.p675a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: renamed from: x.a.b.b.a.a */
/* JADX INFO: compiled from: IMediaControllerCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC13182a extends IInterface {

    /* JADX INFO: renamed from: x.a.b.b.a.a$a */
    /* JADX INFO: compiled from: IMediaControllerCallback.java */
    public static abstract class a extends Binder implements InterfaceC13182a {
        public a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                    }
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo35W();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                    }
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo36X(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo39z(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo34U(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo38y(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    mo37s0(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readInt();
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                case 10:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readInt();
                    return true;
                case 11:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readInt();
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                case 12:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.readInt();
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                case 13:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    ((AbstractC13184c.b) this).f27947a.get();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: renamed from: U */
    void mo34U(CharSequence charSequence) throws RemoteException;

    /* JADX INFO: renamed from: W */
    void mo35W() throws RemoteException;

    /* JADX INFO: renamed from: X */
    void mo36X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    /* JADX INFO: renamed from: s0 */
    void mo37s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    /* JADX INFO: renamed from: y */
    void mo38y(Bundle bundle) throws RemoteException;

    /* JADX INFO: renamed from: z */
    void mo39z(List<MediaSessionCompat.QueueItem> list) throws RemoteException;
}
