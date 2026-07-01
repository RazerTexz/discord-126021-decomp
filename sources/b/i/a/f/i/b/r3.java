package b.i.a.f.i.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import b.i.a.f.e.k.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r3 extends b.i.a.f.e.k.b<i3> {
    public r3(Context context, Looper looper, b.a aVar, b.InterfaceC0037b interfaceC0037b) {
        super(context, looper, b.i.a.f.e.k.e.a(context), b.i.a.f.e.c.f1346b, 93, aVar, interfaceC0037b, null);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof i3 ? (i3) iInterfaceQueryLocalInterface : new k3(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String x() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String y() {
        return "com.google.android.gms.measurement.START";
    }
}
