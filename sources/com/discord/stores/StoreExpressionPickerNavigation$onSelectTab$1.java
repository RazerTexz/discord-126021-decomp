package com.discord.stores;

import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation$onSelectTab$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ExpressionTrayTab $expressionTrayTab;
    public final /* synthetic */ StoreExpressionPickerNavigation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExpressionPickerNavigation$onSelectTab$1(StoreExpressionPickerNavigation storeExpressionPickerNavigation, ExpressionTrayTab expressionTrayTab) {
        super(0);
        this.this$0 = storeExpressionPickerNavigation;
        this.$expressionTrayTab = expressionTrayTab;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreExpressionPickerNavigation.access$setSelectedTab$p(this.this$0, this.$expressionTrayTab);
        this.this$0.markChanged();
    }
}
