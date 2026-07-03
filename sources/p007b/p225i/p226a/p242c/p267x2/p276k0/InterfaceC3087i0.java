package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.i0 */
/* JADX INFO: compiled from: TsPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3087i0 {

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.i0$a */
    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final String f8674a;

        /* JADX INFO: renamed from: b */
        public final byte[] f8675b;

        public a(String str, int i, byte[] bArr) {
            this.f8674a = str;
            this.f8675b = bArr;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.i0$b */
    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f8676a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final String f8677b;

        /* JADX INFO: renamed from: c */
        public final List<a> f8678c;

        /* JADX INFO: renamed from: d */
        public final byte[] f8679d;

        public b(int i, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.f8676a = i;
            this.f8677b = str;
            this.f8678c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f8679d = bArr;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.i0$c */
    /* JADX INFO: compiled from: TsPayloadReader.java */
    public interface c {
        @Nullable
        /* JADX INFO: renamed from: a */
        InterfaceC3087i0 mo3764a(int i, b bVar);
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.i0$d */
    /* JADX INFO: compiled from: TsPayloadReader.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final String f8680a;

        /* JADX INFO: renamed from: b */
        public final int f8681b;

        /* JADX INFO: renamed from: c */
        public final int f8682c;

        /* JADX INFO: renamed from: d */
        public int f8683d;

        /* JADX INFO: renamed from: e */
        public String f8684e;

        public d(int i, int i2, int i3) {
            String string;
            if (i != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(12);
                sb.append(i);
                sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                string = sb.toString();
            } else {
                string = "";
            }
            this.f8680a = string;
            this.f8681b = i2;
            this.f8682c = i3;
            this.f8683d = Integer.MIN_VALUE;
            this.f8684e = "";
        }

        /* JADX INFO: renamed from: a */
        public void m3765a() {
            int i = this.f8683d;
            int i2 = i == Integer.MIN_VALUE ? this.f8681b : i + this.f8682c;
            this.f8683d = i2;
            String str = this.f8680a;
            this.f8684e = C1643a.m851g(C1643a.m841b(str, 11), str, i2);
        }

        /* JADX INFO: renamed from: b */
        public String m3766b() {
            if (this.f8683d != Integer.MIN_VALUE) {
                return this.f8684e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        /* JADX INFO: renamed from: c */
        public int m3767c() {
            int i = this.f8683d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    /* JADX INFO: renamed from: a */
    void mo3754a(C2736d0 c2736d0, InterfaceC3058j interfaceC3058j, d dVar);

    /* JADX INFO: renamed from: b */
    void mo3755b(C2757x c2757x, int i) throws ParserException;

    /* JADX INFO: renamed from: c */
    void mo3756c();
}
