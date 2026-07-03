package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAKey$binding$2 extends C12236k implements Function1<View, WidgetSettingsEnableMfaKeyBinding> {
    public static final WidgetEnableMFAKey$binding$2 INSTANCE = new WidgetEnableMFAKey$binding$2();

    public WidgetEnableMFAKey$binding$2() {
        super(1, WidgetSettingsEnableMfaKeyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaKeyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.enable_mfa_key_code;
        TextView textView = (TextView) view.findViewById(C5419R.id.enable_mfa_key_code);
        if (textView != null) {
            i = C5419R.id.enable_mfa_key_launch_authy;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.enable_mfa_key_launch_authy);
            if (textView2 != null) {
                i = C5419R.id.enable_mfa_key_launch_google_auth;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.enable_mfa_key_launch_google_auth);
                if (textView3 != null) {
                    return new WidgetSettingsEnableMfaKeyBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
