package com.discord.utilities.testing;

import android.os.Build;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtilsKt {
    private static final Lazy IS_JUNIT_TEST$delegate = g.lazy(TestUtilsKt$IS_JUNIT_TEST$2.INSTANCE);

    public static final boolean getIS_JUNIT_TEST() {
        return ((Boolean) IS_JUNIT_TEST$delegate.getValue()).booleanValue();
    }

    public static final boolean isTest() {
        return m.areEqual(Build.FINGERPRINT, "roboelectric");
    }
}
