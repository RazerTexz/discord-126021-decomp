package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountEmailEditBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEmailEditBinding> {
    public static final WidgetSettingsAccountEmailEdit2 INSTANCE = new WidgetSettingsAccountEmailEdit2();

    public WidgetSettingsAccountEmailEdit2() {
        super(1, WidgetSettingsAccountEmailEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountEmailEditBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.edit_account_email_description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.edit_account_email_description);
            if (linkifiedTextView != null) {
                i = R.id.edit_account_email_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_email_wrap);
                if (textInputLayout != null) {
                    i = R.id.settings_account_next;
                    Button button = (Button) view.findViewById(R.id.settings_account_next);
                    if (button != null) {
                        i = R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEmailEditBinding((CoordinatorLayout) view, dimmerView, linkifiedTextView, textInputLayout, button, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
