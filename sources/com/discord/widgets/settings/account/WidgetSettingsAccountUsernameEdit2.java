package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountUsernameEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEditBinding> {
    public static final WidgetSettingsAccountUsernameEdit2 INSTANCE = new WidgetSettingsAccountUsernameEdit2();

    public WidgetSettingsAccountUsernameEdit2() {
        super(1, WidgetSettingsAccountEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountEditBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dtddd;
        TextView textView = (TextView) view.findViewById(R.id.dtddd);
        if (textView != null) {
            i = R.id.edit_account_discriminator_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_discriminator_wrap);
            if (textInputLayout != null) {
                i = R.id.edit_account_tag_layout_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.edit_account_tag_layout_container);
                if (relativeLayout != null) {
                    i = R.id.edit_account_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.edit_account_username_wrap);
                    if (textInputLayout2 != null) {
                        i = R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEditBinding((CoordinatorLayout) view, textView, textInputLayout, relativeLayout, textInputLayout2, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
