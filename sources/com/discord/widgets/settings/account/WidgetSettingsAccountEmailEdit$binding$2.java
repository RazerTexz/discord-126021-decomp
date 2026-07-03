package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountEmailEditBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEdit$binding$2 extends C12236k implements Function1<View, WidgetSettingsAccountEmailEditBinding> {
    public static final WidgetSettingsAccountEmailEdit$binding$2 INSTANCE = new WidgetSettingsAccountEmailEdit$binding$2();

    public WidgetSettingsAccountEmailEdit$binding$2() {
        super(1, WidgetSettingsAccountEmailEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountEmailEditBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.edit_account_email_description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.edit_account_email_description);
            if (linkifiedTextView != null) {
                i = C5419R.id.edit_account_email_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_email_wrap);
                if (textInputLayout != null) {
                    i = C5419R.id.settings_account_next;
                    Button button = (Button) view.findViewById(C5419R.id.settings_account_next);
                    if (button != null) {
                        i = C5419R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.settings_account_save);
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
