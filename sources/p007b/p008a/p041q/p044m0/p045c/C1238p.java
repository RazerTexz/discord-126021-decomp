package p007b.p008a.p041q.p044m0.p045c;

import com.hammerandchisel.libdiscord.Discord;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.webrtc.MediaStreamTrack;
import p007b.p008a.p041q.p044m0.C1221a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;

/* JADX INFO: renamed from: b.a.q.m0.c.p */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1238p implements Discord.GetSupportedVideoCodecsCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1239q f1751a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Emitter f1752b;

    public C1238p(C1239q c1239q, Emitter emitter) {
        this.f1751a = c1239q;
        this.f1752b = emitter;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetSupportedVideoCodecsCallback
    public final void onSupportedVideoCodecs(String[] strArr) {
        C12238m.checkNotNullParameter(strArr, "videoCodecsStringArray");
        C1233k c1233k = this.f1751a.f1753j;
        Set<String> set = C1233k.f1721a;
        Objects.requireNonNull(c1233k);
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        for (String str : strArr) {
            Locale locale = Locale.ROOT;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String upperCase = str.toUpperCase(locale);
            C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            arrayList.add(upperCase);
        }
        List listSortedWith = C12163u.sortedWith(arrayList, new C1236n());
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listSortedWith, 10));
        for (Object obj : listSortedWith) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            int i3 = (i * 2) + 101;
            arrayList2.add(new C1221a((String) obj, i2, MediaStreamTrack.VIDEO_TRACK_KIND, i3, Integer.valueOf(i3 + 1)));
            i = i2;
        }
        this.f1752b.onNext(arrayList2);
        this.f1752b.onCompleted();
    }
}
