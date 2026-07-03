package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.k */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1208k extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ boolean $sendVideo;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1208k(MediaSinkWantsManager mediaSinkWantsManager, boolean z2) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$sendVideo = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Objects.requireNonNull(this.this$0);
        MediaSinkWantsManager.m8452e(this.this$0, null, 1);
        return Unit.f27425a;
    }
}
