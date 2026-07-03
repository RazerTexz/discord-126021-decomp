package p007b.p008a.p021f;

import android.view.View;
import com.discord.chips_view.ChipsView;
import com.discord.chips_view.ChipsView.InterfaceC5465a;
import java.util.Objects;
import p007b.p008a.p021f.p022h.C0902a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.f.a */
/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0895a<K, T extends ChipsView.InterfaceC5465a> implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public C0902a f601j;

    /* JADX INFO: renamed from: k */
    public boolean f602k;

    /* JADX INFO: renamed from: l */
    public String f603l;

    /* JADX INFO: renamed from: m */
    public String f604m;

    /* JADX INFO: renamed from: n */
    public final K f605n;

    /* JADX INFO: renamed from: o */
    public final T f606o;

    /* JADX INFO: renamed from: p */
    public final a f607p;

    /* JADX INFO: renamed from: q */
    public final ChipsView<K, T> f608q;

    /* JADX INFO: renamed from: b.a.f.a$a */
    /* JADX INFO: compiled from: Chip.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f609a;

        /* JADX INFO: renamed from: b */
        public final int f610b;

        /* JADX INFO: renamed from: c */
        public final int f611c;

        /* JADX INFO: renamed from: d */
        public final int f612d;

        /* JADX INFO: renamed from: e */
        public final int f613e;

        /* JADX INFO: renamed from: f */
        public final int f614f;

        public a(int i, float f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f609a = i;
            this.f610b = i2;
            this.f611c = i3;
            this.f612d = i4;
            this.f613e = i5;
            this.f614f = i8;
        }
    }

    public ViewOnClickListenerC0895a(String str, String str2, K k, T t, a aVar, ChipsView<K, T> chipsView) {
        C12238m.checkNotNullParameter(aVar, "params");
        C12238m.checkNotNullParameter(chipsView, "container");
        this.f603l = str;
        this.f604m = str2;
        this.f605n = k;
        this.f606o = t;
        this.f607p = aVar;
        this.f608q = chipsView;
        String strSubstring = null;
        if (str == null) {
            this.f603l = t != null ? t.getDisplayString() : null;
        }
        String str3 = this.f603l;
        if ((str3 != null ? str3.length() : 0) > 30) {
            String str4 = this.f603l;
            if (str4 != null) {
                strSubstring = str4.substring(0, 30);
                C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.f603l = C12238m.stringPlus(strSubstring, "...");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ViewOnClickListenerC0895a) {
            return C12238m.areEqual(this.f606o, ((ViewOnClickListenerC0895a) obj).f606o);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f603l;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f604m;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        K k = this.f605n;
        int iHashCode3 = (iHashCode2 + (k != null ? k.hashCode() : 0)) * 31;
        T t = this.f606o;
        int iHashCode4 = (this.f608q.hashCode() + ((this.f607p.hashCode() + ((iHashCode3 + (t != null ? t.hashCode() : 0)) * 31)) * 31)) * 31;
        C0902a c0902a = this.f601j;
        return C0897c.m186a(this.f602k) + ((iHashCode4 + (c0902a != null ? c0902a.hashCode() : 0)) * 31);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C12238m.checkNotNullParameter(view, "v");
        this.f608q.mEditText.clearFocus();
        ChipsView<K, T> chipsView = this.f608q;
        Objects.requireNonNull(chipsView);
        C12238m.checkNotNullParameter(this, "chip");
        chipsView.m8380f(this);
        chipsView.m8379e(this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("{[Data: ");
        sbM833U.append(this.f606o);
        sbM833U.append(']');
        sbM833U.append("[Label: ");
        sbM833U.append(this.f603l);
        sbM833U.append(']');
        sbM833U.append("[ImageDescription: ");
        sbM833U.append(this.f604m);
        sbM833U.append(']');
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
