package p007b.p225i.p226a.p288f.p292c.p293a.p295e;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p313h.p315b.C3449i;

/* JADX INFO: renamed from: b.i.a.f.c.a.e.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3195a extends C3267b<C3266a.d.c> {

    /* JADX INFO: renamed from: j */
    public static final C3266a.g<C3449i> f9221j;

    /* JADX INFO: renamed from: k */
    public static final C3266a.a<C3449i, C3266a.d.c> f9222k;

    /* JADX INFO: renamed from: l */
    public static final C3266a<C3266a.d.c> f9223l;

    static {
        C3266a.g<C3449i> gVar = new C3266a.g<>();
        f9221j = gVar;
        C3196b c3196b = new C3196b();
        f9222k = c3196b;
        f9223l = new C3266a<>("SmsRetriever.API", c3196b, gVar);
    }

    public AbstractC3195a(@NonNull Context context) {
        super(context, f9223l, (C3266a.d) null, C3267b.a.f9335a);
    }
}
