package com.discord.utilities.debug;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HistoricalProcessExitReason$lastReason$2 extends AbstractC12240o implements Function0<HistoricalProcessExitReason.Reason> {
    public static final HistoricalProcessExitReason$lastReason$2 INSTANCE = new HistoricalProcessExitReason$lastReason$2();

    public HistoricalProcessExitReason$lastReason$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HistoricalProcessExitReason.Reason invoke() {
        return HistoricalProcessExitReason.INSTANCE.createLastReason();
    }
}
