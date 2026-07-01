package com.discord.widgets.auth;

import com.discord.api.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$submit$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ WidgetAgeVerifyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerifyViewModel$submit$1(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel) {
        super(1);
        this.this$0 = widgetAgeVerifyViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "it");
        WidgetAgeVerifyViewModel.access$handleUserUpdateSuccess(this.this$0);
    }
}
