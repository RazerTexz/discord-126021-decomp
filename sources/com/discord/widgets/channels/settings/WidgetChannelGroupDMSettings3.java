package com.discord.widgets.channels.settings;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$iconEditedResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings3 extends Lambda implements Function1<String, Unit> {
    public static final WidgetChannelGroupDMSettings3 INSTANCE = new WidgetChannelGroupDMSettings3();

    public WidgetChannelGroupDMSettings3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
    }
}
