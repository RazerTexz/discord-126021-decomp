package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.l */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1234l extends AbstractC12240o implements Function1<MediaEngine.InterfaceC5642c, Unit> {

    /* JADX INFO: renamed from: j */
    public static final C1234l f1748j = new C1234l();

    public C1234l() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine.InterfaceC5642c interfaceC5642c) {
        MediaEngine.InterfaceC5642c interfaceC5642c2 = interfaceC5642c;
        C12238m.checkNotNullParameter(interfaceC5642c2, "it");
        interfaceC5642c2.onConnected();
        return Unit.f27425a;
    }
}
