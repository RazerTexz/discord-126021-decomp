package b.i.a.c.x2.i0;

import b.i.b.a.CharMatcher;
import b.i.b.a.Splitter2;
import b.i.b.a.Splitter3;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.k, reason: use source file name */
/* JADX INFO: compiled from: SefReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SefReader {
    public static final Splitter3 a = new Splitter3(new Splitter2(new CharMatcher.b(MentionUtils.EMOJIS_AND_STICKERS_CHAR)));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Splitter3 f1228b = new Splitter3(new Splitter2(new CharMatcher.b('*')));
    public final List<a> c = new ArrayList();
    public int d = 0;
    public int e;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.k$a */
    /* JADX INFO: compiled from: SefReader.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1229b;

        public a(int i, long j, int i2) {
            this.a = j;
            this.f1229b = i2;
        }
    }
}
