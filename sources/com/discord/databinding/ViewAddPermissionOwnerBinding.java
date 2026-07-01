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

/* JADX INFO: loaded from: classes.dex */
public final class ViewAddPermissionOwnerBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2170b;

    public ViewAddPermissionOwnerBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2) {
        this.a = view;
        this.f2170b = textView;
    }

    @NonNull
    public static ViewAddPermissionOwnerBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R$layout.view_add_permission_owner, viewGroup);
        int i = R$id.add_icon;
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.add_icon);
        if (imageView != null) {
            i = R$id.label;
            TextView textView = (TextView) viewGroup.findViewById(R$id.label);
            if (textView != null) {
                i = R$id.more_arrow;
                ImageView imageView2 = (ImageView) viewGroup.findViewById(R$id.more_arrow);
                if (imageView2 != null) {
                    return new ViewAddPermissionOwnerBinding(viewGroup, imageView, textView, imageView2);
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
