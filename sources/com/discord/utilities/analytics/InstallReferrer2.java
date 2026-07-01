package com.discord.utilities.analytics;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.analytics.InstallReferrer$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: InstallReferrer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstallReferrer2 extends Lambda implements Function0<InstallReferrer> {
    public static final InstallReferrer2 INSTANCE = new InstallReferrer2();

    public InstallReferrer2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final InstallReferrer invoke() {
        return new InstallReferrer(null, null, 3, null);
    }
}
