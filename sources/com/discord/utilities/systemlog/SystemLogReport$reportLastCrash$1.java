package com.discord.utilities.systemlog;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SystemLogReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogReport$reportLastCrash$1 extends o implements Function1<Error, Unit> {
    public static final SystemLogReport$reportLastCrash$1 INSTANCE = new SystemLogReport$reportLastCrash$1();

    public SystemLogReport$reportLastCrash$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        error.setShouldLog(false);
        error.setShowErrorToasts(false);
        SystemLogReport.access$sendReport(SystemLogReport.INSTANCE, null);
        AppLog.g.i("Checking tombstone error", error.getThrowable());
    }
}
