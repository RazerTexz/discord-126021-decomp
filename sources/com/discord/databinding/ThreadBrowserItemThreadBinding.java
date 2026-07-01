package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadBrowserItemThreadBinding implements ViewBinding {

    @NonNull
    public final ThreadBrowserThreadView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ThreadBrowserThreadView f2159b;

    public ThreadBrowserItemThreadBinding(@NonNull ThreadBrowserThreadView threadBrowserThreadView, @NonNull ThreadBrowserThreadView threadBrowserThreadView2) {
        this.a = threadBrowserThreadView;
        this.f2159b = threadBrowserThreadView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
