package com.discord.models.botuikit;

import d0.z.d.m;

/* JADX INFO: compiled from: MessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageComponentUtils {
    public static final MessageComponentUtils INSTANCE = new MessageComponentUtils();

    private MessageComponentUtils() {
    }

    public final ActionInteractionComponentState$Failed getChildError(LayoutMessageComponent layoutMessageComponent) {
        m.checkNotNullParameter(layoutMessageComponent, "$this$getChildError");
        for (MessageComponent messageComponent : layoutMessageComponent.getChildren()) {
            if (messageComponent instanceof ActionMessageComponent) {
                ActionInteractionComponentState stateInteraction = ((ActionMessageComponent) messageComponent).getStateInteraction();
                if (stateInteraction instanceof ActionInteractionComponentState$Failed) {
                    return (ActionInteractionComponentState$Failed) stateInteraction;
                }
            }
        }
        return null;
    }
}
