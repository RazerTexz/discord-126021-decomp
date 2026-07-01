package b.d.a.a;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Callable {
    public final /* synthetic */ n j;

    public /* synthetic */ m(n nVar) {
        this.j = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int iN;
        n nVar = this.j;
        synchronized (nVar.j) {
            if (!nVar.k) {
                int i = 3;
                try {
                    String packageName = nVar.m.e.getPackageName();
                    int i2 = 16;
                    iN = 3;
                    while (true) {
                        if (i2 < 3) {
                            i2 = 0;
                            break;
                        }
                        try {
                            iN = nVar.m.f.N(i2, packageName, "subs");
                            if (iN == 0) {
                                break;
                            }
                            i2--;
                        } catch (Exception unused) {
                            i = iN;
                            b.i.a.f.h.n.a.f("BillingClient", "Exception while checking if billing is supported; try to reconnect");
                            nVar.m.a = 0;
                            nVar.m.f = null;
                            iN = i;
                        }
                    }
                    Objects.requireNonNull(nVar.m);
                    boolean z2 = true;
                    nVar.m.h = i2 >= 3;
                    if (i2 < 3) {
                        b.i.a.f.h.n.a.e("BillingClient", "In-app billing API does not support subscription on this device.");
                    }
                    for (int i3 = 16; i3 >= 3; i3--) {
                        iN = nVar.m.f.N(i3, packageName, "inapp");
                        if (iN == 0) {
                            nVar.m.i = i3;
                            break;
                        }
                    }
                    a aVar = nVar.m;
                    int i4 = aVar.i;
                    aVar.o = i4 >= 16;
                    aVar.n = i4 >= 15;
                    aVar.m = i4 >= 14;
                    aVar.l = i4 >= 10;
                    aVar.k = i4 >= 9;
                    if (i4 < 6) {
                        z2 = false;
                    }
                    aVar.j = z2;
                    if (i4 < 3) {
                        b.i.a.f.h.n.a.f("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    }
                    if (iN == 0) {
                        nVar.m.a = 2;
                    } else {
                        nVar.m.a = 0;
                        nVar.m.f = null;
                    }
                } catch (Exception unused2) {
                }
                if (iN == 0) {
                    nVar.a(p.i);
                } else {
                    nVar.a(p.a);
                }
            }
        }
        return null;
    }
}
