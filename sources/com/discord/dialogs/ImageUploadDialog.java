package com.discord.dialogs;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.media_picker.MediaPicker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0920b0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ImageUploadDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageUploadDialog extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f18491j = {C1643a.m846d0(ImageUploadDialog.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Uri uri;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public MediaPicker.Provider provider;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public String mimeType;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Action1<String> cropResultCallBack;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public PreviewType previewType;

    /* JADX INFO: compiled from: ImageUploadDialog.kt */
    public enum PreviewType {
        EMOJI(C5419R.dimen.emoji_size),
        USER_AVATAR(C5419R.dimen.avatar_size_extra_large_account),
        GUILD_AVATAR(C5419R.dimen.avatar_size_xxlarge),
        GUILD_SUBSCRIPTION_ROLE_AVATAR(C5419R.dimen.avatar_size_huge);

        private final int previewSizeDimenId;

        PreviewType(int i) {
            this.previewSizeDimenId = i;
        }

        public final int getPreviewSizeDimenId() {
            return this.previewSizeDimenId;
        }
    }

    /* JADX INFO: renamed from: com.discord.dialogs.ImageUploadDialog$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class ViewOnClickListenerC5475a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f18499j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f18500k;

        public ViewOnClickListenerC5475a(int i, Object obj) {
            this.f18499j = i;
            this.f18500k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f18499j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((ImageUploadDialog) this.f18500k).dismiss();
                return;
            }
            Context context = ((ImageUploadDialog) this.f18500k).getContext();
            MediaPicker.Provider provider = ((ImageUploadDialog) this.f18500k).provider;
            if (provider == null) {
                C12238m.throwUninitializedPropertyAccessException("provider");
            }
            Uri uri = ((ImageUploadDialog) this.f18500k).uri;
            if (uri == null) {
                C12238m.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestImageCrop(context, provider, uri, (56 & 8) != 0 ? 1.0f : 0.0f, (56 & 16) != 0 ? 1.0f : 0.0f, (56 & 32) != 0 ? 1024 : 0);
            ((ImageUploadDialog) this.f18500k).dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.dialogs.ImageUploadDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ImageUploadDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: com.discord.dialogs.ImageUploadDialog$c */
    /* JADX INFO: compiled from: ImageUploadDialog.kt */
    public static final /* synthetic */ class C5477c extends C12236k implements Function1<View, C0920b0> {

        /* JADX INFO: renamed from: j */
        public static final C5477c f18501j = new C5477c();

        public C5477c() {
            super(1, C0920b0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0920b0 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.notice_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.notice_cancel);
            if (materialButton != null) {
                i = C5419R.id.notice_crop;
                TextView textView = (TextView) view2.findViewById(C5419R.id.notice_crop);
                if (textView != null) {
                    i = C5419R.id.notice_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(C5419R.id.notice_image);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.notice_upload;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.notice_upload);
                        if (materialButton2 != null) {
                            return new C0920b0((LinearLayout) view2, materialButton, textView, simpleDraweeView, materialButton2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: com.discord.dialogs.ImageUploadDialog$d */
    /* JADX INFO: compiled from: ImageUploadDialog.kt */
    public static final class ViewOnClickListenerC5478d implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ String f18503k;

        public ViewOnClickListenerC5478d(String str) {
            this.f18503k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = ImageUploadDialog.this.getContext();
            Uri uri = ImageUploadDialog.this.uri;
            if (uri == null) {
                C12238m.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestDataUrl(context, uri, this.f18503k, ImageUploadDialog.this.cropResultCallBack);
            ImageUploadDialog.this.dismiss();
        }
    }

    public ImageUploadDialog() {
        super(C5419R.layout.image_upload_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, C5477c.f18501j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0920b0 m8421g() {
        return (C0920b0) this.binding.getValue((Fragment) this, f18491j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        PreviewType previewType = this.previewType;
        String str = this.mimeType;
        if (previewType == null || str == null) {
            dismiss();
            return;
        }
        boolean zAreEqual = C12238m.areEqual(str, "image/gif");
        m8421g().f695e.setOnClickListener(new ViewOnClickListenerC5478d(str));
        TextView textView = m8421g().f693c;
        C12238m.checkNotNullExpressionValue(textView, "binding.noticeCrop");
        textView.setVisibility(zAreEqual ? 4 : 0);
        if (!zAreEqual) {
            m8421g().f693c.setOnClickListener(new ViewOnClickListenerC5475a(0, this));
        }
        m8421g().f692b.setOnClickListener(new ViewOnClickListenerC5475a(1, this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(previewType.getPreviewSizeDimenId());
        SimpleDraweeView simpleDraweeView = m8421g().f694d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.noticeImage");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        SimpleDraweeView simpleDraweeView2 = m8421g().f694d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.noticeImage");
        simpleDraweeView2.setLayoutParams(layoutParams);
        int iOrdinal = previewType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView3 = m8421g().f694d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.noticeImage");
            MGImages.setRoundingParams(simpleDraweeView3, dimensionPixelSize, true, (48 & 8) != 0 ? null : Integer.valueOf(ColorCompat.getThemedColor(view, C5419R.attr.primary_600)), (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
        }
        SimpleDraweeView simpleDraweeView4 = m8421g().f694d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.noticeImage");
        Uri uri = this.uri;
        if (uri == null) {
            C12238m.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        }
        MGImages.setImage$default(simpleDraweeView4, uri.toString(), dimensionPixelSize, dimensionPixelSize, false, null, null, 112, null);
    }
}
