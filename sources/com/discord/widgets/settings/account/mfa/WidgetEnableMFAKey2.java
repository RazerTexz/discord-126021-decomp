package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAKey2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaKeyBinding> {
    public static final WidgetEnableMFAKey2 INSTANCE = new WidgetEnableMFAKey2();

    public WidgetEnableMFAKey2() {
        super(1, WidgetSettingsEnableMfaKeyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaKeyBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.enable_mfa_key_code;
        TextView textView = (TextView) view.findViewById(R.id.enable_mfa_key_code);
        if (textView != null) {
            i = R.id.enable_mfa_key_launch_authy;
            TextView textView2 = (TextView) view.findViewById(R.id.enable_mfa_key_launch_authy);
            if (textView2 != null) {
                i = R.id.enable_mfa_key_launch_google_auth;
                TextView textView3 = (TextView) view.findViewById(R.id.enable_mfa_key_launch_google_auth);
                if (textView3 != null) {
                    return new WidgetSettingsEnableMfaKeyBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
