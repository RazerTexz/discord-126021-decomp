package com.discord.widgets.chat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUrlActionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.WidgetUrlActions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetUrlActions3 extends FunctionReferenceImpl implements Function1<View, WidgetUrlActionsBinding> {
    public static final WidgetUrlActions3 INSTANCE = new WidgetUrlActions3();

    public WidgetUrlActions3() {
        super(1, WidgetUrlActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrlActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUrlActionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dialog_url_actions_copy;
        TextView textView = (TextView) view.findViewById(R.id.dialog_url_actions_copy);
        if (textView != null) {
            i = R.id.dialog_url_actions_open;
            TextView textView2 = (TextView) view.findViewById(R.id.dialog_url_actions_open);
            if (textView2 != null) {
                i = R.id.dialog_url_actions_share;
                TextView textView3 = (TextView) view.findViewById(R.id.dialog_url_actions_share);
                if (textView3 != null) {
                    i = R.id.dialog_url_actions_url;
                    TextView textView4 = (TextView) view.findViewById(R.id.dialog_url_actions_url);
                    if (textView4 != null) {
                        return new WidgetUrlActionsBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
