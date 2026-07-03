package p007b.p195g.p196a.p198b.p204t;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.b.t.j */
/* JADX INFO: compiled from: Separators.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2148j implements Serializable {
    private static final long serialVersionUID = 1;
    private final char objectFieldValueSeparator = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
    private final char objectEntrySeparator = ',';
    private final char arrayValueSeparator = ',';

    /* JADX INFO: renamed from: a */
    public char m1736a() {
        return this.arrayValueSeparator;
    }

    /* JADX INFO: renamed from: b */
    public char m1737b() {
        return this.objectEntrySeparator;
    }

    /* JADX INFO: renamed from: c */
    public char m1738c() {
        return this.objectFieldValueSeparator;
    }
}
