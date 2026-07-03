package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemVoiceUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16074a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16075b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16076c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f16077d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16078e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16079f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16080g;

    public WidgetChannelsListItemVoiceUserBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.f16074a = relativeLayout;
        this.f16075b = simpleDraweeView;
        this.f16076c = imageView;
        this.f16077d = imageView2;
        this.f16078e = textView;
        this.f16079f = imageView3;
        this.f16080g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16074a;
    }
}
