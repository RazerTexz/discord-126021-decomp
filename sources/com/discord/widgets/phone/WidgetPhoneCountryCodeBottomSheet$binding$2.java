package com.discord.widgets.phone;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPhoneCountryCodeBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetPhoneCountryCodeBottomSheetBinding> {
    public static final WidgetPhoneCountryCodeBottomSheet$binding$2 INSTANCE = new WidgetPhoneCountryCodeBottomSheet$binding$2();

    public WidgetPhoneCountryCodeBottomSheet$binding$2() {
        super(1, WidgetPhoneCountryCodeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetPhoneCountryCodeBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.phone_country_code_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.phone_country_code_recycler);
        if (recyclerView != null) {
            i = C5419R.id.phone_country_code_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.phone_country_code_search);
            if (textInputLayout != null) {
                return new WidgetPhoneCountryCodeBottomSheetBinding((LinearLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
