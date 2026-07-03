package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.Connection;
import co.discord.media_engine.StreamParameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.b */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1224b implements Connection.OnVideoCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1227e f1695a;

    /* JADX INFO: renamed from: b.a.q.m0.c.b$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ int $ssrc;
        public final /* synthetic */ String $streamIdentifier;
        public final /* synthetic */ StreamParameters[] $streams;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, String str, StreamParameters[] streamParametersArr) {
            super(0);
            this.$userId = j;
            this.$ssrc = i;
            this.$streamIdentifier = str;
            this.$streams = streamParametersArr;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            C1227e c1227e = C1224b.this.f1695a;
            long j = this.$userId;
            int i = this.$ssrc;
            String str = this.$streamIdentifier;
            StreamParameters[] streamParametersArr = this.$streams;
            c1227e.f1702e.put(Long.valueOf(j), Long.valueOf(i));
            c1227e.m318y(new C1230h(c1227e, j, str, i, streamParametersArr));
            return Unit.f27425a;
        }
    }

    public C1224b(C1227e c1227e) {
        this.f1695a = c1227e;
    }

    @Override // co.discord.media_engine.Connection.OnVideoCallback
    public void onVideo(long j, int i, String str, StreamParameters[] streamParametersArr) {
        C12238m.checkNotNullParameter(str, "streamIdentifier");
        C12238m.checkNotNullParameter(streamParametersArr, "streams");
        C1227e.m294x(this.f1695a, new a(j, i, str, streamParametersArr));
    }
}
