package com.discord.utilities.system;

import android.os.Process;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcfsReader$pid$2 extends o implements Function0<Integer> {
    public static final ProcfsReader$pid$2 INSTANCE = new ProcfsReader$pid$2();

    public ProcfsReader$pid$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return Process.myPid();
    }
}
