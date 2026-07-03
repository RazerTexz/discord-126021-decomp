package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.g */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1200g extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1200g(MediaSinkWantsManager mediaSinkWantsManager) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Objects.requireNonNull(mediaSinkWantsManager);
        mediaSinkWantsManager.m8454b(new C1204i(mediaSinkWantsManager, null));
        this.this$0.f18742a.clear();
        this.this$0.f18743b.clear();
        return Unit.f27425a;
    }
}
