package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MediaSinkWantsManager mediaSinkWantsManager) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Objects.requireNonNull(mediaSinkWantsManager);
        mediaSinkWantsManager.b(new i(mediaSinkWantsManager, null));
        this.this$0.a.clear();
        this.this$0.f2771b.clear();
        return Unit.a;
    }
}
