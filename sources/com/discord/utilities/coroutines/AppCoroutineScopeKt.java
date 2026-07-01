package com.discord.utilities.coroutines;

import d0.w.f;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import s.a.a.n;
import s.a.k0;

/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppCoroutineScopeKt {
    public static final Job appLaunch(CoroutineScope coroutineScope, Class<?> cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        m.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        m.checkNotNullParameter(cls, "errorClass");
        m.checkNotNullParameter(coroutineContext, "context");
        m.checkNotNullParameter(coroutineStart, "start");
        m.checkNotNullParameter(function2, "block");
        String simpleName = cls.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        return appLaunch(coroutineScope, simpleName, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, Class cls, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = f.j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, (Class<?>) cls, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final Job appLaunch(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        m.checkNotNullParameter(coroutineScope, "$this$appLaunch");
        m.checkNotNullParameter(str, "errorTag");
        m.checkNotNullParameter(coroutineContext, "context");
        m.checkNotNullParameter(coroutineStart, "start");
        m.checkNotNullParameter(function2, "block");
        CoroutineDispatcher coroutineDispatcher = k0.a;
        return b.i.a.f.e.o.f.G0(coroutineScope, n.f3830b.plus(new AppErrorTag(str)).plus(coroutineContext), coroutineStart, function2);
    }

    public static /* synthetic */ Job appLaunch$default(CoroutineScope coroutineScope, String str, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = f.j;
        }
        if ((i & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return appLaunch(coroutineScope, str, coroutineContext, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }
}
