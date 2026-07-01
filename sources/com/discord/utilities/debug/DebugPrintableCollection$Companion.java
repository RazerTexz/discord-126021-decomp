package com.discord.utilities.debug;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugPrintable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugPrintableCollection$Companion {
    private DebugPrintableCollection$Companion() {
    }

    public final void initialize(String libdiscordVersion) {
        m.checkNotNullParameter(libdiscordVersion, "libdiscordVersion");
        DebugPrintableCollection.access$setLibdiscordVersion$cp(libdiscordVersion);
    }

    public /* synthetic */ DebugPrintableCollection$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
