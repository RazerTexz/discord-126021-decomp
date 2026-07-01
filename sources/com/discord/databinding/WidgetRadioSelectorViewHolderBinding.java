package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.IconRow;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRadioSelectorViewHolderBinding implements ViewBinding {

    @NonNull
    public final IconRow a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final IconRow f2518b;

    public WidgetRadioSelectorViewHolderBinding(@NonNull IconRow iconRow, @NonNull IconRow iconRow2) {
        this.a = iconRow;
        this.f2518b = iconRow2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
