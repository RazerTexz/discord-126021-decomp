package b.a.y.j0;

import android.graphics.Point;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.discord.views.calls.AppVideoStreamRenderer;
import com.discord.views.calls.VideoCallParticipantView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.j0.o, reason: use source file name */
/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView7 extends Lambda implements Function1<Point, Unit> {
    public final /* synthetic */ VideoCallParticipantView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallParticipantView7(VideoCallParticipantView videoCallParticipantView) {
        super(1);
        this.this$0 = videoCallParticipantView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Point point) {
        Point point2 = point;
        Intrinsics3.checkNotNullParameter(point2, "it");
        VideoCallParticipantView videoCallParticipantView = this.this$0;
        AppVideoStreamRenderer appVideoStreamRenderer = videoCallParticipantView.binding.q;
        Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
        appVideoStreamRenderer.setVisibility(0);
        View view = videoCallParticipantView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
        view.setVisibility(0);
        ProgressBar progressBar = videoCallParticipantView.binding.p;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
        progressBar.setVisibility(8);
        SimpleDraweeView simpleDraweeView = videoCallParticipantView.binding.m;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
        simpleDraweeView.setVisibility(8);
        TextView textView = videoCallParticipantView.binding.n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.participantStreamPreviewText");
        textView.setVisibility(8);
        boolean z2 = (point2.x > point2.y) != (videoCallParticipantView.getWidth() > videoCallParticipantView.getHeight());
        if (videoCallParticipantView.matchVideoOrientation && z2) {
            int height = videoCallParticipantView.getHeight();
            videoCallParticipantView.getLayoutParams().height = videoCallParticipantView.getWidth();
            videoCallParticipantView.getLayoutParams().width = height;
        }
        return Unit.a;
    }
}
