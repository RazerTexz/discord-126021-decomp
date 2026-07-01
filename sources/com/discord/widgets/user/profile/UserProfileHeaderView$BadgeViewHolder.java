package com.discord.widgets.user.profile;

import android.widget.ImageView;
import com.discord.databinding.UserProfileHeaderBadgeBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import com.discord.widgets.user.Badge;
import d0.z.d.m;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$BadgeViewHolder extends SimpleRecyclerAdapter$ViewHolder<Badge> {
    private final UserProfileHeaderBadgeBinding binding;
    public final /* synthetic */ UserProfileHeaderView this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public UserProfileHeaderView$BadgeViewHolder(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding) {
        m.checkNotNullParameter(userProfileHeaderBadgeBinding, "binding");
        this.this$0 = userProfileHeaderView;
        ImageView imageView = userProfileHeaderBadgeBinding.a;
        m.checkNotNullExpressionValue(imageView, "binding.root");
        super(imageView);
        this.binding = userProfileHeaderBadgeBinding;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public /* bridge */ /* synthetic */ void bind(Badge badge) {
        bind2(badge);
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(Badge data) {
        m.checkNotNullParameter(data, "data");
        this.binding.f2165b.setImageResource(data.getIcon());
        ImageView imageView = this.binding.f2165b;
        m.checkNotNullExpressionValue(imageView, "binding.userSheetBadgeImage");
        CharSequence text = data.getText();
        if (text == null) {
            text = data.getTooltip();
        }
        imageView.setContentDescription(text);
        this.binding.f2165b.setOnClickListener(new UserProfileHeaderView$BadgeViewHolder$bind$1(this, data));
    }
}
