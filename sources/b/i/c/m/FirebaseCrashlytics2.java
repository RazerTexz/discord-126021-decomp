package b.i.c.m;

import b.i.c.FirebaseApp2;
import b.i.c.m.d.Onboarding;
import b.i.c.m.d.Onboarding2;
import b.i.c.m.d.Onboarding4;
import b.i.c.m.d.k.CrashlyticsCore2;
import b.i.c.m.d.k.CrashlyticsCore3;
import b.i.c.m.d.k.Utils3;
import b.i.c.m.d.k.Utils5;
import b.i.c.m.d.s.SettingsController;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: b.i.c.m.c, reason: use source file name */
/* JADX INFO: compiled from: FirebaseCrashlytics.java */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCrashlytics2 implements Callable<Void> {
    public final /* synthetic */ Onboarding4 j;
    public final /* synthetic */ ExecutorService k;
    public final /* synthetic */ SettingsController l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ CrashlyticsCore3 n;

    public FirebaseCrashlytics2(Onboarding4 onboarding4, ExecutorService executorService, SettingsController settingsController, boolean z2, CrashlyticsCore3 crashlyticsCore3) {
        this.j = onboarding4;
        this.k = executorService;
        this.l = settingsController;
        this.m = z2;
        this.n = crashlyticsCore3;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Onboarding4 onboarding4 = this.j;
        ExecutorService executorService = this.k;
        SettingsController settingsController = this.l;
        FirebaseApp2 firebaseApp2 = onboarding4.f1674b;
        firebaseApp2.a();
        onboarding4.m.c().r(executorService, new Onboarding2(onboarding4, settingsController)).r(executorService, new Onboarding(onboarding4, firebaseApp2.f.f1655b, settingsController, executorService));
        if (!this.m) {
            return null;
        }
        CrashlyticsCore3 crashlyticsCore3 = this.n;
        SettingsController settingsController2 = this.l;
        ExecutorService executorService2 = crashlyticsCore3.l;
        CrashlyticsCore2 crashlyticsCore2 = new CrashlyticsCore2(crashlyticsCore3, settingsController2);
        FilenameFilter filenameFilter = Utils3.a;
        executorService2.execute(new Utils5(crashlyticsCore2, new TaskCompletionSource()));
        return null;
    }
}
