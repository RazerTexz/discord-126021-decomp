package p007b.p195g.p196a.p198b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: renamed from: b.g.a.b.b */
/* JADX INFO: compiled from: Base64Variants.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2106b {

    /* JADX INFO: renamed from: a */
    public static final C2105a f4451a;

    /* JADX INFO: renamed from: b */
    public static final C2105a f4452b;

    /* JADX INFO: renamed from: c */
    public static final C2105a f4453c;

    /* JADX INFO: renamed from: d */
    public static final C2105a f4454d;

    static {
        C2105a c2105a = new C2105a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f4451a = c2105a;
        f4452b = new C2105a(c2105a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f4453c = new C2105a(c2105a, "PEM", true, '=', 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), '-');
        sb.setCharAt(sb.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), '_');
        f4454d = new C2105a("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
