package com.discord.utilities.stateful;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$setupUnsavedChangesConfirmation$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6923x3e7a4b1b extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6923x3e7a4b1b(StatefulViews statefulViews) {
        super(0);
        this.this$0 = statefulViews;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.hasAnythingChanged();
    }
}
