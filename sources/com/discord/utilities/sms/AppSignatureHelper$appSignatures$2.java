package com.discord.utilities.sms;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSignatureHelper$appSignatures$2 extends AbstractC12240o implements Function0<ArrayList<String>> {
    public final /* synthetic */ AppSignatureHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper$appSignatures$2(AppSignatureHelper appSignatureHelper) {
        super(0);
        this.this$0 = appSignatureHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ArrayList<String> invoke() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = this.this$0.getPackageName();
            Signature[] signatureArr = this.this$0.getPackageManager().getPackageInfo(packageName, 64).signatures;
            C12238m.checkNotNullExpressionValue(signatureArr, "packageManager.getPackag…ATURES\n      ).signatures");
            ArrayList<String> arrayList2 = new ArrayList();
            for (Signature signature : signatureArr) {
                AppSignatureHelper.Companion companion = AppSignatureHelper.INSTANCE;
                C12238m.checkNotNullExpressionValue(packageName, "packageName");
                String charsString = signature.toCharsString();
                C12238m.checkNotNullExpressionValue(charsString, "signature.toCharsString()");
                String strHash = companion.hash(packageName, charsString);
                if (strHash != null) {
                    arrayList2.add(strHash);
                }
            }
            for (String str : arrayList2) {
                arrayList.add(str);
                Logger.d$default(AppLog.f14950g, AppSignatureHelper.INSTANCE.getTAG(), "Hash " + str, null, 4, null);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e$default(AppLog.f14950g, AppSignatureHelper.INSTANCE.getTAG(), "Unable to find package to obtain hash.", e, null, 8, null);
        }
        return arrayList;
    }
}
