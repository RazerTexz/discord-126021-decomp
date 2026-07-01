package b.g.a.b.t;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.Serializable;

/* JADX INFO: compiled from: Separators.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements Serializable {
    private static final long serialVersionUID = 1;
    private final char objectFieldValueSeparator = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
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
