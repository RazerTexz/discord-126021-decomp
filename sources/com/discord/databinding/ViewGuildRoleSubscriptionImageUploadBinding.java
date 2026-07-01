package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionImageUploadBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2195b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final TextView f;

    public ViewGuildRoleSubscriptionImageUploadBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView2) {
        this.a = view;
        this.f2195b = textView;
        this.c = imageView;
        this.d = simpleDraweeView;
        this.e = materialButton;
        this.f = textView2;
    }

    @NonNull
    public static ViewGuildRoleSubscriptionImageUploadBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R$layout.view_guild_role_subscription_image_upload, viewGroup);
        int i = R$id.guild_subscription_custom_image_title;
        TextView textView = (TextView) viewGroup.findViewById(R$id.guild_subscription_custom_image_title);
        if (textView != null) {
            i = R$id.guild_subscription_edit_image;
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.guild_subscription_edit_image);
            if (imageView != null) {
                i = R$id.guild_subscription_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(R$id.guild_subscription_image);
                if (simpleDraweeView != null) {
                    i = R$id.guild_subscription_upload_image;
                    MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(R$id.guild_subscription_upload_image);
                    if (materialButton != null) {
                        i = R$id.guild_subscription_upload_image_label;
                        TextView textView2 = (TextView) viewGroup.findViewById(R$id.guild_subscription_upload_image_label);
                        if (textView2 != null) {
                            return new ViewGuildRoleSubscriptionImageUploadBinding(viewGroup, textView, imageView, simpleDraweeView, materialButton, textView2);
                        }
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
