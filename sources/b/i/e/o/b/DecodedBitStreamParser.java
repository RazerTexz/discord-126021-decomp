package b.i.e.o.b;

import com.discord.widgets.chat.input.MentionUtils;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.o.b.c, reason: use source file name */
/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DecodedBitStreamParser {
    public static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f1846b;
    public static final char[] c;
    public static final char[] d;
    public static final char[] e;

    static {
        char[] cArr = {'!', '\"', MentionUtils.CHANNELS_CHAR, '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', MentionUtils.SLASH_CHAR, MentionUtils.EMOJIS_AND_STICKERS_CHAR, ';', '<', '=', '>', '?', MentionUtils.MENTIONS_CHAR, '[', '\\', ']', '^', '_'};
        f1846b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    public static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    public static int b(int i, int i2) {
        int i3 = i - (((i2 * Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
