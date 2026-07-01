package b.i.a.c.x2;

import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.x2.p, reason: use source file name */
/* JADX INFO: compiled from: GaplessInfoHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GaplessInfoHolder {
    public static final Pattern a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1294b = -1;
    public int c = -1;

    public final boolean a(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = Util2.a;
            int i2 = Integer.parseInt(strGroup, 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.f1294b = i2;
            this.c = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean b(Metadata metadata) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.j;
            if (i >= entryArr.length) {
                return false;
            }
            Metadata.Entry entry = entryArr[i];
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.l) && a(commentFrame.m)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.k) && "iTunSMPB".equals(internalFrame.l) && a(internalFrame.m)) {
                    return true;
                }
            } else {
                continue;
            }
            i++;
        }
    }
}
