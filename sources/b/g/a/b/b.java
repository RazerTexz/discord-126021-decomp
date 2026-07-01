package b.g.a.b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: compiled from: Base64Variants.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f656b;
    public static final a c;
    public static final a d;

    static {
        a aVar = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        a = aVar;
        f656b = new a(aVar, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        c = new a(aVar, "PEM", true, '=', 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), '-');
        sb.setCharAt(sb.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), '_');
        d = new a("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
