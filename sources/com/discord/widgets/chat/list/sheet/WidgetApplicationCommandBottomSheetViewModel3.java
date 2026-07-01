package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData3;
import d0.g0.Strings4;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModelKt, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel3 {
    public static final List<ApplicationCommandData3> flattenOptions(List<ApplicationCommandData3> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$flattenOptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(flattenOptions((ApplicationCommandData3) it.next()));
        }
        return arrayList;
    }

    public static final String toStringTruncateZeroDecimal(Object obj) {
        return obj instanceof Number ? Strings4.removeSuffix(obj.toString(), ".0") : String.valueOf(obj);
    }

    public static final List<ApplicationCommandData3> flattenOptions(ApplicationCommandData3 applicationCommandData3) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "$this$flattenOptions");
        List<ApplicationCommandData3> listC = applicationCommandData3.c();
        if (listC == null || listC.isEmpty()) {
            return CollectionsJVM.listOf(applicationCommandData3);
        }
        ArrayList arrayList = new ArrayList();
        List<ApplicationCommandData3> listC2 = applicationCommandData3.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(flattenOptions((ApplicationCommandData3) it.next()));
            }
        }
        return arrayList;
    }
}
