package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MediaSinkWantsManager mediaSinkWantsManager) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager.e(this.this$0, null, 1);
        return Unit.a;
    }
}
