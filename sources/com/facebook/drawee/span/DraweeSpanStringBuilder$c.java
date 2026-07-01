package com.facebook.drawee.span;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import b.f.g.c.c;
import b.f.g.i.a;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DraweeSpanStringBuilder$c extends c<ImageInfo> {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2891b;
    public final int c;
    public final /* synthetic */ DraweeSpanStringBuilder d;

    public DraweeSpanStringBuilder$c(DraweeSpanStringBuilder draweeSpanStringBuilder, a aVar, boolean z2, int i) {
        this.d = draweeSpanStringBuilder;
        this.a = aVar;
        this.f2891b = z2;
        this.c = i;
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        ImageInfo imageInfo = (ImageInfo) obj;
        if (!this.f2891b || imageInfo == null || this.a.p.d() == null) {
            return;
        }
        Drawable drawableD = this.a.p.d();
        Rect bounds = drawableD.getBounds();
        int i = this.c;
        if (i == -1) {
            if (bounds.width() == imageInfo.getWidth() && bounds.height() == imageInfo.getHeight()) {
                return;
            }
            drawableD.setBounds(0, 0, imageInfo.getWidth(), imageInfo.getHeight());
            DraweeSpanStringBuilder draweeSpanStringBuilder = this.d;
            int i2 = DraweeSpanStringBuilder.j;
            Objects.requireNonNull(draweeSpanStringBuilder);
            return;
        }
        int height = (int) ((i / imageInfo.getHeight()) * imageInfo.getWidth());
        if (bounds.width() == height && bounds.height() == this.c) {
            return;
        }
        drawableD.setBounds(0, 0, height, this.c);
        DraweeSpanStringBuilder draweeSpanStringBuilder2 = this.d;
        int i3 = DraweeSpanStringBuilder.j;
        Objects.requireNonNull(draweeSpanStringBuilder2);
    }
}
