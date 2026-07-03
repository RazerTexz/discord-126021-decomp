package com.discord.utilities.images;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.media_picker.MediaPicker;
import com.discord.media_picker.RequestType;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.yalantis.ucrop.UCropActivity;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p132g.p143f.C1795c;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p485q.p486a.C5285a;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: MGImages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImages {
    public static final MGImages INSTANCE = new MGImages();
    private static final ImageEncoder imageEncoder = new ImageEncoder();

    /* JADX INFO: compiled from: MGImages.kt */
    public static final class AlwaysUpdateChangeDetector implements ChangeDetector {
        public static final AlwaysUpdateChangeDetector INSTANCE = new AlwaysUpdateChangeDetector();

        private AlwaysUpdateChangeDetector() {
        }

        @Override // com.discord.utilities.images.MGImages.ChangeDetector
        public boolean track(Object key, Object value) {
            C12238m.checkNotNullParameter(key, "key");
            return true;
        }
    }

    /* JADX INFO: compiled from: MGImages.kt */
    public interface ChangeDetector {
        boolean track(Object key, Object value);
    }

    /* JADX INFO: compiled from: MGImages.kt */
    public static final class DistinctChangeDetector implements ChangeDetector {
        private final HashMap<Object, Object> dataMap = new HashMap<>();

        @Override // com.discord.utilities.images.MGImages.ChangeDetector
        public boolean track(Object key, Object value) {
            C12238m.checkNotNullParameter(key, "key");
            if (this.dataMap.containsKey(key) && C12238m.areEqual(this.dataMap.get(key), value)) {
                return false;
            }
            this.dataMap.put(key, value);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.images.MGImages$requestImageCrop$1 */
    /* JADX INFO: compiled from: MGImages.kt */
    public static final class C67741 extends AbstractC12240o implements Function1<Exception, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67741(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            invoke2(exc);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Exception exc) {
            C12238m.checkNotNullParameter(exc, "e");
            Context context = this.$context;
            C0876m.m170h(context, context != null ? C1107b.m210b(context, C5419R.string.unable_to_open_media_chooser, new Object[]{exc.getMessage()}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null, 0, null, 12);
        }
    }

    private MGImages() {
    }

    private final DraweeView<?> getDrawee(ImageView imageView) {
        Objects.requireNonNull(imageView, "null cannot be cast to non-null type com.facebook.drawee.view.DraweeView<*>");
        return (DraweeView) imageView;
    }

    private final GenericDraweeHierarchy getHierarchy(ImageView imageView) {
        DraweeView<?> drawee = getDrawee(imageView);
        if (!drawee.hasHierarchy()) {
            drawee.setHierarchy(new C1793a(imageView.getResources()).m1122a());
        }
        DraweeHierarchy hierarchy = drawee.getHierarchy();
        Objects.requireNonNull(hierarchy, "null cannot be cast to non-null type com.facebook.drawee.generic.GenericDraweeHierarchy");
        return (GenericDraweeHierarchy) hierarchy;
    }

    public static final ImageRequestBuilder getImageRequest(String url, int width, int height, boolean useSmallCache) {
        C12238m.checkNotNullParameter(url, "url");
        ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(Uri.parse(url));
        imageRequestBuilderM8723b.f19613b = ImageRequest.EnumC10667c.FULL_FETCH;
        C12238m.checkNotNullExpressionValue(imageRequestBuilderM8723b, "requestBuilder");
        boolean z2 = false;
        imageRequestBuilderM8723b.f19618g = (useSmallCache || !C12106w.contains$default((CharSequence) url, (CharSequence) IconUtils.ANIMATED_IMAGE_EXTENSION, false, 2, (Object) null)) ? ImageRequest.EnumC10666b.SMALL : ImageRequest.EnumC10666b.DEFAULT;
        if (width > 0 && height > 0) {
            z2 = true;
        }
        if (z2) {
            imageRequestBuilderM8723b.f19615d = new C1884e(width, height);
        }
        return imageRequestBuilderM8723b;
    }

    public static final void prepareImageUpload(Uri uri, String mimeType, FragmentManager fragmentManager, MediaPicker.Provider provider, Action1<String> cropResultCallback, ImageUploadDialog.PreviewType previewType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(previewType, "previewType");
        Objects.requireNonNull(ImageUploadDialog.INSTANCE);
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        C12238m.checkNotNullParameter(previewType, "previewType");
        ImageUploadDialog imageUploadDialog = new ImageUploadDialog();
        C12238m.checkNotNullParameter(uri, "<set-?>");
        imageUploadDialog.uri = uri;
        C12238m.checkNotNullParameter(provider, "<set-?>");
        imageUploadDialog.provider = provider;
        imageUploadDialog.mimeType = mimeType;
        imageUploadDialog.cropResultCallBack = cropResultCallback;
        imageUploadDialog.previewType = previewType;
        imageUploadDialog.show(fragmentManager, ImageUploadDialog.class.getName());
    }

    public static final void requestDataUrl(Context context, Uri uri, String mimeType, Action1<String> resultCallback) {
        InputStream inputStreamOpenInputStream;
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || (inputStreamOpenInputStream = contentResolver.openInputStream(uri)) == null) {
                    return;
                }
                if (resultCallback != null) {
                    try {
                        ImageEncoder imageEncoder2 = imageEncoder;
                        C12238m.checkNotNullExpressionValue(inputStreamOpenInputStream, "it");
                        resultCallback.call(imageEncoder2.getDataUrl(mimeType, inputStreamOpenInputStream));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            C12201b.closeFinally(inputStreamOpenInputStream, th);
                            throw th2;
                        }
                    }
                }
                C12201b.closeFinally(inputStreamOpenInputStream, null);
            } catch (IOException e) {
                C0876m.m170h(context, C1107b.m210b(context, C5419R.string.avatar_convert_failure_mobile, new Object[]{e.getMessage()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
            } catch (IllegalStateException e2) {
                C0876m.m170h(context, C1107b.m210b(context, C5419R.string.avatar_convert_failure_mobile, new Object[]{e2.getMessage()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
            } catch (NullPointerException e3) {
                C0876m.m170h(context, C1107b.m210b(context, C5419R.string.avatar_convert_failure_mobile, new Object[]{e3.getMessage()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
            }
        }
    }

    public static final void requestImageCrop(Context context, MediaPicker.Provider provider, Uri inputUri, float aspectRatioX, float aspectRatioY, int maxOutputDimensionPx) {
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(inputUri, "inputUri");
        C67741 c67741 = new C67741(context);
        int themedColor = ColorCompat.getThemedColor(context, C5419R.attr.color_brand_500);
        int color = ColorCompat.getColor(context, C5419R.color.white);
        int themedColor2 = ColorCompat.getThemedColor(context, C5419R.attr.color_brand_630);
        int themedColor3 = ColorCompat.getThemedColor(context, C5419R.attr.color_brand_500);
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(inputUri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(c67741, "onError");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("com.yalantis.ucrop.ToolbarColor", themedColor);
            bundle.putInt("com.yalantis.ucrop.StatusBarColor", themedColor2);
            bundle.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", color);
            bundle.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropFrameColor", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropGridColor", themedColor3);
            if (bundle.getString("com.yalantis.ucrop.CompressionFormatName") == null) {
                bundle.putString("com.yalantis.ucrop.CompressionFormatName", Bitmap.CompressFormat.PNG.name());
            }
            Context contextRequireContext = provider.requireContext();
            Uri uriFromFile = Uri.fromFile(provider.getImageFile());
            C12238m.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(provider.getImageFile())");
            C5285a c5285a = new C5285a(inputUri, uriFromFile);
            C12238m.checkNotNullExpressionValue(c5285a, "UCrop.of(uri, destUri)");
            c5285a.f14388b.putAll(bundle);
            int i = maxOutputDimensionPx < 10 ? 10 : maxOutputDimensionPx;
            if (maxOutputDimensionPx < 10) {
                maxOutputDimensionPx = 10;
            }
            c5285a.f14388b.putInt("com.yalantis.ucrop.MaxSizeX", i);
            c5285a.f14388b.putInt("com.yalantis.ucrop.MaxSizeY", maxOutputDimensionPx);
            c5285a.f14388b.putFloat("com.yalantis.ucrop.AspectRatioX", aspectRatioX);
            c5285a.f14388b.putFloat("com.yalantis.ucrop.AspectRatioY", aspectRatioY);
            c5285a.f14387a.setClass(contextRequireContext, UCropActivity.class);
            c5285a.f14387a.putExtras(c5285a.f14388b);
            Intent intent = c5285a.f14387a;
            C12238m.checkNotNullExpressionValue(intent, "uCrop.getIntent(context)");
            List<ResolveInfo> listQueryIntentActivities = contextRequireContext.getPackageManager().queryIntentActivities(intent, 65536);
            C12238m.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                contextRequireContext.grantUriPermission(it.next().activityInfo.packageName, uriFromFile, 3);
            }
            try {
                provider.startActivityForResult(intent, RequestType.CROP.getCode$media_picker_release());
            } catch (ActivityNotFoundException unused) {
                throw new IOException("No application available for media picker.");
            }
        } catch (IOException e) {
            c67741.invoke(e);
        }
    }

    public static final void setImage(ImageView imageView, String str) {
        setImage$default(imageView, str, 0, 0, false, null, null, 124, null);
    }

    public static final void setImage(ImageView imageView, String str, int i) {
        setImage$default(imageView, str, i, 0, false, null, null, 120, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2) {
        setImage$default(imageView, str, i, i2, false, null, null, 112, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2, boolean z2) {
        setImage$default(imageView, str, i, i2, z2, null, null, 96, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1) {
        setImage$default(imageView, str, i, i2, z2, function1, null, 64, null);
    }

    public static final void setImage(ImageView imageView, List<String> list) {
        setImage$default(imageView, list, 0, 0, false, null, null, null, 252, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i) {
        setImage$default(imageView, list, i, 0, false, null, null, null, 248, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2) {
        setImage$default(imageView, list, i, i2, false, null, null, null, 240, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2) {
        setImage$default(imageView, list, i, i2, z2, null, null, null, 224, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1) {
        setImage$default(imageView, list, i, i2, z2, function1, null, null, Opcodes.CHECKCAST, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1, ChangeDetector changeDetector) {
        setImage$default(imageView, list, i, i2, z2, function1, changeDetector, null, 128, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Uri uri, ChangeDetector changeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, uri, changeDetector);
    }

    public static final void setRoundingParams(ImageView view, float cornerRadius, boolean circle, @ColorInt Integer overlayColor, @ColorInt Integer borderColor, Float borderWidth) {
        C1795c c1795cM1124a;
        C12238m.checkNotNullParameter(view, "view");
        if (circle) {
            c1795cM1124a = new C1795c();
            c1795cM1124a.f3472b = true;
            c1795cM1124a.f3471a = 1;
        } else {
            c1795cM1124a = C1795c.m1124a(cornerRadius);
        }
        if (Build.VERSION.SDK_INT == 28) {
            C12238m.checkNotNullExpressionValue(c1795cM1124a, "roundingParams");
            c1795cM1124a.f3478h = true;
        }
        if (overlayColor != null) {
            overlayColor.intValue();
            C12238m.checkNotNullExpressionValue(c1795cM1124a, "roundingParams");
            c1795cM1124a.m1125b(overlayColor.intValue());
        }
        if (borderColor != null) {
            borderColor.intValue();
            C12238m.checkNotNullExpressionValue(c1795cM1124a, "roundingParams");
            c1795cM1124a.f3476f = borderColor.intValue();
        }
        if (borderWidth != null) {
            borderWidth.floatValue();
            C12238m.checkNotNullExpressionValue(c1795cM1124a, "roundingParams");
            float fFloatValue = borderWidth.floatValue();
            C1460d.m535k(fFloatValue >= 0.0f, "the border width cannot be < 0");
            c1795cM1124a.f3475e = fFloatValue;
        }
        INSTANCE.getHierarchy(view).m8683s(c1795cM1124a);
    }

    public static final void setScaleType(ImageView view, ScalingUtils$ScaleType scaleType) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(scaleType, "scaleType");
        INSTANCE.getHierarchy(view).m8678n(scaleType);
    }

    public final void cancelImageRequests(ImageView view) {
        C12238m.checkNotNullParameter(view, "view");
        getDrawee(view).setController(null);
    }

    public final Bitmap centerBitmapInTransparentBitmap(Bitmap src, int innerHeight, int innerWidth, int outerHeight, int outerWidth, int fillMargins, @ColorInt int fillColor) {
        C12238m.checkNotNullParameter(src, "src");
        if (outerWidth <= innerWidth || outerHeight <= innerHeight) {
            StringBuilder sbM835W = C1643a.m835W("Cannot fit bitmap of size ", innerWidth, " x ", innerHeight, " inside ");
            sbM835W.append("bitmap of size ");
            sbM835W.append(outerWidth);
            sbM835W.append(" x ");
            sbM835W.append(outerHeight);
            throw new IllegalArgumentException(sbM835W.toString());
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(outerWidth, outerHeight, src.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = (outerWidth - innerWidth) / 2.0f;
        float f2 = (outerHeight - innerHeight) / 2.0f;
        RectF rectF = new RectF(f, f2, innerWidth + f, innerHeight + f2);
        if (fillColor != 0) {
            int iSave = canvas.save();
            try {
                canvas.clipRect(fillMargins, fillMargins, outerWidth - fillMargins, outerHeight - fillMargins);
                canvas.drawColor(fillColor);
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        canvas.drawBitmap(src, (Rect) null, rectF, (Paint) null);
        C12238m.checkNotNullExpressionValue(bitmapCreateBitmap, "dest");
        return bitmapCreateBitmap;
    }

    public final void setImage(ImageView view, Uri uri, ChangeDetector changeDetector) {
        Integer intOrNull;
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        if (C12238m.areEqual(uri.getScheme(), "android.resource")) {
            String host = uri.getHost();
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            if (C12238m.areEqual(host, context.getPackageName())) {
                String lastPathSegment = uri.getLastPathSegment();
                setImage(view, (lastPathSegment == null || (intOrNull = C12102s.toIntOrNull(lastPathSegment)) == null) ? 0 : intOrNull.intValue(), changeDetector);
                return;
            }
        }
        setImage$default(view, uri.toString(), 0, 0, false, null, changeDetector, 60, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, changeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, ScalingUtils$ScaleType scalingUtils$ScaleType, ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, scalingUtils$ScaleType, changeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Drawable drawable, ChangeDetector changeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, drawable, changeDetector);
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, String str, int i, int i2, boolean z2, Function1 function1, ChangeDetector changeDetector, int i3, Object obj) {
        setImage(imageView, str, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (Function1<? super ImageRequestBuilder, Unit>) ((i3 & 32) != 0 ? null : function1), (i3 & 64) != 0 ? AlwaysUpdateChangeDetector.INSTANCE : changeDetector);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, ChangeDetector changeDetector) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.m8679o(1, hierarchy.f19507b.getDrawable(resourceId));
        }
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, List list, int i, int i2, boolean z2, Function1 function1, ChangeDetector changeDetector, ControllerListener controllerListener, int i3, Object obj) {
        setImage(imageView, list, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (i3 & 32) != 0 ? null : function1, (i3 & 64) != 0 ? AlwaysUpdateChangeDetector.INSTANCE : changeDetector, (i3 & 128) == 0 ? controllerListener : null);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, ScalingUtils$ScaleType scaleType, ChangeDetector changeDetector) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(scaleType, "scaleType");
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.m8681q(hierarchy.f19507b.getDrawable(resourceId), scaleType);
        }
    }

    public final void setImage(ImageView view, Drawable drawable, ChangeDetector changeDetector) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(drawable, "drawable");
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, drawable)) {
            getHierarchy(view).m8679o(1, drawable);
        }
    }

    public static final void setImage(ImageView view, String url, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, ChangeDetector changeDetector) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        setImage$default(view, (url == null || C12103t.isBlank(url)) ? C12147n.emptyList() : C12145m.listOf(url), width, height, useSmallCache, transform, changeDetector, null, 128, null);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [REQUEST[], com.facebook.imagepipeline.request.ImageRequest[]] */
    public static final void setImage(ImageView view, List<String> urls, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, ChangeDetector changeDetector, ControllerListener<ImageInfo> controllerListener) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(urls, "urls");
        C12238m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, urls)) {
            if (urls.isEmpty()) {
                INSTANCE.getDrawee(view).setController(null);
                return;
            }
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(urls, 10));
            Iterator<T> it = urls.iterator();
            while (it.hasNext()) {
                ImageRequestBuilder imageRequest = getImageRequest((String) it.next(), width, height, useSmallCache);
                if (transform != null) {
                    transform.invoke(imageRequest);
                }
                arrayList.add(imageRequest.m8724a());
            }
            Object[] array = arrayList.toArray(new ImageRequest[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ?? r4 = (ImageRequest[]) array;
            C1733d c1733dM1037a = C1731b.m1037a();
            MGImages mGImages = INSTANCE;
            c1733dM1037a.f19490n = mGImages.getDrawee(view).getController();
            c1733dM1037a.f19487k = controllerListener;
            c1733dM1037a.f19489m = true;
            C1460d.m535k(r4.length > 0, "No requests specified!");
            c1733dM1037a.f19485i = r4;
            c1733dM1037a.f19486j = true;
            mGImages.getDrawee(view).setController(c1733dM1037a.m8667a());
        }
    }
}
