package com.discord.views.phone;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView$a extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ Function0 $onAfterTextChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView$a(Function0 function0) {
        super(1);
        this.$onAfterTextChanged = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        this.$onAfterTextChanged.invoke();
        return Unit.a;
    }
}
