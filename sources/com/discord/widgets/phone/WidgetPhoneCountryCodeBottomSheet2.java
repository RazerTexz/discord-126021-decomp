package com.discord.widgets.phone;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPhoneCountryCodeBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetPhoneCountryCodeBottomSheetBinding> {
    public static final WidgetPhoneCountryCodeBottomSheet2 INSTANCE = new WidgetPhoneCountryCodeBottomSheet2();

    public WidgetPhoneCountryCodeBottomSheet2() {
        super(1, WidgetPhoneCountryCodeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetPhoneCountryCodeBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.phone_country_code_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.phone_country_code_recycler);
        if (recyclerView != null) {
            i = R.id.phone_country_code_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.phone_country_code_search);
            if (textInputLayout != null) {
                return new WidgetPhoneCountryCodeBottomSheetBinding((LinearLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
