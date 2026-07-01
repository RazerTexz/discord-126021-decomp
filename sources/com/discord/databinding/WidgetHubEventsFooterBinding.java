package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubEventsFooterBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2475b;

    public WidgetHubEventsFooterBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton) {
        this.a = linearLayout;
        this.f2475b = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
