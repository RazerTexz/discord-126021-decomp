package com.discord.widgets.chat.input.attachments;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet$draweeControllerListener$1 implements ControllerListener<ImageInfo> {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    public AttachmentBottomSheet$draweeControllerListener$1(AttachmentBottomSheet attachmentBottomSheet) {
        this.this$0 = attachmentBottomSheet;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String id2, Throwable throwable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        onFinalImageSet2(str, imageInfo, animatable);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String id2, Throwable throwable) {
    }

    /* JADX INFO: renamed from: onIntermediateImageSet, reason: avoid collision after fix types in other method */
    public void onIntermediateImageSet2(String id2, ImageInfo imageInfo) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onIntermediateImageSet(String str, ImageInfo imageInfo) {
        onIntermediateImageSet2(str, imageInfo);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String id2) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String id2, Object callerContext) {
    }

    /* JADX INFO: renamed from: onFinalImageSet, reason: avoid collision after fix types in other method */
    public void onFinalImageSet2(String id2, ImageInfo imageInfo, Animatable animatable) {
        String string;
        this.this$0.setAttachmentImageInfo(imageInfo);
        SimpleDraweeView simpleDraweeView = AttachmentBottomSheet.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
        if ((imageInfo != null ? imageInfo.getWidth() : 0) > (imageInfo != null ? imageInfo.getHeight() : 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getWidth()) : null);
            sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getHeight()) : null);
            string = sb.toString();
        } else {
            string = "1";
        }
        constraintLayout$LayoutParams.dimensionRatio = string;
        simpleDraweeView.setLayoutParams(constraintLayout$LayoutParams);
        this.this$0.updateSpoilerViewSize();
    }
}
