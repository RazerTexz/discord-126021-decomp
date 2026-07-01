package com.discord.widgets.botuikit;

import com.discord.api.botuikit.ActionComponent;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.ComponentUtils;
import com.discord.api.botuikit.LayoutComponent;
import com.discord.api.botuikit.SelectComponent;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionInteractionComponentState$Disabled;
import com.discord.models.botuikit.ActionInteractionComponentState$Enabled;
import com.discord.models.botuikit.ActionInteractionComponentState$Failed;
import com.discord.models.botuikit.ActionInteractionComponentState$Loading;
import com.discord.models.botuikit.ActionRowMessageComponentKt;
import com.discord.models.botuikit.ButtonMessageComponentKt;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponentKt;
import com.discord.stores.StoreApplicationInteractions$InteractionSendState;
import com.discord.stores.StoreApplicationInteractions$InteractionSendState$Failed;
import com.discord.stores.StoreApplicationInteractions$InteractionSendState$Loading;
import d0.t.k;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ComponentStateMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentStateMapper {
    public static final ComponentStateMapper INSTANCE = new ComponentStateMapper();

    private ComponentStateMapper() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    public final MessageComponent createActionMessageComponent(ActionComponent component, int index, ComponentChatListState$ComponentStoreState storeState, ComponentExperiments experimentController) {
        Integer num;
        ActionInteractionComponentState actionInteractionComponentState$Failed;
        Set<Map$Entry<Integer, StoreApplicationInteractions$InteractionSendState>> setEntrySet;
        Object next;
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(storeState, "storeState");
        m.checkNotNullParameter(experimentController, "experimentController");
        if (!experimentController.isEnabled(component.getType())) {
            return null;
        }
        Map<Integer, StoreApplicationInteractions$InteractionSendState> interactionState = storeState.getInteractionState();
        if (interactionState == null || (setEntrySet = interactionState.entrySet()) == null) {
            num = null;
        } else {
            Iterator<T> it = setEntrySet.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Map$Entry) next).getValue() instanceof StoreApplicationInteractions$InteractionSendState$Loading));
            Map$Entry map$Entry = (Map$Entry) next;
            if (map$Entry != null) {
                num = (Integer) map$Entry.getKey();
            } else {
                num = null;
            }
        }
        Map<Integer, StoreApplicationInteractions$InteractionSendState> interactionState2 = storeState.getInteractionState();
        StoreApplicationInteractions$InteractionSendState storeApplicationInteractions$InteractionSendState = interactionState2 != null ? interactionState2.get(Integer.valueOf(index)) : null;
        if (!(storeApplicationInteractions$InteractionSendState instanceof StoreApplicationInteractions$InteractionSendState$Failed)) {
            storeApplicationInteractions$InteractionSendState = null;
        }
        StoreApplicationInteractions$InteractionSendState$Failed storeApplicationInteractions$InteractionSendState$Failed = (StoreApplicationInteractions$InteractionSendState$Failed) storeApplicationInteractions$InteractionSendState;
        if (num != null && index == num.intValue()) {
            actionInteractionComponentState$Failed = ActionInteractionComponentState$Loading.INSTANCE;
        } else if (num == null || num.intValue() == index) {
            actionInteractionComponentState$Failed = storeApplicationInteractions$InteractionSendState$Failed != null ? new ActionInteractionComponentState$Failed(storeApplicationInteractions$InteractionSendState$Failed.getErrorMessage()) : ActionInteractionComponentState$Enabled.INSTANCE;
        } else {
            actionInteractionComponentState$Failed = ActionInteractionComponentState$Disabled.INSTANCE;
        }
        if (component instanceof ButtonComponent) {
            return ButtonMessageComponentKt.mergeToMessageComponent((ButtonComponent) component, index, actionInteractionComponentState$Failed, storeState);
        }
        if (component instanceof SelectComponent) {
            return SelectMessageComponentKt.mergeToMessageComponent((SelectComponent) component, index, actionInteractionComponentState$Failed, storeState);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
    public final List<MessageComponent> processComponentsToMessageComponents(List<? extends Component> apiComponents, ComponentChatListState$ComponentStoreState componentStoreState, ComponentExperiments componentExperiments, boolean animateEmojis) {
        m.checkNotNullParameter(apiComponents, "apiComponents");
        m.checkNotNullParameter(componentExperiments, "componentExperiments");
        if (componentStoreState == null) {
            componentStoreState = new ComponentChatListState$ComponentStoreState(null, null, animateEmojis, 3, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new ComponentStateMapper$ChildComponents(-1, null, 0, apiComponents.size());
        Stack stack = new Stack();
        ComponentUtils componentUtils = ComponentUtils.INSTANCE;
        ComponentStateMapper$processComponentsToMessageComponents$1 componentStateMapper$processComponentsToMessageComponents$1 = new ComponentStateMapper$processComponentsToMessageComponents$1(componentStoreState, componentExperiments, ref$ObjectRef, stack);
        Objects.requireNonNull(componentUtils);
        m.checkNotNullParameter(apiComponents, "$this$forEachComponentIndexed");
        m.checkNotNullParameter(componentStateMapper$processComponentsToMessageComponents$1, "action");
        componentUtils.a(apiComponents, 0, componentStateMapper$processComponentsToMessageComponents$1);
        return k.filterNotNull(((ComponentStateMapper$ChildComponents) ref$ObjectRef.element).getComponents());
    }

    public final MessageComponent toMessageLayoutComponent(LayoutComponent component, int index, List<? extends MessageComponent> children, ComponentExperiments experimentController) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(children, "children");
        m.checkNotNullParameter(experimentController, "experimentController");
        ActionRowComponent actionRowComponent = (ActionRowComponent) component;
        if (experimentController.isEnabled(actionRowComponent.getType())) {
            return ActionRowMessageComponentKt.mergeToMessageComponent(actionRowComponent, index, children);
        }
        return null;
    }
}
