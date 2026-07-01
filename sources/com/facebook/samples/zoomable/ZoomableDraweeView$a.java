package com.facebook.samples.zoomable;

import android.graphics.drawable.Animatable;
import androidx.annotation.Nullable;
import b.f.d.e.a;
import b.f.g.c.c;

/* JADX INFO: loaded from: classes3.dex */
public class ZoomableDraweeView$a extends c<Object> {
    public final /* synthetic */ ZoomableDraweeView a;

    public ZoomableDraweeView$a(ZoomableDraweeView zoomableDraweeView) {
        this.a = zoomableDraweeView;
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        ZoomableDraweeView zoomableDraweeView = this.a;
        Class<?> cls = ZoomableDraweeView.j;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = a.a;
        if (((b.f.l.b.c) zoomableDraweeView.o).c) {
            return;
        }
        zoomableDraweeView.b();
        ((b.f.l.b.c) zoomableDraweeView.o).k(true);
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
        ZoomableDraweeView zoomableDraweeView = this.a;
        Class<?> cls = ZoomableDraweeView.j;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = a.a;
        ((b.f.l.b.c) zoomableDraweeView.o).k(false);
    }
}
