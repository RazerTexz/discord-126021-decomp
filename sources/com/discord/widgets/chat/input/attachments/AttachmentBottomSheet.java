package com.discord.widgets.chat.input.attachments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import b.f.j.d.f;
import com.discord.R$layout;
import com.discord.R$string;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAttachmentBottomSheetBinding;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(AttachmentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", 0)};
    public static final AttachmentBottomSheet$Companion Companion = new AttachmentBottomSheet$Companion(null);
    private Attachment<? extends Object> attachment;
    private ImageInfo attachmentImageInfo;
    private Integer attachmentViewSize;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ControllerListener<ImageInfo> draweeControllerListener;
    private boolean isSpoiler;
    private Function0<Unit> onDismissed;
    private Function0<Unit> onFileRemoved;
    private Function1<? super Boolean, Unit> onMarkSpoiler;

    public AttachmentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, AttachmentBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.draweeControllerListener = new AttachmentBottomSheet$draweeControllerListener$1(this);
    }

    public static final /* synthetic */ WidgetAttachmentBottomSheetBinding access$getBinding$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onDismissed;
    }

    public static final /* synthetic */ Function0 access$getOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onFileRemoved;
    }

    public static final /* synthetic */ Function1 access$getOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onMarkSpoiler;
    }

    public static final /* synthetic */ boolean access$isSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.isSpoiler;
    }

    public static final /* synthetic */ void access$setOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onDismissed = function0;
    }

    public static final /* synthetic */ void access$setOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onFileRemoved = function0;
    }

    public static final /* synthetic */ void access$setOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, Function1 function1) {
        attachmentBottomSheet.onMarkSpoiler = function1;
    }

    public static final /* synthetic */ void access$setSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, boolean z2) {
        attachmentBottomSheet.isSpoiler = z2;
    }

    private final WidgetAttachmentBottomSheetBinding getBinding() {
        return (WidgetAttachmentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Attachment<Object> getAttachment() {
        return this.attachment;
    }

    public final ImageInfo getAttachmentImageInfo() {
        return this.attachmentImageInfo;
    }

    public final Integer getAttachmentViewSize() {
        return this.attachmentViewSize;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_attachment_bottom_sheet;
    }

    public final ControllerListener<ImageInfo> getDraweeControllerListener() {
        return this.draweeControllerListener;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public final void loadAttachment() {
        Attachment<? extends Object> attachment = this.attachment;
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment != null ? attachment.getUri() : null);
        imageRequestBuilderB.e = f.a;
        d dVarA = b.a();
        dVarA.m = true;
        SimpleDraweeView simpleDraweeView = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        dVarA.n = simpleDraweeView.getController();
        dVarA.h = imageRequestBuilderB.a();
        AbstractDraweeController abstractDraweeControllerA = dVarA.a();
        abstractDraweeControllerA.f(this.draweeControllerListener);
        SimpleDraweeView simpleDraweeView2 = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentPreview");
        simpleDraweeView2.setController(abstractDraweeControllerA);
    }

    public final void markSpoiler(boolean spoiler) {
        this.isSpoiler = spoiler;
        MaterialCheckBox materialCheckBox = getBinding().e;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.attachmentMarkSpoilerCheckbox");
        materialCheckBox.setChecked(spoiler);
        FrameLayout frameLayout = getBinding().h;
        m.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        frameLayout.setVisibility(spoiler ? 0 : 8);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.attachment = (Attachment) getArgumentsOrDefault().getParcelable("EXTRA_ATTACHMENT");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.onFileRemoved = null;
        this.onMarkSpoiler = null;
        Function0<Unit> function0 = this.onDismissed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView appCompatTextView = getBinding().c;
        m.checkNotNullExpressionValue(appCompatTextView, "binding.attachmentFilename");
        Attachment<? extends Object> attachment = this.attachment;
        appCompatTextView.setText(attachment != null ? attachment.getDisplayName() : null);
        SimpleDraweeView simpleDraweeView = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewExtensions.addOnSizeChangedListener(simpleDraweeView, new AttachmentBottomSheet$onViewCreated$1(this));
        Attachment<? extends Object> attachment2 = this.attachment;
        if (!(attachment2 instanceof Media)) {
            attachment2 = null;
        }
        Media media = (Media) attachment2;
        Long l = media != null ? media.k : null;
        MaterialTextView materialTextView = getBinding().f2227b;
        m.checkNotNullExpressionValue(materialTextView, "binding.attachmentDuration");
        materialTextView.setVisibility(l != null ? 0 : 8);
        if (l != null) {
            long jLongValue = l.longValue();
            MaterialTextView materialTextView2 = getBinding().f2227b;
            m.checkNotNullExpressionValue(materialTextView2, "binding.attachmentDuration");
            if (jLongValue > 0) {
                string = TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null);
            } else {
                Context context = getContext();
                string = context != null ? context.getString(R$string.video) : null;
            }
            materialTextView2.setText(string);
        }
        markSpoiler(this.isSpoiler);
        loadAttachment();
        getBinding().g.setOnClickListener(new AttachmentBottomSheet$onViewCreated$3(this));
        getBinding().d.setOnClickListener(new AttachmentBottomSheet$onViewCreated$4(this));
        setPeekHeightBottomView(getBinding().g);
    }

    public final void setAttachment(Attachment<? extends Object> attachment) {
        this.attachment = attachment;
    }

    public final void setAttachmentImageInfo(ImageInfo imageInfo) {
        this.attachmentImageInfo = imageInfo;
    }

    public final void setAttachmentViewSize(Integer num) {
        this.attachmentViewSize = num;
    }

    public final void updateSpoilerViewSize() {
        Integer num;
        ImageInfo imageInfo = this.attachmentImageInfo;
        if (imageInfo == null || (num = this.attachmentViewSize) == null) {
            return;
        }
        int iIntValue = num.intValue();
        int width = imageInfo.getWidth();
        int height = imageInfo.getHeight();
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Pair pairCalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, width, height, iIntValue, iIntValue, resources, 0, 32, null);
        FrameLayout frameLayout = getBinding().h;
        m.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        ViewGroup$LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).width = ((Number) pairCalculateScaledSize$default.getFirst()).intValue();
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).height = ((Number) pairCalculateScaledSize$default.getSecond()).intValue();
        frameLayout.setLayoutParams(constraintLayout$LayoutParams);
    }
}
