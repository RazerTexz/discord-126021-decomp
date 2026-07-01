package com.discord.widgets.channels;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.WidgetGroupInviteFriendsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$binding$2 extends k implements Function1<View, WidgetGroupInviteFriendsBinding> {
    public static final WidgetGroupInviteFriends$binding$2 INSTANCE = new WidgetGroupInviteFriends$binding$2();

    public WidgetGroupInviteFriends$binding$2() {
        super(1, WidgetGroupInviteFriendsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGroupInviteFriendsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGroupInviteFriendsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGroupInviteFriendsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.group_invite_friends_chips;
        ChipsView chipsView = (ChipsView) view.findViewById(R$id.group_invite_friends_chips);
        if (chipsView != null) {
            i = R$id.group_invite_friends_recipients_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.group_invite_friends_recipients_container);
            if (relativeLayout != null) {
                i = R$id.group_invite_friends_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.group_invite_friends_recycler);
                if (recyclerView != null) {
                    i = R$id.group_invite_friends_save_fab;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.group_invite_friends_save_fab);
                    if (floatingActionButton != null) {
                        i = R$id.group_invite_friends_text_to;
                        TextView textView = (TextView) view.findViewById(R$id.group_invite_friends_text_to);
                        if (textView != null) {
                            i = R$id.group_invite_friends_view_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.group_invite_friends_view_flipper);
                            if (appViewFlipper != null) {
                                return new WidgetGroupInviteFriendsBinding((CoordinatorLayout) view, chipsView, relativeLayout, recyclerView, floatingActionButton, textView, appViewFlipper);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
