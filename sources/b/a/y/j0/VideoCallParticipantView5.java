package b.a.y.j0;

import com.discord.views.calls.VideoCallParticipantView;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.j0.m, reason: use source file name */
/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView5 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ VideoCallParticipantView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallParticipantView5(VideoCallParticipantView videoCallParticipantView) {
        super(1);
        this.this$0 = videoCallParticipantView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Integer num2 = num;
        if (num2 != null) {
            this.this$0.binding.f127b.setBackgroundColor(num2.intValue());
        }
        return Unit.a;
    }
}
