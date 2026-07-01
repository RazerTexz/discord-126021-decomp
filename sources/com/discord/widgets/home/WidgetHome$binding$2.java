package com.discord.widgets.home;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import b.a.i.i5;
import b.a.i.j5;
import b.a.i.k5;
import b.a.i.l5;
import b.a.i.m5;
import b.a.i.n5;
import com.discord.R$id;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHome$binding$2 extends k implements Function1<View, WidgetHomeBinding> {
    public static final WidgetHome$binding$2 INSTANCE = new WidgetHome$binding$2();

    public WidgetHome$binding$2() {
        super(1, WidgetHomeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHomeBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHomeBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.loading;
        View viewFindViewById = view.findViewById(R$id.loading);
        if (viewFindViewById != null) {
            ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.logo);
            if (imageView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(R$id.logo)));
            }
            m5 m5Var = new m5((FrameLayout) viewFindViewById, imageView);
            i = R$id.overlapping_panels;
            HomePanelsLayout homePanelsLayout = (HomePanelsLayout) view.findViewById(R$id.overlapping_panels);
            if (homePanelsLayout != null) {
                i = R$id.panel_center;
                View viewFindViewById2 = view.findViewById(R$id.panel_center);
                if (viewFindViewById2 != null) {
                    int i2 = R$id.widget_forum_channel_list;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) viewFindViewById2.findViewById(R$id.widget_forum_channel_list);
                    if (fragmentContainerView != null) {
                        i2 = R$id.widget_home_panel_center_chat;
                        View viewFindViewById3 = viewFindViewById2.findViewById(R$id.widget_home_panel_center_chat);
                        if (viewFindViewById3 != null) {
                            int i3 = 2131361879;
                            AppBarLayout appBarLayout = (AppBarLayout) viewFindViewById3.findViewById(2131361879);
                            if (appBarLayout != null) {
                                i3 = R$id.home_panel_center_channel_less;
                                ViewStub viewStub = (ViewStub) viewFindViewById3.findViewById(R$id.home_panel_center_channel_less);
                                if (viewStub != null) {
                                    i3 = R$id.home_panel_center_nsfw;
                                    ViewStub viewStub2 = (ViewStub) viewFindViewById3.findViewById(R$id.home_panel_center_nsfw);
                                    if (viewStub2 != null) {
                                        i3 = R$id.unread;
                                        View viewFindViewById4 = viewFindViewById3.findViewById(R$id.unread);
                                        if (viewFindViewById4 != null) {
                                            TextView textView = (TextView) viewFindViewById4;
                                            k5 k5Var = new k5(textView, textView);
                                            View viewFindViewById5 = viewFindViewById3.findViewById(R$id.widget_chat_bottom_space);
                                            if (viewFindViewById5 != null) {
                                                FragmentContainerView fragmentContainerView2 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_chat_input);
                                                if (fragmentContainerView2 != null) {
                                                    FragmentContainerView fragmentContainerView3 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_chat_list);
                                                    if (fragmentContainerView3 != null) {
                                                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_chat_overlay_actions);
                                                        if (fragmentContainerView4 != null) {
                                                            FragmentContainerView fragmentContainerView5 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_chat_voice_inline);
                                                            if (fragmentContainerView5 != null) {
                                                                FragmentContainerView fragmentContainerView6 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_forum_post_status);
                                                                if (fragmentContainerView6 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById3;
                                                                    FragmentContainerView fragmentContainerView7 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_status);
                                                                    if (fragmentContainerView7 != null) {
                                                                        FragmentContainerView fragmentContainerView8 = (FragmentContainerView) viewFindViewById3.findViewById(R$id.widget_thread_status);
                                                                        if (fragmentContainerView8 != null) {
                                                                            j5 j5Var = new j5(constraintLayout, appBarLayout, viewStub, viewStub2, k5Var, viewFindViewById5, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4, fragmentContainerView5, fragmentContainerView6, constraintLayout, fragmentContainerView7, fragmentContainerView8);
                                                                            FragmentContainerView fragmentContainerView9 = (FragmentContainerView) viewFindViewById2.findViewById(R$id.widget_home_panel_directory);
                                                                            if (fragmentContainerView9 != null) {
                                                                                i5 i5Var = new i5((RoundedRelativeLayout) viewFindViewById2, fragmentContainerView, j5Var, fragmentContainerView9);
                                                                                i = R$id.panel_left;
                                                                                View viewFindViewById6 = view.findViewById(R$id.panel_left);
                                                                                if (viewFindViewById6 != null) {
                                                                                    int i4 = R$id.guild_list_add_hint;
                                                                                    TextView textView2 = (TextView) viewFindViewById6.findViewById(R$id.guild_list_add_hint);
                                                                                    if (textView2 != null) {
                                                                                        i4 = R$id.widget_channels;
                                                                                        FragmentContainerView fragmentContainerView10 = (FragmentContainerView) viewFindViewById6.findViewById(R$id.widget_channels);
                                                                                        if (fragmentContainerView10 != null) {
                                                                                            i4 = R$id.widget_guilds;
                                                                                            FragmentContainerView fragmentContainerView11 = (FragmentContainerView) viewFindViewById6.findViewById(R$id.widget_guilds);
                                                                                            if (fragmentContainerView11 != null) {
                                                                                                i4 = R$id.widget_profile_strip;
                                                                                                FrameLayout frameLayout = (FrameLayout) viewFindViewById6.findViewById(R$id.widget_profile_strip);
                                                                                                if (frameLayout != null) {
                                                                                                    l5 l5Var = new l5((RelativeLayout) viewFindViewById6, textView2, fragmentContainerView10, fragmentContainerView11, frameLayout);
                                                                                                    View viewFindViewById7 = view.findViewById(R$id.panel_right);
                                                                                                    if (viewFindViewById7 != null) {
                                                                                                        int i5 = R$id.main_panel_right_rounded_container;
                                                                                                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) viewFindViewById7.findViewById(R$id.main_panel_right_rounded_container);
                                                                                                        if (roundedRelativeLayout != null) {
                                                                                                            i5 = R$id.widget_channel_action_bar;
                                                                                                            FragmentContainerView fragmentContainerView12 = (FragmentContainerView) viewFindViewById7.findViewById(R$id.widget_channel_action_bar);
                                                                                                            if (fragmentContainerView12 != null) {
                                                                                                                i5 = R$id.widget_channel_topic;
                                                                                                                FragmentContainerView fragmentContainerView13 = (FragmentContainerView) viewFindViewById7.findViewById(R$id.widget_channel_topic);
                                                                                                                if (fragmentContainerView13 != null) {
                                                                                                                    i5 = R$id.widget_connected_list;
                                                                                                                    FragmentContainerView fragmentContainerView14 = (FragmentContainerView) viewFindViewById7.findViewById(R$id.widget_connected_list);
                                                                                                                    if (fragmentContainerView14 != null) {
                                                                                                                        n5 n5Var = new n5((FrameLayout) viewFindViewById7, roundedRelativeLayout, fragmentContainerView12, fragmentContainerView13, fragmentContainerView14);
                                                                                                                        ImageView imageView2 = (ImageView) view.findViewById(R$id.peek_transition_bitmap);
                                                                                                                        if (imageView2 != null) {
                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) view;
                                                                                                                            return new WidgetHomeBinding(frameLayout2, m5Var, homePanelsLayout, i5Var, l5Var, n5Var, imageView2, frameLayout2);
                                                                                                                        }
                                                                                                                        i = R$id.peek_transition_bitmap;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i5)));
                                                                                                    }
                                                                                                    i = R$id.panel_right;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById6.getResources().getResourceName(i4)));
                                                                                }
                                                                            } else {
                                                                                i2 = R$id.widget_home_panel_directory;
                                                                            }
                                                                        } else {
                                                                            i3 = R$id.widget_thread_status;
                                                                        }
                                                                    } else {
                                                                        i3 = R$id.widget_status;
                                                                    }
                                                                } else {
                                                                    i3 = R$id.widget_forum_post_status;
                                                                }
                                                            } else {
                                                                i3 = R$id.widget_chat_voice_inline;
                                                            }
                                                        } else {
                                                            i3 = R$id.widget_chat_overlay_actions;
                                                        }
                                                    } else {
                                                        i3 = R$id.widget_chat_list;
                                                    }
                                                } else {
                                                    i3 = R$id.widget_chat_input;
                                                }
                                            } else {
                                                i3 = R$id.widget_chat_bottom_space;
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i3)));
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHomeBinding invoke(View view) {
        return invoke2(view);
    }
}
