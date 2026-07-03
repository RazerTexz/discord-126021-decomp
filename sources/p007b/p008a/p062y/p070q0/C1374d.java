package p007b.p008a.p062y.p070q0;

import android.widget.ImageView;
import com.discord.api.sticker.BaseSticker;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.q0.d */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1374d extends AbstractC12240o implements Function1<Pair<? extends DownloadUtils.DownloadState, ? extends Integer>, Unit> {
    public final /* synthetic */ Integer $localAnimationSettings;
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1374d(StickerView stickerView, Integer num, BaseSticker baseSticker) {
        super(1);
        this.this$0 = stickerView;
        this.$localAnimationSettings = num;
        this.$sticker = baseSticker;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends DownloadUtils.DownloadState, ? extends Integer> pair) {
        Pair<? extends DownloadUtils.DownloadState, ? extends Integer> pair2 = pair;
        DownloadUtils.DownloadState downloadStateComponent1 = pair2.component1();
        Integer numComponent2 = pair2.component2();
        if (downloadStateComponent1 instanceof DownloadUtils.DownloadState.Completed) {
            Integer num = this.$localAnimationSettings;
            if (num != null) {
                numComponent2 = num;
            }
            ImageView imageView = this.this$0.binding.f1179d;
            C12238m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = this.this$0.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setContentDescription(this.this$0.m8615c(this.$sticker));
            if (numComponent2 != null && numComponent2.intValue() == 0) {
                StickerView stickerView = this.this$0;
                stickerView.apngLoadingJob = StickerView.m8612a(stickerView, ((DownloadUtils.DownloadState.Completed) downloadStateComponent1).getFile(), true);
            } else if (numComponent2 != null && numComponent2.intValue() == 1) {
                SimpleDraweeView simpleDraweeView2 = this.this$0.binding.f1177b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerViewImageview");
                MGImages.setImage$default(simpleDraweeView2, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, this.$sticker, null, false, 2, null), 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = this.this$0.binding.f1177b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerViewImageview");
                ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView3, new C1373c(this, downloadStateComponent1));
            } else if (numComponent2 != null && numComponent2.intValue() == 2) {
                SimpleDraweeView simpleDraweeView4 = this.this$0.binding.f1177b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.stickerViewImageview");
                MGImages.setImage$default(simpleDraweeView4, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, this.$sticker, null, false, 2, null), 0, 0, false, null, null, 124, null);
                this.this$0.binding.f1177b.setOnLongClickListener(null);
            }
        }
        return Unit.f27425a;
    }
}
