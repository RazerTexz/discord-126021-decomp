package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.user.UserAvatarPresenceView;

/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15294a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15295b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f15296c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15297d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15298e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ConstraintLayout f15299f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15300g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f15301h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final FrameLayout f15302i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ImageView f15303j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final FrameLayout f15304k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final LinearLayout f15305l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final UserAvatarPresenceView f15306m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final FrameLayout f15307n;

    public TabsHostBottomNavigationViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView5, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout2, @NonNull UserAvatarPresenceView userAvatarPresenceView, @NonNull FrameLayout frameLayout4) {
        this.f15294a = linearLayout;
        this.f15295b = imageView;
        this.f15296c = constraintLayout;
        this.f15297d = textView;
        this.f15298e = imageView2;
        this.f15299f = constraintLayout2;
        this.f15300g = textView2;
        this.f15301h = imageView3;
        this.f15302i = frameLayout;
        this.f15303j = imageView4;
        this.f15304k = frameLayout2;
        this.f15305l = linearLayout2;
        this.f15306m = userAvatarPresenceView;
        this.f15307n = frameLayout4;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static TabsHostBottomNavigationViewBinding m8390a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.tabs_host_bottom_navigation_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.tabs_host_bottom_nav_friends_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_friends_icon);
        if (imageView != null) {
            i = C5419R.id.tabs_host_bottom_nav_friends_item;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_friends_item);
            if (constraintLayout != null) {
                i = C5419R.id.tabs_host_bottom_nav_friends_notifications_badge;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_friends_notifications_badge);
                if (textView != null) {
                    i = C5419R.id.tabs_host_bottom_nav_home_icon;
                    ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_home_icon);
                    if (imageView2 != null) {
                        i = C5419R.id.tabs_host_bottom_nav_home_item;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_home_item);
                        if (constraintLayout2 != null) {
                            i = C5419R.id.tabs_host_bottom_nav_home_notifications_badge;
                            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_home_notifications_badge);
                            if (textView2 != null) {
                                i = C5419R.id.tabs_host_bottom_nav_mentions_icon;
                                ImageView imageView3 = (ImageView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_mentions_icon);
                                if (imageView3 != null) {
                                    i = C5419R.id.tabs_host_bottom_nav_mentions_item;
                                    FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_mentions_item);
                                    if (frameLayout != null) {
                                        i = C5419R.id.tabs_host_bottom_nav_search_icon;
                                        ImageView imageView4 = (ImageView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_search_icon);
                                        if (imageView4 != null) {
                                            i = C5419R.id.tabs_host_bottom_nav_search_item;
                                            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_search_item);
                                            if (frameLayout2 != null) {
                                                i = C5419R.id.tabs_host_bottom_nav_stage_discovery_icon;
                                                ImageView imageView5 = (ImageView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_stage_discovery_icon);
                                                if (imageView5 != null) {
                                                    i = C5419R.id.tabs_host_bottom_nav_stage_discovery_item;
                                                    FrameLayout frameLayout3 = (FrameLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_stage_discovery_item);
                                                    if (frameLayout3 != null) {
                                                        i = C5419R.id.tabs_host_bottom_nav_tabs_container;
                                                        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_tabs_container);
                                                        if (linearLayout != null) {
                                                            i = C5419R.id.tabs_host_bottom_nav_user_avatar_presence_view;
                                                            UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_user_avatar_presence_view);
                                                            if (userAvatarPresenceView != null) {
                                                                i = C5419R.id.tabs_host_bottom_nav_user_settings_item;
                                                                FrameLayout frameLayout4 = (FrameLayout) viewInflate.findViewById(C5419R.id.tabs_host_bottom_nav_user_settings_item);
                                                                if (frameLayout4 != null) {
                                                                    return new TabsHostBottomNavigationViewBinding((LinearLayout) viewInflate, imageView, constraintLayout, textView, imageView2, constraintLayout2, textView2, imageView3, frameLayout, imageView4, frameLayout2, imageView5, frameLayout3, linearLayout, userAvatarPresenceView, frameLayout4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15294a;
    }
}
