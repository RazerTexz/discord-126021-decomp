package com.discord.widgets.user.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.discord.R$layout;
import com.discord.databinding.UserProfileHeaderBadgeBinding;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$1 extends o implements Function2<LayoutInflater, ViewGroup, UserProfileHeaderView$BadgeViewHolder> {
    public final /* synthetic */ UserProfileHeaderView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView$1(UserProfileHeaderView userProfileHeaderView) {
        super(2);
        this.this$0 = userProfileHeaderView;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final UserProfileHeaderView$BadgeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "inflater");
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R$layout.user_profile_header_badge, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        ImageView imageView = (ImageView) viewInflate;
        UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding = new UserProfileHeaderBadgeBinding(imageView, imageView);
        m.checkNotNullExpressionValue(userProfileHeaderBadgeBinding, "UserProfileHeaderBadgeBi…(inflater, parent, false)");
        return new UserProfileHeaderView$BadgeViewHolder(this.this$0, userProfileHeaderBadgeBinding);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ UserProfileHeaderView$BadgeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }
}
