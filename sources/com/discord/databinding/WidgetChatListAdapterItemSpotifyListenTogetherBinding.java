package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogetherBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16274a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16275b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16276c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f16277d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16278e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RecyclerView f16279f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16280g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f16281h;

    public WidgetChatListAdapterItemSpotifyListenTogetherBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f16274a = constraintLayout;
        this.f16275b = simpleDraweeView;
        this.f16276c = textView;
        this.f16277d = constraintLayout2;
        this.f16278e = textView2;
        this.f16279f = recyclerView;
        this.f16280g = textView4;
        this.f16281h = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16274a;
    }
}
