package com.discord.models.botuikit;

import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentType;
import com.discord.widgets.botuikit.ComponentChatListState;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ButtonMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonMessageComponentKt {
    public static final ButtonMessageComponent mergeToMessageComponent(ButtonComponent buttonComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        C12238m.checkNotNullParameter(buttonComponent, "$this$mergeToMessageComponent");
        C12238m.checkNotNullParameter(actionInteractionComponentState, "buttonStateInteraction");
        C12238m.checkNotNullParameter(componentStoreState, "componentStoreState");
        ComponentType type = buttonComponent.getType();
        String customId = buttonComponent.getCustomId();
        String label = buttonComponent.getLabel();
        ButtonStyle style = buttonComponent.getStyle();
        if (buttonComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        } else if (buttonComponent.getUrl() != null) {
            actionInteractionComponentState = ActionInteractionComponentState.Enabled.INSTANCE;
        }
        return new ButtonMessageComponent(type, i, actionInteractionComponentState, customId, label, style, buttonComponent.getEmoji(), buttonComponent.getUrl(), componentStoreState.getAnimateEmojis());
    }
}
