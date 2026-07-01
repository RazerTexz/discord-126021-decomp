package b.c.a.a0.i0;

import g0.e;
import g0.o;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class c$a {
    public final String[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f333b;

    public c$a(String[] strArr, o oVar) {
        this.a = strArr;
        this.f333b = oVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a A[Catch: IOException -> 0x006b, TryCatch #0 {IOException -> 0x006b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x0059), top: B:30:0x0000 }] */
    public static c$a a(String... strArr) {
        String str;
        try {
            ByteString[] byteStringArr = new ByteString[strArr.length];
            e eVar = new e();
            for (int i = 0; i < strArr.length; i++) {
                String str2 = strArr[i];
                String[] strArr2 = c.j;
                eVar.T(34);
                int length = str2.length();
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt = str2.charAt(i3);
                    if (cCharAt < 128) {
                        str = strArr2[cCharAt];
                        if (str != null) {
                            if (i2 < i3) {
                                eVar.c0(str2, i2, i3);
                            }
                            eVar.b0(str);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (cCharAt == 8232) {
                            str = "\\u2028";
                        } else if (cCharAt == 8233) {
                            str = "\\u2029";
                        }
                        if (i2 < i3) {
                            eVar.c0(str2, i2, i3);
                        }
                        eVar.b0(str);
                        i2 = i3 + 1;
                    }
                }
                if (i2 < length) {
                    eVar.c0(str2, i2, length);
                }
                eVar.T(34);
                eVar.readByte();
                byteStringArr[i] = eVar.x();
            }
            return new c$a((String[]) strArr.clone(), o.k.c(byteStringArr));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
