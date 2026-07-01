package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthRegisterAccountInformationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthRegisterAccountInformation2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthRegisterAccountInformationBinding> {
    public static final WidgetAuthRegisterAccountInformation2 INSTANCE = new WidgetAuthRegisterAccountInformation2();

    public WidgetAuthRegisterAccountInformation2() {
        super(1, WidgetAuthRegisterAccountInformationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterAccountInformationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthRegisterAccountInformationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_policy_links;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.auth_policy_links);
        if (linkifiedTextView != null) {
            i = R.id.auth_register_account_information_button;
            LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.auth_register_account_information_button);
            if (loadingButton != null) {
                i = R.id.auth_register_account_information_password_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.auth_register_account_information_password_wrap);
                if (textInputLayout != null) {
                    i = R.id.auth_register_account_information_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.auth_register_account_information_username_wrap);
                    if (textInputLayout2 != null) {
                        i = R.id.auth_tos_opt_in;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.auth_tos_opt_in);
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
