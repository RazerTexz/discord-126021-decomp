package com.discord.widgets.nux;

import com.discord.app.LoggingConfig;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubGuildTemplates extends WidgetGuildTemplates {
    private final LoggingConfig loggingConfig = new LoggingConfig(false, null, WidgetHubGuildTemplates$loggingConfig$1.INSTANCE, 3);

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }
}
