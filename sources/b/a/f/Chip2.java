package b.a.f;

import android.view.View;
import b.a.f.h.ViewChipDefaultBinding;
import b.d.b.a.outline;
import com.discord.chips_view.ChipsView;
import com.discord.chips_view.ChipsView.a;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.f.a, reason: use source file name */
/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Chip2<K, T extends ChipsView.a> implements View.OnClickListener {
    public ViewChipDefaultBinding j;
    public boolean k;
    public String l;
    public String m;
    public final K n;
    public final T o;
    public final a p;
    public final ChipsView<K, T> q;

    /* JADX INFO: renamed from: b.a.f.a$a */
    /* JADX INFO: compiled from: Chip.kt */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f66b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public a(int i, float f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a = i;
            this.f66b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i8;
        }
    }

    public Chip2(String str, String str2, K k, T t, a aVar, ChipsView<K, T> chipsView) {
        Intrinsics3.checkNotNullParameter(aVar, "params");
        Intrinsics3.checkNotNullParameter(chipsView, "container");
        this.l = str;
        this.m = str2;
        this.n = k;
        this.o = t;
        this.p = aVar;
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
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.l = Intrinsics3.stringPlus(strSubstring, "...");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Chip2) {
            return Intrinsics3.areEqual(this.o, ((Chip2) obj).o);
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
        ViewChipDefaultBinding viewChipDefaultBinding = this.j;
        return c.a(this.k) + ((iHashCode4 + (viewChipDefaultBinding != null ? viewChipDefaultBinding.hashCode() : 0)) * 31);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "v");
        this.q.mEditText.clearFocus();
        ChipsView<K, T> chipsView = this.q;
        Objects.requireNonNull(chipsView);
        Intrinsics3.checkNotNullParameter(this, "chip");
        chipsView.f(this);
        chipsView.e(this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("{[Data: ");
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
