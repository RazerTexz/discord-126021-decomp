package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.n4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4125n4 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC4158q4 f10990a;

    public C4125n4(InterfaceC4158q4 interfaceC4158q4) {
        this.f10990a = interfaceC4158q4;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5761a(Context context) {
        ActivityInfo receiverInfo;
        Objects.requireNonNull(context, "null reference");
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
