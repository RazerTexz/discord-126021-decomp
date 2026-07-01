package com.discord.widgets.guilds.join;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildJoin$binding$2 extends k implements Function1<View, WidgetGuildJoinBinding> {
    public static final WidgetGuildJoin$binding$2 INSTANCE = new WidgetGuildJoin$binding$2();

    public WidgetGuildJoin$binding$2() {
        super(1, WidgetGuildJoinBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildJoinBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildJoinBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_join_action_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_join_action_btn);
        if (materialButton != null) {
            i = R$id.guild_join_invite;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_join_invite);
            if (textInputLayout != null) {
                return new WidgetGuildJoinBinding((CoordinatorLayout) view, materialButton, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
