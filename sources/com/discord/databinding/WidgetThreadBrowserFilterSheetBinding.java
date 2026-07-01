package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserFilterSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2671b;

    @NonNull
    public final CardView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    public WidgetThreadBrowserFilterSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CardView cardView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3) {
        this.a = nestedScrollView;
        this.f2671b = checkedSetting;
        this.c = cardView;
        this.d = checkedSetting2;
        this.e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
