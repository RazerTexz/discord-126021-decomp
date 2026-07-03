package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.i */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1204i extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ MediaEngineConnection $connection;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1204i(MediaSinkWantsManager mediaSinkWantsManager, MediaEngineConnection mediaEngineConnection) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$connection = mediaEngineConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        MediaEngineConnection mediaEngineConnection = mediaSinkWantsManager.f18745d;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo309o(mediaSinkWantsManager);
        }
        MediaSinkWantsManager mediaSinkWantsManager2 = this.this$0;
        MediaEngineConnection mediaEngineConnection2 = this.$connection;
        mediaSinkWantsManager2.f18745d = mediaEngineConnection2;
        if (mediaEngineConnection2 != null) {
            mediaEngineConnection2.mo306l(mediaSinkWantsManager2);
        }
        if (this.$connection != null) {
            MediaSinkWantsManager mediaSinkWantsManager3 = this.this$0;
            Set<Long> setKeySet = mediaSinkWantsManager3.f18743b.keySet();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Number) it.next()).longValue()));
            }
            mediaSinkWantsManager3.m8456d(arrayList);
        }
        return Unit.f27425a;
    }
}
