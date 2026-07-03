package p007b.p225i.p361c.p406w;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.i.c.w.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4863a {

    /* JADX INFO: renamed from: a */
    public static final AtomicInteger f13012a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX INFO: renamed from: a */
    public static PendingIntent m6814a(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, f13012a.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), BasicMeasure.EXACTLY);
    }

    @TargetApi(26)
    /* JADX INFO: renamed from: b */
    public static boolean m6815b(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }
}
