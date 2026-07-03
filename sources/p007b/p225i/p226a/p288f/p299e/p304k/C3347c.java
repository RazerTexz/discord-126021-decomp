package p007b.p225i.p226a.p288f.p299e.p304k;

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
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p337l.C4335a;

/* JADX INFO: renamed from: b.i.a.f.e.k.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3347c {

    /* JADX INFO: renamed from: a */
    public final Account f9501a;

    /* JADX INFO: renamed from: b */
    public final Set<Scope> f9502b;

    /* JADX INFO: renamed from: c */
    public final Set<Scope> f9503c;

    /* JADX INFO: renamed from: d */
    public final Map<C3266a<?>, b> f9504d;

    /* JADX INFO: renamed from: e */
    public final String f9505e;

    /* JADX INFO: renamed from: f */
    public final String f9506f;

    /* JADX INFO: renamed from: g */
    public final C4335a f9507g;

    /* JADX INFO: renamed from: h */
    public Integer f9508h;

    /* JADX INFO: renamed from: b.i.a.f.e.k.c$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public Account f9509a;

        /* JADX INFO: renamed from: b */
        public ArraySet<Scope> f9510b;

        /* JADX INFO: renamed from: c */
        public String f9511c;

        /* JADX INFO: renamed from: d */
        public String f9512d;

        /* JADX INFO: renamed from: a */
        public final C3347c m4148a() {
            return new C3347c(this.f9509a, this.f9510b, null, 0, null, this.f9511c, this.f9512d, C4335a.f11447j);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.k.c$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static final class b {
    }

    public C3347c(Account account, Set set, Map map, int i, View view, String str, String str2, C4335a c4335a) {
        this.f9501a = account;
        Set<Scope> setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f9502b = setEmptySet;
        Map<C3266a<?>, b> mapEmptyMap = Collections.emptyMap();
        this.f9504d = mapEmptyMap;
        this.f9505e = str;
        this.f9506f = str2;
        this.f9507g = c4335a;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator<b> it = mapEmptyMap.values().iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
            hashSet.addAll(null);
        }
        this.f9503c = Collections.unmodifiableSet(hashSet);
    }
}
