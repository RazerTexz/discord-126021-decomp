package com.discord.views.sticker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.C5419R;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerPartial;
import com.discord.app.AppLog;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.apng.ApngUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p008a.p025i.C1039r1;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.p070q0.C1371a;
import p007b.p008a.p062y.p070q0.C1372b;
import p007b.p008a.p062y.p070q0.C1374d;
import p007b.p008a.p062y.p070q0.C1375e;
import p007b.p008a.p062y.p070q0.C1376f;
import p007b.p008a.p062y.p070q0.C1378h;
import p007b.p109f.p132g.p142e.C1788v;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1039r1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public BaseSticker sticker;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Subscription subscription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Job apngLoadingJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.sticker_view, this);
        int i = C5419R.id.sticker_view_imageview;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.sticker_view_imageview);
        if (simpleDraweeView != null) {
            i = C5419R.id.sticker_view_lottie;
            RLottieImageView rLottieImageView = (RLottieImageView) findViewById(C5419R.id.sticker_view_lottie);
            if (rLottieImageView != null) {
                i = C5419R.id.sticker_view_placeholder;
                ImageView imageView = (ImageView) findViewById(C5419R.id.sticker_view_placeholder);
                if (imageView != null) {
                    C1039r1 c1039r1 = new C1039r1(this, simpleDraweeView, rLottieImageView, imageView);
                    C12238m.checkNotNullExpressionValue(c1039r1, "StickerViewBinding.infla…ater.from(context), this)");
                    this.binding = c1039r1;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public static final Job m8612a(StickerView stickerView, File file, boolean z2) {
        Objects.requireNonNull(stickerView);
        ApngUtils apngUtils = ApngUtils.INSTANCE;
        SimpleDraweeView simpleDraweeView = stickerView.binding.f1177b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        return apngUtils.renderApngFromFile(file, simpleDraweeView, Integer.valueOf(stickerUtils.getDEFAULT_STICKER_SIZE_PX()), Integer.valueOf(stickerUtils.getDEFAULT_STICKER_SIZE_PX()), z2);
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m8613e(StickerView stickerView, BaseSticker baseSticker, Integer num, int i) {
        int i2 = i & 2;
        stickerView.m8616d(baseSticker, null);
    }

    /* JADX INFO: renamed from: b */
    public final void m8614b() {
        SimpleDraweeView simpleDraweeView = this.binding.f1177b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setBackground(null);
        RLottieImageView rLottieImageView = this.binding.f1178c;
        C12238m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setBackground(null);
    }

    /* JADX INFO: renamed from: c */
    public final CharSequence m8615c(BaseSticker sticker) {
        if (!(sticker instanceof Sticker)) {
            if (!(sticker instanceof StickerPartial)) {
                return null;
            }
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            return C1107b.m216h(context, C5419R.string.sticker_a11y_label, new Object[]{((StickerPartial) sticker).getName()}, null, 4);
        }
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        StringBuilder sb = new StringBuilder();
        Sticker sticker2 = (Sticker) sticker;
        sb.append(sticker2.getName());
        sb.append(", ");
        sb.append(sticker2.getDescription());
        return C1107b.m216h(context2, C5419R.string.sticker_a11y_label, new Object[]{sb.toString()}, null, 4);
    }

    /* JADX INFO: renamed from: d */
    public final void m8616d(BaseSticker sticker, Integer stickerAnimationSettings) {
        C12238m.checkNotNullParameter(sticker, "sticker");
        BaseSticker baseSticker = this.sticker;
        if (baseSticker != null && baseSticker.getId() == sticker.getId()) {
            if (this.subscription != null) {
                return;
            }
        }
        BaseSticker baseSticker2 = this.sticker;
        if (baseSticker2 != null && (baseSticker2 == null || baseSticker2.getId() != sticker.getId())) {
            Subscription subscription = this.subscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.subscription = null;
        }
        this.sticker = sticker;
        int iOrdinal = sticker.getFormatType().ordinal();
        if (iOrdinal == 1) {
            SimpleDraweeView simpleDraweeView = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.f1179d;
            C12238m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            RLottieImageView rLottieImageView = this.binding.f1178c;
            C12238m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setVisibility(8);
            SimpleDraweeView simpleDraweeView2 = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerViewImageview");
            simpleDraweeView2.setContentDescription(m8615c(sticker));
            SimpleDraweeView simpleDraweeView3 = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerViewImageview");
            MGImages.setImage$default(simpleDraweeView3, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, sticker, null, false, 6, null), 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.stickerViewImageview");
            GenericDraweeHierarchy hierarchy = simpleDraweeView4.getHierarchy();
            C12238m.checkNotNullExpressionValue(hierarchy, "binding.stickerViewImageview.hierarchy");
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
            hierarchy.m8678n(C1788v.f3446l);
            return;
        }
        if (iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView5 = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView5, "binding.stickerViewImageview");
            simpleDraweeView5.setVisibility(0);
            ImageView imageView2 = this.binding.f1179d;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.stickerViewPlaceholder");
            imageView2.setVisibility(0);
            RLottieImageView rLottieImageView2 = this.binding.f1178c;
            C12238m.checkNotNullExpressionValue(rLottieImageView2, "binding.stickerViewLottie");
            rLottieImageView2.setVisibility(8);
            this.binding.f1177b.setImageDrawable(null);
            SimpleDraweeView simpleDraweeView6 = this.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView6, "binding.stickerViewImageview");
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView6.getHierarchy();
            C12238m.checkNotNullExpressionValue(hierarchy2, "binding.stickerViewImageview.hierarchy");
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
            hierarchy2.m8678n(C1788v.f3446l);
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            Observable observableM11076j = Observable.m11076j(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, sticker), false, 1, null), StoreUserSettings.observeStickerAnimationSettings$default(StoreStream.INSTANCE.getUserSettings(), false, 1, null), C1371a.f2066j);
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…lobalAnimationSettings) }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11076j), (Class<?>) StickerView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C1372b(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C1374d(this, stickerAnimationSettings, sticker));
            return;
        }
        if (iOrdinal != 3) {
            Logger.e$default(AppLog.f14950g, "Invalid Sticker Format passed to " + StickerView.class + ", type: " + sticker.getFormatType(), null, null, 6, null);
            return;
        }
        SimpleDraweeView simpleDraweeView7 = this.binding.f1177b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView7, "binding.stickerViewImageview");
        simpleDraweeView7.setVisibility(8);
        ImageView imageView3 = this.binding.f1179d;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.stickerViewPlaceholder");
        imageView3.setVisibility(0);
        RLottieImageView rLottieImageView3 = this.binding.f1178c;
        C12238m.checkNotNullExpressionValue(rLottieImageView3, "binding.stickerViewLottie");
        rLottieImageView3.setVisibility(0);
        this.binding.f1178c.setImageDrawable(null);
        this.binding.f1178c.clearAnimation();
        StickerUtils stickerUtils2 = StickerUtils.INSTANCE;
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        Observable observableM11076j2 = Observable.m11076j(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils2.fetchSticker(context2, sticker), false, 1, null), StoreUserSettings.observeStickerAnimationSettings$default(StoreStream.INSTANCE.getUserSettings(), false, 1, null), C1375e.f2067j);
        C12238m.checkNotNullExpressionValue(observableM11076j2, "Observable.combineLatest…lobalAnimationSettings) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11076j2), (Class<?>) StickerView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C1376f(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C1378h(this, stickerAnimationSettings, sticker));
    }

    public final Subscription getSubscription() {
        return this.subscription;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        BaseSticker baseSticker = this.sticker;
        StickerFormatType formatType = baseSticker != null ? baseSticker.getFormatType() : null;
        if (formatType == null) {
            return;
        }
        int iOrdinal = formatType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            this.binding.f1177b.setOnClickListener(onClickListener);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.binding.f1178c.setOnClickListener(onClickListener);
        }
    }
}
