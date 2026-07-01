package com.discord.widgets.voice.call;

import com.discord.models.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$onViewBoundOrOnResume$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ WidgetCallFailed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFailed$onViewBoundOrOnResume$1(WidgetCallFailed widgetCallFailed) {
        super(1);
        this.this$0 = widgetCallFailed;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        WidgetCallFailed.access$configureUI(this.this$0, user);
    }
}
