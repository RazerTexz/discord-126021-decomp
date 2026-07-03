package p007b.p225i.p226a.p242c.p279z2.p282j;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p279z2.AbstractC3161g;
import p007b.p225i.p226a.p242c.p279z2.C3158d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.z2.j.a */
/* JADX INFO: compiled from: IcyDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3165a extends AbstractC3161g {

    /* JADX INFO: renamed from: a */
    public static final Pattern f9150a = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: b */
    public final CharsetDecoder f9151b = C4483c.f11945c.newDecoder();

    /* JADX INFO: renamed from: c */
    public final CharsetDecoder f9152c = C4483c.f11944b.newDecoder();

    @Override // p007b.p225i.p226a.p242c.p279z2.AbstractC3161g
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer) {
        String string;
        String str = null;
        try {
            string = this.f9151b.decode(byteBuffer).toString();
            this.f9151b.reset();
            byteBuffer.rewind();
        } catch (CharacterCodingException unused) {
            this.f9151b.reset();
            byteBuffer.rewind();
            try {
                string = this.f9152c.decode(byteBuffer).toString();
                this.f9152c.reset();
                byteBuffer.rewind();
            } catch (CharacterCodingException unused2) {
                this.f9152c.reset();
                byteBuffer.rewind();
                string = null;
            } catch (Throwable th) {
                this.f9152c.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.f9151b.reset();
            byteBuffer.rewind();
            throw th2;
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (string == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f9150a.matcher(string);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strM4349u1 = C3404f.m4349u1(strGroup);
                strM4349u1.hashCode();
                if (strM4349u1.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strM4349u1.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
