package com.discord.utilities.system;

import android.os.Process;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.system.ProcfsReader$pid$2, reason: use source file name */
/* JADX INFO: compiled from: ProcfsReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProcfsReader2 extends Lambda implements Function0<Integer> {
    public static final ProcfsReader2 INSTANCE = new ProcfsReader2();

    public ProcfsReader2() {
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
