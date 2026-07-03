package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.TreeSet;
import p007b.p109f.p190m.EnumC2056i;
import p007b.p109f.p190m.InterfaceC2051d;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2051d
@TargetApi(23)
public final class SysUtil$MarshmallowSysdeps {
    private SysUtil$MarshmallowSysdeps() {
    }

    @InterfaceC2051d
    public static String[] getSupportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        TreeSet treeSet = new TreeSet();
        if (is64Bit()) {
            treeSet.add(EnumC2056i.AARCH64.toString());
            treeSet.add(EnumC2056i.X86_64.toString());
        } else {
            treeSet.add(EnumC2056i.ARM.toString());
            treeSet.add(EnumC2056i.X86.toString());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (treeSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @InterfaceC2051d
    public static boolean is64Bit() {
        return Process.is64Bit();
    }
}
