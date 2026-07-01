package com.discord.models.botuikit;

import com.discord.models.botuikit.ActionInteractionComponentState;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.botuikit.MessageComponentUtils, reason: use source file name */
/* JADX INFO: compiled from: MessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageComponent4 {
    public static final MessageComponent4 INSTANCE = new MessageComponent4();

    private MessageComponent4() {
    }

    public final ActionInteractionComponentState.Failed getChildError(MessageComponent3 messageComponent3) {
        Intrinsics3.checkNotNullParameter(messageComponent3, "$this$getChildError");
        for (MessageComponent messageComponent : messageComponent3.getChildren()) {
            if (messageComponent instanceof MessageComponent2) {
                ActionInteractionComponentState stateInteraction = ((MessageComponent2) messageComponent).getStateInteraction();
                if (stateInteraction instanceof ActionInteractionComponentState.Failed) {
                    return (ActionInteractionComponentState.Failed) stateInteraction;
                }
            }
        }
        return null;
    }
}
