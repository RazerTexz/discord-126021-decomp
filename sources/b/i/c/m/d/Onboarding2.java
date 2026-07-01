package b.i.c.m.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.h.AppSettingsData;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: b.i.c.m.d.f, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding2 implements b.i.a.f.n.f<Void, AppSettingsData> {
    public final /* synthetic */ SettingsController a;

    public Onboarding2(Onboarding4 onboarding4, SettingsController settingsController) {
        this.a = settingsController;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<AppSettingsData> a(@Nullable Void r1) throws Exception {
        return this.a.a();
    }
}
