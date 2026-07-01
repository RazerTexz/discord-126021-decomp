package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ MediaEngineConnection $connection;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(MediaSinkWantsManager mediaSinkWantsManager, MediaEngineConnection mediaEngineConnection) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$connection = mediaEngineConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        MediaEngineConnection mediaEngineConnection = mediaSinkWantsManager.d;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.o(mediaSinkWantsManager);
        }
        MediaSinkWantsManager mediaSinkWantsManager2 = this.this$0;
        MediaEngineConnection mediaEngineConnection2 = this.$connection;
        mediaSinkWantsManager2.d = mediaEngineConnection2;
        if (mediaEngineConnection2 != null) {
            mediaEngineConnection2.l(mediaSinkWantsManager2);
        }
        if (this.$connection != null) {
            MediaSinkWantsManager mediaSinkWantsManager3 = this.this$0;
            Set<Long> setKeySet = mediaSinkWantsManager3.f2771b.keySet();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Number) it.next()).longValue()));
            }
            mediaSinkWantsManager3.d(arrayList);
        }
        return Unit.a;
    }
}
