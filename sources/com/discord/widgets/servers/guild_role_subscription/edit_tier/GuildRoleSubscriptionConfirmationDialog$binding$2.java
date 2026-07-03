package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildRoleSubscriptionConfirmationDialog$binding$2 extends C12236k implements Function1<View, DialogGuiildRoleSubscriptionConfirmationBinding> {
    public static final GuildRoleSubscriptionConfirmationDialog$binding$2 INSTANCE = new GuildRoleSubscriptionConfirmationDialog$binding$2();

    public GuildRoleSubscriptionConfirmationDialog$binding$2() {
        super(1, DialogGuiildRoleSubscriptionConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DialogGuiildRoleSubscriptionConfirmationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel);
        if (materialButton != null) {
            i = C5419R.id.confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm);
            if (materialButton2 != null) {
                i = C5419R.id.guild_role_subscription_confirmation_subtitle;
                TextView textView = (TextView) view.findViewById(C5419R.id.guild_role_subscription_confirmation_subtitle);
                if (textView != null) {
                    i = C5419R.id.guild_role_subscription_confirmation_title;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_role_subscription_confirmation_title);
                    if (textView2 != null) {
                        return new DialogGuiildRoleSubscriptionConfirmationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
