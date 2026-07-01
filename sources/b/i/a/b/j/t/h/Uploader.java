package b.i.a.b.j.t.h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.g, reason: use source file name */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Uploader implements Runnable {
    public final Uploader6 j;
    public final TransportContext k;
    public final int l;
    public final Runnable m;

    public Uploader(Uploader6 uploader6, TransportContext transportContext, int i, Runnable runnable) {
        this.j = uploader6;
        this.k = transportContext;
        this.l = i;
        this.m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        final Uploader6 uploader6 = this.j;
        final TransportContext transportContext = this.k;
        final int i = this.l;
        Runnable runnable = this.m;
        try {
            try {
                SynchronizationGuard synchronizationGuard = uploader6.f;
                final EventStore eventStore = uploader6.c;
                eventStore.getClass();
                synchronizationGuard.a(new SynchronizationGuard.a(eventStore) { // from class: b.i.a.b.j.t.h.j
                    public final EventStore a;

                    {
                        this.a = eventStore;
                    }

                    @Override // b.i.a.b.j.u.SynchronizationGuard.a
                    public Object execute() {
                        return Integer.valueOf(this.a.l());
                    }
                });
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader6.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    uploader6.a(transportContext, i);
                } else {
                    uploader6.f.a(new SynchronizationGuard.a(uploader6, transportContext, i) { // from class: b.i.a.b.j.t.h.k
                        public final Uploader6 a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final TransportContext f790b;
                        public final int c;

                        {
                            this.a = uploader6;
                            this.f790b = transportContext;
                            this.c = i;
                        }

                        @Override // b.i.a.b.j.u.SynchronizationGuard.a
                        public Object execute() {
                            Uploader6 uploader7 = this.a;
                            uploader7.d.a(this.f790b, this.c + 1);
                            return null;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                uploader6.d.a(transportContext, i + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
