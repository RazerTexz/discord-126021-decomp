package com.google.android.material.badge;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeDrawable$a implements Runnable {
    public final /* synthetic */ View j;
    public final /* synthetic */ FrameLayout k;
    public final /* synthetic */ BadgeDrawable l;

    public BadgeDrawable$a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        this.l = badgeDrawable;
        this.j = view;
        this.k = frameLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l.updateBadgeCoordinates(this.j, this.k);
    }
}
