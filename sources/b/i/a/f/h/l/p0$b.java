package b.i.a.f.h.l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum p0$b implements y4 {
    UNKNOWN_MATCH_TYPE(0),
    REGEXP(1),
    BEGINS_WITH(2),
    ENDS_WITH(3),
    PARTIAL(4),
    EXACT(5),
    IN_LIST(6);

    private final int zzi;

    p0$b(int i) {
        this.zzi = i;
    }

    public static p0$b f(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_MATCH_TYPE;
            case 1:
                return REGEXP;
            case 2:
                return BEGINS_WITH;
            case 3:
                return ENDS_WITH;
            case 4:
                return PARTIAL;
            case 5:
                return EXACT;
            case 6:
                return IN_LIST;
            default:
                return null;
        }
    }

    @Override // b.i.a.f.h.l.y4
    public final int a() {
        return this.zzi;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + p0$b.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
    }
}
