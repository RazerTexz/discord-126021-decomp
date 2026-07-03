package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0941d5;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryChannel$binding$2 extends C12236k implements Function1<View, WidgetDirectoryChannelBinding> {
    public static final WidgetDirectoryChannel$binding$2 INSTANCE = new WidgetDirectoryChannel$binding$2();

    public WidgetDirectoryChannel$binding$2() {
        super(1, WidgetDirectoryChannelBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDirectoryChannelBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = C5419R.id.header;
            ServerDiscoveryHeader serverDiscoveryHeader = (ServerDiscoveryHeader) view.findViewById(C5419R.id.header);
            if (serverDiscoveryHeader != null) {
                i = C5419R.id.tabs;
                TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.tabs);
                if (tabLayout != null) {
                    i = C5419R.id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C5419R.id.view_pager);
                    if (viewPager2 != null) {
                        i = C5419R.id.widget_directory_channel_empty;
                        View viewFindViewById = view.findViewById(C5419R.id.widget_directory_channel_empty);
                        if (viewFindViewById != null) {
                            int i2 = C5419R.id.item_directory_empty_header;
                            TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.item_directory_empty_header);
                            if (textView != null) {
                                i2 = C5419R.id.item_directory_empty_subheader;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(C5419R.id.item_directory_empty_subheader);
                                if (linkifiedTextView != null) {
                                    i2 = C5419R.id.welcome_card_add_server;
                                    ChatActionItem chatActionItem = (ChatActionItem) viewFindViewById.findViewById(C5419R.id.welcome_card_add_server);
                                    if (chatActionItem != null) {
                                        i2 = C5419R.id.welcome_card_invite_friends;
                                        ChatActionItem chatActionItem2 = (ChatActionItem) viewFindViewById.findViewById(C5419R.id.welcome_card_invite_friends);
                                        if (chatActionItem2 != null) {
                                            return new WidgetDirectoryChannelBinding((CoordinatorLayout) view, toolbar, serverDiscoveryHeader, tabLayout, viewPager2, new C0941d5((LinearLayout) viewFindViewById, textView, linkifiedTextView, chatActionItem, chatActionItem2));
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
