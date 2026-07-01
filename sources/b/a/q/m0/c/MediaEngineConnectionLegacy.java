package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.q.m0.c.a, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
    public final /* synthetic */ MediaEngineConnection.ConnectionState $value;
    public final /* synthetic */ MediaEngineConnectionLegacy5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEngineConnectionLegacy(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5, MediaEngineConnection.ConnectionState connectionState) {
        super(1);
        this.this$0 = mediaEngineConnectionLegacy5;
        this.$value = connectionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.d dVar) {
        MediaEngineConnection.d dVar2 = dVar;
        Intrinsics3.checkNotNullParameter(dVar2, "it");
        dVar2.onConnectionStateChange(this.this$0, this.$value);
        return Unit.a;
    }
}
