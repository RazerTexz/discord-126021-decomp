package b.a.y.q0;

import android.view.View;
import com.discord.utilities.file.DownloadUtils$DownloadState;
import com.discord.utilities.file.DownloadUtils$DownloadState$Completed;
import com.discord.views.sticker.StickerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends o implements Function1<View, Unit> {
    public final /* synthetic */ DownloadUtils$DownloadState $downloadState;
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, DownloadUtils$DownloadState downloadUtils$DownloadState) {
        super(1);
        this.this$0 = dVar;
        this.$downloadState = downloadUtils$DownloadState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        m.checkNotNullParameter(view, "it");
        StickerView stickerView = this.this$0.this$0;
        stickerView.apngLoadingJob = StickerView.a(stickerView, ((DownloadUtils$DownloadState$Completed) this.$downloadState).getFile(), true);
        return Unit.a;
    }
}
