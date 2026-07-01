package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$openAvatarPicker$1<T> implements Action1<String> {
    public final /* synthetic */ String $guildShortName;
    public final /* synthetic */ String $iconOriginal;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$openAvatarPicker$1(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2) {
        this.this$0 = widgetServerSettingsOverview;
        this.$guildShortName = str;
        this.$iconOriginal = str2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetServerSettingsOverview.access$configureIcon(this.this$0, this.$guildShortName, this.$iconOriginal, str, true);
    }
}
