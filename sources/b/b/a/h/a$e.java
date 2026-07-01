package b.b.a.h;

import androidx.annotation.StringRes;

/* JADX INFO: compiled from: FlexInputEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e extends a {
    public final int a;

    public a$e(@StringRes int i) {
        super(null);
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof a$e) && this.a == ((a$e) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return b.d.b.a.a.B(b.d.b.a.a.U("ShowToastStringRes(textResId="), this.a, ")");
    }
}
