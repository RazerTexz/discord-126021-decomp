package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewAddPermissionOwnerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15365a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15366b;

    public ViewAddPermissionOwnerBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2) {
        this.f15365a = view;
        this.f15366b = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewAddPermissionOwnerBinding m8391a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_add_permission_owner, viewGroup);
        int i = C5419R.id.add_icon;
        ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.add_icon);
        if (imageView != null) {
            i = C5419R.id.label;
            TextView textView = (TextView) viewGroup.findViewById(C5419R.id.label);
            if (textView != null) {
                i = C5419R.id.more_arrow;
                ImageView imageView2 = (ImageView) viewGroup.findViewById(C5419R.id.more_arrow);
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
        return this.f15365a;
    }
}
