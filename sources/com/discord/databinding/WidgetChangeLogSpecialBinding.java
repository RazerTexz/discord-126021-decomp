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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2254b;

    @NonNull
    public final ImageButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final ImageButton e;

    @NonNull
    public final TextView f;

    @NonNull
    public final NestedScrollView g;

    @NonNull
    public final SimpleDraweeView h;

    @NonNull
    public final VideoView i;

    @NonNull
    public final SimpleDraweeView j;

    @NonNull
    public final CardView k;

    public WidgetChangeLogSpecialBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageButton imageButton, @NonNull MaterialButton materialButton, @NonNull ImageButton imageButton2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull VideoView videoView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull CardView cardView, @NonNull CardView cardView2) {
        this.a = linearLayout;
        this.f2254b = linkifiedTextView;
        this.c = imageButton;
        this.d = materialButton;
        this.e = imageButton2;
        this.f = textView2;
        this.g = nestedScrollView;
        this.h = simpleDraweeView;
        this.i = videoView;
        this.j = simpleDraweeView2;
        this.k = cardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
