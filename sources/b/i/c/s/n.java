package b.i.c.s;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.t.Provider2;
import b.i.c.x.UserAgentPublisher;
import com.adjust.sdk.Constants;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class n {
    public final FirebaseApp2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f1769b;
    public final b.i.a.f.d.b c;
    public final Provider2<UserAgentPublisher> d;
    public final Provider2<HeartBeatInfo> e;
    public final b.i.c.u.g f;

    public n(FirebaseApp2 firebaseApp2, q qVar, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider3, b.i.c.u.g gVar) {
        firebaseApp2.a();
        b.i.a.f.d.b bVar = new b.i.a.f.d.b(firebaseApp2.d);
        this.a = firebaseApp2;
        this.f1769b = qVar;
        this.c = bVar;
        this.d = provider2;
        this.e = provider3;
        this.f = gVar;
    }

    public final Task<String> a(Task<Bundle> task) {
        Executor executor = h.a;
        return task.i(g.j, new b.i.a.f.n.a(this) { // from class: b.i.c.s.m
            public final n a;

            {
                this.a = this;
            }

            @Override // b.i.a.f.n.a
            public final Object a(Task task2) throws IOException {
                Objects.requireNonNull(this.a);
                Bundle bundle = (Bundle) task2.m(IOException.class);
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
                Log.w("FirebaseInstanceId", outline.j(strValueOf.length() + 21, "Unexpected response: ", strValueOf), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }

    public final Task<Bundle> b(String str, String str2, String str3, final Bundle bundle) {
        int i;
        String str4;
        String strEncodeToString;
        int i2;
        int i3;
        PackageInfo packageInfoB;
        HeartBeatInfo.a aVarA;
        PackageInfo packageInfoC;
        bundle.putString("scope", str3);
        bundle.putString(NotificationCompat.MessagingStyle.Message.KEY_SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        FirebaseApp2 firebaseApp2 = this.a;
        firebaseApp2.a();
        bundle.putString("gmp_app_id", firebaseApp2.f.f1655b);
        q qVar = this.f1769b;
        synchronized (qVar) {
            if (qVar.d == 0 && (packageInfoC = qVar.c("com.google.android.gms")) != null) {
                qVar.d = packageInfoC.versionCode;
            }
            i = qVar.d;
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f1769b.a());
        q qVar2 = this.f1769b;
        synchronized (qVar2) {
            if (qVar2.c == null) {
                qVar2.e();
            }
            str4 = qVar2.c;
        }
        bundle.putString("app_ver_name", str4);
        FirebaseApp2 firebaseApp3 = this.a;
        firebaseApp3.a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance(Constants.SHA1).digest(firebaseApp3.e.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String strA = ((b.i.c.u.k) b.i.a.f.e.o.f.j(this.f.a(false))).a();
            if (TextUtils.isEmpty(strA)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strA);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-".concat("21.0.0"));
        HeartBeatInfo heartBeatInfo = this.e.get();
        UserAgentPublisher userAgentPublisher = this.d.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (aVarA = heartBeatInfo.a("fire-iid")) != HeartBeatInfo.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarA.f()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
        final b.i.a.f.d.b bVar = this.c;
        b.i.a.f.d.r rVar = bVar.f;
        synchronized (rVar) {
            if (rVar.f1342b == 0 && (packageInfoB = rVar.b("com.google.android.gms")) != null) {
                rVar.f1342b = packageInfoB.versionCode;
            }
            i2 = rVar.f1342b;
        }
        if (i2 < 12000000) {
            return !(bVar.f.a() != 0) ? b.i.a.f.e.o.f.Y(new IOException("MISSING_INSTANCEID_SERVICE")) : bVar.b(bundle).j(b.i.a.f.d.z.j, new b.i.a.f.n.a(bVar, bundle) { // from class: b.i.a.f.d.v
                public final b a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final Bundle f1343b;

                {
                    this.a = bVar;
                    this.f1343b = bundle;
                }

                @Override // b.i.a.f.n.a
                public final Object a(Task task) {
                    b bVar2 = this.a;
                    Bundle bundle2 = this.f1343b;
                    Objects.requireNonNull(bVar2);
                    if (!task.p()) {
                        return task;
                    }
                    Bundle bundle3 = (Bundle) task.l();
                    return !(bundle3 != null && bundle3.containsKey("google.messenger")) ? task : bVar2.b(bundle2).r(z.j, w.a);
                }
            });
        }
        b.i.a.f.d.f fVarA = b.i.a.f.d.f.a(bVar.e);
        synchronized (fVarA) {
            i3 = fVarA.e;
            fVarA.e = i3 + 1;
        }
        return fVarA.b(new b.i.a.f.d.s(i3, bundle)).i(b.i.a.f.d.z.j, b.i.a.f.d.t.a);
    }
}
