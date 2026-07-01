package com.discord.widgets.chat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetUrlActionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetUrlActions$binding$2 extends k implements Function1<View, WidgetUrlActionsBinding> {
    public static final WidgetUrlActions$binding$2 INSTANCE = new WidgetUrlActions$binding$2();

    public WidgetUrlActions$binding$2() {
        super(1, WidgetUrlActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrlActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUrlActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUrlActionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.dialog_url_actions_copy;
        TextView textView = (TextView) view.findViewById(R$id.dialog_url_actions_copy);
        if (textView != null) {
            i = R$id.dialog_url_actions_open;
            TextView textView2 = (TextView) view.findViewById(R$id.dialog_url_actions_open);
            if (textView2 != null) {
                i = R$id.dialog_url_actions_share;
                TextView textView3 = (TextView) view.findViewById(R$id.dialog_url_actions_share);
                if (textView3 != null) {
                    i = R$id.dialog_url_actions_url;
                    TextView textView4 = (TextView) view.findViewById(R$id.dialog_url_actions_url);
                    if (textView4 != null) {
                        return new WidgetUrlActionsBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
