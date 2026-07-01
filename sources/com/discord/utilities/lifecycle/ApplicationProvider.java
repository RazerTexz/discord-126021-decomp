package com.discord.utilities.lifecycle;

import android.app.Application;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ApplicationProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationProvider {
    public static final ApplicationProvider INSTANCE = new ApplicationProvider();
    private static Application application;

    private ApplicationProvider() {
    }

    public final Application get() {
        Application application2 = application;
        if (application2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("application");
        }
        return application2;
    }

    public final void init(Application application2) {
        Intrinsics3.checkNotNullParameter(application2, "application");
        application = application2;
    }
}
