package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetManageReactionsResultUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17224a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17225b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f17226c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17227d;

    public WidgetManageReactionsResultUserBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f17224a = relativeLayout;
        this.f17225b = imageView;
        this.f17226c = simpleDraweeView;
        this.f17227d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17224a;
    }
}
