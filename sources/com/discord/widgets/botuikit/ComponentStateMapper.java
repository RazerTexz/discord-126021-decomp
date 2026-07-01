package com.discord.widgets.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.Component5;
import com.discord.api.botuikit.Component7;
import com.discord.api.botuikit.Component8;
import com.discord.api.botuikit.SelectComponent;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent2;
import com.discord.models.botuikit.ButtonMessageComponent2;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ComponentStateMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentStateMapper {
    public static final ComponentStateMapper INSTANCE = new ComponentStateMapper();

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.ComponentStateMapper$processComponentsToMessageComponents$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComponentStateMapper.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Integer, Component, Unit> {
        public final /* synthetic */ Stack $childComponentsLevelStack;
        public final /* synthetic */ Ref$ObjectRef $childrenComponents;
        public final /* synthetic */ ComponentExperiments $componentExperiments;
        public final /* synthetic */ ComponentChatListState.ComponentStoreState $componentState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentChatListState.ComponentStoreState componentStoreState, ComponentExperiments componentExperiments, Ref$ObjectRef ref$ObjectRef, Stack stack) {
            super(2);
            this.$componentState = componentStoreState;
            this.$componentExperiments = componentExperiments;
            this.$childrenComponents = ref$ObjectRef;
            this.$childComponentsLevelStack = stack;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Component component) {
            invoke(num.intValue(), component);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
        /* JADX WARN: Type inference failed for: r8v0, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
        public final void invoke(int i, Component component) {
            Component8 parentLayoutComponent;
            Intrinsics3.checkNotNullParameter(component, "component");
            if (component instanceof Component5) {
                MessageComponent messageComponentCreateActionMessageComponent = ComponentStateMapper.INSTANCE.createActionMessageComponent((Component5) component, i, this.$componentState, this.$componentExperiments);
                if (messageComponentCreateActionMessageComponent != null) {
                    ((ChildComponents) this.$childrenComponents.element).getComponents()[((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageComponentCreateActionMessageComponent;
                }
                ChildComponents childComponents = (ChildComponents) this.$childrenComponents.element;
                childComponents.setCurrentComponentInsertionIndex(childComponents.getCurrentComponentInsertionIndex() + 1);
            } else if (component instanceof Component8) {
                this.$childComponentsLevelStack.push((ChildComponents) this.$childrenComponents.element);
                Component8 component8 = (Component8) component;
                this.$childrenComponents.element = new ChildComponents(i, component8, 0, component8.a().size(), 4, null);
            }
            while (((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex() == ((ChildComponents) this.$childrenComponents.element).getTotal() && (parentLayoutComponent = ((ChildComponents) this.$childrenComponents.element).getParentLayoutComponent()) != null) {
                MessageComponent messageLayoutComponent = ComponentStateMapper.INSTANCE.toMessageLayoutComponent(parentLayoutComponent, ((ChildComponents) this.$childrenComponents.element).getLayoutComponentIndex(), _Arrays.filterNotNull(((ChildComponents) this.$childrenComponents.element).getComponents()), this.$componentExperiments);
                Ref$ObjectRef ref$ObjectRef = this.$childrenComponents;
                Object objPop = this.$childComponentsLevelStack.pop();
                Intrinsics3.checkNotNullExpressionValue(objPop, "childComponentsLevelStack.pop()");
                ref$ObjectRef.element = (ChildComponents) objPop;
                ((ChildComponents) this.$childrenComponents.element).getComponents()[((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageLayoutComponent;
                ChildComponents childComponents2 = (ChildComponents) this.$childrenComponents.element;
                childComponents2.setCurrentComponentInsertionIndex(childComponents2.getCurrentComponentInsertionIndex() + 1);
            }
        }
    }

    private ComponentStateMapper() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    public final MessageComponent createActionMessageComponent(Component5 component, int index, ComponentChatListState.ComponentStoreState storeState, ComponentExperiments experimentController) {
        Integer num;
        ActionInteractionComponentState failed;
        Set<Map.Entry<Integer, StoreApplicationInteractions.InteractionSendState>> setEntrySet;
        Object next;
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        Intrinsics3.checkNotNullParameter(experimentController, "experimentController");
        if (!experimentController.isEnabled(component.getType())) {
            return null;
        }
        Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState = storeState.getInteractionState();
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
            } while (!(((Map.Entry) next).getValue() instanceof StoreApplicationInteractions.InteractionSendState.Loading));
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                num = (Integer) entry.getKey();
            } else {
                num = null;
            }
        }
        Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState2 = storeState.getInteractionState();
        StoreApplicationInteractions.InteractionSendState interactionSendState = interactionState2 != null ? interactionState2.get(Integer.valueOf(index)) : null;
        if (!(interactionSendState instanceof StoreApplicationInteractions.InteractionSendState.Failed)) {
            interactionSendState = null;
        }
        StoreApplicationInteractions.InteractionSendState.Failed failed2 = (StoreApplicationInteractions.InteractionSendState.Failed) interactionSendState;
        if (num != null && index == num.intValue()) {
            failed = ActionInteractionComponentState.Loading.INSTANCE;
        } else if (num == null || num.intValue() == index) {
            failed = failed2 != null ? new ActionInteractionComponentState.Failed(failed2.getErrorMessage()) : ActionInteractionComponentState.Enabled.INSTANCE;
        } else {
            failed = ActionInteractionComponentState.Disabled.INSTANCE;
        }
        if (component instanceof ButtonComponent) {
            return ButtonMessageComponent2.mergeToMessageComponent((ButtonComponent) component, index, failed, storeState);
        }
        if (component instanceof SelectComponent) {
            return SelectMessageComponent2.mergeToMessageComponent((SelectComponent) component, index, failed, storeState);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
    public final List<MessageComponent> processComponentsToMessageComponents(List<? extends Component> apiComponents, ComponentChatListState.ComponentStoreState componentStoreState, ComponentExperiments componentExperiments, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(apiComponents, "apiComponents");
        Intrinsics3.checkNotNullParameter(componentExperiments, "componentExperiments");
        if (componentStoreState == null) {
            componentStoreState = new ComponentChatListState.ComponentStoreState(null, null, animateEmojis, 3, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new ChildComponents(-1, null, 0, apiComponents.size());
        Stack stack = new Stack();
        Component7 component7 = Component7.INSTANCE;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(componentStoreState, componentExperiments, ref$ObjectRef, stack);
        Objects.requireNonNull(component7);
        Intrinsics3.checkNotNullParameter(apiComponents, "$this$forEachComponentIndexed");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "action");
        component7.a(apiComponents, 0, anonymousClass1);
        return _Arrays.filterNotNull(((ChildComponents) ref$ObjectRef.element).getComponents());
    }

    public final MessageComponent toMessageLayoutComponent(Component8 component, int index, List<? extends MessageComponent> children, ComponentExperiments experimentController) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(children, "children");
        Intrinsics3.checkNotNullParameter(experimentController, "experimentController");
        ActionRowComponent actionRowComponent = (ActionRowComponent) component;
        if (experimentController.isEnabled(actionRowComponent.getType())) {
            return ActionRowMessageComponent2.mergeToMessageComponent(actionRowComponent, index, children);
        }
        return null;
    }

    /* JADX INFO: compiled from: ComponentStateMapper.kt */
    public static final /* data */ class ChildComponents {
        private final MessageComponent[] components;
        private int currentComponentInsertionIndex;
        private final int layoutComponentIndex;
        private final Component8 parentLayoutComponent;
        private final int total;

        public ChildComponents(int i, Component8 component8, int i2, int i3) {
            this.layoutComponentIndex = i;
            this.parentLayoutComponent = component8;
            this.currentComponentInsertionIndex = i2;
            this.total = i3;
            MessageComponent[] messageComponentArr = new MessageComponent[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                messageComponentArr[i4] = null;
            }
            this.components = messageComponentArr;
        }

        public static /* synthetic */ ChildComponents copy$default(ChildComponents childComponents, int i, Component8 component8, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = childComponents.layoutComponentIndex;
            }
            if ((i4 & 2) != 0) {
                component8 = childComponents.parentLayoutComponent;
            }
            if ((i4 & 4) != 0) {
                i2 = childComponents.currentComponentInsertionIndex;
            }
            if ((i4 & 8) != 0) {
                i3 = childComponents.total;
            }
            return childComponents.copy(i, component8, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getLayoutComponentIndex() {
            return this.layoutComponentIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Component8 getParentLayoutComponent() {
            return this.parentLayoutComponent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCurrentComponentInsertionIndex() {
            return this.currentComponentInsertionIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final ChildComponents copy(int layoutComponentIndex, Component8 parentLayoutComponent, int currentComponentInsertionIndex, int total) {
            return new ChildComponents(layoutComponentIndex, parentLayoutComponent, currentComponentInsertionIndex, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChildComponents)) {
                return false;
            }
            ChildComponents childComponents = (ChildComponents) other;
            return this.layoutComponentIndex == childComponents.layoutComponentIndex && Intrinsics3.areEqual(this.parentLayoutComponent, childComponents.parentLayoutComponent) && this.currentComponentInsertionIndex == childComponents.currentComponentInsertionIndex && this.total == childComponents.total;
        }

        public final MessageComponent[] getComponents() {
            return this.components;
        }

        public final int getCurrentComponentInsertionIndex() {
            return this.currentComponentInsertionIndex;
        }

        public final int getLayoutComponentIndex() {
            return this.layoutComponentIndex;
        }

        public final Component8 getParentLayoutComponent() {
            return this.parentLayoutComponent;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            int i = this.layoutComponentIndex * 31;
            Component8 component8 = this.parentLayoutComponent;
            return ((((i + (component8 != null ? component8.hashCode() : 0)) * 31) + this.currentComponentInsertionIndex) * 31) + this.total;
        }

        public final void setCurrentComponentInsertionIndex(int i) {
            this.currentComponentInsertionIndex = i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChildComponents(layoutComponentIndex=");
            sbU.append(this.layoutComponentIndex);
            sbU.append(", parentLayoutComponent=");
            sbU.append(this.parentLayoutComponent);
            sbU.append(", currentComponentInsertionIndex=");
            sbU.append(this.currentComponentInsertionIndex);
            sbU.append(", total=");
            return outline.B(sbU, this.total, ")");
        }

        public /* synthetic */ ChildComponents(int i, Component8 component8, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i4 & 2) != 0 ? null : component8, (i4 & 4) != 0 ? 0 : i2, i3);
        }
    }
}
