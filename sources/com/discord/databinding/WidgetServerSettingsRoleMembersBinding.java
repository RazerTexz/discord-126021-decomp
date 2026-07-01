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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2584b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final SearchInputView d;

    public WidgetServerSettingsRoleMembersBinding(@NonNull LinearLayout linearLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView) {
        this.a = linearLayout;
        this.f2584b = appViewFlipper;
        this.c = recyclerView;
        this.d = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
