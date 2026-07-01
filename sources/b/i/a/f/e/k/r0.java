package b.i.a.f.e.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements ServiceConnection {
    public final Map<ServiceConnection, ServiceConnection> j = new HashMap();
    public int k = 2;
    public boolean l;

    @Nullable
    public IBinder m;
    public final q0 n;
    public ComponentName o;
    public final /* synthetic */ t0 p;

    public r0(t0 t0Var, q0 q0Var) {
        this.p = t0Var;
        this.n = q0Var;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b8  */
    public final void a(String str) {
        Intent intent;
        boolean zD;
        Bundle bundleCall;
        this.k = 3;
        t0 t0Var = this.p;
        b.i.a.f.e.n.a aVar = t0Var.f;
        Context context = t0Var.d;
        q0 q0Var = this.n;
        Intent component = null;
        if (q0Var.f1391b != null) {
            if (q0Var.e) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", q0Var.f1391b);
                try {
                    bundleCall = context.getContentResolver().call(q0.a, "serviceIntentCall", (String) null, bundle);
                } catch (IllegalArgumentException e) {
                    String strValueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                    sb.append("Dynamic intent resolution failed: ");
                    sb.append(strValueOf);
                    Log.w("ConnectionStatusConfig", sb.toString());
                    bundleCall = null;
                }
                component = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
                if (component == null) {
                    String strValueOf2 = String.valueOf(q0Var.f1391b);
                    Log.w("ConnectionStatusConfig", strValueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(strValueOf2) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            if (component == null) {
                intent = new Intent(q0Var.f1391b).setPackage(q0Var.c);
            }
            zD = aVar.d(context, str, intent, this, this.n.d, true);
            this.l = zD;
            if (zD) {
                Message messageObtainMessage = this.p.e.obtainMessage(1, this.n);
                t0 t0Var2 = this.p;
                t0Var2.e.sendMessageDelayed(messageObtainMessage, t0Var2.h);
            } else {
                this.k = 2;
                try {
                    t0 t0Var3 = this.p;
                    t0Var3.f.c(t0Var3.d, this);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
        component = new Intent().setComponent(null);
        intent = component;
        zD = aVar.d(context, str, intent, this, this.n.d, true);
        this.l = zD;
        if (zD) {
            Message messageObtainMessage2 = this.p.e.obtainMessage(1, this.n);
            t0 t0Var4 = this.p;
            t0Var4.e.sendMessageDelayed(messageObtainMessage2, t0Var4.h);
        } else {
            this.k = 2;
            t0 t0Var5 = this.p;
            t0Var5.f.c(t0Var5.d, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.p.c) {
            this.p.e.removeMessages(1, this.n);
            this.m = iBinder;
            this.o = componentName;
            Iterator<ServiceConnection> it = this.j.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.k = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.p.c) {
            this.p.e.removeMessages(1, this.n);
            this.m = null;
            this.o = componentName;
            Iterator<ServiceConnection> it = this.j.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.k = 2;
        }
    }
}
