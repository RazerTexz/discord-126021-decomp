package com.discord.widgets.chat.input.attachments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAttachmentBottomSheetBinding;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p007b.p109f.p161j.p169d.C1885f;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(AttachmentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: AttachmentBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AttachmentBottomSheet show$default(Companion companion, FragmentManager fragmentManager, Attachment attachment, Function0 function0, Function1 function1, Function0 function2, int i, Object obj) {
            if ((i & 16) != 0) {
                function2 = null;
            }
            return companion.show(fragmentManager, attachment, function0, function1, function2);
        }

        public final AttachmentBottomSheet show(FragmentManager fragmentManager, Attachment<? extends Object> attachment, Function0<Unit> onFileRemoved, Function1<? super Boolean, Unit> onMarkSpoiler, Function0<Unit> onDismissed) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(attachment, "attachment");
            C12238m.checkNotNullParameter(onFileRemoved, "onFileRemoved");
            C12238m.checkNotNullParameter(onMarkSpoiler, "onMarkSpoiler");
            AttachmentBottomSheet attachmentBottomSheet = new AttachmentBottomSheet();
            attachmentBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("EXTRA_ATTACHMENT", attachment)));
            attachmentBottomSheet.onFileRemoved = onFileRemoved;
            attachmentBottomSheet.onMarkSpoiler = onMarkSpoiler;
            attachmentBottomSheet.onDismissed = onDismissed;
            attachmentBottomSheet.isSpoiler = attachment.getSpoiler();
            attachmentBottomSheet.show(fragmentManager, C12216a0.getOrCreateKotlinClass(AttachmentBottomSheet.class).toString());
            return attachmentBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: AttachmentBottomSheet.kt */
    public static final class C77591 extends AbstractC12240o implements Function4<Integer, Integer, Integer, Integer, Unit> {
        public C77591() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
            invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2, int i3, int i4) {
            AttachmentBottomSheet.this.setAttachmentViewSize(Integer.valueOf(i));
            AttachmentBottomSheet.this.updateSpoilerViewSize();
        }
    }

    public AttachmentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, AttachmentBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.draweeControllerListener = new ControllerListener<ImageInfo>() { // from class: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$draweeControllerListener$1
            @Override // com.facebook.drawee.controller.ControllerListener
            public void onFailure(String id2, Throwable throwable) {
            }

            @Override // com.facebook.drawee.controller.ControllerListener
            public void onIntermediateImageFailed(String id2, Throwable throwable) {
            }

            @Override // com.facebook.drawee.controller.ControllerListener
            public void onIntermediateImageSet(String id2, ImageInfo imageInfo) {
            }

            @Override // com.facebook.drawee.controller.ControllerListener
            public void onRelease(String id2) {
            }

            @Override // com.facebook.drawee.controller.ControllerListener
            public void onSubmit(String id2, Object callerContext) {
            }

            @Override // com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String id2, ImageInfo imageInfo, Animatable animatable) {
                String string;
                this.this$0.setAttachmentImageInfo(imageInfo);
                SimpleDraweeView simpleDraweeView = this.this$0.getBinding().f15662f;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
                ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                if ((imageInfo != null ? imageInfo.getWidth() : 0) > (imageInfo != null ? imageInfo.getHeight() : 0)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getWidth()) : null);
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getHeight()) : null);
                    string = sb.toString();
                } else {
                    string = "1";
                }
                layoutParams2.dimensionRatio = string;
                simpleDraweeView.setLayoutParams(layoutParams2);
                this.this$0.updateSpoilerViewSize();
            }
        };
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
        return C5419R.layout.widget_attachment_bottom_sheet;
    }

    public final ControllerListener<ImageInfo> getDraweeControllerListener() {
        return this.draweeControllerListener;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public final void loadAttachment() {
        Attachment<? extends Object> attachment = this.attachment;
        ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(attachment != null ? attachment.getUri() : null);
        imageRequestBuilderM8723b.f19616e = C1885f.f3721a;
        C1733d c1733dM1037a = C1731b.m1037a();
        c1733dM1037a.f19489m = true;
        SimpleDraweeView simpleDraweeView = getBinding().f15662f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        c1733dM1037a.f19490n = simpleDraweeView.getController();
        c1733dM1037a.f19484h = imageRequestBuilderM8723b.m8724a();
        AbstractDraweeController abstractDraweeControllerM8667a = c1733dM1037a.m8667a();
        abstractDraweeControllerM8667a.m8656f(this.draweeControllerListener);
        SimpleDraweeView simpleDraweeView2 = getBinding().f15662f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentPreview");
        simpleDraweeView2.setController(abstractDraweeControllerM8667a);
    }

    public final void markSpoiler(boolean spoiler) {
        this.isSpoiler = spoiler;
        MaterialCheckBox materialCheckBox = getBinding().f15661e;
        C12238m.checkNotNullExpressionValue(materialCheckBox, "binding.attachmentMarkSpoilerCheckbox");
        materialCheckBox.setChecked(spoiler);
        FrameLayout frameLayout = getBinding().f15664h;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        frameLayout.setVisibility(spoiler ? 0 : 8);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.attachment = (Attachment) getArgumentsOrDefault().getParcelable("EXTRA_ATTACHMENT");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView appCompatTextView = getBinding().f15659c;
        C12238m.checkNotNullExpressionValue(appCompatTextView, "binding.attachmentFilename");
        Attachment<? extends Object> attachment = this.attachment;
        appCompatTextView.setText(attachment != null ? attachment.getDisplayName() : null);
        SimpleDraweeView simpleDraweeView = getBinding().f15662f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewExtensions.addOnSizeChangedListener(simpleDraweeView, new C77591());
        Attachment<? extends Object> attachment2 = this.attachment;
        if (!(attachment2 instanceof Media)) {
            attachment2 = null;
        }
        Media media = (Media) attachment2;
        Long l = media != null ? media.f22083k : null;
        MaterialTextView materialTextView = getBinding().f15658b;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.attachmentDuration");
        materialTextView.setVisibility(l != null ? 0 : 8);
        if (l != null) {
            long jLongValue = l.longValue();
            MaterialTextView materialTextView2 = getBinding().f15658b;
            C12238m.checkNotNullExpressionValue(materialTextView2, "binding.attachmentDuration");
            if (jLongValue > 0) {
                string = TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null);
            } else {
                Context context = getContext();
                string = context != null ? context.getString(C5419R.string.video) : null;
            }
            materialTextView2.setText(string);
        }
        markSpoiler(this.isSpoiler);
        loadAttachment();
        getBinding().f15663g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function0 function0 = AttachmentBottomSheet.this.onFileRemoved;
                if (function0 != null) {
                }
                AttachmentBottomSheet.this.dismiss();
            }
        });
        getBinding().f15660d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet.onViewCreated.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                boolean z2 = !AttachmentBottomSheet.this.isSpoiler;
                AttachmentBottomSheet.this.markSpoiler(z2);
                Function1 function1 = AttachmentBottomSheet.this.onMarkSpoiler;
                if (function1 != null) {
                }
            }
        });
        setPeekHeightBottomView(getBinding().f15663g);
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
        C12238m.checkNotNullExpressionValue(resources, "resources");
        Pair pairCalculateScaledSize = embedResourceUtils.calculateScaledSize(width, height, iIntValue, iIntValue, resources, (32 & 32) != 0 ? 0 : 0);
        FrameLayout frameLayout = getBinding().f15664h;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) pairCalculateScaledSize.getFirst()).intValue();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((Number) pairCalculateScaledSize.getSecond()).intValue();
        frameLayout.setLayoutParams(layoutParams2);
    }
}
