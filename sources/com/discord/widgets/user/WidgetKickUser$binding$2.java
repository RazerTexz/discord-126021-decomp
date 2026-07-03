package com.discord.widgets.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetKickUserBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetKickUser$binding$2 extends C12236k implements Function1<View, WidgetKickUserBinding> {
    public static final WidgetKickUser$binding$2 INSTANCE = new WidgetKickUser$binding$2();

    public WidgetKickUser$binding$2() {
        super(1, WidgetKickUserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetKickUserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetKickUserBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.kick_user_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.kick_user_body);
        if (textView != null) {
            i = C5419R.id.kick_user_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.kick_user_cancel);
            if (materialButton != null) {
                i = C5419R.id.kick_user_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.kick_user_confirm);
                if (materialButton2 != null) {
                    i = C5419R.id.kick_user_reason;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.kick_user_reason);
                    if (textInputLayout != null) {
                        i = C5419R.id.kick_user_title;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.kick_user_title);
                        if (textView2 != null) {
                            return new WidgetKickUserBinding((LinearLayout) view, textView, materialButton, materialButton2, textInputLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
