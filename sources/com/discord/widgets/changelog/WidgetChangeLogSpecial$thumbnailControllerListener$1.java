package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p109f.p132g.p139c.C1755c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$thumbnailControllerListener$1 extends C1755c<Object> {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$thumbnailControllerListener$1(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id2, Object imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        try {
            SimpleDraweeView simpleDraweeView = this.this$0.getBinding().f15829j;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
            int i = 0;
            if (!(animatable != null)) {
                i = 8;
            }
            simpleDraweeView.setVisibility(i);
            this.this$0.getBinding().f15829j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLogSpecial$thumbnailControllerListener$1$onFinalImageSet$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Animatable animatableMo8654c;
                    this.this$0.this$0.hideVideoOverlay();
                    SimpleDraweeView simpleDraweeView2 = this.this$0.this$0.getBinding().f15827h;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
                    DraweeController controller = simpleDraweeView2.getController();
                    if (controller == null || (animatableMo8654c = controller.mo8654c()) == null) {
                        return;
                    }
                    animatableMo8654c.start();
                }
            });
        } catch (Exception e) {
            Logger.e$default(AppLog.f14950g, "Failed to set changelog thumbnail image.", e, null, 4, null);
        }
    }
}
