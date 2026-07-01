package com.discord.widgets.servers.member_verification;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification2 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationBinding> {
    public static final WidgetMemberVerification2 INSTANCE = new WidgetMemberVerification2();

    public WidgetMemberVerification2() {
        super(1, WidgetMemberVerificationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetMemberVerificationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.app_bar_layout;
        CustomAppBarLayout customAppBarLayout = (CustomAppBarLayout) view.findViewById(R.id.app_bar_layout);
        if (customAppBarLayout != null) {
            i = R.id.collapsing_toolbar;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    i = R.id.member_verification_container;
                    MemberVerificationView memberVerificationView = (MemberVerificationView) view.findViewById(R.id.member_verification_container);
                    if (memberVerificationView != null) {
                        i = R.id.member_verification_guild_icon;
                        MemberVerificationAvatarView memberVerificationAvatarView = (MemberVerificationAvatarView) view.findViewById(R.id.member_verification_guild_icon);
                        if (memberVerificationAvatarView != null) {
                            i = R.id.member_verification_rules_confirm;
                            LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.member_verification_rules_confirm);
                            if (loadingButton != null) {
                                i = R.id.member_verification_rules_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.member_verification_rules_recycler);
                                if (recyclerView != null) {
                                    i = R.id.member_verification_scrollview;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.member_verification_scrollview);
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
