package b.i.c.m.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.h.AppSettingsData;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.m.d.e, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding implements b.i.a.f.n.f<AppSettingsData, Void> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsController f1673b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ Onboarding4 d;

    public Onboarding(Onboarding4 onboarding4, String str, SettingsController settingsController, Executor executor) {
        this.d = onboarding4;
        this.a = str;
        this.f1673b = settingsController;
        this.c = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable AppSettingsData appSettingsData) throws Exception {
        try {
            Onboarding4.a(this.d, appSettingsData, this.a, this.f1673b, this.c, true);
            return null;
        } catch (Exception e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Error performing auto configuration.", e);
            }
            throw e;
        }
    }
}
