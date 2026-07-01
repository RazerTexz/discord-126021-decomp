package b.i.a.c.x2.k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.x2.k0.TsPayloadReader;
import b.i.b.a.Charsets;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.l, reason: use source file name */
/* JADX INFO: compiled from: DefaultTsPayloadReaderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Format2> f1264b;

    public DefaultTsPayloadReaderFactory(int i) {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        ImmutableList2<Object> immutableList2 = RegularImmutableList.l;
        this.a = i;
        this.f1264b = immutableList2;
    }

    @Override // b.i.a.c.x2.k0.TsPayloadReader.c
    @Nullable
    public TsPayloadReader a(int i, TsPayloadReader.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new PesReader(new MpegAudioReader(bVar.f1258b));
            }
            if (i == 21) {
                return new PesReader(new Id3Reader());
            }
            if (i == 27) {
                if (d(4)) {
                    return null;
                }
                return new PesReader(new H264Reader(new SeiReader(c(bVar)), d(1), d(8)));
            }
            if (i == 36) {
                return new PesReader(new H265Reader(new SeiReader(c(bVar))));
            }
            if (i == 89) {
                return new PesReader(new DvbSubtitleReader(bVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new PesReader(new Ac4Reader(bVar.f1258b));
                }
                if (i == 257) {
                    return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (d(16)) {
                        return null;
                    }
                    return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (d(2)) {
                                return null;
                            }
                            return new PesReader(new AdtsReader(false, bVar.f1258b));
                        case 16:
                            return new PesReader(new H263Reader(new UserDataReader(c(bVar))));
                        case 17:
                            if (d(2)) {
                                return null;
                            }
                            return new PesReader(new LatmReader(bVar.f1258b));
                        default:
                            switch (i) {
                                case 128:
                                    break;
                                case Opcodes.LOR /* 129 */:
                                    break;
                                case 130:
                                    if (!d(64)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                }
                return new PesReader(new Ac3Reader(bVar.f1258b));
            }
            return new PesReader(new DtsReader(bVar.f1258b));
        }
        return new PesReader(new H262Reader(new UserDataReader(c(bVar))));
    }

    public SparseArray<TsPayloadReader> b() {
        return new SparseArray<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final List<Format2> c(TsPayloadReader.b bVar) {
        String str;
        int i;
        if (d(32)) {
            return this.f1264b;
        }
        byte[] bArr = bVar.d;
        int length = bArr.length;
        int i2 = 0;
        ArrayList arrayList = this.f1264b;
        while (length - i2 > 0) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            int i5 = i3 + 1;
            int i6 = (bArr[i3] & 255) + i5;
            boolean z2 = true;
            if (i4 == 134) {
                arrayList = new ArrayList();
                int i7 = i5 + 1;
                int i8 = bArr[i5] & 255 & 31;
                int i9 = 0;
                while (i9 < i8) {
                    String str2 = new String(bArr, i7, 3, Charsets.c);
                    int i10 = i7 + 3;
                    int i11 = i10 + 1;
                    int i12 = bArr[i10] & 255;
                    boolean z3 = (i12 & 128) != 0;
                    if (z3) {
                        i = i12 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    int i13 = i11 + 1;
                    byte b2 = (byte) (bArr[i11] & 255);
                    int i14 = i13 + 1;
                    AnimatableValueParser.j(i14 >= 0 && i14 <= length);
                    List<byte[]> listSingletonList = null;
                    if (z3) {
                        listSingletonList = Collections.singletonList((b2 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    }
                    Format2.b bVar2 = new Format2.b();
                    bVar2.k = str;
                    bVar2.c = str2;
                    bVar2.C = i;
                    bVar2.m = listSingletonList;
                    arrayList.add(bVar2.a());
                    i9++;
                    i7 = i14;
                }
            }
            if (i6 < 0 || i6 > length) {
                z2 = false;
            }
            AnimatableValueParser.j(z2);
            i2 = i6;
            arrayList = arrayList;
        }
        return arrayList;
    }

    public final boolean d(int i) {
        return (i & this.a) != 0;
    }
}
