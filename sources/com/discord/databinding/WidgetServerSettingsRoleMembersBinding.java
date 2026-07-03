package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsRoleMembersBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17744a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f17745b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17746c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SearchInputView f17747d;

    public WidgetServerSettingsRoleMembersBinding(@NonNull LinearLayout linearLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView) {
        this.f17744a = linearLayout;
        this.f17745b = appViewFlipper;
        this.f17746c = recyclerView;
        this.f17747d = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17744a;
    }
}
