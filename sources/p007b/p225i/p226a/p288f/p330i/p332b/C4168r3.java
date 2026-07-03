package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3351e;

/* JADX INFO: renamed from: b.i.a.f.i.b.r3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4168r3 extends AbstractC3345b<InterfaceC4068i3> {
    public C4168r3(Context context, Looper looper, AbstractC3345b.a aVar, AbstractC3345b.b bVar) {
        super(context, looper, AbstractC3351e.m4152a(context), C3256c.f9307b, 93, aVar, bVar, null);
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
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC4068i3 ? (InterfaceC4068i3) iInterfaceQueryLocalInterface : new C4091k3(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.measurement.START";
    }
}
