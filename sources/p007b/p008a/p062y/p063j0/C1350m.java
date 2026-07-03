package p007b.p008a.p062y.p063j0;

import com.discord.views.calls.VideoCallParticipantView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.y.j0.m */
/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1350m extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ VideoCallParticipantView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1350m(VideoCallParticipantView videoCallParticipantView) {
        super(1);
        this.this$0 = videoCallParticipantView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Integer num2 = num;
        if (num2 != null) {
            this.this$0.binding.f913b.setBackgroundColor(num2.intValue());
        }
        return Unit.f27425a;
    }
}
