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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18275a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f18276b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CardView f18277c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f18278d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f18279e;

    public WidgetThreadBrowserFilterSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CardView cardView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3) {
        this.f18275a = nestedScrollView;
        this.f18276b = checkedSetting;
        this.f18277c = cardView;
        this.f18278d = checkedSetting2;
        this.f18279e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18275a;
    }
}
