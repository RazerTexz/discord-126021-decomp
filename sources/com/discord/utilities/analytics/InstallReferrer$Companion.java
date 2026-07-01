package com.discord.utilities.analytics;

import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InstallReferrer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstallReferrer$Companion {
    private InstallReferrer$Companion() {
    }

    private final InstallReferrer getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = InstallReferrer.access$getINSTANCE$cp();
        InstallReferrer$Companion installReferrer$Companion = InstallReferrer.Companion;
        return (InstallReferrer) lazyAccess$getINSTANCE$cp.getValue();
    }

    public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
        m.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
        getINSTANCE().init(onReceivedInstallReferrer);
    }

    public /* synthetic */ InstallReferrer$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
