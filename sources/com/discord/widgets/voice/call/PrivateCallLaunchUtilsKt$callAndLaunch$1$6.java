package com.discord.widgets.voice.call;

import com.discord.stores.StoreCalls;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$6 extends o implements Function0<Unit> {
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$1$6(PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1) {
        super(0);
        this.this$0 = privateCallLaunchUtilsKt$callAndLaunch$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreCalls calls = StoreStream.Companion.getCalls();
        PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1 = this.this$0;
        calls.call(privateCallLaunchUtilsKt$callAndLaunch$1.$appComponent, privateCallLaunchUtilsKt$callAndLaunch$1.$context, privateCallLaunchUtilsKt$callAndLaunch$1.$fragmentManager, privateCallLaunchUtilsKt$callAndLaunch$1.$channelId, PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1.INSTANCE);
    }
}
