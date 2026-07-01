package com.lytefast.flexinput.widget;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import b.b.a.i.FlexEditText2;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FlexEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FlexEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public Function1<? super InputContentInfoCompat, Unit> inputContentHandler;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Function2<? super Integer, ? super Integer, Unit> onSelectionChangedListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onMaxLinesChangedListener;

    /* JADX INFO: compiled from: FlexEditText.kt */
    public static final class a implements InputConnectionCompat.OnCommitContentListener {
        public a(EditorInfo editorInfo) {
        }

        @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
        public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                } catch (Exception unused) {
                    return false;
                }
            }
            Function1<InputContentInfoCompat, Unit> inputContentHandler = FlexEditText.this.getInputContentHandler();
            Intrinsics3.checkNotNullExpressionValue(inputContentInfoCompat, "inputContentInfo");
            inputContentHandler.invoke(inputContentInfoCompat);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.inputContentHandler = new FlexEditText2(this);
    }

    public final Function1<InputContentInfoCompat, Unit> getInputContentHandler() {
        return this.inputContentHandler;
    }

    public final Function1<Integer, Unit> getOnMaxLinesChangedListener() {
        return this.onMaxLinesChangedListener;
    }

    public final Function2<Integer, Integer, Unit> getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics3.checkNotNullParameter(editorInfo, "editorInfo");
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection == null) {
            return null;
        }
        EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/*"});
        return InputConnectionCompat.createWrapper(inputConnectionOnCreateInputConnection, editorInfo, new a(editorInfo));
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int start, int end) {
        super.onSelectionChanged(start, end);
        Function2<? super Integer, ? super Integer, Unit> function2 = this.onSelectionChangedListener;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(start), Integer.valueOf(end));
        }
    }

    public final void setInputContentHandler(Function1<? super InputContentInfoCompat, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.inputContentHandler = function1;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
        Function1<? super Integer, Unit> function1 = this.onMaxLinesChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(maxLines));
        }
    }

    public final void setOnMaxLinesChangedListener(Function1<? super Integer, Unit> function1) {
        this.onMaxLinesChangedListener = function1;
    }

    public final void setOnSelectionChangedListener(Function2<? super Integer, ? super Integer, Unit> function2) {
        this.onSelectionChangedListener = function2;
    }
}
