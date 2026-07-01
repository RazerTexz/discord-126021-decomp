package b.a.a.a;

import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c$a extends k$c {
    public final Integer a;

    public k$c$a() {
        this(null, 1);
    }

    public k$c$a(Integer num) {
        super(null);
        this.a = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k$c$a) && m.areEqual(this.a, ((k$c$a) obj).a);
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.a;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return b.d.b.a.a.F(b.d.b.a.a.U("Dismiss(errorToastStringResId="), this.a, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k$c$a(Integer num, int i) {
        this(null);
        int i2 = i & 1;
    }
}
