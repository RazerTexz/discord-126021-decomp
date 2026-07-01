package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit$handleSaveAlias$1<T> implements Action1<ModelEmojiGuild> {
    public final /* synthetic */ String $sanitizedName;
    public final /* synthetic */ WidgetServerSettingsEmojisEdit this$0;

    public WidgetServerSettingsEmojisEdit$handleSaveAlias$1(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, String str) {
        this.this$0 = widgetServerSettingsEmojisEdit;
        this.$sanitizedName = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelEmojiGuild modelEmojiGuild) {
        call2(modelEmojiGuild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelEmojiGuild modelEmojiGuild) {
        WidgetServerSettingsEmojisEdit.access$onSaveSuccess(this.this$0, this.$sanitizedName);
    }
}
