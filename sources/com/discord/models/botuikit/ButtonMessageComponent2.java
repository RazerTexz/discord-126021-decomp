package com.discord.models.botuikit;

import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.ButtonComponent2;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.botuikit.ButtonMessageComponentKt, reason: use source file name */
/* JADX INFO: compiled from: ButtonMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonMessageComponent2 {
    public static final ButtonMessageComponent mergeToMessageComponent(ButtonComponent buttonComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        Intrinsics3.checkNotNullParameter(buttonComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "buttonStateInteraction");
        Intrinsics3.checkNotNullParameter(componentStoreState, "componentStoreState");
        Component6 type = buttonComponent.getType();
        String customId = buttonComponent.getCustomId();
        String label = buttonComponent.getLabel();
        ButtonComponent2 style = buttonComponent.getStyle();
        if (buttonComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        } else if (buttonComponent.getUrl() != null) {
            actionInteractionComponentState = ActionInteractionComponentState.Enabled.INSTANCE;
        }
        return new ButtonMessageComponent(type, i, actionInteractionComponentState, customId, label, style, buttonComponent.getEmoji(), buttonComponent.getUrl(), componentStoreState.getAnimateEmojis());
    }
}
