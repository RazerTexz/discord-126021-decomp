package com.discord.utilities.sms;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.sms.AppSignatureHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.sms.AppSignatureHelper$appSignatures$2, reason: use source file name */
/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSignatureHelper2 extends Lambda implements Function0<ArrayList<String>> {
    public final /* synthetic */ AppSignatureHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper2(AppSignatureHelper appSignatureHelper) {
        super(0);
        this.this$0 = appSignatureHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ArrayList<String> invoke() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = this.this$0.getPackageName();
            Signature[] signatureArr = this.this$0.getPackageManager().getPackageInfo(packageName, 64).signatures;
            Intrinsics3.checkNotNullExpressionValue(signatureArr, "packageManager.getPackag…ATURES\n      ).signatures");
            ArrayList<String> arrayList2 = new ArrayList();
            for (Signature signature : signatureArr) {
                AppSignatureHelper.Companion companion = AppSignatureHelper.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(packageName, "packageName");
                String charsString = signature.toCharsString();
                Intrinsics3.checkNotNullExpressionValue(charsString, "signature.toCharsString()");
                String strHash = companion.hash(packageName, charsString);
                if (strHash != null) {
                    arrayList2.add(strHash);
                }
            }
            for (String str : arrayList2) {
                arrayList.add(str);
                Logger.d$default(AppLog.g, AppSignatureHelper.INSTANCE.getTAG(), "Hash " + str, null, 4, null);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e$default(AppLog.g, AppSignatureHelper.INSTANCE.getTAG(), "Unable to find package to obtain hash.", e, null, 8, null);
        }
        return arrayList;
    }
}
