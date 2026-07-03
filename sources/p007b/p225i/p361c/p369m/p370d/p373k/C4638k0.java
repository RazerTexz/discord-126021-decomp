package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4591a;
import p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4599a;
import p007b.p225i.p361c.p369m.p370d.p372j.InterfaceC4605a;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.InterfaceC4744e;

/* JADX INFO: renamed from: b.i.c.m.d.k.k0 */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4638k0 {

    /* JADX INFO: renamed from: a */
    public final Context f12329a;

    /* JADX INFO: renamed from: b */
    public final C4542c f12330b;

    /* JADX INFO: renamed from: c */
    public final C4650q0 f12331c;

    /* JADX INFO: renamed from: d */
    public final long f12332d;

    /* JADX INFO: renamed from: e */
    public C4642m0 f12333e;

    /* JADX INFO: renamed from: f */
    public C4642m0 f12334f;

    /* JADX INFO: renamed from: g */
    public boolean f12335g;

    /* JADX INFO: renamed from: h */
    public C4663x f12336h;

    /* JADX INFO: renamed from: i */
    public final C4660v0 f12337i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC4605a f12338j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC4599a f12339k;

    /* JADX INFO: renamed from: l */
    public ExecutorService f12340l;

    /* JADX INFO: renamed from: m */
    public C4631i f12341m;

    /* JADX INFO: renamed from: n */
    public InterfaceC4591a f12342n;

    /* JADX INFO: renamed from: b.i.c.m.d.k.k0$a */
    /* JADX INFO: compiled from: CrashlyticsCore.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC4736d f12343j;

        public a(InterfaceC4736d interfaceC4736d) {
            this.f12343j = interfaceC4736d;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4638k0.m6439a(C4638k0.this, this.f12343j);
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.k.k0$b */
    /* JADX INFO: compiled from: CrashlyticsCore.java */
    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                boolean zDelete = C4638k0.this.f12333e.m6445b().delete();
                C4592b.f12227a.m6371b("Initialization marker file removed: " + zDelete);
                return Boolean.valueOf(zDelete);
            } catch (Exception e) {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                }
                return Boolean.FALSE;
            }
        }
    }

    public C4638k0(C4542c c4542c, C4660v0 c4660v0, InterfaceC4591a interfaceC4591a, C4650q0 c4650q0, InterfaceC4605a interfaceC4605a, InterfaceC4599a interfaceC4599a, ExecutorService executorService) {
        this.f12330b = c4542c;
        this.f12331c = c4650q0;
        c4542c.m6330a();
        this.f12329a = c4542c.f12118d;
        this.f12337i = c4660v0;
        this.f12342n = interfaceC4591a;
        this.f12338j = interfaceC4605a;
        this.f12339k = interfaceC4599a;
        this.f12340l = executorService;
        this.f12341m = new C4631i(executorService);
        this.f12332d = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    public static Task m6439a(C4638k0 c4638k0, InterfaceC4736d interfaceC4736d) {
        Task<Void> taskM4261Y;
        c4638k0.f12341m.m6436a();
        c4638k0.f12333e.m6444a();
        C4592b c4592b = C4592b.f12227a;
        c4592b.m6371b("Initialization marker file created.");
        C4663x c4663x = c4638k0.f12336h;
        C4631i c4631i = c4663x.f12433m;
        c4631i.m6437b(new CallableC4634j(c4631i, new RunnableC4653s(c4663x)));
        try {
            try {
                c4638k0.f12338j.mo6389a(new C4632i0(c4638k0));
                C4735c c4735c = (C4735c) interfaceC4736d;
                InterfaceC4744e interfaceC4744eM6685c = c4735c.m6685c();
                if (interfaceC4744eM6685c.mo6689a().f12757a) {
                    if (!c4638k0.f12336h.m6473h(interfaceC4744eM6685c.mo6690b().f12758a)) {
                        c4592b.m6371b("Could not finalize previous sessions.");
                    }
                    taskM4261Y = c4638k0.f12336h.m6482u(1.0f, c4735c.m6683a());
                } else {
                    c4592b.m6371b("Collection of crash reports disabled in Crashlytics settings.");
                    taskM4261Y = C3404f.m4261Y(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                }
            } catch (Exception e) {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                }
                taskM4261Y = C3404f.m4261Y(e);
            }
            return taskM4261Y;
        } finally {
            c4638k0.m6441c();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m6440b(InterfaceC4736d interfaceC4736d) {
        Future<?> futureSubmit = this.f12340l.submit(new a(interfaceC4736d));
        C4592b.f12227a.m6371b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
            }
        } catch (ExecutionException e2) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Problem encountered during Crashlytics initialization.", e2);
            }
        } catch (TimeoutException e3) {
            if (C4592b.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e3);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6441c() {
        this.f12341m.m6437b(new b());
    }

    /* JADX INFO: renamed from: d */
    public void m6442d(@Nullable Boolean bool) {
        Boolean boolM6449a;
        C4650q0 c4650q0 = this.f12331c;
        synchronized (c4650q0) {
            if (bool != null) {
                try {
                    c4650q0.f12376f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                boolM6449a = bool;
            } else {
                C4542c c4542c = c4650q0.f12372b;
                c4542c.m6330a();
                boolM6449a = c4650q0.m6449a(c4542c.f12118d);
            }
            c4650q0.f12377g = boolM6449a;
            SharedPreferences.Editor editorEdit = c4650q0.f12371a.edit();
            if (bool != null) {
                editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
            } else {
                editorEdit.remove("firebase_crashlytics_collection_enabled");
            }
            editorEdit.commit();
            synchronized (c4650q0.f12373c) {
                if (c4650q0.m6450b()) {
                    if (!c4650q0.f12375e) {
                        c4650q0.f12374d.m9126b(null);
                        c4650q0.f12375e = true;
                    }
                } else if (c4650q0.f12375e) {
                    c4650q0.f12374d = new TaskCompletionSource<>();
                    c4650q0.f12375e = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m6443e(String str, String str2) {
        C4663x c4663x = this.f12336h;
        Objects.requireNonNull(c4663x);
        try {
            c4663x.f12432l.m6405c(str, str2);
            c4663x.f12433m.m6437b(new CallableC4649q(c4663x, c4663x.f12432l.m6404a()));
        } catch (IllegalArgumentException e) {
            Context context = c4663x.f12429i;
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    throw e;
                }
            }
            C4592b.f12227a.m6373d("Attempting to set custom attribute with null key, ignoring.");
        }
    }
}
