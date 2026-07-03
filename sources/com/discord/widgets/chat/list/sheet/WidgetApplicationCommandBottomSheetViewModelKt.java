package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModelKt {
    public static final List<ApplicationCommandValue> flattenOptions(List<ApplicationCommandValue> list) {
        C12238m.checkNotNullParameter(list, "$this$flattenOptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(flattenOptions((ApplicationCommandValue) it.next()));
        }
        return arrayList;
    }

    public static final String toStringTruncateZeroDecimal(Object obj) {
        return obj instanceof Number ? C12106w.removeSuffix(obj.toString(), ".0") : String.valueOf(obj);
    }

    public static final List<ApplicationCommandValue> flattenOptions(ApplicationCommandValue applicationCommandValue) {
        C12238m.checkNotNullParameter(applicationCommandValue, "$this$flattenOptions");
        List<ApplicationCommandValue> listM7741c = applicationCommandValue.m7741c();
        if (listM7741c == null || listM7741c.isEmpty()) {
            return C12145m.listOf(applicationCommandValue);
        }
        ArrayList arrayList = new ArrayList();
        List<ApplicationCommandValue> listM7741c2 = applicationCommandValue.m7741c();
        if (listM7741c2 != null) {
            Iterator<T> it = listM7741c2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(flattenOptions((ApplicationCommandValue) it.next()));
            }
        }
        return arrayList;
    }
}
