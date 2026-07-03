package p007b.p008a.p062y.p070q0;

import android.view.View;
import com.discord.utilities.file.DownloadUtils;
import com.discord.views.sticker.StickerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.q0.c */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1373c extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ DownloadUtils.DownloadState $downloadState;
    public final /* synthetic */ C1374d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1373c(C1374d c1374d, DownloadUtils.DownloadState downloadState) {
        super(1);
        this.this$0 = c1374d;
        this.$downloadState = downloadState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        C12238m.checkNotNullParameter(view, "it");
        StickerView stickerView = this.this$0.this$0;
        stickerView.apngLoadingJob = StickerView.m8612a(stickerView, ((DownloadUtils.DownloadState.Completed) this.$downloadState).getFile(), true);
        return Unit.f27425a;
    }
}
