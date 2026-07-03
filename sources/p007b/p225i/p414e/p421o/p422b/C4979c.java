package p007b.p225i.p414e.p421o.p422b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.o.b.c */
/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4979c {

    /* JADX INFO: renamed from: a */
    public static final char[] f13324a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: b */
    public static final char[] f13325b;

    /* JADX INFO: renamed from: c */
    public static final char[] f13326c;

    /* JADX INFO: renamed from: d */
    public static final char[] f13327d;

    /* JADX INFO: renamed from: e */
    public static final char[] f13328e;

    static {
        char[] cArr = {'!', '\"', MentionUtilsKt.CHANNELS_CHAR, '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', MentionUtilsKt.SLASH_CHAR, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, ';', '<', '=', '>', '?', MentionUtilsKt.MENTIONS_CHAR, '[', '\\', ']', '^', '_'};
        f13325b = cArr;
        f13326c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f13327d = cArr;
        f13328e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    /* JADX INFO: renamed from: a */
    public static void m6971a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    /* JADX INFO: renamed from: b */
    public static int m6972b(int i, int i2) {
        int i3 = i - (((i2 * Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
