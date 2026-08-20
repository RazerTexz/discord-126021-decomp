package com.discord.models.botuikit;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageComponentUtils {
    public static final MessageComponentUtils INSTANCE = new MessageComponentUtils();

    private MessageComponentUtils() {
    }

    public final ActionInteractionComponentState.Failed getChildError(LayoutMessageComponent layoutMessageComponent) {
        C12238m.checkNotNullParameter(layoutMessageComponent, "$this$getChildError");
        for (MessageComponent messageComponent : layoutMessageComponent.getChildren()) {
            if (messageComponent instanceof ActionMessageComponent) {
                ActionInteractionComponentState stateInteraction = ((ActionMessageComponent) messageComponent).getStateInteraction();
                if (stateInteraction instanceof ActionInteractionComponentState.Failed) {
                    return (ActionInteractionComponentState.Failed) stateInteraction;
                }
            }
        }
        return null;
    }
}
