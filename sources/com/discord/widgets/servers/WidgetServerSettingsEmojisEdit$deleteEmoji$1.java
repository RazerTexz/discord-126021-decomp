package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.stores.StoreStream;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit$deleteEmoji$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetServerSettingsEmojisEdit this$0;

    public WidgetServerSettingsEmojisEdit$deleteEmoji$1(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        this.this$0 = widgetServerSettingsEmojisEdit;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) throws Exception {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r5) throws Exception {
        StoreStream.Companion.getGuildEmojis().deleteEmoji(WidgetServerSettingsEmojisEdit.access$getGuildId$p(this.this$0), WidgetServerSettingsEmojisEdit.access$getEmojiId$p(this.this$0));
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
