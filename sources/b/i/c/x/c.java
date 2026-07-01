package b.i.c.x;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements h {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1803b;

    public c(Set<e> set, d dVar) {
        this.a = a(set);
        this.f1803b = dVar;
    }

    public static String a(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.a());
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // b.i.c.x.h
    public String getUserAgent() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        d dVar = this.f1803b;
        synchronized (dVar.f1804b) {
            setUnmodifiableSet = Collections.unmodifiableSet(dVar.f1804b);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(' ');
        d dVar2 = this.f1803b;
        synchronized (dVar2.f1804b) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(dVar2.f1804b);
        }
        sb.append(a(setUnmodifiableSet2));
        return sb.toString();
    }
}
