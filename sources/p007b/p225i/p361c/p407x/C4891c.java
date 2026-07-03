package p007b.p225i.p361c.p407x;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.x.c */
/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4891c implements InterfaceC4896h {

    /* JADX INFO: renamed from: a */
    public final String f13082a;

    /* JADX INFO: renamed from: b */
    public final C4892d f13083b;

    public C4891c(Set<AbstractC4893e> set, C4892d c4892d) {
        this.f13082a = m6845a(set);
        this.f13083b = c4892d;
    }

    /* JADX INFO: renamed from: a */
    public static String m6845a(Set<AbstractC4893e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<AbstractC4893e> it = set.iterator();
        while (it.hasNext()) {
            AbstractC4893e next = it.next();
            sb.append(next.mo6843a());
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(next.mo6844b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // p007b.p225i.p361c.p407x.InterfaceC4896h
    public String getUserAgent() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        C4892d c4892d = this.f13083b;
        synchronized (c4892d.f13085b) {
            setUnmodifiableSet = Collections.unmodifiableSet(c4892d.f13085b);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return this.f13082a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13082a);
        sb.append(' ');
        C4892d c4892d2 = this.f13083b;
        synchronized (c4892d2.f13085b) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(c4892d2.f13085b);
        }
        sb.append(m6845a(setUnmodifiableSet2));
        return sb.toString();
    }
}
