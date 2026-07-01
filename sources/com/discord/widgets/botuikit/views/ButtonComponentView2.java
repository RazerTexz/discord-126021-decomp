package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.ButtonComponent2;
import com.discord.models.botuikit.ButtonMessageComponent;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.ButtonComponentViewKt, reason: use source file name */
/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentView2 {
    public static final boolean hasEmoji(ButtonMessageComponent buttonMessageComponent) {
        Intrinsics3.checkNotNullParameter(buttonMessageComponent, "$this$hasEmoji");
        return buttonMessageComponent.getEmoji() != null;
    }

    public static final boolean hasIcon(ButtonMessageComponent buttonMessageComponent) {
        Intrinsics3.checkNotNullParameter(buttonMessageComponent, "$this$hasIcon");
        return buttonMessageComponent.getStyle() == ButtonComponent2.LINK;
    }
}
