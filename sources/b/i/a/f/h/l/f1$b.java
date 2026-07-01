package b.i.a.f.h.l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum f1$b implements y4 {
    RADS(1),
    PROVISIONING(2);

    private final int zzd;

    f1$b(int i) {
        this.zzd = i;
    }

    @Override // b.i.a.f.h.l.y4
    public final int a() {
        return this.zzd;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + f1$b.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }
}
