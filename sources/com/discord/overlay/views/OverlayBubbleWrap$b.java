package com.discord.overlay.views;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayBubbleWrap$b implements View$OnLayoutChangeListener {
    public final /* synthetic */ OverlayBubbleWrap j;

    public OverlayBubbleWrap$b(OverlayBubbleWrap overlayBubbleWrap) {
        this.j = overlayBubbleWrap;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        OverlayBubbleWrap overlayBubbleWrap = this.j;
        KProperty[] kPropertyArr = OverlayBubbleWrap.j;
        overlayBubbleWrap.d();
    }
}
