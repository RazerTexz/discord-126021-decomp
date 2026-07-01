package com.discord.widgets.auth;

import com.discord.views.phone.PhoneOrEmailInputView$Mode;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$configureSegmentControl$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$configureSegmentControl$1(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetAuthRegisterIdentity.access$setInputMode(this.this$0, i == 0 ? PhoneOrEmailInputView$Mode.PHONE : PhoneOrEmailInputView$Mode.EMAIL);
        WidgetAuthRegisterIdentity.access$getBinding$p(this.this$0).g.setSelectedIndex(i);
    }
}
