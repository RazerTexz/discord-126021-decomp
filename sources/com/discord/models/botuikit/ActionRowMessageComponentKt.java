package com.discord.models.botuikit;

import com.discord.api.botuikit.ActionRowComponent;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ActionRowMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionRowMessageComponentKt {
    public static final ActionRowMessageComponent mergeToMessageComponent(ActionRowComponent actionRowComponent, int i, List<? extends MessageComponent> list) {
        m.checkNotNullParameter(actionRowComponent, "$this$mergeToMessageComponent");
        m.checkNotNullParameter(list, "children");
        return new ActionRowMessageComponent(actionRowComponent.getType(), i, list);
    }
}
