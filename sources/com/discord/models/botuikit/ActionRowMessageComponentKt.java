package com.discord.models.botuikit;

import com.discord.api.botuikit.ActionRowComponent;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActionRowMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionRowMessageComponentKt {
    public static final ActionRowMessageComponent mergeToMessageComponent(ActionRowComponent actionRowComponent, int i, List<? extends MessageComponent> list) {
        C12238m.checkNotNullParameter(actionRowComponent, "$this$mergeToMessageComponent");
        C12238m.checkNotNullParameter(list, "children");
        return new ActionRowMessageComponent(actionRowComponent.getType(), i, list);
    }
}
