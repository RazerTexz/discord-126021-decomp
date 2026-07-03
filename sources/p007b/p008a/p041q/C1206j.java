package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.j */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1206j extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1206j(MediaSinkWantsManager mediaSinkWantsManager, Long l) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$userId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ArrayList arrayList = new ArrayList();
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Long l = mediaSinkWantsManager.f18746e;
        if (l != null) {
            if (l.longValue() != mediaSinkWantsManager.f18749h) {
                arrayList.add(l);
            }
        }
        Long l2 = this.$userId;
        if (l2 == null) {
            this.this$0.f18746e = null;
        } else {
            if (!this.this$0.f18744c.contains(l2)) {
                long j = this.this$0.f18749h;
                Long l3 = this.$userId;
                if (l3 != null && j == l3.longValue()) {
                    this.this$0.f18746e = this.$userId;
                } else {
                    MediaSinkWantsManager mediaSinkWantsManager2 = this.this$0;
                    StringBuilder sbM833U = C1643a.m833U("Participant not found: ");
                    sbM833U.append(this.$userId);
                    mediaSinkWantsManager2.m8453a(sbM833U.toString());
                }
                return Unit.f27425a;
            }
            MediaSinkWantsManager mediaSinkWantsManager3 = this.this$0;
            Long l4 = this.$userId;
            mediaSinkWantsManager3.f18746e = l4;
            arrayList.add(l4);
        }
        MediaSinkWantsManager mediaSinkWantsManager4 = this.this$0;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((Number) it.next()).longValue()));
        }
        mediaSinkWantsManager4.m8456d(arrayList2);
        return Unit.f27425a;
    }
}
