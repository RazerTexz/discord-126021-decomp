package p007b.p225i.p361c.p398s;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p298d.C3227b;
import p007b.p225i.p226a.p288f.p298d.C3231f;
import p007b.p225i.p226a.p288f.p298d.C3243r;
import p007b.p225i.p226a.p288f.p298d.C3244s;
import p007b.p225i.p226a.p288f.p298d.C3245t;
import p007b.p225i.p226a.p288f.p298d.ExecutorC3251z;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p400t.InterfaceC4836a;
import p007b.p225i.p361c.p401u.AbstractC4847k;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: renamed from: b.i.c.s.n */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4823n {

    /* JADX INFO: renamed from: a */
    public final C4542c f12877a;

    /* JADX INFO: renamed from: b */
    public final C4826q f12878b;

    /* JADX INFO: renamed from: c */
    public final C3227b f12879c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC4836a<InterfaceC4896h> f12880d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC4836a<InterfaceC4803d> f12881e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4843g f12882f;

    public C4823n(C4542c c4542c, C4826q c4826q, InterfaceC4836a<InterfaceC4896h> interfaceC4836a, InterfaceC4836a<InterfaceC4803d> interfaceC4836a2, InterfaceC4843g interfaceC4843g) {
        c4542c.m6330a();
        C3227b c3227b = new C3227b(c4542c.f12118d);
        this.f12877a = c4542c;
        this.f12878b = c4826q;
        this.f12879c = c3227b;
        this.f12880d = interfaceC4836a;
        this.f12881e = interfaceC4836a2;
        this.f12882f = interfaceC4843g;
    }

    /* JADX INFO: renamed from: a */
    public final Task<String> m6727a(Task<Bundle> task) {
        Executor executor = C4817h.f12866a;
        return task.mo6014i(ExecutorC4816g.f12865j, new InterfaceC4353a(this) { // from class: b.i.c.s.m

            /* JADX INFO: renamed from: a */
            public final C4823n f12876a;

            {
                this.f12876a = this;
            }

            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
            /* JADX INFO: renamed from: a */
            public final Object mo4012a(Task task2) throws IOException {
                Objects.requireNonNull(this.f12876a);
                Bundle bundle = (Bundle) task2.mo6018m(IOException.class);
                if (bundle == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                String string = bundle.getString("registration_id");
                if (string != null || (string = bundle.getString("unregistered")) != null) {
                    return string;
                }
                String string2 = bundle.getString("error");
                if ("RST".equals(string2)) {
                    throw new IOException("INSTANCE_ID_RESET");
                }
                if (string2 != null) {
                    throw new IOException(string2);
                }
                String strValueOf = String.valueOf(bundle);
                Log.w("FirebaseInstanceId", C1643a.m857j(strValueOf.length() + 21, "Unexpected response: ", strValueOf), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final Task<Bundle> m6728b(String str, String str2, String str3, final Bundle bundle) {
        int i;
        String str4;
        String strEncodeToString;
        int i2;
        int i3;
        PackageInfo packageInfoM4011b;
        InterfaceC4803d.a aVarMo6716a;
        PackageInfo packageInfoM6732c;
        bundle.putString("scope", str3);
        bundle.putString(NotificationCompat.MessagingStyle.Message.KEY_SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        C4542c c4542c = this.f12877a;
        c4542c.m6330a();
        bundle.putString("gmp_app_id", c4542c.f12120f.f12135b);
        C4826q c4826q = this.f12878b;
        synchronized (c4826q) {
            if (c4826q.f12888d == 0 && (packageInfoM6732c = c4826q.m6732c("com.google.android.gms")) != null) {
                c4826q.f12888d = packageInfoM6732c.versionCode;
            }
            i = c4826q.f12888d;
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f12878b.m6731a());
        C4826q c4826q2 = this.f12878b;
        synchronized (c4826q2) {
            if (c4826q2.f12887c == null) {
                c4826q2.m6734e();
            }
            str4 = c4826q2.f12887c;
        }
        bundle.putString("app_ver_name", str4);
        C4542c c4542c2 = this.f12877a;
        c4542c2.m6330a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance(Constants.SHA1).digest(c4542c2.f12119e.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String strMo6750a = ((AbstractC4847k) C3404f.m4303j(this.f12882f.mo6756a(false))).mo6750a();
            if (TextUtils.isEmpty(strMo6750a)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strMo6750a);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-".concat("21.0.0"));
        InterfaceC4803d interfaceC4803d = this.f12881e.get();
        InterfaceC4896h interfaceC4896h = this.f12880d.get();
        if (interfaceC4803d != null && interfaceC4896h != null && (aVarMo6716a = interfaceC4803d.mo6716a("fire-iid")) != InterfaceC4803d.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarMo6716a.m6717f()));
            bundle.putString("Firebase-Client", interfaceC4896h.getUserAgent());
        }
        final C3227b c3227b = this.f12879c;
        C3243r c3243r = c3227b.f9248f;
        synchronized (c3243r) {
            if (c3243r.f9284b == 0 && (packageInfoM4011b = c3243r.m4011b("com.google.android.gms")) != null) {
                c3243r.f9284b = packageInfoM4011b.versionCode;
            }
            i2 = c3243r.f9284b;
        }
        if (i2 < 12000000) {
            return !(c3227b.f9248f.m4010a() != 0) ? C3404f.m4261Y(new IOException("MISSING_INSTANCEID_SERVICE")) : c3227b.m4000b(bundle).mo6015j(ExecutorC3251z.f9295j, new InterfaceC4353a(c3227b, bundle) { // from class: b.i.a.f.d.v

                /* JADX INFO: renamed from: a */
                public final C3227b f9288a;

                /* JADX INFO: renamed from: b */
                public final Bundle f9289b;

                {
                    this.f9288a = c3227b;
                    this.f9289b = bundle;
                }

                @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
                /* JADX INFO: renamed from: a */
                public final Object mo4012a(Task task) {
                    C3227b c3227b2 = this.f9288a;
                    Bundle bundle2 = this.f9289b;
                    Objects.requireNonNull(c3227b2);
                    if (!task.mo6021p()) {
                        return task;
                    }
                    Bundle bundle3 = (Bundle) task.mo6017l();
                    return !(bundle3 != null && bundle3.containsKey("google.messenger")) ? task : c3227b2.m4000b(bundle2).mo6023r(ExecutorC3251z.f9295j, C3248w.f9290a);
                }
            });
        }
        C3231f c3231fM4001a = C3231f.m4001a(c3227b.f9247e);
        synchronized (c3231fM4001a) {
            i3 = c3231fM4001a.f9262e;
            c3231fM4001a.f9262e = i3 + 1;
        }
        return c3231fM4001a.m4002b(new C3244s(i3, bundle)).mo6014i(ExecutorC3251z.f9295j, C3245t.f9286a);
    }
}
