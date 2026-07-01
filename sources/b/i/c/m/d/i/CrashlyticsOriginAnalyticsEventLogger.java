package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.c.m.d.i.e, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsOriginAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {

    @NonNull
    public final b.i.c.j.a.a a;

    public CrashlyticsOriginAnalyticsEventLogger(@NonNull b.i.c.j.a.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.c.m.d.i.AnalyticsEventLogger
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        this.a.a("clx", str, bundle);
    }
}
