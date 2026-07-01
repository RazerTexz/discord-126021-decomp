package b.i.c.m.d.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.c.FirebaseApp2;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.i.AnalyticsEventLogger;
import b.i.c.m.d.j.BreadcrumbSource;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.SettingsDataProvider;
import b.i.c.m.d.s.h.Settings2;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: b.i.c.m.d.k.k0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsCore3 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseApp2 f1689b;
    public final DataCollectionArbiter c;
    public final long d;
    public CrashlyticsFileMarker e;
    public CrashlyticsFileMarker f;
    public boolean g;
    public x h;
    public final IdManager i;
    public final BreadcrumbSource j;
    public final AnalyticsEventLogger k;
    public ExecutorService l;
    public CrashlyticsBackgroundWorker m;
    public CrashlyticsNativeComponent n;

    /* JADX INFO: renamed from: b.i.c.m.d.k.k0$a */
    /* JADX INFO: compiled from: CrashlyticsCore.java */
    public class a implements Runnable {
        public final /* synthetic */ SettingsDataProvider j;

        public a(SettingsDataProvider settingsDataProvider) {
            this.j = settingsDataProvider;
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsCore3.a(CrashlyticsCore3.this, this.j);
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
                boolean zDelete = CrashlyticsCore3.this.e.b().delete();
                Logger3.a.b("Initialization marker file removed: " + zDelete);
                return Boolean.valueOf(zDelete);
            } catch (Exception e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                }
                return Boolean.FALSE;
            }
        }
    }

    public CrashlyticsCore3(FirebaseApp2 firebaseApp2, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, ExecutorService executorService) {
        this.f1689b = firebaseApp2;
        this.c = dataCollectionArbiter;
        firebaseApp2.a();
        this.a = firebaseApp2.d;
        this.i = idManager;
        this.n = crashlyticsNativeComponent;
        this.j = breadcrumbSource;
        this.k = analyticsEventLogger;
        this.l = executorService;
        this.m = new CrashlyticsBackgroundWorker(executorService);
        this.d = System.currentTimeMillis();
    }

    public static Task a(CrashlyticsCore3 crashlyticsCore3, SettingsDataProvider settingsDataProvider) {
        Task<Void> taskY;
        crashlyticsCore3.m.a();
        crashlyticsCore3.e.a();
        Logger3 logger3 = Logger3.a;
        logger3.b("Initialization marker file created.");
        x xVar = crashlyticsCore3.h;
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = xVar.m;
        crashlyticsBackgroundWorker.b(new CrashlyticsBackgroundWorker2(crashlyticsBackgroundWorker, new s(xVar)));
        try {
            try {
                crashlyticsCore3.j.a(new CrashlyticsCore(crashlyticsCore3));
                SettingsController settingsController = (SettingsController) settingsDataProvider;
                Settings2 settings2C = settingsController.c();
                if (settings2C.a().a) {
                    if (!crashlyticsCore3.h.h(settings2C.b().a)) {
                        logger3.b("Could not finalize previous sessions.");
                    }
                    taskY = crashlyticsCore3.h.u(1.0f, settingsController.a());
                } else {
                    logger3.b("Collection of crash reports disabled in Crashlytics settings.");
                    taskY = b.i.a.f.e.o.f.Y(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                }
            } catch (Exception e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                }
                taskY = b.i.a.f.e.o.f.Y(e);
            }
            return taskY;
        } finally {
            crashlyticsCore3.c();
        }
    }

    public final void b(SettingsDataProvider settingsDataProvider) {
        Future<?> futureSubmit = this.l.submit(new a(settingsDataProvider));
        Logger3.a.b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
            }
        } catch (ExecutionException e2) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Problem encountered during Crashlytics initialization.", e2);
            }
        } catch (TimeoutException e3) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e3);
            }
        }
    }

    public void c() {
        this.m.b(new b());
    }

    public void d(@Nullable Boolean bool) {
        Boolean boolA;
        DataCollectionArbiter dataCollectionArbiter = this.c;
        synchronized (dataCollectionArbiter) {
            if (bool != null) {
                try {
                    dataCollectionArbiter.f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                boolA = bool;
            } else {
                FirebaseApp2 firebaseApp2 = dataCollectionArbiter.f1693b;
                firebaseApp2.a();
                boolA = dataCollectionArbiter.a(firebaseApp2.d);
            }
            dataCollectionArbiter.g = boolA;
            SharedPreferences.Editor editorEdit = dataCollectionArbiter.a.edit();
            if (bool != null) {
                editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
            } else {
                editorEdit.remove("firebase_crashlytics_collection_enabled");
            }
            editorEdit.commit();
            synchronized (dataCollectionArbiter.c) {
                if (dataCollectionArbiter.b()) {
                    if (!dataCollectionArbiter.e) {
                        dataCollectionArbiter.d.b(null);
                        dataCollectionArbiter.e = true;
                    }
                } else if (dataCollectionArbiter.e) {
                    dataCollectionArbiter.d = new TaskCompletionSource<>();
                    dataCollectionArbiter.e = false;
                }
            }
        }
    }

    public void e(String str, String str2) {
        x xVar = this.h;
        Objects.requireNonNull(xVar);
        try {
            xVar.l.c(str, str2);
            xVar.m.b(new q(xVar, xVar.l.a()));
        } catch (IllegalArgumentException e) {
            Context context = xVar.i;
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    throw e;
                }
            }
            Logger3.a.d("Attempting to set custom attribute with null key, ignoring.");
        }
    }
}
