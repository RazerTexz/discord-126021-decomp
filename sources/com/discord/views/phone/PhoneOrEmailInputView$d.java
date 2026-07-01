package com.discord.views.phone;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView$d extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ PhoneOrEmailInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView$d(PhoneOrEmailInputView phoneOrEmailInputView) {
        super(1);
        this.this$0 = phoneOrEmailInputView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        PhoneOrEmailInputView phoneOrEmailInputView = this.this$0;
        int i = PhoneOrEmailInputView.j;
        phoneOrEmailInputView.f();
        this.this$0.c();
        return Unit.a;
    }
}
