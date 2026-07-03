package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

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
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzj;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;
import p007b.p225i.p226a.p288f.p333j.C4263a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.f */
/* JADX INFO: loaded from: classes3.dex */
public final class C4280f extends AbstractC3349d<InterfaceC4311u0> {

    /* JADX INFO: renamed from: A */
    public final C3938o<C3301k.a, IBinder> f11408A;

    /* JADX INFO: renamed from: B */
    public final ClientAppContext f11409B;

    /* JADX INFO: renamed from: C */
    public final int f11410C;

    @TargetApi(14)
    public C4280f(Context context, Looper looper, AbstractC3268c.a aVar, AbstractC3268c.b bVar, C3347c c3347c, C4264a c4264a) {
        int i;
        super(context, looper, 62, c3347c, aVar, bVar);
        this.f11408A = new C3938o<>();
        String str = c3347c.f9505e;
        int i2 = context instanceof Activity ? 1 : context instanceof Application ? 2 : context instanceof Service ? 3 : 0;
        if (c4264a != null) {
            this.f11409B = new ClientAppContext(str, null, false, null, i2);
            i = c4264a.f11403j;
        } else {
            this.f11409B = new ClientAppContext(str, null, false, null, i2);
            i = -1;
        }
        this.f11410C = i;
        if (i2 == 1) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new C4284h(activity, this, null));
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m5982G(int i) throws RemoteException {
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
        if (!m4134j()) {
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            }
        } else {
            zzj zzjVar = new zzj(i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
            }
            ((InterfaceC4311u0) m4142w()).mo5993i0(zzjVar);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: h */
    public final void mo4036h() {
        try {
            m5982G(2);
        } catch (RemoteException e) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
            }
        }
        this.f11408A.f10465a.clear();
        super.mo4036h();
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: k */
    public final boolean mo4039k() {
        return C4263a.m5980a(this.f9479d);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC4311u0 ? (InterfaceC4311u0) iInterfaceQueryLocalInterface : new C4313v0(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: u */
    public final Bundle mo4140u() {
        Bundle bundle = new Bundle();
        bundle.putInt("NearbyPermissions", this.f11410C);
        bundle.putParcelable("ClientAppContext", this.f11409B);
        return bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }
}
