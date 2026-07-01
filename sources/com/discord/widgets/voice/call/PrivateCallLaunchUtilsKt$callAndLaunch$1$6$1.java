package com.discord.widgets.voice.call;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1 extends o implements Function0<Unit> {
    public static final PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1 INSTANCE = new PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1();

    public PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getMediaEngine().selectVideoInputDevice(null);
    }
}
