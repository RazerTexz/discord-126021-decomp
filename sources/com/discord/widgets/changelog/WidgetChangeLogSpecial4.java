package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import b.f.g.c.BaseControllerListener;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$thumbnailControllerListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial4 extends BaseControllerListener<Object> {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial4(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id2, Object imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        try {
            SimpleDraweeView simpleDraweeView = this.this$0.getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
            int i = 0;
            if (!(animatable != null)) {
                i = 8;
            }
            simpleDraweeView.setVisibility(i);
            this.this$0.getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLogSpecial$thumbnailControllerListener$1$onFinalImageSet$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Animatable animatableC;
                    this.this$0.this$0.hideVideoOverlay();
                    SimpleDraweeView simpleDraweeView2 = this.this$0.this$0.getBinding().h;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
                    DraweeController controller = simpleDraweeView2.getController();
                    if (controller == null || (animatableC = controller.c()) == null) {
                        return;
                    }
                    animatableC.start();
                }
            });
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Failed to set changelog thumbnail image.", e, null, 4, null);
        }
    }
}
