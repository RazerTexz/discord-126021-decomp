package com.discord.widgets.voice.call;

import b.a.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$7 extends o implements Function1<String, Unit> {
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1$6 $doCall$6;
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$1$7(PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1, PrivateCallLaunchUtilsKt$callAndLaunch$1$6 privateCallLaunchUtilsKt$callAndLaunch$1$6) {
        super(1);
        this.this$0 = privateCallLaunchUtilsKt$callAndLaunch$1;
        this.$doCall$6 = privateCallLaunchUtilsKt$callAndLaunch$1$6;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        if (str != null) {
            this.$doCall$6.invoke2();
        } else {
            m.g(this.this$0.$context, 2131893291, 0, null, 12);
        }
    }
}
