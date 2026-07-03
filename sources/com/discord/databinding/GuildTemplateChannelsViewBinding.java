package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class GuildTemplateChannelsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15159a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f15160b;

    public GuildTemplateChannelsViewBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.f15159a = linearLayout;
        this.f15160b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15159a;
    }
}
