package p007b.p008a.p062y.p063j0;

import android.graphics.Point;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.discord.views.calls.AppVideoStreamRenderer;
import com.discord.views.calls.VideoCallParticipantView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.j0.o */
/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1352o extends AbstractC12240o implements Function1<Point, Unit> {
    public final /* synthetic */ VideoCallParticipantView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1352o(VideoCallParticipantView videoCallParticipantView) {
        super(1);
        this.this$0 = videoCallParticipantView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Point point) {
        Point point2 = point;
        C12238m.checkNotNullParameter(point2, "it");
        VideoCallParticipantView videoCallParticipantView = this.this$0;
        AppVideoStreamRenderer appVideoStreamRenderer = videoCallParticipantView.binding.f928q;
        C12238m.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
        appVideoStreamRenderer.setVisibility(0);
        View view = videoCallParticipantView.binding.f914c;
        C12238m.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
        view.setVisibility(0);
        ProgressBar progressBar = videoCallParticipantView.binding.f927p;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
        progressBar.setVisibility(8);
        SimpleDraweeView simpleDraweeView = videoCallParticipantView.binding.f924m;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
        simpleDraweeView.setVisibility(8);
        TextView textView = videoCallParticipantView.binding.f925n;
        C12238m.checkNotNullExpressionValue(textView, "binding.participantStreamPreviewText");
        textView.setVisibility(8);
        boolean z2 = (point2.x > point2.y) != (videoCallParticipantView.getWidth() > videoCallParticipantView.getHeight());
        if (videoCallParticipantView.matchVideoOrientation && z2) {
            int height = videoCallParticipantView.getHeight();
            videoCallParticipantView.getLayoutParams().height = videoCallParticipantView.getWidth();
            videoCallParticipantView.getLayoutParams().width = height;
        }
        return Unit.f27425a;
    }
}
