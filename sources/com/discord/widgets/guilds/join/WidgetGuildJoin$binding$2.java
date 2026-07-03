package com.discord.widgets.guilds.join;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildJoin$binding$2 extends C12236k implements Function1<View, WidgetGuildJoinBinding> {
    public static final WidgetGuildJoin$binding$2 INSTANCE = new WidgetGuildJoin$binding$2();

    public WidgetGuildJoin$binding$2() {
        super(1, WidgetGuildJoinBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildJoinBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_join_action_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_join_action_btn);
        if (materialButton != null) {
            i = C5419R.id.guild_join_invite;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_join_invite);
            if (textInputLayout != null) {
                return new WidgetGuildJoinBinding((CoordinatorLayout) view, materialButton, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
