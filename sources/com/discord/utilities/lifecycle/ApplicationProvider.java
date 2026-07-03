package com.discord.utilities.lifecycle;

import android.app.Application;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.throwUninitializedPropertyAccessException("application");
        }
        return application2;
    }

    public final void init(Application application2) {
        C12238m.checkNotNullParameter(application2, "application");
        application = application2;
    }
}
