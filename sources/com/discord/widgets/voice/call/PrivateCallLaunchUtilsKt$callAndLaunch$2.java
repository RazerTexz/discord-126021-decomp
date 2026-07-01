package com.discord.widgets.voice.call;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PrivateCallLaunchUtilsKt$callAndLaunch$2 extends k implements Function0<Unit> {
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1 $onPermissionsGranted$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$2(PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1) {
        super(0, null, "onPermissionsGranted", "invoke()V", 0);
        this.$onPermissionsGranted$1 = privateCallLaunchUtilsKt$callAndLaunch$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$onPermissionsGranted$1.invoke2();
    }
}
