package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.d5;
import com.discord.R$id;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryChannel$binding$2 extends k implements Function1<View, WidgetDirectoryChannelBinding> {
    public static final WidgetDirectoryChannel$binding$2 INSTANCE = new WidgetDirectoryChannel$binding$2();

    public WidgetDirectoryChannel$binding$2() {
        super(1, WidgetDirectoryChannelBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDirectoryChannelBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDirectoryChannelBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = R$id.header;
            ServerDiscoveryHeader serverDiscoveryHeader = (ServerDiscoveryHeader) view.findViewById(R$id.header);
            if (serverDiscoveryHeader != null) {
                i = R$id.tabs;
                TabLayout tabLayout = (TabLayout) view.findViewById(R$id.tabs);
                if (tabLayout != null) {
                    i = R$id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R$id.view_pager);
                    if (viewPager2 != null) {
                        i = R$id.widget_directory_channel_empty;
                        View viewFindViewById = view.findViewById(R$id.widget_directory_channel_empty);
                        if (viewFindViewById != null) {
                            int i2 = R$id.item_directory_empty_header;
                            TextView textView = (TextView) viewFindViewById.findViewById(R$id.item_directory_empty_header);
                            if (textView != null) {
                                i2 = R$id.item_directory_empty_subheader;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(R$id.item_directory_empty_subheader);
                                if (linkifiedTextView != null) {
                                    i2 = R$id.welcome_card_add_server;
                                    ChatActionItem chatActionItem = (ChatActionItem) viewFindViewById.findViewById(R$id.welcome_card_add_server);
                                    if (chatActionItem != null) {
                                        i2 = R$id.welcome_card_invite_friends;
                                        ChatActionItem chatActionItem2 = (ChatActionItem) viewFindViewById.findViewById(R$id.welcome_card_invite_friends);
                                        if (chatActionItem2 != null) {
                                            return new WidgetDirectoryChannelBinding((CoordinatorLayout) view, toolbar, serverDiscoveryHeader, tabLayout, viewPager2, new d5((LinearLayout) viewFindViewById, textView, linkifiedTextView, chatActionItem, chatActionItem2));
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
