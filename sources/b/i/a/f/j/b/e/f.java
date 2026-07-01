package b.i.a.f.j.b.e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.c$a;
import b.i.a.f.e.h.c$b;
import b.i.a.f.e.h.j.k$a;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzj;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b.i.a.f.e.k.d<u0> {
    public final b.i.a.f.h.m.o<k$a, IBinder> A;
    public final ClientAppContext B;
    public final int C;

    @TargetApi(14)
    public f(Context context, Looper looper, c$a c_a, c$b c_b, b.i.a.f.e.k.c cVar, b.i.a.f.j.b.a aVar) {
        int i;
        super(context, looper, 62, cVar, c_a, c_b);
        this.A = new b.i.a.f.h.m.o<>();
        String str = cVar.e;
        int i2 = context instanceof Activity ? 1 : context instanceof Application ? 2 : context instanceof Service ? 3 : 0;
        if (aVar != null) {
            this.B = new ClientAppContext(str, null, false, null, i2);
            i = aVar.j;
        } else {
            this.B = new ClientAppContext(str, null, false, null, i2);
            i = -1;
        }
        this.C = i;
        if (i2 == 1) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new h(activity, this, null));
        }
    }

    public final void G(int i) throws RemoteException {
        String str;
        if (i == 1) {
            str = "ACTIVITY_STOPPED";
        } else {
            if (i != 2) {
                if (Log.isLoggable("NearbyMessagesClient", 5)) {
                    Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
                    return;
                }
                return;
            }
            str = "CLIENT_DISCONNECTED";
        }
        if (!j()) {
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            }
        } else {
            zzj zzjVar = new zzj(i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((u0) w()).i0(zzjVar);
        }
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final void h() {
        try {
            G(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.A.a.clear();
        super.h();
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final boolean k() {
        return b.i.a.f.j.a.a(this.d);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return iInterfaceQueryLocalInterface instanceof u0 ? (u0) iInterfaceQueryLocalInterface : new v0(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final Bundle u() {
        Bundle bundle = new Bundle();
        bundle.putInt("NearbyPermissions", this.C);
        bundle.putParcelable("ClientAppContext", this.B);
        return bundle;
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String x() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String y() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }
}
