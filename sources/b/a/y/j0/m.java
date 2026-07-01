package b.a.y.j0;

import com.discord.views.calls.VideoCallParticipantView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends d0.z.d.o implements Function1<Integer, Unit> {
    public final /* synthetic */ VideoCallParticipantView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(VideoCallParticipantView videoCallParticipantView) {
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
