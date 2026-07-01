package com.discord.models.botuikit;

import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentType;
import com.discord.widgets.botuikit.ComponentChatListState$ComponentStoreState;
import d0.z.d.m;

/* JADX INFO: compiled from: ButtonMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonMessageComponentKt {
    public static final ButtonMessageComponent mergeToMessageComponent(ButtonComponent buttonComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState$ComponentStoreState componentChatListState$ComponentStoreState) {
        m.checkNotNullParameter(buttonComponent, "$this$mergeToMessageComponent");
        m.checkNotNullParameter(actionInteractionComponentState, "buttonStateInteraction");
        m.checkNotNullParameter(componentChatListState$ComponentStoreState, "componentStoreState");
        ComponentType type = buttonComponent.getType();
        String customId = buttonComponent.getCustomId();
        String label = buttonComponent.getLabel();
        ButtonStyle style = buttonComponent.getStyle();
        if (buttonComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState$Disabled.INSTANCE;
        } else if (buttonComponent.getUrl() != null) {
            actionInteractionComponentState = ActionInteractionComponentState$Enabled.INSTANCE;
        }
        return new ButtonMessageComponent(type, i, actionInteractionComponentState, customId, label, style, buttonComponent.getEmoji(), buttonComponent.getUrl(), componentChatListState$ComponentStoreState.getAnimateEmojis());
    }
}
