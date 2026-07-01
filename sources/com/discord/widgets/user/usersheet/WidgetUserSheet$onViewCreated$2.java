package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$2 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isMe;
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$onViewCreated$2(WidgetUserSheet widgetUserSheet, boolean z2) {
        super(0);
        this.this$0 = widgetUserSheet;
        this.$isMe = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isMe) {
            this.this$0.requestMicrophone(new WidgetUserSheet$onViewCreated$2$1(this), new WidgetUserSheet$onViewCreated$2$2(this));
        } else {
            WidgetUserSheet.access$getViewModel$p(this.this$0).inviteUserToSpeak();
        }
    }
}
