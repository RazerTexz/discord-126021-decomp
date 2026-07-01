package b.a.y.q0;

import android.content.Context;
import android.widget.ImageView;
import com.discord.api.sticker.BaseSticker;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.sticker.StickerView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.q0.h, reason: use source file name */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView9 extends Lambda implements Function1<Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer>, Unit> {
    public final /* synthetic */ Integer $localAnimationSettings;
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView9(StickerView stickerView, Integer num, BaseSticker baseSticker) {
        super(1);
        this.this$0 = stickerView;
        this.$localAnimationSettings = num;
        this.$sticker = baseSticker;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer> tuples2) {
        Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer> tuples3 = tuples2;
        DownloadUtils.DownloadState downloadStateComponent1 = tuples3.component1();
        Integer numComponent2 = tuples3.component2();
        if (downloadStateComponent1 instanceof DownloadUtils.DownloadState.Completed) {
            Integer num = this.$localAnimationSettings;
            if (num != null) {
                numComponent2 = num;
            }
            RLottieDrawable.PlaybackMode playbackMode = (numComponent2 != null && numComponent2.intValue() == 0) ? RLottieDrawable.PlaybackMode.LOOP : RLottieDrawable.PlaybackMode.FREEZE;
            ImageView imageView = this.this$0.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            RLottieImageView rLottieImageView = this.this$0.binding.c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setContentDescription(this.this$0.c(this.$sticker));
            StickerView stickerView = this.this$0;
            RLottieImageView rLottieImageView2 = stickerView.binding.c;
            Context context = stickerView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            File file = ((DownloadUtils.DownloadState.Completed) downloadStateComponent1).getFile();
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            int default_sticker_size_px = stickerUtils.getDEFAULT_STICKER_SIZE_PX();
            int default_sticker_size_px2 = stickerUtils.getDEFAULT_STICKER_SIZE_PX();
            Objects.requireNonNull(rLottieImageView2);
            Intrinsics3.checkParameterIsNotNull(context, "context");
            Intrinsics3.checkParameterIsNotNull(file, "file");
            Intrinsics3.checkParameterIsNotNull(playbackMode, "playbackMode");
            RLottieDrawable rLottieDrawable = new RLottieDrawable(file, default_sticker_size_px, default_sticker_size_px2, false, true, rLottieImageView2.a(context).getRefreshRate(), (int[]) null, 64);
            rLottieImageView2.drawable = rLottieDrawable;
            rLottieDrawable.f(playbackMode);
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 != null) {
                rLottieDrawable2.e(true);
            }
            rLottieImageView2.setImageDrawable(rLottieImageView2.drawable);
            if (numComponent2 != null && numComponent2.intValue() == 0) {
                this.this$0.binding.c.b();
            } else if (numComponent2 != null && numComponent2.intValue() == 1) {
                RLottieImageView rLottieImageView3 = this.this$0.binding.c;
                Intrinsics3.checkNotNullExpressionValue(rLottieImageView3, "binding.stickerViewLottie");
                ViewExtensions.setOnLongClickListenerConsumeClick(rLottieImageView3, new StickerView8(this));
            } else if (numComponent2 != null && numComponent2.intValue() == 2) {
                this.this$0.binding.c.setOnLongClickListener(null);
            }
        }
        return Unit.a;
    }
}
