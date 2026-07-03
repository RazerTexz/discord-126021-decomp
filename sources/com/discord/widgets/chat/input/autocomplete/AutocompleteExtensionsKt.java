package com.discord.widgets.chat.input.autocomplete;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.Comparator;
import java.util.Map;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteExtensionsKt {
    public static final String replaceAutocompleteDataWithServerValues(String str, Map<IntRange, ? extends Autocompletable> map) {
        C12238m.checkNotNullParameter(str, "$this$replaceAutocompleteDataWithServerValues");
        C12238m.checkNotNullParameter(map, "inputMentionsMap");
        String string = str;
        for (IntRange intRange : C12163u.sortedWith(map.keySet(), new Comparator() { // from class: com.discord.widgets.chat.input.autocomplete.AutocompleteExtensionsKt$replaceAutocompleteDataWithServerValues$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return C12169a.compareValues(Integer.valueOf(((IntRange) t2).getFirst()), Integer.valueOf(((IntRange) t).getFirst()));
            }
        })) {
            Autocompletable autocompletable = map.get(intRange);
            if (autocompletable != null) {
                if (intRange.getFirst() > string.length() || intRange.getLast() > string.length()) {
                    AppLog appLog = AppLog.f14950g;
                    StringBuilder sbM833U = C1643a.m833U("Invalid mention position to insert ");
                    sbM833U.append(autocompletable.getInputReplacement());
                    sbM833U.append(' ');
                    sbM833U.append("into ");
                    sbM833U.append(string);
                    sbM833U.append(" at [");
                    sbM833U.append(intRange.getFirst());
                    sbM833U.append(" - ");
                    sbM833U.append(intRange.getLast());
                    sbM833U.append("]. Original input: ");
                    sbM833U.append(str);
                    String string2 = sbM833U.toString();
                    StringBuilder sbM833U2 = C1643a.m833U("first ");
                    sbM833U2.append(intRange.getFirst());
                    sbM833U2.append(", last ");
                    sbM833U2.append(intRange.getLast());
                    sbM833U2.append(", s.length() ");
                    sbM833U2.append(string.length());
                    Logger.e$default(appLog, string2, new IndexOutOfBoundsException(sbM833U2.toString()), null, 4, null);
                } else {
                    string = C12106w.replaceRange(string, intRange.getFirst(), intRange.getLast(), autocompletable.getInputReplacement()).toString();
                }
            }
        }
        return string;
    }
}
