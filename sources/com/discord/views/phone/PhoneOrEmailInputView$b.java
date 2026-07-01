package com.discord.views.phone;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView$b extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ Function0 $onAfterTextChanged;
    public final /* synthetic */ PhoneOrEmailInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView$b(PhoneOrEmailInputView phoneOrEmailInputView, Function0 function0) {
        super(1);
        this.this$0 = phoneOrEmailInputView;
        this.$onAfterTextChanged = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        PhoneOrEmailInputView phoneOrEmailInputView = this.this$0;
        int i = PhoneOrEmailInputView.j;
        phoneOrEmailInputView.c();
        this.$onAfterTextChanged.invoke();
        return Unit.a;
    }
}
