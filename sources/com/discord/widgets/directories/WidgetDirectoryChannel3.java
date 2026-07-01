package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.WidgetDirectoryChannelEmptyBinding;
import com.discord.R;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryChannel3 extends FunctionReferenceImpl implements Function1<View, WidgetDirectoryChannelBinding> {
    public static final WidgetDirectoryChannel3 INSTANCE = new WidgetDirectoryChannel3();

    public WidgetDirectoryChannel3() {
        super(1, WidgetDirectoryChannelBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDirectoryChannelBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.header;
            ServerDiscoveryHeader serverDiscoveryHeader = (ServerDiscoveryHeader) view.findViewById(R.id.header);
            if (serverDiscoveryHeader != null) {
                i = R.id.tabs;
                TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
                if (tabLayout != null) {
                    i = R.id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager);
                    if (viewPager2 != null) {
                        i = R.id.widget_directory_channel_empty;
                        View viewFindViewById = view.findViewById(R.id.widget_directory_channel_empty);
                        if (viewFindViewById != null) {
                            int i2 = R.id.item_directory_empty_header;
                            TextView textView = (TextView) viewFindViewById.findViewById(R.id.item_directory_empty_header);
                            if (textView != null) {
                                i2 = R.id.item_directory_empty_subheader;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(R.id.item_directory_empty_subheader);
                                if (linkifiedTextView != null) {
                                    i2 = R.id.welcome_card_add_server;
                                    ChatActionItem chatActionItem = (ChatActionItem) viewFindViewById.findViewById(R.id.welcome_card_add_server);
                                    if (chatActionItem != null) {
                                        i2 = R.id.welcome_card_invite_friends;
                                        ChatActionItem chatActionItem2 = (ChatActionItem) viewFindViewById.findViewById(R.id.welcome_card_invite_friends);
                                        if (chatActionItem2 != null) {
                                            return new WidgetDirectoryChannelBinding((CoordinatorLayout) view, toolbar, serverDiscoveryHeader, tabLayout, viewPager2, new WidgetDirectoryChannelEmptyBinding((LinearLayout) viewFindViewById, textView, linkifiedTextView, chatActionItem, chatActionItem2));
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
