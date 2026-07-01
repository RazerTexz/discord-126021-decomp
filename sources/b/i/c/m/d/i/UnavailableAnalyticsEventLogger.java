package b.i.c.m.d.i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;

/* JADX INFO: renamed from: b.i.c.m.d.i.f, reason: use source file name */
/* JADX INFO: compiled from: UnavailableAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnavailableAnalyticsEventLogger implements AnalyticsEventLogger {
    @Override // b.i.c.m.d.i.AnalyticsEventLogger
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        Logger3.a.b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
