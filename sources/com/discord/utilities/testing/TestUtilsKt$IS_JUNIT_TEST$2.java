package com.discord.utilities.testing;

import kotlin.jvm.functions.Function0;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TestUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestUtilsKt$IS_JUNIT_TEST$2 extends AbstractC12240o implements Function0<Boolean> {
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
        C12238m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        C12238m.checkNotNullExpressionValue(stackTrace, "Thread.currentThread().stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            C12238m.checkNotNullExpressionValue(stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            C12238m.checkNotNullExpressionValue(className, "it.className");
            if (C12103t.startsWith$default(className, "org.junit", false, 2, null)) {
                return true;
            }
        }
        return false;
    }
}
