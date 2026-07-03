package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailUpdate$binding$2 extends C12236k implements Function1<View, WidgetUserEmailUpdateBinding> {
    public static final WidgetUserEmailUpdate$binding$2 INSTANCE = new WidgetUserEmailUpdate$binding$2();

    public WidgetUserEmailUpdate$binding$2() {
        super(1, WidgetUserEmailUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserEmailUpdateBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = C5419R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = C5419R.id.alert_verify_email_change_email;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.alert_verify_email_change_email);
                if (textInputLayout != null) {
                    i = C5419R.id.alert_verify_email_change_password;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.alert_verify_email_change_password);
                    if (textInputLayout2 != null) {
                        i = C5419R.id.dimmer_view;
                        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                        if (dimmerView != null) {
                            return new WidgetUserEmailUpdateBinding((RelativeLayout) view, linearLayout, materialButton, textInputLayout, textInputLayout2, dimmerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
