package com.discord.widgets.botuikit;

import com.discord.api.botuikit.ActionComponent;
import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.LayoutComponent;
import com.discord.models.botuikit.MessageComponent;
import d0.t.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ComponentStateMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentStateMapper$processComponentsToMessageComponents$1 extends o implements Function2<Integer, Component, Unit> {
    public final /* synthetic */ Stack $childComponentsLevelStack;
    public final /* synthetic */ Ref$ObjectRef $childrenComponents;
    public final /* synthetic */ ComponentExperiments $componentExperiments;
    public final /* synthetic */ ComponentChatListState$ComponentStoreState $componentState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentStateMapper$processComponentsToMessageComponents$1(ComponentChatListState$ComponentStoreState componentChatListState$ComponentStoreState, ComponentExperiments componentExperiments, Ref$ObjectRef ref$ObjectRef, Stack stack) {
        super(2);
        this.$componentState = componentChatListState$ComponentStoreState;
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
        LayoutComponent parentLayoutComponent;
        m.checkNotNullParameter(component, "component");
        if (component instanceof ActionComponent) {
            MessageComponent messageComponentCreateActionMessageComponent = ComponentStateMapper.INSTANCE.createActionMessageComponent((ActionComponent) component, i, this.$componentState, this.$componentExperiments);
            if (messageComponentCreateActionMessageComponent != null) {
                ((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getComponents()[((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageComponentCreateActionMessageComponent;
            }
            ComponentStateMapper$ChildComponents componentStateMapper$ChildComponents = (ComponentStateMapper$ChildComponents) this.$childrenComponents.element;
            componentStateMapper$ChildComponents.setCurrentComponentInsertionIndex(componentStateMapper$ChildComponents.getCurrentComponentInsertionIndex() + 1);
        } else if (component instanceof LayoutComponent) {
            this.$childComponentsLevelStack.push((ComponentStateMapper$ChildComponents) this.$childrenComponents.element);
            LayoutComponent layoutComponent = (LayoutComponent) component;
            this.$childrenComponents.element = new ComponentStateMapper$ChildComponents(i, layoutComponent, 0, layoutComponent.a().size(), 4, null);
        }
        while (((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex() == ((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getTotal() && (parentLayoutComponent = ((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getParentLayoutComponent()) != null) {
            MessageComponent messageLayoutComponent = ComponentStateMapper.INSTANCE.toMessageLayoutComponent(parentLayoutComponent, ((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getLayoutComponentIndex(), k.filterNotNull(((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getComponents()), this.$componentExperiments);
            Ref$ObjectRef ref$ObjectRef = this.$childrenComponents;
            Object objPop = this.$childComponentsLevelStack.pop();
            m.checkNotNullExpressionValue(objPop, "childComponentsLevelStack.pop()");
            ref$ObjectRef.element = (ComponentStateMapper$ChildComponents) objPop;
            ((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getComponents()[((ComponentStateMapper$ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageLayoutComponent;
            ComponentStateMapper$ChildComponents componentStateMapper$ChildComponents2 = (ComponentStateMapper$ChildComponents) this.$childrenComponents.element;
            componentStateMapper$ChildComponents2.setCurrentComponentInsertionIndex(componentStateMapper$ChildComponents2.getCurrentComponentInsertionIndex() + 1);
        }
    }
}
