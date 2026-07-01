package b.a.y.q0;

import android.widget.ImageView;
import com.discord.api.sticker.BaseSticker;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.q0.d, reason: use source file name */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView5 extends Lambda implements Function1<Tuples2<? extends DownloadUtils.DownloadState, ? extends Integer>, Unit> {
    public final /* synthetic */ Integer $localAnimationSettings;
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView5(StickerView stickerView, Integer num, BaseSticker baseSticker) {
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
            ImageView imageView = this.this$0.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = this.this$0.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setContentDescription(this.this$0.c(this.$sticker));
            if (numComponent2 != null && numComponent2.intValue() == 0) {
                StickerView stickerView = this.this$0;
                stickerView.apngLoadingJob = StickerView.a(stickerView, ((DownloadUtils.DownloadState.Completed) downloadStateComponent1).getFile(), true);
            } else if (numComponent2 != null && numComponent2.intValue() == 1) {
                SimpleDraweeView simpleDraweeView2 = this.this$0.binding.f191b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerViewImageview");
                MGImages.setImage$default(simpleDraweeView2, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, this.$sticker, null, false, 2, null), 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = this.this$0.binding.f191b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerViewImageview");
                ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView3, new StickerView4(this, downloadStateComponent1));
            } else if (numComponent2 != null && numComponent2.intValue() == 2) {
                SimpleDraweeView simpleDraweeView4 = this.this$0.binding.f191b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.stickerViewImageview");
                MGImages.setImage$default(simpleDraweeView4, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, this.$sticker, null, false, 2, null), 0, 0, false, null, null, 124, null);
                this.this$0.binding.f191b.setOnLongClickListener(null);
            }
        }
        return Unit.a;
    }
}
