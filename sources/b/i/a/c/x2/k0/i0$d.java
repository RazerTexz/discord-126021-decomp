package b.i.a.c.x2.k0;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;

/* JADX INFO: compiled from: TsPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0$d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1259b;
    public final int c;
    public int d;
    public String e;

    public i0$d(int i, int i2, int i3) {
        String string;
        if (i != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder(12);
            sb.append(i);
            sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
            string = sb.toString();
        } else {
            string = "";
        }
        this.a = string;
        this.f1259b = i2;
        this.c = i3;
        this.d = Integer.MIN_VALUE;
        this.e = "";
    }

    public void a() {
        int i = this.d;
        int i2 = i == Integer.MIN_VALUE ? this.f1259b : i + this.c;
        this.d = i2;
        String str = this.a;
        this.e = b.d.b.a.a.g(b.d.b.a.a.b(str, 11), str, i2);
    }

    public String b() {
        if (this.d != Integer.MIN_VALUE) {
            return this.e;
        }
        throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }

    public int c() {
        int i = this.d;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }
}
