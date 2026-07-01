package com.discord.app;

import android.util.Log;
import d0.g0.y;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLog$a$a extends o implements Function2<String, Integer, Unit> {
    public final /* synthetic */ AppLog$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLog$a$a(AppLog$a appLog$a) {
        super(2);
        this.this$0 = appLog$a;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return Unit.a;
    }

    public final void invoke(String str, int i) {
        m.checkNotNullParameter(str, "message");
        Iterator<T> it = y.chunked(str, i).iterator();
        while (it.hasNext()) {
            Log.println(this.this$0.$priority, AppLog.g.getDefaultTag(), (String) it.next());
        }
    }
}
