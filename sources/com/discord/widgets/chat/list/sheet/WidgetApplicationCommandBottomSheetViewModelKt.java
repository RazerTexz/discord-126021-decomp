package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandValue;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModelKt {
    public static final List<ApplicationCommandValue> flattenOptions(List<ApplicationCommandValue> list) {
        m.checkNotNullParameter(list, "$this$flattenOptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(flattenOptions((ApplicationCommandValue) it.next()));
        }
        return arrayList;
    }

    public static final String toStringTruncateZeroDecimal(Object obj) {
        return obj instanceof Number ? w.removeSuffix(obj.toString(), ".0") : String.valueOf(obj);
    }

    public static final List<ApplicationCommandValue> flattenOptions(ApplicationCommandValue applicationCommandValue) {
        m.checkNotNullParameter(applicationCommandValue, "$this$flattenOptions");
        List<ApplicationCommandValue> listC = applicationCommandValue.c();
        if (listC == null || listC.isEmpty()) {
            return d0.t.m.listOf(applicationCommandValue);
        }
        ArrayList arrayList = new ArrayList();
        List<ApplicationCommandValue> listC2 = applicationCommandValue.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(flattenOptions((ApplicationCommandValue) it.next()));
            }
        }
        return arrayList;
    }
}
