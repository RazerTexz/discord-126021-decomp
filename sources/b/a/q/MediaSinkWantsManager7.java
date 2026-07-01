package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.socket.io.Payloads;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.l, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager7 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ List $ssrcs;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager7(MediaSinkWantsManager mediaSinkWantsManager, List list, long j) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$ssrcs = list;
        this.$userId = j;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager9 mediaSinkWantsManager9;
        boolean z2;
        List list = this.$ssrcs;
        ArrayList<Payloads.Stream> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Payloads.Stream stream = (Payloads.Stream) next;
            Boolean active = stream.getActive();
            if (active != null ? active.booleanValue() : false) {
                Integer ssrc = stream.getSsrc();
                z2 = (ssrc != null ? ssrc.intValue() : 0) > 0;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (Payloads.Stream stream2 : arrayList) {
            Integer quality = stream2.getQuality();
            VideoMetadata videoMetadata = null;
            if (quality != null) {
                int iIntValue = quality.intValue();
                Objects.requireNonNull(MediaSinkWantsManager9.INSTANCE);
                MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues = MediaSinkWantsManager9.values();
                int i = 0;
                while (true) {
                    if (i >= 11) {
                        mediaSinkWantsManager9 = null;
                        break;
                    }
                    mediaSinkWantsManager9 = mediaSinkWantsManager9ArrValues[i];
                    if (mediaSinkWantsManager9.getValue() == iIntValue) {
                        break;
                    }
                    i++;
                }
                if (mediaSinkWantsManager9 == null) {
                    mediaSinkWantsManager9 = MediaSinkWantsManager9.Hundred;
                }
            } else {
                mediaSinkWantsManager9 = MediaSinkWantsManager9.Hundred;
            }
            Integer ssrc2 = stream2.getSsrc();
            Intrinsics3.checkNotNull(ssrc2);
            long jIntValue = ssrc2.intValue();
            MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
            long j = this.$userId;
            Objects.requireNonNull(mediaSinkWantsManager);
            if (stream2.getMaxResolution() != null) {
                videoMetadata = new VideoMetadata(j, stream2.getMaxResolution().getWidth(), stream2.getMaxResolution().getHeight(), stream2.getMaxFrameRate(), stream2.getMaxResolution().getType());
            } else {
                mediaSinkWantsManager.a("metadataOf: " + stream2 + " has no maxResolution!");
            }
            arrayList2.add(new MediaSinkWantsManager.b(mediaSinkWantsManager9, jIntValue, videoMetadata));
        }
        if (arrayList2.isEmpty()) {
            this.this$0.f2771b.remove(Long.valueOf(this.$userId));
            this.this$0.c.remove(Long.valueOf(this.$userId));
        } else {
            this.this$0.f2771b.put(Long.valueOf(this.$userId), arrayList2);
            this.this$0.c.add(Long.valueOf(this.$userId));
        }
        this.this$0.d(arrayList2.isEmpty() ? Collections2.emptyList() : CollectionsJVM.listOf(String.valueOf(this.$userId)));
        return Unit.a;
    }
}
