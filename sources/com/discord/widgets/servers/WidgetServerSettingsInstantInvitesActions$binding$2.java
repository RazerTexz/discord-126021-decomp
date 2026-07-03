package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsInstantInvitesActions$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsInstantInviteActionsBinding> {
    public static final WidgetServerSettingsInstantInvitesActions$binding$2 INSTANCE = new WidgetServerSettingsInstantInvitesActions$binding$2();

    public WidgetServerSettingsInstantInvitesActions$binding$2() {
        super(1, WidgetServerSettingsInstantInviteActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsInstantInviteActionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.invite_actions_copy;
        TextView textView = (TextView) view.findViewById(C5419R.id.invite_actions_copy);
        if (textView != null) {
            i = C5419R.id.invite_actions_revoke;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.invite_actions_revoke);
            if (textView2 != null) {
                i = C5419R.id.invite_actions_share;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.invite_actions_share);
                if (textView3 != null) {
                    i = C5419R.id.invite_actions_title;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.invite_actions_title);
                    if (textView4 != null) {
                        return new WidgetServerSettingsInstantInviteActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
