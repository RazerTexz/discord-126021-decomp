package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.View$OnClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$thumbnailControllerListener$1$onFinalImageSet$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeLog$thumbnailControllerListener$1 this$0;

    public WidgetChangeLog$thumbnailControllerListener$1$onFinalImageSet$1(WidgetChangeLog$thumbnailControllerListener$1 widgetChangeLog$thumbnailControllerListener$1) {
        this.this$0 = widgetChangeLog$thumbnailControllerListener$1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Animatable animatableC;
        WidgetChangeLog.access$hideVideoOverlay(this.this$0.this$0);
        SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0.this$0).f;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogThumbnail");
        DraweeController controller = simpleDraweeView.getController();
        if (controller == null || (animatableC = controller.c()) == null) {
            return;
        }
        animatableC.start();
    }
}
