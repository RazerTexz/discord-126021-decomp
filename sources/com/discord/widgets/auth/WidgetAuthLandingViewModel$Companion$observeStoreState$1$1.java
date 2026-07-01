package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$Companion$observeStoreState$1$1 implements Action0 {
    public final /* synthetic */ String $guildTemplateCode;
    public final /* synthetic */ WidgetAuthLandingViewModel$Companion$observeStoreState$1 this$0;

    public WidgetAuthLandingViewModel$Companion$observeStoreState$1$1(WidgetAuthLandingViewModel$Companion$observeStoreState$1 widgetAuthLandingViewModel$Companion$observeStoreState$1, String str) {
        this.this$0 = widgetAuthLandingViewModel$Companion$observeStoreState$1;
        this.$guildTemplateCode = str;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.$storeGuildTemplates.maybeInitTemplateState(this.$guildTemplateCode);
    }
}
