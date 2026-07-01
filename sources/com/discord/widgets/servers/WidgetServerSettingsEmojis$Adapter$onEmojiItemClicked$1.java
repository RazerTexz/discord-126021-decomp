package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 extends Lambda implements Function2<View, ModelEmojiGuild, Unit> {
    public static final WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 INSTANCE = new WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1();

    public WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
        invoke2(view, modelEmojiGuild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(modelEmojiGuild, "<anonymous parameter 1>");
    }
}
