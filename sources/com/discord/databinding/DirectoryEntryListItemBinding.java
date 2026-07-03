package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.directories.ServerDiscoveryItem;

/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ServerDiscoveryItem f15042a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ServerDiscoveryItem f15043b;

    public DirectoryEntryListItemBinding(@NonNull ServerDiscoveryItem serverDiscoveryItem, @NonNull ServerDiscoveryItem serverDiscoveryItem2) {
        this.f15042a = serverDiscoveryItem;
        this.f15043b = serverDiscoveryItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15042a;
    }
}
