package com.discord.utilities.testing;

import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.testing.TestUtilsKt$IS_JUNIT_TEST$2, reason: use source file name */
/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtils2 extends Lambda implements Function0<Boolean> {
    public static final TestUtils2 INSTANCE = new TestUtils2();

    public TestUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        Intrinsics3.checkNotNullExpressionValue(stackTrace, "Thread.currentThread().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            Intrinsics3.checkNotNullExpressionValue(stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className, "it.className");
            if (StringsJVM.startsWith$default(className, "org.junit", false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
