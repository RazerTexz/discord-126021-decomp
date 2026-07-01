package b.i.a.f.h.l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum q1$a implements y4 {
    UNKNOWN(0),
    STRING(1),
    NUMBER(2),
    BOOLEAN(3),
    STATEMENT(4);

    private final int zzg;

    q1$a(int i) {
        this.zzg = i;
    }

    @Override // b.i.a.f.h.l.y4
    public final int a() {
        return this.zzg;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + q1$a.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
