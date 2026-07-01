package com.discord.utilities.images;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import b.f.g.f.a;
import b.f.g.f.c;
import b.f.j.d.e;
import com.discord.R$attr;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.media_picker.MediaPicker$Provider;
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
import com.facebook.imagepipeline.request.ImageRequest$b;
import com.facebook.imagepipeline.request.ImageRequest$c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.yalantis.ucrop.UCropActivity;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.t.n;
import d0.t.o;
import d0.y.b;
import d0.z.d.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import rx.functions.Action1;

/* JADX INFO: compiled from: MGImages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImages {
    public static final MGImages INSTANCE = new MGImages();
    private static final ImageEncoder imageEncoder = new ImageEncoder();

    private MGImages() {
    }

    public static /* synthetic */ Bitmap centerBitmapInTransparentBitmap$default(MGImages mGImages, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        return mGImages.centerBitmapInTransparentBitmap(bitmap, i, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    private final DraweeView<?> getDrawee(ImageView imageView) {
        Objects.requireNonNull(imageView, "null cannot be cast to non-null type com.facebook.drawee.view.DraweeView<*>");
        return (DraweeView) imageView;
    }

    private final GenericDraweeHierarchy getHierarchy(ImageView imageView) {
        DraweeView<?> drawee = getDrawee(imageView);
        if (!drawee.hasHierarchy()) {
            drawee.setHierarchy(new a(imageView.getResources()).a());
        }
        DraweeHierarchy hierarchy = drawee.getHierarchy();
        Objects.requireNonNull(hierarchy, "null cannot be cast to non-null type com.facebook.drawee.generic.GenericDraweeHierarchy");
        return (GenericDraweeHierarchy) hierarchy;
    }

    public static final ImageRequestBuilder getImageRequest(String url, int width, int height, boolean useSmallCache) {
        m.checkNotNullParameter(url, "url");
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(Uri.parse(url));
        imageRequestBuilderB.f2904b = ImageRequest$c.FULL_FETCH;
        m.checkNotNullExpressionValue(imageRequestBuilderB, "requestBuilder");
        boolean z2 = false;
        imageRequestBuilderB.g = (useSmallCache || !w.contains$default((CharSequence) url, (CharSequence) IconUtils.ANIMATED_IMAGE_EXTENSION, false, 2, (Object) null)) ? ImageRequest$b.SMALL : ImageRequest$b.DEFAULT;
        if (width > 0 && height > 0) {
            z2 = true;
        }
        if (z2) {
            imageRequestBuilderB.d = new e(width, height);
        }
        return imageRequestBuilderB;
    }

    public static final void prepareImageUpload(Uri uri, String mimeType, FragmentManager fragmentManager, MediaPicker$Provider provider, Action1<String> cropResultCallback, ImageUploadDialog$PreviewType previewType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(previewType, "previewType");
        Objects.requireNonNull(ImageUploadDialog.k);
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(mimeType, "mimeType");
        m.checkNotNullParameter(previewType, "previewType");
        ImageUploadDialog imageUploadDialog = new ImageUploadDialog();
        m.checkNotNullParameter(uri, "<set-?>");
        imageUploadDialog.uri = uri;
        m.checkNotNullParameter(provider, "<set-?>");
        imageUploadDialog.provider = provider;
        imageUploadDialog.mimeType = mimeType;
        imageUploadDialog.cropResultCallBack = cropResultCallback;
        imageUploadDialog.previewType = previewType;
        imageUploadDialog.show(fragmentManager, ImageUploadDialog.class.getName());
    }

    public static final void requestDataUrl(Context context, Uri uri, String mimeType, Action1<String> resultCallback) {
        InputStream inputStreamOpenInputStream;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || (inputStreamOpenInputStream = contentResolver.openInputStream(uri)) == null) {
                    return;
                }
                if (resultCallback != null) {
                    try {
                        ImageEncoder imageEncoder2 = imageEncoder;
                        m.checkNotNullExpressionValue(inputStreamOpenInputStream, "it");
                        resultCallback.call(imageEncoder2.getDataUrl(mimeType, inputStreamOpenInputStream));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            b.closeFinally(inputStreamOpenInputStream, th);
                            throw th2;
                        }
                    }
                }
                b.closeFinally(inputStreamOpenInputStream, null);
            } catch (IOException e) {
                b.a.d.m.h(context, b.a.k.b.h(context, 2131886955, new Object[]{e.getMessage()}, null, 4), 0, null, 12);
            } catch (IllegalStateException e2) {
                b.a.d.m.h(context, b.a.k.b.h(context, 2131886955, new Object[]{e2.getMessage()}, null, 4), 0, null, 12);
            } catch (NullPointerException e3) {
                b.a.d.m.h(context, b.a.k.b.h(context, 2131886955, new Object[]{e3.getMessage()}, null, 4), 0, null, 12);
            }
        }
    }

    public static final void requestImageCrop(Context context, MediaPicker$Provider provider, Uri inputUri, float aspectRatioX, float aspectRatioY, int maxOutputDimensionPx) {
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(inputUri, "inputUri");
        MGImages$requestImageCrop$1 mGImages$requestImageCrop$1 = new MGImages$requestImageCrop$1(context);
        int themedColor = ColorCompat.getThemedColor(context, R$attr.color_brand_500);
        int color = ColorCompat.getColor(context, 2131100487);
        int themedColor2 = ColorCompat.getThemedColor(context, 2130969079);
        int themedColor3 = ColorCompat.getThemedColor(context, R$attr.color_brand_500);
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(inputUri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mGImages$requestImageCrop$1, "onError");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("com.yalantis.ucrop.ToolbarColor", themedColor);
            bundle.putInt("com.yalantis.ucrop.StatusBarColor", themedColor2);
            bundle.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", color);
            bundle.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropFrameColor", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropGridColor", themedColor3);
            if (bundle.getString("com.yalantis.ucrop.CompressionFormatName") == null) {
                bundle.putString("com.yalantis.ucrop.CompressionFormatName", Bitmap$CompressFormat.PNG.name());
            }
            Context contextRequireContext = provider.requireContext();
            Uri uriFromFile = Uri.fromFile(provider.getImageFile());
            m.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(provider.getImageFile())");
            b.q.a.a aVar = new b.q.a.a(inputUri, uriFromFile);
            m.checkNotNullExpressionValue(aVar, "UCrop.of(uri, destUri)");
            aVar.f1977b.putAll(bundle);
            int i = maxOutputDimensionPx < 10 ? 10 : maxOutputDimensionPx;
            if (maxOutputDimensionPx < 10) {
                maxOutputDimensionPx = 10;
            }
            aVar.f1977b.putInt("com.yalantis.ucrop.MaxSizeX", i);
            aVar.f1977b.putInt("com.yalantis.ucrop.MaxSizeY", maxOutputDimensionPx);
            aVar.f1977b.putFloat("com.yalantis.ucrop.AspectRatioX", aspectRatioX);
            aVar.f1977b.putFloat("com.yalantis.ucrop.AspectRatioY", aspectRatioY);
            aVar.a.setClass(contextRequireContext, UCropActivity.class);
            aVar.a.putExtras(aVar.f1977b);
            Intent intent = aVar.a;
            m.checkNotNullExpressionValue(intent, "uCrop.getIntent(context)");
            List<ResolveInfo> listQueryIntentActivities = contextRequireContext.getPackageManager().queryIntentActivities(intent, 65536);
            m.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
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
            mGImages$requestImageCrop$1.invoke(e);
        }
    }

    public static /* synthetic */ void requestImageCrop$default(Context context, MediaPicker$Provider mediaPicker$Provider, Uri uri, float f, float f2, int i, int i2, Object obj) {
        requestImageCrop(context, mediaPicker$Provider, uri, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? 1.0f : f2, (i2 & 32) != 0 ? 1024 : i);
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

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1, MGImages$ChangeDetector mGImages$ChangeDetector) {
        setImage$default(imageView, list, i, i2, z2, function1, mGImages$ChangeDetector, null, 128, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Uri uri, MGImages$ChangeDetector mGImages$ChangeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            mGImages$ChangeDetector = MGImages$AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, uri, mGImages$ChangeDetector);
    }

    public static final void setRoundingParams(ImageView view, float cornerRadius, boolean circle, @ColorInt Integer overlayColor, @ColorInt Integer borderColor, Float borderWidth) {
        c cVarA;
        m.checkNotNullParameter(view, "view");
        if (circle) {
            cVarA = new c();
            cVarA.f523b = true;
            cVarA.a = 1;
        } else {
            cVarA = c.a(cornerRadius);
        }
        if (Build$VERSION.SDK_INT == 28) {
            m.checkNotNullExpressionValue(cVarA, "roundingParams");
            cVarA.h = true;
        }
        if (overlayColor != null) {
            overlayColor.intValue();
            m.checkNotNullExpressionValue(cVarA, "roundingParams");
            cVarA.b(overlayColor.intValue());
        }
        if (borderColor != null) {
            borderColor.intValue();
            m.checkNotNullExpressionValue(cVarA, "roundingParams");
            cVarA.f = borderColor.intValue();
        }
        if (borderWidth != null) {
            borderWidth.floatValue();
            m.checkNotNullExpressionValue(cVarA, "roundingParams");
            float fFloatValue = borderWidth.floatValue();
            d.k(fFloatValue >= 0.0f, "the border width cannot be < 0");
            cVarA.e = fFloatValue;
        }
        INSTANCE.getHierarchy(view).s(cVarA);
    }

    public static /* synthetic */ void setRoundingParams$default(ImageView imageView, float f, boolean z2, Integer num, Integer num2, Float f2, int i, Object obj) {
        setRoundingParams(imageView, f, z2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : f2);
    }

    public static final void setScaleType(ImageView view, ScalingUtils$ScaleType scaleType) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(scaleType, "scaleType");
        INSTANCE.getHierarchy(view).n(scaleType);
    }

    public final void cancelImageRequests(ImageView view) {
        m.checkNotNullParameter(view, "view");
        getDrawee(view).setController(null);
    }

    public final Bitmap centerBitmapInTransparentBitmap(Bitmap src, int innerHeight, int innerWidth, int outerHeight, int outerWidth, int fillMargins, @ColorInt int fillColor) {
        m.checkNotNullParameter(src, "src");
        if (outerWidth <= innerWidth || outerHeight <= innerHeight) {
            StringBuilder sbW = b.d.b.a.a.W("Cannot fit bitmap of size ", innerWidth, " x ", innerHeight, " inside ");
            sbW.append("bitmap of size ");
            sbW.append(outerWidth);
            sbW.append(" x ");
            sbW.append(outerHeight);
            throw new IllegalArgumentException(sbW.toString());
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
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "dest");
        return bitmapCreateBitmap;
    }

    public final void setImage(ImageView view, Uri uri, MGImages$ChangeDetector changeDetector) {
        Integer intOrNull;
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(changeDetector, "changeDetector");
        if (m.areEqual(uri.getScheme(), "android.resource")) {
            String host = uri.getHost();
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            if (m.areEqual(host, context.getPackageName())) {
                String lastPathSegment = uri.getLastPathSegment();
                setImage(view, (lastPathSegment == null || (intOrNull = s.toIntOrNull(lastPathSegment)) == null) ? 0 : intOrNull.intValue(), changeDetector);
                return;
            }
        }
        setImage$default(view, uri.toString(), 0, 0, false, null, changeDetector, 60, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, MGImages$ChangeDetector mGImages$ChangeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            mGImages$ChangeDetector = MGImages$AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, mGImages$ChangeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, ScalingUtils$ScaleType scalingUtils$ScaleType, MGImages$ChangeDetector mGImages$ChangeDetector, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            mGImages$ChangeDetector = MGImages$AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, scalingUtils$ScaleType, mGImages$ChangeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Drawable drawable, MGImages$ChangeDetector mGImages$ChangeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            mGImages$ChangeDetector = MGImages$AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, drawable, mGImages$ChangeDetector);
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, String str, int i, int i2, boolean z2, Function1 function1, MGImages$ChangeDetector mGImages$ChangeDetector, int i3, Object obj) {
        setImage(imageView, str, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (Function1<? super ImageRequestBuilder, Unit>) ((i3 & 32) != 0 ? null : function1), (i3 & 64) != 0 ? MGImages$AlwaysUpdateChangeDetector.INSTANCE : mGImages$ChangeDetector);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, MGImages$ChangeDetector changeDetector) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.o(1, hierarchy.f2890b.getDrawable(resourceId));
        }
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, List list, int i, int i2, boolean z2, Function1 function1, MGImages$ChangeDetector mGImages$ChangeDetector, ControllerListener controllerListener, int i3, Object obj) {
        setImage(imageView, list, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (i3 & 32) != 0 ? null : function1, (i3 & 64) != 0 ? MGImages$AlwaysUpdateChangeDetector.INSTANCE : mGImages$ChangeDetector, (i3 & 128) == 0 ? controllerListener : null);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, ScalingUtils$ScaleType scaleType, MGImages$ChangeDetector changeDetector) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(scaleType, "scaleType");
        m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.q(hierarchy.f2890b.getDrawable(resourceId), scaleType);
        }
    }

    public final void setImage(ImageView view, Drawable drawable, MGImages$ChangeDetector changeDetector) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(drawable, "drawable");
        m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, drawable)) {
            getHierarchy(view).o(1, drawable);
        }
    }

    public static final void setImage(ImageView view, String url, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, MGImages$ChangeDetector changeDetector) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(changeDetector, "changeDetector");
        setImage$default(view, (url == null || t.isBlank(url)) ? n.emptyList() : d0.t.m.listOf(url), width, height, useSmallCache, transform, changeDetector, null, 128, null);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [REQUEST[], com.facebook.imagepipeline.request.ImageRequest[]] */
    public static final void setImage(ImageView view, List<String> urls, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, MGImages$ChangeDetector changeDetector, ControllerListener<ImageInfo> controllerListener) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(urls, "urls");
        m.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, urls)) {
            if (urls.isEmpty()) {
                INSTANCE.getDrawee(view).setController(null);
                return;
            }
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(urls, 10));
            Iterator<T> it = urls.iterator();
            while (it.hasNext()) {
                ImageRequestBuilder imageRequest = getImageRequest((String) it.next(), width, height, useSmallCache);
                if (transform != null) {
                    transform.invoke(imageRequest);
                }
                arrayList.add(imageRequest.a());
            }
            Object[] array = arrayList.toArray(new ImageRequest[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ?? r4 = (ImageRequest[]) array;
            b.f.g.a.a.d dVarA = b.f.g.a.a.b.a();
            MGImages mGImages = INSTANCE;
            dVarA.n = mGImages.getDrawee(view).getController();
            dVarA.k = controllerListener;
            dVarA.m = true;
            d.k(r4.length > 0, "No requests specified!");
            dVarA.i = r4;
            dVarA.j = true;
            mGImages.getDrawee(view).setController(dVarA.a());
        }
    }
}
