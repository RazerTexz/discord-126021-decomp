package b.i.a.c.b3.v;

import b.i.a.c.b3.Cue;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.b3.v.WebvttCueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.v.c, reason: use source file name */
/* JADX INFO: compiled from: Mp4WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder2 {
    public final ParsableByteArray n;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.n = new ParsableByteArray();
    }

    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        Cue cueA;
        ParsableByteArray parsableByteArray = this.n;
        parsableByteArray.a = bArr;
        parsableByteArray.c = i;
        parsableByteArray.f984b = 0;
        ArrayList arrayList = new ArrayList();
        while (this.n.a() > 0) {
            if (this.n.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iF = this.n.f();
            if (this.n.f() == 1987343459) {
                ParsableByteArray parsableByteArray2 = this.n;
                int i2 = iF - 8;
                CharSequence charSequenceF = null;
                Cue.b bVarA = null;
                while (i2 > 0) {
                    if (i2 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int iF2 = parsableByteArray2.f();
                    int iF3 = parsableByteArray2.f();
                    int i3 = iF2 - 8;
                    String strM = Util2.m(parsableByteArray2.a, parsableByteArray2.f984b, i3);
                    parsableByteArray2.F(i3);
                    i2 = (i2 - 8) - i3;
                    if (iF3 == 1937011815) {
                        WebvttCueParser.e eVar = new WebvttCueParser.e();
                        WebvttCueParser.e(strM, eVar);
                        bVarA = eVar.a();
                    } else if (iF3 == 1885436268) {
                        charSequenceF = WebvttCueParser.f(null, strM.trim(), Collections.emptyList());
                    }
                }
                if (charSequenceF == null) {
                    charSequenceF = "";
                }
                if (bVarA != null) {
                    bVarA.a = charSequenceF;
                    cueA = bVarA.a();
                } else {
                    Pattern pattern = WebvttCueParser.a;
                    WebvttCueParser.e eVar2 = new WebvttCueParser.e();
                    eVar2.c = charSequenceF;
                    cueA = eVar2.a().a();
                }
                arrayList.add(cueA);
            } else {
                this.n.F(iF - 8);
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }
}
