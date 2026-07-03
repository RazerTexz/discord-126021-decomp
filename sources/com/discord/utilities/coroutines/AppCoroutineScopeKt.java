package com.discord.utilities.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.C12179f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppCoroutineScopeKt {
    public static final Job appLaunch(CoroutineScope coroutineScope, Class<?> cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        C12238m.checkNotNullParameter(cls, "errorClass");
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(coroutineStart, "start");
        C12238m.checkNotNullParameter(function2, "block");
        String simpleName = cls.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        return appLaunch(coroutineScope, simpleName, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, Class cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, (Class<?>) cls, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final Job appLaunch(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        C12238m.checkNotNullParameter(str, "errorTag");
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(coroutineStart, "start");
        C12238m.checkNotNullParameter(function2, "block");
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        return C3404f.m4208G0(coroutineScope, C13031n.f27700b.plus(new AppErrorTag(str)).plus(coroutineContext), coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, str, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }
}
