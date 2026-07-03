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
import com.discord.C5419R;
import com.discord.databinding.TabsHostBottomNavigationViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.views.user.UserAvatarPresenceViewController;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$9 */
    /* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
    public static final class C101539 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $onSettingsLongPress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101539(Function0 function0) {
            super(1);
            this.$onSettingsLongPress = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            this.$onSettingsLongPress.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
    }

    private final void initialize() {
        int i;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            C12238m.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            C12238m.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        LinearLayout linearLayout = this.binding.f15305l;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i;
        LinearLayout linearLayout2 = this.binding.f15305l;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.tabsHostBottomNavTabsContainer");
        linearLayout2.setLayoutParams(layoutParams);
        ImageView imageView = this.binding.f15298e;
        NavigationTab navigationTab = NavigationTab.HOME;
        ImageView imageView2 = this.binding.f15295b;
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        ImageView imageView3 = this.binding.f15303j;
        NavigationTab navigationTab3 = NavigationTab.SEARCH;
        ImageView imageView4 = this.binding.f15301h;
        NavigationTab navigationTab4 = NavigationTab.MENTIONS;
        this.tintableIconToNavigationTabMap = C12136h0.mapOf(C12116o.m10073to(imageView, navigationTab), C12116o.m10073to(imageView2, navigationTab2), C12116o.m10073to(imageView3, navigationTab3), C12116o.m10073to(imageView4, navigationTab4));
        UserAvatarPresenceView userAvatarPresenceView = this.binding.f15306m;
        NavigationTab navigationTab5 = NavigationTab.SETTINGS;
        this.iconToNavigationTabMap = C12136h0.mapOf(C12116o.m10073to(this.binding.f15298e, navigationTab), C12116o.m10073to(this.binding.f15295b, navigationTab2), C12116o.m10073to(this.binding.f15303j, navigationTab3), C12116o.m10073to(this.binding.f15301h, navigationTab4), C12116o.m10073to(userAvatarPresenceView, navigationTab5));
        this.navigationTabToViewMap = C12136h0.mapOf(C12116o.m10073to(navigationTab, this.binding.f15299f), C12116o.m10073to(navigationTab2, this.binding.f15296c), C12116o.m10073to(navigationTab3, this.binding.f15304k), C12116o.m10073to(navigationTab4, this.binding.f15302i), C12116o.m10073to(navigationTab5, this.binding.f15307n));
        UserAvatarPresenceView userAvatarPresenceView2 = this.binding.f15306m;
        C12238m.checkNotNullExpressionValue(userAvatarPresenceView2, "binding.tabsHostBottomNavUserAvatarPresenceView");
        this.userAvatarPresenceViewController = new UserAvatarPresenceViewController(userAvatarPresenceView2, null, null, null, 14);
    }

    private final void updateNotificationBadges(int homeNotificationsCount, int friendsNotificationsCount) {
        TextView textView = this.binding.f15300g;
        C12238m.checkNotNullExpressionValue(textView, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView.setText(String.valueOf(homeNotificationsCount));
        TextView textView2 = this.binding.f15300g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView2.setVisibility(homeNotificationsCount > 0 ? 0 : 8);
        TextView textView3 = this.binding.f15300g;
        C12238m.checkNotNullExpressionValue(textView3, "binding.tabsHostBottomNavHomeNotificationsBadge");
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        textView3.setContentDescription(C1107b.m211c(resources, C5419R.string.mentions_count, new Object[]{String.valueOf(homeNotificationsCount)}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
        TextView textView4 = this.binding.f15297d;
        C12238m.checkNotNullExpressionValue(textView4, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView4.setText(String.valueOf(friendsNotificationsCount));
        TextView textView5 = this.binding.f15297d;
        C12238m.checkNotNullExpressionValue(textView5, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView5.setVisibility(friendsNotificationsCount > 0 ? 0 : 8);
        TextView textView6 = this.binding.f15297d;
        C12238m.checkNotNullExpressionValue(textView6, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        textView6.setContentDescription(C1107b.m211c(resources2, C5419R.string.incoming_friend_requests_count, new Object[]{String.valueOf(friendsNotificationsCount)}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
    }

    public final void addHeightChangedListener(HeightChangedListener heightChangedListener) {
        C12238m.checkNotNullParameter(heightChangedListener, "heightChangedListener");
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
        C12238m.checkNotNullParameter(selectedTab, "selectedTab");
        C12238m.checkNotNullParameter(onTabSelected, "onTabSelected");
        C12238m.checkNotNullParameter(visibleTabs, "visibleTabs");
        C12238m.checkNotNullParameter(onSearchClick, "onSearchClick");
        C12238m.checkNotNullParameter(onSettingsLongPress, "onSettingsLongPress");
        C12238m.checkNotNullParameter(onMentionsLongPress, "onMentionsLongPress");
        LinearLayout linearLayout = this.binding.f15305l;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        linearLayout.setWeightSum(visibleTabs.size());
        ConstraintLayout constraintLayout = this.binding.f15299f;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.tabsHostBottomNavHomeItem");
        constraintLayout.setVisibility(visibleTabs.contains(NavigationTab.HOME) ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.binding.f15296c;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.tabsHostBottomNavFriendsItem");
        constraintLayout2.setVisibility(visibleTabs.contains(NavigationTab.FRIENDS) ? 0 : 8);
        FrameLayout frameLayout = this.binding.f15304k;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.tabsHostBottomNavSearchItem");
        frameLayout.setVisibility(visibleTabs.contains(NavigationTab.SEARCH) ? 0 : 8);
        FrameLayout frameLayout2 = this.binding.f15302i;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.tabsHostBottomNavMentionsItem");
        frameLayout2.setVisibility(visibleTabs.contains(NavigationTab.MENTIONS) ? 0 : 8);
        FrameLayout frameLayout3 = this.binding.f15307n;
        C12238m.checkNotNullExpressionValue(frameLayout3, "binding.tabsHostBottomNavUserSettingsItem");
        frameLayout3.setVisibility(visibleTabs.contains(NavigationTab.SETTINGS) ? 0 : 8);
        Map<ImageView, ? extends NavigationTab> map = this.tintableIconToNavigationTabMap;
        if (map == null) {
            C12238m.throwUninitializedPropertyAccessException("tintableIconToNavigationTabMap");
        }
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ColorCompatKt.tintWithColor((ImageView) entry.getKey(), ColorCompat.getThemedColor(getContext(), ((NavigationTab) entry.getValue()) == selectedTab ? C5419R.attr.colorTabsIconActive : C5419R.attr.colorInteractiveNormal));
        }
        Map<View, ? extends NavigationTab> map2 = this.iconToNavigationTabMap;
        if (map2 == null) {
            C12238m.throwUninitializedPropertyAccessException("iconToNavigationTabMap");
        }
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            ((View) entry2.getKey()).setAlpha(selectedTab == ((NavigationTab) entry2.getValue()) ? 1.0f : 0.5f);
        }
        Map<NavigationTab, ? extends View> map3 = this.navigationTabToViewMap;
        if (map3 == null) {
            C12238m.throwUninitializedPropertyAccessException("navigationTabToViewMap");
        }
        Iterator<T> it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            ((View) entry3.getValue()).setSelected(selectedTab == ((NavigationTab) entry3.getKey()));
        }
        UserAvatarPresenceViewController userAvatarPresenceViewController = this.userAvatarPresenceViewController;
        if (userAvatarPresenceViewController == null) {
            C12238m.throwUninitializedPropertyAccessException("userAvatarPresenceViewController");
        }
        long j = userAvatarPresenceViewController.userId;
        userAvatarPresenceViewController.userId = myUserId;
        if (j != myUserId) {
            userAvatarPresenceViewController.bind();
        }
        updateNotificationBadges(homeNotificationsCount, friendsNotificationsCount);
        if (!buttonsEnabled) {
            this.binding.f15299f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.f15296c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.f15304k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.f15302i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.f15307n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.binding.f15307n.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.15
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return false;
                }
            });
            this.binding.f15302i.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.16
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return false;
                }
            });
            return;
        }
        this.binding.f15299f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.HOME);
            }
        });
        this.binding.f15296c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.FRIENDS);
            }
        });
        this.binding.f15304k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSearchClick.invoke();
            }
        });
        this.binding.f15302i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.MENTIONS);
            }
        });
        this.binding.f15307n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tabs.TabsHostBottomNavigationView.updateView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onTabSelected.invoke(NavigationTab.SETTINGS);
            }
        });
        FrameLayout frameLayout4 = this.binding.f15307n;
        C12238m.checkNotNullExpressionValue(frameLayout4, "binding.tabsHostBottomNavUserSettingsItem");
        ViewExtensions.setOnLongClickListenerConsumeClick(frameLayout4, new C101539(onSettingsLongPress));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
