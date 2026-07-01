package b.i.c.m.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import b.i.c.FirebaseApp2;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.DataCollectionArbiter;
import b.i.c.m.d.k.DeliveryMechanism;
import b.i.c.m.d.k.IdManager;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.h.AppRequestData;
import b.i.c.m.d.s.h.AppSettingsData;
import b.i.c.m.d.s.i.CreateAppSpiCall;
import b.i.c.m.d.s.i.UpdateAppSpiCall;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.m.d.h, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding4 {
    public final HttpRequestFactory a = new HttpRequestFactory();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseApp2 f1674b;
    public final Context c;
    public PackageManager d;
    public String e;
    public PackageInfo f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public IdManager l;
    public DataCollectionArbiter m;

    public Onboarding4(FirebaseApp2 firebaseApp2, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.f1674b = firebaseApp2;
        this.c = context;
        this.l = idManager;
        this.m = dataCollectionArbiter;
    }

    public static void a(Onboarding4 onboarding4, AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z2) throws Throwable {
        Objects.requireNonNull(onboarding4);
        if ("new".equals(appSettingsData.a)) {
            if (new CreateAppSpiCall(onboarding4.c(), appSettingsData.f1749b, onboarding4.a, "17.3.0").d(onboarding4.b(appSettingsData.e, str), z2)) {
                settingsController.d(2, executor);
                return;
            } else {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to create app with Crashlytics service.", null);
                    return;
                }
                return;
            }
        }
        if ("configured".equals(appSettingsData.a)) {
            settingsController.d(2, executor);
        } else if (appSettingsData.f) {
            Logger3.a.b("Server says an update is required - forcing a full App update.");
            new UpdateAppSpiCall(onboarding4.c(), appSettingsData.f1749b, onboarding4.a, "17.3.0").d(onboarding4.b(appSettingsData.e, str), z2);
        }
    }

    public final AppRequestData b(String str, String str2) {
        return new AppRequestData(str, str2, this.l.e, this.h, this.g, CommonUtils.f(CommonUtils.l(this.c), str2, this.h, this.g), this.j, DeliveryMechanism.f(this.i).g(), this.k, "0");
    }

    public String c() {
        Context context = this.c;
        int iN = CommonUtils.n(context, "com.crashlytics.ApiEndpoint", "string");
        return iN > 0 ? context.getString(iN) : "";
    }
}
