package com.discord.utilities.testing;

import android.os.Build;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;

/* JADX INFO: renamed from: com.discord.utilities.testing.TestUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtils {
    private static final Lazy IS_JUNIT_TEST$delegate = LazyJVM.lazy(TestUtils2.INSTANCE);

    public static final boolean getIS_JUNIT_TEST() {
        return ((Boolean) IS_JUNIT_TEST$delegate.getValue()).booleanValue();
    }

    public static final boolean isTest() {
        return Intrinsics3.areEqual(Build.FINGERPRINT, "roboelectric");
    }
}
