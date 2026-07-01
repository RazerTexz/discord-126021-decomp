package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import b.d.b.a.a;
import b.f.m.d;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
@d
@TargetApi(18)
public class Api18TraceUtils {
    public static void a(String str, String str2, String str3) {
        String strY = a.y(str, str2, str3);
        if (strY.length() > 127 && str2 != null) {
            int length = (Opcodes.LAND - str.length()) - str3.length();
            StringBuilder sbU = a.U(str);
            sbU.append(str2.substring(0, length));
            sbU.append(str3);
            strY = sbU.toString();
        }
        Trace.beginSection(strY);
    }
}
