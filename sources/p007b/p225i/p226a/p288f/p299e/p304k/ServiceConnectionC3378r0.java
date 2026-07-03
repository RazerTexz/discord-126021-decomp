package p007b.p225i.p226a.p288f.p299e.p304k;

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
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;

/* JADX INFO: renamed from: b.i.a.f.e.k.r0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConnectionC3378r0 implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public final Map<ServiceConnection, ServiceConnection> f9553j = new HashMap();

    /* JADX INFO: renamed from: k */
    public int f9554k = 2;

    /* JADX INFO: renamed from: l */
    public boolean f9555l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public IBinder f9556m;

    /* JADX INFO: renamed from: n */
    public final C3376q0 f9557n;

    /* JADX INFO: renamed from: o */
    public ComponentName f9558o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C3382t0 f9559p;

    public ServiceConnectionC3378r0(C3382t0 c3382t0, C3376q0 c3376q0) {
        this.f9559p = c3382t0;
        this.f9557n = c3376q0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b8  */
    /* JADX INFO: renamed from: a */
    public final void m4176a(String str) {
        Intent intent;
        boolean zM4184d;
        Bundle bundleCall;
        this.f9554k = 3;
        C3382t0 c3382t0 = this.f9559p;
        C3398a c3398a = c3382t0.f9567f;
        Context context = c3382t0.f9565d;
        C3376q0 c3376q0 = this.f9557n;
        Intent component = null;
        if (c3376q0.f9547b != null) {
            if (c3376q0.f9550e) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", c3376q0.f9547b);
                try {
                    bundleCall = context.getContentResolver().call(C3376q0.f9546a, "serviceIntentCall", (String) null, bundle);
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
                    String strValueOf2 = String.valueOf(c3376q0.f9547b);
                    Log.w("ConnectionStatusConfig", strValueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(strValueOf2) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            if (component == null) {
                intent = new Intent(c3376q0.f9547b).setPackage(c3376q0.f9548c);
            }
            zM4184d = c3398a.m4184d(context, str, intent, this, this.f9557n.f9549d, true);
            this.f9555l = zM4184d;
            if (zM4184d) {
                Message messageObtainMessage = this.f9559p.f9566e.obtainMessage(1, this.f9557n);
                C3382t0 c3382t1 = this.f9559p;
                c3382t1.f9566e.sendMessageDelayed(messageObtainMessage, c3382t1.f9569h);
            } else {
                this.f9554k = 2;
                try {
                    C3382t0 c3382t2 = this.f9559p;
                    c3382t2.f9567f.m4183c(c3382t2.f9565d, this);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
        component = new Intent().setComponent(null);
        intent = component;
        zM4184d = c3398a.m4184d(context, str, intent, this, this.f9557n.f9549d, true);
        this.f9555l = zM4184d;
        if (zM4184d) {
            Message messageObtainMessage2 = this.f9559p.f9566e.obtainMessage(1, this.f9557n);
            C3382t0 c3382t3 = this.f9559p;
            c3382t3.f9566e.sendMessageDelayed(messageObtainMessage2, c3382t3.f9569h);
        } else {
            this.f9554k = 2;
            C3382t0 c3382t4 = this.f9559p;
            c3382t4.f9567f.m4183c(c3382t4.f9565d, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f9559p.f9564c) {
            this.f9559p.f9566e.removeMessages(1, this.f9557n);
            this.f9556m = iBinder;
            this.f9558o = componentName;
            Iterator<ServiceConnection> it = this.f9553j.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f9554k = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f9559p.f9564c) {
            this.f9559p.f9566e.removeMessages(1, this.f9557n);
            this.f9556m = null;
            this.f9558o = componentName;
            Iterator<ServiceConnection> it = this.f9553j.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f9554k = 2;
        }
    }
}
