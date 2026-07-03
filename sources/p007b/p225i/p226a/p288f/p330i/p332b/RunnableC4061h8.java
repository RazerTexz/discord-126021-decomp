package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.h8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4061h8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f10786j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f10787k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f10788l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ String f10789m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ boolean f10790n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ zzn f10791o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C4161q7 f10792p;

    public RunnableC4061h8(C4161q7 c4161q7, AtomicReference atomicReference, String str, String str2, String str3, boolean z2, zzn zznVar) {
        this.f10792p = c4161q7;
        this.f10786j = atomicReference;
        this.f10787k = str;
        this.f10788l = str2;
        this.f10789m = str3;
        this.f10790n = z2;
        this.f10791o = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10786j) {
            try {
                try {
                    C4161q7 c4161q7 = this.f10792p;
                    InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
                    if (interfaceC4068i3 == null) {
                        c4161q7.mo5726g().f11141f.m5863d("(legacy) Failed to get user properties; not connected to service", C4157q3.m5788s(this.f10787k), this.f10788l, this.f10789m);
                        this.f10786j.set(Collections.emptyList());
                        this.f10786j.notify();
                    } else {
                        if (TextUtils.isEmpty(this.f10787k)) {
                            this.f10786j.set(interfaceC4068i3.mo5671R(this.f10788l, this.f10789m, this.f10790n, this.f10791o));
                        } else {
                            this.f10786j.set(interfaceC4068i3.mo5680u(this.f10787k, this.f10788l, this.f10789m, this.f10790n));
                        }
                        this.f10792p.m5808F();
                        this.f10786j.notify();
                    }
                } catch (RemoteException e) {
                    this.f10792p.mo5726g().f11141f.m5863d("(legacy) Failed to get user properties; remote exception", C4157q3.m5788s(this.f10787k), this.f10788l, e);
                    this.f10786j.set(Collections.emptyList());
                    this.f10786j.notify();
                }
            } catch (Throwable th) {
                this.f10786j.notify();
                throw th;
            }
        }
    }
}
