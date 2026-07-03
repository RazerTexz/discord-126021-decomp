package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsEnableMfaDownloadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17943a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17944b;

    public WidgetSettingsEnableMfaDownloadBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f17943a = linearLayout;
        this.f17944b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17943a;
    }
}
