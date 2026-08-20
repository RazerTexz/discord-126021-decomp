package com.discord.models.botuikit;

import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectComponent;
import com.discord.api.botuikit.SelectItem;
import com.discord.widgets.botuikit.ComponentChatListState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectMessageComponentKt {
    public static final SelectMessageComponent mergeToMessageComponent(SelectComponent selectComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        C12238m.checkNotNullParameter(selectComponent, "$this$mergeToMessageComponent");
        C12238m.checkNotNullParameter(actionInteractionComponentState, "actionInteractionComponentState");
        C12238m.checkNotNullParameter(componentStoreState, "componentStoreState");
        Map<Integer, List<SelectItem>> selections = componentStoreState.getSelections();
        List arrayList = selections != null ? selections.get(Integer.valueOf(i)) : null;
        ComponentType type = selectComponent.getType();
        String customId = selectComponent.getCustomId();
        String placeholder = selectComponent.getPlaceholder();
        int minValues = selectComponent.getMinValues();
        int maxValues = selectComponent.getMaxValues();
        List<SelectItem> listM7609e = selectComponent.m7609e();
        if (selectComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        }
        ActionInteractionComponentState actionInteractionComponentState2 = actionInteractionComponentState;
        if (arrayList == null) {
            List<SelectItem> listM7609e2 = selectComponent.m7609e();
            arrayList = new ArrayList();
            for (Object obj : listM7609e2) {
                if (((SelectItem) obj).getDefault()) {
                    arrayList.add(obj);
                }
            }
        }
        return new SelectMessageComponent(type, i, actionInteractionComponentState2, customId, placeholder, minValues, maxValues, listM7609e, arrayList, componentStoreState.getAnimateEmojis());
    }
}
