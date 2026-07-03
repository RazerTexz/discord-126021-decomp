package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* JADX INFO: renamed from: b.i.a.f.i.b.i8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4073i8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f10822j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10823k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ zzn f10824l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ InterfaceC3660fc f10825m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4161q7 f10826n;

    public RunnableC4073i8(C4161q7 c4161q7, String str, String str2, zzn zznVar, InterfaceC3660fc interfaceC3660fc) {
        this.f10826n = c4161q7;
        this.f10822j = str;
        this.f10823k = str2;
        this.f10824l = zznVar;
        this.f10825m = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                C4161q7 c4161q7 = this.f10826n;
                InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                if (interfaceC4068i3 == null) {
                    c4161q7.mo5726g().f11141f.m5862c("Failed to get conditional properties; not connected to service", this.f10822j, this.f10823k);
                    this.f10826n.m5866e().m5900N(this.f10825m, arrayList);
                } else {
                    ArrayList<Bundle> arrayListM5881j0 = C4196t9.m5881j0(interfaceC4068i3.mo5670K(this.f10822j, this.f10823k, this.f10824l));
                    this.f10826n.m5808F();
                    this.f10826n.m5866e().m5900N(this.f10825m, arrayListM5881j0);
                }
            } catch (RemoteException e) {
                this.f10826n.mo5726g().f11141f.m5863d("Failed to get conditional properties; remote exception", this.f10822j, this.f10823k, e);
                this.f10826n.m5866e().m5900N(this.f10825m, arrayList);
            }
        } catch (Throwable th) {
            this.f10826n.m5866e().m5900N(this.f10825m, arrayList);
            throw th;
        }
    }
}
