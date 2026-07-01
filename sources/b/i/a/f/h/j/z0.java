package b.i.a.f.h.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {
    public static boolean a(Context context, String str, boolean z2) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            return receiverInfo != null && receiverInfo.enabled && (!z2 || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
