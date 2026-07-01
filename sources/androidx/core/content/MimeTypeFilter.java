package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static boolean matches(@Nullable String str, @NonNull String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), str2.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), strArrSplit)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }

    @Nullable
    public static String matches(@Nullable String str, @NonNull String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(strArrSplit, str2.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN))) {
                return str2;
            }
        }
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return null;
        }
        String[] strArrSplit = str.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), strArrSplit)) {
                return str2;
            }
        }
        return null;
    }
}
