package p007b.p225i.p226a.p288f.p298d;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p313h.p319f.HandlerC3480a;

/* JADX INFO: renamed from: b.i.a.f.d.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC3232g implements ServiceConnection {

    /* JADX INFO: renamed from: l */
    public C3241p f9265l;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3231f f9268o;

    /* JADX INFO: renamed from: j */
    public int f9263j = 0;

    /* JADX INFO: renamed from: k */
    public final Messenger f9264k = new Messenger(new HandlerC3480a(Looper.getMainLooper(), new Handler.Callback(this) { // from class: b.i.a.f.d.j

        /* JADX INFO: renamed from: j */
        public final ServiceConnectionC3232g f9270j;

        {
            this.f9270j = this;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            ServiceConnectionC3232g serviceConnectionC3232g = this.f9270j;
            Objects.requireNonNull(serviceConnectionC3232g);
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i);
                Log.d("MessengerIpcClient", sb.toString());
            }
            synchronized (serviceConnectionC3232g) {
                AbstractC3242q<?> abstractC3242q = serviceConnectionC3232g.f9267n.get(i);
                if (abstractC3242q == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                serviceConnectionC3232g.f9267n.remove(i);
                serviceConnectionC3232g.m4005c();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    abstractC3242q.m4008b(new zzp(4, "Not supported by GmsCore"));
                    return true;
                }
                abstractC3242q.mo4006a(data);
                return true;
            }
        }
    }));

    /* JADX INFO: renamed from: m */
    public final Queue<AbstractC3242q<?>> f9266m = new ArrayDeque();

    /* JADX INFO: renamed from: n */
    public final SparseArray<AbstractC3242q<?>> f9267n = new SparseArray<>();

    public ServiceConnectionC3232g(C3231f c3231f, C3233h c3233h) {
        this.f9268o = c3231f;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4003a(int i, @Nullable String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
        }
        int i2 = this.f9263j;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.f9263j = 4;
                return;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.f9263j;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f9263j = 4;
        C3398a.m4181b().m4183c(this.f9268o.f9259b, this);
        zzp zzpVar = new zzp(i, str);
        Iterator<AbstractC3242q<?>> it = this.f9266m.iterator();
        while (it.hasNext()) {
            it.next().m4008b(zzpVar);
        }
        this.f9266m.clear();
        for (int i4 = 0; i4 < this.f9267n.size(); i4++) {
            this.f9267n.valueAt(i4).m4008b(zzpVar);
        }
        this.f9267n.clear();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized boolean m4004b(AbstractC3242q<?> abstractC3242q) {
        int i = this.f9263j;
        if (i == 0) {
            this.f9266m.add(abstractC3242q);
            C1460d.m432F(this.f9263j == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f9263j = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (C3398a.m4181b().m4182a(this.f9268o.f9259b, intent, this, 1)) {
                this.f9268o.f9260c.schedule(new Runnable(this) { // from class: b.i.a.f.d.i

                    /* JADX INFO: renamed from: j */
                    public final ServiceConnectionC3232g f9269j;

                    {
                        this.f9269j = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ServiceConnectionC3232g serviceConnectionC3232g = this.f9269j;
                        synchronized (serviceConnectionC3232g) {
                            if (serviceConnectionC3232g.f9263j == 1) {
                                serviceConnectionC3232g.m4003a(1, "Timed out while binding");
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                m4003a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.f9266m.add(abstractC3242q);
            return true;
        }
        if (i == 2) {
            this.f9266m.add(abstractC3242q);
            this.f9268o.f9260c.execute(new RunnableC3236k(this));
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.f9263j;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final synchronized void m4005c() {
        if (this.f9263j == 2 && this.f9266m.isEmpty() && this.f9267n.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f9263j = 3;
            C3398a.m4181b().m4183c(this.f9268o.f9259b, this);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f9268o.f9260c.execute(new Runnable(this, iBinder) { // from class: b.i.a.f.d.l

            /* JADX INFO: renamed from: j */
            public final ServiceConnectionC3232g f9272j;

            /* JADX INFO: renamed from: k */
            public final IBinder f9273k;

            {
                this.f9272j = this;
                this.f9273k = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ServiceConnectionC3232g serviceConnectionC3232g = this.f9272j;
                IBinder iBinder2 = this.f9273k;
                synchronized (serviceConnectionC3232g) {
                    try {
                        if (iBinder2 == null) {
                            serviceConnectionC3232g.m4003a(0, "Null service connection");
                            return;
                        }
                        try {
                            serviceConnectionC3232g.f9265l = new C3241p(iBinder2);
                            serviceConnectionC3232g.f9263j = 2;
                            serviceConnectionC3232g.f9268o.f9260c.execute(new RunnableC3236k(serviceConnectionC3232g));
                        } catch (RemoteException e) {
                            serviceConnectionC3232g.m4003a(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f9268o.f9260c.execute(new Runnable(this) { // from class: b.i.a.f.d.n

            /* JADX INFO: renamed from: j */
            public final ServiceConnectionC3232g f9276j;

            {
                this.f9276j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f9276j.m4003a(2, "Service disconnected");
            }
        });
    }
}
