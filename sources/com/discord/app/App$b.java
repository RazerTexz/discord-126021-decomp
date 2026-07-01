package com.discord.app;

import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class App$b extends o implements Function1<Throwable, Unit> {
    public static final App$b j = new App$b();

    public App$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        m.checkNotNullParameter(th2, "throwable");
        Logger.e$default(AppLog.g, "Subscription error in backgrounded delay, " + th2, null, null, 6, null);
        return Unit.a;
    }
}
