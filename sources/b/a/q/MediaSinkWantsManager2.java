package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.g, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager2(MediaSinkWantsManager mediaSinkWantsManager) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Objects.requireNonNull(mediaSinkWantsManager);
        mediaSinkWantsManager.b(new MediaSinkWantsManager4(mediaSinkWantsManager, null));
        this.this$0.a.clear();
        this.this$0.f2771b.clear();
        return Unit.a;
    }
}
