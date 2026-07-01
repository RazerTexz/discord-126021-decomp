package com.discord.app;

import android.util.Log;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLog$a extends o implements Function1<String, Unit> {
    public final /* synthetic */ Map $metadata;
    public final /* synthetic */ int $priority;
    public final /* synthetic */ Throwable $throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLog$a(int i, Map map, Throwable th) {
        super(1);
        this.$priority = i;
        this.$metadata = map;
        this.$throwable = th;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Set setEntrySet;
        String strJoinToString$default;
        m.checkNotNullParameter(str, "message");
        AppLog$a$a appLog$a$a = new AppLog$a$a(this);
        appLog$a$a.invoke(str, 1000);
        Map map = this.$metadata;
        if (map != null && (setEntrySet = map.entrySet()) != null && (strJoinToString$default = u.joinToString$default(setEntrySet, "\n\t", null, null, 0, null, null, 62, null)) != null) {
            appLog$a$a.invoke("Metadata: " + strJoinToString$default, Integer.MAX_VALUE);
        }
        String stackTraceString = Log.getStackTraceString(this.$throwable);
        m.checkNotNullExpressionValue(stackTraceString, "Log.getStackTraceString(throwable)");
        appLog$a$a.invoke(stackTraceString, 1000);
    }
}
