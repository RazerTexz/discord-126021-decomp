package com.discord.dialogs;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import b.a.i.b0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.media_picker.MediaPicker$Provider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: ImageUploadDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageUploadDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(ImageUploadDialog.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadDialogBinding;", 0)};
    public static final ImageUploadDialog$b k = new ImageUploadDialog$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Uri uri;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public MediaPicker$Provider provider;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public String mimeType;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Action1<String> cropResultCallBack;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public ImageUploadDialog$PreviewType previewType;

    public ImageUploadDialog() {
        super(R$layout.image_upload_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ImageUploadDialog$c.j, null, 2, null);
    }

    public final b0 g() {
        return (b0) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ImageUploadDialog$PreviewType imageUploadDialog$PreviewType = this.previewType;
        String str = this.mimeType;
        if (imageUploadDialog$PreviewType == null || str == null) {
            dismiss();
            return;
        }
        boolean zAreEqual = m.areEqual(str, "image/gif");
        g().e.setOnClickListener(new ImageUploadDialog$d(this, str));
        TextView textView = g().c;
        m.checkNotNullExpressionValue(textView, "binding.noticeCrop");
        textView.setVisibility(zAreEqual ? 4 : 0);
        if (!zAreEqual) {
            g().c.setOnClickListener(new ImageUploadDialog$a(0, this));
        }
        g().f81b.setOnClickListener(new ImageUploadDialog$a(1, this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(imageUploadDialog$PreviewType.getPreviewSizeDimenId());
        SimpleDraweeView simpleDraweeView = g().d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.noticeImage");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        SimpleDraweeView simpleDraweeView2 = g().d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.noticeImage");
        simpleDraweeView2.setLayoutParams(layoutParams);
        int iOrdinal = imageUploadDialog$PreviewType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView3 = g().d;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.noticeImage");
            MGImages.setRoundingParams$default(simpleDraweeView3, dimensionPixelSize, true, Integer.valueOf(ColorCompat.getThemedColor(view, 2130969989)), null, null, 48, null);
        }
        SimpleDraweeView simpleDraweeView4 = g().d;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.noticeImage");
        Uri uri = this.uri;
        if (uri == null) {
            m.throwUninitializedPropertyAccessException(NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        }
        MGImages.setImage$default(simpleDraweeView4, uri.toString(), dimensionPixelSize, dimensionPixelSize, false, null, null, 112, null);
    }
}
