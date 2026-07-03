package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadBrowserItemThreadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ThreadBrowserThreadView f15310a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ThreadBrowserThreadView f15311b;

    public ThreadBrowserItemThreadBinding(@NonNull ThreadBrowserThreadView threadBrowserThreadView, @NonNull ThreadBrowserThreadView threadBrowserThreadView2) {
        this.f15310a = threadBrowserThreadView;
        this.f15311b = threadBrowserThreadView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15310a;
    }
}
