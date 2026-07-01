package com.discord.widgets.bugreports;

import com.discord.utilities.file.DownloadUtils$DownloadState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$prefetchStickers$1 extends o implements Function1<DownloadUtils$DownloadState, Unit> {
    public static final BugReportViewModel$prefetchStickers$1 INSTANCE = new BugReportViewModel$prefetchStickers$1();

    public BugReportViewModel$prefetchStickers$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils$DownloadState downloadUtils$DownloadState) {
        invoke2(downloadUtils$DownloadState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DownloadUtils$DownloadState downloadUtils$DownloadState) {
        m.checkNotNullParameter(downloadUtils$DownloadState, "it");
    }
}
