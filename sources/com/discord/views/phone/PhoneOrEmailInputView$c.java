package com.discord.views.phone;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet;
import com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PhoneOrEmailInputView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneOrEmailInputView$c extends o implements Function1<View, Unit> {
    public final /* synthetic */ Fragment $fragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView$c(Fragment fragment) {
        super(1);
        this.$fragment = fragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetPhoneCountryCodeBottomSheet$Companion widgetPhoneCountryCodeBottomSheet$Companion = WidgetPhoneCountryCodeBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.$fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetPhoneCountryCodeBottomSheet$Companion.show(parentFragmentManager);
        return Unit.a;
    }
}
