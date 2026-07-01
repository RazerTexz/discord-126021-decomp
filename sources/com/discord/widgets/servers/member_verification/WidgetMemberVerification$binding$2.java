package com.discord.widgets.servers.member_verification;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification$binding$2 extends k implements Function1<View, WidgetMemberVerificationBinding> {
    public static final WidgetMemberVerification$binding$2 INSTANCE = new WidgetMemberVerification$binding$2();

    public WidgetMemberVerification$binding$2() {
        super(1, WidgetMemberVerificationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.app_bar_layout;
        CustomAppBarLayout customAppBarLayout = (CustomAppBarLayout) view.findViewById(R$id.app_bar_layout);
        if (customAppBarLayout != null) {
            i = R$id.collapsing_toolbar;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R$id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                i = 2131363051;
                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                if (dimmerView != null) {
                    i = R$id.member_verification_container;
                    MemberVerificationView memberVerificationView = (MemberVerificationView) view.findViewById(R$id.member_verification_container);
                    if (memberVerificationView != null) {
                        i = R$id.member_verification_guild_icon;
                        MemberVerificationAvatarView memberVerificationAvatarView = (MemberVerificationAvatarView) view.findViewById(R$id.member_verification_guild_icon);
                        if (memberVerificationAvatarView != null) {
                            i = R$id.member_verification_rules_confirm;
                            LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.member_verification_rules_confirm);
                            if (loadingButton != null) {
                                i = R$id.member_verification_rules_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.member_verification_rules_recycler);
                                if (recyclerView != null) {
                                    i = R$id.member_verification_scrollview;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.member_verification_scrollview);
                                    if (nestedScrollView != null) {
                                        return new WidgetMemberVerificationBinding((CoordinatorLayout) view, customAppBarLayout, collapsingToolbarLayout, dimmerView, memberVerificationView, memberVerificationAvatarView, loadingButton, recyclerView, nestedScrollView);
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
