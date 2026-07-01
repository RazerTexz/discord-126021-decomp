package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.directories.ServerDiscoveryItem;

/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryListItemBinding implements ViewBinding {

    @NonNull
    public final ServerDiscoveryItem a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ServerDiscoveryItem f2096b;

    public DirectoryEntryListItemBinding(@NonNull ServerDiscoveryItem serverDiscoveryItem, @NonNull ServerDiscoveryItem serverDiscoveryItem2) {
        this.a = serverDiscoveryItem;
        this.f2096b = serverDiscoveryItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
