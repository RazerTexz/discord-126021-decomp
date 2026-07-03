package com.discord.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChangeLogSpecialBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15820a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f15821b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageButton f15822c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15823d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageButton f15824e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15825f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final NestedScrollView f15826g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SimpleDraweeView f15827h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final VideoView f15828i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final SimpleDraweeView f15829j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final CardView f15830k;

    public WidgetChangeLogSpecialBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageButton imageButton, @NonNull MaterialButton materialButton, @NonNull ImageButton imageButton2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull VideoView videoView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull CardView cardView, @NonNull CardView cardView2) {
        this.f15820a = linearLayout;
        this.f15821b = linkifiedTextView;
        this.f15822c = imageButton;
        this.f15823d = materialButton;
        this.f15824e = imageButton2;
        this.f15825f = textView2;
        this.f15826g = nestedScrollView;
        this.f15827h = simpleDraweeView;
        this.f15828i = videoView;
        this.f15829j = simpleDraweeView2;
        this.f15830k = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15820a;
    }
}
