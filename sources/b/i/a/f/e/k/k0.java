package b.i.a.f.e.k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements ServiceConnection {
    public final int j;
    public final /* synthetic */ b k;

    public k0(b bVar, int i) {
        this.k = bVar;
        this.j = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            b.C(this.k, 16);
            return;
        }
        synchronized (this.k.i) {
            b bVar = this.k;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            bVar.j = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof i)) ? new b0(iBinder) : (i) iInterfaceQueryLocalInterface;
        }
        b bVar2 = this.k;
        int i = this.j;
        Handler handler = bVar2.g;
        handler.sendMessage(handler.obtainMessage(7, i, -1, new m0(bVar2, 0)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b bVar;
        synchronized (this.k.i) {
            bVar = this.k;
            bVar.j = null;
        }
        Handler handler = bVar.g;
        handler.sendMessage(handler.obtainMessage(6, this.j, 1));
    }
}
