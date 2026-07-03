package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.ButtonStyle;
import com.discord.models.botuikit.ButtonMessageComponent;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentViewKt {
    public static final boolean hasEmoji(ButtonMessageComponent buttonMessageComponent) {
        C12238m.checkNotNullParameter(buttonMessageComponent, "$this$hasEmoji");
        return buttonMessageComponent.getEmoji() != null;
    }

    public static final boolean hasIcon(ButtonMessageComponent buttonMessageComponent) {
        C12238m.checkNotNullParameter(buttonMessageComponent, "$this$hasIcon");
        return buttonMessageComponent.getStyle() == ButtonStyle.LINK;
    }
}
