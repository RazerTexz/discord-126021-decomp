package com.discord.utilities.systemlog;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SystemLogReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogReport$reportLastCrash$2 extends o implements Function1<SystemLogUtils$Tombstone, Unit> {
    public static final SystemLogReport$reportLastCrash$2 INSTANCE = new SystemLogReport$reportLastCrash$2();

    public SystemLogReport$reportLastCrash$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SystemLogUtils$Tombstone systemLogUtils$Tombstone) {
        invoke2(systemLogUtils$Tombstone);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SystemLogUtils$Tombstone systemLogUtils$Tombstone) {
        m.checkNotNullParameter(systemLogUtils$Tombstone, "crash");
        Iterator it = w.split$default((CharSequence) systemLogUtils$Tombstone.getText(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            AppLog.g.recordBreadcrumb((String) it.next(), "Tombstone");
        }
        AppLog appLog = AppLog.g;
        appLog.recordBreadcrumb(systemLogUtils$Tombstone.getGroupHash(), "Tombstone-Hash");
        SystemLogReport systemLogReport = SystemLogReport.INSTANCE;
        boolean zAccess$checkHashChanged = SystemLogReport.access$checkHashChanged(systemLogReport, systemLogUtils$Tombstone.getTextHash());
        if (zAccess$checkHashChanged) {
            Logger.e$default(appLog, "Tombstone", null, null, 6, null);
        }
        if (!zAccess$checkHashChanged) {
            systemLogUtils$Tombstone = null;
        }
        SystemLogReport.access$sendReport(systemLogReport, systemLogUtils$Tombstone);
    }
}
