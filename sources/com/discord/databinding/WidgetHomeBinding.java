package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.home.HomePanelsLayout;
import p007b.p008a.p025i.C0980i5;
import p007b.p008a.p025i.C1001l5;
import p007b.p008a.p025i.C1008m5;
import p007b.p008a.p025i.C1015n5;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f17124a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1008m5 f17125b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final HomePanelsLayout f17126c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C0980i5 f17127d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C1001l5 f17128e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final C1015n5 f17129f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f17130g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final FrameLayout f17131h;

    public WidgetHomeBinding(@NonNull FrameLayout frameLayout, @NonNull C1008m5 c1008m5, @NonNull HomePanelsLayout homePanelsLayout, @NonNull C0980i5 c0980i5, @NonNull C1001l5 c1001l5, @NonNull C1015n5 c1015n5, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2) {
        this.f17124a = frameLayout;
        this.f17125b = c1008m5;
        this.f17126c = homePanelsLayout;
        this.f17127d = c0980i5;
        this.f17128e = c1001l5;
        this.f17129f = c1015n5;
        this.f17130g = imageView;
        this.f17131h = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17124a;
    }
}
