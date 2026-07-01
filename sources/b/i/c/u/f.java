package b.i.c.u;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.trusted.sharing.ShareTarget;
import b.i.c.u.o.a$b;
import b.i.c.u.o.c$a;
import b.i.c.u.o.d$a;
import b.i.c.u.p.b$b;
import b.i.c.u.p.f$b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException$a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements g {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadFactory f1780b = new f$a();
    public final b.i.c.c c;
    public final b.i.c.u.p.c d;
    public final b.i.c.u.o.c e;
    public final n f;
    public final b.i.c.u.o.b g;
    public final l h;
    public final Object i;
    public final ExecutorService j;
    public final ExecutorService k;

    @GuardedBy("this")
    public String l;

    @GuardedBy("lock")
    public final List<m> m;

    public f(b.i.c.c cVar, @NonNull b.i.c.t.a<b.i.c.x.h> aVar, @NonNull b.i.c.t.a<b.i.c.r.d> aVar2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = f1780b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, threadFactory);
        cVar.a();
        b.i.c.u.p.c cVar2 = new b.i.c.u.p.c(cVar.d, aVar, aVar2);
        b.i.c.u.o.c cVar3 = new b.i.c.u.o.c(cVar);
        n nVarC = n.c();
        b.i.c.u.o.b bVar = new b.i.c.u.o.b(cVar);
        l lVar = new l();
        this.i = new Object();
        this.m = new ArrayList();
        this.c = cVar;
        this.d = cVar2;
        this.e = cVar3;
        this.f = nVarC;
        this.g = bVar;
        this.h = lVar;
        this.j = threadPoolExecutor;
        this.k = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    @NonNull
    public static f f() {
        b.i.c.c cVarB = b.i.c.c.b();
        b.c.a.a0.d.o(true, "Null is not a valid value of FirebaseApp.");
        cVarB.a();
        return (f) cVarB.g.a(g.class);
    }

    @Override // b.i.c.u.g
    @NonNull
    public Task<k> a(boolean z2) {
        h();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i iVar = new i(this.f, taskCompletionSource);
        synchronized (this.i) {
            this.m.add(iVar);
        }
        Task task = taskCompletionSource.a;
        this.j.execute(new d(this, z2));
        return task;
    }

    public final void b(boolean z2) {
        b.i.c.u.o.d dVarB;
        synchronized (a) {
            b.i.c.c cVar = this.c;
            cVar.a();
            b bVarA = b.a(cVar.d, "generatefid.lock");
            try {
                dVarB = this.e.b();
                if (dVarB.i()) {
                    String strI = i(dVarB);
                    b.i.c.u.o.c cVar2 = this.e;
                    a$b a_b = (a$b) dVarB.k();
                    a_b.a = strI;
                    a_b.b(c$a.UNREGISTERED);
                    dVarB = a_b.a();
                    cVar2.a(dVarB);
                }
                if (bVarA != null) {
                    bVarA.b();
                }
            } catch (Throwable th) {
                if (bVarA != null) {
                    bVarA.b();
                }
                throw th;
            }
        }
        if (z2) {
            a$b a_b2 = (a$b) dVarB.k();
            a_b2.c = null;
            dVarB = a_b2.a();
        }
        l(dVarB);
        this.k.execute(new e(this, z2));
    }

    public final b.i.c.u.o.d c(@NonNull b.i.c.u.o.d dVar) throws FirebaseInstallationsException {
        HttpURLConnection httpURLConnectionC;
        b.i.c.u.p.f fVarF;
        FirebaseInstallationsException$a firebaseInstallationsException$a = FirebaseInstallationsException$a.UNAVAILABLE;
        b.i.c.u.p.c cVar = this.d;
        String strD = d();
        b.i.c.u.o.a aVar = (b.i.c.u.o.a) dVar;
        String str = aVar.f1784b;
        String strG = g();
        String str2 = aVar.e;
        if (!cVar.f.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
        }
        URL urlA = cVar.a(String.format("projects/%s/installations/%s/authTokens:generate", strG, str));
        int i = 0;
        while (true) {
            if (i > 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
            }
            httpURLConnectionC = cVar.c(urlA, strD);
            try {
                httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str2);
                httpURLConnectionC.setDoOutput(true);
                cVar.h(httpURLConnectionC);
                int responseCode = httpURLConnectionC.getResponseCode();
                cVar.f.b(responseCode);
                if (responseCode >= 200 && responseCode < 300) {
                    fVarF = cVar.f(httpURLConnectionC);
                    break;
                }
                b.i.c.u.p.c.b(httpURLConnectionC, null, strD, strG);
                if (responseCode == 401 || responseCode == 404) {
                    b$b b_b = (b$b) b.i.c.u.p.f.a();
                    b_b.c = f$b.AUTH_ERROR;
                    fVarF = b_b.a();
                    break;
                }
                if (responseCode == 429) {
                    throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException$a.TOO_MANY_REQUESTS);
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    b$b b_b2 = (b$b) b.i.c.u.p.f.a();
                    b_b2.c = f$b.BAD_CONFIG;
                    fVarF = b_b2.a();
                    break;
                }
                httpURLConnectionC.disconnect();
                i++;
            } catch (IOException | AssertionError unused) {
            } catch (Throwable th) {
                httpURLConnectionC.disconnect();
                throw th;
            }
        }
        httpURLConnectionC.disconnect();
        b.i.c.u.p.b bVar = (b.i.c.u.p.b) fVarF;
        int iOrdinal = bVar.c.ordinal();
        if (iOrdinal == 0) {
            String str3 = bVar.a;
            long j = bVar.f1789b;
            long jB = this.f.b();
            a$b a_b = (a$b) dVar.k();
            a_b.c = str3;
            a_b.e = Long.valueOf(j);
            a_b.f = Long.valueOf(jB);
            return a_b.a();
        }
        if (iOrdinal == 1) {
            a$b a_b2 = (a$b) dVar.k();
            a_b2.g = "BAD CONFIG";
            a_b2.b(c$a.REGISTER_ERROR);
            return a_b2.a();
        }
        if (iOrdinal != 2) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
        }
        synchronized (this) {
            this.l = null;
        }
        d$a d_aK = dVar.k();
        d_aK.b(c$a.NOT_GENERATED);
        return d_aK.a();
    }

    @Nullable
    public String d() {
        b.i.c.c cVar = this.c;
        cVar.a();
        return cVar.f.a;
    }

    @VisibleForTesting
    public String e() {
        b.i.c.c cVar = this.c;
        cVar.a();
        return cVar.f.f1655b;
    }

    @Nullable
    public String g() {
        b.i.c.c cVar = this.c;
        cVar.a();
        return cVar.f.g;
    }

    @Override // b.i.c.u.g
    @NonNull
    public Task<String> getId() {
        String str;
        h();
        synchronized (this) {
            str = this.l;
        }
        if (str != null) {
            return b.i.a.f.e.o.f.Z(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        j jVar = new j(taskCompletionSource);
        synchronized (this.i) {
            this.m.add(jVar);
        }
        Task task = taskCompletionSource.a;
        this.j.execute(new c(this));
        return task;
    }

    public final void h() {
        b.c.a.a0.d.v(e(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        b.c.a.a0.d.v(g(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        b.c.a.a0.d.v(d(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String strE = e();
        Pattern pattern = n.f1783b;
        b.c.a.a0.d.o(strE.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        b.c.a.a0.d.o(n.f1783b.matcher(d()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String i(b.i.c.u.o.d dVar) {
        String string;
        b.i.c.c cVar = this.c;
        cVar.a();
        if (cVar.e.equals("CHIME_ANDROID_SDK") || this.c.h()) {
            if (((b.i.c.u.o.a) dVar).c == c$a.ATTEMPT_MIGRATION) {
                b.i.c.u.o.b bVar = this.g;
                synchronized (bVar.f1786b) {
                    synchronized (bVar.f1786b) {
                        string = bVar.f1786b.getString("|S|id", null);
                    }
                    if (string == null) {
                        string = bVar.a();
                    }
                }
                return TextUtils.isEmpty(string) ? this.h.a() : string;
            }
        }
        return this.h.a();
    }

    public final b.i.c.u.o.d j(b.i.c.u.o.d dVar) throws FirebaseInstallationsException {
        b.i.c.u.p.d dVarE;
        FirebaseInstallationsException$a firebaseInstallationsException$a = FirebaseInstallationsException$a.UNAVAILABLE;
        b.i.c.u.o.a aVar = (b.i.c.u.o.a) dVar;
        String str = aVar.f1784b;
        String string = null;
        if (str != null && str.length() == 11) {
            b.i.c.u.o.b bVar = this.g;
            synchronized (bVar.f1786b) {
                String[] strArr = b.i.c.u.o.b.a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    String string2 = bVar.f1786b.getString("|T|" + bVar.c + "|" + str2, null);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.startsWith("{")) {
                            try {
                                string = new JSONObject(string2).getString("token");
                            } catch (JSONException unused) {
                            }
                        } else {
                            string = string2;
                        }
                        break;
                    }
                    i++;
                }
            }
        }
        b.i.c.u.p.c cVar = this.d;
        String strD = d();
        String str3 = aVar.f1784b;
        String strG = g();
        String strE = e();
        if (!cVar.f.a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
        }
        URL urlA = cVar.a(String.format("projects/%s/installations", strG));
        int i2 = 0;
        while (true) {
            if (i2 > 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
            }
            HttpURLConnection httpURLConnectionC = cVar.c(urlA, strD);
            try {
                try {
                    httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    cVar.g(httpURLConnectionC, str3, strE);
                    int responseCode = httpURLConnectionC.getResponseCode();
                    cVar.f.b(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        dVarE = cVar.e(httpURLConnectionC);
                        httpURLConnectionC.disconnect();
                        break;
                    }
                    b.i.c.u.p.c.b(httpURLConnectionC, strE, strD, strG);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException$a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        b.i.c.u.p.a aVar2 = new b.i.c.u.p.a(null, null, null, null, b.i.c.u.p.d$a.BAD_CONFIG, null);
                        httpURLConnectionC.disconnect();
                        dVarE = aVar2;
                        break;
                    }
                    httpURLConnectionC.disconnect();
                    i2++;
                } catch (IOException | AssertionError unused2) {
                }
            } catch (Throwable th) {
                httpURLConnectionC.disconnect();
                throw th;
            }
        }
        b.i.c.u.p.a aVar3 = (b.i.c.u.p.a) dVarE;
        int iOrdinal = aVar3.e.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$a);
            }
            a$b a_b = (a$b) dVar.k();
            a_b.g = "BAD CONFIG";
            a_b.b(c$a.REGISTER_ERROR);
            return a_b.a();
        }
        String str4 = aVar3.f1788b;
        String str5 = aVar3.c;
        long jB = this.f.b();
        String strC = aVar3.d.c();
        long jD = aVar3.d.d();
        a$b a_b2 = (a$b) dVar.k();
        a_b2.a = str4;
        a_b2.b(c$a.REGISTERED);
        a_b2.c = strC;
        a_b2.d = str5;
        a_b2.e = Long.valueOf(jD);
        a_b2.f = Long.valueOf(jB);
        return a_b2.a();
    }

    public final void k(Exception exc) {
        synchronized (this.i) {
            Iterator<m> it = this.m.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void l(b.i.c.u.o.d dVar) {
        synchronized (this.i) {
            Iterator<m> it = this.m.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }
}
