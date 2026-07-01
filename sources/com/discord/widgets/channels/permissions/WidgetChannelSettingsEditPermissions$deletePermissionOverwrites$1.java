package com.discord.widgets.channels.permissions;

import com.discord.app.AppActivity;
import com.discord.utilities.stateful.StatefulViews;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(1);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) throws Exception {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r4) throws Exception {
        StatefulViews statefulViewsAccess$getState$p = WidgetChannelSettingsEditPermissions.access$getState$p(this.this$0);
        if (statefulViewsAccess$getState$p != null) {
            StatefulViews.clear$default(statefulViewsAccess$getState$p, false, 1, null);
        }
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
