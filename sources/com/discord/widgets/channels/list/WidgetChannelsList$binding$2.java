package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListBinding;
import com.discord.utilities.view.rounded.RoundedCoordinatorLayout;
import com.discord.views.CustomAppBarLayout;
import com.discord.widgets.friends.EmptyFriendsStateView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsList$binding$2 extends k implements Function1<View, WidgetChannelsListBinding> {
    public static final WidgetChannelsList$binding$2 INSTANCE = new WidgetChannelsList$binding$2();

    public WidgetChannelsList$binding$2() {
        super(1, WidgetChannelsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelsListBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.app_bar_layout;
        CustomAppBarLayout customAppBarLayout = (CustomAppBarLayout) view.findViewById(R$id.app_bar_layout);
        if (customAppBarLayout != null) {
            i = R$id.channels_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.channels_list);
            if (recyclerView != null) {
                i = R$id.channels_list_banner;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.channels_list_banner);
                if (simpleDraweeView != null) {
                    i = R$id.channels_list_banner_foreground;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.channels_list_banner_foreground);
                    if (frameLayout != null) {
                        i = R$id.channels_list_direct_messages_title;
                        TextView textView = (TextView) view.findViewById(R$id.channels_list_direct_messages_title);
                        if (textView != null) {
                            i = R$id.channels_list_header;
                            TextView textView2 = (TextView) view.findViewById(R$id.channels_list_header);
                            if (textView2 != null) {
                                i = R$id.channels_list_premium_guild_hint;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.channels_list_premium_guild_hint);
                                if (constraintLayout != null) {
                                    i = R$id.channels_list_premium_guild_hint_button;
                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.channels_list_premium_guild_hint_button);
                                    if (materialButton != null) {
                                        i = R$id.channels_list_premium_guild_hint_subtitle;
                                        TextView textView3 = (TextView) view.findViewById(R$id.channels_list_premium_guild_hint_subtitle);
                                        if (textView3 != null) {
                                            i = R$id.channels_list_premium_guild_hint_title;
                                            TextView textView4 = (TextView) view.findViewById(R$id.channels_list_premium_guild_hint_title);
                                            if (textView4 != null) {
                                                i = R$id.channels_list_private_channels_header;
                                                Toolbar toolbar = (Toolbar) view.findViewById(R$id.channels_list_private_channels_header);
                                                if (toolbar != null) {
                                                    i = R$id.channels_list_search;
                                                    TextView textView5 = (TextView) view.findViewById(R$id.channels_list_search);
                                                    if (textView5 != null) {
                                                        i = R$id.channels_list_start_group;
                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.channels_list_start_group);
                                                        if (appCompatImageView != null) {
                                                            i = R$id.channels_list_tooltip_background;
                                                            View viewFindViewById = view.findViewById(R$id.channels_list_tooltip_background);
                                                            if (viewFindViewById != null) {
                                                                i = R$id.channels_list_tooltip_top_tail;
                                                                View viewFindViewById2 = view.findViewById(R$id.channels_list_tooltip_top_tail);
                                                                if (viewFindViewById2 != null) {
                                                                    i = R$id.channels_list_unreads_stub;
                                                                    ViewStub viewStub = (ViewStub) view.findViewById(R$id.channels_list_unreads_stub);
                                                                    if (viewStub != null) {
                                                                        i = R$id.channels_toolbar;
                                                                        Toolbar toolbar2 = (Toolbar) view.findViewById(R$id.channels_toolbar);
                                                                        if (toolbar2 != null) {
                                                                            i = R$id.collapsing_toolbar;
                                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R$id.collapsing_toolbar);
                                                                            if (collapsingToolbarLayout != null) {
                                                                                RoundedCoordinatorLayout roundedCoordinatorLayout = (RoundedCoordinatorLayout) view;
                                                                                i = R$id.widget_channels_list_empty_friends_state_view;
                                                                                EmptyFriendsStateView emptyFriendsStateView = (EmptyFriendsStateView) view.findViewById(R$id.widget_channels_list_empty_friends_state_view);
                                                                                if (emptyFriendsStateView != null) {
                                                                                    return new WidgetChannelsListBinding(roundedCoordinatorLayout, customAppBarLayout, recyclerView, simpleDraweeView, frameLayout, textView, textView2, constraintLayout, materialButton, textView3, textView4, toolbar, textView5, appCompatImageView, viewFindViewById, viewFindViewById2, viewStub, toolbar2, collapsingToolbarLayout, roundedCoordinatorLayout, emptyFriendsStateView);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
