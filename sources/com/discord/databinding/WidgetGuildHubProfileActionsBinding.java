package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildHubProfileActionsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2414b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final CardView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetGuildHubProfileActionsBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull CardView cardView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull CardView cardView2, @NonNull LinearLayout linearLayout5) {
        this.a = linearLayout;
        this.f2414b = linearLayout4;
        this.c = simpleDraweeView;
        this.d = cardView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
