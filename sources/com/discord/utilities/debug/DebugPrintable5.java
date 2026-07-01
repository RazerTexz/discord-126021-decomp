package com.discord.utilities.debug;

import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.discord.utilities.debug.DebugPrintableRef, reason: use source file name */
/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintable5 {
    private final WeakReference<DebugPrintable> reference;
    private final String tag;

    public DebugPrintable5(String str, DebugPrintable debugPrintable) {
        Intrinsics3.checkNotNullParameter(debugPrintable, "debugPrintable");
        this.tag = str;
        this.reference = new WeakReference<>(debugPrintable);
    }

    public final WeakReference<DebugPrintable> getReference() {
        return this.reference;
    }

    public final String getTag() {
        return this.tag;
    }
}
