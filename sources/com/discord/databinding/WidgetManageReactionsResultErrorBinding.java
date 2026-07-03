package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetManageReactionsResultErrorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17222a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17223b;

    public WidgetManageReactionsResultErrorBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f17222a = relativeLayout;
        this.f17223b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17222a;
    }
}
