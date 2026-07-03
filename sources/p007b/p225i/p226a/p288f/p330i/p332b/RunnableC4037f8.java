package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.f8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4037f8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f10726j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10727k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10728l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ String f10729m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ zzn f10730n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C4161q7 f10731o;

    public RunnableC4037f8(C4161q7 c4161q7, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.f10731o = c4161q7;
        this.f10726j = atomicReference;
        this.f10727k = str;
        this.f10728l = str2;
        this.f10729m = str3;
        this.f10730n = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10726j) {
            try {
                try {
                    C4161q7 c4161q7 = this.f10731o;
                    InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                    if (interfaceC4068i3 == null) {
                        c4161q7.mo5726g().f11141f.m5863d("(legacy) Failed to get conditional properties; not connected to service", C4157q3.m5788s(this.f10727k), this.f10728l, this.f10729m);
                        this.f10726j.set(Collections.emptyList());
                        this.f10726j.notify();
                    } else {
                        if (TextUtils.isEmpty(this.f10727k)) {
                            this.f10726j.set(interfaceC4068i3.mo5670K(this.f10728l, this.f10729m, this.f10730n));
                        } else {
                            this.f10726j.set(interfaceC4068i3.mo5669J(this.f10727k, this.f10728l, this.f10729m));
                        }
                        this.f10731o.m5808F();
                        this.f10726j.notify();
                    }
                } catch (RemoteException e) {
                    this.f10731o.mo5726g().f11141f.m5863d("(legacy) Failed to get conditional properties; remote exception", C4157q3.m5788s(this.f10727k), this.f10728l, e);
                    this.f10726j.set(Collections.emptyList());
                    this.f10726j.notify();
                }
            } catch (Throwable th) {
                this.f10726j.notify();
                throw th;
            }
        }
    }
}
