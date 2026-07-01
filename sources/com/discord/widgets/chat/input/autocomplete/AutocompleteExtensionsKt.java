package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AutocompleteExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteExtensionsKt {
    public static final String replaceAutocompleteDataWithServerValues(String str, Map<IntRange, ? extends Autocompletable> map) {
        m.checkNotNullParameter(str, "$this$replaceAutocompleteDataWithServerValues");
        m.checkNotNullParameter(map, "inputMentionsMap");
        String string = str;
        for (IntRange intRange : u.sortedWith(map.keySet(), new AutocompleteExtensionsKt$replaceAutocompleteDataWithServerValues$$inlined$sortedByDescending$1())) {
            Autocompletable autocompletable = map.get(intRange);
            if (autocompletable != null) {
                if (intRange.getFirst() > string.length() || intRange.getLast() > string.length()) {
                    AppLog appLog = AppLog.g;
                    StringBuilder sbU = a.U("Invalid mention position to insert ");
                    sbU.append(autocompletable.getInputReplacement());
                    sbU.append(' ');
                    sbU.append("into ");
                    sbU.append(string);
                    sbU.append(" at [");
                    sbU.append(intRange.getFirst());
                    sbU.append(" - ");
                    sbU.append(intRange.getLast());
                    sbU.append("]. Original input: ");
                    sbU.append(str);
                    String string2 = sbU.toString();
                    StringBuilder sbU2 = a.U("first ");
                    sbU2.append(intRange.getFirst());
                    sbU2.append(", last ");
                    sbU2.append(intRange.getLast());
                    sbU2.append(", s.length() ");
                    sbU2.append(string.length());
                    Logger.e$default(appLog, string2, new IndexOutOfBoundsException(sbU2.toString()), null, 4, null);
                } else {
                    string = w.replaceRange(string, intRange.getFirst(), intRange.getLast(), autocompletable.getInputReplacement()).toString();
                }
            }
        }
        return string;
    }
}
