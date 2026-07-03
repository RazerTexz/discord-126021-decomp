package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C0949e5;
import p007b.p008a.p025i.C1022o5;
import p007b.p008a.p025i.C1029p5;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubEmailFlowBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17173a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1022o5 f17174b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C0949e5 f17175c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17176d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f17177e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final C1029p5 f17178f;

    public WidgetHubEmailFlowBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull C1022o5 c1022o5, @NonNull C0949e5 c0949e5, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull C1029p5 c1029p5) {
        this.f17173a = linearLayout;
        this.f17174b = c1022o5;
        this.f17175c = c0949e5;
        this.f17176d = materialButton;
        this.f17177e = loadingButton;
        this.f17178f = c1029p5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17173a;
    }
}
