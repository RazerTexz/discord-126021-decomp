package com.discord.widgets.auth;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.a.k;
import b.a.a.k$a;
import b.a.k.b;
import com.discord.utilities.birthday.BirthdayHelper;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$configureBirthdayInput$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Long $timeOfBirth;
    public final /* synthetic */ WidgetAgeVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify$configureBirthdayInput$1(WidgetAgeVerify widgetAgeVerify, Long l) {
        super(1);
        this.this$0 = widgetAgeVerify;
        this.$timeOfBirth = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        k$a k_a = k.k;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = b.k(this.this$0, 2131886382, new Object[0], null, 4);
        Long l = this.$timeOfBirth;
        k_a.a(parentFragmentManager, charSequenceK, l != null ? l.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1(this);
    }
}
