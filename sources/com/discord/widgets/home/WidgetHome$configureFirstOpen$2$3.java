package com.discord.widgets.home;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureFirstOpen$2$3 extends o implements Function0<Unit> {
    public static final WidgetHome$configureFirstOpen$2$3 INSTANCE = new WidgetHome$configureFirstOpen$2$3();

    public WidgetHome$configureFirstOpen$2$3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getNux().updateNux(WidgetHome$configureFirstOpen$2$3$1.INSTANCE);
    }
}
