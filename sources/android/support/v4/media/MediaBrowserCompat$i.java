package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$i {
    public Messenger a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f17b;

    public MediaBrowserCompat$i(IBinder iBinder, Bundle bundle) {
        this.a = new Messenger(iBinder);
        this.f17b = bundle;
    }

    public final void a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.arg1 = 1;
        messageObtain.setData(bundle);
        messageObtain.replyTo = messenger;
        this.a.send(messageObtain);
    }
}
