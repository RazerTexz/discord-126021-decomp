package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.a */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1223a extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
    public final /* synthetic */ MediaEngineConnection.ConnectionState $value;
    public final /* synthetic */ C1227e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1223a(C1227e c1227e, MediaEngineConnection.ConnectionState connectionState) {
        super(1);
        this.this$0 = c1227e;
        this.$value = connectionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
        C12238m.checkNotNullParameter(interfaceC5648d2, "it");
        interfaceC5648d2.onConnectionStateChange(this.this$0, this.$value);
        return Unit.f27425a;
    }
}
