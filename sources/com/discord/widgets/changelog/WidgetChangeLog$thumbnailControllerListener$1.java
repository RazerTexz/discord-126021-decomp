package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import b.f.g.c.c;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$thumbnailControllerListener$1 extends c<Object> {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$thumbnailControllerListener$1(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id2, Object imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        try {
            SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0).i;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
            int i = 0;
            if (!(animatable != null)) {
                i = 8;
            }
            simpleDraweeView.setVisibility(i);
            WidgetChangeLog.access$getBinding$p(this.this$0).i.setOnClickListener(new WidgetChangeLog$thumbnailControllerListener$1$onFinalImageSet$1(this));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Failed to set changelog thumbnail image.", e, null, 4, null);
        }
    }
}
