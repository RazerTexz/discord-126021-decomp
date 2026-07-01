package b.i.a.f.h.l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum n0$a implements y4 {
    UNKNOWN_COMPARISON_TYPE(0),
    LESS_THAN(1),
    GREATER_THAN(2),
    EQUAL(3),
    BETWEEN(4);

    private final int zzg;

    n0$a(int i) {
        this.zzg = i;
    }

    public static n0$a f(int i) {
        if (i == 0) {
            return UNKNOWN_COMPARISON_TYPE;
        }
        if (i == 1) {
            return LESS_THAN;
        }
        if (i == 2) {
            return GREATER_THAN;
        }
        if (i == 3) {
            return EQUAL;
        }
        if (i != 4) {
            return null;
        }
        return BETWEEN;
    }

    @Override // b.i.a.f.h.l.y4
    public final int a() {
        return this.zzg;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + n0$a.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
