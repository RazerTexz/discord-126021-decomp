package com.discord.utilities.debug;

import com.discord.utilities.debug.HistoricalProcessExitReason;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.debug.HistoricalProcessExitReason$lastReason$2, reason: use source file name */
/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HistoricalProcessExitReason2 extends Lambda implements Function0<HistoricalProcessExitReason.Reason> {
    public static final HistoricalProcessExitReason2 INSTANCE = new HistoricalProcessExitReason2();

    public HistoricalProcessExitReason2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HistoricalProcessExitReason.Reason invoke() {
        return HistoricalProcessExitReason.INSTANCE.createLastReason();
    }
}
