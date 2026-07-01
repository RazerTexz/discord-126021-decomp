package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.e5;
import b.a.i.o5;
import b.a.i.p5;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubEmailFlowBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final o5 f2473b;

    @NonNull
    public final e5 c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final p5 f;

    public WidgetHubEmailFlowBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull o5 o5Var, @NonNull e5 e5Var, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull p5 p5Var) {
        this.a = linearLayout;
        this.f2473b = o5Var;
        this.c = e5Var;
        this.d = materialButton;
        this.e = loadingButton;
        this.f = p5Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
