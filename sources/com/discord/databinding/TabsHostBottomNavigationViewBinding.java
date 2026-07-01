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
import com.discord.R;
import com.discord.views.user.UserAvatarPresenceView;

/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2157b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final FrameLayout i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final FrameLayout k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final UserAvatarPresenceView m;

    @NonNull
    public final FrameLayout n;

    public TabsHostBottomNavigationViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView5, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout2, @NonNull UserAvatarPresenceView userAvatarPresenceView, @NonNull FrameLayout frameLayout4) {
        this.a = linearLayout;
        this.f2157b = imageView;
        this.c = constraintLayout;
        this.d = textView;
        this.e = imageView2;
        this.f = constraintLayout2;
        this.g = textView2;
        this.h = imageView3;
        this.i = frameLayout;
        this.j = imageView4;
        this.k = frameLayout2;
        this.l = linearLayout2;
        this.m = userAvatarPresenceView;
        this.n = frameLayout4;
    }

    @NonNull
    public static TabsHostBottomNavigationViewBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.tabs_host_bottom_navigation_view, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.tabs_host_bottom_nav_friends_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_friends_icon);
        if (imageView != null) {
            i = R.id.tabs_host_bottom_nav_friends_item;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_friends_item);
            if (constraintLayout != null) {
                i = R.id.tabs_host_bottom_nav_friends_notifications_badge;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_friends_notifications_badge);
                if (textView != null) {
                    i = R.id.tabs_host_bottom_nav_home_icon;
                    ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_home_icon);
                    if (imageView2 != null) {
                        i = R.id.tabs_host_bottom_nav_home_item;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_home_item);
                        if (constraintLayout2 != null) {
                            i = R.id.tabs_host_bottom_nav_home_notifications_badge;
                            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_home_notifications_badge);
                            if (textView2 != null) {
                                i = R.id.tabs_host_bottom_nav_mentions_icon;
                                ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_mentions_icon);
                                if (imageView3 != null) {
                                    i = R.id.tabs_host_bottom_nav_mentions_item;
                                    FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_mentions_item);
                                    if (frameLayout != null) {
                                        i = R.id.tabs_host_bottom_nav_search_icon;
                                        ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_search_icon);
                                        if (imageView4 != null) {
                                            i = R.id.tabs_host_bottom_nav_search_item;
                                            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_search_item);
                                            if (frameLayout2 != null) {
                                                i = R.id.tabs_host_bottom_nav_stage_discovery_icon;
                                                ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_stage_discovery_icon);
                                                if (imageView5 != null) {
                                                    i = R.id.tabs_host_bottom_nav_stage_discovery_item;
                                                    FrameLayout frameLayout3 = (FrameLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_stage_discovery_item);
                                                    if (frameLayout3 != null) {
                                                        i = R.id.tabs_host_bottom_nav_tabs_container;
                                                        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_tabs_container);
                                                        if (linearLayout != null) {
                                                            i = R.id.tabs_host_bottom_nav_user_avatar_presence_view;
                                                            UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(R.id.tabs_host_bottom_nav_user_avatar_presence_view);
                                                            if (userAvatarPresenceView != null) {
                                                                i = R.id.tabs_host_bottom_nav_user_settings_item;
                                                                FrameLayout frameLayout4 = (FrameLayout) viewInflate.findViewById(R.id.tabs_host_bottom_nav_user_settings_item);
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
        return this.a;
    }
}
