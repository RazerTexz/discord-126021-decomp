package com.discord.utilities.view.text;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextWatcher$Companion {
    private TextWatcher$Companion() {
    }

    public final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> onAfterTextChanged) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(textView, "textView");
        m.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextWatcherKt.addBindedTextWatcher(textView, fragment, new TextWatcher$Companion$addBindedTextWatcher$1(onAfterTextChanged));
    }

    public final void reset(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        HashMap map = (HashMap) TextWatcherKt.access$getBindedTextWatchers$p().get(fragment);
        if (map != null) {
            for (Map$Entry map$Entry : map.entrySet()) {
                TextView textView = (TextView) map$Entry.getKey();
                Iterator it = ((ArrayList) map$Entry.getValue()).iterator();
                while (it.hasNext()) {
                    textView.removeTextChangedListener((android.text.TextWatcher) it.next());
                }
            }
        }
        TextWatcherKt.access$getBindedTextWatchers$p().remove(fragment);
    }

    public /* synthetic */ TextWatcher$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
