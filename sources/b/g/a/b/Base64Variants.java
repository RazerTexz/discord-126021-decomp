package b.g.a.b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: renamed from: b.g.a.b.b, reason: use source file name */
/* JADX INFO: compiled from: Base64Variants.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Base64Variants {
    public static final Base64Variant a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Base64Variant f656b;
    public static final Base64Variant c;
    public static final Base64Variant d;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        a = base64Variant;
        f656b = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        c = new Base64Variant(base64Variant, "PEM", true, '=', 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), '-');
        sb.setCharAt(sb.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), '_');
        d = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
