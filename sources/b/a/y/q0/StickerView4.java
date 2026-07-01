package b.a.y.q0;

import android.view.View;
import com.discord.utilities.file.DownloadUtils;
import com.discord.views.sticker.StickerView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.q0.c, reason: use source file name */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ DownloadUtils.DownloadState $downloadState;
    public final /* synthetic */ StickerView5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView4(StickerView5 stickerView5, DownloadUtils.DownloadState downloadState) {
        super(1);
        this.this$0 = stickerView5;
        this.$downloadState = downloadState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        StickerView stickerView = this.this$0.this$0;
        stickerView.apngLoadingJob = StickerView.a(stickerView, ((DownloadUtils.DownloadState.Completed) this.$downloadState).getFile(), true);
        return Unit.a;
    }
}
