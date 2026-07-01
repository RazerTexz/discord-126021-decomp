package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$5<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel$Actions $actions$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$5(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions, long j) {
        this.this$0 = widgetGuildProfileSheet;
        this.$actions$inlined = widgetGuildProfileSheetViewModel$Actions;
        this.$guildId$inlined = j;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModelAccess$getViewModel$p = WidgetGuildProfileSheet.access$getViewModel$p(this.this$0);
        AppActivity appActivity = this.this$0.getAppActivity();
        long j = this.$guildId$inlined;
        m.checkNotNullExpressionValue(bool, "checked");
        widgetGuildProfileSheetViewModelAccess$getViewModel$p.setAllowDM(appActivity, j, bool.booleanValue());
    }
}
