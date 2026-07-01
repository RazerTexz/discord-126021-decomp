package com.discord.widgets.phone;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPhoneCountryCodeBottomSheet$binding$2 extends k implements Function1<View, WidgetPhoneCountryCodeBottomSheetBinding> {
    public static final WidgetPhoneCountryCodeBottomSheet$binding$2 INSTANCE = new WidgetPhoneCountryCodeBottomSheet$binding$2();

    public WidgetPhoneCountryCodeBottomSheet$binding$2() {
        super(1, WidgetPhoneCountryCodeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPhoneCountryCodeBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPhoneCountryCodeBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.phone_country_code_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.phone_country_code_recycler);
        if (recyclerView != null) {
            i = R$id.phone_country_code_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.phone_country_code_search);
            if (textInputLayout != null) {
                return new WidgetPhoneCountryCodeBottomSheetBinding((LinearLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
