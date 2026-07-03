package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountUsernameEdit$binding$2 extends C12236k implements Function1<View, WidgetSettingsAccountEditBinding> {
    public static final WidgetSettingsAccountUsernameEdit$binding$2 INSTANCE = new WidgetSettingsAccountUsernameEdit$binding$2();

    public WidgetSettingsAccountUsernameEdit$binding$2() {
        super(1, WidgetSettingsAccountEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountEditBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dtddd;
        TextView textView = (TextView) view.findViewById(C5419R.id.dtddd);
        if (textView != null) {
            i = C5419R.id.edit_account_discriminator_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_discriminator_wrap);
            if (textInputLayout != null) {
                i = C5419R.id.edit_account_tag_layout_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.edit_account_tag_layout_container);
                if (relativeLayout != null) {
                    i = C5419R.id.edit_account_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.edit_account_username_wrap);
                    if (textInputLayout2 != null) {
                        i = C5419R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.settings_account_save);
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
