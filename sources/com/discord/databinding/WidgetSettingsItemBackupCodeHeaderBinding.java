package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsItemBackupCodeHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f17977a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17978b;

    public WidgetSettingsItemBackupCodeHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f17977a = textView;
        this.f17978b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17977a;
    }
}
