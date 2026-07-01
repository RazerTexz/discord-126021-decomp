package b.a.y.q0;

import android.content.Context;
import android.widget.ImageView;
import com.discord.api.sticker.BaseSticker;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieDrawable$PlaybackMode;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.file.DownloadUtils$DownloadState;
import com.discord.utilities.file.DownloadUtils$DownloadState$Completed;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.sticker.StickerView;
import d0.z.d.m;
import d0.z.d.o;
import java.io.File;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends o implements Function1<Pair<? extends DownloadUtils$DownloadState, ? extends Integer>, Unit> {
    public final /* synthetic */ Integer $localAnimationSettings;
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(StickerView stickerView, Integer num, BaseSticker baseSticker) {
        super(1);
        this.this$0 = stickerView;
        this.$localAnimationSettings = num;
        this.$sticker = baseSticker;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends DownloadUtils$DownloadState, ? extends Integer> pair) {
        Pair<? extends DownloadUtils$DownloadState, ? extends Integer> pair2 = pair;
        DownloadUtils$DownloadState downloadUtils$DownloadStateComponent1 = pair2.component1();
        Integer numComponent2 = pair2.component2();
        if (downloadUtils$DownloadStateComponent1 instanceof DownloadUtils$DownloadState$Completed) {
            Integer num = this.$localAnimationSettings;
            if (num != null) {
                numComponent2 = num;
            }
            RLottieDrawable$PlaybackMode rLottieDrawable$PlaybackMode = (numComponent2 != null && numComponent2.intValue() == 0) ? RLottieDrawable$PlaybackMode.LOOP : RLottieDrawable$PlaybackMode.FREEZE;
            ImageView imageView = this.this$0.binding.d;
            m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            RLottieImageView rLottieImageView = this.this$0.binding.c;
            m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setContentDescription(this.this$0.c(this.$sticker));
            StickerView stickerView = this.this$0;
            RLottieImageView rLottieImageView2 = stickerView.binding.c;
            Context context = stickerView.getContext();
            m.checkNotNullExpressionValue(context, "context");
            File file = ((DownloadUtils$DownloadState$Completed) downloadUtils$DownloadStateComponent1).getFile();
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            int default_sticker_size_px = stickerUtils.getDEFAULT_STICKER_SIZE_PX();
            int default_sticker_size_px2 = stickerUtils.getDEFAULT_STICKER_SIZE_PX();
            Objects.requireNonNull(rLottieImageView2);
            m.checkParameterIsNotNull(context, "context");
            m.checkParameterIsNotNull(file, "file");
            m.checkParameterIsNotNull(rLottieDrawable$PlaybackMode, "playbackMode");
            RLottieDrawable rLottieDrawable = new RLottieDrawable(file, default_sticker_size_px, default_sticker_size_px2, false, true, rLottieImageView2.a(context).getRefreshRate(), (int[]) null, 64);
            rLottieImageView2.drawable = rLottieDrawable;
            rLottieDrawable.f(rLottieDrawable$PlaybackMode);
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 != null) {
                rLottieDrawable2.e(true);
            }
            rLottieImageView2.setImageDrawable(rLottieImageView2.drawable);
            if (numComponent2 != null && numComponent2.intValue() == 0) {
                this.this$0.binding.c.b();
            } else if (numComponent2 != null && numComponent2.intValue() == 1) {
                RLottieImageView rLottieImageView3 = this.this$0.binding.c;
                m.checkNotNullExpressionValue(rLottieImageView3, "binding.stickerViewLottie");
                ViewExtensions.setOnLongClickListenerConsumeClick(rLottieImageView3, new g(this));
            } else if (numComponent2 != null && numComponent2.intValue() == 2) {
                this.this$0.binding.c.setOnLongClickListener(null);
            }
        }
        return Unit.a;
    }
}
