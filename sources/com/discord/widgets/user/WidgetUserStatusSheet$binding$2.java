package com.discord.widgets.user;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import b.a.i.e4;
import com.discord.R$id;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserStatusSheet$binding$2 extends k implements Function1<View, WidgetUserStatusUpdateBinding> {
    public static final WidgetUserStatusSheet$binding$2 INSTANCE = new WidgetUserStatusSheet$binding$2();

    public WidgetUserStatusSheet$binding$2() {
        super(1, WidgetUserStatusUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserStatusUpdateBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusUpdateBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R$id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R$id.user_status_update_custom;
            UserStatusPresenceCustomView userStatusPresenceCustomView = (UserStatusPresenceCustomView) view.findViewById(R$id.user_status_update_custom);
            if (userStatusPresenceCustomView != null) {
                i = R$id.user_status_update_dnd;
                View viewFindViewById = view.findViewById(R$id.user_status_update_dnd);
                if (viewFindViewById != null) {
                    e4 e4VarA = e4.a(viewFindViewById);
                    i = R$id.user_status_update_idle;
                    View viewFindViewById2 = view.findViewById(R$id.user_status_update_idle);
                    if (viewFindViewById2 != null) {
                        e4 e4VarA2 = e4.a(viewFindViewById2);
                        i = R$id.user_status_update_invisible;
                        View viewFindViewById3 = view.findViewById(R$id.user_status_update_invisible);
                        if (viewFindViewById3 != null) {
                            e4 e4VarA3 = e4.a(viewFindViewById3);
                            i = R$id.user_status_update_online;
                            View viewFindViewById4 = view.findViewById(R$id.user_status_update_online);
                            if (viewFindViewById4 != null) {
                                return new WidgetUserStatusUpdateBinding((NestedScrollView) view, textView, userStatusPresenceCustomView, e4VarA, e4VarA2, e4VarA3, e4.a(viewFindViewById4));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
