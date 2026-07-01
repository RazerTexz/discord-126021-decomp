package com.discord.widgets.auth;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.a.k;
import b.a.a.k$a;
import com.discord.utilities.birthday.BirthdayHelper;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$onViewBoundOrOnResume$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetAuthBirthday this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday$onViewBoundOrOnResume$1(WidgetAuthBirthday widgetAuthBirthday) {
        super(1);
        this.this$0 = widgetAuthBirthday;
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
        String string = this.this$0.getString(2131886382);
        m.checkNotNullExpressionValue(string, "getString(R.string.age_gate_date_of_birth)");
        Long lAccess$getBirthday = WidgetAuthBirthday.access$getBirthday(this.this$0);
        k_a.a(parentFragmentManager, string, lAccess$getBirthday != null ? lAccess$getBirthday.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAuthBirthday$onViewBoundOrOnResume$1$$special$$inlined$apply$lambda$1(this);
    }
}
