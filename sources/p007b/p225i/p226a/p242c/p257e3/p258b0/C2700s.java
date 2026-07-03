package p007b.p225i.p226a.p242c.p257e3.p258b0;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.s */
/* JADX INFO: compiled from: SimpleCacheSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2700s extends C2689h {

    /* JADX INFO: renamed from: p */
    public static final Pattern f6517p = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* JADX INFO: renamed from: q */
    public static final Pattern f6518q = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* JADX INFO: renamed from: r */
    public static final Pattern f6519r = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public C2700s(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009f A[PHI: r2
      0x009f: PHI (r2v15 java.util.regex.Matcher) = (r2v10 java.util.regex.Matcher), (r2v8 java.util.regex.Matcher) binds: [B:26:0x0095, B:22:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    @Nullable
    /* JADX INFO: renamed from: g */
    public static C2700s m2842g(File file, long j, long j2, C2691j c2691j) {
        File file2;
        long j3;
        String strGroup;
        File fileM2843h;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = f6518q.matcher(name2);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                Objects.requireNonNull(strGroup);
                int i = C2738e0.f6708a;
                int length = strGroup.length();
                int iEnd = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (strGroup.charAt(i3) == '%') {
                        i2++;
                    }
                }
                if (i2 != 0) {
                    int i4 = length - (i2 * 2);
                    StringBuilder sb = new StringBuilder(i4);
                    Matcher matcher2 = C2738e0.f6714g.matcher(strGroup);
                    while (i2 > 0 && matcher2.find()) {
                        String strGroup2 = matcher2.group(1);
                        Objects.requireNonNull(strGroup2);
                        char c = (char) Integer.parseInt(strGroup2, 16);
                        sb.append((CharSequence) strGroup, iEnd, matcher2.start());
                        sb.append(c);
                        iEnd = matcher2.end();
                        i2--;
                    }
                    if (iEnd < length) {
                        sb.append((CharSequence) strGroup, iEnd, length);
                    }
                    if (sb.length() != i4) {
                        strGroup = null;
                    } else {
                        strGroup = sb.toString();
                    }
                }
            } else {
                matcher = f6517p.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    Objects.requireNonNull(strGroup);
                } else {
                    strGroup = null;
                }
            }
            if (strGroup == null) {
                fileM2843h = null;
            } else {
                File parentFile = file.getParentFile();
                C1460d.m438H(parentFile);
                int i5 = c2691j.m2796d(strGroup).f6471a;
                String strGroup3 = matcher.group(2);
                Objects.requireNonNull(strGroup3);
                long j4 = Long.parseLong(strGroup3);
                String strGroup4 = matcher.group(3);
                Objects.requireNonNull(strGroup4);
                fileM2843h = m2843h(parentFile, i5, j4, Long.parseLong(strGroup4));
                if (!file.renameTo(fileM2843h)) {
                    fileM2843h = null;
                }
            }
            if (fileM2843h == null) {
                return null;
            }
            file2 = fileM2843h;
            name = fileM2843h.getName();
        }
        Matcher matcher3 = f6519r.matcher(name);
        if (!matcher3.matches()) {
            return null;
        }
        String strGroup5 = matcher3.group(1);
        Objects.requireNonNull(strGroup5);
        String str = c2691j.f6479b.get(Integer.parseInt(strGroup5));
        if (str == null) {
            return null;
        }
        long length2 = j == -1 ? file2.length() : j;
        if (length2 == 0) {
            return null;
        }
        String strGroup6 = matcher3.group(2);
        Objects.requireNonNull(strGroup6);
        long j5 = Long.parseLong(strGroup6);
        if (j2 == -9223372036854775807L) {
            String strGroup7 = matcher3.group(3);
            Objects.requireNonNull(strGroup7);
            j3 = Long.parseLong(strGroup7);
        } else {
            j3 = j2;
        }
        return new C2700s(str, j5, length2, j3, file2);
    }

    /* JADX INFO: renamed from: h */
    public static File m2843h(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        sb.append(j2);
        sb.append(".v3.exo");
        return new File(file, sb.toString());
    }
}
