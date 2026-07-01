package com.discord.stores;

import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation$observeSelectedTab$1 extends o implements Function0<ExpressionTrayTab> {
    public final /* synthetic */ StoreExpressionPickerNavigation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExpressionPickerNavigation$observeSelectedTab$1(StoreExpressionPickerNavigation storeExpressionPickerNavigation) {
        super(0);
        this.this$0 = storeExpressionPickerNavigation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ExpressionTrayTab invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ExpressionTrayTab invoke() {
        return StoreExpressionPickerNavigation.access$getSelectedTab$p(this.this$0);
    }
}
