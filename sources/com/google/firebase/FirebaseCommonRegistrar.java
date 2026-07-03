package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.firebase.FirebaseCommonRegistrar;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p407x.AbstractC4893e;
import p007b.p225i.p361c.p407x.InterfaceC4895g;
import p007b.p225i.p361c.p407x.InterfaceC4896h;
import p507d0.C11227e;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements InterfaceC4575g {
    /* JADX INFO: renamed from: a */
    public static String m9175a(String str) {
        return str.replace(' ', '_').replace(MentionUtilsKt.SLASH_CHAR, '_');
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    public List<C4572d<?>> getComponents() {
        String string;
        ArrayList arrayList = new ArrayList();
        C4572d.b bVarM6348a = C4572d.m6348a(InterfaceC4896h.class);
        bVarM6348a.m6351a(new C4583o(AbstractC4893e.class, 2, 0));
        bVarM6348a.m6353c(new InterfaceC4574f() { // from class: b.i.c.x.b
            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                Set setMo6347d = interfaceC4573e.mo6347d(AbstractC4893e.class);
                C4892d c4892d = C4892d.f13084a;
                if (c4892d == null) {
                    synchronized (C4892d.class) {
                        c4892d = C4892d.f13084a;
                        if (c4892d == null) {
                            c4892d = new C4892d();
                            C4892d.f13084a = c4892d;
                        }
                    }
                }
                return new C4891c(setMo6347d, c4892d);
            }
        });
        arrayList.add(bVarM6348a.m6352b());
        C4572d.b bVarM6348a2 = C4572d.m6348a(InterfaceC4803d.class);
        bVarM6348a2.m6351a(new C4583o(Context.class, 1, 0));
        bVarM6348a2.m6353c(new InterfaceC4574f() { // from class: b.i.c.r.b
            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return new C4802c((Context) interfaceC4573e.mo6346a(Context.class));
            }
        });
        arrayList.add(bVarM6348a2.m6352b());
        arrayList.add(C3404f.m4228N("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(C3404f.m4228N("fire-core", "19.4.0"));
        arrayList.add(C3404f.m4228N("device-name", m9175a(Build.PRODUCT)));
        arrayList.add(C3404f.m4228N("device-model", m9175a(Build.DEVICE)));
        arrayList.add(C3404f.m4228N("device-brand", m9175a(Build.BRAND)));
        arrayList.add(C3404f.m4272b0("android-target-sdk", new InterfaceC4895g() { // from class: b.i.c.d
            @Override // p007b.p225i.p361c.p407x.InterfaceC4895g
            /* JADX INFO: renamed from: a */
            public String mo6336a(Object obj) {
                ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
                return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
            }
        }));
        arrayList.add(C3404f.m4272b0("android-min-sdk", new InterfaceC4895g() { // from class: b.i.c.e
            @Override // p007b.p225i.p361c.p407x.InterfaceC4895g
            /* JADX INFO: renamed from: a */
            public String mo6336a(Object obj) {
                ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
                return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
            }
        }));
        arrayList.add(C3404f.m4272b0("android-platform", new InterfaceC4895g() { // from class: b.i.c.f
            @Override // p007b.p225i.p361c.p407x.InterfaceC4895g
            /* JADX INFO: renamed from: a */
            public String mo6336a(Object obj) {
                Context context = (Context) obj;
                int i = Build.VERSION.SDK_INT;
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                    return "tv";
                }
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return "watch";
                }
                if (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                    return (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
                }
                return "auto";
            }
        }));
        arrayList.add(C3404f.m4272b0("android-installer", new InterfaceC4895g() { // from class: b.i.c.g
            @Override // p007b.p225i.p361c.p407x.InterfaceC4895g
            /* JADX INFO: renamed from: a */
            public String mo6336a(Object obj) {
                Context context = (Context) obj;
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                return installerPackageName != null ? FirebaseCommonRegistrar.m9175a(installerPackageName) : "";
            }
        }));
        try {
            string = C11227e.f22290j.toString();
        } catch (NoClassDefFoundError unused) {
            string = null;
        }
        if (string != null) {
            arrayList.add(C3404f.m4228N("kotlin", string));
        }
        return arrayList;
    }
}
