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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final UserAkaView f2281b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final LinkifiedTextView g;

    public WidgetChannelTopicBinding(@NonNull LinearLayout linearLayout, @NonNull UserAkaView userAkaView, @NonNull LinearLayout linearLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = linearLayout;
        this.f2281b = userAkaView;
        this.c = simpleDraweeView;
        this.d = imageView;
        this.e = imageView2;
        this.f = textView;
        this.g = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
