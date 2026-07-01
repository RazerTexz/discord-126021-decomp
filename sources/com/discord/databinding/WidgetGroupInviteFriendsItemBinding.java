package com.discord.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGroupInviteFriendsItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f2407b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final SimpleDraweeSpanTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final StatusView f;

    @NonNull
    public final CheckBox g;

    public WidgetGroupInviteFriendsItemBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RelativeLayout relativeLayout2, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull CheckBox checkBox) {
        this.a = linearLayout;
        this.f2407b = relativeLayout;
        this.c = simpleDraweeView;
        this.d = simpleDraweeSpanTextView;
        this.e = textView;
        this.f = statusView;
        this.g = checkBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
