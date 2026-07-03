package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: b.i.a.f.e.k.k0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC3364k0 implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public final int f9532j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractC3345b f9533k;

    public ServiceConnectionC3364k0(AbstractC3345b abstractC3345b, int i) {
        this.f9533k = abstractC3345b;
        this.f9532j = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            AbstractC3345b.m4122C(this.f9533k, 16);
            return;
        }
        synchronized (this.f9533k.f9484i) {
            AbstractC3345b abstractC3345b = this.f9533k;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            abstractC3345b.f9485j = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC3359i)) ? new C3346b0(iBinder) : (InterfaceC3359i) iInterfaceQueryLocalInterface;
        }
        AbstractC3345b abstractC3345b2 = this.f9533k;
        int i = this.f9532j;
        Handler handler = abstractC3345b2.f9482g;
        handler.sendMessage(handler.obtainMessage(7, i, -1, new C3368m0(abstractC3345b2, 0)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC3345b abstractC3345b;
        synchronized (this.f9533k.f9484i) {
            abstractC3345b = this.f9533k;
            abstractC3345b.f9485j = null;
        }
        Handler handler = abstractC3345b.f9482g;
        handler.sendMessage(handler.obtainMessage(6, this.f9532j, 1));
    }
}
