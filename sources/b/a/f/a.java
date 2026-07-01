package b.a.f;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.chips_view.ChipsView;
import com.discord.chips_view.ChipsView$a;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<K, T extends ChipsView$a> implements View$OnClickListener {
    public b.a.f.h.a j;
    public boolean k;
    public String l;
    public String m;
    public final K n;
    public final T o;
    public final a$a p;
    public final ChipsView<K, T> q;

    public a(String str, String str2, K k, T t, a$a a_a, ChipsView<K, T> chipsView) {
        m.checkNotNullParameter(a_a, "params");
        m.checkNotNullParameter(chipsView, "container");
        this.l = str;
        this.m = str2;
        this.n = k;
        this.o = t;
        this.p = a_a;
        this.q = chipsView;
        String strSubstring = null;
        if (str == null) {
            this.l = t != null ? t.getDisplayString() : null;
        }
        String str3 = this.l;
        if ((str3 != null ? str3.length() : 0) > 30) {
            String str4 = this.l;
            if (str4 != null) {
                strSubstring = str4.substring(0, 30);
                m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.l = m.stringPlus(strSubstring, "...");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return m.areEqual(this.o, ((a) obj).o);
        }
        return false;
    }

    public int hashCode() {
        String str = this.l;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.m;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        K k = this.n;
        int iHashCode3 = (iHashCode2 + (k != null ? k.hashCode() : 0)) * 31;
        T t = this.o;
        int iHashCode4 = (this.q.hashCode() + ((this.p.hashCode() + ((iHashCode3 + (t != null ? t.hashCode() : 0)) * 31)) * 31)) * 31;
        b.a.f.h.a aVar = this.j;
        return c.a(this.k) + ((iHashCode4 + (aVar != null ? aVar.hashCode() : 0)) * 31);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        m.checkNotNullParameter(view, "v");
        this.q.mEditText.clearFocus();
        ChipsView<K, T> chipsView = this.q;
        Objects.requireNonNull(chipsView);
        m.checkNotNullParameter(this, "chip");
        chipsView.f(this);
        chipsView.e(this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("{[Data: ");
        sbU.append(this.o);
        sbU.append(']');
        sbU.append("[Label: ");
        sbU.append(this.l);
        sbU.append(']');
        sbU.append("[ImageDescription: ");
        sbU.append(this.m);
        sbU.append(']');
        sbU.append('}');
        return sbU.toString();
    }
}
