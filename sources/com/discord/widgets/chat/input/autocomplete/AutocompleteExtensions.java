package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.Map;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: AutocompleteExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteExtensions {
    public static final String replaceAutocompleteDataWithServerValues(String str, Map<Ranges2, ? extends Autocompletable> map) {
        Intrinsics3.checkNotNullParameter(str, "$this$replaceAutocompleteDataWithServerValues");
        Intrinsics3.checkNotNullParameter(map, "inputMentionsMap");
        String string = str;
        for (Ranges2 ranges2 : _Collections.sortedWith(map.keySet(), new Comparator() { // from class: com.discord.widgets.chat.input.autocomplete.AutocompleteExtensionsKt$replaceAutocompleteDataWithServerValues$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(((Ranges2) t2).getFirst()), Integer.valueOf(((Ranges2) t).getFirst()));
            }
        })) {
            Autocompletable autocompletable = map.get(ranges2);
            if (autocompletable != null) {
                if (ranges2.getFirst() > string.length() || ranges2.getLast() > string.length()) {
                    AppLog appLog = AppLog.g;
                    StringBuilder sbU = outline.U("Invalid mention position to insert ");
                    sbU.append(autocompletable.getInputReplacement());
                    sbU.append(' ');
                    sbU.append("into ");
                    sbU.append(string);
                    sbU.append(" at [");
                    sbU.append(ranges2.getFirst());
                    sbU.append(" - ");
                    sbU.append(ranges2.getLast());
                    sbU.append("]. Original input: ");
                    sbU.append(str);
                    String string2 = sbU.toString();
                    StringBuilder sbU2 = outline.U("first ");
                    sbU2.append(ranges2.getFirst());
                    sbU2.append(", last ");
                    sbU2.append(ranges2.getLast());
                    sbU2.append(", s.length() ");
                    sbU2.append(string.length());
                    Logger.e$default(appLog, string2, new IndexOutOfBoundsException(sbU2.toString()), null, 4, null);
                } else {
                    string = Strings4.replaceRange(string, ranges2.getFirst(), ranges2.getLast(), autocompletable.getInputReplacement()).toString();
                }
            }
        }
        return string;
    }
}
