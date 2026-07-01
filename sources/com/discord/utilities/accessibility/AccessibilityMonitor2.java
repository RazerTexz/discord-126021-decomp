package com.discord.utilities.accessibility;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor2 extends Lambda implements Function0<AccessibilityMonitor> {
    public static final AccessibilityMonitor2 INSTANCE = new AccessibilityMonitor2();

    public AccessibilityMonitor2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AccessibilityMonitor invoke() {
        return new AccessibilityMonitor();
    }
}
