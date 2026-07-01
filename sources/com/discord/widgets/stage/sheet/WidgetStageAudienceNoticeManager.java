package com.discord.widgets.stage.sheet;

import com.discord.utilities.cache.SharedPreferencesProvider;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeManager {
    public static final WidgetStageAudienceNoticeManager INSTANCE = new WidgetStageAudienceNoticeManager();
    private static final String STAGE_AUDIENCE_NOTICE_SHOWN_KEY = "STAGE_AUDIENCE_NOTICE_SHOWN_KEY";

    private WidgetStageAudienceNoticeManager() {
    }

    public final boolean hasUserSeenAudienceNotice() {
        return SharedPreferencesProvider.INSTANCE.get().getBoolean(STAGE_AUDIENCE_NOTICE_SHOWN_KEY, false);
    }

    public final void markUserSeenAudienceNotice() {
        SharedPreferencesProvider.INSTANCE.get().edit().putBoolean(STAGE_AUDIENCE_NOTICE_SHOWN_KEY, true).apply();
    }
}
