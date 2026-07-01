package b.a.a.a;

import androidx.annotation.StringRes;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$c$c extends f$c {
    public final Integer f;

    public f$c$c() {
        this(null, 1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f$c$c(Integer num, int i) {
        this(null);
        int i2 = i & 1;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof f$c$c) && m.areEqual(this.f, ((f$c$c) obj).f);
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.f;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return b.d.b.a.a.F(b.d.b.a.a.U("Dismiss(dismissStringId="), this.f, ")");
    }

    public f$c$c(@StringRes Integer num) {
        super(false, false, false, false, true, null);
        this.f = num;
    }
}
