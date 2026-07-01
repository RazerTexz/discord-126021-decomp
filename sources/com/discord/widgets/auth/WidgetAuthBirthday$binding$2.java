package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthBirthday$binding$2 extends k implements Function1<View, WidgetAuthBirthdayBinding> {
    public static final WidgetAuthBirthday$binding$2 INSTANCE = new WidgetAuthBirthday$binding$2();

    public WidgetAuthBirthday$binding$2() {
        super(1, WidgetAuthBirthdayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthBirthdayBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthBirthdayBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_policy_links;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.auth_policy_links);
        if (linkifiedTextView != null) {
            i = R$id.auth_register_birthday;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.auth_register_birthday);
            if (textInputLayout != null) {
                i = R$id.auth_register_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_register_button);
                if (materialButton != null) {
                    i = R$id.auth_register_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.auth_register_container);
                    if (linearLayout != null) {
                        i = R$id.auth_tos_opt_in;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R$id.auth_tos_opt_in);
                        if (materialCheckBox != null) {
                            i = 2131363051;
                            DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
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
