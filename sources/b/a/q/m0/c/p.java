package b.a.q.m0.c;

import com.hammerandchisel.libdiscord.Discord$GetSupportedVideoCodecsCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.webrtc.MediaStreamTrack;
import rx.Emitter;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Discord$GetSupportedVideoCodecsCallback {
    public final /* synthetic */ q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Emitter f273b;

    public p(q qVar, Emitter emitter) {
        this.a = qVar;
        this.f273b = emitter;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$GetSupportedVideoCodecsCallback
    public final void onSupportedVideoCodecs(String[] strArr) {
        d0.z.d.m.checkNotNullParameter(strArr, "videoCodecsStringArray");
        k kVar = this.a.j;
        Set<String> set = k.a;
        Objects.requireNonNull(kVar);
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        for (String str : strArr) {
            Locale locale = Locale.ROOT;
            d0.z.d.m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String upperCase = str.toUpperCase(locale);
            d0.z.d.m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            arrayList.add(upperCase);
        }
        List listSortedWith = d0.t.u.sortedWith(arrayList, new n());
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(listSortedWith, 10));
        for (Object obj : listSortedWith) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            int i3 = (i * 2) + 101;
            arrayList2.add(new b.a.q.m0.a((String) obj, i2, MediaStreamTrack.VIDEO_TRACK_KIND, i3, Integer.valueOf(i3 + 1)));
            i = i2;
        }
        this.f273b.onNext(arrayList2);
        this.f273b.onCompleted();
    }
}
