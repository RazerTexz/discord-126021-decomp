package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthRegisterAccountInformationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthRegisterAccountInformation$binding$2 extends k implements Function1<View, WidgetAuthRegisterAccountInformationBinding> {
    public static final WidgetAuthRegisterAccountInformation$binding$2 INSTANCE = new WidgetAuthRegisterAccountInformation$binding$2();

    public WidgetAuthRegisterAccountInformation$binding$2() {
        super(1, WidgetAuthRegisterAccountInformationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterAccountInformationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthRegisterAccountInformationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthRegisterAccountInformationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_policy_links;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.auth_policy_links);
        if (linkifiedTextView != null) {
            i = R$id.auth_register_account_information_button;
            LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.auth_register_account_information_button);
            if (loadingButton != null) {
                i = R$id.auth_register_account_information_password_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.auth_register_account_information_password_wrap);
                if (textInputLayout != null) {
                    i = R$id.auth_register_account_information_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R$id.auth_register_account_information_username_wrap);
                    if (textInputLayout2 != null) {
                        i = R$id.auth_tos_opt_in;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R$id.auth_tos_opt_in);
                        if (materialCheckBox != null) {
                            return new WidgetAuthRegisterAccountInformationBinding((CoordinatorLayout) view, linkifiedTextView, loadingButton, textInputLayout, textInputLayout2, materialCheckBox);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
