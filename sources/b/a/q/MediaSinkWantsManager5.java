package b.a.q;

import b.d.b.a.outline;
import com.discord.rtcconnection.MediaSinkWantsManager;
import d0.t.Iterables2;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.j, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager5(MediaSinkWantsManager mediaSinkWantsManager, Long l) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$userId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ArrayList arrayList = new ArrayList();
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Long l = mediaSinkWantsManager.e;
        if (l != null) {
            if (l.longValue() != mediaSinkWantsManager.h) {
                arrayList.add(l);
            }
        }
        Long l2 = this.$userId;
        if (l2 == null) {
            this.this$0.e = null;
        } else {
            if (!this.this$0.c.contains(l2)) {
                long j = this.this$0.h;
                Long l3 = this.$userId;
                if (l3 != null && j == l3.longValue()) {
                    this.this$0.e = this.$userId;
                } else {
                    MediaSinkWantsManager mediaSinkWantsManager2 = this.this$0;
                    StringBuilder sbU = outline.U("Participant not found: ");
                    sbU.append(this.$userId);
                    mediaSinkWantsManager2.a(sbU.toString());
                }
                return Unit.a;
            }
            MediaSinkWantsManager mediaSinkWantsManager3 = this.this$0;
            Long l4 = this.$userId;
            mediaSinkWantsManager3.e = l4;
            arrayList.add(l4);
        }
        MediaSinkWantsManager mediaSinkWantsManager4 = this.this$0;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((Number) it.next()).longValue()));
        }
        mediaSinkWantsManager4.d(arrayList2);
        return Unit.a;
    }
}
