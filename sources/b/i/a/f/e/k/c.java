package b.i.a.f.e.k;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final Account a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Scope> f1380b;
    public final Set<Scope> c;
    public final Map<b.i.a.f.e.h.a<?>, b> d;
    public final String e;
    public final String f;
    public final b.i.a.f.l.a g;
    public Integer h;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class a {
        public Account a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArraySet<Scope> f1381b;
        public String c;
        public String d;

        public final c a() {
            return new c(this.a, this.f1381b, null, 0, null, this.c, this.d, b.i.a.f.l.a.j);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class b {
    }

    public c(Account account, Set set, Map map, int i, View view, String str, String str2, b.i.a.f.l.a aVar) {
        this.a = account;
        Set<Scope> setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f1380b = setEmptySet;
        Map<b.i.a.f.e.h.a<?>, b> mapEmptyMap = Collections.emptyMap();
        this.d = mapEmptyMap;
        this.e = str;
        this.f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator<b> it = mapEmptyMap.values().iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
            hashSet.addAll(null);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }
}
