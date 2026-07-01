package com.discord.widgets.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.TabsHostBottomNavigationViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.views.user.UserAvatarPresenceViewController;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationView extends LinearLayout {
    private final TabsHostBottomNavigationViewBinding binding;
    private final Set<HeightChangedListener> heightChangedListeners;
    private Map<View, ? extends NavigationTab> iconToNavigationTabMap;
    private Map<NavigationTab, ? extends View> navigationTabToViewMap;
    private Map<ImageView, ? extends NavigationTab> tintableIconToNavigationTabMap;
    private UserAvatarPresenceViewController userAvatarPresenceViewController;

    /* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
    public interface HeightChangedListener {
        void onHeightChanged(int height);
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$9, reason: invalid class name */
    /* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
    public static final class AnonymousClass9 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $onSettingsLongPress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(Function0 function0) {
            super(1);
            this.$onSettingsLongPress = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$onSettingsLongPress.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
    }

    private final void initialize() {
        int i;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        LinearLayout linearLayout = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i;
        LinearLayout linearLayout2 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.tabsHostBottomNavTabsContainer");
        linearLayout2.setLayoutParams(layoutParams);
        ImageView imageView = this.binding.e;
        NavigationTab navigationTab = NavigationTab.HOME;
        ImageView imageView2 = this.binding.f2157b;
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        ImageView imageView3 = this.binding.j;
        NavigationTab navigationTab3 = NavigationTab.SEARCH;
        ImageView imageView4 = this.binding.h;
        NavigationTab navigationTab4 = NavigationTab.MENTIONS;
        this.tintableIconToNavigationTabMap = Maps6.mapOf(Tuples.to(imageView, navigationTab), Tuples.to(imageView2, navigationTab2), Tuples.to(imageView3, navigationTab3), Tuples.to(imageView4, navigationTab4));
        UserAvatarPresenceView userAvatarPresenceView = this.binding.m;
        NavigationTab navigationTab5 = NavigationTab.SETTINGS;
        this.iconToNavigationTabMap = Maps6.mapOf(Tuples.to(this.binding.e, navigationTab), Tuples.to(this.binding.f2157b, navigationTab2), Tuples.to(this.binding.j, navigationTab3), Tuples.to(this.binding.h, navigationTab4), Tuples.to(userAvatarPresenceView, navigationTab5));
        this.navigationTabToViewMap = Maps6.mapOf(Tuples.to(navigationTab, this.binding.f), Tuples.to(navigationTab2, this.binding.c), Tuples.to(navigationTab3, this.binding.k), Tuples.to(navigationTab4, this.binding.i), Tuples.to(navigationTab5, this.binding.n));
        UserAvatarPresenceView userAvatarPresenceView2 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(userAvatarPresenceView2, "binding.tabsHostBottomNavUserAvatarPresenceView");
        this.userAvatarPresenceViewController = new UserAvatarPresenceViewController(userAvatarPresenceView2, null, null, null, 14);
    }

    private final void updateNotificationBadges(int homeNotificationsCount, int friendsNotificationsCount) {
        TextView textView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView.setText(String.valueOf(homeNotificationsCount));
        TextView textView2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView2.setVisibility(homeNotificationsCount > 0 ? 0 : 8);
        TextView textView3 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.tabsHostBottomNavHomeNotificationsBadge");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView3.setContentDescription(FormatUtils.c(resources, R.string.mentions_count, new Object[]{String.valueOf(homeNotificationsCount)}, (4 & 4) != 0 ? FormatUtils.d.j : null));
        TextView textView4 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView4.setText(String.valueOf(friendsNotificationsCount));
        TextView textView5 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView5.setVisibility(friendsNotificationsCount > 0 ? 0 : 8);
        TextView textView6 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        textView6.setContentDescription(FormatUtils.c(resources2, R.string.incoming_friend_requests_count, new Object[]{String.valueOf(friendsNotificationsCount)}, (4 & 4) != 0 ? FormatUtils.d.j : null));
    }

    public final void addHeightChangedListener(HeightChangedListener heightChangedListener) {
        Intrinsics3.checkNotNullParameter(heightChangedListener, "heightChangedListener");
        this.heightChangedListeners.add(heightChangedListener);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Iterator<T> it = this.heightChangedListeners.iterator();
        while (it.hasNext()) {
            ((HeightChangedListener) it.next()).onHeightChanged(h);
        }
    }

    public final void updateView(NavigationTab selectedTab, final Function1<? super NavigationTab, Unit> onTabSelected, boolean buttonsEnabled, long myUserId, Set<? extends NavigationTab> visibleTabs, int homeNotificationsCount, int friendsNotificationsCount, final Function0<Unit> onSearchClick, Function0<Unit> onSettingsLongPress, Function0<Unit> onMentionsLongPress) {
        Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
        Intrinsics3.checkNotNullParameter(onTabSelected, "onTabSelected");
        Intrinsics3.checkNotNullParameter(visibleTabs, "visibleTabs");
        Intrinsics3.checkNotNullParameter(onSearchClick, "onSearchClick");
        Intrinsics3.checkNotNullParameter(onSettingsLongPress, "onSettingsLongPress");
        Intrinsics3.checkNotNullParameter(onMentionsLongPress, "onMentionsLongPress");
        LinearLayout linearLayout = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        linearLayout.setWeightSum(visibleTabs.size());
        ConstraintLayout constraintLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.tabsHostBottomNavHomeItem");
        constraintLayout.setVisibility(visibleTabs.contains(NavigationTab.HOME) ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.tabsHostBottomNavFriendsItem");
        constraintLayout2.setVisibility(visibleTabs.contains(NavigationTab.FRIENDS) ? 0 : 8);
        FrameLayout frameLayout = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.tabsHostBottomNavSearchItem");
        frameLayout.setVisibility(visibleTabs.contains(NavigationTab.SEARCH) ? 0 : 8);
        FrameLayout frameLayout2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.tabsHostBottomNavMentionsItem");
        frameLayout2.setVisibility(visibleTabs.contains(NavigationTab.MENTIONS) ? 0 : 8);
        FrameLayout frameLayout3 = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.tabsHostBottomNavUserSettingsItem");
        frameLayout3.setVisibility(visibleTabs.contains(NavigationTab.SETTINGS) ? 0 : 8);
        Map<ImageView, ? extends NavigationTab> map = this.tintableIconToNavigationTabMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("tintableIconToNavigationTabMap");
        }
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ColorCompat2.tintWithColor((ImageView) entry.getKey(), ColorCompat.getThemedColor(getContext(), ((NavigationTab) entry.getValue()) == selectedTab ? R.attr.colorTabsIconActive : R.attr.colorInteractiveNormal));
        }
        Map<View, ? extends NavigationTab> map2 = this.iconToNavigationTabMap;
        if (map2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("iconToNavigationTabMap");
        }
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            ((View) entry2.getKey()).setAlpha(selectedTab == ((NavigationTab) entry2.getValue()) ? 1.0f : 0.5f);
        }
        Map<NavigationTab, ? extends View> map3 = this.navigationTabToViewMap;
        if (map3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("navigationTabToViewMap");
        }
        Iterator<T> it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            ((View) entry3.getValue()).setSelected(selectedTab == ((NavigationTab) entry3.getKey()));
        }
        UserAvatarPresenceViewController userAvatarPresenceViewController = this.userAvatarPresenceViewController;
        if (userAvatarPresenceViewController == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userAvatarPresenceViewController");
        }
        long j = userAvatarPresenceViewController.userId;
        userAvatarPresenceViewController.userId = myUserId;
        if (j != myUserId) {
            userAvatarPresenceViewController.bind();
        }
        updateNotificationBadges(homeNotificationsCount, friendsNotificationsCount);
        if (!buttonsEnabled) {
            this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.n.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.15
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return false;
                }
            });
            this.binding.i.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.16
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return false;
                }
            });
            return;
        }
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.HOME);
            }
        });
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.FRIENDS);
            }
        });
        this.binding.k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSearchClick.invoke();
            }
        });
        this.binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.MENTIONS);
            }
        });
        this.binding.n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.SETTINGS);
            }
        });
        FrameLayout frameLayout4 = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.tabsHostBottomNavUserSettingsItem");
        ViewExtensions.setOnLongClickListenerConsumeClick(frameLayout4, new AnonymousClass9(onSettingsLongPress));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
