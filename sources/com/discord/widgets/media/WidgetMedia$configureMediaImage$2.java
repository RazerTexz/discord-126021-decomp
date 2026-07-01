package com.discord.widgets.media;

import android.graphics.drawable.Animatable;
import b.f.g.c.c;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$configureMediaImage$2 extends c<ImageInfo> {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia$configureMediaImage$2(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFailure(String id2, Throwable throwable) {
        super.onFailure(id2, throwable);
        WidgetMedia.access$handleImageProgressComplete(this.this$0);
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String str, Object obj, Animatable animatable) {
        onFinalImageSet(str, (ImageInfo) obj, animatable);
    }

    public void onFinalImageSet(String id2, ImageInfo imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        WidgetMedia.access$handleImageProgressComplete(this.this$0);
    }
}
