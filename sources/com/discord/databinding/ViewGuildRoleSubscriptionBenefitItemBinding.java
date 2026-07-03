package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionBenefitItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15460a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15461b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15462c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15463d;

    public ViewGuildRoleSubscriptionBenefitItemBinding(@NonNull View view, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.f15460a = view;
        this.f15461b = textView;
        this.f15462c = simpleDraweeView;
        this.f15463d = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewGuildRoleSubscriptionBenefitItemBinding m8396a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_guild_role_subscription_benefit_item, viewGroup);
        int i = C5419R.id.guild_role_subscription_benefit_description;
        TextView textView = (TextView) viewGroup.findViewById(C5419R.id.guild_role_subscription_benefit_description);
        if (textView != null) {
            i = C5419R.id.guild_role_subscription_benefit_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.guild_role_subscription_benefit_image);
            if (simpleDraweeView != null) {
                i = C5419R.id.guild_role_subscription_benefit_name;
                TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.guild_role_subscription_benefit_name);
                if (textView2 != null) {
                    return new ViewGuildRoleSubscriptionBenefitItemBinding(viewGroup, textView, simpleDraweeView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15460a;
    }
}
