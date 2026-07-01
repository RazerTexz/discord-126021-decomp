package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildInvitePageBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInvite2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildInvitePageBinding> {
    public static final WidgetGuildInvite2 INSTANCE = new WidgetGuildInvite2();

    public WidgetGuildInvite2() {
        super(1, WidgetGuildInvitePageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInvitePageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildInvitePageBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_invite_actions;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_invite_actions);
        if (linearLayout != null) {
            i = R.id.guild_invite_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_invite_cancel);
            if (materialButton != null) {
                i = R.id.guild_invite_event_info;
                GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(R.id.guild_invite_event_info);
                if (guildScheduledEventItemView != null) {
                    i = R.id.guild_invite_info;
                    WidgetInviteInfo widgetInviteInfo = (WidgetInviteInfo) view.findViewById(R.id.guild_invite_info);
                    if (widgetInviteInfo != null) {
                        i = R.id.scroll_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
                        if (nestedScrollView != null) {
                            i = R.id.toolbar;
                            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.toolbar);
                            if (appBarLayout != null) {
                                return new WidgetGuildInvitePageBinding((ConstraintLayout) view, linearLayout, materialButton, guildScheduledEventItemView, widgetInviteInfo, nestedScrollView, appBarLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
