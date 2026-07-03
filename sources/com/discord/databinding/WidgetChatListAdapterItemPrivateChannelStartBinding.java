package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemPrivateChannelStartBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16261a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16262b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final PileView f16263c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinearLayout f16264d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16265e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f16266f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16267g;

    public WidgetChatListAdapterItemPrivateChannelStartBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull PileView pileView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3) {
        this.f16261a = linearLayout;
        this.f16262b = textView;
        this.f16263c = pileView;
        this.f16264d = linearLayout2;
        this.f16265e = textView2;
        this.f16266f = simpleDraweeView;
        this.f16267g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16261a;
    }
}
