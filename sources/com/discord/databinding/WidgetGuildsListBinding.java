package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17092a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17093b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ViewStub f17094c;

    public WidgetGuildsListBinding(@NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull ViewStub viewStub) {
        this.f17092a = relativeLayout;
        this.f17093b = recyclerView;
        this.f17094c = viewStub;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17092a;
    }
}
