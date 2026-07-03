package com.discord.utilities.testing;

import android.os.Build;
import kotlin.Lazy;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtilsKt {
    private static final Lazy IS_JUNIT_TEST$delegate = C12083g.lazy(TestUtilsKt$IS_JUNIT_TEST$2.INSTANCE);

    public static final boolean getIS_JUNIT_TEST() {
        return ((Boolean) IS_JUNIT_TEST$delegate.getValue()).booleanValue();
    }

    public static final boolean isTest() {
        return C12238m.areEqual(Build.FINGERPRINT, "roboelectric");
    }
}
