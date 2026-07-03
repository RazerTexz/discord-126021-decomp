package p007b.p225i.p226a.p288f.p299e.p304k;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l;

/* JADX INFO: renamed from: b.i.a.f.e.k.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3349d<T extends IInterface> extends AbstractC3345b<T> implements C3266a.f {

    /* JADX INFO: renamed from: x */
    public final C3347c f9513x;

    /* JADX INFO: renamed from: y */
    public final Set<Scope> f9514y;

    /* JADX INFO: renamed from: z */
    @Nullable
    public final Account f9515z;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC3349d(Context context, Looper looper, int i, C3347c c3347c, InterfaceC3290f interfaceC3290f, InterfaceC3303l interfaceC3303l) {
        AbstractC3351e abstractC3351eM4152a = AbstractC3351e.m4152a(context);
        Object obj = GoogleApiAvailability.f20480c;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f20481d;
        Objects.requireNonNull(interfaceC3290f, "null reference");
        Objects.requireNonNull(interfaceC3303l, "null reference");
        super(context, looper, abstractC3351eM4152a, googleApiAvailability, i, new C3375q(interfaceC3290f), new C3373p(interfaceC3303l), c3347c.f9506f);
        this.f9513x = c3347c;
        this.f9515z = c3347c.f9501a;
        Set<Scope> set = c3347c.f9503c;
        Iterator<Scope> it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f9514y = set;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Set<Scope> mo4030a() {
        return mo4042o() ? this.f9514y : Collections.emptySet();
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @Nullable
    /* JADX INFO: renamed from: s */
    public final Account mo4138s() {
        return this.f9515z;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* JADX INFO: renamed from: v */
    public final Set<Scope> mo4141v() {
        return this.f9514y;
    }
}
