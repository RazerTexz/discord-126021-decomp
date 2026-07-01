package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import b.b.a.b;
import b.b.a.d.h;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaFragment$b implements SwipeRefreshLayout$OnRefreshListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3167b;
    public final /* synthetic */ MediaFragment c;
    public final /* synthetic */ b d;

    public MediaFragment$b(View view, h hVar, MediaFragment mediaFragment, b bVar) {
        this.a = view;
        this.f3167b = hVar;
        this.c = mediaFragment;
        this.d = bVar;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
    public final void onRefresh() {
        if (MediaFragment.access$hasPermissions(this.c, "android.permission.READ_EXTERNAL_STORAGE")) {
            h hVar = this.f3167b;
            Context context = this.a.getContext();
            m.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            hVar.b(contentResolver);
        }
        SwipeRefreshLayout swipeRefreshLayoutAccess$getSwipeRefreshLayout$p = MediaFragment.access$getSwipeRefreshLayout$p(this.c);
        if (swipeRefreshLayoutAccess$getSwipeRefreshLayout$p != null) {
            swipeRefreshLayoutAccess$getSwipeRefreshLayout$p.setRefreshing(false);
        }
    }
}
