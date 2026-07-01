package com.discord.utilities.testing;

import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtilsKt$IS_JUNIT_TEST$2 extends o implements Function0<Boolean> {
    public static final TestUtilsKt$IS_JUNIT_TEST$2 INSTANCE = new TestUtilsKt$IS_JUNIT_TEST$2();

    public TestUtilsKt$IS_JUNIT_TEST$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        m.checkNotNullExpressionValue(stackTrace, "Thread.currentThread().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            m.checkNotNullExpressionValue(stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            m.checkNotNullExpressionValue(className, "it.className");
            if (t.startsWith$default(className, "org.junit", false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
