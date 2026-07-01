package com.discord.widgets.guilds.create;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel$1 implements Action0 {
    public final /* synthetic */ String $guildTemplateCode;

    public WidgetGuildCreateViewModel$1(String str) {
        this.$guildTemplateCode = str;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreStream.Companion.getGuildTemplates().maybeInitTemplateState(this.$guildTemplateCode);
    }
}
