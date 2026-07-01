package b.i.a.c.b3.v;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.v.j, reason: use source file name */
/* JADX INFO: compiled from: WebvttParserUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttParserUtil {
    static {
        Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static float a(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long b(String str) throws NumberFormatException {
        int i = Util2.a;
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str2 : Util2.H(strArrSplit[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            j2 += Long.parseLong(strArrSplit[1]);
        }
        return j2 * 1000;
    }

    public static void c(ParsableByteArray parsableByteArray) throws ParserException {
        int i = parsableByteArray.f984b;
        String strG = parsableByteArray.g();
        if (strG != null && strG.startsWith("WEBVTT")) {
            return;
        }
        parsableByteArray.E(i);
        String strValueOf = String.valueOf(parsableByteArray.g());
        throw ParserException.a(strValueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(strValueOf) : new String("Expected WEBVTT. Got "), null);
    }
}
