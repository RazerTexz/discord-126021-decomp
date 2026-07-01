package b.i.c.x;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.x.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultUserAgentPublisher2 implements UserAgentPublisher {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GlobalLibraryVersionRegistrar f1803b;

    public DefaultUserAgentPublisher2(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.a = a(set);
        this.f1803b = globalLibraryVersionRegistrar;
    }

    public static String a(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion next = it.next();
            sb.append(next.a());
            sb.append(MentionUtils.SLASH_CHAR);
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // b.i.c.x.UserAgentPublisher
    public String getUserAgent() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.f1803b;
        synchronized (globalLibraryVersionRegistrar.f1804b) {
            setUnmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.f1804b);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(' ');
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = this.f1803b;
        synchronized (globalLibraryVersionRegistrar2.f1804b) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar2.f1804b);
        }
        sb.append(a(setUnmodifiableSet2));
        return sb.toString();
    }
}
