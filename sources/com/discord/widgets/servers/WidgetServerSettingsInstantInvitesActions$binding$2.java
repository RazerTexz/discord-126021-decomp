package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvitesActions$binding$2 extends k implements Function1<View, WidgetServerSettingsInstantInviteActionsBinding> {
    public static final WidgetServerSettingsInstantInvitesActions$binding$2 INSTANCE = new WidgetServerSettingsInstantInvitesActions$binding$2();

    public WidgetServerSettingsInstantInvitesActions$binding$2() {
        super(1, WidgetServerSettingsInstantInviteActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsInstantInviteActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsInstantInviteActionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.invite_actions_copy;
        TextView textView = (TextView) view.findViewById(R$id.invite_actions_copy);
        if (textView != null) {
            i = R$id.invite_actions_revoke;
            TextView textView2 = (TextView) view.findViewById(R$id.invite_actions_revoke);
            if (textView2 != null) {
                i = R$id.invite_actions_share;
                TextView textView3 = (TextView) view.findViewById(R$id.invite_actions_share);
                if (textView3 != null) {
                    i = R$id.invite_actions_title;
                    TextView textView4 = (TextView) view.findViewById(R$id.invite_actions_title);
                    if (textView4 != null) {
                        return new WidgetServerSettingsInstantInviteActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
