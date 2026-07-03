package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15486a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialRadioButton f15487b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15488c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15489d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15490e;

    public ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding(@NonNull View view, @NonNull MaterialRadioButton materialRadioButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f15486a = view;
        this.f15487b = materialRadioButton;
        this.f15488c = textView;
        this.f15489d = textView2;
        this.f15490e = imageView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding m8398a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_guild_role_subscription_plan_format_radio_button, viewGroup);
        int i = C5419R.id.guild_role_subscription_plan_format_button;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) viewGroup.findViewById(C5419R.id.guild_role_subscription_plan_format_button);
        if (materialRadioButton != null) {
            i = C5419R.id.guild_role_subscription_plan_format_button_subtitle;
            TextView textView = (TextView) viewGroup.findViewById(C5419R.id.guild_role_subscription_plan_format_button_subtitle);
            if (textView != null) {
                i = C5419R.id.guild_role_subscription_plan_format_button_title;
                TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.guild_role_subscription_plan_format_button_title);
                if (textView2 != null) {
                    i = C5419R.id.guild_role_subscription_plan_format_image;
                    ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.guild_role_subscription_plan_format_image);
                    if (imageView != null) {
                        return new ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding(viewGroup, materialRadioButton, textView, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15486a;
    }
}
