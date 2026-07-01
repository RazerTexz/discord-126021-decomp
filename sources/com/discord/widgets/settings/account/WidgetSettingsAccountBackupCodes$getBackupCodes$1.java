package com.discord.widgets.settings.account;

import b.a.k.b;
import com.discord.api.auth.mfa.BackupCode;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$getBackupCodes$1 extends o implements Function1<GetBackupCodesResponse, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes$getBackupCodes$1(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(1);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesResponse getBackupCodesResponse) {
        invoke2(getBackupCodesResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GetBackupCodesResponse getBackupCodesResponse) {
        List<BackupCode> listA = getBackupCodesResponse.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!((BackupCode) obj).getConsumed()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listA) {
            if (((BackupCode) obj2).getConsumed()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList3.add(new WidgetSettingsAccountBackupCodes$BackupCodeItemHeader(b.h(this.this$0.requireContext(), 2131896848, new Object[0], null, 4)));
            ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList4.add(new WidgetSettingsAccountBackupCodes$BackupCodeItem((BackupCode) it.next()));
            }
            arrayList3.addAll(arrayList4);
        }
        if (!arrayList2.isEmpty()) {
            arrayList3.add(new WidgetSettingsAccountBackupCodes$BackupCodeItemHeader(b.h(this.this$0.requireContext(), 2131896983, new Object[0], null, 4)));
            ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList5.add(new WidgetSettingsAccountBackupCodes$BackupCodeItem((BackupCode) it2.next()));
            }
            arrayList3.addAll(arrayList5);
        }
        WidgetSettingsAccountBackupCodes.access$configureUI(this.this$0, arrayList3);
    }
}
