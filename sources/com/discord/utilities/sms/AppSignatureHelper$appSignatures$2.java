package com.discord.utilities.sms;

import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.Signature;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSignatureHelper$appSignatures$2 extends o implements Function0<ArrayList<String>> {
    public final /* synthetic */ AppSignatureHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper$appSignatures$2(AppSignatureHelper appSignatureHelper) {
        super(0);
        this.this$0 = appSignatureHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ArrayList<String> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<String> invoke2() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = this.this$0.getPackageName();
            Signature[] signatureArr = this.this$0.getPackageManager().getPackageInfo(packageName, 64).signatures;
            m.checkNotNullExpressionValue(signatureArr, "packageManager.getPackag…ATURES\n      ).signatures");
            ArrayList<String> arrayList2 = new ArrayList();
            for (Signature signature : signatureArr) {
                AppSignatureHelper$Companion appSignatureHelper$Companion = AppSignatureHelper.Companion;
                m.checkNotNullExpressionValue(packageName, "packageName");
                String charsString = signature.toCharsString();
                m.checkNotNullExpressionValue(charsString, "signature.toCharsString()");
                String strAccess$hash = AppSignatureHelper$Companion.access$hash(appSignatureHelper$Companion, packageName, charsString);
                if (strAccess$hash != null) {
                    arrayList2.add(strAccess$hash);
                }
            }
            for (String str : arrayList2) {
                arrayList.add(str);
                Logger.d$default(AppLog.g, AppSignatureHelper.Companion.getTAG(), "Hash " + str, null, 4, null);
            }
        } catch (PackageManager$NameNotFoundException e) {
            Logger.e$default(AppLog.g, AppSignatureHelper.Companion.getTAG(), "Unable to find package to obtain hash.", e, null, 8, null);
        }
        return arrayList;
    }
}
