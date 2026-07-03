package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/* JADX INFO: renamed from: b.i.a.f.h.j.z0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3555z0 {
    /* JADX INFO: renamed from: a */
    public static boolean m4515a(Context context, String str, boolean z2) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            return receiverInfo != null && receiverInfo.enabled && (!z2 || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
