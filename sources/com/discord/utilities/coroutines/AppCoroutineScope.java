package com.discord.utilities.coroutines;

import b.i.a.f.e.o.f;
import d0.w.CoroutineContextImpl4;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: com.discord.utilities.coroutines.AppCoroutineScopeKt, reason: use source file name */
/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppCoroutineScope {
    public static final Job appLaunch(CoroutineScope coroutineScope, Class<?> cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(coroutineStart, "start");
        Intrinsics3.checkNotNullParameter(function2, "block");
        String simpleName = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        return appLaunch(coroutineScope, simpleName, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, Class cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = CoroutineContextImpl4.j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, (Class<?>) cls, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final Job appLaunch(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(coroutineStart, "start");
        Intrinsics3.checkNotNullParameter(function2, "block");
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        return f.G0(coroutineScope, MainDispatchers.f3830b.plus(new AppCoroutineScope2(str)).plus(coroutineContext), coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = CoroutineContextImpl4.j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, str, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }
}
