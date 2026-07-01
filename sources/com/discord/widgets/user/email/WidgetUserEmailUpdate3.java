package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailUpdate3 extends FunctionReferenceImpl implements Function1<View, WidgetUserEmailUpdateBinding> {
    public static final WidgetUserEmailUpdate3 INSTANCE = new WidgetUserEmailUpdate3();

    public WidgetUserEmailUpdate3() {
        super(1, WidgetUserEmailUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserEmailUpdateBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = R.id.alert_verify_email_change_email;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_email);
                if (textInputLayout != null) {
                    i = R.id.alert_verify_email_change_password;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_password);
                    if (textInputLayout2 != null) {
                        i = R.id.dimmer_view;
                        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
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
