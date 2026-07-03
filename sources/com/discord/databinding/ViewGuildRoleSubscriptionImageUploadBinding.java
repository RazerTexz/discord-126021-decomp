package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildRoleSubscriptionImageUploadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15477a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15478b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15479c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15480d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f15481e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15482f;

    public ViewGuildRoleSubscriptionImageUploadBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView2) {
        this.f15477a = view;
        this.f15478b = textView;
        this.f15479c = imageView;
        this.f15480d = simpleDraweeView;
        this.f15481e = materialButton;
        this.f15482f = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewGuildRoleSubscriptionImageUploadBinding m8397a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_guild_role_subscription_image_upload, viewGroup);
        int i = C5419R.id.guild_subscription_custom_image_title;
        TextView textView = (TextView) viewGroup.findViewById(C5419R.id.guild_subscription_custom_image_title);
        if (textView != null) {
            i = C5419R.id.guild_subscription_edit_image;
            ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.guild_subscription_edit_image);
            if (imageView != null) {
                i = C5419R.id.guild_subscription_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.guild_subscription_image);
                if (simpleDraweeView != null) {
                    i = C5419R.id.guild_subscription_upload_image;
                    MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(C5419R.id.guild_subscription_upload_image);
                    if (materialButton != null) {
                        i = C5419R.id.guild_subscription_upload_image_label;
                        TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.guild_subscription_upload_image_label);
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
        return this.f15477a;
    }
}
