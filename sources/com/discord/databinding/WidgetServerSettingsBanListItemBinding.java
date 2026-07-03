package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsBanListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17530a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RelativeLayout f17531b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f17532c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17533d;

    public WidgetServerSettingsBanListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f17530a = relativeLayout;
        this.f17531b = relativeLayout2;
        this.f17532c = simpleDraweeView;
        this.f17533d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17530a;
    }
}
