package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$configureUI$3 extends o implements Function2<View, ModelEmojiGuild, Unit> {
    public final /* synthetic */ WidgetServerSettingsEmojis this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$configureUI$3(WidgetServerSettingsEmojis widgetServerSettingsEmojis) {
        super(2);
        this.this$0 = widgetServerSettingsEmojis;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
        invoke2(view, modelEmojiGuild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(modelEmojiGuild, "emoji");
        WidgetServerSettingsEmojis.access$launchEditScreen(this.this$0, view, modelEmojiGuild);
    }
}
