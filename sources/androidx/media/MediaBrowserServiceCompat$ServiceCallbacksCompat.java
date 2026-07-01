package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceCallbacksCompat implements MediaBrowserServiceCompat$ServiceCallbacks {
    public final Messenger mCallbacks;

    public MediaBrowserServiceCompat$ServiceCallbacksCompat(Messenger messenger) {
        this.mCallbacks = messenger;
    }

    private void sendRequest(int i, Bundle bundle) throws RemoteException {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.arg1 = 2;
        messageObtain.setData(bundle);
        this.mCallbacks.send(messageObtain);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
    public IBinder asBinder() {
        return this.mCallbacks.getBinder();
    }

    @Override // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
    public void onConnect(String str, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) throws RemoteException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, mediaSessionCompat$Token);
        bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
        sendRequest(1, bundle2);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
    public void onConnectFailed() throws RemoteException {
        sendRequest(2, null);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
    public void onLoadChildren(String str, List<MediaBrowserCompat$MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
        Bundle bundle3 = new Bundle();
        bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
        bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
        if (list != null) {
            bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
        }
        sendRequest(3, bundle3);
    }
}
