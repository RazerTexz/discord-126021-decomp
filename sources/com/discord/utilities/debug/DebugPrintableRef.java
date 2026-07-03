package com.discord.utilities.debug;

import java.lang.ref.WeakReference;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintableRef {
    private final WeakReference<DebugPrintable> reference;
    private final String tag;

    public DebugPrintableRef(String str, DebugPrintable debugPrintable) {
        C12238m.checkNotNullParameter(debugPrintable, "debugPrintable");
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
