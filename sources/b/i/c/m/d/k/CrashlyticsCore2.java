package b.i.c.m.d.k;

import b.i.c.m.d.s.SettingsDataProvider;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.c.m.d.k.j0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsCore2 implements Callable<Task<Void>> {
    public final /* synthetic */ SettingsDataProvider j;
    public final /* synthetic */ CrashlyticsCore3 k;

    public CrashlyticsCore2(CrashlyticsCore3 crashlyticsCore3, SettingsDataProvider settingsDataProvider) {
        this.k = crashlyticsCore3;
        this.j = settingsDataProvider;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return CrashlyticsCore3.a(this.k, this.j);
    }
}
