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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2328b;

    @NonNull
    public final PileView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    public WidgetChatListAdapterItemPrivateChannelStartBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull PileView pileView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f2328b = textView;
        this.c = pileView;
        this.d = linearLayout2;
        this.e = textView2;
        this.f = simpleDraweeView;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
