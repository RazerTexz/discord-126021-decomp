package com.discord.utilities.debug;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HistoricalProcessExitReason$lastReason$2 extends o implements Function0<HistoricalProcessExitReason$Reason> {
    public static final HistoricalProcessExitReason$lastReason$2 INSTANCE = new HistoricalProcessExitReason$lastReason$2();

    public HistoricalProcessExitReason$lastReason$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HistoricalProcessExitReason$Reason invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HistoricalProcessExitReason$Reason invoke() {
        return HistoricalProcessExitReason.access$createLastReason(HistoricalProcessExitReason.INSTANCE);
    }
}
