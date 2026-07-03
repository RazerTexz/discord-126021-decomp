package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 extends AbstractC12240o implements Function2<View, ModelEmojiGuild, Unit> {
    public static final WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 INSTANCE = new WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1();

    public WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
        invoke2(view, modelEmojiGuild);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(modelEmojiGuild, "<anonymous parameter 1>");
    }
}
