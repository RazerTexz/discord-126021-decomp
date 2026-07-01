package com.discord.models.botuikit;

import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.SelectComponent;
import com.discord.api.botuikit.SelectItem;
import com.discord.widgets.botuikit.ComponentChatListState$ComponentStoreState;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SelectMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectMessageComponentKt {
    public static final SelectMessageComponent mergeToMessageComponent(SelectComponent selectComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState$ComponentStoreState componentChatListState$ComponentStoreState) {
        m.checkNotNullParameter(selectComponent, "$this$mergeToMessageComponent");
        m.checkNotNullParameter(actionInteractionComponentState, "actionInteractionComponentState");
        m.checkNotNullParameter(componentChatListState$ComponentStoreState, "componentStoreState");
        Map<Integer, List<SelectItem>> selections = componentChatListState$ComponentStoreState.getSelections();
        List arrayList = selections != null ? selections.get(Integer.valueOf(i)) : null;
        ComponentType type = selectComponent.getType();
        String customId = selectComponent.getCustomId();
        String placeholder = selectComponent.getPlaceholder();
        int minValues = selectComponent.getMinValues();
        int maxValues = selectComponent.getMaxValues();
        List<SelectItem> listE = selectComponent.e();
        if (selectComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState$Disabled.INSTANCE;
        }
        ActionInteractionComponentState actionInteractionComponentState2 = actionInteractionComponentState;
        if (arrayList == null) {
            List<SelectItem> listE2 = selectComponent.e();
            arrayList = new ArrayList();
            for (Object obj : listE2) {
                if (((SelectItem) obj).getDefault()) {
                    arrayList.add(obj);
                }
            }
        }
        return new SelectMessageComponent(type, i, actionInteractionComponentState2, customId, placeholder, minValues, maxValues, listE, arrayList, componentChatListState$ComponentStoreState.getAnimateEmojis());
    }
}
