package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.g */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2479g implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C2484l f5370j;

    /* JADX INFO: renamed from: k */
    public final AbstractC2442i f5371k;

    /* JADX INFO: renamed from: l */
    public final int f5372l;

    /* JADX INFO: renamed from: m */
    public final Runnable f5373m;

    public RunnableC2479g(C2484l c2484l, AbstractC2442i abstractC2442i, int i, Runnable runnable) {
        this.f5370j = c2484l;
        this.f5371k = abstractC2442i;
        this.f5372l = i;
        this.f5373m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        final C2484l c2484l = this.f5370j;
        final AbstractC2442i abstractC2442i = this.f5371k;
        final int i = this.f5372l;
        Runnable runnable = this.f5373m;
        try {
            try {
                InterfaceC2518a interfaceC2518a = c2484l.f5390f;
                final InterfaceC2494c interfaceC2494c = c2484l.f5387c;
                interfaceC2494c.getClass();
                interfaceC2518a.mo2406a(new InterfaceC2518a.a(interfaceC2494c) { // from class: b.i.a.b.j.t.h.j

                    /* JADX INFO: renamed from: a */
                    public final InterfaceC2494c f5381a;

                    {
                        this.f5381a = interfaceC2494c;
                    }

                    @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
                    public Object execute() {
                        return Integer.valueOf(this.f5381a.mo2396l());
                    }
                });
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) c2484l.f5385a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    c2484l.m2385a(abstractC2442i, i);
                } else {
                    c2484l.f5390f.mo2406a(new InterfaceC2518a.a(c2484l, abstractC2442i, i) { // from class: b.i.a.b.j.t.h.k

                        /* JADX INFO: renamed from: a */
                        public final C2484l f5382a;

                        /* JADX INFO: renamed from: b */
                        public final AbstractC2442i f5383b;

                        /* JADX INFO: renamed from: c */
                        public final int f5384c;

                        {
                            this.f5382a = c2484l;
                            this.f5383b = abstractC2442i;
                            this.f5384c = i;
                        }

                        @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
                        public Object execute() {
                            C2484l c2484l2 = this.f5382a;
                            c2484l2.f5388d.mo2382a(this.f5383b, this.f5384c + 1);
                            return null;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                c2484l.f5388d.mo2382a(abstractC2442i, i + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
