package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialRadioButton f2197b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    public ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding(@NonNull View view, @NonNull MaterialRadioButton materialRadioButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = view;
        this.f2197b = materialRadioButton;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
    }

    @NonNull
    public static ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R.layout.view_guild_role_subscription_plan_format_radio_button, viewGroup);
        int i = R.id.guild_role_subscription_plan_format_button;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) viewGroup.findViewById(R.id.guild_role_subscription_plan_format_button);
        if (materialRadioButton != null) {
            i = R.id.guild_role_subscription_plan_format_button_subtitle;
            TextView textView = (TextView) viewGroup.findViewById(R.id.guild_role_subscription_plan_format_button_subtitle);
            if (textView != null) {
                i = R.id.guild_role_subscription_plan_format_button_title;
                TextView textView2 = (TextView) viewGroup.findViewById(R.id.guild_role_subscription_plan_format_button_title);
                if (textView2 != null) {
                    i = R.id.guild_role_subscription_plan_format_image;
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.guild_role_subscription_plan_format_image);
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
        return this.a;
    }
}
