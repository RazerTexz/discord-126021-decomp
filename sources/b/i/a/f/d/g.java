package b.i.a.f.d;

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
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements ServiceConnection {
    public p l;
    public final /* synthetic */ f o;
    public int j = 0;
    public final Messenger k = new Messenger(new b.i.a.f.h.f.a(Looper.getMainLooper(), new Handler.Callback(this) { // from class: b.i.a.f.d.j
        public final g j;

        {
            this.j = this;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            g gVar = this.j;
            Objects.requireNonNull(gVar);
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i);
                Log.d("MessengerIpcClient", sb.toString());
            }
            synchronized (gVar) {
                q<?> qVar = gVar.n.get(i);
                if (qVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                gVar.n.remove(i);
                gVar.c();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    qVar.b(new zzp(4, "Not supported by GmsCore"));
                    return true;
                }
                qVar.a(data);
                return true;
            }
        }
    }));
    public final Queue<q<?>> m = new ArrayDeque();
    public final SparseArray<q<?>> n = new SparseArray<>();

    public g(f fVar, h hVar) {
        this.o = fVar;
    }

    public final synchronized void a(int i, @Nullable String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
        }
        int i2 = this.j;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.j = 4;
                return;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.j;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.j = 4;
        b.i.a.f.e.n.a.b().c(this.o.f1339b, this);
        zzp zzpVar = new zzp(i, str);
        Iterator<q<?>> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().b(zzpVar);
        }
        this.m.clear();
        for (int i4 = 0; i4 < this.n.size(); i4++) {
            this.n.valueAt(i4).b(zzpVar);
        }
        this.n.clear();
    }

    public final synchronized boolean b(q<?> qVar) {
        int i = this.j;
        if (i == 0) {
            this.m.add(qVar);
            AnimatableValueParser.F(this.j == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.j = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (b.i.a.f.e.n.a.b().a(this.o.f1339b, intent, this, 1)) {
                this.o.c.schedule(new Runnable(this) { // from class: b.i.a.f.d.i
                    public final g j;

                    {
                        this.j = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar = this.j;
                        synchronized (gVar) {
                            if (gVar.j == 1) {
                                gVar.a(1, "Timed out while binding");
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.m.add(qVar);
            return true;
        }
        if (i == 2) {
            this.m.add(qVar);
            this.o.c.execute(new k(this));
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.j;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    public final synchronized void c() {
        if (this.j == 2 && this.m.isEmpty() && this.n.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.j = 3;
            b.i.a.f.e.n.a.b().c(this.o.f1339b, this);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.o.c.execute(new Runnable(this, iBinder) { // from class: b.i.a.f.d.l
            public final g j;
            public final IBinder k;

            {
                this.j = this;
                this.k = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g gVar = this.j;
                IBinder iBinder2 = this.k;
                synchronized (gVar) {
                    try {
                        if (iBinder2 == null) {
                            gVar.a(0, "Null service connection");
                            return;
                        }
                        try {
                            gVar.l = new p(iBinder2);
                            gVar.j = 2;
                            gVar.o.c.execute(new k(gVar));
                        } catch (RemoteException e) {
                            gVar.a(0, e.getMessage());
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
        this.o.c.execute(new Runnable(this) { // from class: b.i.a.f.d.n
            public final g j;

            {
                this.j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.j.a(2, "Service disconnected");
            }
        });
    }
}
