package com.discord.widgets.user;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetPruneUsersBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetPruneUsers$binding$2 extends k implements Function1<View, WidgetPruneUsersBinding> {
    public static final WidgetPruneUsers$binding$2 INSTANCE = new WidgetPruneUsers$binding$2();

    public WidgetPruneUsers$binding$2() {
        super(1, WidgetPruneUsersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPruneUsersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPruneUsersBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPruneUsersBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.prune_user_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.prune_user_cancel);
        if (materialButton != null) {
            i = R$id.prune_user_header;
            TextView textView = (TextView) view.findViewById(R$id.prune_user_header);
            if (textView != null) {
                i = R$id.prune_user_prune;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.prune_user_prune);
                if (materialButton2 != null) {
                    i = R$id.prune_users_estimate_text;
                    TextView textView2 = (TextView) view.findViewById(R$id.prune_users_estimate_text);
                    if (textView2 != null) {
                        i = R$id.prune_users_history_1_radio;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.prune_users_history_1_radio);
                        if (checkedSetting != null) {
                            i = R$id.prune_users_history_2_radio;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.prune_users_history_2_radio);
                            if (checkedSetting2 != null) {
                                i = R$id.prune_users_loading_progressbar;
                                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.prune_users_loading_progressbar);
                                if (progressBar != null) {
                                    return new WidgetPruneUsersBinding((ScrollView) view, materialButton, textView, materialButton2, textView2, checkedSetting, checkedSetting2, progressBar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
