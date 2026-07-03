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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16780a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f16781b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f16782c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CardView f16783d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16784e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16785f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16786g;

    public WidgetGuildHubProfileActionsBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull CardView cardView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull CardView cardView2, @NonNull LinearLayout linearLayout5) {
        this.f16780a = linearLayout;
        this.f16781b = linearLayout4;
        this.f16782c = simpleDraweeView;
        this.f16783d = cardView;
        this.f16784e = textView2;
        this.f16785f = textView3;
        this.f16786g = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16780a;
    }
}
