package com.discord.stores;

import com.discord.models.requiredaction.RequiredAction;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserRequiredActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRequiredActions$observeUserRequiredAction$1 extends o implements Function0<RequiredAction> {
    public final /* synthetic */ StoreUserRequiredActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserRequiredActions$observeUserRequiredAction$1(StoreUserRequiredActions storeUserRequiredActions) {
        super(0);
        this.this$0 = storeUserRequiredActions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RequiredAction invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RequiredAction invoke() {
        return StoreUserRequiredActions.access$getUserRequiredAction$p(this.this$0);
    }
}
