package com.discord.widgets.voice.call;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$4 extends o implements Function1<Long, Boolean> {
    public final /* synthetic */ PrivateCallLaunchUtilsKt$callAndLaunch$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$1$4(PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1) {
        super(1);
        this.this$0 = privateCallLaunchUtilsKt$callAndLaunch$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke2(l));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Long l) {
        return l != null && l.longValue() == this.this$0.$channelId;
    }
}
