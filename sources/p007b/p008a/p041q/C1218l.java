package p007b.p008a.p041q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.socket.p499io.Payloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.l */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1218l extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ List $ssrcs;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1218l(MediaSinkWantsManager mediaSinkWantsManager, List list, long j) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$ssrcs = list;
        this.$userId = j;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        EncodeQuality encodeQuality;
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
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        for (Payloads.Stream stream2 : arrayList) {
            Integer quality = stream2.getQuality();
            VideoMetadata videoMetadata = null;
            if (quality != null) {
                int iIntValue = quality.intValue();
                Objects.requireNonNull(EncodeQuality.INSTANCE);
                EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
                int i = 0;
                while (true) {
                    if (i >= 11) {
                        encodeQuality = null;
                        break;
                    }
                    encodeQuality = encodeQualityArrValues[i];
                    if (encodeQuality.getValue() == iIntValue) {
                        break;
                    }
                    i++;
                }
                if (encodeQuality == null) {
                    encodeQuality = EncodeQuality.Hundred;
                }
            } else {
                encodeQuality = EncodeQuality.Hundred;
            }
            Integer ssrc2 = stream2.getSsrc();
            C12238m.checkNotNull(ssrc2);
            long jIntValue = ssrc2.intValue();
            MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
            long j = this.$userId;
            Objects.requireNonNull(mediaSinkWantsManager);
            if (stream2.getMaxResolution() != null) {
                videoMetadata = new VideoMetadata(j, stream2.getMaxResolution().getWidth(), stream2.getMaxResolution().getHeight(), stream2.getMaxFrameRate(), stream2.getMaxResolution().getType());
            } else {
                mediaSinkWantsManager.m8453a("metadataOf: " + stream2 + " has no maxResolution!");
            }
            arrayList2.add(new MediaSinkWantsManager.C5603b(encodeQuality, jIntValue, videoMetadata));
        }
        if (arrayList2.isEmpty()) {
            this.this$0.f18743b.remove(Long.valueOf(this.$userId));
            this.this$0.f18744c.remove(Long.valueOf(this.$userId));
        } else {
            this.this$0.f18743b.put(Long.valueOf(this.$userId), arrayList2);
            this.this$0.f18744c.add(Long.valueOf(this.$userId));
        }
        this.this$0.m8456d(arrayList2.isEmpty() ? C12147n.emptyList() : C12145m.listOf(String.valueOf(this.$userId)));
        return Unit.f27425a;
    }
}
