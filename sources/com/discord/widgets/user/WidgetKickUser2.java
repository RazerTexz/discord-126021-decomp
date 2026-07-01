package com.discord.widgets.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetKickUserBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetKickUser2 extends FunctionReferenceImpl implements Function1<View, WidgetKickUserBinding> {
    public static final WidgetKickUser2 INSTANCE = new WidgetKickUser2();

    public WidgetKickUser2() {
        super(1, WidgetKickUserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetKickUserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetKickUserBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.kick_user_body;
        TextView textView = (TextView) view.findViewById(R.id.kick_user_body);
        if (textView != null) {
            i = R.id.kick_user_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.kick_user_cancel);
            if (materialButton != null) {
                i = R.id.kick_user_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.kick_user_confirm);
                if (materialButton2 != null) {
                    i = R.id.kick_user_reason;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.kick_user_reason);
                    if (textInputLayout != null) {
                        i = R.id.kick_user_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.kick_user_title);
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
