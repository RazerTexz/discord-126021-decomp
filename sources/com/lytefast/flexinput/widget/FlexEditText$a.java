package com.lytefast.flexinput.widget;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlexEditText$a implements InputConnectionCompat$OnCommitContentListener {
    public final /* synthetic */ FlexEditText a;

    public FlexEditText$a(FlexEditText flexEditText, EditorInfo editorInfo) {
        this.a = flexEditText;
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfoCompat.requestPermission();
            } catch (Exception unused) {
                return false;
            }
        }
        Function1<InputContentInfoCompat, Unit> inputContentHandler = this.a.getInputContentHandler();
        m.checkNotNullExpressionValue(inputContentInfoCompat, "inputContentInfo");
        inputContentHandler.invoke(inputContentInfoCompat);
        return true;
    }
}
