package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet$addPermissionOverwrites$1 extends o implements Function1<List<? extends Void>, Unit> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberSheet$addPermissionOverwrites$1(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        super(1);
        this.this$0 = widgetChannelSettingsAddMemberSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Void> list) {
        invoke2((List<Void>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Void> list) {
        m.checkNotNullParameter(list, "it");
        this.this$0.dismiss();
    }
}
