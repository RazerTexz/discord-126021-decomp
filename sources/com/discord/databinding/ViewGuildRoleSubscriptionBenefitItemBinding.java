package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionBenefitItemBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2192b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    public ViewGuildRoleSubscriptionBenefitItemBinding(@NonNull View view, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.a = view;
        this.f2192b = textView;
        this.c = simpleDraweeView;
        this.d = textView2;
    }

    @NonNull
    public static ViewGuildRoleSubscriptionBenefitItemBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R.layout.view_guild_role_subscription_benefit_item, viewGroup);
        int i = R.id.guild_role_subscription_benefit_description;
        TextView textView = (TextView) viewGroup.findViewById(R.id.guild_role_subscription_benefit_description);
        if (textView != null) {
            i = R.id.guild_role_subscription_benefit_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(R.id.guild_role_subscription_benefit_image);
            if (simpleDraweeView != null) {
                i = R.id.guild_role_subscription_benefit_name;
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.guild_role_subscription_benefit_name);
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
        return this.a;
    }
}
