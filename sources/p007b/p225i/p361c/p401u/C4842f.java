package p007b.p225i.p361c.p401u;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p400t.InterfaceC4836a;
import p007b.p225i.p361c.p401u.p402o.AbstractC4854d;
import p007b.p225i.p361c.p401u.p402o.C4851a;
import p007b.p225i.p361c.p401u.p402o.C4852b;
import p007b.p225i.p361c.p401u.p402o.C4853c;
import p007b.p225i.p361c.p401u.p403p.AbstractC4858d;
import p007b.p225i.p361c.p401u.p403p.AbstractC4860f;
import p007b.p225i.p361c.p401u.p403p.C4855a;
import p007b.p225i.p361c.p401u.p403p.C4856b;
import p007b.p225i.p361c.p401u.p403p.C4857c;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: renamed from: b.i.c.u.f */
/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4842f implements InterfaceC4843g {

    /* JADX INFO: renamed from: a */
    public static final Object f12928a = new Object();

    /* JADX INFO: renamed from: b */
    public static final ThreadFactory f12929b = new a();

    /* JADX INFO: renamed from: c */
    public final C4542c f12930c;

    /* JADX INFO: renamed from: d */
    public final C4857c f12931d;

    /* JADX INFO: renamed from: e */
    public final C4853c f12932e;

    /* JADX INFO: renamed from: f */
    public final C4850n f12933f;

    /* JADX INFO: renamed from: g */
    public final C4852b f12934g;

    /* JADX INFO: renamed from: h */
    public final C4848l f12935h;

    /* JADX INFO: renamed from: i */
    public final Object f12936i;

    /* JADX INFO: renamed from: j */
    public final ExecutorService f12937j;

    /* JADX INFO: renamed from: k */
    public final ExecutorService f12938k;

    /* JADX INFO: renamed from: l */
    @GuardedBy("this")
    public String f12939l;

    /* JADX INFO: renamed from: m */
    @GuardedBy("lock")
    public final List<InterfaceC4849m> f12940m;

    /* JADX INFO: renamed from: b.i.c.u.f$a */
    /* JADX INFO: compiled from: FirebaseInstallations.java */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: j */
        public final AtomicInteger f12941j = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f12941j.getAndIncrement())));
        }
    }

    public C4842f(C4542c c4542c, @NonNull InterfaceC4836a<InterfaceC4896h> interfaceC4836a, @NonNull InterfaceC4836a<InterfaceC4803d> interfaceC4836a2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = f12929b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, threadFactory);
        c4542c.m6330a();
        C4857c c4857c = new C4857c(c4542c.f12118d, interfaceC4836a, interfaceC4836a2);
        C4853c c4853c = new C4853c(c4542c);
        C4850n c4850nM6770c = C4850n.m6770c();
        C4852b c4852b = new C4852b(c4542c);
        C4848l c4848l = new C4848l();
        this.f12936i = new Object();
        this.f12940m = new ArrayList();
        this.f12930c = c4542c;
        this.f12931d = c4857c;
        this.f12932e = c4853c;
        this.f12933f = c4850nM6770c;
        this.f12934g = c4852b;
        this.f12935h = c4848l;
        this.f12937j = threadPoolExecutor;
        this.f12938k = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static C4842f m6755f() {
        C4542c c4542cM6327b = C4542c.m6327b();
        C1460d.m551o(true, "Null is not a valid value of FirebaseApp.");
        c4542cM6327b.m6330a();
        return (C4842f) c4542cM6327b.f12121g.mo6346a(InterfaceC4843g.class);
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4843g
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<AbstractC4847k> mo6756a(final boolean z2) {
        m6762h();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C4845i c4845i = new C4845i(this.f12933f, taskCompletionSource);
        synchronized (this.f12936i) {
            this.f12940m.add(c4845i);
        }
        Task task = taskCompletionSource.f20845a;
        this.f12937j.execute(new Runnable(this, z2) { // from class: b.i.c.u.d

            /* JADX INFO: renamed from: j */
            public final C4842f f12924j;

            /* JADX INFO: renamed from: k */
            public final boolean f12925k;

            {
                this.f12924j = this;
                this.f12925k = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4842f c4842f = this.f12924j;
                boolean z3 = this.f12925k;
                Object obj = C4842f.f12928a;
                c4842f.m6757b(z3);
            }
        });
        return task;
    }

    /* JADX INFO: renamed from: b */
    public final void m6757b(final boolean z2) {
        AbstractC4854d abstractC4854dM6788b;
        synchronized (f12928a) {
            C4542c c4542c = this.f12930c;
            c4542c.m6330a();
            C4838b c4838bM6753a = C4838b.m6753a(c4542c.f12118d, "generatefid.lock");
            try {
                abstractC4854dM6788b = this.f12932e.m6788b();
                if (abstractC4854dM6788b.m6790i()) {
                    String strM6763i = m6763i(abstractC4854dM6788b);
                    C4853c c4853c = this.f12932e;
                    C4851a.b bVar = (C4851a.b) abstractC4854dM6788b.mo6781k();
                    bVar.f12959a = strM6763i;
                    bVar.mo6783b(C4853c.a.UNREGISTERED);
                    abstractC4854dM6788b = bVar.mo6782a();
                    c4853c.m6787a(abstractC4854dM6788b);
                }
                if (c4838bM6753a != null) {
                    c4838bM6753a.m6754b();
                }
            } catch (Throwable th) {
                if (c4838bM6753a != null) {
                    c4838bM6753a.m6754b();
                }
                throw th;
            }
        }
        if (z2) {
            C4851a.b bVar2 = (C4851a.b) abstractC4854dM6788b.mo6781k();
            bVar2.f12961c = null;
            abstractC4854dM6788b = bVar2.mo6782a();
        }
        m6766l(abstractC4854dM6788b);
        this.f12938k.execute(new Runnable(this, z2) { // from class: b.i.c.u.e

            /* JADX INFO: renamed from: j */
            public final C4842f f12926j;

            /* JADX INFO: renamed from: k */
            public final boolean f12927k;

            {
                this.f12926j = this;
                this.f12927k = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC4854d abstractC4854dM6788b2;
                AbstractC4854d abstractC4854dM6764j;
                C4842f c4842f = this.f12926j;
                boolean z3 = this.f12927k;
                Object obj = C4842f.f12928a;
                Objects.requireNonNull(c4842f);
                Object obj2 = C4842f.f12928a;
                synchronized (obj2) {
                    C4542c c4542c2 = c4842f.f12930c;
                    c4542c2.m6330a();
                    C4838b c4838bM6753a2 = C4838b.m6753a(c4542c2.f12118d, "generatefid.lock");
                    try {
                        abstractC4854dM6788b2 = c4842f.f12932e.m6788b();
                        if (c4838bM6753a2 != null) {
                            c4838bM6753a2.m6754b();
                        }
                    } catch (Throwable th2) {
                        if (c4838bM6753a2 != null) {
                            c4838bM6753a2.m6754b();
                        }
                        throw th2;
                    }
                }
                try {
                    if (abstractC4854dM6788b2.m6789h()) {
                        abstractC4854dM6764j = c4842f.m6764j(abstractC4854dM6788b2);
                    } else {
                        if (abstractC4854dM6788b2.mo6779f() == C4853c.a.UNREGISTERED) {
                            abstractC4854dM6764j = c4842f.m6764j(abstractC4854dM6788b2);
                        } else if (!z3 && !c4842f.f12933f.m6773d(abstractC4854dM6788b2)) {
                            return;
                        } else {
                            abstractC4854dM6764j = c4842f.m6758c(abstractC4854dM6788b2);
                        }
                    }
                    synchronized (obj2) {
                        C4542c c4542c3 = c4842f.f12930c;
                        c4542c3.m6330a();
                        C4838b c4838bM6753a3 = C4838b.m6753a(c4542c3.f12118d, "generatefid.lock");
                        try {
                            c4842f.f12932e.m6787a(abstractC4854dM6764j);
                            if (c4838bM6753a3 != null) {
                                c4838bM6753a3.m6754b();
                            }
                        } catch (Throwable th3) {
                            if (c4838bM6753a3 != null) {
                                c4838bM6753a3.m6754b();
                            }
                            throw th3;
                        }
                    }
                    if (abstractC4854dM6764j.m6791j()) {
                        String str = ((C4851a) abstractC4854dM6764j).f12952b;
                        synchronized (c4842f) {
                            c4842f.f12939l = str;
                        }
                    }
                    if (abstractC4854dM6764j.m6789h()) {
                        c4842f.m6765k(new FirebaseInstallationsException(FirebaseInstallationsException.EnumC11081a.BAD_CONFIG));
                    } else if (abstractC4854dM6764j.m6790i()) {
                        c4842f.m6765k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                    } else {
                        c4842f.m6766l(abstractC4854dM6764j);
                    }
                } catch (FirebaseInstallationsException e) {
                    c4842f.m6765k(e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC4854d m6758c(@NonNull AbstractC4854d abstractC4854d) throws FirebaseInstallationsException {
        HttpURLConnection httpURLConnectionM6806c;
        AbstractC4860f abstractC4860fM6808f;
        FirebaseInstallationsException.EnumC11081a enumC11081a = FirebaseInstallationsException.EnumC11081a.UNAVAILABLE;
        C4857c c4857c = this.f12931d;
        String strM6759d = m6759d();
        C4851a c4851a = (C4851a) abstractC4854d;
        String str = c4851a.f12952b;
        String strM6761g = m6761g();
        String str2 = c4851a.f12955e;
        if (!c4857c.f12994f.m6811a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
        }
        URL urlM6805a = c4857c.m6805a(String.format("projects/%s/installations/%s/authTokens:generate", strM6761g, str));
        int i = 0;
        while (true) {
            if (i > 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
            }
            httpURLConnectionM6806c = c4857c.m6806c(urlM6805a, strM6759d);
            try {
                httpURLConnectionM6806c.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnectionM6806c.addRequestProperty("Authorization", "FIS_v2 " + str2);
                httpURLConnectionM6806c.setDoOutput(true);
                c4857c.m6810h(httpURLConnectionM6806c);
                int responseCode = httpURLConnectionM6806c.getResponseCode();
                c4857c.f12994f.m6812b(responseCode);
                if (responseCode >= 200 && responseCode < 300) {
                    abstractC4860fM6808f = c4857c.m6808f(httpURLConnectionM6806c);
                    break;
                }
                C4857c.m6802b(httpURLConnectionM6806c, null, strM6759d, strM6761g);
                if (responseCode == 401 || responseCode == 404) {
                    C4856b.b bVar = (C4856b.b) AbstractC4860f.m6813a();
                    bVar.f12988c = AbstractC4860f.b.AUTH_ERROR;
                    abstractC4860fM6808f = bVar.mo6800a();
                    break;
                }
                if (responseCode == 429) {
                    throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.EnumC11081a.TOO_MANY_REQUESTS);
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    C4856b.b bVar2 = (C4856b.b) AbstractC4860f.m6813a();
                    bVar2.f12988c = AbstractC4860f.b.BAD_CONFIG;
                    abstractC4860fM6808f = bVar2.mo6800a();
                    break;
                }
                httpURLConnectionM6806c.disconnect();
                i++;
            } catch (IOException | AssertionError unused) {
            } catch (Throwable th) {
                httpURLConnectionM6806c.disconnect();
                throw th;
            }
        }
        httpURLConnectionM6806c.disconnect();
        C4856b c4856b = (C4856b) abstractC4860fM6808f;
        int iOrdinal = c4856b.f12985c.ordinal();
        if (iOrdinal == 0) {
            String str3 = c4856b.f12983a;
            long j = c4856b.f12984b;
            long jM6772b = this.f12933f.m6772b();
            C4851a.b bVar3 = (C4851a.b) abstractC4854d.mo6781k();
            bVar3.f12961c = str3;
            bVar3.f12963e = Long.valueOf(j);
            bVar3.f12964f = Long.valueOf(jM6772b);
            return bVar3.mo6782a();
        }
        if (iOrdinal == 1) {
            C4851a.b bVar4 = (C4851a.b) abstractC4854d.mo6781k();
            bVar4.f12965g = "BAD CONFIG";
            bVar4.mo6783b(C4853c.a.REGISTER_ERROR);
            return bVar4.mo6782a();
        }
        if (iOrdinal != 2) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
        }
        synchronized (this) {
            this.f12939l = null;
        }
        AbstractC4854d.a aVarMo6781k = abstractC4854d.mo6781k();
        aVarMo6781k.mo6783b(C4853c.a.NOT_GENERATED);
        return aVarMo6781k.mo6782a();
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public String m6759d() {
        C4542c c4542c = this.f12930c;
        c4542c.m6330a();
        return c4542c.f12120f.f12134a;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public String m6760e() {
        C4542c c4542c = this.f12930c;
        c4542c.m6330a();
        return c4542c.f12120f.f12135b;
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public String m6761g() {
        C4542c c4542c = this.f12930c;
        c4542c.m6330a();
        return c4542c.f12120f.f12140g;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4843g
    @NonNull
    public Task<String> getId() {
        String str;
        m6762h();
        synchronized (this) {
            str = this.f12939l;
        }
        if (str != null) {
            return C3404f.m4264Z(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C4846j c4846j = new C4846j(taskCompletionSource);
        synchronized (this.f12936i) {
            this.f12940m.add(c4846j);
        }
        Task task = taskCompletionSource.f20845a;
        this.f12937j.execute(new Runnable(this) { // from class: b.i.c.u.c

            /* JADX INFO: renamed from: j */
            public final C4842f f12923j;

            {
                this.f12923j = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4842f c4842f = this.f12923j;
                Object obj = C4842f.f12928a;
                c4842f.m6757b(false);
            }
        });
        return task;
    }

    /* JADX INFO: renamed from: h */
    public final void m6762h() {
        C1460d.m579v(m6760e(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C1460d.m579v(m6761g(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C1460d.m579v(m6759d(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String strM6760e = m6760e();
        Pattern pattern = C4850n.f12949b;
        C1460d.m551o(strM6760e.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C1460d.m551o(C4850n.f12949b.matcher(m6759d()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX INFO: renamed from: i */
    public final String m6763i(AbstractC4854d abstractC4854d) {
        String string;
        C4542c c4542c = this.f12930c;
        c4542c.m6330a();
        if (c4542c.f12119e.equals("CHIME_ANDROID_SDK") || this.f12930c.m6334h()) {
            if (((C4851a) abstractC4854d).f12953c == C4853c.a.ATTEMPT_MIGRATION) {
                C4852b c4852b = this.f12934g;
                synchronized (c4852b.f12967b) {
                    synchronized (c4852b.f12967b) {
                        string = c4852b.f12967b.getString("|S|id", null);
                    }
                    if (string == null) {
                        string = c4852b.m6786a();
                    }
                }
                return TextUtils.isEmpty(string) ? this.f12935h.m6769a() : string;
            }
        }
        return this.f12935h.m6769a();
    }

    /* JADX INFO: renamed from: j */
    public final AbstractC4854d m6764j(AbstractC4854d abstractC4854d) throws FirebaseInstallationsException {
        AbstractC4858d abstractC4858dM6807e;
        FirebaseInstallationsException.EnumC11081a enumC11081a = FirebaseInstallationsException.EnumC11081a.UNAVAILABLE;
        C4851a c4851a = (C4851a) abstractC4854d;
        String str = c4851a.f12952b;
        String string = null;
        if (str != null && str.length() == 11) {
            C4852b c4852b = this.f12934g;
            synchronized (c4852b.f12967b) {
                String[] strArr = C4852b.f12966a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    String string2 = c4852b.f12967b.getString("|T|" + c4852b.f12968c + "|" + str2, null);
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
        C4857c c4857c = this.f12931d;
        String strM6759d = m6759d();
        String str3 = c4851a.f12952b;
        String strM6761g = m6761g();
        String strM6760e = m6760e();
        if (!c4857c.f12994f.m6811a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
        }
        URL urlM6805a = c4857c.m6805a(String.format("projects/%s/installations", strM6761g));
        int i2 = 0;
        while (true) {
            if (i2 > 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
            }
            HttpURLConnection httpURLConnectionM6806c = c4857c.m6806c(urlM6805a, strM6759d);
            try {
                try {
                    httpURLConnectionM6806c.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionM6806c.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionM6806c.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    c4857c.m6809g(httpURLConnectionM6806c, str3, strM6760e);
                    int responseCode = httpURLConnectionM6806c.getResponseCode();
                    c4857c.f12994f.m6812b(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        abstractC4858dM6807e = c4857c.m6807e(httpURLConnectionM6806c);
                        httpURLConnectionM6806c.disconnect();
                        break;
                    }
                    C4857c.m6802b(httpURLConnectionM6806c, strM6760e, strM6759d, strM6761g);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.EnumC11081a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        C4855a c4855a = new C4855a(null, null, null, null, AbstractC4858d.a.BAD_CONFIG, null);
                        httpURLConnectionM6806c.disconnect();
                        abstractC4858dM6807e = c4855a;
                        break;
                    }
                    httpURLConnectionM6806c.disconnect();
                    i2++;
                } catch (IOException | AssertionError unused2) {
                }
            } catch (Throwable th) {
                httpURLConnectionM6806c.disconnect();
                throw th;
            }
        }
        C4855a c4855a2 = (C4855a) abstractC4858dM6807e;
        int iOrdinal = c4855a2.f12982e.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
            }
            C4851a.b bVar = (C4851a.b) abstractC4854d.mo6781k();
            bVar.f12965g = "BAD CONFIG";
            bVar.mo6783b(C4853c.a.REGISTER_ERROR);
            return bVar.mo6782a();
        }
        String str4 = c4855a2.f12979b;
        String str5 = c4855a2.f12980c;
        long jM6772b = this.f12933f.m6772b();
        String strMo6798c = c4855a2.f12981d.mo6798c();
        long jMo6799d = c4855a2.f12981d.mo6799d();
        C4851a.b bVar2 = (C4851a.b) abstractC4854d.mo6781k();
        bVar2.f12959a = str4;
        bVar2.mo6783b(C4853c.a.REGISTERED);
        bVar2.f12961c = strMo6798c;
        bVar2.f12962d = str5;
        bVar2.f12963e = Long.valueOf(jMo6799d);
        bVar2.f12964f = Long.valueOf(jM6772b);
        return bVar2.mo6782a();
    }

    /* JADX INFO: renamed from: k */
    public final void m6765k(Exception exc) {
        synchronized (this.f12936i) {
            Iterator<InterfaceC4849m> it = this.f12940m.iterator();
            while (it.hasNext()) {
                if (it.next().mo6767a(exc)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m6766l(AbstractC4854d abstractC4854d) {
        synchronized (this.f12936i) {
            Iterator<InterfaceC4849m> it = this.f12940m.iterator();
            while (it.hasNext()) {
                if (it.next().mo6768b(abstractC4854d)) {
                    it.remove();
                }
            }
        }
    }
}
