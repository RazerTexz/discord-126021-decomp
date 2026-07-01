package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildRoleSubscriptionConfirmationDialog2 extends FunctionReferenceImpl implements Function1<View, DialogGuiildRoleSubscriptionConfirmationBinding> {
    public static final GuildRoleSubscriptionConfirmationDialog2 INSTANCE = new GuildRoleSubscriptionConfirmationDialog2();

    public GuildRoleSubscriptionConfirmationDialog2() {
        super(1, DialogGuiildRoleSubscriptionConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DialogGuiildRoleSubscriptionConfirmationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel);
        if (materialButton != null) {
            i = R.id.confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm);
            if (materialButton2 != null) {
                i = R.id.guild_role_subscription_confirmation_subtitle;
                TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_confirmation_subtitle);
                if (textView != null) {
                    i = R.id.guild_role_subscription_confirmation_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_confirmation_title);
                    if (textView2 != null) {
                        return new DialogGuiildRoleSubscriptionConfirmationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
