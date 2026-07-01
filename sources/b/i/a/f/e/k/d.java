package b.i.a.f.e.k;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T extends IInterface> extends b<T> implements a.f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f1382x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set<Scope> f1383y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public final Account f1384z;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, Looper looper, int i, c cVar, b.i.a.f.e.h.j.f fVar, b.i.a.f.e.h.j.l lVar) {
        e eVarA = e.a(context);
        Object obj = GoogleApiAvailability.c;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.d;
        Objects.requireNonNull(fVar, "null reference");
        Objects.requireNonNull(lVar, "null reference");
        super(context, looper, eVarA, googleApiAvailability, i, new q(fVar), new p(lVar), cVar.f);
        this.f1382x = cVar;
        this.f1384z = cVar.a;
        Set<Scope> set = cVar.c;
        Iterator<Scope> it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f1383y = set;
    }

    @Override // b.i.a.f.e.h.a.f
    @NonNull
    public Set<Scope> a() {
        return o() ? this.f1383y : Collections.emptySet();
    }

    @Override // b.i.a.f.e.k.b
    @Nullable
    public final Account s() {
        return this.f1384z;
    }

    @Override // b.i.a.f.e.k.b
    public final Set<Scope> v() {
        return this.f1383y;
    }
}
