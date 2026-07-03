package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p190m.InterfaceC2051d;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2051d
@TargetApi(18)
public class Api18TraceUtils {
    /* JADX INFO: renamed from: a */
    public static void m8727a(String str, String str2, String str3) {
        String strM886y = C1643a.m886y(str, str2, str3);
        if (strM886y.length() > 127 && str2 != null) {
            int length = (Opcodes.LAND - str.length()) - str3.length();
            StringBuilder sbM833U = C1643a.m833U(str);
            sbM833U.append(str2.substring(0, length));
            sbM833U.append(str3);
            strM886y = sbM833U.toString();
        }
        Trace.beginSection(strM886y);
    }
}
