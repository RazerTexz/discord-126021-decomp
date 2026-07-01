package b.g.a.b.t;

import com.discord.widgets.chat.input.MentionUtils;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.b.t.j, reason: use source file name */
/* JADX INFO: compiled from: Separators.java */
/* JADX INFO: loaded from: classes3.dex */
public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final char objectFieldValueSeparator = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
    private final char objectEntrySeparator = ',';
    private final char arrayValueSeparator = ',';

    public char a() {
        return this.arrayValueSeparator;
    }

    public char b() {
        return this.objectEntrySeparator;
    }

    public char c() {
        return this.objectFieldValueSeparator;
    }
}
