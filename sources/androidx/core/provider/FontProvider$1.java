package androidx.core.provider;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class FontProvider$1 implements Comparator<byte[]> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
        return compare2(bArr, bArr2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    length = bArr[i];
                    length2 = bArr2[i];
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }
}
