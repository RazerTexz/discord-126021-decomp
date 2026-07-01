package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* JADX INFO: compiled from: TextWatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TextWatcher implements android.text.TextWatcher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<Editable, Unit> onAfterTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onBeforeTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onTextChanged;

    /* JADX INFO: compiled from: TextWatcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> onAfterTextChanged) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(textView, "textView");
            Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
            TextWatcher4.addBindedTextWatcher(textView, fragment, new TextWatcher3(onAfterTextChanged));
        }

        public final void reset(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            HashMap map = (HashMap) TextWatcher4.bindedTextWatchers.get(fragment);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    TextView textView = (TextView) entry.getKey();
                    Iterator it = ((ArrayList) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        textView.removeTextChangedListener((android.text.TextWatcher) it.next());
                    }
                }
            }
            TextWatcher4.bindedTextWatchers.remove(fragment);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TextWatcher() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextWatcher(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function5, Function1<? super Editable, Unit> function1) {
        this.onBeforeTextChanged = function4;
        this.onTextChanged = function5;
        this.onAfterTextChanged = function1;
    }

    public static final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> action1) {
        INSTANCE.addBindedTextWatcher(fragment, textView, action1);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function1<Editable, Unit> function1 = this.onAfterTextChanged;
        if (function1 != null) {
            function1.invoke(s2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onBeforeTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public /* synthetic */ TextWatcher(Function4 function4, Function4 function5, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function4, (i & 2) != 0 ? null : function5, (i & 4) != 0 ? null : function1);
    }
}
