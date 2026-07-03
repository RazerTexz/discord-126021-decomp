package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.channels.UserAkaView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelTopicBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15961a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final UserAkaView f15962b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15963c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15964d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15965e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15966f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f15967g;

    public WidgetChannelTopicBinding(@NonNull LinearLayout linearLayout, @NonNull UserAkaView userAkaView, @NonNull LinearLayout linearLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f15961a = linearLayout;
        this.f15962b = userAkaView;
        this.f15963c = simpleDraweeView;
        this.f15964d = imageView;
        this.f15965e = imageView2;
        this.f15966f = textView;
        this.f15967g = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15961a;
    }
}
