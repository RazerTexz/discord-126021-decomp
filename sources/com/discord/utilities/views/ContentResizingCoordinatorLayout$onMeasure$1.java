package com.discord.utilities.views;

import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.q;

/* JADX INFO: compiled from: ContentResizingCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ContentResizingCoordinatorLayout$onMeasure$1 extends q {
    public ContentResizingCoordinatorLayout$onMeasure$1(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        super(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.class, "appBarLayout", "getAppBarLayout()Lcom/google/android/material/appbar/AppBarLayout;", 0);
    }

    @Override // d0.z.d.q, kotlin.reflect.KProperty0
    public Object get() {
        return ContentResizingCoordinatorLayout.access$getAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver);
    }

    @Override // d0.z.d.q
    public void set(Object obj) {
        ContentResizingCoordinatorLayout.access$setAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver, (AppBarLayout) obj);
    }
}
