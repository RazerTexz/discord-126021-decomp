package p007b.p225i.p361c.p406w;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.messaging.FirebaseMessagingService;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p393p.InterfaceC4782a;
import p007b.p225i.p361c.p393p.p395h.C4793d;
import p007b.p225i.p361c.p393p.p395h.C4794e;

/* JADX INFO: renamed from: b.i.c.w.q */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4879q {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4782a f13038a;

    static {
        C4794e c4794e = new C4794e();
        c4794e.f12822b.put(C4875m.b.class, new C4875m.c());
        c4794e.f12823c.remove(C4875m.b.class);
        c4794e.f12822b.put(C4875m.class, new C4875m.a());
        c4794e.f12823c.remove(C4875m.class);
        f13038a = new C4793d(c4794e);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m6817a(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: b */
    public static void m6818b(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String strM6817a = m6817a(intent);
        if (strM6817a != null) {
            bundle.putString("_nt", strM6817a);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        String stringExtra6 = intent.hasExtra("google.c.a.udt") ? intent.getStringExtra("google.c.a.udt") : null;
        if (stringExtra6 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(stringExtra6));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        String str2 = (intent.getExtras() == null || !C4880r.m6820f(intent.getExtras())) ? "data" : "display";
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str2);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String strValueOf = String.valueOf(bundle);
            Log.d("FirebaseMessaging", C1643a.m861l(strValueOf.length() + str.length() + 37, "Logging to scion event=", str, " scionPayload=", strValueOf));
        }
        C4542c c4542cM6327b = C4542c.m6327b();
        c4542cM6327b.m6330a();
        InterfaceC4549a interfaceC4549a = (InterfaceC4549a) c4542cM6327b.f12121g.mo6346a(InterfaceC4549a.class);
        if (interfaceC4549a != null) {
            interfaceC4549a.mo6338a("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m6819c(Intent intent) {
        if (intent == null || FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction())) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }
}
