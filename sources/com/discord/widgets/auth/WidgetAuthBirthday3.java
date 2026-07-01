package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthBirthday3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthBirthdayBinding> {
    public static final WidgetAuthBirthday3 INSTANCE = new WidgetAuthBirthday3();

    public WidgetAuthBirthday3() {
        super(1, WidgetAuthBirthdayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthBirthdayBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_policy_links;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.auth_policy_links);
        if (linkifiedTextView != null) {
            i = R.id.auth_register_birthday;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.auth_register_birthday);
            if (textInputLayout != null) {
                i = R.id.auth_register_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_register_button);
                if (materialButton != null) {
                    i = R.id.auth_register_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auth_register_container);
                    if (linearLayout != null) {
                        i = R.id.auth_tos_opt_in;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.auth_tos_opt_in);
                        if (materialCheckBox != null) {
                            i = R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetAuthBirthdayBinding((CoordinatorLayout) view, linkifiedTextView, textInputLayout, materialButton, linearLayout, materialCheckBox, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
