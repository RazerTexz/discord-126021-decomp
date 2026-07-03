package p007b.p225i.p226a.p242c.p267x2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x2.p */
/* JADX INFO: compiled from: GaplessInfoHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3115p {

    /* JADX INFO: renamed from: a */
    public static final Pattern f8984a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: b */
    public int f8985b = -1;

    /* JADX INFO: renamed from: c */
    public int f8986c = -1;

    /* JADX INFO: renamed from: a */
    public final boolean m3814a(String str) {
        Matcher matcher = f8984a.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = C2738e0.f6708a;
            int i2 = Integer.parseInt(strGroup, 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.f8985b = i2;
            this.f8986c = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m3815b(Metadata metadata) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f19936j;
            if (i >= entryArr.length) {
                return false;
            }
            Metadata.Entry entry = entryArr[i];
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.f19983l) && m3814a(commentFrame.f19984m)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.f19990k) && "iTunSMPB".equals(internalFrame.f19991l) && m3814a(internalFrame.f19992m)) {
                    return true;
                }
            } else {
                continue;
            }
            i++;
        }
    }
}
