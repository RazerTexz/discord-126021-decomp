package p507d0.p591y;

import java.io.File;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.c */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12202c {
    public static final String access$constructMessage(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
